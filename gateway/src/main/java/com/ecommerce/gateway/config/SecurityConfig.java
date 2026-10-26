package com.ecommerce.gateway.config;

import com.ecommerce.gateway.filter.JwtFilter;
import com.ecommerce.gateway.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtFilter jwtFilter(JwtUtil jwtUtil) {
        return new JwtFilter(jwtUtil);
    }

    // Este Bean se encarga de configurar CORS para permitir solicitudes desde el frontend.
    /*
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        // Permitir solicitudes desde el frontend (por ejemplo, http://localhost:5173)
        configuration.setAllowedOrigins(
                List.of("http://localhost:5173")
        );

        configuration.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );

        configuration.setAllowedHeaders(
                List.of("*")
        );

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
    */


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(
            ServerHttpSecurity http,
            JwtFilter jwtFilter) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors(Customizer.withDefaults())
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)

                .authorizeExchange(exchange -> exchange

                        /**
                         * Permitir solicitudes OPTIONS para CORS
                         * Las solicitudes OPTIONS son preflight requests que el navegador envía antes de la solicitud
                         * real para verificar si el servidor permite la solicitud desde el origen del frontend.
                         * Por lo tanto, es importante permitir estas solicitudes para que CORS funcione correctamente.
                         */
                        //.pathMatchers(HttpMethod.OPTIONS).permitAll()

                        // 🔓 Rutas públicas
                        .pathMatchers("/api/auth/**").permitAll()


                        // 🔐 Rutas protegidas
                        .pathMatchers("/api/support/**").hasAnyRole("SUPPORT", "ADMIN", "AUDITOR")
                        .pathMatchers("/api/users/**").hasAnyRole("SUPPORT", "ADMIN", "AUDITOR")


                        // Todo lo demás requiere autenticación
                        .anyExchange().authenticated()
                )

                .addFilterAt(jwtFilter, SecurityWebFiltersOrder.AUTHENTICATION)

                .build();
    }
}
