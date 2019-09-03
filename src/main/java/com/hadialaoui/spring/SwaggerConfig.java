package com.hadialaoui.spring;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Test", "hadialaoui.com", "info@hadialaoui.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("title", "description", "version", "termsOfServiceUrl", DEFAULT_CONTACT, "license", "license");
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}
}
