package com.demo.ms.product;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.inject.Named;

@Configuration
public class ApplicationConfig {
    @Named
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("com.demo.ms.product.rest");
        }
    }
}
