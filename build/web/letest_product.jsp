<%-- 
    Document   : letest_product
    Created on : Apr 7, 2020, 7:35:34 PM
    Author     : Arpit mishra
--%>

<%@page import="com.beans.Product"%>
<%@page import="com.daos.ProductDao"%>
<%@page import="com.beans.WearType"%>
<%@page import="com.controllers.WeartypeController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.daos.WeartypeDao"%>
<section class="top-letest-product-section">
		<div class="container">
			<div class="section-title">
				<h2>LADIES WEAR</h2>
			</div>
			<div class="product-slider owl-carousel">
                            <% 
                                    ProductDao pd = new ProductDao();
                                    ArrayList<Product> products = pd.getAllProductByWearType(2); 
                                    for (Product product : products) {
                                %>
				<div class="product-item">
					<div class="pi-pic">
                                            <img src="<%=product.getImage()%>" alt="" height="400">
						<div class="pi-links">
							<a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
							<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
						</div>
					</div>
					<div class="pi-text">
                                            <h6>&#x20B9; <s><%=product.getPrice()%></s> <br/>&#x20B9;  <%=product.getSelling_price()%> </h6>
						<p><%=product.getName()%> </p>
					</div>
				</div>
				 <%}%>
			</div>
		</div>
	</section>