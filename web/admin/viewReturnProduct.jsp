<%-- 
    Document   : viewQueries
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

<%@page import="com.beans.Shopkeeper"%>
<%@page import="com.daos.ShopkeeperDao"%>
<%@page import="com.daos.CustomerDao"%>
<%@page import="com.beans.ReturnProduct"%>
<%@page import="com.beans.Admin"%>
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
        Admin admin = (Admin)session.getAttribute("admin");
        if (admin==null){
            response.sendRedirect("../login.jsp");
            return;
        }
        %>

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
            <h1 class="h3 mb-0 text-gray-800">Returned Product : </h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
        <table width='700' border='1' cellspacing='0' class="table table-striped">
            <tr>
                <th>Booking(Order) ID </th>
                <th>Order Details</th>
                <th> Product Name </th>
                <th> Quantity </th>
                <th> Date </th>
                <th> Customer </th>
                <th> Customer's Address </th>
                <th> Current Status </th>
                <th>Seller's Details</th>
                
            </tr>
         <%
         OrderDao od = new OrderDao();
         ArrayList<ReturnProduct> orders = od.getAllReturn_product();
         ProductDao pd = new ProductDao();
         AddressDao ad = new AddressDao();
         Customer customer = new Customer();
         ShopkeeperDao sd = new ShopkeeperDao(); 
         for(ReturnProduct rp : orders) {   Address address = ad.getById(rp.getAddress_id()); %>
         
         <tr>
             <td><%=rp.getId()%></td>
             <td><a href="orderDetail.jsp?order_id=<%=rp.getId()%>">Order Details</a></td>
             <td><%=pd.getById(rp.getProduct_id()).getName() %></td> 
             <td><%=rp.getQuantity()%></td>
             <td><%=rp.getDate() %></td>
             <td><%=new CustomerDao().getById(rp.getCustomer_id()).getName() %></td>
             <td><%=address.getAddress()%>, <%=address.getCity()%>, <%=address.getPincode()%><br/>(<%=address.getState()%>)</td>
             <td><%=rp.getStatus()%></td>
             <td><%Shopkeeper sk = sd.getByProductId(rp.getProduct_id());%>
                 <%=sk.getShopName()%> <br/> <%=sk.getAddress()%>,PIN:(<%=sk.getPin()%>)<br/> Contact :<%=sk.getContact()%>
             </td>
                 </tr>
         <% } %>
    </table>
    <br/>
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
