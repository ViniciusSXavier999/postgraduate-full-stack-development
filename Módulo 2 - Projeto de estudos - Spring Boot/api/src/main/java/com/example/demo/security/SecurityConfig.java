package com.example.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .securityMatcher("/**") // escopo da segurança
	        .csrf(csrf -> csrf.disable()) // só configura CSRF
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/arquivos/upload").permitAll()
	            .anyRequest().authenticated()
	        )
	        .cors(Customizer.withDefaults()) // ou .cors(cors -> ...)
	        .httpBasic(Customizer.withDefaults()); // ou .httpBasic(httpBasic -> ...)

	    return http.build();
	}

}
