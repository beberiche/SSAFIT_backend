package com.ssafit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafit.interceptor.JWTInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
		.allowedMethods("GET","POST","PUT","DELETE")
		.maxAge(6000);
		
	}
	
	
	
//	@Autowired
//	JWTInterceptor JWTinterceptor;
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(JWTinterceptor).addPathPatterns("/**").excludePathPatterns("/api/login");
//	}
}
