/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.persistence;

import com.jgl.company.aplicacionjgl.backend.DTO.LoginDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jhonatan
 */
public class UsuarioPersistence {

    protected EntityManagerFactory emf;
    protected EntityManager entityManager;

    public UsuarioPersistence() {
        emf = Persistence.createEntityManagerFactory("AplicacionJGL");
    }
    
    
    public Response login(LoginDTO login) {
        int status = 500;
        entityManager = emf.createEntityManager();
        LoginDTO user = null;
        try {
            entityManager.getTransaction().begin();
            Query q = entityManager.createQuery("select u from UsuarioEntity where u.user=:user AND u.pass=:pass");
            q.setParameter("user", login.getUserName());
            q.setParameter("pass", login.getPass());
            user = new LoginDTO();
            user = (LoginDTO) q.getSingleResult();
            entityManager.getTransaction().commit();
            status = 200;
        } catch (Exception e) {
            entityManager.close();
        }
        
        return Response.status(status).entity("usuario authenticado").build();
    }

}
