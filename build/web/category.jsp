<%-- 
    Document   : category
    Created on : Apr 15, 2020, 11:38:20 PM
    Author     : Arpit mishra
--%>

        
<%@page import="com.beans.Product"%>
<%@page import="com.daos.ProductDao"%>
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
				<div class="col-lg-3 order-2 order-lg-1">
					<div class="filter-widget">
						<h2 class="fw-title">Categories Filter</h2>
						<ul class="category-menu">
                                                    <%
                                                        ProductDao pd = new ProductDao(); 
                                                                
                                                        WeartypeDao wd = new WeartypeDao();
                                                    ArrayList<WearType> wears = wd.getAllWeartype();
                                                    for (WearType wt : wears){
                                                    %>
							<li><a href="#"><%=wt.getName()%></a>
								<ul class="sub-menu">
                                                                    <% 
                                                                    CategoryDao cd = new CategoryDao();
                                                    ArrayList<Category> cats = cd.getAllCategoryByWearId(wt.getId());
                                                    for (Category cat : cats){%>
									<li><a href="#"> <%= cat.getName()%></a></li>
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
                                                     <% for(String brand : pd.getAllProductBrands()){%>
							<li><a href="#"><%=brand%></a></li>
							 <%}%>   
						</ul>
					</div>
				</div>

				<div class="col-lg-9  order-1 order-lg-2 mb-5 mb-lg-0">
					<div class="row">
                                            <% for (Product product : pd.getAllApprovedProduct()){%> 
						<div class="col-lg-4 col-sm-6">
							<div class="product-item">
								<div class="pi-pic">
                                                                    <a href="productDetail.jsp?pid=<%=product.getId()%>"> <img src="<%=product.getImage()%>" style="width:300px; height: 400px;" alt=""></a>
									<div class="pi-links">
                                                                            <a href="<%if(product.getStock()>0) out.println("addCart.jsp?pid="+product.getId()); else out.println("#");%>" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
										<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
									</div>
								</div>
								<div class="pi-text">
									<h6>&#x20B9; <s><%=product.getPrice()%></s> <br/>&#x20B9;  <%=product.getSelling_price()%> </h6>
                                                                        <p><%=product.getName()%> <br/> <%if(product.getStock()>0){%> (stock available : <%=product.getStock()%>) <%} else out.println("<font color='red'><b>(Out Of Stock)</b></font>");%></p>
								</div>
							</div>
						</div>
                                                                <%}%>
						 
						  
						 
						 
						<div class="text-center w-100 pt-3">
							<button class="site-btn sb-line sb-dark">LOAD MORE</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Category section end -->


	<!-- Footer section -->
        <jsp:include page="footer.jsp"></jsp:include>
	<!-- Footer section end -->

    <%if(request.getParameter("info")!=null)
    out.println("<script> alert('" + request.getParameter("info") +"');</script>");
  %>   


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
