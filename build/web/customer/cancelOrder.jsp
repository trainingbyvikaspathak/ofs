<%-- 
    Document   : viewQueries
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

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
            <h1 class="h3 mb-0 text-gray-800">Your Order History : </h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
            <h3>Order Cancellation :</h3>
            <form class="form" method="post" onsubmit="return makeConfirm();">
                <input type="text" name="order_id" value="<%=request.getParameter("order_id")%>" readonly class="form-control"/> 
            <br/>
            Give Reason for cancellation : <br/>
            <textarea name="description" class="form-control" rows="5" cols="30"></textarea> <br/>
            <input type="submit" class="btn btn-primary" value="Cancel this  order" name="submit"/>
            </form>
        <%
            if(request.getParameter("submit")!=null){
             int orderId  = Integer.parseInt(request.getParameter("order_id"));
             String desc = request.getParameter("description");
             String person = "customer";
             String status = "cancelled";
             OrderDao od = new OrderDao();
             od.updateOrderStatus(orderId, desc, status, person);
             response.sendRedirect("viewBooked.jsp");
            }
           %>
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
