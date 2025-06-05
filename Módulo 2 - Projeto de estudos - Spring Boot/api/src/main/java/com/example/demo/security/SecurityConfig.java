package com.example.demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.oauth2.jwt.*;

import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Value("${auth0.audience}")
	private String audience;

	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	private String issuer;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/**") // escopo da segurança
				.csrf(csrf -> csrf.disable()) // só configura CSRF
				.authorizeHttpRequests(
						auth -> auth.requestMatchers(
								"/arquivos/upload",
								"/v3/api-docs/**",
			                    "/swagger-ui.html",
			                    "/swagger-ui/**",
			                    "/swagger-resources/**",
			                    "/swagger-resources",
			                    "/configuration/ui",
			                    "/configuration/security",
			                    "/api/hello",
			                    "/webjars/**"
								).permitAll().anyRequest().authenticated())
				.cors(Customizer.withDefaults()) // ou .cors(cors -> ...)
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.decoder(jwtDecoder())) // ← Adicionamos suporte ao
																								// token JWT do Auth0

				);
		return http.build();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		NimbusJwtDecoder decoder = JwtDecoders.fromIssuerLocation(issuer);

		OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator (audience);
		OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
		OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

		decoder.setJwtValidator(withAudience);
		return decoder;
	}

}
