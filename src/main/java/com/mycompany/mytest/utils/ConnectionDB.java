package com.mycompany.mytest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;

// for queries 
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Cydonian
 */
public class ConnectionDB {

    public ConnectionDB() {
    
    }
    
    public Connection getConnection(){
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapractice?" + "user=root&password=");
            
            return conn;
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return null;
        
    }
    
    public void test(){
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapractice?" + "user=root&password=");
            
            Statement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM products");
            
            if (stmt.execute("SELECT * FROM products")) {
                rs = stmt.getResultSet();
                System.out.println(rs);
            }
            
            while (rs.next())
            {
                System.out.println("id ="+rs.getObject("idProduct"));
            }
            
            conn.close();
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}


