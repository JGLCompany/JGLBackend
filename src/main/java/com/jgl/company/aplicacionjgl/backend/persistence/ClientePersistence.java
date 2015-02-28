/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.persistence;

import com.jgl.company.aplicacionjgl.backend.DTO.ClienteDTO;
import com.jgl.company.aplicacionjgl.backend.entity.ClienteEntity;
import com.jgl.company.aplicacionjgl.backend.entity.ClienteEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jj.alarcon10
 */
public class ClientePersistence {

    
    protected EntityManagerFactory emf;
    protected EntityManager entityManager;
    
    public ClientePersistence() {
        emf = Persistence.createEntityManagerFactory("AplicacionJGL");
    }
    
    public List<ClienteEntity> getClientes() {
       List<ClienteEntity> clientes = null;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query q = entityManager.createQuery("select u from ClienteEntity u");
            clientes = q.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.isOpen());
            entityManager.close();
        }
        return clientes;
        
    }

    public ClienteEntity getCliente(long id) {
       ClienteEntity cliente = null;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            cliente = entityManager.find(ClienteEntity.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.isOpen());
            entityManager.close();
        }
        return cliente;
    }
    
    
    public Response setCliente(ClienteEntity cliente) {
        int status = 200;
        Long resp = 0L;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            resp = cliente.getId();
        } catch (Exception e) {      
            if (entityManager.isOpen());
            entityManager.close();
            status = 500;
        } 
        return Response.status(status).header("Access-Control-Allow-Origin", "*").entity(resp).build();
    }

    public Response setClienteUpdate(ClienteEntity detalle) {
        int status = 200;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            ClienteEntity entity = entityManager.merge(detalle);
            entityManager.getTransaction().commit();
            System.out.printf("Se ha actualizado el registro" + " id: " + entity.getId());
        } catch (Exception e) {
            if (entityManager.isOpen());
            entityManager.close();
            status = 500;
        }
        return Response.status(status).header("Access-Control-Allow-Origin", "*").entity(detalle.getId()).build();
    }

    public Response deleteCliente(long id) {
        int status = 200;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            ClienteEntity entity = entityManager.find(ClienteEntity.class, id);
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
            System.out.printf("Se ha eliminado el registro" + " id: " + entity.getId());
        } catch (Exception e) {
            if (entityManager.isOpen());
            entityManager.close();
            status = 500;
        }
        return Response.status(status).header("Access-Control-Allow-Origin", "*").entity(id).build();
    }

}
