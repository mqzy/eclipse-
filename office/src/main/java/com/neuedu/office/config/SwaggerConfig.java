package com.neuedu.office.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootConfiguration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${swagger.enabled}")
	private boolean enable;
	@Value("${swagger.title}")
	private String title;
	
	
	private static final String SWAGGER_SCAN_BASE_PACKAGE="com.neuedu.office.controller";
	private static final String VERSION = "1.0.0";
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(this.enable)
				.apiInfo(createApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo createApiInfo() {
		System.out.println(enable+title);
		return new ApiInfoBuilder()
				.title(this.title)
				.description("SpringBoot项目使用swagger构建Restfull")
				.termsOfServiceUrl("http://localhost:8080")
				.contact(new Contact("组长","http://localhost:8080","admin@admin.com"))
				.version(VERSION)
				.build();
	}
}
