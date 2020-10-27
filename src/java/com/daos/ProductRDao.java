/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;
import com.beans.Product;
import com.jdbc.ConnectionPool;
import java.sql.*;
/**
 *
 * @author Dell
 */
public class ProductRDao {
        
public boolean update(int pid,int wearid,int catid) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = "update product_r set category_id=?,weartype_id=? where product_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, catid);
                smt.setInt(2, wearid);
                smt.setInt(3, pid);
                 
                int n = smt.executeUpdate();
 

                    if (n > 0) {
                        status = true;
                    }
                    con.commit();
                    System.out.println("Record updated");

                
                con.close();
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception x) {
                    System.out.println("Error " + x.getMessage());
                }
                System.out.println("Error:" + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }
        return status;
    }
    
}
