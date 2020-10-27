/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.WearType;
import com.daos.WeartypeDao;
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
public class WeartypeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String op = request.getParameter("op");
        System.out.println("hello");
        if (op != null && op.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            WeartypeDao wd = new WeartypeDao();
            if (wd.removeById(id)) {
                response.sendRedirect("admin/allWeartypes.jsp");
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
            String name = request.getParameter("name");
            WeartypeDao wd = new WeartypeDao();
            if (wd.add(name)) {
                out.println("Weartype added");
            }
        }
        
        if (op != null && op.equalsIgnoreCase("update")) {
            String name = request.getParameter("name");
            System.out.println("catName:- "+name);
            WeartypeDao wd = new WeartypeDao();
            HttpSession session = request.getSession();
            WearType wear = (WearType) session.getAttribute("weartype1");
            wear.setName(name);
            System.out.println("name:"+wear.getName());
            
            if(wd.update(wear)){
                out.println("Record updated");
                session.removeAttribute("weartype1");
                
            }
        }
     
    }
}
