package com.mycompany.mytest.controllers;
import com.mycompany.mytest.models.Product;
import java.util.List;
/**
 *
 * @author Cydonian
 */
public class ProductController {
    
    public ProductController() {
    
    }
    
    public List<Product> getProducts(){
        List<Product> report = null;
        return report;
    }
    
    public boolean createProduct(Product product){
            return true;
    }
    
    public boolean updateProduct(Product product){
        return true;
    }
    
    public boolean deleteProduct(String idProduct){
        return true;
    }

}
