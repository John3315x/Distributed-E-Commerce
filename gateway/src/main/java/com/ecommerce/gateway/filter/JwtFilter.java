package com.ecommerce.gateway.filter;

import com.ecommerce.gateway.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Collections;

/**
 * 🚩
 * QUEDAMOS AQUI: AHORA NO SE VA A TRABAJAR CON EL LOCALSTORAGE SINO CON UNA COOKIE
 * Se debe obtener la cookie del navegador que contiene el jwt
 */
public class JwtFilter implements WebFilter{

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        //System.out.println("ENTRA AL FILTRO");

        String path = exchange.getRequest().getURI().getPath();

        System.out.println("JWT Filter -> " + path);

        // LA RUTA SUPPORT ES SOLO PARA ENTORNO DE DESARROLLO
        // 🔓 Rutas públicas
        if (path.startsWith("/api/auth")){
            return chain.filter(exchange);
        }

        //System.out.println("REQUIERE JWT");

        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        //System.out.println("Authorization Header: " + authHeader);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            try {
                // Valida token y obtiene claims
                String email = jwtUtil.getSubject(token);
                String role = jwtUtil.getRole(token);

                //System.out.println("AQUI: " + email + " | " + role);

                // Crear roles
                var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));

                // Crear Authentication
                var auth = new UsernamePasswordAuthenticationToken(email, null, authorities);

                // Importante en WebFlux: Meterlo en el contexto de seguridad reactivo
                return chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth));

            } catch (Exception e) {
                return unauthorized(exchange);
            }
        }

        return unauthorized(exchange);
    }

    // Corta la ejecución
    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }
}
