/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.Customer;
import com.daos.CustomerDao;
import com.utilities.FileUploader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Arpit mishra
 */
public class CustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op = request.getParameter("op");
        
        if (op != null && op.equalsIgnoreCase("check_userid")) {
           out.println(op);System.out.println(op);
            String userid = request.getParameter("userid");
            CustomerDao cd = new CustomerDao();
            if (userid == null || userid.equals("")) {
                out.println("<font size='4'>Please provide Userid</font>");
                return;
            }
            if (cd.isUserIdExist(userid)) {
                out.println("<font color='red' size='4'>Sorry This Userid already exist!!!</font>");
            } else {
                out.println("<font color='blue' size='4'>Congratulations! This Userid is available!!!</font>");
            }
        }
        
        if (op != null && op.equalsIgnoreCase("check_email")) {
            String email = request.getParameter("email");
            CustomerDao cd = new CustomerDao();
            if (email == null || email.equals("")) {
                out.println("<font size='4'>Please provide Email</font>");
                return;
            }
            if (cd.isEmailExist(email)) {
                out.println("<font color='red' size='4'>Sorry This Email already exist!!!</font>");
            } else {
                out.println("<font color='blue' size='4'>Congratulations! This Email is not registered!!!</font>");
            }
            
        }
        
        if (op != null && op.equalsIgnoreCase("check_mobile")) {
            String mobile = request.getParameter("mobile");
            CustomerDao cd = new CustomerDao();
            if (mobile == null || mobile.equals("")) {
                out.println("<font size='4'>Please provide Mobile no</font>");
                return;
            }
            if (cd.isMobileExist(mobile)) {
                out.println("<font color='red' size='4'>Sorry This Mobile no already exist!!!</font>");
            } else {
                out.println("<font color='blue' size='4'>Congratulations! This Mobile no is not registered!!!</font>");
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op = request.getParameter("op");

        if (op != null && op.equalsIgnoreCase("add")) {
            //System.out.println("CustomerComtroller");
            
            
             try {
                //check the enctype of the incomming request -
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                String encodedPassword = "";
                String photo = "", imagePath = "";
                if (isMultipart) {
                    imagePath = FileUploader.getUploadedPath(getServletContext(), "media/customer", request);
                }
          
            
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            customer.setImage(imagePath);
            CustomerDao cd = new CustomerDao();
            System.out.println("customer:"+customer.getName());
            
                
            if(cd.add(customer)){
                out.println("Now! You are registered");
                session.removeAttribute("customer");
            }
               }
                catch(Exception e){}
//JDBC Code 
    }


    
    }
}
