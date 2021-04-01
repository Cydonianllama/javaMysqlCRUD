/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytest.models;

/**
 *
 * @author Usuario
 */
public class Product {
    
    private String IdProduct;
    private String nameProduct;
    private String typeProduct;
    private float currentPrice;
    
    public Product(){
        
    }

    public String getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(String IdProduct) {
        this.IdProduct = IdProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Product(String IdProduct, String nameProduct, String typeProduct, float currentPrice) {
        this.IdProduct = IdProduct;
        this.nameProduct = nameProduct;
        this.typeProduct = typeProduct;
        this.currentPrice = currentPrice;
    }
    
}
