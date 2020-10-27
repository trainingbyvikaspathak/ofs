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

public final class viewProducts_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags-->\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"au theme template\">\n");
      out.write("        <meta name=\"author\" content=\"Hau Nguyen\">\n");
      out.write("        <meta name=\"keywords\" content=\"au theme template\">\n");
      out.write("\n");
      out.write("        <!-- Title Page-->\n");
      out.write("        <title>Add Product</title>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <script>\n");
      out.write("                function getCategory(x, y) {\n");
      out.write("\n");
      out.write("                    ajax3 = new XMLHttpRequest();\n");
      out.write("                    ajax3.open(\"GET\", \"../ProductController?op=get_cat&weartype_id=\" + x, true);\n");
      out.write("                    ajax3.send();\n");
      out.write("\n");
      out.write("                    ajax3.onreadystatechange = function () {\n");
      out.write("                        // alert(x);\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            y.innerHTML = this.responseText;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body id=\"page-top\">\n");
      out.write("        ");

            Shopkeeper shopkeeper = (Shopkeeper) session.getAttribute("shopkeeper");
            if (shopkeeper == null) {
                response.sendRedirect("../login.jsp");
                return; 
            }
            System.out.println("shopkeepr id : " + shopkeeper.getId());
        
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <!-- MENU SIDEBAR-->\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\n");
      out.write("                <!-- END MENU SIDEBAR-->\n");
      out.write("                <div id=\"content-wrapper\" class=\"d-flex flex-column\">\n");
      out.write("\n");
      out.write("                    <!-- PAGE CONTAINER-->\n");
      out.write("                    <div id=\"idcontent\">\n");
      out.write("                        <!-- HEADER DESKTOP-->\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "topbar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                        <!-- END HEADER DESKTOP-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <!-- Main Section -->\n");
      out.write("                        <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"col col-md-12\">\n");
      out.write("\n");
      out.write("                                <form class=\"form\">\n");
      out.write("                                    <center><h3>List of Your products</h3></center>\n");
      out.write("\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Name</td>\n");
      out.write("                                            <td> Wear Type </td>\n");
      out.write("                                            <td>Category</td>\n");
      out.write("                                            <td>Brand </td>\n");
      out.write("                                            <td>size</td>\n");
      out.write("                                            <td>Price</td>\n");
      out.write("                                            <td>Current Status</td>\n");
      out.write("                                            <td>Action</td>\n");
      out.write("                                            <td>Image</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    ");

                                        ProductDao pd = new ProductDao();
                                        ArrayList<Product> products = pd.getAllProductByShopkeeperId(shopkeeper.getId());
                                        WeartypeDao wd = new WeartypeDao();
                                        CategoryDao cd = new CategoryDao();

                                        for (Product product : products) {
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>");
      out.print(product.getName());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(wd.getWeartypeByProductId(product.getId()).getName());
      out.write(" </td>\n");
      out.write("                                        <td>");
      out.print(cd.getCategoryByProductId(product.getId()).getName());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(product.getBrand());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(product.getSize());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(product.getPrice());
      out.write("</td>\n");
      out.write("                                        <td><b> <font color=\"");
if (product.getStatus().equalsIgnoreCase("pending") || product.getStatus().equalsIgnoreCase("rejected")) {
                                out.println("red");
                            }
      out.write("\"> ");
      out.print(product.getStatus());
      out.write("</td>\n");
      out.write("                                                <td>   <a href=\"ViewAndUpdateProduct.jsp?pid=");
      out.print(product.getId());
      out.write("\" class=\"btn btn-primary\"> Edit/Update Details </a>  </td>\n");
      out.write("                                                <td> <img src=\"../");
      out.print(product.getImage());
      out.write("\" width=\"50\" height=\"50\" class=\"img rounded-circle\"/></td>\n");
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("\n");
      out.write("                                </table>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- End Main Section -->\n");
      out.write("\n");
      out.write("                <!-- Footer -->\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("                <!-- End Footer -->\n");
      out.write("            </div>>\n");
      out.write("            <!-- END PAGE CONTAINER-->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Jquery JS-->\n");
      out.write("        <script src=\"vendor/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <!-- Bootstrap JS-->\n");
      out.write("        <script src=\"vendor/bootstrap-4.1/popper.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap-4.1/bootstrap.min.js\"></script>\n");
      out.write("        <!-- Vendor JS       -->\n");
      out.write("        <script src=\"vendor/slick/slick.min.js\">\n");
      out.write("        </script>\n");
      out.write("        <script src=\"vendor/wow/wow.min.js\"></script>\n");
      out.write("        <script src=\"vendor/animsition/animsition.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap-progressbar/bootstrap-progressbar.min.js\">\n");
      out.write("        </script>\n");
      out.write("        <script src=\"vendor/counter-up/jquery.waypoints.min.js\"></script>\n");
      out.write("        <script src=\"vendor/counter-up/jquery.counterup.min.js\">\n");
      out.write("        </script>\n");
      out.write("        <script src=\"vendor/circle-progress/circle-progress.min.js\"></script>\n");
      out.write("        <script src=\"vendor/perfect-scrollbar/perfect-scrollbar.js\"></script>\n");
      out.write("        <script src=\"vendor/chartjs/Chart.bundle.min.js\"></script>\n");
      out.write("        <script src=\"vendor/select2/select2.min.js\">\n");
      out.write("        </script>\n");
      out.write("        <script src=\"vendor/vector-map/jquery.vmap.js\"></script>\n");
      out.write("        <script src=\"vendor/vector-map/jquery.vmap.min.js\"></script>\n");
      out.write("        <script src=\"vendor/vector-map/jquery.vmap.sampledata.js\"></script>\n");
      out.write("        <script src=\"vendor/vector-map/jquery.vmap.world.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Main JS-->\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("<!-- end document-->\n");
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
