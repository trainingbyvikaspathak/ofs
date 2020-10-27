<%-- 
    Document   : updateReporter
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

<%@page import="com.daos.CategoryDao"%>
<%@page import="com.beans.Product"%>
<%@page import="com.daos.ProductDao"%>
<%@page import="com.beans.Shopkeeper"%>
<%@page import="com.daos.ShopkeeperDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Status of Reporters</title>
  <link rel="icon" href="assets/img/admin.ico" type="x/image"/>

  <!-- Custom fonts for this template-->
  <jsp:include page="base.jsp"></jsp:include>
  

</head>

<body id="page-top">
    <%
        if (session.getAttribute("admin")==null){
            response.sendRedirect("../login.jsp");
            return;
        }
        %>

        
   <%-- CODE FOR UPDATION OF STATUS --%>
      <%
          String msg=null;
          if (request.getParameter("submit")!=null){ 
               String selectedProduct[] = request.getParameterValues("selected"); 
               if(selectedProduct==null){
                   response.sendRedirect("updateProducts.jsp?msg=Please select atleast one Checkbox !");
                   return;
               }
               for(String productId : selectedProduct){
                   System.out.println("Seller id : " +  productId);
                   ProductDao pd1 = new ProductDao();
                   Product product1 = pd1.getById(Integer.parseInt(productId));
                   product1.setStatus(request.getParameter("status"+productId));
                   System.out.println("selected Status : " + product1.getStatus());
                   pd1.update(product1);
                   System.out.println("Record updated ....");
                   msg="Records Updated !!";
               }
               
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
            <h1 class="h3 mb-0 text-gray-800">Status of Products</h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
            <form method="post">
            <% if(request.getParameter("msg")!=null) out.println("<script> alert('" +request.getParameter("msg") +"');</script>"); %>
        <table width='700' border='1' cellspacing='0' class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>MRP</th>
                <th>Selling Cost</th>
                <th>Shop Name </th>
                <th> Current Status</th>
                <th> Image </th>
                <th>Operations</th>
                <th>Select</th>
            </tr>
        <%
            ProductDao pd = new ProductDao();
            ArrayList<Product> rows = new ArrayList();
            CategoryDao cd =new  CategoryDao();
            ShopkeeperDao sd = new ShopkeeperDao();
            rows = pd.getAllNonApprovedProducts();
            for (Product product : rows) {%>
        <tr>
            <td><%=product.getId()%> </td>
            <td><%=product.getName()%></td>
            <td><%=cd.getCategoryByProductId(product.getId()).getName() %> </td>
            <td><%=product.getPrice() %></td>
            <td><%=product.getSelling_price() %> </td>
            <td><%=sd.getById(product.getSeller_id()).getShopName() %> </td>
            <td><%=product.getStatus()%> </td>
            <td><img src="../<%=product.getImage()%>" style="width:60px; height: 60px;"></td>
            <td><input type="radio" name="status<%=product.getId()%>" value="approved" <% if (product.getStatus().equalsIgnoreCase("approved")) out.println("checked");%> />Approved
                <br/><input type="radio" name="status<%=product.getId()%>" value="rejected" <% if (product.getStatus().equalsIgnoreCase("rejected")) out.println("checked");%>/>Rejected
            </td>
            <td><input type="checkbox" name="selected" value="<%=product.getId()%>"/></td>
            
        </tr>

        <%}%>
    </table>
            
    <br/>
     
    <br/><br/>  
   <center><input type="submit" name="submit" value="submit" class="form-control btn-primary"/></center>
            </form>       
<% if (msg!=null) out.println("<script>alert('"+msg+"');</script>");%>
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
