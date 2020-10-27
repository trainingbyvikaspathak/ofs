<%-- 
    Document   : viewQueries
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

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
        if (session.getAttribute("customer")==null){
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
            <h1 class="h3 mb-0 text-gray-800">Replies from shop keepers (Sellers) </h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
        <table width='700' border='1' cellspacing='0' class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Shop Keeper Name</th>
                <th>Shop Name </th>
                <th>Message</th>
                
            </tr>
         
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
