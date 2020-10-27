
package com.daos;

import com.beans.WearType;
import com.jdbc.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WeartypeDao {
    
    public boolean add(String weartype) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Insert into wear_type(name) values (?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, weartype);
                
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
    
    public boolean removeById(int id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "delete from weart_ype where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);

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
    
    public WearType getById(int id) {
        WearType weartype = null;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from wear_type where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    weartype = new WearType();
                    weartype.setId(rs.getInt("id"));
                    weartype.setName(rs.getString("name"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return weartype;
    }

    
    public ArrayList<WearType> getAllWeartype() {
        ArrayList<WearType> weartypeList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from wear_type";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    WearType weartype = new WearType();
                    weartype.setId(rs.getInt("id"));
                    weartype.setName(rs.getString("name"));
                    
                    weartypeList.add(weartype);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return weartypeList;
    }
    
    public WearType getWeartypeByProductId(int product_id) {
        WearType weartype = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from wear_type where id in(select weartype_id from product_r where product_id=? )";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, product_id);
                ResultSet rs = smt.executeQuery();
                if(rs.next()){
                    weartype = new WearType();
                    weartype.setId(rs.getInt("id"));
                    weartype.setName(rs.getString("name"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return weartype;
    }
        
    
    public boolean update(WearType weartype) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "update wear_type set name=? where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, weartype.getName());
                smt.setInt(2, weartype.getId());
                
                int n = smt.executeUpdate();
               // System.out.println("n:"+n);
                if (n > 0) {
                    //System.out.println("Customer:"+customer);
                    status = true;
                    System.out.println("Record Updated!!!");
                }
                cp.putConnection(con);
                smt.close();

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }
    
    
   /* public static void main(String[] args) {
        WeartypeDao wd = new WeartypeDao();
        System.out.println(wd.getWeartypeByProductId(1).getName());
    }*/
}
