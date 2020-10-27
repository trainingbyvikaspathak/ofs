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


            <script>
                function getCategory(x, y) {

                    ajax3 = new XMLHttpRequest();
                    ajax3.open("GET", "../ProductController?op=get_cat&weartype_id=" + x, true);
                    ajax3.send();

                    ajax3.onreadystatechange = function () {
                        // alert(x);
                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                        }
                    }
                }
            </script>
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

                                <form class="form">
                                    <center><h3>Products which are Rejected by Admin</h3></center>

                                    <table class="table">
                                        <tr>
                                            <td>Name</td>
                                            <td> Wear Type </td>
                                            <td>Category</td>
                                            <td>Brand </td>
                                            <td>size</td>
                                            <td>Price</td>
                                            <td>Current Status</td>
                                            <td>Action</td>
                                            <td>Image</td>
                                        </tr>
                                    <%
                                        ProductDao pd = new ProductDao();
                                        ArrayList<Product> products = pd.getAllProductByShopkeeperIdAndStatus(shopkeeper.getId(),"rejected");
                                        WeartypeDao wd = new WeartypeDao();
                                        CategoryDao cd = new CategoryDao();
                                        if(products.size()==0)
                                           out.println("<tr><th colspan='9'> <h2>No Rejected products</h2>");

                                        for (Product product : products) {%>
                                    <tr>
                                        <td><%=product.getName()%></td>
                                        <td><%=wd.getWeartypeByProductId(product.getId()).getName()%> </td>
                                        <td><%=cd.getCategoryByProductId(product.getId()).getName()%></td>
                                        <td><%=product.getBrand()%></td>
                                        <td><%=product.getSize()%></td>
                                        <td><%=product.getPrice()%></td>
                                        <td><b> <font color="<%if (product.getStatus().equalsIgnoreCase("pending") || product.getStatus().equalsIgnoreCase("rejected")) {
                                out.println("red");
                            }%>"> <%=product.getStatus()%></td>
                                                <td>   <a href="ViewAndUpdateProduct.jsp?pid=<%=product.getId()%>" class="btn btn-primary"> Edit/Update Details </a>  </td>
                                                <td> <img src="../<%=product.getImage()%>" width="50" height="50" class="img rounded-circle"/></td>

                                    </tr>

                                    <%}%>

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
