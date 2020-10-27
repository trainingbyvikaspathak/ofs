package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zxx\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Cart | eCommerce</title>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\r\n");
      out.write("\t<!-- Stylesheets -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/flaticon.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/slicknav.min.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/jquery-ui.min.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/animate.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style.css\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- Page Preloder -->\r\n");
      out.write("\t<div id=\"preloder\">\r\n");
      out.write("\t\t<div class=\"loader\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Header section -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\t<!-- Header section end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Page info -->\r\n");
      out.write("\t<div class=\"page-top-info\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<h4>Your cart</h4>\r\n");
      out.write("\t\t\t<div class=\"site-pagination\">\r\n");
      out.write("\t\t\t\t<a href=\"home.jsp\">Home</a> /\r\n");
      out.write("\t\t\t\t<a href=\"cart.jsp\">Your cart</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- Page info end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- cart section end -->\r\n");
      out.write("\t<section class=\"cart-section spad\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-8\">\r\n");
      out.write("\t\t\t\t\t<div class=\"cart-table\">\r\n");
      out.write("\t\t\t\t\t\t<h3>Your Cart</h3>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cart-table-warp\">\r\n");
      out.write("\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th class=\"product-th\">Product</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th class=\"quy-th\">Quantity</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th class=\"size-th\">SizeSize</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th class=\"total-th\">Price</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"product-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"img/cart/1.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"pc-title\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4>Animal Print Dress</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>$45.90</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"quy-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"quantity\">\r\n");
      out.write("\t\t\t\t\t                        <div class=\"pro-qty\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("                    \t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"size-col\"><h4>Size M</h4></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"total-col\"><h4>$45.90</h4></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"product-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"img/cart/2.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"pc-title\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4>Ruffle Pink Top</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>$45.90</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"quy-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"quantity\">\r\n");
      out.write("\t\t\t\t\t                        <div class=\"pro-qty\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("                    \t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"size-col\"><h4>Size M</h4></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"total-col\"><h4>$45.90</h4></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"product-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"img/cart/3.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"pc-title\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4>Skinny Jeans</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>$45.90</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"quy-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"quantity\">\r\n");
      out.write("\t\t\t\t\t                        <div class=\"pro-qty\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("                    \t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"size-col\"><h4>Size M</h4></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"total-col\"><h4>$45.90</h4></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"total-cost\">\r\n");
      out.write("\t\t\t\t\t\t\t<h6>Total <span>$99.90</span></h6>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-4 card-right\">\r\n");
      out.write("                                    <form class=\"form\" style=\"font-family: corbel; font-size:20px\">\r\n");
      out.write("\t\t\t\t\t\tSelect Payment Method : <br/>\r\n");
      out.write("                                                <input type=\"radio\" name=\"payment_mode\" value=\"COD\" />Cash On Delivery <br/><br/><br/>\r\n");
      out.write("                                                \r\n");
      out.write("                                                <input type=\"radio\" name=\"address\" value=\"\"/>Deliver on Following Address <br/>\r\n");
      out.write("                                                <fieldset class=\"form-control\" style=\"height: 100px;\">\r\n");
      out.write("                                                    \r\n");
      out.write("                                                </fieldset>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("                                    <a href=\"\" class=\"site-btn\">Proceed to checkout <br/> (Confirm Order)</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"\" class=\"site-btn sb-dark\">Continue shopping</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- cart section end -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- Related product section -->\r\n");
      out.write("\t<section class=\"related-product-section\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"section-title text-uppercase\">\r\n");
      out.write("                            <a href=\"category.jsp\" class=\"btn btn-primary text-white\" style=\"border-radius: 25px\"><h6>Continue Shopping</h6></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- Related product section end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Footer section -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t<!-- Footer section end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!--====== Javascripts & Jquery ======-->\r\n");
      out.write("\t<script src=\"js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery.slicknav.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery.nicescroll.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery.zoom.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery-ui.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
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
