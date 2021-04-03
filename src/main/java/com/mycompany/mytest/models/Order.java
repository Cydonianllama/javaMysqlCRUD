package com.mycompany.mytest.models;
//libs
import java.util.List;

//modesls
import com.mycompany.mytest.models.OrderItem;

/**
 *
 * @author Usuario
 */
public class Order {

    private String idOrder;
    private String idCashier;
    private String state;
    private List<OrderItem> products;
    
    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdCashier() {
        return idCashier;
    }

    public void setIdCashier(String idCashier) {
        this.idCashier = idCashier;
    }

    public List<OrderItem> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItem> products) {
        this.products = products;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Order(
            String idOrder, 
            String idCashier, 
            String state, 
            List<OrderItem> products
    ) {
        this.idOrder = idOrder;
        this.idCashier = idCashier;
        this.state = state;
        this.products = products;
    }
    
    public Order() {
        
    }

    public Order(
            String idOrder,
            String idCashier, 
            String state
    ) {
        this.idOrder = idOrder;
        this.idCashier = idCashier;
        this.state = state;
    }    
    
}
