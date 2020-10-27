
package com.daos;

import com.beans.Category;

import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDao {
    
    public boolean add(String category) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Insert into category(name) values (?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, category);
                
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
                String sql = "delete from category where id=?";
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
    
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> categoryList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from category";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setName(rs.getString("name"));
                    
                    categoryList.add(category);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return categoryList;
    }
    
    public ArrayList<Category> getAllCategoryByWearId(int wear_id) {
        ArrayList<Category> categoryList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                //String sql = "select * from category where id in(select cat_id from product_details where weartype_id in(select id from weartype where id=?))";
                 String sql = "select * from category where id in (select cat_id from cat_wear_r where weartype_id = ?)";
               
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, wear_id);
                
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setName(rs.getString("name"));
                    
                    categoryList.add(category);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return categoryList;
    }
    
    public Category getById(int id) {
        Category category = null;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from category where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setName(rs.getString("name"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return category;
    }
    
    public boolean update(Category category) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "update category set name=? where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, category.getName());
                smt.setInt(2, category.getId());
                
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
    
    public Category getCategoryByProductId(int p_id) {
        Category category = null;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from category where id in(select category_id from product_r where product_id=?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, p_id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setName(rs.getString("name"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return category;
    }
    
}
