package com.example.nguyengiahy20008341labweektuan2.resources;

import com.example.nguyengiahy20008341labweektuan2.models.Customer;
import com.example.nguyengiahy20008341labweektuan2.models.KindOfUser;
import com.example.nguyengiahy20008341labweektuan2.models.Order;
import com.example.nguyengiahy20008341labweektuan2.models.User;
import com.example.nguyengiahy20008341labweektuan2.services.CustomerService;
import com.example.nguyengiahy20008341labweektuan2.services.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import jakarta.json.JsonException;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import java.util.Optional;
import java.util.jar.JarException;

@Path("/customers")

public class CustomerResource {
    private  final CustomerService customerService;
    private  final UserService userService;


    public  CustomerResource(){

        this.customerService = new CustomerService();
        this.userService = new UserService();
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        try {
            List<Customer> customer = customerService.getAllCustomer();
            return Response.ok(customer).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Object object) throws JSONException {
        //ResponseEntity
        JSONObject jsonObject = new JSONObject(object.toString());

        String usernameuser = jsonObject.getString("username");
        String passwords = jsonObject.getString("password");
        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");
        String phone = "0"+jsonObject.getString("phone");
        String address = jsonObject.getString("address");

        User user = new User(usernameuser, passwords, KindOfUser.CUSTOMER);
        Customer customer = new Customer(name, email, phone, address, user);

        boolean isInsertUser = userService.insertUser(user);
        if (isInsertUser){
            boolean isInsertCustomer = customerService.insertCustomer(customer);
            if (isInsertCustomer){
                return Response.ok(customer).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/login")
    public Response login(@QueryParam("username") String username,@QueryParam("password") String password){
        Customer customer=customerService.getCustomerByNameAndPassword(username,password);
        if(customer!=null){
            return Response.ok(customer).build();
        }
        return  Response.status(Response.Status.NOT_FOUND).build();
    }


    @GET
    @Produces("application/json")
    @Path("/orders/{id}")
    public Response getOrdersByCustomerID(@PathParam("id") long custID) {
        List<Order> orders = customerService.getCustByOrer(custID);
        if (orders!=null) {
            return Response.ok(orders).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") long id) {
        Optional<Customer> cusOpt = customerService.getCustomerById(id);
        if (cusOpt.isPresent()) {
            return Response.ok(cusOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
