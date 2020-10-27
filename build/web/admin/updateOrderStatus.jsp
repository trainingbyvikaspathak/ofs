<%-- 
    Document   : updateReporter
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

<%@page import="com.beans.Address"%>
<%@page import="com.daos.AddressDao"%>
<%@page import="com.beans.Orders"%>
<%@page import="com.daos.OrderDao"%>
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
            if (session.getAttribute("admin") == null) {
                response.sendRedirect("../login.jsp");
                return;
            }
        %>


        <%-- CODE FOR UPDATION OF STATUS --%>
        <%
            String msg = null;
            if (request.getParameter("submit") != null) {
                String selectedProduct[] = request.getParameterValues("selected");
                if (selectedProduct == null) {
                    response.sendRedirect("updateOrderStatus.jsp?msg=Please select atleast one Checkbox !");
                    return;
                }
                for (String orderid : selectedProduct) {
                    System.out.println("Seller id : " + orderid);
                   // ProductDao pd1 = new ProductDao();
                    String desc = request.getParameter("Status changed by the Admin");
                    String person = "Admin";
                    String status = request.getParameter("status" + orderid);
                    OrderDao od = new OrderDao();
                    od.updateOrderStatus(Integer.parseInt(orderid), desc, status, person);
                    response.sendRedirect("updateOrderStatus.jsp");
                    msg = "Records Updated !!";
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
                            <% if (request.getParameter("msg") != null) {
                    out.println("<script> alert('" + request.getParameter("msg") + "');</script>");
                } %>
                            <table width='700' border='1' cellspacing='0' class="table table-striped">
                                <tr>
                                    <th>Booking(Order) ID </th>
                                    <th> Booking Date </th>
                                    <th> Total Amount </th>
                                    <th> Payment Mode </th>
                                    <th> Delivery Address </th>
                                    <th> Current Status </th>
                                    <th>Operations</th>
                                    <th>Select</th>
                                </tr>
                                <%
                                    ProductDao pd = new ProductDao();
                                    ArrayList<Product> rows = new ArrayList();
                                    CategoryDao cd = new CategoryDao();
                                    ShopkeeperDao sd = new ShopkeeperDao();
                                    rows = pd.getAllNonApprovedProducts();
                                    OrderDao od = new OrderDao();
                                    ArrayList<Orders> orders = od.getAllOrders();
                                    AddressDao ad = new AddressDao();

            for (Orders order : orders) {
                Address address = ad.getById(order.getAddress_id());%>

                                <tr>
                                    <td><%=order.getId()%></td>
                                    <td><a href="orderDetail.jsp?order_id=<%=order.getId()%>"><%=order.getDate()%></a></td>
                                    <td><%=order.getTotal_amount()%></td> 
                                    <td><%=order.getPayment_mode()%></td>
                                    <td><%=address.getAddress()%>, <%=address.getCity()%>, <%=address.getPincode()%><br/>(<%=address.getState()%>)</td>
                                    <td><%=od.getCurrentStatus(order.getId())%></td>
                                    <td><%if (!od.getCurrentStatus(order.getId()).equalsIgnoreCase("delivered") && !od.getCurrentStatus(order.getId()).equalsIgnoreCase("cancelled")) {%> 

                                        <input type="radio" name="status<%=order.getId()%>" value="under processing" <% if (od.getCurrentStatus(order.getId()).equalsIgnoreCase("under processing")) {
                         out.println("checked");
                     }%> />Under Processing
                                        <br/><input type="radio" name="status<%=order.getId()%>" value="Packed" <%  if (od.getCurrentStatus(order.getId()).equalsIgnoreCase("packed")) {
                        out.println("checked");
                    }%>/>Packed
                                        <br/><input type="radio" name="status<%=order.getId()%>" value="Dispatched" <%  if (od.getCurrentStatus(order.getId()).equalsIgnoreCase("dispatched")) {
                        out.println("checked");}%>/>Dispatched
                                        
                                        <br/><input type="radio" name="status<%=order.getId()%>" value="Delivered" <%  if (od.getCurrentStatus(order.getId()).equalsIgnoreCase("Delivered")) {
                        out.println("checked");}%>/>Delivered
                                        <%}%>
                                    </td>
                                    <td><%if (!od.getCurrentStatus(order.getId()).equalsIgnoreCase("delivered") && !od.getCurrentStatus(order.getId()).equalsIgnoreCase("cancelled")) {%> 
                                        <input type="checkbox" name="selected" value="<%=order.getId()%>"/><%}%></td>

                                </tr>

                                <%}%>
                            </table>

                            <br/>

                            <br/><br/>  
                            <center><input type="submit" name="submit" value="submit" class="form-control btn-primary"/></center>
                        </form>       
                        <% if (msg != null) {
        out.println("<script>alert('" + msg + "');</script>");
    }%>
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
