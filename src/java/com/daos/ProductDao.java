package com.daos;

import com.beans.Product;
import com.jdbc.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

public class ProductDao {

    public boolean addProduct(Product product, int weartype_id, int cat_id,int seller_id) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = "insert into product(name,price,size,color,brand,image,description,stock,selling_price,shopkeeper_id,status) values(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, product.getName());
                smt.setInt(2, product.getPrice());
                smt.setString(3, product.getSize());
                smt.setString(4, product.getColor());
                smt.setString(5, product.getBrand());
                smt.setString(6, product.getImage());
                smt.setString(7, product.getDescription());
                smt.setInt(8, product.getStock());
                smt.setInt(9,product.getSelling_price());
                smt.setInt(10, seller_id);
                smt.setString(11, "pending");
                int n = smt.executeUpdate();

                sql = "select id from product order by id desc limit 1";
                smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                int p_id = -1;

                if (rs.next()) {
                    p_id = rs.getInt("id");
                    System.out.println("pid:"+p_id);
                    smt = con.prepareStatement("insert into product_r (product_id,weartype_id,category_id) values(?,?,?)");
                    smt.setInt(1, p_id);
                    smt.setInt(2, weartype_id);
                    smt.setInt(3, cat_id);
                    n = smt.executeUpdate();

                    if (n > 0) {
                        status = true;
                    }
                    con.commit();
                    System.out.println("Record inserted");

                }
              //  con.close();
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
    
public boolean update(Product product) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = "update product set name=?,price=?,size=?,color=?,brand=?,image=?,description=?,stock=?,selling_price=?,shopkeeper_id=?,status=? where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, product.getName());
                smt.setInt(2, product.getPrice());
                smt.setString(3, product.getSize());
                smt.setString(4, product.getColor());
                smt.setString(5, product.getBrand());
                smt.setString(6, product.getImage());
                smt.setString(7, product.getDescription());
                smt.setInt(8, product.getStock());
                smt.setInt(9,product.getSelling_price());
                smt.setInt(10, product.getSeller_id());
                smt.setString(11, product.getStatus());
                smt.setInt(12, product.getId());
                int n = smt.executeUpdate();
 

                    if (n > 0) {
                        status = true;
                    }
                    con.commit();
                    System.out.println("Record updated");

                
               // con.close();
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
    

public boolean AddStock(int pid,int stock) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = "update product set stock=stock+? where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, stock);
                smt.setInt(2, pid);
                 
                int n = smt.executeUpdate();
 

                    if (n > 0) {
                        status = true;
                    }
                    con.commit();
                    System.out.println("Record updated");

                
               // con.close();
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

   
public boolean subtractStock(int pid,int stock) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = "update product set stock=stock-? where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, stock);
                smt.setInt(2, pid);
                 
                int n = smt.executeUpdate();
 

                    if (n > 0) {
                        status = true;
                    }
                    con.commit();
                    System.out.println("Record updated");

                
               // con.close();
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


    public boolean removeById(int id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                con.setAutoCommit(false);
                String sql = "delete from product_r where product_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                int n = smt.executeUpdate();
            smt = con.prepareStatement("delete from product where id=?");
            smt.setInt(1, id);
            n = smt.executeUpdate();
            con.setAutoCommit(true);
                 
                if (n > 0) {
                    status = true;
                    System.out.println("alert('Record Removed...')");
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return status;
    }
    

    public Product getById(int id) {
        Product product = null;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from product where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return product;
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setPrice(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    public ArrayList<Product> getAllProductByShopkeeperId(int shopkeeperId) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product where shopkeeper_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, shopkeeperId);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setPrice(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }
    
     public ArrayList<Product> getAllProductByShopkeeperIdAndStatus(int shopkeeperId,String status) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product where shopkeeper_id=? and status=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, shopkeeperId);
                smt.setString(2, status);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setPrice(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }
    
    
    
     public ArrayList<Product> getAllApprovedProduct() {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product where status=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, "approved");
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

      public ArrayList<Product> getAllProductByStatus(String status) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product wherer status=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, status);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setPrice(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }
      
        public ArrayList<Product> getAllNonApprovedProducts() {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product where status != 'approved'";
                PreparedStatement smt = con.prepareStatement(sql);
               
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setPrice(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }
      
   public ArrayList<String> getAllProductBrands() {
        ArrayList<String> brandList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select distinct(brand) from product";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    brandList.add(rs.getString(1));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return brandList;
    }  
        
        
    public ArrayList<Product> getAllProductBySize(String size) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product where size=? and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, size);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                     product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    public ArrayList<Product> getAllProductByBrand(String brand) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product where brand=? and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, brand);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                     product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    public ArrayList<Product> getAllProductByColor(String color) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product where color=? and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, color);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                     product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    public int getProductCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();

            if (con != null) {
                String sql = "select count(*) from product ";
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

    public ArrayList<Product> getAllProductByWearType(int wear_id) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from product where id in(select product_id from product_r where weartype_id=?) and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, wear_id);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    public ArrayList<Product> getAllProductByCategory(String category) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from product where id in(select product_id from product_r where category_id in(select id from category where name=?)) and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, category);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    public ArrayList<Product> getAllProductByWearTypeIdAndCategoryId(int wear_id, int cat_id) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from product where id in(select product_id from product_r where cat_id in(select id from category where id=?)and weartype_id in(select id from wear_type where id=?)) and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, cat_id);
                smt.setInt(2, wear_id);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                     product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    public ArrayList<Product> getAllProductByWearTypeAndCategoryAndColor(String weartype, String category, String color) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from product where color=? and id in(select product_id from product_r where cat_id in(select id from category where name=?)and weartype_id in(select id from wear_type where name=?)) and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, color);
                smt.setString(2, category);
                smt.setString(3, weartype);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                     product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    public ArrayList<Product> getAllProductByWearTypeAndCategoryAndSize(String weartype, String category, String size) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from product where size=? and id in(select product_id from product_r where cat_id in(select id from category where name=?)and weartype_id in(select id from wear_type where name=?)) and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, size);
                smt.setString(2, category);
                smt.setString(3, weartype);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                     product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    public ArrayList<Product> getAllProductByWearTypeAndCategoryAndBrand(String weartype, String category, String brand) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from product where brand=? and id in(select product_id from product_r where cat_id in(select id from category where name=?)and weartype_id in(select id from wear_type where name=?)) and status='approved'";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, brand);
                smt.setString(2, category);
                smt.setString(3, weartype);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                     product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }
    public ArrayList<Product> getAllProductByLimit(int limit) {
        ArrayList<Product> productList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = " select * from product where  status='approved' limit ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, limit);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setSize(rs.getString("size"));
                    product.setColor(rs.getString("color"));
                    product.setBrand(rs.getString("brand"));
                    product.setImage(rs.getString("image"));
                    product.setDescription(rs.getString("description"));
                    product.setStock(rs.getInt("stock"));
                    product.setSelling_price(rs.getInt("selling_price"));
                    product.setStatus(rs.getString("status"));
                    product.setSeller_id(rs.getInt("shopkeeper_id"));
                    
                    productList.add(product);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }

    
}

