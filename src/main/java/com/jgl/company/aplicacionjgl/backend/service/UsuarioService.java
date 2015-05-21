/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.service;

import com.jgl.company.aplicacionjgl.backend.DTO.UsuarioDTO;
import com.jgl.company.aplicacionjgl.backend.entity.UsuarioEntity;
import com.jgl.company.aplicacionjgl.backend.persistence.ProductosPersistence;
import com.jgl.company.aplicacionjgl.backend.persistence.UsuarioPersistence;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jj.alarcon10
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {

    protected UsuarioPersistence usuarioPersistence;

    @PostConstruct
    public void loadDependencies() {
        usuarioPersistence = new UsuarioPersistence();
    }

    @POST
    public Response createUser(UsuarioDTO user) {
        return usuarioPersistence.createUser(user);
    }

}
