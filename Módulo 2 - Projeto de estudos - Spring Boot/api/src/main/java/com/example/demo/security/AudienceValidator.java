package com.example.demo.security;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;


// CLASSE RESPONSÁVEL PELA VALIDAÇÃO DO IDENTIFICADOR UNICO DO AUTH0

public class AudienceValidator implements OAuth2TokenValidator<Jwt> {

	private final String audience;

	public AudienceValidator(String audience) {
		this.audience = audience;
	}

	public OAuth2TokenValidatorResult validate(Jwt jwt) {
		if (jwt.getAudience().contains(audience)) {
			return OAuth2TokenValidatorResult.success();
		}
		return OAuth2TokenValidatorResult
				.failure(new OAuth2Error("invalid_token", "Token não tem audience válida", null));
	}

}
