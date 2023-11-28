package com.example.nguyengiahy20008341labweektuan2.resources;

import com.example.nguyengiahy20008341labweektuan2.models.Order;
import com.example.nguyengiahy20008341labweektuan2.services.OrderService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Path("/orders")
public class OrderResource {
    private final OrderService orderService;
    public OrderResource() {
        orderService = new OrderService();
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        //paging if possible
        List<Order> lst = orderService.getAllOrder();
        return Response.ok(lst).build();
    }
    @GET
    @Produces("application/json")
    @Path("/searchbydate")
    public Response getOrdersByDate(@QueryParam("date") Date date){
        List<Order> orders = orderService.getOrderByDate(date);
        if (orders!=null) {
            return Response.ok(orders).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces("application/json")
    @Path("/searchOrderByDate")
    public Response getOrdersByPeriod(@QueryParam("fromdate") Date fromDate,@QueryParam("todate") Date toDate){
        List<Order> orders = orderService.getAllOrderToDateFrom(fromDate,toDate);
        if (orders!=null) {
            return Response.ok(orders).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Order order) {
        //ResponseEntity
        boolean b = orderService.insertOrder(order);
        if (b){
            return Response.ok(order).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(Order order) {
        //ResponseEntity
        boolean b = orderService.updateOrder(order);
        if (b){
            return Response.ok(order).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getOrder(@PathParam("id") long id) {
        Optional<Order> orderOpt = orderService.getOrderById(id);
        if (orderOpt.isPresent()) {
            return Response.ok(orderOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
