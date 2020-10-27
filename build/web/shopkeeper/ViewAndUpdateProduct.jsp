<%@page import="com.beans.Shopkeeper"%>
<%@page import= "com.beans.Product, com.beans.Category, com.beans.WearType, 
        com.daos.ProductDao, com.daos.CategoryDao, com.daos.WeartypeDao, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="au theme template">
        <meta name="author" content="Hau Nguyen">
        <meta name="keywords" content="au theme template">

        <!-- Title Page-->
        <title>Add Product</title>

        <jsp:include page="base.jsp"></jsp:include>
        </head>

        <body id="page-top">
        <%
            Shopkeeper shopkeeper = (Shopkeeper) session.getAttribute("shopkeeper");
            if (shopkeeper == null) {
                response.sendRedirect("../login.jsp");
                return;
            }
            System.out.println("shopkeepr id : " + shopkeeper.getId());
        %>


        <div id="wrapper">
            <!-- MENU SIDEBAR-->
            <jsp:include page="sidebar.jsp"></jsp:include>
                <!-- END MENU SIDEBAR-->
                <div id="content-wrapper" class="d-flex flex-column">

                    <!-- PAGE CONTAINER-->
                    <div id="idcontent">
                        <!-- HEADER DESKTOP-->
                    <jsp:include page="topbar.jsp"></jsp:include>

                        <!-- END HEADER DESKTOP-->


                        <!-- Main Section -->
                        <div class="container-fluid">


                            <div class="col col-md-12">

                                <form method="post" action="SaveProduct.jsp">
                                    <table class="table">
                                    <%
                                        int pid = request.getParameter("pid") == null ? 0 : Integer.parseInt(request.getParameter("pid"));
                                        ProductDao pd = new ProductDao();
                                        Product product = pd.getById(pid);
                                        WeartypeDao wd = new WeartypeDao();
                                        CategoryDao cd = new CategoryDao();
                                    %>
                                    <tr> <td>Name</td>   <td><input type="text" value="<%=product.getName()%>" name="name" class="form-control"/>
                                            <input type="hidden" name="pid" value="<%=product.getId()%>"/>
                                        </td></tr>
                                    <tr>  <td> Wear Type </td><td><select name="weartype_id" class="form-control">
                                            <%for (WearType wear : wd.getAllWeartype()) {%> 
                                            <option value="<%=wear.getId()%>" <%if (wear.getId() == wd.getWeartypeByProductId(product.getId()).getId()) {
                                                    out.println(" selected");
                                                }%>><%=wear.getName()%></option>
                                                <%}%>
                                            </select>
                                        </td> </tr>
                                    <tr>  <td>Category</td> <td>
                                            <select name="category_id" class="form-control">
                                                    <%for (Category category : cd.getAllCategory()) {%>
                                                    <option value="<%=category.getId()%>" <%if (category.getId() == cd.getCategoryByProductId(product.getId()).getId()) {
                                                            out.println(" selected");
                                                        }%>><%=category.getName()%>
                                                    <%}%>
                                            </select>
                                    <tr>  <td>Brand </td> <td><input type="text" name="brand" value="<%=product.getBrand()%>" class="form-control"></td> </tr>
                                    <tr> <td>size</td> <td><input type="text" name="size" value="<%=product.getSize()%>"class="form-control"/></td> </tr>
                                    <tr> <td>Price(MRP) </td> <td><input type="text" name="price" value="<%=product.getPrice()%>" class="form-control"/></td> </tr>
                                    <tr> <td>Selling Price</td> <td><input type="text" name="selling_price" value="<%=product.getSelling_price()%>" class="form-control"/></td> </tr>
                                    <tr> <td>Color</td> <td><input type="text" name="color" value="<%=product.getColor()%>" class="form-control"/></td> </tr>
                                    <tr> <td>Stock in Hand</td> <td><input type="text" name="stock" value="<%=product.getStock()%>" class="form-control"/></td> </tr>
                                    <tr> <td>Description </td> <td><input type="text" name="description" value="<%=product.getDescription()%>" class="form-control"/></td> </tr>

                                                                               <tr> <td>Current Status</td> <td><b> <font color="<%if (product.getStatus().equalsIgnoreCase("pending") || product.getStatus().equalsIgnoreCase("rejected")) {
                                              out.println("red");
                                          }%>"> <%=product.getStatus()%></td> </tr>

                                                <tr><td>Image</td>   <th>
                                                        <b>Current Image of Product</b><br/>
                                                        <img src="../<%=product.getImage()%>" width="250" height="300" class="img img-profile" style="float:left"/>
                                                        <br/><br/><br/> <br/><br/>  
                                                        <input type="submit" value="Change image" class="btn btn-success" name="submit2"/>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <td colspan="2">    
                                                        <input type="submit1" value="update without changing image" class="btn btn-primary form-control" name="submit"/>
                                                    </td>
                                                </tr>
                                </table>
                            </form>
                        </div>

                        <div class="col-md-12">

                        </div>
                    </div>
                </div>



                <!-- End Main Section -->

                <!-- Footer -->
                <jsp:include page="footer.jsp"></jsp:include>
                <!-- End Footer -->
            </div>>
            <!-- END PAGE CONTAINER-->
        </div>


        <!-- Jquery JS-->
        <script src="vendor/jquery-3.2.1.min.js"></script>
        <!-- Bootstrap JS-->
        <script src="vendor/bootstrap-4.1/popper.min.js"></script>
        <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
        <!-- Vendor JS       -->
        <script src="vendor/slick/slick.min.js">
        </script>
        <script src="vendor/wow/wow.min.js"></script>
        <script src="vendor/animsition/animsition.min.js"></script>
        <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
        </script>
        <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
        <script src="vendor/counter-up/jquery.counterup.min.js">
        </script>
        <script src="vendor/circle-progress/circle-progress.min.js"></script>
        <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="vendor/chartjs/Chart.bundle.min.js"></script>
        <script src="vendor/select2/select2.min.js">
        </script>
        <script src="vendor/vector-map/jquery.vmap.js"></script>
        <script src="vendor/vector-map/jquery.vmap.min.js"></script>
        <script src="vendor/vector-map/jquery.vmap.sampledata.js"></script>
        <script src="vendor/vector-map/jquery.vmap.world.js"></script>

        <!-- Main JS-->
        <script src="js/main.js"></script>

    </body>

</html>
<!-- end document-->
