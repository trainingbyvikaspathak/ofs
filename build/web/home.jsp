<%-- 
    Document   : home
    Created on : Apr 7, 2020, 6:28:10 PM
    Author     : Arpit mishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Fashion store | E-Commerce </title>
        <title> Home </title>
        <link rel="icon" href="./img/favicon.ico" type="x/image"/>
        <meta charset="UTF-8">
        <jsp:include page="base.jsp"></jsp:include>

        </head>
        <body>
            <!-- Page Preloder -->
            <div id="preloder">
                <div class="loader"></div>
            </div>

            <!-- Header section -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Header section -->



            <!-- Hero section -->
        <jsp:include page="hero.jsp"></jsp:include>
            <!-- Hero section end -->

            <!-- sidebar section -->
            <!-- <!--jsp:include page="sidebar.jsp"><--/jsp:include--> -->
            <!-- sidebar section -->



            <!-- Features section -->
            <!--jsp:include page="feature.jsp"/jsp:include>-->
            <!-- Features section end -->


            <!-- letest product section -->
        <jsp:include page="letest_product.jsp"></jsp:include>
            <!-- letest product section end -->



            <!-- Product filter section -->
        <jsp:include page="product.jsp"></jsp:include>
            <!-- Product filter section end -->


            <!-- Banner section -->

        <jsp:include page="banner.jsp"></jsp:include>
            <!-- Banner section end  -->


            <!-- Footer section -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer section end -->



        <!--====== Javascripts & Jquery ======-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.slicknav.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/main.js"></script>



    </body>
</html>
