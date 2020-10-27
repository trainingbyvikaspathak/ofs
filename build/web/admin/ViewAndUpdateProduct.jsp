<%-- 
    Document   : showNews
    Created on : 8 Mar, 2020, 12:08:28 AM
    Author     : ravi
--%>
<%@page import="com.daos.CategoryDao"%>
<%@page import="com.daos.WeartypeDao"%>
<%@page import="com.daos.ProductDao"%>
<%@page import="com.beans.Product"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>All News</title>

  <jsp:include page="base.jsp"></jsp:include>
</head>

<body id="page-top">
    <%
        if (session.getAttribute("admin")==null){
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

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Product Details </h1>
            
          <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Export News</a>
          </div>

          <div class="row table-responsive">
       
              <form method="post">
              <table class="table">
                 
                      <%
                          int pid = request.getParameter("pid")==null?0:Integer.parseInt(request.getParameter("pid"));
                          ProductDao pd = new ProductDao();
                          Product product = pd.getById(pid); 
                          WeartypeDao wd = new WeartypeDao();
                          CategoryDao cd = new CategoryDao();
                          if(request.getParameter("submit")!=null){
                              product.setStatus(request.getParameter("status"));
                              pd.update(product);
                             // RequestDispatcher rd  = request.getRequestDispatcher("showProducts.jsp");
                             // rd.forward(request, response);
                            response.sendRedirect("showProducts.jsp");
                             // return;
                          }
                          %>
                           <tr> <td>Name</td>   <td><%=product.getName() %></td></tr>
                          <tr>  <td> Wear Type </td><td><%=wd.getWeartypeByProductId(product.getId()).getName()%> </td> </tr>
                          <tr>   <td>Category</td> <td><%=cd.getCategoryByProductId(product.getId()).getName()%></td> </tr>
                          <tr>  <td>Brand </td> <td><%=product.getBrand() %></td> </tr>
                          <tr> <td>size</td> <td><%=product.getSize()%></td> </tr>
                          <tr> <td>Price(MRP) </td> <td><%=product.getPrice() %></td> </tr>
                          <tr> <td>Selling Price</td> <td><%=product.getSelling_price() %></td> </tr>
                          <tr> <td>Current Status</td> <td><b> <font color="<%if(product.getStatus().equalsIgnoreCase("pending") || product.getStatus().equalsIgnoreCase("rejected")) out.println("red");%>"> <%=product.getStatus()%></td> </tr>
                                      <tr> <td>Change Status </td> 
                                                  <td> <select name="status">
                                                          <option value="pending">pending</option>
                                                           <option value="approved">approved</option>
                                                            <option value="rejected">rejected</option>
                                              </select>  </td> 
                                      
                                      </tr>
                                      <tr><td>Image</td>   <td> <img src="../<%=product.getImage()%>" width="250" height="300" class="img rounded-circle"/></td>
                          
                                      <tr>
                                          <th colspan="2"><input type="submit" name="submit" class="form-control btn btn-primary" value="update Status"</th>
                                      </tr>  
              </table>
              </form>
          </div>

          
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

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="logout.jsp">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  
</body>

</html>

