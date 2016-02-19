package com.demo.ms.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("CustomerAPI")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build()
                .enableUrlTemplating(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("My awesome API")
                .description("Here is some description")
                .version("1.0")
                .contact("Amit Patel")
                .build();
    }
}
