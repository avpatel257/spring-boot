package com.demo.ms.order;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;

@Configuration
public class ApplicationConfig {
    @Named
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("com.demo.ms.order.rest");
        }
    }
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
