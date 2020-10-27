<%-- 
    Document   : login
    Created on : Apr 17, 2020, 5:26:01 PM
    Author     : Arpit mishra
--%>

<%@page import="com.beans.Admin"%>
<%@page import="com.daos.AdminDao"%>
<%@page import="com.beans.Shopkeeper"%>
<%@page import="com.beans.Customer, com.daos.CustomerDao,com.daos.ShopkeeperDao, java.sql.*, java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="assets/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="assets/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/login/css/main.css">
<!--===============================================================================================-->

        <jsp:include page="base.jsp"></jsp:include>
        </head>
        <body>
            <!-- Page Preloder -->
            <div id="preloder">
                <div class="loader"></div>
            </div>

            <!-- Header section -->
        <jsp:include page="header.jsp"></jsp:include>
        <!-- Header section end -->
<!-- Category section -->
    <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(assets/login/images/BGI.jpg);">
					<span class="login100-form-title-1">
						Sign In
					</span>
				</div>
                            <%
          //Reading cookie 
           Cookie cookies[] = request.getCookies();
           String userid="",password="";
           
           for(Cookie c : cookies){
               if(c.getName().equals("userid"))
               {
                   userid=c.getValue();
               }
               if (c.getName().equals("password"))
               {
                   password = c.getValue();
               }
           }
       %>
      

				<form class="login100-form validate-form">
					<div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
						<span class="label-input100">Username</span>
						<input class="input100" type="text" name="userid" value="<%=userid%>" placeholder="Enter user id">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input100">Password</span>
                                                <input class="input100" type="password" name="password" value="<%=password%>" placeholder="Enter password">
						<span class="focus-input100"></span>
					</div>
                                    
                                    <h6>Select Role</h6>
                                    <div >
                                     
                                        <input type="radio" name="role" id="role1" value="admin"/><label for="role1"><b> Admin </b></label> 
                                        <input type="radio" name="role" id="role2" value="customer"/><label for="role2"><b> Customer </b></label>
                                        <input type="radio" name="role" id="role3" value="shopkeeper"/><label for="role3"><b> Shokeeper </b></label> 
                                         </div>
                                    </br></br></br></br>
					<div class="flex-sb-m w-full p-b-30">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
						</div>

						<div>
							<a href="#" class="txt1">
								Forgot Password?
							</a>
						</div>
					</div>

					<div class="container-login100-form-btn">
                                            <button class="login100-form-btn" type="submit" name="submit">
							Login
						</button>
					</div>
                                    <p>
      <span style="color:red; font-family: corble; font-size: 16px">
    <%=request.getParameter("msg")!=null?request.getParameter("msg"):""%>
</span>
  </p>
				</form>
			</div>
		</div>
	</div>
	<!-- Category section end -->
        
            <%
           if(request.getParameter("submit")!=null){
           userid= request.getParameter("userid");
           password = request.getParameter("password");
           String role = request.getParameter("role");
           
        if(role==null){
            response.sendRedirect("login.jsp?msg=Please Select Any One Role");
            //return;
        }
        else if(role.equals("customer")){
               CustomerDao cd = new CustomerDao();
               //System.out.println(ad);
               Customer customer = cd.getByLoginDetail(userid, password,role);
               if(customer==null){
              // System.out.println(ad);
                   response.sendRedirect("login.jsp?msg=Invalid Userid or password of customer");
               } else {
              // System.out.println("jdhsjkdhakdhakds:"+ad);
                   
                   session.setAttribute("customer", customer);
                   response.sendRedirect("home.jsp");
               }
           }
    else if (role.equals("shopkeeper")){
           ShopkeeperDao sd = new ShopkeeperDao();
           Shopkeeper shopkeeper = sd.getByLoginDetail(userid, password, role);
          // System.out.println("returning data : " +  shopkeeper.getName());
           if(shopkeeper == null)
           {
              response.sendRedirect("login.jsp?msg=Invalid Userid or password of Shopkeeper"); 
             }
           else{
               
               session.setAttribute("shopkeeper", shopkeeper);
               response.sendRedirect("shopkeeper/shopkeeperhome.jsp");
           
           } 
                
           }
           
          else if (role.equals("admin")){
           AdminDao ad = new AdminDao();
           Admin admin = ad.getByLoginDetail(userid, password);
          // System.out.println("returning data : " +  shopkeeper.getName());
           if(admin == null)
           {
              response.sendRedirect("login.jsp?msg=Invalid Userid or password of Shopkeeper"); 
             }
           else{
               
               session.setAttribute("admin", admin);
               response.sendRedirect("admin/adminhome.jsp");
           
           } 
                
           }
           }
      %>
       

        <!-- Footer section -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer section end -->



        <!--====== Javascripts & Jquery ======-->
        <script src="assets/js/jquery-3.2.1.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.slicknav.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/jquery.nicescroll.min.js"></script>
        <script src="assets/js/jquery.zoom.min.js"></script>
        <script src="assets/js/jquery-ui.min.js"></script>
        <script src="assets/js/main.js"></script>
        <!--===============================================================================================-->
	<script src="assets/login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/login/vendor/bootstrap/js/popper.js"></script>
	<script src="assets/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="assets/login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="assets/login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="assets/login/js/main.js"></script>

    </body>
</html>
