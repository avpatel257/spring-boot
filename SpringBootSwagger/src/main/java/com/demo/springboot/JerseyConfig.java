package com.demo.springboot;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jersey.listing.ApiListingResourceJSON;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/v1")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
        configureSwagger();
    }
    private void configureSwagger() {
        register(ApiListingResource.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        //beanConfig.setSchemes(new String[]{"http"});
        //beanConfig.setHost("localhost:8080");
        //beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("com.demo.springboot");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }
    private void registerEndpoints() {
        register(WadlResource.class);
        register(HelloWorldEndpoint.class);
        register( ApiListingResourceJSON.class );
    }
}
