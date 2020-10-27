package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Product;
import com.daos.ProductDao;
import com.beans.WearType;
import com.controllers.WeartypeController;
import java.util.ArrayList;
import com.daos.WeartypeDao;

public final class letest_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<section class=\"top-letest-product-section\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"section-title\">\r\n");
      out.write("\t\t\t\t<h2>LADIES WEAR</h2>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"product-slider owl-carousel\">\r\n");
      out.write("                            ");
 
                                    ProductDao pd = new ProductDao();
                                    ArrayList<Product> products = pd.getAllProductByWearType(2); 
                                    for (Product product : products) {
                                
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"product-item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"pi-pic\">\r\n");
      out.write("                                            <img src=\"");
      out.print(product.getImage());
      out.write("\" alt=\"\" height=\"400\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pi-links\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"add-card\"><i class=\"flaticon-bag\"></i><span>ADD TO CART</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"wishlist-btn\"><i class=\"flaticon-heart\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"pi-text\">\r\n");
      out.write("                                            <h6>&#x20B9; <s>");
      out.print(product.getPrice());
      out.write("</s> <br/>&#x20B9;  ");
      out.print(product.getSelling_price());
      out.write(" </h6>\r\n");
      out.write("\t\t\t\t\t\t<p>");
      out.print(product.getName());
      out.write(" </p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t ");
}
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
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
