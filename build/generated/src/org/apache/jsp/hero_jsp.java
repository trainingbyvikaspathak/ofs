package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hero_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<section class=\"hero-section\">\r\n");
      out.write("\t\t<div class=\"hero-slider owl-carousel\">\r\n");
      out.write("\t\t\t<div class=\"hs-item set-bg\" data-setbg=\"img/bgi.jpg\">\r\n");
      out.write("\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xl-6 col-lg-7 text-white\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>New Arrivals</span>\r\n");
      out.write("\t\t\t\t\t\t\t<h2>denim jackets</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"site-btn sb-line\">DISCOVER</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"site-btn sb-white\">ADD TO CART</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"offer-card text-white\">\r\n");
      out.write("\t\t\t\t\t\t<span>from</span>\r\n");
      out.write("\t\t\t\t\t\t<h2>3000 Rs.</h2>\r\n");
      out.write("\t\t\t\t\t\t<p>SHOP NOW</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"hs-item set-bg\" data-setbg=\"img/bgi2.jpg\">\r\n");
      out.write("\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xl-6 col-lg-7 text-white\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>New Arrivals</span>\r\n");
      out.write("\t\t\t\t\t\t\t<h2>denim jackets</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"site-btn sb-line\">DISCOVER</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"site-btn sb-white\">ADD TO CART</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"offer-card text-white\">\r\n");
      out.write("\t\t\t\t\t\t<span>from</span>\r\n");
      out.write("\t\t\t\t\t\t<h2>2900 Rs.</h2>\r\n");
      out.write("\t\t\t\t\t\t<p>SHOP NOW</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"slide-num-holder\" id=\"snh-1\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>");
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
