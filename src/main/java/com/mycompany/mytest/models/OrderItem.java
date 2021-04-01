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
public class OrderItem {
    
    private String IdProduct;
    private int quantity;

    public OrderItem(String IdProduct, int quantity) {
        this.IdProduct = IdProduct;
        this.quantity = quantity;
    }
    
}
