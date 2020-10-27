<%-- 
    Document   : contact
    Created on : Apr 15, 2020, 11:07:38 PM
    Author     : Arpit mishra
--%>

<%@page import="com.daos.QueryDao"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>Contact Us | eCommerce </title>
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
	<!-- Header section end -->


	<!-- Page info -->
	<div class="page-top-info">
		<div class="container">
			<h4>Contact</h4>
			<div class="site-pagination">
				<a href="home.jsp">Home</a> /
				<a href="contact.jsp">Contact</a>
			</div>
		</div>
	</div>
	<!-- Page info end -->


	<!-- Contact section -->
	<section class="contact-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 contact-info">
					<h3>Get in touch</h3>
					<p>Maint Bhopal, h. no 11, India</p>
					<p>+917623437823</p>
					<p>hosting@contact.com</p>
					<div class="contact-social">
						<a href="#"><i class="fa fa-pinterest"></i></a>
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-dribbble"></i></a>
						<a href="#"><i class="fa fa-behance"></i></a>
					</div>
                                </div>
                            <div class="col-lg-6 contact-info">
                                <%! String msg="";%>
                            <jsp:useBean id="queries" class="com.beans.Queries" scope="session"></jsp:useBean>
                            <% if (request.getParameter("submit")!=null){%>
                            <jsp:setProperty name="queries" property="*"></jsp:setProperty>
                             <%
                                 QueryDao qd = new QueryDao();
                                 qd.save(queries);
                                 msg="Query Submitted, We will contact you soon !!";
                            }%>
                            
                                <form class="contact-form" method="post">
                                    <% if(msg!="") out.println("<label><b>"+msg+"</b></label>"); %>
						<input type="text" placeholder="Your name" name="name">
						<input type="text" placeholder="Your e-mail" name="email">
						<input type="text" placeholder="Subject" name="subject">
						<textarea placeholder="Message" name="message"></textarea>
                                                <button class="site-btn" type="submit" name="submit">SEND NOW</button>
					</form>
				</div>
			</div>
		</div>
		
	</section>
	<!-- Contact section end -->


	 

	<!-- Footer section -->
        <jsp:include page="base.jsp"></jsp:include>
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
