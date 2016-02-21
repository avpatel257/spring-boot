package com.demo.springboot;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class HelloWorldEndpoint {
    @GET
    @Path("/world")
    @ApiOperation(value = "GetCustomerById", nickname = "GetCustomerById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Customer's Id", required = true, dataType = "int", paramType = "path")
    })
    public String test() {
        return "Hello world!";
    }
}