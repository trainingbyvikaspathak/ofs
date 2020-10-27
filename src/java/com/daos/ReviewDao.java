/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.beans.Cart;
import com.beans.Review;
import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class ReviewDao {
     public boolean add(Review review) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Insert into review(name,subject,email,message,shopkeeper_id,product_id) values (?,?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, review.getName());
                smt.setString(2, review.getSubject());
                smt.setString(3, review.getEmail());
                smt.setString(4, review.getMessage());
                smt.setInt(5, review.getShopkeeper_id());
                smt.setInt(6, review.getProduct_id());
                
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
     
     public ArrayList<Review> getAllReviewByproductId(int pid) {
        ArrayList<Review> reviews = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from review where product_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, pid);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                     Review r = new Review();
                     r.setName(rs.getString("name"));
                     r.setSubject(rs.getString("subject"));
                     r.setEmail(rs.getString("email"));
                     r.setMessage(rs.getString("message"));
                     r.setShopkeeper_id(rs.getInt("shopkeeper_id"));
                     r.setProduct_id(rs.getInt("product_id"));
                     r.setId(rs.getInt("id"));
                    r.setStatus(rs.getString("status"));
                    
                    reviews.add(r);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return reviews;
    }
    
     
     public ArrayList<Review> getAllReviewByShopkeeprId(int sid) {
        ArrayList<Review> reviews = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from review where shopkeeper_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, sid);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                     Review r = new Review();
                     r.setName(rs.getString("name"));
                     r.setSubject(rs.getString("subject"));
                     r.setEmail(rs.getString("email"));
                     r.setMessage(rs.getString("message"));
                     r.setShopkeeper_id(rs.getInt("shopkeeper_id"));
                     r.setProduct_id(rs.getInt("product_id"));
                     r.setId(rs.getInt("id"));
                     r.setStatus(rs.getString("status"));
                    
                    reviews.add(r);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return reviews;
    }
}
