package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Category;
import com.daos.CategoryDao;
import com.beans.Product;
import java.util.ArrayList;
import com.daos.ProductDao;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<section class=\"product-filter-section\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"section-title\">\r\n");
      out.write("\t\t\t\t<h2>BROWSE TOP SELLING PRODUCTS</h2>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<ul class=\"product-filter-menu\">\r\n");
      out.write("                            ");

                            CategoryDao cd = new  CategoryDao();
                            ArrayList<Category>  clist  = cd.getAllCategory();
                            for(int i=0;i<7;i++){
                            
      out.write("\r\n");
      out.write("                            <li><a href=\"home.jsp?catid=");
      out.print((clist.get(i)).getId());
      out.write("&category=");
      out.print((clist.get(i)).getName());
      out.write('"');
      out.write('>');
      out.print((clist.get(i)).getName());
      out.write(" </a></li>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("                            \r\n");
      out.write("                            ");

                                ProductDao pdo = new ProductDao();
                                ArrayList<Product> plist = null; 
                            if(request.getParameter("catid")==null)
                                plist = pdo.getAllProductByLimit(8);
                                
                            else
                                plist = pdo.getAllProductByCategory(request.getParameter("category"));
                             
                                for(int i=0; i<8 && i<plist.size(); i++){
                                    Product product = plist.get(i); 
                               
                            
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-3 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"product-item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pi-pic\">\r\n");
      out.write("                                                    <img src=\"");
      out.print(product.getImage());
      out.write("\" alt=\"\" style=\"height: 400px; border-width: 2px; border-style: solid;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"pi-links\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\" class=\"add-card\"><i class=\"flaticon-bag\"></i><span>ADD TO CART</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\" class=\"wishlist-btn\"><i class=\"flaticon-heart\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pi-text\">\r\n");
      out.write("\t\t\t\t\t\t\t<h6>&#x20B9; <s>");
      out.print(product.getPrice());
      out.write("</s> <br/>&#x20B9;  ");
      out.print(product.getSelling_price());
      out.write(" </h6>\r\n");
      out.write("\t\t\t\t\t\t\t<p>");
      out.print(product.getName());
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("                                                ");
}
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"text-center pt-5\">\r\n");
      out.write("                            <a href=\"category.jsp\" class=\"site-btn sb-line sb-dark\">LOAD MORE</a>\r\n");
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
