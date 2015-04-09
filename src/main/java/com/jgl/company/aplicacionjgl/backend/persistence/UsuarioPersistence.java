/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.persistence;

import com.jgl.company.aplicacionjgl.backend.DTO.LoginDTO;
import com.jgl.company.aplicacionjgl.backend.entity.UsuarioEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
    
    
    public Response login(LoginDTO login) throws NonUniqueResultException  { //Excepción que garantiza un solo resultado
        String statusStr = "usuario autenticado";
        entityManager = emf.createEntityManager();
        UsuarioEntity user = null;
        try{
            entityManager.getTransaction().begin();
            Query q = entityManager.createQuery("select u from UsuarioEntity u where u.userName=:usern AND u.pass=:pass",UsuarioEntity.class); //debe ser u.userName con cast al final del query
            q.setParameter("usern", login.getUserName()).setParameter("pass", login.getPass());
            user = (UsuarioEntity) q.getSingleResult();
            entityManager.getTransaction().commit();
            return Response.status(200).entity(statusStr).build();
        }catch(NoResultException e){
            entityManager.close();
            statusStr = "usuario no autenticado";
            return Response.status(200).entity(statusStr).build(); 
        }    
            
            
        
        
    }

}
