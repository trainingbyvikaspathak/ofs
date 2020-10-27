package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.daos.ShopkeeperDao;
import com.beans.Shopkeeper;
import com.daos.AddressDao;
import com.beans.Address;
import com.beans.Customer;
import com.beans.WearType;
import com.daos.WeartypeDao;
import com.beans.Category;
import java.util.ArrayList;
import com.daos.CategoryDao;

public final class nearByShops_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("    <head>\n");
      out.write("        <title>Cotegory </title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("        ");
 if (session.getAttribute("customer") == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            Customer customer = (Customer) session.getAttribute("customer");
            ArrayList<Address> addresses = new AddressDao().getAllAddressesByCustomerId(customer.getId());

        
      out.write("\n");
      out.write("        <!-- Page Preloder -->\n");
      out.write("        <div id=\"preloder\">\n");
      out.write("            <div class=\"loader\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Header section -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            <!-- Header section end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Page info -->\n");
      out.write("            <div class=\"page-top-info\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <h4>");
      out.print(request.getParameter("msg"));
      out.write(" </h4>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Page info end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Category section -->\n");
      out.write("        <section class=\"category-section spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-3 order-2 order-lg-1\">\n");
      out.write("                        <div class=\"filter-widget\">\n");
      out.write("                            <h2 class=\"fw-title\">Categories Filter</h2>\n");
      out.write("                            <ul class=\"category-menu\">\n");
      out.write("                                ");
 WeartypeDao wd = new WeartypeDao();
                                    ArrayList<WearType> wears = wd.getAllWeartype();
                                    for (WearType wt : wears) {
                                
      out.write("\n");
      out.write("                                <li><a href=\"#\">");
      out.print(wt.getName());
      out.write("</a>\n");
      out.write("                                    <ul class=\"sub-menu\">\n");
      out.write("                                        ");

                                            CategoryDao cd = new CategoryDao();
                                            ArrayList<Category> cats = cd.getAllCategoryByWearId(wt.getId());
                                                                        for (Category cat : cats) {
      out.write("\n");
      out.write("                                        <li><a href=\"#\"> ");
      out.print( cat.getName());
      out.write(" <span>(2)</span></a></li>\n");
      out.write("                                            ");
}
      out.write("\t \n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"filter-widget mb-0\">\n");
      out.write("                            <h2 class=\"fw-title\">refine by</h2>\n");
      out.write("                            <div class=\"price-range-wrap\">\n");
      out.write("                                <h4>Price</h4>\n");
      out.write("                                <div class=\"price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content\" data-min=\"10\" data-max=\"270\">\n");
      out.write("                                    <div class=\"ui-slider-range ui-corner-all ui-widget-header\" style=\"left: 0%; width: 100%;\"></div>\n");
      out.write("                                    <span tabindex=\"0\" class=\"ui-slider-handle ui-corner-all ui-state-default\" style=\"left: 0%;\">\n");
      out.write("                                    </span>\n");
      out.write("                                    <span tabindex=\"0\" class=\"ui-slider-handle ui-corner-all ui-state-default\" style=\"left: 100%;\">\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"range-slider\">\n");
      out.write("                                    <div class=\"price-input\">\n");
      out.write("                                        <input type=\"text\" id=\"minamount\">\n");
      out.write("                                        <input type=\"text\" id=\"maxamount\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"filter-widget mb-0\">\n");
      out.write("                            <h2 class=\"fw-title\">color by</h2>\n");
      out.write("                            <div class=\"fw-color-choose\">\n");
      out.write("                                <div class=\"cs-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"cs\" id=\"gray-color\">\n");
      out.write("                                    <label class=\"cs-gray\" for=\"gray-color\">\n");
      out.write("                                        <span>(3)</span>\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"cs-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"cs\" id=\"orange-color\">\n");
      out.write("                                    <label class=\"cs-orange\" for=\"orange-color\">\n");
      out.write("                                        <span>(25)</span>\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"cs-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"cs\" id=\"yollow-color\">\n");
      out.write("                                    <label class=\"cs-yollow\" for=\"yollow-color\">\n");
      out.write("                                        <span>(112)</span>\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"cs-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"cs\" id=\"green-color\">\n");
      out.write("                                    <label class=\"cs-green\" for=\"green-color\">\n");
      out.write("                                        <span>(75)</span>\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"cs-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"cs\" id=\"purple-color\">\n");
      out.write("                                    <label class=\"cs-purple\" for=\"purple-color\">\n");
      out.write("                                        <span>(9)</span>\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"cs-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"cs\" id=\"blue-color\" checked=\"\">\n");
      out.write("                                    <label class=\"cs-blue\" for=\"blue-color\">\n");
      out.write("                                        <span>(29)</span>\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"filter-widget mb-0\">\n");
      out.write("                            <h2 class=\"fw-title\">Size</h2>\n");
      out.write("                            <div class=\"fw-size-choose\">\n");
      out.write("                                <div class=\"sc-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"sc\" id=\"xs-size\">\n");
      out.write("                                    <label for=\"xs-size\">XS</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"sc-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"sc\" id=\"s-size\">\n");
      out.write("                                    <label for=\"s-size\">S</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"sc-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"sc\" id=\"m-size\"  checked=\"\">\n");
      out.write("                                    <label for=\"m-size\">M</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"sc-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"sc\" id=\"l-size\">\n");
      out.write("                                    <label for=\"l-size\">L</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"sc-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"sc\" id=\"xl-size\">\n");
      out.write("                                    <label for=\"xl-size\">XL</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"sc-item\">\n");
      out.write("                                    <input type=\"radio\" name=\"sc\" id=\"xxl-size\">\n");
      out.write("                                    <label for=\"xxl-size\">XXL</label>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"filter-widget\">\n");
      out.write("                            <h2 class=\"fw-title\">Brand</h2>\n");
      out.write("                            <ul class=\"category-menu\">\n");
      out.write("                                <li><a href=\"#\">Abercrombie & Fitch <span>(2)</span></a></li>\n");
      out.write("                                <li><a href=\"#\">Asos<span>(56)</span></a></li>\n");
      out.write("                                <li><a href=\"#\">Bershka<span>(36)</span></a></li>\n");
      out.write("                                <li><a href=\"#\">Missguided<span>(27)</span></a></li>\n");
      out.write("                                <li><a href=\"#\">Zara<span>(19)</span></a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-lg-9  order-1 order-lg-2 mb-5 mb-lg-0\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            ");
 
                                for (Address address : addresses) {
                                    System.out.println("pin code of customer : " + address.getPincode());
                               
                                    ArrayList<Shopkeeper> shopkeeperList = new ShopkeeperDao().getShopsByPin(String.valueOf(address.getPincode()));
                                    for (Shopkeeper shopkeepar : shopkeeperList) {
                                
      out.write("\n");
      out.write("                                \n");
      out.write("                            <div class=\"col-lg-4 col-sm-6\">\n");
      out.write("                                <div class=\"product-item\">\n");
      out.write("                                    <div class=\"pi-pic\">\n");
      out.write("                                        <div class=\"tag-sale\">ON SALE</div>\n");
      out.write("                                        <img src=\"");
      out.print(shopkeepar.getImage());
      out.write("\" alt=\"\">\n");
      out.write("                                        \n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"pi-text\">\n");
      out.write("                                         <p><b> ");
      out.print(shopkeepar.getAddress());
      out.write(" </b></p>\n");
      out.write("                                         <p>PIN : ");
      out.print(shopkeepar.getPin());
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                                    ");
}}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
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
      out.write("\n");
      out.write("        <!--====== Javascripts & Jquery ======-->\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.slicknav.min.js\"></script>\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.nicescroll.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.zoom.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
