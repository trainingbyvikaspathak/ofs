package org.apache.jsp.shopkeeper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Shopkeeper;

public final class shopkeeperhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <title>Shopkeeper Home</title>\r\n");
      out.write("  <link rel=\"icon\" href=\"shopkeeper/assets/img/admin.ico\" type=\"x/image\"/>\r\n");
      out.write("\r\n");
      out.write("  <!-- Custom fonts for this template-->\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body id=\"page-top\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");
    
         Shopkeeper shopkeeper = (Shopkeeper)session.getAttribute("shopkeeper");
       if(shopkeeper.getUserid() == "")
       {
        response.sendRedirect("../login.jsp");
       }
       
      out.write("\r\n");
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
      out.write("            <h1 class=\"h3 mb-0 text-gray-800\">Dashboard</h1>\r\n");
      out.write("            <a href=\"shopkeeperhome.jsp\" class=\"d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm\"><i class=\"fas fa-download fa-sm text-white-50\"></i> Generate Report</a>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
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
      out.write("  \r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
