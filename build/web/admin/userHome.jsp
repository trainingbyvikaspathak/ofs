<%-- 
    Document   : userHome
    Created on : 12-Feb-2020, 15:33:58
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Welcome <%=request.getParameter("name") %> </h2>
        
        <br/><br/>
        <a href="destroy.jsp">Logout</a>
         
    </body>
</html>
