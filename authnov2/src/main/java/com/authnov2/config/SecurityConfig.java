package com.authnov2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //Here we can configure which url is open and which is close
    //Here we can configure role based access

    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http.authorizeHttpRequests(
         req -> {
             req.requestMatchers("/api/v1/welcome/hello").permitAll().
                     anyRequest().authenticated();
         }
       );
       return http.build();
   }
}
