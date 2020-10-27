package com.daos;

import com.beans.Customer;
import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDao {

    public boolean add(Customer customer) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Insert into customer(name,gender,email,mobile,userid,password,role,image) values (?,?,?,?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, customer.getName());
                smt.setString(2, customer.getGender());
                smt.setString(3, customer.getEmail());
                smt.setString(4, customer.getMobile());
                smt.setString(5, customer.getUserid());
                smt.setString(6, customer.getPassword());
                smt.setString(7, customer.getRole());
                smt.setString(8, customer.getImage());

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Inserted!!");
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Record not inserted");
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
                String sql = "delete from customer where id=?";
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

    public boolean remove(Customer customer) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "delete from customer where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, customer.getId());

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

    public Customer getById(int id) {
        Customer customer = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from customer where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setGender(rs.getString("gender"));
                    customer.setEmail(rs.getString("email"));
                    customer.setMobile(rs.getString("mobile"));
                    customer.setUserid(rs.getString("userid"));
                    customer.setPassword(rs.getString("password"));

                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return customer;
    }

    public ArrayList<Customer> getAllRecords() {
        ArrayList<Customer> customers = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from customer";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setGender(rs.getString("gender"));
                    customer.setEmail(rs.getString("email"));
                    customer.setMobile(rs.getString("mobile"));
                    customer.setUserid(rs.getString("userid"));
                    customer.setPassword(rs.getString("password"));

                    customers.add(customer);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customers;
    }

    public ArrayList<Customer> getRowsByLimit(int start, int end) {
        ArrayList<Customer> customers = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from customer limit ?,?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, end);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setGender(rs.getString("gender"));
                    customer.setEmail(rs.getString("email"));
                    customer.setMobile(rs.getString("mobile"));
                    customer.setUserid(rs.getString("userid"));
                    customer.setPassword(rs.getString("password"));
                    
                    customers.add(customer);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return customers;
    }

    public boolean isUserIdExist(String userid) {
        boolean status = false;
                       
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from customer where userid=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, userid);

                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    status = true;
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return status;
    }

    public boolean isEmailExist(String email) {
        boolean status = false;
        
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
        
            cp.initialize();
            Connection con = cp.getConnection();
        
            if (con != null) {
                String sql = "select * from customer where email=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, email);

                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    status = true;
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return status;
    }

    public boolean isMobileExist(String mobile) {
        boolean status = false;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from customer where mobile=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, mobile);

                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    status = true;
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return status;
    }

    public boolean update(Customer customer) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "update customer set name=?,gender=?,email=?,mobile=?,userid=?,password=? where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, customer.getName());
                smt.setString(2, customer.getGender());
                smt.setString(3, customer.getEmail());
                smt.setString(4, customer.getMobile());
                smt.setString(5, customer.getUserid());
                smt.setString(6, customer.getPassword());
                smt.setInt(7, customer.getId());

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

    public int getRecordCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();

            if (con != null) {
                String sql = "select count(*) from customer";
                PreparedStatement smt = con.prepareStatement(sql);
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

    public String getRole(String userid, String password) {
        String role = null;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select role from customer where userid=? and password=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, userid);
                smt.setString(2, password);

                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    role = rs.getString("role");
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return role;
    }
    
    public Customer getByLoginDetail(String userid, String password, String role) {
        Customer customer = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from customer where userid=? and password=? and role=?";
                PreparedStatement smt = con.prepareStatement(sql);
               smt.setString(1, userid);
               smt.setString(2,password);
               smt.setString(3, role);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    customer = new Customer();
                    customer.setName(rs.getString("name"));
                    customer.setGender(rs.getString("gender"));
                    customer.setEmail(rs.getString("email"));
                    customer.setMobile(rs.getString("mobile"));
                    customer.setImage(rs.getString("image"));
                    customer.setId(rs.getInt("id"));
                  //  admin.setUserid(rs.getString("userid"));
                //   admin.setPassword(rs.getString("password"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return customer;
    }
    
    public int isValid(String userid, String password, String role) {
        int id = -1;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "select * from customer where userid=? and password=? and role=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, userid);
                smt.setString(2, password);
                smt.setString(3, role);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("id");
                }
                smt.close();
                cp.putConnection(con);
            } catch (Exception e) {
                System.out.println("DBError :" + e.getMessage());
            }
        }

        return id;
    }
    public static void main(String[] args) {
        
    CustomerDao c = new CustomerDao();
        
    }
}
