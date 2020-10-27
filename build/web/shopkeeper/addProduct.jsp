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
            }
        %>

        <jsp:useBean class="com.beans.Product" id="product" scope="session"></jsp:useBean>
        <jsp:useBean class="com.beans.WearType" id="weartype" scope="session"></jsp:useBean>
        <jsp:useBean class="com.beans.Category" id="category" scope="session"></jsp:useBean>
        <%
            if (request.getParameter("submit") != null) {
                weartype.setId(Integer.parseInt(request.getParameter("wear")));
                category.setId(Integer.parseInt(request.getParameter("cate")));

        %>
        <jsp:setProperty name="product" property="*"></jsp:setProperty>
        <%}%>
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
                                    <table class="table">
                                        <tr>
                                            <th colspan="2"><center><h2>**Add Product Here** </h2></center></th>
                                        </tr>
                                        <tr>
                                            <th>Enter Product Name </th>
                                            <td><input type="text" name="name" class="form-control" value="${product.name}"/></td>
                                    </tr> 
                                    <tr>
                                        <th>Enter Product Price </th>
                                        <td><input type="text" name="price" class="form-control" value="${product.price}"/></td>
                                    </tr>
                                    <tr>
                                        <th>Enter Product Selling Price </th>
                                        <td><input type="text" name="selling_price" class="form-control" value="${product.price}"/></td>
                                    </tr>
                                    <tr>
                                        <th>Enter Product Size </th>
                                        <td><input type="text" name="size" class="form-control" value="${product.size}"/></td>
                                    </tr> 
                                    <tr>
                                        <th>Enter Product Color </th>
                                        <td><input type="text" name="color" class="form-control" value="${product.color}"/></td>
                                    </tr>
                                    <tr>
                                        <th>Enter Product Brand </th>
                                        <td><input type="text" name="brand" class="form-control" value="${product.brand}"/></td>
                                    </tr> 
                                    <tr>
                                        <th>Enter Product Stock </th>
                                        <td><input type="text" name="stock" class="form-control" value="${product.stock}"/></td>
                                    </tr> 
                                    <tr>
                                        <th>Enter Product Description </th>
                                        <td><input type="text" name="description" class="form-control" value="${product.description}"/></td>
                                    </tr> 
                                    <tr>
                                        <th>Select Wear Type </th>
                                        <td>
                                            <%
                                                WeartypeDao wd = new WeartypeDao();
                                                ArrayList<WearType> weartypes = wd.getAllWeartype();
                                                for (WearType wear : weartypes) {
                                                    System.out.println("wid:" + wear.getId());
                                            %> 
                                            <input type="radio" name="wear" onclick="getCategory(this.value, category);" value="<%=wear.getId()%>" /> <%=wear.getName()%><br/> 
                                            <%}%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Select Category </th>
                                        <td>
                                            <div id="category">

                                            </div>
                                            <%--
                                                CategoryDao cd = new CategoryDao();
                                                ArrayList<Category> categories = cd.getAllCategory();
                                                for (Category cat : categories) {%> 
                                            <input type="radio" name="cate" value="<%=cat.getId()%>" /> <%=cat.getName()%><br/> 
                                            --%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th colspan="2"><center><button name="submit" type="submit" class="btn btn-primary">Save and Next </button></center></th>
                                    </tr>
                                </table>
                            </form>
                        </div>

                        <div class="col-md-12">
                            <%
                                if (request.getParameter("submit") != null) {
                                    //weartype.setId(Integer.parseInt(request.getParameter("wear")));
                                    //category.setId(Integer.parseInt(request.getParameter("cate")));
                            %>
                            <script type="text/javascript">

                                function readURL(input) {

                                    if (input.files && input.files[0]) {
                                        var reader = new FileReader();

                                        reader.onload = function (e) {
                                            preview.src = e.target.result;
                                        };

                                        reader.readAsDataURL(input.files[0]);
                                    }
                                }
                            </script>
                            <form action="../ProductController?op=add" method="post" enctype="multipart/form-data" class="form">
                                <table class="table">
                                    <tr>
                                        <th>Select Product Image</th>
                                        <td><img src="../img/nopic.png" style="width:300px;height: 300px" class="img img-thumbnail" id="preview"/> <br/>
                       
                                            <input type="file" name="image" class="form-control btn btn-primary"  onchange="readURL(this);"/></td>
                                    </tr>
                                    <tr>
                                        <th colspan="2" ><center><button type="submit" class="btn btn-primary">Click here to insert image</button></center></th>
                                    </tr>
                                </table>
                            </form>

                            <% }
                            %>
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
