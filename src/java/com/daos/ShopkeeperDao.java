package com.daos;

import com.beans.Shopkeeper;
import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ShopkeeperDao {

    public boolean add(Shopkeeper shopkeeper) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Insert into shopkeeper(name,gender,email,contact,userid,password,role,image,RN,address,pin,shopname,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, shopkeeper.getName());
                smt.setString(2, shopkeeper.getGender());
                smt.setString(3, shopkeeper.getEmail());
                smt.setString(4, shopkeeper.getContact());
                smt.setString(5, shopkeeper.getUserid());
                smt.setString(6, shopkeeper.getPassword());
                smt.setString(7, shopkeeper.getRole());
                smt.setString(8, shopkeeper.getImage());
                smt.setString(9, shopkeeper.getRN());
                smt.setString(10, shopkeeper.getAddress());
                smt.setString(11, shopkeeper.getPin());
                smt.setString(12, shopkeeper.getShopName());
                smt.setString(13, "pending");

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
                String sql = "delete from shopkeeper where id=?";
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

    public boolean remove(Shopkeeper shopkeeper) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "delete from shopkeeper where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, shopkeeper.getId());

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

    public Shopkeeper getById(int id) {
        Shopkeeper shopkeeper = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from shopkeeper where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    shopkeeper = new Shopkeeper();
                    shopkeeper.setId(rs.getInt("id"));
                    shopkeeper.setName(rs.getString("name"));
                    shopkeeper.setGender(rs.getString("gender"));
                    shopkeeper.setEmail(rs.getString("email"));
                    shopkeeper.setContact(rs.getString("contact"));
                    shopkeeper.setUserid(rs.getString("userid"));
                    shopkeeper.setPassword(rs.getString("password"));
                    shopkeeper.setPin(rs.getString("pin"));
                    shopkeeper.setShopName(rs.getString("shopname"));
                    shopkeeper.setStatus(rs.getString("status"));
                    shopkeeper.setImage(rs.getString("image"));
                    shopkeeper.setRN(rs.getString("rn"));
                    shopkeeper.setAddress(rs.getString("address"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return shopkeeper;
    }

    
    
    public Shopkeeper getByProductId(int id) {
        Shopkeeper shopkeeper = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from shopkeeper where id=(select shopkeeper_id from product where id=?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    shopkeeper = new Shopkeeper();
                    shopkeeper.setId(rs.getInt("id"));
                    shopkeeper.setName(rs.getString("name"));
                    shopkeeper.setGender(rs.getString("gender"));
                    shopkeeper.setEmail(rs.getString("email"));
                    shopkeeper.setContact(rs.getString("contact"));
                    shopkeeper.setUserid(rs.getString("userid"));
                    shopkeeper.setPassword(rs.getString("password"));
                    shopkeeper.setPin(rs.getString("pin"));
                    shopkeeper.setShopName(rs.getString("shopname"));
                    shopkeeper.setStatus(rs.getString("status"));
                    shopkeeper.setImage(rs.getString("image"));
                    shopkeeper.setRN(rs.getString("rn"));
                    shopkeeper.setAddress(rs.getString("address"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return shopkeeper;
    }

    public ArrayList<Shopkeeper> getAllRecords() {
        ArrayList<Shopkeeper> shopkeepers = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from shopkeeper";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Shopkeeper shopkeeper = new Shopkeeper();
                    shopkeeper.setId(rs.getInt("id"));
                    shopkeeper.setName(rs.getString("name"));
                    shopkeeper.setGender(rs.getString("gender"));
                    shopkeeper.setEmail(rs.getString("email"));
                    shopkeeper.setContact(rs.getString("contact"));
                    shopkeeper.setUserid(rs.getString("userid"));
                    shopkeeper.setPassword(rs.getString("password"));
                    shopkeeper.setPin(rs.getString("pin"));
                    shopkeeper.setShopName(rs.getString("shopname"));
                    shopkeeper.setStatus(rs.getString("status"));
                    shopkeeper.setImage(rs.getString("image"));
                    shopkeeper.setRN(rs.getString("rn"));
                    shopkeeper.setAddress(rs.getString("address"));
                    shopkeepers.add(shopkeeper);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return shopkeepers;
    }
    public ArrayList<Shopkeeper> getAllApprovedRecords() {
        ArrayList<Shopkeeper> shopkeepers = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from shopkeeper where status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Shopkeeper shopkeeper = new Shopkeeper();
                    shopkeeper.setId(rs.getInt("id"));
                    shopkeeper.setName(rs.getString("name"));
                    shopkeeper.setGender(rs.getString("gender"));
                    shopkeeper.setEmail(rs.getString("email"));
                    shopkeeper.setContact(rs.getString("contact"));
                    shopkeeper.setUserid(rs.getString("userid"));
                    shopkeeper.setPassword(rs.getString("password"));
                    shopkeeper.setPin(rs.getString("pin"));
                    shopkeeper.setShopName(rs.getString("shopname"));
                    shopkeeper.setStatus(rs.getString("status"));
                    shopkeeper.setImage(rs.getString("image"));
                    shopkeeper.setRN(rs.getString("rn"));
                    shopkeeper.setAddress(rs.getString("address"));
                    shopkeepers.add(shopkeeper);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return shopkeepers;
    }

     public ArrayList<Shopkeeper> getAllRecordsByStatus(String status) {
        ArrayList<Shopkeeper> shopkeepers = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from shopkeeper where status=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, status);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Shopkeeper shopkeeper = new Shopkeeper();
                    shopkeeper.setId(rs.getInt("id"));
                    shopkeeper.setName(rs.getString("name"));
                    shopkeeper.setGender(rs.getString("gender"));
                    shopkeeper.setEmail(rs.getString("email"));
                    shopkeeper.setContact(rs.getString("contact"));
                    shopkeeper.setUserid(rs.getString("userid"));
                    shopkeeper.setPassword(rs.getString("password"));
                    shopkeeper.setPin(rs.getString("pin"));
                    shopkeeper.setShopName(rs.getString("shopname"));
                    shopkeeper.setStatus(rs.getString("status"));
                    shopkeeper.setImage(rs.getString("image"));
                    shopkeeper.setRN(rs.getString("rn"));
                    shopkeeper.setAddress(rs.getString("address"));
                    shopkeepers.add(shopkeeper);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return shopkeepers;
    }
      
    public ArrayList<Shopkeeper> getRowsByLimit(int start, int end) {
        ArrayList<Shopkeeper> shopkeepers = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from shopkeeper limit ?,?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, end);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Shopkeeper shopkeeper = new Shopkeeper();
                    shopkeeper.setId(rs.getInt("id"));
                    shopkeeper.setName(rs.getString("name"));
                    shopkeeper.setGender(rs.getString("gender"));
                    shopkeeper.setEmail(rs.getString("email"));
                    shopkeeper.setContact(rs.getString("contact"));
                    shopkeeper.setUserid(rs.getString("userid"));
                    shopkeeper.setPassword(rs.getString("password"));
                    shopkeeper.setPin(rs.getString("pin"));
                    shopkeeper.setShopName(rs.getString("shopname"));
                    shopkeeper.setStatus(rs.getString("status"));
                    shopkeeper.setImage(rs.getString("image"));
                    shopkeeper.setRN(rs.getString("rn"));
                    shopkeeper.setAddress(rs.getString("address"));
                    shopkeepers.add(shopkeeper);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return shopkeepers;
    }
    
    public ArrayList<Shopkeeper> getRecordsByLimit(ArrayList<Shopkeeper> list, int start, int end) {
        ArrayList<Shopkeeper> shopkeepers = new ArrayList();
        for (int  i=start;i<(start+end) && i<list.size();i++)
            shopkeepers.add(list.get(i));
        return shopkeepers;
    }

    public boolean isUserIdExist(String userid) {
        boolean status = false;
                        
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from shopkeeper where userid=?";
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
                String sql = "select * from shopkeeper where email=?";
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
     public boolean isShopExist(String RN) {
        boolean status = false;
        
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
        
            cp.initialize();
            Connection con = cp.getConnection();
        
            if (con != null) {
                String sql = "select * from shopkeeper where RN=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, RN);

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


    public boolean isContactExist(String contact) {
        boolean status = false;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from shopkeeper where contact=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, contact);

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

    public boolean update(Shopkeeper shopkeeper) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "update shopkeeper set name=?,gender=?,email=?,contact=?,userid=?,password=?,address=?,shopname=?,status=?  where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, shopkeeper.getName());
                smt.setString(2, shopkeeper.getGender());
                smt.setString(3, shopkeeper.getEmail());
                smt.setString(4, shopkeeper.getContact());
                smt.setString(5, shopkeeper.getUserid());
                smt.setString(6, shopkeeper.getPassword());
               smt.setString(7, shopkeeper.getAddress());
                smt.setString(8,shopkeeper.getShopName());
                smt.setString(9, shopkeeper.getStatus());
                 smt.setInt(10, shopkeeper.getId());
                
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
                String sql = "select count(*) from shopkeeper";
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
            System.out.println("Err     or :" + e.getMessage());
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
                String sql = "select role from shopkeeper where userid=? and password=?";
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
    
    public Shopkeeper getByLoginDetail(String userid, String password, String role) {
        Shopkeeper shopkeeper = null;
        try {
            System.out.println("Connection started .....");
            ConnectionPool cp = ConnectionPool.getInstance();
            System.out.println("line 1 : connectionPool : "+cp);
            cp.initialize();
            System.out.println("line 2 : connectionPool again: "+ cp);
            Connection con = cp.getConnection();
            System.out.println("line 3 : connection object : " + con);
            if (con != null) {
                String sql = "select * from shopkeeper where userid=? and password=? and role=? and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
               smt.setString(1, userid);
               smt.setString(2,password);
               smt.setString(3, role);
                ResultSet rs = smt.executeQuery();
                System.out.println("Query executed...");
                if (rs.next()) {
                    shopkeeper = new Shopkeeper();
                    shopkeeper.setId(rs.getInt("id"));
                    shopkeeper.setName(rs.getString("name"));
                    shopkeeper.setGender(rs.getString("gender"));
                    shopkeeper.setEmail(rs.getString("email"));
                    shopkeeper.setContact(rs.getString("contact"));
                    shopkeeper.setImage(rs.getString("image"));
                    shopkeeper.setPin(rs.getString("pin"));
                    shopkeeper.setShopName(rs.getString("shopname"));
                    shopkeeper.setStatus(rs.getString("status"));
                    shopkeeper.setImage(rs.getString("image"));
                    shopkeeper.setRN(rs.getString("rn"));
                    shopkeeper.setAddress(rs.getString("address"));
                  //  admin.setUserid(rs.getString("userid"));
                //   admin.setPassword(rs.getString("password"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return shopkeeper;
    }
    
    public int isValid(String userid, String password, String role) {
        int id = -1;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "select * from shopkeeper where userid=? and password=? and role=? and status='approved'";
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
    
    public ArrayList<Shopkeeper> getShopsByPin(String pin) {
        ArrayList<Shopkeeper> shopkeepers = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from shopkeeper where pin=? and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, pin);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Shopkeeper shopkeeper = new Shopkeeper();
                    shopkeeper.setId(rs.getInt("id"));
                    shopkeeper.setName(rs.getString("name"));
                    shopkeeper.setGender(rs.getString("gender"));
                    shopkeeper.setEmail(rs.getString("email"));
                    shopkeeper.setContact(rs.getString("contact"));
                    shopkeeper.setUserid(rs.getString("userid"));
                    shopkeeper.setPassword(rs.getString("password"));
                    shopkeeper.setPin(rs.getString("pin"));
                    shopkeeper.setShopName(rs.getString("shopname"));
                    shopkeeper.setAddress(rs.getString("address"));
                    shopkeeper.setStatus(rs.getString("status"));
                    shopkeeper.setImage(rs.getString("image"));
                    shopkeeper.setRN(rs.getString("rn"));
                    shopkeeper.setAddress(rs.getString("address"));
                    shopkeepers.add(shopkeeper);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return shopkeepers;
    }
    
    
    public static void main(String[] args) {
        
    CustomerDao c = new CustomerDao();
        
    }
}
