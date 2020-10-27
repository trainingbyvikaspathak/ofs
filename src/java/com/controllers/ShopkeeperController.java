/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.Shopkeeper;
import com.daos.ShopkeeperDao;
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
public class ShopkeeperController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op = request.getParameter("op");
        
        if (op != null && op.equalsIgnoreCase("check_userid")) {
           out.println(op);System.out.println(op);
            String userid = request.getParameter("userid");
            ShopkeeperDao cd = new ShopkeeperDao();
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
            ShopkeeperDao cd = new ShopkeeperDao();
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
        
        if (op != null && op.equalsIgnoreCase("check_contact")) {
            String contact = request.getParameter("contact");
            ShopkeeperDao cd = new ShopkeeperDao();
            if (contact == null || contact.equals("")) {
                out.println("<font size='4'>Please provide Mobile no</font>");
                return;
            }
            if (cd.isContactExist(contact)) {
                out.println("<font color='red' size='4'>Sorry This Mobile no already exist!!!</font>");
            } else {
                out.println("<font color='blue' size='4'>Congratulations! This Mobile no is not registered!!!</font>");
            }
        }
         if (op != null && op.equalsIgnoreCase("check_RN")) {
             
            String RN = request.getParameter("RN");
            ShopkeeperDao cd = new ShopkeeperDao();
            if (RN == null || RN.equals("")) {
                out.println("<font size='4'>Please provide Email</font>");
                return;
            }
            if (cd.isShopExist(RN)) {
                out.println("<font color='red' size='4'>Sorry This Shop already exist!!!</font>");
            } else {
                out.println("<font color='blue' size='4'>Congratulations! This Shop is not registered!!!</font>");
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
                    imagePath = FileUploader.getUploadedPath(getServletContext(), "shopkeeper/media", request);
                }
          
            
            HttpSession session = request.getSession();
            Shopkeeper shopkeeper = (Shopkeeper) session.getAttribute("shopkeeper");
            shopkeeper.setImage(imagePath);
            ShopkeeperDao cd = new ShopkeeperDao();
            System.out.println("shopkeeper:"+shopkeeper.getName());
            
                
            if(cd.add(shopkeeper)){
                out.println("Now! You are registered");
                session.removeAttribute("shopkeeper");
            }
               }
                catch(Exception e){}
//JDBC Code 
    }


    
    }
}
