package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Customer;
import com.daos.CategoryDao;
import com.beans.Category;
import com.daos.WeartypeDao;
import com.beans.WearType;
import java.util.ArrayList;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<header class=\"header-section\">\r\n");
      out.write("\t\t<div class=\"header-top\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-2 text-center text-lg-left\">\r\n");
      out.write("\t\t\t\t\t\t<!-- logo -->\r\n");
      out.write("\t\t\t\t\t\t<a href=\"home.jsp\" class=\"site-logo\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"img/LOGO2.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xl-4 col-lg-5\">\r\n");
      out.write("\t\t\t\t\t\t<form class=\"header-search-form\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" placeholder=\"Search on online fasion store ....\">\r\n");
      out.write("\t\t\t\t\t\t\t<button><i class=\"flaticon-search\"></i></button>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xl-4 col-lg-5\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"user-panel\">\r\n");
      out.write("                                                    ");
 if (session.getAttribute("customer")==null && session.getAttribute("admin")==null && session.getAttribute("shopkeeper")==null ) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"up-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"flaticon-profile\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"login.jsp\">Sign</a> In or <a href=\"Registration.jsp\">Create Account</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("                                                        ");
} else {
      out.write("\r\n");
      out.write("                                                        <div class=\"up-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"flaticon-profile\"></i>\r\n");
      out.write("                                                                <a href=\"logout.jsp\">Logout</a>\r\n");
      out.write("                                                                <a href=\"home.jsp\"></a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("                                                        ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"up-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"shopping-card\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"flaticon-bag\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>0</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"cart.jsp\">Shopping Cart</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("                                    \r\n");
      out.write("                                    <div class=\"col-lg-2 text-center\">\r\n");
      out.write("\t\t\t\t\t\t<!-- logo -->\r\n");
      out.write("                                              <a href=\"home.jsp\" class=\"site-logo\"> \r\n");
      out.write("                                                  ");
 if(session.getAttribute("customer")==null){
      out.write("\r\n");
      out.write("                                                     <img src=\"img/login.png\" class=\"img-profile\" style=\"width:50px;height: 50px;\"/> <br/> Guest\r\n");
      out.write("                                                     ");
} else {Customer customer = (Customer)session.getAttribute("customer"); 
      out.write("\r\n");
      out.write("                                                        <img src=\"");
      out.print(customer.getImage());
      out.write("\" class=\"img-profile rounded-circle \" style=\"width:50px;height: 50px;\"/> <br/> ");
      out.print(customer.getName());
      out.write("\r\n");
      out.write("                                                    ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<nav class=\"main-navbar\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<!-- menu -->\r\n");
      out.write("\t\t\t\t<ul class=\"main-menu\">\r\n");
      out.write("                                    <li><a href=\"home.jsp\">Home</a></li>\r\n");
      out.write("                                    ");
 
                                        WeartypeDao wd = new WeartypeDao();
                                    ArrayList<WearType> wears  = wd.getAllWeartype(); 
                                    for(WearType w : wears){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"category.jsp?msg=");
      out.print(w.getName());
      out.write(" wear&weartype_id=");
      out.print(w.getId());
      out.write("\"> ");
      out.print(w.getName());
      out.write(" wear</a></li>\r\n");
      out.write("\t\t\t\t\t ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Search By Category</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sub-menu\">\r\n");
      out.write("                                                    ");

                                                        CategoryDao cd =new CategoryDao();
                                                        ArrayList<Category> cats = cd.getAllCategory();
                                                        for (Category cat : cats) {
                                                    
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"category.jsp?msg=Selected Category : ");
      out.print(cat.getName());
      out.write("&category_id=");
      out.print(cat.getId());
      out.write('"');
      out.write('>');
      out.print(cat.getName());
      out.write(" </a></li>\r\n");
      out.write("                                                        ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("                                        <li><a href=\"nearByShops.jsp?msg=Shops Near By You...\">NearBy Shops</a></li>\r\n");
      out.write("                                        <li><a href=\"./contact.jsp\">Contact Us</a></li>\r\n");
      out.write("\t\t\t\t\t<!--<li><a href=\"#\">Pages</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sub-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"./product.jsp\">Product Page</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"./category.jsp\">Category Page</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"./cart.jsp\">Cart Page</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"./checkout.jsp\">Checkout Page</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"./contact.jsp\">Contact Page</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li> -->\r\n");
      out.write("                                        \r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">My Order</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sub-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Return</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Shipping</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Track Order</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Account</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</header>");
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
