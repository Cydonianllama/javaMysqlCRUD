package com.mycompany.mytest;

import com.mycompany.mytest.entities.product.ProductRepository;
import com.mycompany.mytest.entities.order.OrderRepository;
import com.mycompany.mytest.utils.ConnectionDB;

import com.mycompany.mytest.models.Product;
import com.mycompany.mytest.models.Order;

/**
 *
 * @author Cydonian
 */
public class main {
    public static void main(String[] args){
        ConnectionDB DB = new ConnectionDB();  
        ProductRepository productRepo = new ProductRepository(DB);
        OrderRepository orderRepo = new OrderRepository(DB);
        Order o_ = new Order(
                "order-2",
                "cashier-1",
                "finalized");

    } 
}
