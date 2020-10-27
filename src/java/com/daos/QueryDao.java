/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.beans.Queries;
import com.daos.QueryDao;


public class QueryDao {
    
      public boolean save(Queries query) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Insert into queries(name,email,subject,message) values (?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, query.getName());
                smt.setString(2, query.getEmail());
                smt.setString(3, query.getSubject());
                smt.setString(4, query.getMessage());
                
                
                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Query Inserted!!");
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }
    
    public boolean addQuery(String name, String email, String subject, String message) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Insert into queries(name,email,subject,message) values (?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, name);
                smt.setString(2, email);
                smt.setString(3, subject);
                smt.setString(4, message);
                
                
                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Query Inserted!!");
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }
    
    public ArrayList<Queries> getAllQueries() {

        ArrayList<Queries> queries = new ArrayList<Queries>();
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "select * from queries order by id desc";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Queries query = new Queries();
                    query.setId(rs.getInt("id"));
                    query.setName(rs.getString("name"));
                    query.setEmail(rs.getString("email"));
                    query.setSubject(rs.getString("subject"));
                    query.setMessage(rs.getString("message"));
                   queries.add(query);
                }
                smt.close();
                cp.putConnection(con);
            } catch (Exception e) {
                System.out.println("Error :" + e.getMessage());
            }
        }
        return queries;
    }
    
    public Queries getById(int id) {
        Queries query = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "select * from queries where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    query = new Queries();
                    query.setId(rs.getInt("id"));
                    query.setName(rs.getString("name"));
                    query.setEmail(rs.getString("email"));
                    query.setSubject(rs.getString("subject"));
                    query.setMessage(rs.getString("message"));
                    
               }
                smt.close();
                cp.putConnection(con);
            } catch (Exception e) {
                System.out.println("Error :" + e.getMessage());
            }
        }

        return query;
    }
    
}
