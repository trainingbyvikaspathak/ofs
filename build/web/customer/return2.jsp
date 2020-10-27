<%-- 
    Document   : viewQueries
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.beans.Product"%>
<%@page import="com.beans.Cart"%>
<%@page import="com.beans.Address"%>
<%@page import="com.daos.AddressDao"%>
<%@page import="com.daos.ProductDao"%>
<%@page import="com.beans.Orders"%>
<%@page import="com.beans.Customer"%>
<%@page import="com.sun.xml.ws.rx.rm.policy.metro200603.OrderedDeliveryAssertion"%>
<%@page import="com.daos.OrderDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.Queries,com.daos.QueryDao, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>All Queries</title>
 <link rel="icon" href="assets/img/admin.ico" type="x/image"/>
  <!-- Custom fonts for this template-->
  <jsp:include page="base.jsp"></jsp:include>
  

</head>

<body id="page-top">
    <%
        Customer customer = (Customer)session.getAttribute("customer");
        if (customer==null){
            response.sendRedirect("../login.jsp");
            return;
        }
        %>

        <script>
        function makeConfirm(){
            if(confirm("do you want to cancel order ?"))
                return true;
            else
                return false;
        }
        </script>
  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
  <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
      <jsp:include page="topbar.jsp"></jsp:include>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">
            <div class="d-sm-flex align-items-center justify-content-between mb-4">
              <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
            <h3>Order Details :</h3>
            <form method="post">
            <table class="table col">
                                         
                                            <tr>
                                                <th><h4>Product Image</h4></th>
                                                <th><h4>Name</h4></th>
                                                <th><h4>Price</h4></th>
                                                <th><h4>Quantity</h4></th>
                                                <th><h4>Size</h4></th>
                                                <th><h4>Amount</h4></th>
                                                <th>Return </th>
                                            </tr>
                                        
                                    <%
                                        int orderId  = Integer.parseInt(request.getParameter("order_id"));
                                        float total=0;
                                        OrderDao od = new OrderDao();
                                        ArrayList<Cart> cart = od.getOrderDetails(orderId);
                                        ProductDao pd = new ProductDao();
                                        //System.out.println("hello.....");
                                        System.out.println("cart size : "+ cart.size());
                                        
                                         if(request.getParameter("submit")!=null){
                                        String date = java.time.LocalDate.now().toString(); 
                                        int orderid = Integer.parseInt(request.getParameter("order_id")); 
                                        int cid = Integer.parseInt(request.getParameter("customer_id"));
                                        int aid = Integer.parseInt(request.getParameter("address_id"));
                                        String rprods[] = request.getParameterValues("return");
                                        for(String product_id : rprods){
                                            int pid = Integer.parseInt(product_id);
                                            String status ="Request for Returning product";
                                            od.addReturningRequest(orderid, pid, date, cid, aid, status);
                                            System.out.println("Returned...");
                                            //ProductDao pdd = new ProductDao();
                                            pd.AddStock(pid, Integer.parseInt(request.getParameter("quantity")));
                                        }
                                        
                                            } 
                                        
                                        int i = 0;
                                        for (Cart c : cart) {
                                            Product product = pd.getById(c.getProduct_id());
                                            System.out.println("one....");
                                        
                                    %>
                                    <tbody>
                                        <tr>
                                            <td class="product-col">
                                                <img src="../<%=product.getImage()%>" alt="" class="img-thumbnail" width="100" height="100">
                                                <input type="hidden" name="order_id" value="<%=orderId%>"/>
                                                 <input type="hidden" name="customer_id" value="<%=customer.getId()%>"/>
                                                <input type="hidden" name="address_id" value="<%=od.getById(orderId).getAddress_id()%>"/><% System.out.println("Two...");%>
                                           
                                           
                                                
                                                <input type="hidden" name="product_id" value="<%=product.getId()%>"/>
                                            </td>
                                             <td>
                                                  <h4><%=product.getName()%></h4>
                                            </td>
                                            <td> 
                                                <h4> &#x20B9; <%=product.getSelling_price()%> </h4>
                                                
                                            </td>
                                            <td>
                                              <%=c.getQuanity()%>
                                              <input type="hidden" value="<%=c.getQuanity()%>" name="quantity"/>
                                             </td>
                                            <td><h4>Size <%=product.getSize()%></h4></td>
                                            <td><h4>&#x20B9; <%=c.getAmount()%></h4></td>
                                            <td> <% if (od.isReturned(orderId, product.getId())){out.println("<b>Already Returned</b>");}else {%>  <input type="checkbox" name="return" value="<%=product.getId()%>"/>Return this<%}%></td>
                                            </tr>
                                        <% total += c.getAmount();i++;}%>
                                    </tbody>
                                    <tr>
                                        <th colspan="7"><input type="submit" class="form-control btn btn-primary" name="submit" value="Proceed"/></th>
                                    </tr>
                                </table>
            </form>
                                    <h4>Total Billing Amount : &#x20B9;<%=total%></h4>
        </div>
                                   
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <jsp:include page="footer.jsp"></jsp:include>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->
</body>

</html>
