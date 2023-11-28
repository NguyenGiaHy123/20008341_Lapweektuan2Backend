package com.example.nguyengiahy20008341labweektuan2.resources;

import com.example.nguyengiahy20008341labweektuan2.models.Employee;
import com.example.nguyengiahy20008341labweektuan2.services.EmployeeService;
import com.example.nguyengiahy20008341labweektuan2.services.impl.EmployeeServiceimpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employees")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource() {
        employeeService = new EmployeeServiceimpl();
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        try {
            List<Employee> employees = employeeService.getAll();
            return Response.ok(employees).status(200).build();
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
    @Path("/update")
    public Response update(Employee employee) {
        //ResponseEntity
        boolean b = employeeService.update(employee);
        if (b){
            return Response.ok(employee).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (employeeService.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces("application/json")
    @Path("/login")
    public Response getEmployeeByUsernameAndPassword(@QueryParam("username") String username,@QueryParam("password") String password) {
        Employee employee = (Employee) employeeService.getEmployeeByUsernameAndPassword(username, password);
        if (employee!=null) {
            return Response.ok(employee).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
