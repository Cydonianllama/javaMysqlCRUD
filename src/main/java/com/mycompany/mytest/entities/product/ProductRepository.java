package com.mycompany.mytest.entities.product;
//libs
import java.util.List;
import java.util.ArrayList;
// queries mysql
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
//models
import com.mycompany.mytest.models.Product;
//utils
import com.mycompany.mytest.utils.ConnectionDB;
/**
 *
 * @author Grandez Mendoza Erick Manuel
 */
public class ProductRepository {

    private final ConnectionDB connection;
    private Statement stmt;
    private ResultSet rs;
    
    public ProductRepository(ConnectionDB conn) {
           connection = conn;
    }
    
    public List<Product> findAllProducts(){
        
        List<Product> productsReport = new ArrayList<Product>();
        
        try{
            
            Connection conn = connection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM products");
            
            while (rs.next()){
                
                String idProduct = rs.getString("idProduct");
                String nameProduct = rs.getString("nameProduct");
                String typeProduct = rs.getString("typeProduct");
                float currentPrices = Float.parseFloat(rs.getString("currentPrices"));
                
                Product product = new Product(
                        idProduct,
                        nameProduct,
                        typeProduct,
                        currentPrices
                );

                productsReport.add(product);
               
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
       
        return productsReport;
        
    }
    
    public Product find(String idProduct){
        
        String idProductQuery = "idProduct = '"+idProduct+"'";
        Product productReport = new Product();
        
        try{
            
            Connection conn = connection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM products WHERE "+idProductQuery);
            
            while (rs.next()){
                
                productReport.setIdProduct(rs.getString("idProduct"));
                productReport.setNameProduct(rs.getString("nameProduct"));
                productReport.setTypeProduct(rs.getString("typeProduct"));
                productReport.setCurrentPrice(Float.parseFloat(rs.getString("currentPrices")));
                
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        return productReport;
        
    }
    
    public boolean create(Product product){
        
        boolean isCreated = false;
        
        try{
            
            Connection conn = connection.getConnection();
            PreparedStatement pt = conn.prepareStatement(
                    "insert into products(idProduct,nameProduct,typeProduct,currentPrices)"+
                            "values(?,?,?,?)"
            );
            
            pt.setString(1,product.getIdProduct());
            pt.setString(2,product.getNameProduct());
            pt.setString(3,product.getTypeProduct());
            pt.setFloat (4,product.getCurrentPrice());

            pt.execute();
            isCreated = true;
            
        }catch(Exception ex){
            System.out.println(ex);  
        }
        return isCreated;
    }
    
    public boolean update(Product product){
        
        boolean isUpdated = false;
        
        try{
            
            Connection conn = connection.getConnection();
            PreparedStatement pt = conn.prepareStatement(
                    "update products set "+
                            "nameProduct = ?,"+
                            "typeProduct = ?,"+
                            "currentPrices = ?"+
                            " Where idProduct = ?"
            );
            
            pt.setString(1,product.getNameProduct());
            pt.setString(2,product.getTypeProduct());
            pt.setFloat (3,product.getCurrentPrice());
            pt.setString(4,product.getIdProduct());

            pt.execute();
            isUpdated = true;
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        return isUpdated;
        
    }
    
}
