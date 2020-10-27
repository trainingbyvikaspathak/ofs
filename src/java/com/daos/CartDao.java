
package com.daos;

import com.beans.Cart;
import com.jdbc.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

public class CartDao {
    
    public boolean add(int cust_id, int prod_id, int qty) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Insert into cart(customer_id,product_id,qty) values (?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, cust_id);
                smt.setInt(2, prod_id);
                smt.setInt(3, qty);
                
                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Inserted!!");
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }
    
    public boolean removeByCustomerId(int customer_id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "delete from cart where customer_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, customer_id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record removed!!");
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return status;
    }
    
    public boolean removeByProductId(int product_id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "delete from cart where product_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, product_id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record removed!!");
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return status;
    }
    
    public boolean removeByCustomerIdAndProductId(int customer_id,int product_id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "delete from cart where customer_id=? and product_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, customer_id);
                smt.setInt(2, product_id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record removed!!");
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return status;
    }
    
    
    public ArrayList<Cart> getAllCartRecordsByCustomerId(int customer_id) {
        ArrayList<Cart> carts = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from cart where customer_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, customer_id);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Cart cart = new Cart();
                    cart.setId(rs.getInt("id"));
                    //cart.setCustomer_id(rs.getInt("customer_id"));
                    //cart.setProduct_id(rs.getInt("product_id"));
                    //cart.setQuantity(rs.getInt("qty"));
                    
                    carts.add(cart);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return carts;
    }
    
    public int getCartProductCount(int customer_id) {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();

            if (con != null) {
                String sql = "select count(*) from cart where customer_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, customer_id);
                ResultSet rs = smt.executeQuery();

                if (rs.next()) {
                    total = rs.getInt(1);
                    System.out.println("total records:" + total);
                }

                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return total;
    }
    
}
