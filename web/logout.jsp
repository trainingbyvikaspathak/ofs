<%-- 
    Document   : logout
    Created on : Apr 17, 2020, 6:24:19 PM
    Author     : Arpit mishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.removeAttribute("customer");
    response.sendRedirect("home.jsp");
%>
