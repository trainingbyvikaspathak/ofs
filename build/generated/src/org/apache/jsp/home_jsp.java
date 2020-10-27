package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Fashion store | E-Commerce </title>\r\n");
      out.write("        <title> Home </title>\r\n");
      out.write("        <link rel=\"icon\" href=\"./img/favicon.ico\" type=\"x/image\"/>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\r\n");
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
      out.write("            <!-- Header section -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Hero section -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "hero.jsp", out, false);
      out.write("\r\n");
      out.write("            <!-- Hero section end -->\r\n");
      out.write("\r\n");
      out.write("            <!-- sidebar section -->\r\n");
      out.write("            <!-- <!--jsp:include page=\"sidebar.jsp\"><--/jsp:include--> -->\r\n");
      out.write("            <!-- sidebar section -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Features section -->\r\n");
      out.write("            <!--jsp:include page=\"feature.jsp\"/jsp:include>-->\r\n");
      out.write("            <!-- Features section end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- letest product section -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "letest_product.jsp", out, false);
      out.write("\r\n");
      out.write("            <!-- letest product section end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Product filter section -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "product.jsp", out, false);
      out.write("\r\n");
      out.write("            <!-- Product filter section end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Banner section -->\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "banner.jsp", out, false);
      out.write("\r\n");
      out.write("            <!-- Banner section end  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Footer section -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Footer section end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--====== Javascripts & Jquery ======-->\r\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.slicknav.min.js\"></script>\r\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.nicescroll.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.zoom.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
