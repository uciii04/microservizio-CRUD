package com.example.GestioneCatalogo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.GestioneCatalogo.security.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .userDetailsService(customUserDetailsService)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()

                // accesso catalogo
                .requestMatchers("/prezzi/vincente/**").permitAll()

                // admin
                .requestMatchers("/prezzi/**").hasRole("ADMIN")
                .requestMatchers("/price-list/**").hasRole("ADMIN")
                .requestMatchers("/products/**").hasRole("ADMIN")
                .requestMatchers("/categories/**").hasRole("ADMIN")
                .requestMatchers("/attributes/**").hasRole("ADMIN")

                // cliente
                .requestMatchers("/catalogo/**").hasAnyRole("CLIENTE", "ADMIN")

                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}