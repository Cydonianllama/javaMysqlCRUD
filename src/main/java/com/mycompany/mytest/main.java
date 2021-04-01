package com.mycompany.mytest;

import com.mycompany.mytest.entities.product.ProductRepository;
import com.mycompany.mytest.utils.ConnectionDB;

import com.mycompany.mytest.models.Product;

/**
 *
 * @author Cydonian
 */
public class main {
    public static void main(String[] args){
        ProductRepository productRepo = new ProductRepository(new ConnectionDB());
        //System.out.println(productRepo.findAllProducts().get(0).getIdProduct());
        
        Product product = new Product("product-2","uva","fruta",Float.parseFloat("15.5"));
        System.out.println(productRepo.update(product));

    } 
}
