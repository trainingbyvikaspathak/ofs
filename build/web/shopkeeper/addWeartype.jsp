<%-- 
    Document   : addWeartype
    Created on : Oct 2, 2020, 1:42:53 PM
    Author     : Arpit mishra
--%>

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
        <title>Add Weartype</title>

        <jsp:include page="base.jsp"></jsp:include>

        </head>

        <body class="animsition">
            <div class="page-wrapper">
                <!-- MENU SIDEBAR-->
            <jsp:include page="sidebar.jsp"></jsp:include>
                <!-- END MENU SIDEBAR-->

                <!-- PAGE CONTAINER-->
                <div class="page-container2">
                    <!-- HEADER DESKTOP-->
                <jsp:include page="header.jsp"></jsp:include>

                    <!-- END HEADER DESKTOP-->



                    <!-- Main Section -->
                    <div class="main-content">
                        <div class="form-control">
                            <div class="container-fluid">
                                <div class="col col-md-12">
                                    <form action="../WeartypeController?op=add" method="post" class="form">
                                        <table class="table">
                                            <tr>
                                                <th colspan="2"><center><h2>**Add New Waertype** </h2></center></th>
                                            </tr>
                                            <tr>
                                                <th>Enter Weartype Name</th>
                                                <td><input type="text" name="name" class="form-control" value="${weartype.name}"/></td>
                                            </tr>
                                            <tr>
                                                <th colspan="2" ><center><button type="submit" class="btn btn-primary">Click here to insert data</button></center></th>
                                            </tr>
                                        </table>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>




                    <!-- End Main Section -->

                    <!-- Footer --!>
                <jsp:include page="footer.jsp"></jsp:include>
                <!-- End Footer -->
                <!-- END PAGE CONTAINER-->
            </div>

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
