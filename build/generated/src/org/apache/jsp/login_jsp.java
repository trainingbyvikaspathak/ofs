package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Admin;
import com.daos.AdminDao;
import com.beans.Shopkeeper;
import com.beans.Customer;
import com.daos.CustomerDao;
import com.daos.ShopkeeperDao;
import java.sql.*;
import java.util.ArrayList;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        \r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/vendor/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css\">\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/vendor/animate/animate.css\">\r\n");
      out.write("<!--===============================================================================================-->\t\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/vendor/css-hamburgers/hamburgers.min.css\">\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/vendor/animsition/css/animsition.min.css\">\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/vendor/select2/select2.min.css\">\r\n");
      out.write("<!--===============================================================================================-->\t\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/vendor/daterangepicker/daterangepicker.css\">\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/css/util.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/login/css/main.css\">\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("            <!-- Page Preloder -->\r\n");
      out.write("            <div id=\"preloder\">\r\n");
      out.write("                <div class=\"loader\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Header section -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Header section end -->\r\n");
      out.write("<!-- Category section -->\r\n");
      out.write("    <div class=\"limiter\">\r\n");
      out.write("\t\t<div class=\"container-login100\">\r\n");
      out.write("\t\t\t<div class=\"wrap-login100\">\r\n");
      out.write("\t\t\t\t<div class=\"login100-form-title\" style=\"background-image: url(assets/login/images/BGI.jpg);\">\r\n");
      out.write("\t\t\t\t\t<span class=\"login100-form-title-1\">\r\n");
      out.write("\t\t\t\t\t\tSign In\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("                            ");

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
       
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<form class=\"login100-form validate-form\">\r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input m-b-26\" data-validate=\"Username is required\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"label-input100\">Username</span>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"userid\" value=\"");
      out.print(userid);
      out.write("\" placeholder=\"Enter user id\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input m-b-18\" data-validate = \"Password is required\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"label-input100\">Password</span>\r\n");
      out.write("                                                <input class=\"input100\" type=\"password\" name=\"password\" value=\"");
      out.print(password);
      out.write("\" placeholder=\"Enter password\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("                                    \r\n");
      out.write("                                    <h6>Select Role</h6>\r\n");
      out.write("                                    <div >\r\n");
      out.write("                                     \r\n");
      out.write("                                        <input type=\"radio\" name=\"role\" id=\"role1\" value=\"admin\"/><label for=\"role1\"><b> Admin </b></label> \r\n");
      out.write("                                        <input type=\"radio\" name=\"role\" id=\"role2\" value=\"customer\"/><label for=\"role2\"><b> Customer </b></label>\r\n");
      out.write("                                        <input type=\"radio\" name=\"role\" id=\"role3\" value=\"shopkeeper\"/><label for=\"role3\"><b> Shokeeper </b></label> \r\n");
      out.write("                                         </div>\r\n");
      out.write("                                    </br></br></br></br>\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-sb-m w-full p-b-30\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"contact100-form-checkbox\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"input-checkbox100\" id=\"ckb1\" type=\"checkbox\" name=\"remember-me\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"label-checkbox100\" for=\"ckb1\">\r\n");
      out.write("\t\t\t\t\t\t\t\tRemember me\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"txt1\">\r\n");
      out.write("\t\t\t\t\t\t\t\tForgot Password?\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"container-login100-form-btn\">\r\n");
      out.write("                                            <button class=\"login100-form-btn\" type=\"submit\" name=\"submit\">\r\n");
      out.write("\t\t\t\t\t\t\tLogin\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("                                    <p>\r\n");
      out.write("      <span style=\"color:red; font-family: corble; font-size: 16px\">\r\n");
      out.write("    ");
      out.print(request.getParameter("msg")!=null?request.getParameter("msg"):"");
      out.write("\r\n");
      out.write("</span>\r\n");
      out.write("  </p>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- Category section end -->\r\n");
      out.write("        \r\n");
      out.write("            ");

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
      
      out.write("\r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("        <!-- Footer section -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Footer section end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--====== Javascripts & Jquery ======-->\r\n");
      out.write("        <script src=\"assets/js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery.slicknav.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/owl.carousel.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery.nicescroll.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery.zoom.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery-ui.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/main.js\"></script>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("\t<script src=\"assets/login/vendor/jquery/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<script src=\"assets/login/vendor/animsition/js/animsition.min.js\"></script>\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<script src=\"assets/login/vendor/bootstrap/js/popper.js\"></script>\r\n");
      out.write("\t<script src=\"assets/login/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<script src=\"assets/login/vendor/select2/select2.min.js\"></script>\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<script src=\"assets/login/vendor/daterangepicker/moment.min.js\"></script>\r\n");
      out.write("\t<script src=\"assets/login/vendor/daterangepicker/daterangepicker.js\"></script>\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<script src=\"assets/login/vendor/countdowntime/countdowntime.js\"></script>\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<script src=\"assets/login/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
