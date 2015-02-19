/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.persistence;

import com.jgl.company.aplicacionjgl.backend.DTO.ProductoDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Jhonatan
 */
public class ProductosPersistence {
    
    protected EntityManagerFactory emf;
    protected EntityManager entityManager;

    public ProductosPersistence() {
        emf = Persistence.createEntityManagerFactory("AplicacionJGL");// Construir persistence.xml
    }

    public List<ProductoDTO> getProductos() {
        List<ProductoDTO> productos = null;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query q = entityManager.createQuery("select u from ProductoEntity u");
            productos = q.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.isOpen());
            entityManager.close();
        }
        return productos;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ProductoDTO getProducto(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setProducto(ProductoDTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setProductoUpdate(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteProducto(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
