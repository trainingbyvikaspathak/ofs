<%-- 
    Document   : shopkeeperhome
    Created on : Oct 4, 2020, 11:47:41 AM
    Author     : Arpit mishra
--%>


<%@page import="com.daos.ProductDao"%>
<%@page import="com.beans.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.daos.ReviewDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.Shopkeeper"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shopkeeper Home</title>
  <link rel="icon" href="shopkeeper/assets/img/admin.ico" type="x/image"/>

  <!-- Custom fonts for this template-->
  <jsp:include page="base.jsp"></jsp:include>
  

</head>

<body id="page-top">


    
    <%    
         Shopkeeper shopkeeper = (Shopkeeper)session.getAttribute("shopkeeper");
       if(shopkeeper==null)
       {
        response.sendRedirect("../login.jsp");
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

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Customers' Reviews and Complains </h1>
            <a href="shopkeeperhome.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
          <table class="table table-striped">
              <tr>
                  <th>Name</th>
                  <th>email</th>
                  <th>Subject</th>
                  <th>Product Name</th>
                  <th>Message</th>
                  <th>Reply Status</th>
                  <th>Action</th>
              </tr>
              <% 
              ReviewDao rd = new ReviewDao();
              ProductDao pd = new ProductDao(); 
              ArrayList<Review> reviews = rd.getAllReviewByShopkeeprId(shopkeeper.getId());
              for(Review review:reviews){%>
              <tr>
                  <td><%=review.getName()%></td>
                  <td><%=review.getEmail()%></td>
                  <td><%=review.getSubject()%></td>
                  <td><%=pd.getById(review.getProduct_id()).getName() %></td>
                  <td><%=review.getMessage()%></td>
                  <td><%=review.getStatus()%></td>
                  <td><% if (review.getStatus().equalsIgnoreCase("not replied")){%> <a href="#">Reply this Customer</a><%}%>    </td>
              </tr>
             <%}%>
          </table>
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
