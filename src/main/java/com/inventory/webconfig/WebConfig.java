package com.inventory.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  
                .allowedOrigins("*")  //allowedOrigins("http://localhost:3000")
                .allowedMethods("POST", "PUT", "GET",  "DELETE", "OPTIONS") 
                .allowedHeaders("Content-Type", "Origin")
                .exposedHeaders("X-Total-Count", "Location", "Access-Control-Allow-Origin")  
                .allowCredentials(false)
                .maxAge(6000);
    }
}