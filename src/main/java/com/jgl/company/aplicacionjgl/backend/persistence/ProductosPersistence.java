/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.persistence;


import com.jgl.company.aplicacionjgl.backend.DTO.ProductoPageDTO;
import com.jgl.company.aplicacionjgl.backend.entity.ProductoEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jhonatan
 */
public class ProductosPersistence {

    protected EntityManagerFactory emf;
    protected EntityManager entityManager;

    public ProductosPersistence() {
        emf = Persistence.createEntityManagerFactory("AplicacionJGL");
    }

    public ProductoPageDTO getProductos(Integer page, Integer maxRecords) {
        ProductoPageDTO productos = null;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query count = entityManager.createQuery("select count(u) from ProductoEntity u");
            Long regCount = 0L;
            regCount = Long.parseLong(count.getSingleResult().toString());
            Query query = entityManager.createQuery("select u from ProductoEntity u");
            if(page != null && maxRecords != null){
                query.setFirstResult((page-1)*maxRecords);
                query.setMaxResults(maxRecords);
            }
            productos = new ProductoPageDTO();
            productos.setTotalRecords(regCount);
            productos.setProductos(query.getResultList());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.isOpen());
            entityManager.close();
        }
        return productos;
    }

    public ProductoEntity getProducto(long id) {
        ProductoEntity producto = null;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            producto = entityManager.find(ProductoEntity.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.isOpen());
            entityManager.close();
        }
        return producto;

    }

    public Response setProducto(ProductoEntity producto) {
        int status = 200;
        Long resp = 0L;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(producto);
            entityManager.getTransaction().commit();
            resp = producto.getId();
        } catch (Exception e) {      
            if (entityManager.isOpen());
            entityManager.close();
            status = 500;
        } 
        return Response.status(status).header("Access-Control-Allow-Origin", "*").entity(resp).build();
    }

    public Response setProductoUpdate(ProductoEntity detalle) {
        int status = 200;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            ProductoEntity entity = entityManager.merge(detalle);
            entityManager.getTransaction().commit();
            System.out.printf("Se ha actualizado el registro" + " id: " + entity.getId());
        } catch (Exception e) {
            if (entityManager.isOpen());
            entityManager.close();
            status = 500;
        }
        return Response.status(status).header("Access-Control-Allow-Origin", "*").entity(detalle.getId()).build();
    }

    public Response deleteProducto(long id) {
        int status = 200;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            ProductoEntity entity = entityManager.find(ProductoEntity.class, id);
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
