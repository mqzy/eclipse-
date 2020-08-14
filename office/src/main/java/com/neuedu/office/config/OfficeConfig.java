package com.neuedu.office.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.neuedu.office.converter.MyDateConverter;

@SpringBootConfiguration
public class OfficeConfig extends WebMvcConfigurationSupport {
	@Autowired
	private MyDateConverter myDateConverter;

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
	
	

}
