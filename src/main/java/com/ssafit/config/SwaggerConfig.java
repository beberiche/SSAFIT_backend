package com.ssafit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				// ApiSelectorBuilder
				.select()
				// ApiSelectorBuilder
				.apis(RequestHandlerSelectors.basePackage("com.ssafit.controller"))
				// ApiSelectorBuilder
				.paths(PathSelectors.ant("/api/**"))
				// Docket
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//  ApiInfoBuilder
				.title("SSAFY Swagger")
				.description("대전 4반 8팀  SSAFIT 최종 프로젝트 ")
				.version("v1")
				.build();
	}
}










