package com.mycompany.mytest.entities.order;

//libs
import java.util.List;
import java.util.ArrayList;

//connection
import com.mycompany.mytest.utils.ConnectionDB;

//mysqlConnection
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

//models
import com.mycompany.mytest.models.Order;
import com.mycompany.mytest.models.OrderItem;

/**
 *
 * @author Grandez Mendoza Erick Manuel
 */
public class OrderRepository {

    private final ConnectionDB connection;
    
    public OrderRepository(ConnectionDB db) {
        connection = db;
    }
    
    public List<OrderItem> finItemsOrder(String idOrder){
        List<OrderItem> itemsReport = new ArrayList<OrderItem>();
        String queryIdOrder = "idOrder = '"+idOrder+"'";
        try{
            Connection conn = connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from orderitems where " +
                            queryIdOrder
            );
            while(rs.next()){
                String idItem = rs.getString("idItem");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                OrderItem item = new OrderItem(
                        idItem,
                        quantity
                );
                itemsReport.add(item);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return  itemsReport;
    }
    
    public List<Order> findAll(){
        List<Order> orderReport = new ArrayList<Order>();
        try{
            Connection conn = connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from orders");
            while(rs.next()){
                String idOrder = rs.getString("idOrder");
                String idCashier = rs.getString("idCashier");
                String state = rs.getString("state");
                
                Order order_ = new Order(
                        idOrder,
                        idCashier,
                        state
                );
                orderReport.add(order_);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        return orderReport;
    }
    
    public Order find(String idOrder){
        Order reportOrder = new Order();
        String queryIdOrder = "idOrder ='"+idOrder+"'";
        try{
            Connection conn = connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from orders where "+
                            queryIdOrder
            );
            while(rs.next()){
                String idOrder_ = rs.getString("idOrder");
                String idCashier_ = rs.getString("idCashier");
                String state_ = rs.getString("state");
                Order order = new Order(
                        idOrder_,
                        idCashier_,
                        state_
                );
                reportOrder = order;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        return reportOrder;
    }
    
    public boolean create(Order order){
        boolean isCreated = false;
        try{
            Connection conn = connection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "insert into orders(idOrder,idCashier,state)"+
                            "values(?,?,?)"
                            
            );
            ps.setString(1, order.getIdOrder());
            ps.setString(2, order.getIdCashier());
            ps.setString(3, order.getState());
            ps.execute();
            isCreated = true;
        }catch(Exception ex){
            System.out.println(ex);
        }
        return isCreated;
    }
    
    public boolean update(Order order){
        boolean isUpdated = false;
        try{
            Connection conn = connection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "update orders set "+
                            "idCashier = ? ,"+
                            "state = ? "+
                            "where idOrder = ?"
                            
            );
            ps.setString(1, order.getIdCashier());
            ps.setString(2, order.getState());
            ps.setString(3, order.getIdOrder());
            ps.execute();
            
            isUpdated = true;
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        return isUpdated;
    }
    
    public boolean delete(String idOrder){
        boolean isDeleted = false;
        try{
            Connection conn = connection.getConnection();
            PreparedStatement pt = conn.prepareStatement("delete from orders where idOrder = ?");
            pt.setString(1, idOrder);
            pt.execute();
            isDeleted = true;
        }catch(Exception ex){
            System.out.println(ex);
        }
        return isDeleted;
    }
    
}
