package com.controllers;

import com.beans.Cart;
import com.beans.Customer;
import com.beans.Product;
import com.daos.CartDao;
import com.daos.OrderDao;
import com.daos.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        String mode = request.getParameter("payment");
        
        
        
        
        HttpSession session = request.getSession();
        System.out.println("op:" + op);
        
        //adding order and payment by customer
        if (op.equalsIgnoreCase("addOrder")) {
            Customer customer = (Customer) session.getAttribute("customer");
            int address_id = Integer.parseInt(request.getParameter("address_id"));
            //    Product product = (Product) session.getAttribute("product");
            ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart");
            System.out.println("cid:" + customer.getId());
            //   System.out.println("pid:"+product.getId());
            System.out.println("cartList:" + cartList);
            OrderDao od = new OrderDao();
            LocalDate date = LocalDate.now();
            String order_date = date.toString();
            String status = "pending";
            String details = "your order has been recieved";
           /*if (od.addOrder(customer.getId(), order_date, address_id)) {
                int order_id = od.getOrderId();
                for (Cart cart : cartList) {
                    int pid = cart.getProduct_id();
                    ProductDao pd = new ProductDao();
                    Product product = pd.getById(pid);

                    if (od.addOrderItems(customer, cart, product, mode, order_id, status)) {
                        System.out.println("ordered successfully!");
                        CartDao cd = new CartDao();
                        if (cd.removeByProductId(pid)) {
                            System.out.println("removed from cart");
                        }
                    }
                }
            }
            response.sendRedirect("home.jsp"); */
        }
      
        
        //from admin section confirming order
        if(op.equalsIgnoreCase("confirmOrder")){
            System.out.println("Welcome");
            int orderItem_id = Integer.parseInt(request.getParameter("orderId"));
            OrderDao od = new OrderDao();
            String status = "confirmed";
            if(od.updateOrderStatus(status, orderItem_id)){
                response.sendRedirect("admin/pendingOrders.jsp");
            }
        }
        
        //changing status to delivered by Admin
        if(op.equalsIgnoreCase("deliverOrder")){
            System.out.println("Welcome");
            int orderItem_id = Integer.parseInt(request.getParameter("orderId"));
            OrderDao od = new OrderDao();
            String status = "delivered";
            if(od.updateOrderStatus(status, orderItem_id)){
                response.sendRedirect("admin/confirmedOrders.jsp");
            }
        }
    }

}
