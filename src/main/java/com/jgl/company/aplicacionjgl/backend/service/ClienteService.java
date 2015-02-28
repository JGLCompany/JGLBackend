/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.service;

import com.jgl.company.aplicacionjgl.backend.DTO.ClienteDTO;
import com.jgl.company.aplicacionjgl.backend.entity.ClienteEntity;
import com.jgl.company.aplicacionjgl.backend.persistence.ClientePersistence;
import com.jgl.company.aplicacionjgl.backend.persistence.ProductosPersistence;
import java.util.ArrayList;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jhonatan
 */
@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteService {

    
    private ClientePersistence clientesPersistence;
    @PostConstruct
	public void loadDependencies(){
		clientesPersistence = new ClientePersistence();
	}
    @GET
    public List<ClienteEntity> getClientes() {
        return clientesPersistence.getClientes(); 
    }

    @Path("{id}")
    @GET
    public ClienteEntity getCliente(@PathParam("id") long id) {
        return clientesPersistence.getCliente(id);
    }
    
    @POST
    public void setCliente(ClienteEntity cliente){
        clientesPersistence.setCliente(cliente);
    }
    
    @Path("{id}")
    @PUT
    public void setClienteUpdate(ClienteEntity cliente){
        clientesPersistence.setClienteUpdate(cliente);
    }
    @Path("{id}")
    @DELETE
    public void deleteCliente(@PathParam("id") long id){
        clientesPersistence.deleteCliente(id);
    }
    
    

}
