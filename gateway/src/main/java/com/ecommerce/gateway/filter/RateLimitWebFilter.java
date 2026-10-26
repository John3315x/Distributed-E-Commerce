package com.ecommerce.gateway.filter;

import com.ecommerce.gateway.service.RateLimiterService;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * 🚩
 * RateLimitWebFilter:
 *
 * Este filtro se ejecuta antes de la cadena de seguridad de Spring Security.
 * Se utiliza para aplicar el Rate Limiting mediante Redis antes de que la
 * petición pueda ser rechazada por autenticación o autorización.
 *
 * De esta forma, Redis contabiliza todas las peticiones que llegan al Gateway,
 * independientemente de su resultado posterior:
 *
 * - JWT ausente
 * - JWT inválido
 * - JWT válido pero sin permisos suficientes (403)
 * - Ruta inexistente (404)
 * - Petición autorizada
 *
 * Si el límite es superado, la petición se rechaza inmediatamente con
 * HTTP 429 Too Many Requests y no continúa hacia Spring Security.
 *
 * Se utiliza WebFilter en lugar de GlobalFilter porque GlobalFilter pertenece
 * a la cadena de filtros propia de Spring Cloud Gateway y, en este caso,
 * necesitamos que el Rate Limiter se ejecute antes del procesamiento de
 * seguridad de Spring WebFlux.
 */

@Component
public class RateLimitWebFilter implements WebFilter, Ordered {

    private final RateLimiterService rateLimiterService;

    public RateLimitWebFilter(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService;
    }

    @Override
    public int getOrder() {
        return -200;
    }

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            WebFilterChain chain) {

        String ip = Optional.ofNullable(
                        exchange.getRequest()
                                .getHeaders()
                                .getFirst("X-Forwarded-For")
                )
                .map(header -> header.split(",")[0])
                .orElseGet(() ->
                        Optional.ofNullable(
                                        exchange.getRequest().getRemoteAddress()
                                )
                                .map(addr ->
                                        addr.getAddress().getHostAddress()
                                )
                                .orElse("unknown")
                );

        String path = exchange.getRequest().getURI().getPath();

        //System.out.println("RateLimitWebFilter -> IP: " + ip + ", Path: " + path);

        String key = "gateway:rate_limit:" + ip + ":" + path;

        boolean allowed = rateLimiterService.isAllowed(key, 5, 600);

        if (!allowed) {

            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);

            exchange.getResponse().getHeaders().add("Content-Type", "application/json");

            String body = "{\"error\":\"Too many requests\",\"status\":429}";

            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));

            return exchange.getResponse().writeWith(Mono.just(buffer));
        }

        return chain.filter(exchange);
    }
}
