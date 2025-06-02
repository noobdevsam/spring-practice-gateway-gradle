package com.example.spring_practice_gateway_gradle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain secFilterChain(ServerHttpSecurity http) {

        return http
                .authorizeExchange(
                        exchange -> exchange.anyExchange().authenticated()
                )
                .oauth2ResourceServer(
                        resourceServer -> resourceServer.jwt(Customizer.withDefaults())
                )
                .csrf(
                        ServerHttpSecurity.CsrfSpec::disable
                )
                .build();
    }
}