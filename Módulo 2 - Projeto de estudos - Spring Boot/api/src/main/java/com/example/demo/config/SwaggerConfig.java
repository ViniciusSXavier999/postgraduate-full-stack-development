package com.example.demo.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	/* VERSÃO ATUALIZADA SPRING BOOT 3+ */

	/*
	 * @Bean public OpenAPI customOpenAPI() { return new OpenAPI() // 1 .info(new
	 * Info() // 2 .title("Minha API") // 3 .version("1.0") // 4
	 * .description("Documentação gerada pelo SpringDoc OpenAPI")); // 5 }
	 * 
	 * /*
	 * 
	 * /* VERSÃO ANTIGA
	 */
	/*
	 * @Bean public Docket api() { return new Docket(DocmentationType.SWAGGER_2)
	 * .select()
	 * .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
	 * .paths(PathSeelctors.any()) .build(); }
	 */

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(apiInfo())
				.components(securityComponents())
				.addSecurityItem(securityRequirement());
	}

	private Info apiInfo() {
	        return new Info()
	        .title("Minha API Rest FULL")
			.description("API REALIZADA DURANTE A PÓS GRADUAÇÃO EM DESENVOLVIMENTO FULL STACK PELA DESCOMPLICA")
			.version("1.0").termsOfService("Link_termos_uso")
			.contact(new Contact()
					.name("Vinicius")
					.url("https://github.com/ViniciusSXavier999")
					.email("seu@email.com"))
			.license(new License()
					.name("Licença da API")
					.url("https://www.link-da-licenca.com"));
	    }

	private Components securityComponents() {
		return new Components()
				.addSecuritySchemes("bearerAuth", 
						new SecurityScheme()
						.type(SecurityScheme.Type.HTTP)
				.scheme("bearer")
				.bearerFormat("JWT")
				.in(SecurityScheme.In.HEADER)
				.name("Authorization"));
	}

	private SecurityRequirement securityRequirement() {
		return new SecurityRequirement().addList("bearerAuth");
	}

	}



