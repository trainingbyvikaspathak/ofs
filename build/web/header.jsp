<%-- 
    Document   : header
    Created on : Apr 7, 2020, 6:52:31 PM
    Author     : Arpit mishra
--%>

<%@page import="com.beans.Cart"%>
<%@page import="com.beans.Customer"%>
<%@page import="com.daos.CategoryDao"%>
<%@page import="com.beans.Category"%>
<%@page import="com.daos.WeartypeDao"%>
<%@page import="com.beans.WearType"%>
<%@page import="java.util.ArrayList"%>
<header class="header-section">
    <div class="header-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-2 text-center text-lg-left">
                    <!-- logo -->
                    <a href="home.jsp" class="site-logo">
                        <img src="img/LOGO2.png" alt="">
                    </a>
                </div>
                <div class="col-xl-4 col-lg-5">
                    <form class="header-search-form">
                        <input type="text" placeholder="Search on online fasion store ....">
                        <button><i class="flaticon-search"></i></button>
                    </form>
                </div>
                <div class="col-xl-4 col-lg-5">
                    <div class="user-panel">
                        <% if (session.getAttribute("customer") == null && session.getAttribute("admin") == null && session.getAttribute("shopkeeper") == null) {%>
                        <div class="up-item">
                            <i class="flaticon-profile"></i>
                            <a href="login.jsp">Sign</a> In or <a href="Registration.jsp">Create Account</a>
                        </div>
                        <%} else {%>
                        <div class="up-item">
                            <i class="flaticon-profile"></i>
                            <a href="logout.jsp">Logout</a>
                            <a href="home.jsp"></a>
                        </div>
                        <%}%>
                        <div class="up-item">
                            <div class="shopping-card">
                                <i class="flaticon-bag"></i>
                                <span>
                                    <%
                                    ArrayList<Cart> cart ;
                                    if (session.getAttribute("cart")==null)
                                            cart =new ArrayList<Cart>();
                                    else  
                                    cart = (ArrayList)session.getAttribute("cart");
                                    out.println(cart.size());
                                    %>
                                </span>
                        </div>
                        <a href="cart.jsp">Shopping Cart</a>
                </div>
        </div>
</div>
                                    
<div class="col-lg-2 text-center">
        <!-- logo -->
      <a href="home.jsp" class="site-logo"> 
          <% if(session.getAttribute("customer")==null){%>
                                    <img src="img/login.png" class="img-profile" style="width:50px;height: 50px;"/> <br/> Guest
                                    <%}else {Customer customer = (Customer)session.getAttribute("customer"); %>
                                    <img src="<%=customer.getImage()%>" class="img-profile rounded-circle " style="width:50px;height: 50px;"/> <br/> <%=customer.getName()%>
                                    <%}%>
                                    </a>
                            </div>
                        </div>
                    </div>
                </div>
                <nav class="main-navbar">
                    <div class="container">
                        <!-- menu -->
                        <ul class="main-menu">
                            <li><a href="home.jsp">Home</a></li>
                                <%
                                    WeartypeDao wd = new WeartypeDao();
                                    ArrayList<WearType> wears = wd.getAllWeartype();
                                        for (WearType w : wears) {%>
                            <li><a href="category.jsp?msg=<%=w.getName()%> wear&weartype_id=<%=w.getId()%>"> <%=w.getName()%> wear</a></li>
                                <%}%>

                            </a></li>
                            <li><a href="#">Search By Category</a>
                                <ul class="sub-menu">
                                    <%
                                        CategoryDao cd = new CategoryDao();
                                        ArrayList<Category> cats = cd.getAllCategory();
                                        for (Category cat : cats) {
                                    %>
                                    <li><a href="category.jsp?msg=Selected Category : <%=cat.getName()%>&category_id=<%=cat.getId()%>"><%=cat.getName()%> </a></li>
                                        <%}%>
                                </ul>
                            </li>
                            <li><a href="nearByShops.jsp?msg=Shops Near By You...">NearBy Shops</a></li>
                            <li><a href="./contact.jsp">Contact Us</a></li>
                            <!--<li><a href="#">Pages</a>
                                    <ul class="sub-menu">
                                            <li><a href="./product.jsp">Product Page</a></li>
                                            <li><a href="./category.jsp">Category Page</a></li>
                                            <li><a href="./cart.jsp">Cart Page</a></li>
                                            <li><a href="./checkout.jsp">Checkout Page</a></li>
                                            <li><a href="./contact.jsp">Contact Page</a></li>
                                    </ul>
                            </li> -->

                            <li><a href="#">My Order</a>
                                <ul class="sub-menu">
                                    <li><a href="customer/return1.jsp">Return</a></li>
                                    <li><a href="customer/trackOrder.jsp">Track Order</a></li>
                                    <li><a href="customer/customerhome.jsp">Account</a></li>

                                </ul>
                            </li>

                        </ul>
                    </div>
                </nav>
                </header>