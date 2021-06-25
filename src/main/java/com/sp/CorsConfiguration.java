package com.sp;

 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

 

@Configuration
public class CorsConfiguration {

 

//This can be used in combination with @CrossOrigin on the controller & method.

 

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	System.out.println("adding cors ");
                registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET","POST","PUT","DELETE","PATCH").
                allowedHeaders("Authorization","Content-Type","Access-Control-Allow-Credentials","Access-Control-Allow-Origin","Access-Control-Allow-Headers","Access-Control-Request-Headers").allowCredentials(true);
            }
        };
    }
}