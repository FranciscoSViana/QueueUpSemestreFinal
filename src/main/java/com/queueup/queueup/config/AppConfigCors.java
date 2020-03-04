package com.queueup.queueup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfigCors implements WebMvcConfigurer {

	public void addCorsMapping(CorsRegistry reg) {
		reg.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "PUT", "DELETE", "POST", "OPTIONS", "HEAD",
				"TRACE", "CONNECT");
	}
}
