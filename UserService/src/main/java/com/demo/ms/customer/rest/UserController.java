package com.demo.ms.customer.rest;

import com.demo.ms.customer.domain.Customer;
import com.demo.ms.customer.domain.User;
import com.demo.ms.customer.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;


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

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "GetUserById", nickname = "GetUserById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "User's Id", required = true, dataType = "int", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public User getCliente(@PathVariable long id) {
        return service.findByUserId(id);

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "Add user", nickname = "Add new User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity<User> add(@RequestBody User user) {
        return new ResponseEntity<User>(service.save(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update existing user", nickname = "Update existing user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity<User> udpate(@PathVariable("id") long id, @RequestBody User user) {
        return new ResponseEntity<User>(service.update(id, user), HttpStatus.OK);
    }

}