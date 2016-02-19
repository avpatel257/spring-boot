package com.demo.ms.customer.rest;

import com.demo.ms.customer.domain.Customer;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Named
@Path("/customer")
public class CustomerResource {
    private static List<Customer> clients = new ArrayList<Customer>();

    static {

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Cliente 1");
        customer1.setEmail("customer1@gmail.com");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Cliente 2");
        customer2.setEmail("customer2@gmail.com");

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setName("Cliente 3");
        customer3.setEmail("customer3@gmail.com");

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setName("Cliente 4");
        customer4.setEmail("customer4@gmail.com");

        Customer customer5 = new Customer();
        customer5.setId(5);
        customer5.setName("Cliente 5");
        customer5.setEmail("customer5@gmail.com");

        clients.add(customer1);
        clients.add(customer2);
        clients.add(customer3);
        clients.add(customer4);
        clients.add(customer5);

    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "GetAllCustomers", nickname = "GetAllCustomers")
    public List<Customer> getClientes() {
        return clients;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "GetCustomerById", nickname = "GetCustomerById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Customer's Id", required = true, dataType = "int", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Customer.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Customer getCliente(@PathParam("id") long id) {
        Customer cli = null;
        for (Customer c : clients) {
            if (c.getId() == id)
                cli = c;
        }
        return cli;
    }

}