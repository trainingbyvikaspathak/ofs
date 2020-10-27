<%-- 
    Document   : updateReporter
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

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
               String selectedSellers[] = request.getParameterValues("selected"); 
               if(selectedSellers==null){
                   response.sendRedirect("updateSeller.jsp?msg=Please select atleast one Checkbox !");
                   return;
               }
               for(String sellerId : selectedSellers){
                   System.out.println("Seller id : " + sellerId);
                   ShopkeeperDao sd1 = new ShopkeeperDao();
                   Shopkeeper shopkeeper1 = sd1.getById(Integer.parseInt(sellerId));
                   shopkeeper1.setStatus(request.getParameter("status"+sellerId));
                   System.out.println("selected Status : " + shopkeeper1.getStatus());
                   sd1.update(shopkeeper1);
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
            <h1 class="h3 mb-0 text-gray-800">Status of Reporters</h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
            <form method="post">
            <% if(request.getParameter("msg")!=null) out.println("<script> alert('" +request.getParameter("msg") +"');</script>"); %>
        <table width='700' border='1' cellspacing='0' class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Shop Name</th>
                <th>Contact Person</th>
                <th>UserId</th>
                <th>Contact</th>
                <th>Email </th>
                <th>Status</th>
                <th>Image</th>
                <th>Operations</th>
                <th>Select</th>
            </tr>
        <%
            ShopkeeperDao sd = new ShopkeeperDao();
            ArrayList<Shopkeeper> rows = new ArrayList();

            int start = request.getParameter("start") != null ? Integer.parseInt(request.getParameter("start")) : 0;
            int end = 3;
            int total = sd.getRecordCount();
            rows = sd.getAllRecords();

            for (Shopkeeper shopkeeper : rows) {%>
        <tr>
            <td><%=shopkeeper.getId()%> </td>
            <td><%=shopkeeper.getShopName()%></td>
            <td><%=shopkeeper.getName()%> </td>
            <td><%=shopkeeper.getUserid()%></td>
            <td><%=shopkeeper.getContact()%> </td>
            <td><%=shopkeeper.getEmail()%> </td>
            <td><%=shopkeeper.getStatus()%> </td>
            <td><img src="../<%=shopkeeper.getImage()%>" style="width:60px; height: 60px;"></td>
            <td><input type="radio" name="status<%=shopkeeper.getId()%>" value="approved" <% if (shopkeeper.getStatus().equalsIgnoreCase("approved")) out.println("checked");%> />Approved
                <br/><input type="radio" name="status<%=shopkeeper.getId()%>" value="rejected" <% if (shopkeeper.getStatus().equalsIgnoreCase("rejected")) out.println("checked");%>/>Rejected
                <br/><input type="radio" name="status<%=shopkeeper.getId()%>" value="pending" <% if (shopkeeper.getStatus().equalsIgnoreCase("pending")) out.println("checked");%>/>Pending
            </td>
            <td><input type="checkbox" name="selected" value="<%=shopkeeper.getId()%>"/></td>
            
        </tr>

        <%}%>
    </table>
            
    <br/>
   <span style="float:left"><a href="statusReporter.jsp?start=<%=start - end%>" class="btn btn-primary <%if (start == 0) {
            out.println("disabled");
        }%>">Previous</a></span>
    <center>
        <%
            int pages = total / end + (total % end == 0 ? 0 : 1);
            for (int i = 0; i < pages; i++) {%>
        <span style="text-decoration: none; align-content: center;  <% if (Math.floor(start / end) == i) {
               out.println("background-color: orange");
            }%>" class="btn btn-dark"><a href="updateSeller.jsp?start=<%=end * i%>"><%=i + 1%></a></span> 
        <%}
        %>
        <span style="float:right"><a href="updateSeller.jsp?start=<%=start + end%>" class="btn btn-primary <% if (start + end >= total) {
             out.println(" disabled");
         }%>">Next</a></span>

    </center> 
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
