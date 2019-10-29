package com.tecky.communicate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class WebConfig {

    /**
     * Swagger API_VERSION.
     */
    private static final String API_VERSION = "1.0.0";

    /**
     * Springfox implementation of Swagger 2.
     *
     * @return {@link Docket}
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(s -> s.startsWith("/api"))
                .build()
                .tags(new Tag("Expression API", "API pour des opérations de CRUD sur les expressions."))
                .apiInfo(metaData());
    }

    /**
     * Adds information to API documentation.
     * With Spring Boot, this configuration is enough to integrate Swagger 2.
     */
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("API REST Communicate")
                .description("Centralisation des nouvelles expressions.")
                .version(API_VERSION)
                .license("Open Source software")
                .contact(new Contact("mkeysersoze", "", "malek.majouli@gmail.com"))
                .build();
    }
}