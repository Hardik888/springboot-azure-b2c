package com.alphasetu.backend.configs;

import com.azure.spring.cloud.autoconfigure.implementation.aadb2c.security.AadB2cOidcLoginConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration  {

    private final AadB2cOidcLoginConfigurer configurer;

    public WebSecurityConfiguration(AadB2cOidcLoginConfigurer configurer) {
        this.configurer = configurer;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .apply(configurer);
        return http.build();
    }
}
