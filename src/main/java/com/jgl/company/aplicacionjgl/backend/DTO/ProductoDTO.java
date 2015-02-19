/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgl.company.aplicacionjgl.backend.DTO;

/**
 *
 * @author Jhonatan
 */
public class ProductoDTO {
    private String linea;
    private String referencia;
    private int cantInven;
    private String codigo;
    private int precioVenta;
    private double piva;
    private String codigoBarras;

    

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCantInven() {
        return cantInven;
    }

    public void setCantInven(int cantInven) {
        this.cantInven = cantInven;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPiva() {
        return piva;
    }

    public void setPiva(double piva) {
        this.piva = piva;
    }
    
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    
}
