/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.Category;
import com.daos.CategoryDao;
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
public class CategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String op = request.getParameter("op");
        System.out.println("hello");
        if (op != null && op.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            CategoryDao cd = new CategoryDao();
            if (cd.removeById(id)) {
                response.sendRedirect("admin/allCategories.jsp");
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
            CategoryDao cd = new CategoryDao();
            if(cd.add(name)){
                out.println("A new Category is added");
            }
        }
        
        if (op != null && op.equalsIgnoreCase("update")) {
            String name = request.getParameter("name");
            System.out.println("catName:- "+name);
            CategoryDao cd = new CategoryDao();
            HttpSession session = request.getSession();
            Category category = (Category) session.getAttribute("category1");
            category.setName(name);
            System.out.println("name:"+category.getName());
            
            if(cd.update(category)){
                out.println("Record updated");
                session.removeAttribute("category1");
            }
        }
     }

}
