<%-- 
    Document   : viewQueries
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

<%@page import="com.beans.TrackOrder"%>
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
                <form>
                    <h1 class="h3 mb-0 text-gray-800">Enter Order_ID : <input type="text" name="order_id" class="form-control" required="required"/> </h1>
                <input type="submit" value="Submit" name="submit"/>
                </form> 
                <br/>
                Your Recent Orders :  <%
         OrderDao od = new OrderDao();
         ArrayList<Orders> orders = od.getAllOrdersByCustomerId(customer.getId());
         ProductDao pd = new ProductDao();
         AddressDao ad = new AddressDao();
       int i=1;
 for(Orders order : orders) {%> <a href="trackOrder.jsp?order_id=<%=order.getId()%>&submit=Submit">Order<%=i++%></a> &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; <%}%>
        
             </div>
            <table width='700' border='1' cellspacing='0' class="table table-striped">
            <tr>
                <th> Date </th>
                <th> Status </th>
                <th> Description </th>
                <th> Person </th>
            </tr>
        <% if(request.getParameter("submit")!=null){
            int orderid=Integer.parseInt(request.getParameter("order_id"));
            ArrayList<TrackOrder> orderStatus = new OrderDao().getAllOrdersStatus(orderid);
            for(TrackOrder order : orderStatus){ %>
         <tr>
             <td><%=order.getDate() %></td>
             <td><%=order.getStatus()%> </td>
             <td><%=order.getDesc()%></td> 
             <td><%=order.getPerson()%></td>
           </tr>
          
         <% } }%>
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
