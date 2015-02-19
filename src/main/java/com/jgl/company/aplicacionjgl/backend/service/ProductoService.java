/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.service;

import com.jgl.company.aplicacionjgl.backend.DTO.ProductoDTO;
import com.jgl.company.aplicacionjgl.backend.persistence.ProductosPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Jhonatan
 */
@Path("/productos")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class ProductoService {
    
    
    protected ProductosPersistence productosPersistence;
    @PostConstruct
	public void loadDependencies(){
		productosPersistence = new ProductosPersistence();
	}
    
    
    
    @GET
    public List<ProductoDTO> getProductos() {
        return productosPersistence.getProductos();
    }

    @Path("{id}")
    @GET
    public ProductoDTO getProducto(@PathParam("id") long id) {
        return productosPersistence.getProducto(id);
    }
    
    @POST
    public void setProducto(ProductoDTO producto){
        productosPersistence.setProducto(producto);
    }
    
    @PUT
    public void setProductoUpdate(@PathParam("id") long id){
        productosPersistence.setProductoUpdate(id);
    }
    
    @DELETE
    public void deleteProducto(@PathParam("id") long id){
        productosPersistence.deleteProducto(id);
    }
}
