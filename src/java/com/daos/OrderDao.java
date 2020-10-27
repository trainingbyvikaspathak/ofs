package com.daos;

import com.beans.Cart;
import com.beans.Customer;
import com.beans.Product;
import com.beans.Orders;
import com.beans.OrderItems;
import com.beans.ReturnProduct;
import com.beans.TrackOrder;
import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.criteria.Order;

public class OrderDao {

    public int addOrder(Orders order) {
        int orderItemId = 0;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);

                String sql = "insert into orders(date,customer_id,address_id,payment_mode,payment_status,total_amount) values(?,?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, order.getDate());
                smt.setInt(2, order.getCustomer_id());
                smt.setInt(3, order.getAddress_id());
                smt.setString(4, order.getPayment_mode());
                smt.setString(5, order.getPayment_status());
                smt.setFloat(6, order.getTotal_amount());

                int n = smt.executeUpdate();

                sql = "select id from orders order by id desc limit 1";
                smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();

                if (rs.next()) {
                    orderItemId = rs.getInt("id");
                }
                sql = "insert into order_status(order_id,status,date,description,person) values(?,?,?,?,?)";
                smt = con.prepareStatement(sql);
                smt.setInt(1, orderItemId);
                smt.setString(2, "Booked/Pending");
                smt.setString(3, order.getDate());
                smt.setString(4, "Order Booked By Customer");
                smt.setString(5, "customer");

                n = smt.executeUpdate();

                if (n > 0) {
                    System.out.println("Record inserted to order_status !");
                }

                con.commit();
                System.out.println("Record inserted");

