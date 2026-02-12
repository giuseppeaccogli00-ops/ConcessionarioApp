package com.example.bff.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("cookieAuth",//id logico che identifica questo schema
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.APIKEY)//il token è una API key
                                        .in(SecurityScheme.In.COOKIE)//questa API key viene messa nei cookie HTTP
                                        .name("bezkoder")
                        )
                )
                .addSecurityItem(
                        new SecurityRequirement().addList("cookieAuth")
                );
    }
}

