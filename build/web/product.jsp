<%-- 
    Document   : product
    Created on : Apr 7, 2020, 6:49:02 PM
    Author     : Arpit mishra
--%>

<%@page import="com.beans.Category"%>
<%@page import="com.daos.CategoryDao"%>
<%@page import="com.beans.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.daos.ProductDao"%>
<section class="product-filter-section">
		<div class="container">
			<div class="section-title">
				<h2>BROWSE TOP SELLING PRODUCTS</h2>
			</div>
			<ul class="product-filter-menu">
                            <%
                            CategoryDao cd = new  CategoryDao();
                            ArrayList<Category>  clist  = cd.getAllCategory();
                            for(int i=0;i<7;i++){
                            %>
                            <li><a href="home.jsp?catid=<%=(clist.get(i)).getId()%>&category=<%=(clist.get(i)).getName()%>"><%=(clist.get(i)).getName()%> </a></li>
                            <%}%>
				
			</ul>
			<div class="row">
                            
                            <%
                                ProductDao pdo = new ProductDao();
                                ArrayList<Product> plist = null; 
                            if(request.getParameter("catid")==null)
                                plist = pdo.getAllProductByLimit(8);
                                
                            else
                                plist = pdo.getAllProductByCategory(request.getParameter("category"));
                             
                                for(int i=0; i<8 && i<plist.size(); i++){
                                    Product product = plist.get(i); 
                               
                            %>
				<div class="col-lg-3 col-sm-6">
					<div class="product-item">
						<div class="pi-pic">
                                                    <img src="<%=product.getImage()%>" alt="" style="height: 400px; border-width: 2px; border-style: solid;">
							<div class="pi-links">
								<a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
								<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
							</div>
						</div>
						<div class="pi-text">
							<h6>&#x20B9; <s><%=product.getPrice()%></s> <br/>&#x20B9;  <%=product.getSelling_price()%> </h6>
							<p><%=product.getName()%></p>
						</div>
					</div>
				</div>
                                                <%}%>
			</div>
			<div class="text-center pt-5">
                            <a href="category.jsp" class="site-btn sb-line sb-dark">LOAD MORE</a>
			</div>
		</div>
	</section>