<%-- 
    Document   : cart
    Created on : Apr 15, 2020, 9:52:03 PM
    Author     : Arpit mishra
--%>
<%@page import="com.beans.Address"%>
<%@page import="com.daos.AddressDao"%>
<%@page import="com.beans.Product"%>
<%@page import="com.daos.ProductDao"%>
<%@page import="com.beans.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.beans.Customer"%>
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

        <%
            Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>

        
          <script type="text/javascript">
            function makeConfirmation(){
                if(confirm("do you want to Remove Item ?"))
                    return true;
                else
                    return false;
            }
            
           
            function checkAddress(){
                var ards = document.getElementsByName("address_id");
                var i=0;
                for(var x = 0;x<ards.length;x++){
                    if(ards[x].checked)
                        i++;
                }
                if(i==0) {    alert("Please Select any one Address ");
                return false;
            }
            
            }
            
            </script>
        

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
                    <h4>Your cart</h4>
                    <div class="site-pagination">
                        <a href="home.jsp">Home</a> /
                        <a href="cart.jsp">Your cart</a>
                    </div>
                </div>
            </div>
            <!-- Page info end -->


            <!-- cart section end -->
            <section class="cart-section spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="cart-table">
                                <h3>Your Cart</h3>
                                <div class="cart-table-warp">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th class="product-th">Product</th>
                                                <th class="quy-th">Quantity</th>
                                                <th class="size-th">SizeSize</th>
                                                <th class="total-th">Price</th>
                                                <th class="total-th">Action</th>
                                            </tr>
                                        </thead>
                                    <%
                                        float total=0;
                                        ArrayList<Cart> cart = (ArrayList) session.getAttribute("cart");
                                        ProductDao pd = new ProductDao();
                                        
                                        
                                        int i = 0;
                                        for (Cart c : cart) {
                                            Product product = pd.getById(c.getProduct_id());

                                    %>
                                    <tbody>
                                        <tr>
                                            <td class="product-col">
                                                <img src="<%=product.getImage()%> " alt="">
                                                <div class="pc-title">
                                                    <h4><%=product.getName()%></h4>
                                                    <p>&#x20B9; <%=product.getSelling_price()%></p>
                                                </div>
                                            </td>
                                            <td class="quy-col">
                                                <div class="quantity">
                                                   <%=c.getQuanity()%>
                                                </div>
                                            </td>
                                            <td class="size-col"><h4>Size <%=product.getSize()%></h4></td>
                                            <td class="total-col"><h4>&#x20B9; <%=c.getAmount()%></h4></td>
                                            <td><a href="cart.jsp?op=delete&rowid=<%=i%>" onclick="return makeConfirmation();"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
                                        </tr>
                                        <% total += c.getAmount();i++;}%>
                                    </tbody>
                                </table>
                            </div>
                            <div class="total-cost">
                                <h6>Total <span>&#x20B9; <%=total%></span></h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 card-right">
                        <form onsubmit="return checkAddress()" class="form" style="font-family: corbel; font-size:20px" method="post" action="invoice.jsp">
                            Select Payment Method : <br/>
                            <input type="radio" name="payment_mode" value="COD" checked />Cash On Delivery <br/><br/><br/>
                            <input type="hidden" name="date" value="" id="dt">
                            <input type="hidden" name="customer_id" value="<%=customer.getId()%>"/>
                            <input type="hidden" name="payment_status" value="Pending"/>
                            <input type="hidden" name="total_amount" value="<%=total%>"/>
                            <script>  
                         let today =new Date().toISOString().slice(0,10);
                         dt.value = today;
                          </script>
                            <%AddressDao ad = new AddressDao();
                            ArrayList<Address> adrlist =ad.getAllAddressesByCustomerId(customer.getId());
                            for(Address address : adrlist){ %>
                            <input type="radio" name="address_id" value="<%=address.getId()%>"/>Deliver on Following Address <br/>
                            <fieldset class="form-control" style="height: 100px;">
                                <%=address.getAddress()%>, <%=address.getCity()%> <br/> 
                                <%=address.getState()%> <br/>PIN : <%=address.getPincode()%>
                                Mobile :<%=address.getMobile()%> <br/>
                               
                            </fieldset>
                            <%}%>
                            <input type="submit" value="Proceed to checkout /Confirm" class="site-btn" <%if(cart.size()==0)out.println(" disabled");%> ></a>
                        </form>
                       
                        <a href="category.jsp" class="site-btn sb-dark">Continue shopping</a>
                    </div>
                </div>
            </div>
        </section>
        <!-- cart section end -->

        <!-- Related product section -->
        <section class="related-product-section">
            <div class="container">
                <div class="section-title text-uppercase">
                    <a href="category.jsp" class="btn btn-primary text-white" style="border-radius: 25px"><h6>Continue Shopping</h6></a>
                </div>

            </div>
        </section>
        <!-- Related product section end -->

        <!-- Footer section -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer section end -->

 <%
       if(request.getParameter("op")!=null && request.getParameter("op").equalsIgnoreCase("delete"))
       {
         int rowid= request.getParameter("rowid")!=null?Integer.parseInt(request.getParameter("rowid")):-1 ;
      System.out.println(cart.size());
         cart.remove(rowid);
           System.out.println(cart.size());
           session.setAttribute("cart", cart);
           response.sendRedirect("cart.jsp"); 
       }
 
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
