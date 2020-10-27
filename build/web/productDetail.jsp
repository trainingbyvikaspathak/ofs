<%-- 
    Document   : cart
    Created on : Apr 15, 2020, 9:52:03 PM
    Author     : Arpit mishra
--%>
<%@page import="com.daos.ReviewDao"%>
<%@page import="com.beans.Review"%>
<%@page import="com.daos.ShopkeeperDao"%>
<%@page import="com.beans.Product"%>
<%@page import="com.daos.ProductDao"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>Cart | eCommerce</title>
	<meta charset="UTF-8">
        <jsp:include page="base.jsp"></jsp:include>
	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" href="css/flaticon.css"/>
	<link rel="stylesheet" href="css/slicknav.min.css"/>
	<link rel="stylesheet" href="css/jquery-ui.min.css"/>
	<link rel="stylesheet" href="css/owl.carousel.min.css"/>
	<link rel="stylesheet" href="css/animate.css"/>
	<link rel="stylesheet" href="css/style.css"/>


	
</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
<jsp:include page="header.jsp"></jsp:include>
	<!-- Header section end -->
        
<%if(request.getParameter("info")!=null)
    out.println("<script> alert('" + request.getParameter("info") +"');</script>");
  %>      
  
  
<% 
if(request.getParameter("submitReview")!=null){%>
<jsp:useBean class="com.beans.Review" id="review" scope="session"></jsp:useBean>
<jsp:setProperty name="review" property="*"></jsp:setProperty>

<%
    ReviewDao rd = new ReviewDao();
    Review rw = (Review) session.getAttribute("review");
    System.out.println("product Details : " + rw.getName() +"," + rw.getEmail()+"," +rw.getSubject() +"," + rw.getMessage());
    rd.add(review);
}
    %>

   
	<!-- Page info -->
	<div class="page-top-info">
		<div class="container">
			<h4>Product Details</h4>
			 
		</div>
	</div>
	<!-- Page info end -->


	<!-- cart section end -->
	<section class="cart-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="cart-table">
						<h3>Product Details</h3>
						<div class="cart-table-warp">
                                                <% ProductDao pd = new ProductDao();
                                                Product product = pd.getById(Integer.parseInt(request.getParameter("pid")));
                                                %>
                                                <table class="table" style="font-size: 16px">
                                                    <tbody>
								<tr>
                                                                    <th rowspan="7">
                                                                            <img src="<%=product.getImage()%>" style="border-width:2px; border-radius: 5px;width:400px;height: 500px;">
										 
									</th>
                                                                        <th><%=product.getName()%></th>
									 
								</tr>
                                                                <tr>
                                                                    <th><b> Size : </b> <%=product.getSize()%></th>
                                                                </tr>
                                                                
                                                                    <tr>
                                                                    <th><b> Brand : </b> <%=product.getBrand()%></th>
                                                                </tr>
                                                                
                                                                    <tr>
                                                                        <th><b> Sold By : </b> <%=new ShopkeeperDao().getById(product.getSeller_id()).getShopName()%></th>
                                                                </tr>
                                                                    <tr>
                                                                    <th><b> MRP  : </b>&#x20B9; <%=product.getPrice()%></th>
                                                                </tr>
                                                                     <tr>
                                                                    <th><b> Our Price  : </b>&#x20B9; <%=product.getSelling_price() %></th>
                                                                </tr>
                                                                  </tr>
                                                                    <tr>
                                                                    <th><b> Description  : </b> <%=product.getDescription()%></th>
                                                                </tr>
                                                    </tbody>
							 
						</table>
						</div>
						<div class="total-cost">
							<h6>Price :  <span>&#x20B9;<%=product.getSelling_price()%></span></h6>
						</div>
					</div>
				</div>
				<div class="col-lg-4 card-right">
                                    <form action="addCart.jsp">
                                        <input type="hidden"  name="pid" value="<%=product.getId()%>"/>
                                        
                                    Select Qunatity of Product :<br/>
                                    <select name="quantity" class="dropdown-item dropdown-header form-control">
                                        <%for (int i=1;i<=5 && i<=product.getStock(); i++){%>
                                        <option value="<%=i%>"><%=i%></option>
                                        <%}%>
                                    </select> <br/><br/>
                                    
                                    <input type="submit" name="submit" class="site-btn"  value = "Add to Cart" <%if (product.getStock()==0) out.println(" disabled style='opacity:0.7'");%> /> <br/> <br/>
                                    </form>
                                    <a href="cart.jsp" class="site-btn">View Cart and Checkout</a> <br/><br/>
                                        <a href="category.jsp" class="site-btn sb-dark">Continue shopping</a>
				 
                                    <h4>Reviews of Products</h4>
                                    <div class="container" style="overflow: hidden; height: 300px;">
                                        <% for (Review review : new ReviewDao().getAllReviewByproductId(product.getId())){%> 
                                        <div class="row bg-info" style="border-radius: 10px; margin-top:10px">
                                            <div class="col">
                                                <b><%=review.getName()%></b><br/> 
                                                <%=review.getMessage()%> <br/>
                                            </div>
                                        </div>
                                        <%}%>
                                    </div>
				
			</div>
		</div>
	</section>
	<!-- cart section end -->

	<!-- Related product section -->
	<section class="related-product-section">
		<div class="container">
                    <div class="row">
                        <div class="col col-md-12 col-sm-12">
                            <center><h4> Give Review to above product</h4></center> <br/>
                            <form method="post" class="form">
                                <table class="table  bg-info" style="border-radius: 10px">
                                <tr>
                                    <td>Name</td> 
                                    <td><input type="text" name="name" class="form-control" required="required"/>
                                        <input type="hidden" name="shopkeeper_id" value="<%=product.getSeller_id()%>"/>
                                        <input type="hidden" name="product_id" value="<%=product.getId()%>"/>
                                 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Subject (Review/Complain) </td>
                                    <td><input type="text" name="subject" class="form form-control" required/></td>
                                </tr>
                                 <tr>
                                    <td>email </td>
                                    <td><input type="email" name="email" class="form form-control" required/></td>
                                </tr>
                                
                                <tr>
                                    <td> Message </td>
                                    <td><textarea name="message" class="form-control" required="required"></textarea></td>
                                </tr>
                                <tr>
                                    <th colspan="2">
                                        <input type="submit" class="form-control btn btn-dark" name="submitReview"/>
                                    </th>
                                </tr>
                            </table>
                            </form>
                        </div>
                    </div>
		 
		</div>
	</section>
	<!-- Related product section end -->



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
