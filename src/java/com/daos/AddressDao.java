
package com.daos;

import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import com.beans.Address;
import java.sql.ResultSet;

public class AddressDao {
    
    public boolean add(Address address) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Insert into address(customer_id,address,city,state,pincode,mobile,name) values (?,?,?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, address.getCustomer_id());
                smt.setString(2, address.getAddress());
                smt.setString(3, address.getCity());
                smt.setString(4, address.getState());
                smt.setInt(5, address.getPincode());
                smt.setString(6, address.getMobile());
                smt.setString(7, address.getName());
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
                String sql = "delete from address where id=?";
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

    public boolean remove(Address address) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "delete from address where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, address.getId());

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
    
    public Address getById(int id) {
        Address address = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from address where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    address = new Address();
                    address.setId(rs.getInt("id"));
                    address.setCustomer_id(rs.getInt("customer_id"));
                    address.setAddress(rs.getString("address"));
                    address.setCity(rs.getString("city"));
                    address.setState(rs.getString("state"));
                    address.setPincode(rs.getInt("pincode"));
                    address.setMobile(rs.getString("mobile"));
                    address.setName(rs.getString("name"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return address;
    }

    public ArrayList<Address> getAllAddressesByCustomerId(int cust_id) {
        ArrayList<Address> addresses = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from address where customer_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, cust_id);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Address address = new Address();
                    address.setId(rs.getInt("id"));
                    address.setCustomer_id(rs.getInt("customer_id"));
                    address.setAddress(rs.getString("address"));
                    address.setCity(rs.getString("city"));
                    address.setState(rs.getString("state"));
                    address.setPincode(rs.getInt("pincode"));
                    address.setMobile(rs.getString("mobile"));
                    address.setName(rs.getString("name"));
                    addresses.add(address);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return addresses;
    }
    
    public Address getByIdAndCustomerId(int id, int cust_id) {
        Address address = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from address where id=? and customer_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                smt.setInt(2, cust_id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    address = new Address();
                    address.setId(rs.getInt("id"));
                    address.setCustomer_id(rs.getInt("customer_id"));
                    address.setAddress(rs.getString("address"));
                    address.setCity(rs.getString("city"));
                    address.setState(rs.getString("state"));
                    address.setPincode(rs.getInt("pincode"));
                    address.setMobile(rs.getString("mobile"));
                    address.setName(rs.getString("name"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return address;
    }
    
}
