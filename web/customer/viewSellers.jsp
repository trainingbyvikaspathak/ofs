<%-- 
    Document   : viewReporter
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.*, com.daos.*, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>List of Reporters</title>
        <link rel="icon" href="assets/img/admin.ico" type="x/image"/>

        <!-- Custom fonts for this template-->
        <jsp:include page="base.jsp"></jsp:include>
            <script>
                function submitForm() {
                    document.getElementById("form1").submit();
                }

            </script>
        </head>

        <body id="page-top">
        <%
            if (session.getAttribute("admin") == null) {
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
                            <form id="form1">
                                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                                    <h1 class="h3 mb-0 text-gray-800">List of Sellers/Shopkeepers</h1>
                                   <select onchange="submitForm();" name="filter" id="filter" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">  
                                        <option value="" selected>All</option>
                                        <option value="approved" ${param.filter=="approved"? "selected": ""}>Approved</option>
                                        <option value="rejected" ${param.filter=="rejected"? "selected": ""}>Rejected</option>
                                        <option value="pending" ${param.filter=="pending"? "selected": ""}>Pending</option>
                                    </select>
                                </div>
                                <table width='700' border='1' cellspacing='0' class="table table-striped">
                                    <tr>
                                        <th>ID</th>
                                        <th>Shop Name</th>
                                        <th>contact Person</th>
                                        <th>RN</th>
                                        <th>Address</th>
                                        <th>PIN</th>
                                        <th>Contact</th>
                                        <th>Email </th>
                                        <th>Status</th>
                                        <th>Image</th>
                                    </tr>
                                <%
                                    ShopkeeperDao sd = new ShopkeeperDao();
                                    ArrayList<Shopkeeper> rows = new ArrayList();
                                    String op = request.getParameter("filter");
                                    System.out.println("op:" + op);
                                    if (op == null || op.equals("") || op.equals("-1")) {
                                      rows = sd.getAllRecords();
                                    } else  {
                                        System.out.println("====");
                                        rows =sd.getAllRecordsByStatus(op);
                                        System.out.println("rows:" + rows.size());
                                    }
                                    int start = request.getParameter("start") != null ? Integer.parseInt(request.getParameter("start")) : 0;
                                    int end = 3;
                                    int total = rows.size(); 
                                    ArrayList<Shopkeeper> rows1;
                                    rows1 = sd.getRecordsByLimit(rows, start, end);

                                    for (Shopkeeper shopkeeper : rows1) {%>
                                <tr>
                                    <td><%=shopkeeper.getId()%> </td>
                                    <td><%=shopkeeper.getShopName() %> </td>
                                    <td><%=shopkeeper.getName()%> </td>
                                    <td><%=shopkeeper.getRN()%> </td>
                                    <td><%=shopkeeper.getAddress()%></td>
                                    <td><%=shopkeeper.getPin()%> </td>
                                    <td><%=shopkeeper.getContact()%> </td>
                                    <td><%=shopkeeper.getEmail()%></td>
                                    <td><%=shopkeeper.getStatus()%> </td>
                                    <td><img src="../<%=shopkeeper.getImage()%>" style="width:60px; height: 60px;"></td>
                                </tr>

                                <%}
                                %>

                            </table>
                            <br/>
                            <span style="float:left"><a href="viewSellers.jsp?start=<%=start - end%>" class="btn btn-primary <%if (start == 0) {
                                         out.println("disabled");
                                     }%>">Previous</a></span>
                                 <center>
                                     <%
                                         int pages = total / end + (total % end == 0 ? 0 : 1);
                                         for (int i = 0; i < pages; i++) {%>
                                     <span style="text-decoration: none; align-content: center;  <% if (Math.floor(start / end) == i) {
                                             out.println("background-color: orange");
                                     }%>" class="btn btn-dark"><a href="viewSellers.jsp?start=<%=end * i%>"><%=i + 1%></a></span> 
                                         <%}
                                         %>
                                         <span style="float:right"><a href="viewSellers.jsp?start=<%=start + end%>" class="btn btn-primary <% if (start + end >= total) {
                                             out.println(" disabled");
                                         }%>">Next</a></span>

                            </center> 
                            <br/><br/>  --%>
                            <a href='addReporter.jsp' class="btn btn-primary"><i class="fa fa-plus-square" aria-hidden="true"></i>Add More Reporters</a>

                        </form>
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
