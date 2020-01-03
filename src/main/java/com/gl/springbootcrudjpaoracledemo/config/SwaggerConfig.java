package com.gl.springbootcrudjpaoracledemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gl.springbootcrudjpaoracledemo"))
                .paths(regex("/users"))
                .build()
                .apiInfo(metaInfo());
    }

    List<VendorExtension> vendorExtension = new ArrayList<>();

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot CRUD JPA with Oracle Api",
                "Spring Boot CRUD JPA with Oracle",
                "1.o",
                "Terms of service",
                 new Contact("GlobalLogic","https://www.globallogic.com/gl/springbootcrudjpaoracledemo","thaneshwar.sahu@globallogic.com"),
                "Apache Licence Version 2.0",
                "https://www.apache.org/license.html",
                vendorExtension
        );
        return apiInfo;
    }



}
