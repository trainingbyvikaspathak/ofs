package org.apache.jsp.shopkeeper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Shopkeeper;
import com.beans.Product;
import com.beans.Category;
import com.beans.WearType;
import com.daos.ProductDao;
import com.daos.CategoryDao;
import com.daos.WeartypeDao;
import java.util.ArrayList;

public final class addProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <!-- Required meta tags-->\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <meta name=\"description\" content=\"au theme template\">\r\n");
      out.write("        <meta name=\"author\" content=\"Hau Nguyen\">\r\n");
      out.write("        <meta name=\"keywords\" content=\"au theme template\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Title Page-->\r\n");
      out.write("        <title>Add Product</title>\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <script>\r\n");
      out.write("                function getCategory(x, y) {\r\n");
      out.write("\r\n");
      out.write("                    ajax3 = new XMLHttpRequest();\r\n");
      out.write("                    ajax3.open(\"GET\", \"../ProductController?op=get_cat&weartype_id=\" + x, true);\r\n");
      out.write("                    ajax3.send();\r\n");
      out.write("\r\n");
      out.write("                    ajax3.onreadystatechange = function () {\r\n");
      out.write("                        // alert(x);\r\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("                            y.innerHTML = this.responseText;\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            </script>\r\n");
      out.write("        </head>\r\n");
      out.write("\r\n");
      out.write("        <body id=\"page-top\">\r\n");
      out.write("        ");

            Shopkeeper shopkeeper = (Shopkeeper) session.getAttribute("shopkeeper");
            if (shopkeeper == null) {
                response.sendRedirect("../login.jsp");
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      com.beans.Product product = null;
      synchronized (session) {
        product = (com.beans.Product) _jspx_page_context.getAttribute("product", PageContext.SESSION_SCOPE);
        if (product == null){
          product = new com.beans.Product();
          _jspx_page_context.setAttribute("product", product, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        ");
      com.beans.WearType weartype = null;
      synchronized (session) {
        weartype = (com.beans.WearType) _jspx_page_context.getAttribute("weartype", PageContext.SESSION_SCOPE);
        if (weartype == null){
          weartype = new com.beans.WearType();
          _jspx_page_context.setAttribute("weartype", weartype, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        ");
      com.beans.Category category = null;
      synchronized (session) {
        category = (com.beans.Category) _jspx_page_context.getAttribute("category", PageContext.SESSION_SCOPE);
        if (category == null){
          category = new com.beans.Category();
          _jspx_page_context.setAttribute("category", category, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        ");

            if (request.getParameter("submit") != null) {
                weartype.setId(Integer.parseInt(request.getParameter("wear")));
                category.setId(Integer.parseInt(request.getParameter("cate")));

        
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("product"), request);
      out.write("\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("            <!-- MENU SIDEBAR-->\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("                <!-- END MENU SIDEBAR-->\r\n");
      out.write("                <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- PAGE CONTAINER-->\r\n");
      out.write("                    <div id=\"idcontent\">\r\n");
      out.write("                        <!-- HEADER DESKTOP-->\r\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "topbar.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <!-- END HEADER DESKTOP-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <!-- Main Section -->\r\n");
      out.write("                        <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"col col-md-12\">\r\n");
      out.write("\r\n");
      out.write("                                <form class=\"form\">\r\n");
      out.write("                                    <table class=\"table\">\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th colspan=\"2\"><center><h2>**Add Product Here** </h2></center></th>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th>Enter Product Name </th>\r\n");
      out.write("                                            <td><input type=\"text\" name=\"name\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("                                    </tr> \r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Enter Product Price </th>\r\n");
      out.write("                                        <td><input type=\"text\" name=\"price\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Enter Product Selling Price </th>\r\n");
      out.write("                                        <td><input type=\"text\" name=\"selling price\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Enter Product Size </th>\r\n");
      out.write("                                        <td><input type=\"text\" name=\"size\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("                                    </tr> \r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Enter Product Color </th>\r\n");
      out.write("                                        <td><input type=\"text\" name=\"color\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.color}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Enter Product Brand </th>\r\n");
      out.write("                                        <td><input type=\"text\" name=\"brand\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.brand}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("                                    </tr> \r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Enter Product Stock </th>\r\n");
      out.write("                                        <td><input type=\"text\" name=\"stock\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.stock}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("                                    </tr> \r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Enter Product Description </th>\r\n");
      out.write("                                        <td><input type=\"text\" name=\"description\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("                                    </tr> \r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Select Wear Type </th>\r\n");
      out.write("                                        <td>\r\n");
      out.write("                                            ");

                                                WeartypeDao wd = new WeartypeDao();
                                                ArrayList<WearType> weartypes = wd.getAllWeartype();
                                                for (WearType wear : weartypes) {
                                                    System.out.println("wid:" + wear.getId());
                                            
      out.write(" \r\n");
      out.write("                                            <input type=\"radio\" name=\"wear\" onclick=\"getCategory(this.value, category);\" value=\"");
      out.print(wear.getId());
      out.write("\" /> ");
      out.print(wear.getName());
      out.write("<br/> \r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("                                        </td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Select Category </th>\r\n");
      out.write("                                        <td>\r\n");
      out.write("                                            <div id=\"category\">\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");
      out.write("\r\n");
      out.write("                                        </td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th colspan=\"2\"><center><button name=\"submit\" type=\"submit\" class=\"btn btn-primary\">Save and Next </button></center></th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-md-12\">\r\n");
      out.write("                            ");

                                if (request.getParameter("submit") != null) {
                                    //weartype.setId(Integer.parseInt(request.getParameter("wear")));
                                    //category.setId(Integer.parseInt(request.getParameter("cate")));
                            
      out.write("\r\n");
      out.write("                            <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("                                function readURL(input) {\r\n");
      out.write("\r\n");
      out.write("                                    if (input.files && input.files[0]) {\r\n");
      out.write("                                        var reader = new FileReader();\r\n");
      out.write("\r\n");
      out.write("                                        reader.onload = function (e) {\r\n");
      out.write("                                            preview.src = e.target.result;\r\n");
      out.write("                                        };\r\n");
      out.write("\r\n");
      out.write("                                        reader.readAsDataURL(input.files[0]);\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                            </script>\r\n");
      out.write("                            <form action=\"../ProductController?op=add\" method=\"post\" enctype=\"multipart/form-data\" class=\"form\">\r\n");
      out.write("                                <table class=\"table\">\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Select Product Image</th>\r\n");
      out.write("                                        <td><img src=\"../img/nopic.png\" style=\"width:300px;height: 300px\" class=\"img img-thumbnail\" id=\"preview\"/> <br/>\r\n");
      out.write("                       \r\n");
      out.write("                                            <input type=\"file\" name=\"image\" class=\"form-control btn btn-primary\"  onchange=\"readURL(this);\"/></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th colspan=\"2\" ><center><button type=\"submit\" class=\"btn btn-primary\">Click here to insert image</button></center></th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </form>\r\n");
      out.write("\r\n");
      out.write("                            ");
 }
                            
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <!-- End Main Section -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Footer -->\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("                <!-- End Footer -->\r\n");
      out.write("            </div>>\r\n");
      out.write("            <!-- END PAGE CONTAINER-->\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Jquery JS-->\r\n");
      out.write("        <script src=\"vendor/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("        <!-- Bootstrap JS-->\r\n");
      out.write("        <script src=\"vendor/bootstrap-4.1/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/bootstrap-4.1/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- Vendor JS       -->\r\n");
      out.write("        <script src=\"vendor/slick/slick.min.js\">\r\n");
      out.write("        </script>\r\n");
      out.write("        <script src=\"vendor/wow/wow.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/animsition/animsition.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/bootstrap-progressbar/bootstrap-progressbar.min.js\">\r\n");
      out.write("        </script>\r\n");
      out.write("        <script src=\"vendor/counter-up/jquery.waypoints.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/counter-up/jquery.counterup.min.js\">\r\n");
      out.write("        </script>\r\n");
      out.write("        <script src=\"vendor/circle-progress/circle-progress.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/perfect-scrollbar/perfect-scrollbar.js\"></script>\r\n");
      out.write("        <script src=\"vendor/chartjs/Chart.bundle.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/select2/select2.min.js\">\r\n");
      out.write("        </script>\r\n");
      out.write("        <script src=\"vendor/vector-map/jquery.vmap.js\"></script>\r\n");
      out.write("        <script src=\"vendor/vector-map/jquery.vmap.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/vector-map/jquery.vmap.sampledata.js\"></script>\r\n");
      out.write("        <script src=\"vendor/vector-map/jquery.vmap.world.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Main JS-->\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("<!-- end document-->\r\n");
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
