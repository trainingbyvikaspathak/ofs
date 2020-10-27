<%-- 
    Document   : category
    Created on : Apr 15, 2020, 11:38:20 PM
    Author     : Arpit mishra
--%>

<%@page import="com.daos.ShopkeeperDao"%>
<%@page import="com.beans.Shopkeeper"%>
<%@page import="com.daos.AddressDao"%>
<%@page import="com.beans.Address"%>
<%@page import="com.beans.Customer"%>
<%@page import="com.beans.WearType"%>
<%@page import="com.daos.WeartypeDao"%>
<%@page import="com.beans.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.daos.CategoryDao"%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <title>Cotegory </title>
        <meta charset="UTF-8">
        <jsp:include page="base.jsp"></jsp:include>
        </head>
        <body>
        <% if (session.getAttribute("customer") == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            Customer customer = (Customer) session.getAttribute("customer");
            ArrayList<Address> addresses = new AddressDao().getAllAddressesByCustomerId(customer.getId());

        %>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Header section -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Header section end -->


            <!-- Page info -->
            <div class="page-top-info">
                <div class="container">
                    <h4><%=request.getParameter("msg")%> </h4>

            </div>
        </div>
        <!-- Page info end -->


        <!-- Category section -->
        <section class="category-section spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 order-2 order-lg-1 disable">
                        <div class="filter-widget">
                            <h2 class="fw-title">Categories Filter</h2>
                            <ul class="category-menu">
                                <% WeartypeDao wd = new WeartypeDao();
                                    ArrayList<WearType> wears = wd.getAllWeartype();
                                    for (WearType wt : wears) {
                                %>
                                <li><a href="#"><%=wt.getName()%></a>
                                    <ul class="sub-menu">
                                        <%
                                            CategoryDao cd = new CategoryDao();
                                            ArrayList<Category> cats = cd.getAllCategoryByWearId(wt.getId());
                                            for (Category cat : cats) {%>
                                        <li><a href="#"> <%= cat.getName()%> <span>(2)</span></a></li>
                                            <%}%>	 
                                    </ul>
                                </li>
                                <%}%>


                            </ul>
                        </div>
                        <div class="filter-widget mb-0">
                            <h2 class="fw-title">refine by</h2>
                            <div class="price-range-wrap">
                                <h4>Price</h4>
                                <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content" data-min="10" data-max="270">
                                    <div class="ui-slider-range ui-corner-all ui-widget-header" style="left: 0%; width: 100%;"></div>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default" style="left: 0%;">
                                    </span>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default" style="left: 100%;">
                                    </span>
                                </div>
                                <div class="range-slider">
                                    <div class="price-input">
                                        <input type="text" id="minamount">
                                        <input type="text" id="maxamount">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="filter-widget mb-0">
                            <h2 class="fw-title">color by</h2>
                            <div class="fw-color-choose">
                                <div class="cs-item">
                                    <input type="radio" name="cs" id="gray-color">
                                    <label class="cs-gray" for="gray-color">
                                        <span>(3)</span>
                                    </label>
                                </div>
                                <div class="cs-item">
                                    <input type="radio" name="cs" id="orange-color">
                                    <label class="cs-orange" for="orange-color">
                                        <span>(25)</span>
                                    </label>
                                </div>
                                <div class="cs-item">
                                    <input type="radio" name="cs" id="yollow-color">
                                    <label class="cs-yollow" for="yollow-color">
                                        <span>(112)</span>
                                    </label>
                                </div>
                                <div class="cs-item">
                                    <input type="radio" name="cs" id="green-color">
                                    <label class="cs-green" for="green-color">
                                        <span>(75)</span>
                                    </label>
                                </div>
                                <div class="cs-item">
                                    <input type="radio" name="cs" id="purple-color">
                                    <label class="cs-purple" for="purple-color">
                                        <span>(9)</span>
                                    </label>
                                </div>
                                <div class="cs-item">
                                    <input type="radio" name="cs" id="blue-color" checked="">
                                    <label class="cs-blue" for="blue-color">
                                        <span>(29)</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="filter-widget mb-0">
                            <h2 class="fw-title">Size</h2>
                            <div class="fw-size-choose">
                                <div class="sc-item">
                                    <input type="radio" name="sc" id="xs-size">
                                    <label for="xs-size">XS</label>
                                </div>
                                <div class="sc-item">
                                    <input type="radio" name="sc" id="s-size">
                                    <label for="s-size">S</label>
                                </div>
                                <div class="sc-item">
                                    <input type="radio" name="sc" id="m-size"  checked="">
                                    <label for="m-size">M</label>
                                </div>
                                <div class="sc-item">
                                    <input type="radio" name="sc" id="l-size">
                                    <label for="l-size">L</label>
                                </div>
                                <div class="sc-item">
                                    <input type="radio" name="sc" id="xl-size">
                                    <label for="xl-size">XL</label>
                                </div>
                                <div class="sc-item">
                                    <input type="radio" name="sc" id="xxl-size">
                                    <label for="xxl-size">XXL</label>
                                </div>
                            </div>
                        </div>
                        <div class="filter-widget">
                            <h2 class="fw-title">Brand</h2>
                            <ul class="category-menu">
                                <li><a href="#">Abercrombie & Fitch <span>(2)</span></a></li>
                                <li><a href="#">Asos<span>(56)</span></a></li>
                                <li><a href="#">Bershka<span>(36)</span></a></li>
                                <li><a href="#">Missguided<span>(27)</span></a></li>
                                <li><a href="#">Zara<span>(19)</span></a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-9  order-1 order-lg-2 mb-5 mb-lg-0">
                        <div class="row">
                            <%
                                for (Address address : addresses) {
                                    System.out.println("pin code of customer : " + address.getPincode());

                                    ArrayList<Shopkeeper> shopkeeperList = new ShopkeeperDao().getShopsByPin(String.valueOf(address.getPincode()));
                                    for (Shopkeeper shopkeepar : shopkeeperList) {
                            %>

                            <div class="col-lg-4 col-sm-6" >
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <img src="<%=shopkeepar.getImage()%>" style="height: 400px; width:200px; border-style: solid; border-width: 2px; border-radius: 5px;" alt="Image not Available !">
                                        <h4><%=shopkeepar.getShopName()%></h4>
                                    </div>
                                    <div class="pi-text">
                                        <p><b> <%=shopkeepar.getAddress()%> </b></p>
                                        <p>PIN : <%=shopkeepar.getPin()%></p>
                                        <p>Call : <%=shopkeepar.getContact()%></p>
                                    </div>
                                    <div class="text-justify pt-5">
                                        <a href="#" class="site-btn sb-line sb-dark">SHOP WITH IT</a>
                                    </div>
                                </div>
                            </div>
                            <%}
                                        }%>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Category section end -->


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
