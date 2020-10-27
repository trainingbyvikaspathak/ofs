/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.Customer;
import com.daos.AddressDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arpit mishra
 */
public class AddressController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
        if (op != null && op.equalsIgnoreCase("add")) {
            HttpSession session = request.getSession();
            Customer customer = (Customer)session.getAttribute("customer");
            //String customer_id = request.getParameter("customer_id");
            System.out.println("cust id: "+customer.getId());
            com.beans.Address address = (com.beans.Address) session.getAttribute("address");
            AddressDao ad = new AddressDao();
            System.out.println("Address:"+address.getName());
            address.setCustomer_id(customer.getId());
            if(ad.add(address)){
               response.sendRedirect("billingAddress.jsp");
                
           }
        }
    

    }

}
