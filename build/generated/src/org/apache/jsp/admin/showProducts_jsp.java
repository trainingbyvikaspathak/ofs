package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.daos.CategoryDao;
import com.daos.WeartypeDao;
import com.daos.ProductDao;
import com.beans.Product;
import java.util.ArrayList;

public final class showProducts_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("  <meta name=\"description\" content=\"\">\r\n");
      out.write("  <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("  <title>All News</title>\r\n");
      out.write("\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body id=\"page-top\">\r\n");
      out.write("    ");

        if (session.getAttribute("admin")==null){
            response.sendRedirect("../login.jsp");
            return;
        }
        
      out.write("\r\n");
      out.write("  <!-- Page Wrapper -->\r\n");
      out.write("  <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Sidebar -->\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("    <!-- End of Sidebar -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Content Wrapper -->\r\n");
      out.write("    <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Main Content -->\r\n");
      out.write("      <div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Topbar -->\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "topbar.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- End of Topbar -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Begin Page Content -->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("          <!-- Page Heading -->\r\n");
      out.write("          <div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\r\n");
      out.write("            <h1 class=\"h3 mb-0 text-gray-800\">List of All News </h1>\r\n");
      out.write("            \r\n");
      out.write("          <a href=\"#\" class=\"d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm\"><i class=\"fas fa-download fa-sm text-white-50\"></i> Export News</a>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"row table-responsive\">\r\n");
      out.write("              \r\n");
      out.write("              <table class=\"table\">\r\n");
      out.write("                  <tr>\r\n");
      out.write("                      <td>Name</td>\r\n");
      out.write("                      <td> Wear Type </td>\r\n");
      out.write("                      <td>Category</td>\r\n");
      out.write("                      <td>Brand </td>\r\n");
      out.write("                      <td>size</td>\r\n");
      out.write("                      <td>Price</td>\r\n");
      out.write("                      <td>Current Status</td>\r\n");
      out.write("                      <td>Action</td>\r\n");
      out.write("                      <td>Image</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                      ");

                          ProductDao pd = new ProductDao();
                          ArrayList<Product> products = pd.getAllProduct();
                          WeartypeDao wd = new WeartypeDao();
                          CategoryDao cd = new CategoryDao();
                          
                          for(Product product : products){
      out.write("\r\n");
      out.write("                  <tr>\r\n");
      out.write("                      <td>");
      out.print(product.getName() );
      out.write("</td>\r\n");
      out.write("                      <td>");
      out.print(wd.getWeartypeByProductId(product.getId()).getName() );
      out.write("</td>\r\n");
      out.write("                      <td>");
      out.print(cd.getCategoryByProductId(product.getId()).getName() );
      out.write("</td>\r\n");
      out.write("                      <td>");
      out.print(product.getBrand() );
      out.write("</td>\r\n");
      out.write("                      <td>");
      out.print(product.getSize());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(product.getPrice() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(product.getStatus());
      out.write("</td>\r\n");
      out.write("                      <td><a href=\"changeNewsStatus.jsp?newsid=");
      out.print(product.getId());
      out.write("\" class=\"btn btn-primary\"> View and Change Status</a></td>\r\n");
      out.write("                      <td> <img src=\"../");
      out.print(product.getImage());
      out.write("\" width=\"50\" height=\"50\" class=\"img rounded-circle\"/></td>\r\n");
      out.write("                      \r\n");
      out.write("                  </tr>\r\n");
      out.write("                          \r\n");
      out.write("                          ");
}
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("              </table>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          \r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- End of Main Content -->\r\n");
      out.write("\r\n");
      out.write("      <!-- Footer -->\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("      <!-- End of Footer -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End of Content Wrapper -->\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- End of Page Wrapper -->\r\n");
      out.write("\r\n");
      out.write("  <!-- Scroll to Top Button-->\r\n");
      out.write("  <a class=\"scroll-to-top rounded\" href=\"#page-top\">\r\n");
      out.write("    <i class=\"fas fa-angle-up\"></i>\r\n");
      out.write("  </a>\r\n");
      out.write("\r\n");
      out.write("  <!-- Logout Modal-->\r\n");
      out.write("  <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <h5 class=\"modal-title\" id=\"exampleModalLabel\">Ready to Leave?</h5>\r\n");
      out.write("          <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("            <span aria-hidden=\"true\">×</span>\r\n");
      out.write("          </button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-body\">Select \"Logout\" below if you are ready to end your current session.</div>\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("          <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">Cancel</button>\r\n");
      out.write("          <a class=\"btn btn-primary\" href=\"logout.jsp\">Logout</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <!-- Bootstrap core JavaScript-->\r\n");
      out.write("  \r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
