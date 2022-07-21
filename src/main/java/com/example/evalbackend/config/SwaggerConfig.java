package com.example.evalbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    @Primary
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return () -> {
            SwaggerResource swResource = new SwaggerResource();
            swResource.setName("Documentation");
            swResource.setSwaggerVersion("2.0");
            swResource.setLocation("/swagger.yaml");

            List<SwaggerResource> resources = List.of(swResource);
            return resources;
        };
    }
}
