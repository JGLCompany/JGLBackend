/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.service;

import com.jgl.company.aplicacionjgl.backend.DTO.PedidoDTO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jhonatan
 */
@Path("/pedidos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidoService {
    @GET
    public List<PedidoDTO> getPedidos() {
        return null;
    }

    @Path("{id}")
    @GET
    public PedidoDTO getPedido(@PathParam("id") long id) {
        return null;
    }
    
    @POST
    public void setPedido(PedidoDTO pedido){
    
    }
    
    @PUT
    public void setPedidoUpdate(@PathParam("id") long id){
    
    }
    
    @DELETE
    public void deletePedido(@PathParam("id") long id){
    
    }
    
}
