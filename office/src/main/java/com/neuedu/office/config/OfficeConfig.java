package com.neuedu.office.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.neuedu.office.converter.MyDateConverter;
import com.neuedu.office.intercepter.LoginIntercepter;

@SpringBootConfiguration
public class OfficeConfig extends WebMvcConfigurationSupport {
	@Autowired
	private MyDateConverter myDateConverter;
	@Autowired
	private LoginIntercepter loginIntercepter;
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginIntercepter)
		.addPathPatterns("/**")
		.excludePathPatterns("/webjars/**",
				"/login","/checklogin","/exit",
				"/druid/**",
				"/swagger-ui.html/**","/v2/**","/swagger-resources/**");
		super.addInterceptors(registry);
	}

	@Bean
	public FormContentFilter httpPutFormContentFilter() {
		return new FormContentFilter();
	}
	
	@Override
	protected void addFormatters(FormatterRegistry registry) {
		registry.addConverter(myDateConverter);
		super.addFormatters(registry);
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
		.addResourceLocations("classpath:/META-INF/resources/")
		.addResourceLocations("classpath:/public/")
		.addResourceLocations("classpath:/static/")
		.addResourceLocations("classpath:/templates/");
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("/webjars/")
		.resourceChain(false);
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowCredentials(true)
			.allowedMethods("GET","POST","DELETE","PATCH","OPTIONS","HEAD","PUT").maxAge(3600*48);
		super.addCorsMappings(registry);
	}
	
	

}
