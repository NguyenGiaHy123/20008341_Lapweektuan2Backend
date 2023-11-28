package com.example.nguyengiahy20008341labweektuan2.resources;

import com.example.nguyengiahy20008341labweektuan2.models.Product;
import com.example.nguyengiahy20008341labweektuan2.services.ProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/products")
public class ProductResource {
    private final ProductService productService;

    public ProductResource() {
        productService = new ProductService();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Product> products = productService.getAllProduct();
        return Response.ok(products).build();
    }


    @GET
    @Produces("application/json")
    @Path("/getProductByPriceNewst")
    public Response getProductByPriceNewst(){
        List<Product> products = productService.getProductByPriceNewst();
        return Response.ok(products).build();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getProduct(@PathParam("id") long id) {
        Optional<Product> proOpt = productService.findByID(id);
        if (proOpt.isPresent()) {
            return Response.ok(proOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Path("/search")
    public Response getProductByKeyWord(@QueryParam("keyword") String keyword){
        List<Product> products = productService.getGetProductsByKeyword(keyword);
        return Response.ok(products).build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (productService.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product product) {
        //ResponseEntity
        boolean b = productService.insert(product);
        if (b){
            return Response.ok(product).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(Product product) {
        //ResponseEntity
        boolean b = productService.updateProduct(product);
        if (b){
            return Response.ok(product).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
