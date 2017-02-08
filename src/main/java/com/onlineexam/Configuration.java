package com.onlineexam;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
public class Configuration {

	
	public WebMvcConfigurer corsConfiguerer(){
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				String[] header = {"Accept:true","Accept-Charset:utf8","Access-Control-Allow-Origin:http://localhost:8080"};
				registry.addMapping("/hero").allowedOrigins("http://localhost:8080")
				.allowedHeaders(header).maxAge(3000);
				registry.addMapping("/compile").allowedOrigins("http://localhost:8080").allowedHeaders(header).maxAge(3000);
				
			}
		};
	}
	
	
	

}
