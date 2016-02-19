package com.demo.ms.customer;

import com.demo.ms.customer.rest.CustomerResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
    @Named
    @ApplicationPath("/v1")
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("com.demo.ms.customer.rest");
        }
    }
//
//    @Bean
//    public Docket documentation() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("CustomerAPI")
//                .apiInfo(apiInfo())
//                .select()
//                .paths(regex("/api/customer.*"))
//                .build()
//                .enableUrlTemplating(true);
//    }
//
//    @Bean
//    public UiConfiguration uiConfig() {
//        return UiConfiguration.DEFAULT;
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("My awesome API")
//                .description("Some description")
//                .version("1.0")
//                .contact("my-email@domain.org")
//                .build();
//    }
}
