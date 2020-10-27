<%@page import="com.utilities.FileUploader"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="com.daos.ProductRDao"%>
<%@page import="com.beans.Shopkeeper,java.sql.*"%>
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
                            <%
            if(request.getParameter("submit1")!=null || request.getParameter("submit2")!=null){ 
            int pid = Integer.parseInt(request.getParameter("pid"));
            ProductDao pd = new ProductDao();
            Product product = pd.getById(pid);
            session.setAttribute("product", product); 
            int wearid = Integer.parseInt(request.getParameter("weartype_id"));
            int catid = Integer.parseInt(request.getParameter("category_id"));
            System.out.println("pid " +pid + ", wearid : "+wearid +", catid : " +catid );
            System.out.println("Product Name : " + product.getName()); 
            product.setName(request.getParameter("name"));
            product.setBrand(request.getParameter("brand"));
            product.setSize(request.getParameter("size"));
            product.setPrice(Integer.parseInt(request.getParameter("price")));
            product.setSelling_price(Integer.parseInt(request.getParameter("selling_price")));
            product.setColor(request.getParameter("color"));
            product.setStock(Integer.parseInt(request.getParameter("stock")));
            product.setDescription(request.getParameter("description"));
          
            System.out.println("New Product Name : " + product.getName());


            ProductRDao prd = new ProductRDao();
            pd.update(product);
            prd.update(pid, wearid, catid);
            
            System.out.println("<script> alert('updated');</script>");
            session.setAttribute("product", product);
            } 
            
            if (request.getParameter("submit2")!=null){%>
                            <form method="post" enctype="multipart/form-data" class="form" action="">
                                 <table class="table">
                                    <tr>
                                        <th>Select Product Image</th>
                                        <td><img src="../img/nopic.png" style="width:300px;height: 300px" class="img img-thumbnail" id="preview"/> <br/>
                       
                                            <input type="file" name="image" class="form-control btn btn-primary"  onchange="readURL(this);"/></td>
                                    </tr>
                                    <tr>
                                    <input type="hidden" name="final_submit" value="update" />
                                        <th colspan="2" ><center><button type="submit" class="btn btn-primary">Click here Update Image</button></center></th>
                                    </tr>
                                </table>
                            </form>
                            <% } else{

try {
                //check the enctype of the incomming request -
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                 String photo = "", imagePath = "";
                if (isMultipart) {
                    imagePath = FileUploader.getUploadedPath(getServletContext(), "shopkeeper/media/product", request);
                }
            Product product = (Product) session.getAttribute("product");
            ProductDao pd = new ProductDao();
            product.setImage(imagePath);
            pd.update(product);
            session.removeAttribute("product");
            response.sendRedirect("viewProducts.jsp");
            }
        
              catch(Exception e){
                  System.out.println("Error " + e.getMessage());
              }
 System.out.println("submitte.....");   
}
  
%>
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
