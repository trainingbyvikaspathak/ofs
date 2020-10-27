package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Shopkeeper;
import com.daos.ShopkeeperDao;
import java.sql.*;
import java.util.ArrayList;

public final class shopkeeperRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Register</title>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <script>\n");
      out.write("                function matchPwd(x, y) {\n");
      out.write("                    if (x === y) {\n");
      out.write("                        return true;\n");
      out.write("                    } else {\n");
      out.write("                        alert('Sorry! Password and Confirm Password is not matching.');\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function checkUserid(x, y) {\n");
      out.write("                    \n");
      out.write("                    ajax1 = new XMLHttpRequest();\n");
      out.write("                    ajax1.open(\"GET\", \"ShopkeeperController?op=check_userid&userid=\" + x, true);\n");
      out.write("                    ajax1.send();\n");
      out.write("\n");
      out.write("                    ajax1.onreadystatechange = function () {\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            y.innerHTML = this.responseText;\n");
      out.write("                            \n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function checkContact(x, y) {\n");
      out.write("                    ajax2 = new XMLHttpRequest();\n");
      out.write("                    ajax2.open(\"GET\", \"ShopkeeperController?op=check_contact&contact=\" + x, true);\n");
      out.write("                    ajax2.send();\n");
      out.write("\n");
      out.write("                    ajax2.onreadystatechange = function () {\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            y.innerHTML = this.responseText;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function checkEmail(x, y) {\n");
      out.write("                    ajax3 = new XMLHttpRequest();\n");
      out.write("                    ajax3.open(\"GET\", \"ShopkeeperController?op=check_email&email=\" + x, true);\n");
      out.write("                    ajax3.send();\n");
      out.write("\n");
      out.write("                    ajax3.onreadystatechange = function () {\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            y.innerHTML = this.responseText;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                function checkRN(x, y) {\n");
      out.write("                    ajax3 = new XMLHttpRequest();\n");
      out.write("                    ajax3.open(\"GET\", \"ShopkeeperController?op=check_RN&RN=\" + x, true);\n");
      out.write("                    ajax3.send();\n");
      out.write("\n");
      out.write("                    ajax3.onreadystatechange = function () {\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            y.innerHTML = this.responseText;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("        ");
      com.beans.Shopkeeper shopkeeper = null;
      synchronized (session) {
        shopkeeper = (com.beans.Shopkeeper) _jspx_page_context.getAttribute("shopkeeper", PageContext.SESSION_SCOPE);
        if (shopkeeper == null){
          shopkeeper = new com.beans.Shopkeeper();
          _jspx_page_context.setAttribute("shopkeeper", shopkeeper, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("         ");

                                    if (request.getParameter("submit") != null) {
                                
      out.write("\n");
      out.write("                                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("shopkeeper"), request);
}
      out.write("\n");
      out.write("            <!-- Page Preloder -->\n");
      out.write("            <div id=\"preloder\">\n");
      out.write("                <div class=\"loader\"></div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Header section -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            <!-- Header section end -->\n");
      out.write("\n");
      out.write("            <!-- Category section -->\n");
      out.write("            \n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <form method=\"post\"  class=\"form\" onsubmit=\"return matchPwd(password.value, cpassword.value);\">\n");
      out.write("                        <table class=\"table\">\n");
      out.write("                            <tr>\n");
      out.write("                                <th colspan=\"2\"><h2>Shopkeeper Registration** </h2></th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Name </th>\n");
      out.write("                                <td><input type=\"text\" name=\"name\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                                <th>Role </th>\n");
      out.write("                                <td><input type=\"text\" name=\"role\" class=\"form-control\" value=\"shopkeeper\" readonly/> </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Gender </th>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"radio\" name=\"gender\"  value=\"male\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.gender eq \"male\"?\"checked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/> Male\n");
      out.write("                                <br/>\n");
      out.write("                                <input type=\"radio\" name=\"gender\"  value=\"female\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.gender eq \"female\"?\"checked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/> Female\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Email </th>\n");
      out.write("                            <td><input type=\"email\" name=\"email\" class=\"form-control\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"email\" onblur=\"checkEmail(this.value, sp1);\" />\n");
      out.write("                                <span id =\"sp1\"> </span></td>\n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <th>Shop Registration No. </th>\n");
      out.write("                            <td><input type=\"text\" name=\"RN\" class=\"form-control\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.RN}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"RN\" onblur=\"checkRN(this.value, sp4);\"/>\n");
      out.write("                                <span id=\"sp4\"></span>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                      \n");
      out.write("                        <tr>\n");
      out.write("                            <th>Mobile No.</th>\n");
      out.write("                            <td><input type=\"number\" name=\"contact\" class=\"form-control\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.contact}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"10\" id=\"contact\" onblur=\"checkContact(this.value, sp3);\"/>\n");
      out.write("                                <span id =\"sp3\"></span></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>User Id </th>\n");
      out.write("                            <td><input type=\"text\" name=\"userid\" class=\"form-control\" id=\"userid\" required=\"required\" onblur=\"checkUserid(this.value, sp2);\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                <span id =\"sp2\"> </span></td>\n");
      out.write("                        </tr> \n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Password </th>\n");
      out.write("                            <td><input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Confirm Password</th>\n");
      out.write("                            <td><input type=\"password\" name=\"cpassword\" id=\"cpassword\" required=\"required\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Address </th>\n");
      out.write("                            <td><input type=\"text\" name=\"address\" id=\"address\" class=\"form-control\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <input type=\"hidden\" name=\"role\" value=\"shopkeeper\"/>\n");
      out.write("                        <tr>\n");
      out.write("                            <th colspan=\"2\"><center><button name=\"submit\" type=\"submit\" class=\"btn btn-primary\">Register</button></center></th>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                                ");

                                    if (request.getParameter("submit") != null) {
                                
      out.write("\n");
      out.write("                                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("shopkeeper"), request);
      out.write("\n");
      out.write("\n");
      out.write("                                   \n");
      out.write("                                ");
 response.sendRedirect("ShopPic.jsp"); }
                                
      out.write("\n");
      out.write("                            </div>\n");
      out.write("        \n");
      out.write("        <!-- Category section end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Footer section -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <!-- Footer section end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--====== Javascripts & Jquery ======-->\n");
      out.write("        <script src=\"assets/js/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery.slicknav.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery.nicescroll.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery.zoom.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery-ui.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/main.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
