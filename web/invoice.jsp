<%-- 
    Document   : home
    Created on : Apr 7, 2020, 6:28:10 PM
    Author     : Arpit mishra
--%>

<%@page import="com.daos.OrderDao"%>
<%@page import="com.beans.Orders"%>
<%@page import="com.daos.ProductDao"%>
<%@page import="com.beans.Cart"%>
<%@page import="com.beans.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.beans.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Fashion store | E-Commerce </title>
        <title> Home </title>
        <link rel="icon" href="./img/favicon.ico" type="x/image"/>
        <meta charset="UTF-8">
        <jsp:include page="base.jsp"></jsp:include>
         </head>
        <body>
          <%
           Customer customer = (Customer) session.getAttribute("customer");
           if (customer==null){
               response.sendRedirect("login.jsp"); 
               return; 
           }
           
        %>
            <!-- Page Preloder -->
            <div id="preloder">
                <div class="loader"></div>
            </div>

            <!-- Header section -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Header section -->



            <!-- Hero section -->
        
            <!-- sidebar section -->
            <!-- <!--jsp:include page="sidebar.jsp"><--/jsp:include--> 
             
            Details of product :
        <jsp:useBean class="com.beans.Orders" id="order" scope="session"></jsp:useBean>
        <jsp:setProperty name="order" property="*"></jsp:setProperty>

        
        <%
           ArrayList<Cart> orderDetails = (ArrayList) session.getAttribute("cart"); 
         Orders order1 = (Orders) session.getAttribute("order"); 
         System.out.println("Order : " + order1);
         OrderDao od = new OrderDao();
         ProductDao pd= new ProductDao();
         
        int order_id =  od.addOrder(order1);
        if (order_id!=0)
            if(od.addOrderDetails(order_id, orderDetails)){%>
            
            <h3>Your Order has been Booked <br/> please one the following order id for future reference : <%=order_id%> <br/> </h3>
            <hr/>
            <b>This order Contains : </b>
            <table class="table">
                <tr>
                <th>Product</th>
                <th>Quantity</th>
                </tr>
                <%int total=0; for(Cart cart : (ArrayList<Cart>)session.getAttribute("cart")){%>
                <tr><td><%=new ProductDao().getById(cart.getProduct_id()).getName() %></td>
                    <td><%=cart.getQuanity()%></td>
                </tr> <%total+=cart.getAmount();    
                pd.subtractStock(cart.getProduct_id(), cart.getQuanity());
                 }%>
                <tr>
                    <th colspan="2"><b>Total Amount :<%=total%> </th>
                </tr>
            </table>
                 <%session.removeAttribute("cart"); }%>
        
            <!-- Footer section -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer section end -->



        <!--====== Javascripts & Jquery ======-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.slicknav.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/main.js"></script>



    </body>
</html>
