/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.service;

import com.jgl.company.aplicacionjgl.backend.DTO.ProductoDTO;
import com.jgl.company.aplicacionjgl.backend.DTO.ProductoPageDTO;
import com.jgl.company.aplicacionjgl.backend.entity.ProductoEntity;
import com.jgl.company.aplicacionjgl.backend.persistence.ProductosPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jhonatan
 */
@Path("/productos")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class ProductoService {
    
    
    private ProductosPersistence productosPersistence;
    @PostConstruct
	public void loadDependencies(){
		productosPersistence = new ProductosPersistence();
	}
    
    
//    @OPTIONS
//    public Response cors(@javax.ws.rs.core.Context HttpHeaders requestHeaders) {
//        return Response.status(200).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS").header("Access-Control-Allow-Headers", "AUTHORIZATION, content-type, accept, X_REST_USER").build();
//    }

        
        
    @GET
    public ProductoPageDTO getProductos(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return productosPersistence.getProductos(page,maxRecords);
    } 

    @Path("{id}")
    @GET
    public ProductoEntity getProducto(@PathParam("id") long id) {
        return productosPersistence.getProducto(id);
    }
    
    @POST
    public Response setProducto(ProductoEntity producto){
        return productosPersistence.setProducto(producto);
    }
    
    @PUT
    public Response setProductoUpdate(ProductoEntity producto){
        return productosPersistence.setProductoUpdate(producto);
    }
    
    @Path("{id}")
    @DELETE
    public Response deleteProducto(@PathParam("id") long id){
        return productosPersistence.deleteProducto(id);
    }
}
