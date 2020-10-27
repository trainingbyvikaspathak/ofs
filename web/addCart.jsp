<%-- 
    Document   : home
    Created on : Apr 7, 2020, 6:28:10 PM
    Author     : Arpit mishra
--%>

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
           
           ProductDao pd = new ProductDao();
           ArrayList<Product> productList = pd.getAllApprovedProduct(); 
            
           int selectedProductId=request.getParameter("pid")!=null? Integer.parseInt(request.getParameter("pid")):-1;
           
           

int quantity =request.getParameter("quantity")!=null? Integer.parseInt(request.getParameter("quantity")):1 ; 

Cart mycart = new Cart();

if (quantity!=0 && selectedProductId!=0){
    Product selectedProduct = pd.getById(selectedProductId);
mycart.setProduct_id(selectedProductId);
mycart.setQuanity(quantity);
mycart.setPrice(selectedProduct.getSelling_price());
mycart.setAmount(selectedProduct.getSelling_price()* quantity);

}

ArrayList<Cart> cart ;
if (session.getAttribute("cart")==null)
    cart =new ArrayList<Cart>();
else{
    cart = (ArrayList)session.getAttribute("cart");
}

boolean exist=false;
for(Cart cc : cart){
    if(selectedProductId!=0)
    {
    if(cc.getProduct_id()==selectedProductId)
    {
        exist=true;
        cc.setQuanity(cc.getQuanity() + quantity );
        cc.setAmount(cc.getQuanity()*pd.getById(selectedProductId).getPrice());
    }
    }
       
}

if(!exist && selectedProductId!=0)
    cart.add(mycart);

session.setAttribute("cart",cart);
String returningURL =request.getHeader("referer");
if(returningURL.contains("?"))
    returningURL += "&info=Added to Cart";
else 
    returningURL += "?info=Added to Cart";
response.sendRedirect(returningURL);
            %>

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
