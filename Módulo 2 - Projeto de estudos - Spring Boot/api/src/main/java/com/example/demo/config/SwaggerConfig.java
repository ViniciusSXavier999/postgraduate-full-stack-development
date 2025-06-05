package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class SwaggerConfig {
	
	
	/* VERSÃO ATUALIZADA SPRING BOOT 3+*/
	
	/*
	@Bean
	public OpenAPI customOpenAPI() {
	    return new OpenAPI()                                      // 1
	        .info(new Info()                                      // 2
	            .title("Minha API")                               // 3
	            .version("1.0")                                   // 4
	            .description("Documentação gerada pelo SpringDoc OpenAPI")); // 5
	}

	/*
	
	/* VERSÃO ANTIGA  */
	/*
	@Bean
	public Docket api() {
		return new Docket(DocmentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSeelctors.any())
				.build();
	}
*/
}