               // con.close();
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception x) {
                }
                System.out.println("Error:" + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }
        return orderItemId;
    }

    public boolean addOrderDetails(int order_id, ArrayList<Cart> cart) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                int n = 0;
                for (Cart c : cart) {
                    c.setOrder_id(order_id);
                    String sql = "insert into order_details(order_id,product_id,quantity,price,amount) values(?,?,?,?,?)";
                    PreparedStatement smt = con.prepareStatement(sql);
                    smt.setInt(1, order_id);
                    smt.setInt(2, c.getProduct_id());
                    smt.setInt(3, c.getQuanity());
                    smt.setFloat(4, c.getPrice());
                    smt.setFloat(5, c.getAmount());
                    n = smt.executeUpdate();

                    if (n > 0) {
                        status = true;
                        System.out.println("ordered");
                    }
                }

            } catch (Exception e) {
                System.out.println("DbError:" + e.getMessage());
            }
        }
        return status;

    }

    public ArrayList<Cart> getOrderDetails(int orderid) {
        ArrayList<Cart> orderdetails = new ArrayList<Cart>();
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                 
                String sql = "select * from order_details where order_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, orderid);
                ResultSet rs = smt.executeQuery();
                
                while (rs.next()) {
                     Cart c = new Cart();
                     c.setId(rs.getInt("id"));
                     c.setOrder_id(rs.getInt("order_id"));
                     c.setProduct_id(rs.getInt("product_id"));
                     c.setPrice(rs.getFloat("price"));
                     c.setQuanity(rs.getInt("quantity"));
                     c.setAmount(rs.getFloat("amount"));
                     orderdetails.add(c);
                }
                con.commit();
              //  con.close();
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception x) {
                }
                System.out.println("Error:" + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }

        return orderdetails;
    }

    public ArrayList<Orders> getOrdersByCustomerId(int customerId) {
        ArrayList<Orders> orders = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                orders = new ArrayList<>();
                String sql = "select * from orders where customer_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                smt.setInt(1, customerId);
                while (rs.next()) {
                    Orders order = new Orders();
                    order.setId(rs.getInt("id"));
                    order.setAddress_id(rs.getInt("address_id"));
                    order.setDate(rs.getString("date"));
                    order.setPayment_mode(rs.getString("payment_mode"));
                    order.setTotal_amount(rs.getFloat("total_amount"));
                    orders.add(order);
                }
                con.commit();
                //con.close();
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception x) {
                }
                System.out.println("Error:" + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }

        return orders;
    }

    public String getCurrentStatus(int orderId) {
        String status = "";
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = " select status from order_status where order_id=? order by id desc limit 1";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, orderId);
                ResultSet rs = smt.executeQuery();

                if (rs.next()) {
                    status = rs.getString("status");
                }
                con.commit();
               // con.close();
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception x) {
                }
                System.out.println("Error:" + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }

        return status;
    }

    
      public Orders getById(int orderId) {
        Orders order=new Orders();
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = "select * from orders where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, orderId);
                ResultSet rs = smt.executeQuery();

                if (rs.next()) {
                    order.setId(rs.getInt("id"));
                    order.setDate(rs.getString("date"));
                    order.setCustomer_id(rs.getInt("customer_id"));
                    order.setAddress_id(rs.getInt("address_id"));
                    order.setPayment_mode(rs.getString("payment_mode"));
                    order.setPayment_status(rs.getString("payment_status"));
                    order.setTotal_amount(rs.getFloat("total_amount"));
                }
                con.commit();
               // con.close();
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception x) {
                }
                System.out.println("Error:" + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }

        return order;
    }
    
    
    public String getDeliveryDate(int orderId) {
        String date = "";
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = " select date from order_status where order_id=? and status='delivered' order by id desc limit 1";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, orderId);
                ResultSet rs = smt.executeQuery();

                if (rs.next()) {
                    date = rs.getString("date");
                }
                con.commit();
               // con.close();
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception x) {
                }
                System.out.println("Error:" + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }

        return date;
    }
      
    
    public ArrayList<OrderStatus> getAllStatusByOrderId(int orderid) {
        ArrayList<OrderStatus> statuslist = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                statuslist = new ArrayList<>();
                String sql = "select * from order_status where order_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                smt.setInt(1, orderid);
                while (rs.next()) {
                    OrderStatus os = new OrderStatus();
                    os.setId(rs.getInt("id"));
                    os.setOrder_id(rs.getInt("order_id"));
                    os.setDate(rs.getString("date"));
                    os.setDescription(rs.getString("description"));
                    os.setStatus(rs.getString("status"));
                    os.setPerson(rs.getString("person"));
                    statuslist.add(os);
                }
                con.commit();
                //con.close();
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception x) {
                }
                System.out.println("Error:" + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }
        return statuslist;
    }

    public void updateOrderStatus(int orderId, String desc, String status, String person) {
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        String date = java.time.LocalDate.now().toString();
        
        if (con != null) {
            try {
                String sql = "insert into order_status(order_id,status,date,description,person) values(?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, orderId);
                smt.setString(2, status);
                smt.setString(3, date);
                smt.setString(4, desc);
                smt.setString(5, person);
                int n= smt.executeUpdate();
                
               
              //  con.close();
                smt.close();
                 cp.putConnection(con);
                
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }

    }

    
       public void addReturningRequest(int orderId,int pid, String date,int cid,int aid,String status) {
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
       // String date = java.time.LocalDate.now().toString();
        
        if (con != null) {
            try {
                String sql = "insert into return_product(order_id,product_id,date,customer_id,address_id,status) values(?,?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, orderId);
               smt.setInt(2,pid);
               smt.setString(3,date);
               smt.setInt(4, cid);
               smt.setInt(5, aid);
               smt.setString(6, status);
                System.out.println(" Hello ...");
                System.out.println("received Details : "+ orderId +","+pid +","+date+","+cid+","+aid+","+status);
                int n= smt.executeUpdate();
                
                System.out.println("Hi...");
                con.commit();
                smt.close();
                 cp.putConnection(con);
                
            } catch (Exception e) {
                System.out.println("Error -> " + e.getMessage());
            }
        }

    }
   

          public boolean isReturned(int orderid,int pid){
              boolean ans=false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        String date = java.time.LocalDate.now().toString();
        
        if (con != null) {
            try {
                String sql = "select * from return_product where order_id=? and product_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, orderid);
                smt.setInt(2, pid);
                ResultSet rs = smt.executeQuery();
                if(rs.next())
                    ans=true;
               
              //  con.close();
                smt.close();
                 cp.putConnection(con);
                
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
        return ans;

    }
          
    public ArrayList<Orders> getAllOrdersByCustomerId(int customer_id) {
        ArrayList<Orders> orders = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from orders where customer_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, customer_id);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Orders order = new Orders();
                    order.setId(rs.getInt("id"));
                    order.setCustomer_id(rs.getInt("customer_id"));
                    order.setDate(rs.getString("date"));
                    order.setAddress_id(rs.getInt("address_id"));
                    order.setTotal_amount(rs.getFloat("total_amount"));
                    order.setPayment_mode(rs.getString("payment_mode"));
                    orders.add(order);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orders;
    }

   public ArrayList<Orders> getAllOrdersByCustomerId(int customer_id,String status) {
        ArrayList<Orders> orders = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from orders  where customer_id=? and id in (select order_id from order_status where status=?);";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, customer_id);
                smt.setString(2, status);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Orders order = new Orders();
                    order.setId(rs.getInt("id"));
                    order.setCustomer_id(rs.getInt("customer_id"));
                    order.setDate(rs.getString("date"));
                    order.setAddress_id(rs.getInt("address_id"));
                    order.setTotal_amount(rs.getFloat("total_amount"));
                    order.setPayment_mode(rs.getString("payment_mode"));
                    orders.add(order);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orders;
    }  
    
   public ArrayList<Orders> getAllOrderByStatus(String status) {
        ArrayList<Orders> orders = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from orders  where id in (select order_id from order_status where status=?);";
                PreparedStatement smt = con.prepareStatement(sql);
                 smt.setString(1, status);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Orders order = new Orders();
                    order.setId(rs.getInt("id"));
                    order.setCustomer_id(rs.getInt("customer_id"));
                    order.setDate(rs.getString("date"));
                    order.setAddress_id(rs.getInt("address_id"));
                    order.setTotal_amount(rs.getFloat("total_amount"));
                    order.setPayment_mode(rs.getString("payment_mode"));
                    orders.add(order);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orders;
    }  
   
   public ArrayList<ReturnProduct> getAllReturn_product(){
       ArrayList returnOrders = new ArrayList();
       
      try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from return_product";
                PreparedStatement smt = con.prepareStatement(sql);
                  ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    ReturnProduct rp = new ReturnProduct();
                    rp.setId(rs.getInt("id"));
                    rp.setAddress_id(rs.getInt("address_id"));
                    rp.setCustomer_id(rs.getInt("customer_id"));
                    rp.setOrder_id(rs.getInt("order_id"));
                    rp.setDate(rs.getString("date"));
                    rp.setQuantity(rs.getInt("quantity"));
                    rp.setStatus(rs.getString("status"));
                    rp.setProduct_id(rs.getInt("product_id"));
                    returnOrders.add(rp);
                            
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return returnOrders;
   }
    
   
    public ArrayList<TrackOrder> getAllOrdersStatus(int orderid) {
        ArrayList<TrackOrder> orders = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from order_status where order_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, orderid);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    TrackOrder order = new TrackOrder();
                    order.setId(rs.getInt("id"));
                    order.setStatus(rs.getString("status"));
                    order.setDate(rs.getString("date"));
                   order.setDesc(rs.getString("description"));
                   order.setPerson(rs.getString("person"));
                    orders.add(order);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orders;
    }  
    
    public ArrayList<Orders> getAllOrdersInDescByCustomerId(int customer_id) {
        ArrayList<Orders> orders = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from orders where customer_id=? order by id desc";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, customer_id);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Orders order = new Orders();
                    order.setId(rs.getInt("id"));
                    order.setCustomer_id(rs.getInt("customer_id"));
                    order.setDate(rs.getString("date"));
                    order.setAddress_id(rs.getInt("address_id"));

                    orders.add(order);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orders;
    }

    public ArrayList<Cart> getAllOrdersItemsesByOrderId(int order_id) {
        ArrayList<Cart> orderItems = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from order_details where order_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, order_id);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Cart orderItem = new Cart();
                    orderItem.setId(rs.getInt("id"));
                    orderItem.setProduct_id(rs.getInt("product_id"));
                    orderItem.setQuanity(rs.getInt("quantity"));
                    orderItem.setPrice(rs.getFloat("price"));
                    orderItem.setAmount(rs.getFloat("amount"));
                    orderItems.add(orderItem);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orderItems;
    }

    public ArrayList<Orders> getAllOrders() {
        ArrayList<Orders> orders = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from orders";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Orders order = new Orders();
                    order.setId(rs.getInt("id"));
                    order.setCustomer_id(rs.getInt("customer_id"));
                    order.setDate(rs.getString("date"));
                    order.setAddress_id(rs.getInt("address_id"));
                    order.setTotal_amount(rs.getFloat("total_amount"));
                    order.setPayment_mode(rs.getString("payment_mode"));
                    
                    orders.add(order);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orders;
    }

    public ArrayList<Orders> getAllOrdersInDesc() {
        ArrayList<Orders> orders = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from orders order by id desc";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Orders order = new Orders();
                    order.setId(rs.getInt("id"));
                    order.setCustomer_id(rs.getInt("customer_id"));
                    order.setDate(rs.getString("date"));
                    order.setAddress_id(rs.getInt("address_id"));

                    orders.add(order);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orders;
    }

    public ArrayList<OrderItems> getAllOrdersItemsesByOrderIdAndStatus(int order_id, String status) {
        ArrayList<OrderItems> orderItems = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from order_items where order_id=? and status=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, order_id);
                smt.setString(2, status);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    OrderItems orderItem = new OrderItems();
                    orderItem.setId(rs.getInt("id"));
                    orderItem.setProduct_id(rs.getInt("product_id"));
                    orderItem.setOrder_id(rs.getInt("order_id"));
                    orderItem.setQuantity(rs.getInt("quantity"));
                    orderItem.setPrice(rs.getInt("price"));
                    orderItem.setStatus(rs.getString("status"));
                    orderItem.setDate(rs.getString("date"));

                    orderItems.add(orderItem);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orderItems;
    }

 
    public ArrayList<OrderItems> getAllOrdersItemsByStatus(String status) {
        ArrayList<OrderItems> orderItems = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from order_items where status=?";
                PreparedStatement smt = con.prepareStatement(sql);

                smt.setString(1, status);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    OrderItems orderItem = new OrderItems();
                    orderItem.setId(rs.getInt("id"));
                    orderItem.setProduct_id(rs.getInt("product_id"));
                    orderItem.setOrder_id(rs.getInt("order_id"));
                    orderItem.setQuantity(rs.getInt("quantity"));
                    orderItem.setPrice(rs.getInt("price"));
                    orderItem.setStatus(rs.getString("status"));
                    orderItem.setDate(rs.getString("date"));

                    orderItems.add(orderItem);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orderItems;
    }

    public boolean updateOrderStatus(String status, int orderItem_id) {
        boolean sts = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                String sql = "update order_items set status=?, date=? where id = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, status);
                LocalDate date = LocalDate.now();
                String order_date = date.toString();
                smt.setString(2, order_date);
                smt.setInt(3, orderItem_id);

                smt.executeUpdate();
                cp.putConnection(con);
                sts = true;
                smt.close();

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        return sts;
    }
}
