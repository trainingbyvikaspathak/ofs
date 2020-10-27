
<%-- 
    Document   : shopkeeperRegistration
    Created on : Apr 17, 2020, 6:18:10 PM
    Author     : Arpit mishra
--%>

<%@page import="com.beans.Shopkeeper, com.daos.ShopkeeperDao, java.sql.*, java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>

        <jsp:include page="base.jsp"></jsp:include>

            <script>
                function matchPwd(x, y) {
                    if (x === y) {
                        return true;
                    } else {
                        alert('Sorry! Password and Confirm Password is not matching.');
                        return false;
                    }
                }

                function checkUserid(x, y) {
                    
                    ajax1 = new XMLHttpRequest();
                    ajax1.open("GET", "ShopkeeperController?op=check_userid&userid=" + x, true);
                    ajax1.send();

                    ajax1.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                            
                        }
                    }
                }

                function checkContact(x, y) {
                    ajax2 = new XMLHttpRequest();
                    ajax2.open("GET", "ShopkeeperController?op=check_contact&contact=" + x, true);
                    ajax2.send();

                    ajax2.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                        }
                    }
                }

                function checkEmail(x, y) {
                    ajax3 = new XMLHttpRequest();
                    ajax3.open("GET", "ShopkeeperController?op=check_email&email=" + x, true);
                    ajax3.send();

                    ajax3.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                        }
                    }
                }
                function checkRN(x, y) {
                    ajax3 = new XMLHttpRequest();
                    ajax3.open("GET", "ShopkeeperController?op=check_RN&RN=" + x, true);
                    ajax3.send();

                    ajax3.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                        }
                    }
                }

            </script>
        </head>
        <body>
        <jsp:useBean class="com.beans.Shopkeeper" id="shopkeeper" scope="session"></jsp:useBean>
         <%
                                    if (request.getParameter("submit") != null) {
                                %>
                                <jsp:setProperty name="shopkeeper" property="*"></jsp:setProperty><%}%>
            <!-- Page Preloder -->
            <div id="preloder">
                <div class="loader"></div>
            </div>

            <!-- Header section -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Header section end -->

            <!-- Category section -->
            
                <div class="container">
                    <form method="post"  class="form" onsubmit="return matchPwd(password.value, cpassword.value);">
                        <table class="table">
                            <tr>
                                <th colspan="2"><h2>Shopkeeper Registration** </h2></th>
                            </tr>
                            <tr>
                                <th>Name </th>
                                <td><input type="text" name="name" class="form-control" value="${shopkeeper.name}"/></td>
                        </tr>
                        <tr>
                                <th>Role </th>
                                <td><input type="text" name="role" class="form-control" value="shopkeeper" readonly/> </td>
                        </tr>
                        <tr>
                            <th>Gender </th>
                            <td>
                                <input type="radio" name="gender"  value="male" ${shopkeeper.gender eq "male"?"checked":""}/> Male
                                <br/>
                                <input type="radio" name="gender"  value="female" ${shopkeeper.gender eq "female"?"checked":""}/> Female
                            </td>
                        </tr>
                        <tr>
                            <th>Email </th>
                            <td><input type="email" name="email" class="form-control" required="required" value="${shopkeeper.email}" id="email" onblur="checkEmail(this.value, sp1);" />
                                <span id ="sp1"> </span></td>
                        </tr> 
                        <tr>
                            <th>Shop Registration No. </th>
                            <td><input type="text" name="RN" class="form-control" required="required" value="${shopkeeper.RN}" id="RN" onblur="checkRN(this.value, sp4);"/>
                                <span id="sp4"></span>
                            </td>
                        </tr>
                      
                        <tr>
                            <th>Mobile No.</th>
                            <td><input type="number" name="contact" class="form-control" required="required" value="${shopkeeper.contact}" maxlength="10" id="contact" onblur="checkContact(this.value, sp3);"/>
                                <span id ="sp3"></span></td>
                        </tr>
                        <tr>
                            <th>User Id </th>
                            <td><input type="text" name="userid" class="form-control" id="userid" required="required" onblur="checkUserid(this.value, sp2);" value="${shopkeeper.userid}"/>
                                <span id ="sp2"> </span></td>
                        </tr> 

                        <tr>
                            <th>Password </th>
                            <td><input type="password" name="password" id="password" class="form-control" required="required" value="${shopkeeper.password}"/></td>
                        </tr>
                        <tr>
                            <th>Confirm Password</th>
                            <td><input type="password" name="cpassword" id="cpassword" required="required" class="form-control" value="${shopkeeper.password}"></td>
                        </tr>
                        <tr>
                            <th>Address </th>
                            <td><input type="text" name="address" id="address" class="form-control" required="required" value="${shopkeeper.address}"/></td>
                        </tr>
                         <tr>
                            <th>Pin Code </th>
                            <td><input type="text" name="pin" id="pin" class="form-control" required="required" value="${shopkeeper.pin}"/></td>
                        </tr>
                         <tr>
                            <th>Shop Name  </th>
                            <td><input type="text" name="shopName" id="shopName" class="form-control" required="required" value="${shopkeeper.shopName}"/></td>
                        </tr>
                        
                        
                        
                        <input type="hidden" name="role" value="shopkeeper"/>
                        <tr>
                            <th colspan="2"><center><button name="submit" type="submit" class="btn btn-primary">Register</button></center></th>
                        </tr>
                    </table>
                </form>
            </div>
                        
                        <div class="col-md-12">
                                <%
                                    if (request.getParameter("submit") != null) {
                                %>
                                <jsp:setProperty name="shopkeeper" property="*"></jsp:setProperty>

                                   
                                <% response.sendRedirect("ShopPic.jsp"); }
                                %>
                            </div>
        
        <!-- Category section end -->


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

    </body>
</html>





