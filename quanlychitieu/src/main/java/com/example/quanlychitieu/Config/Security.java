package com.example.quanlychitieu.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())    // Tắt CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()   // Cho phép tất cả API
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
