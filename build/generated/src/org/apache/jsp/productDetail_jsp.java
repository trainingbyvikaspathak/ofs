package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.daos.ReviewDao;
import com.beans.Review;
import com.daos.ShopkeeperDao;
import com.beans.Product;
import com.daos.ProductDao;

public final class productDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("<head>\n");
      out.write("\t<title>Cart | eCommerce</title>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("\t<!-- Stylesheets -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"/>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\"/>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/flaticon.css\"/>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/slicknav.min.css\"/>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/jquery-ui.min.css\"/>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\"/>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/animate.css\"/>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style.css\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!-- Page Preloder -->\n");
      out.write("\t<div id=\"preloder\">\n");
      out.write("\t\t<div class=\"loader\"></div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- Header section -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\t<!-- Header section end -->\n");
 
if(request.getAttribute("submitReview")!=null){
      out.write('\n');
      com.beans.Review review = null;
      synchronized (session) {
        review = (com.beans.Review) _jspx_page_context.getAttribute("review", PageContext.SESSION_SCOPE);
        if (review == null){
          review = new com.beans.Review();
          _jspx_page_context.setAttribute("review", review, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("review"), request);
      out.write('\n');
      out.write('\n');

    ReviewDao rd = new ReviewDao();
    Review rw = (Review) session.getAttribute("review");
    rd.add(review);
}
    
      out.write("\n");
      out.write("\n");
      out.write("\t<!-- Page info -->\n");
      out.write("\t<div class=\"page-top-info\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<h4>Product Details</h4>\n");
      out.write("\t\t\t \n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- Page info end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<!-- cart section end -->\n");
      out.write("\t<section class=\"cart-section spad\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-lg-8\">\n");
      out.write("\t\t\t\t\t<div class=\"cart-table\">\n");
      out.write("\t\t\t\t\t\t<h3>Product Details</h3>\n");
      out.write("\t\t\t\t\t\t<div class=\"cart-table-warp\">\n");
      out.write("                                                ");
 ProductDao pd = new ProductDao();
                                                Product product = pd.getById(Integer.parseInt(request.getParameter("pid")));
                                                
      out.write("\n");
      out.write("                                                <table class=\"table\" style=\"font-size: 16px\">\n");
      out.write("                                                    <tbody>\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\n");
      out.write("                                                                    <th rowspan=\"7\">\n");
      out.write("                                                                            <img src=\"");
      out.print(product.getImage());
      out.write("\" style=\"border-width:2px; border-radius: 5px;width:400px;height: 500px;\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t\t\t\t</th>\n");
      out.write("                                                                        <th>");
      out.print(product.getName());
      out.write("</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t\t\t</tr>\n");
      out.write("                                                                <tr>\n");
      out.write("                                                                    <th><b> Size : </b> ");
      out.print(product.getSize());
      out.write("</th>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                \n");
      out.write("                                                                    <tr>\n");
      out.write("                                                                    <th><b> Brand : </b> ");
      out.print(product.getBrand());
      out.write("</th>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                \n");
      out.write("                                                                    <tr>\n");
      out.write("                                                                        <th><b> Sold By : </b> ");
      out.print(new ShopkeeperDao().getById(product.getSeller_id()).getShopName());
      out.write("</th>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                    <tr>\n");
      out.write("                                                                    <th><b> MRP  : </b> ");
      out.print(product.getPrice());
      out.write("</th>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                     <tr>\n");
      out.write("                                                                    <th><b> Our Price  : </b> ");
      out.print(product.getSelling_price() );
      out.write("</th>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                  </tr>\n");
      out.write("                                                                    <tr>\n");
      out.write("                                                                    <th><b> Description  : </b> ");
      out.print(product.getDescription());
      out.write("</th>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                    </tbody>\n");
      out.write("\t\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"total-cost\">\n");
      out.write("\t\t\t\t\t\t\t<h6>Price :  <span>&#x20B9;");
      out.print(product.getSelling_price());
      out.write("</span></h6>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-lg-4 card-right\">\n");
      out.write("                                    Select Qunatity of Product :<br/>\n");
      out.write("                                    <select name=\"quantity\" class=\"dropdown-item dropdown-header form-control\">\n");
      out.write("                                        ");
for (int i=1;i<=5 && i<=product.getStock(); i++){
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                    </select> <br/><br/>\n");
      out.write("                                    \n");
      out.write("\t\t\t\t\t<a href=\"\" class=\"site-btn\">Add to Cart</a> <br/> <br/>\n");
      out.write("                                        <a href=\"\" class=\"site-btn\">View Cart and Checkout</a> <br/><br/>\n");
      out.write("\t\t\t\t\t<a href=\"\" class=\"site-btn sb-dark\">Continue shopping</a>\n");
      out.write("\t\t\t\t \n");
      out.write("                                    <h4>Reviews of Products</h4>\n");
      out.write("                                    <div class=\"container\" style=\"overflow: hidden; height: 300px;\">\n");
      out.write("                                        ");
 for (Review review : new ReviewDao().getAllReviewByproductId(product.getId())){
      out.write(" \n");
      out.write("                                        <div class=\"row bg-info\" style=\"border-radius: 10px\">\n");
      out.write("                                            <div class=\"col\">\n");
      out.write("                                                <b>");
      out.print(review.getName());
      out.write("</b><br/> \n");
      out.write("                                                ");
      out.print(review.getMessage());
      out.write(" <br/>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</section>\n");
      out.write("\t<!-- cart section end -->\n");
      out.write("\n");
      out.write("\t<!-- Related product section -->\n");
      out.write("\t<section class=\"related-product-section\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col col-md-12 col-sm-12\">\n");
      out.write("                            <center><h4> Give Review to above product</h4></center> <br/>\n");
      out.write("                            <form method=\"post\" class=\"form\">\n");
      out.write("                                <table class=\"table  bg-info\" style=\"border-radius: 10px\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Name</td> \n");
      out.write("                                    <td><input type=\"text\" name=\"name\" class=\"form-control\" required=\"required\"/>\n");
      out.write("                                        <input type=\"hidden\" name=\"shopkeeper_id\" value=\"");
      out.print(new ShopkeeperDao().getById(product.getSeller_id()).getId());
      out.write("\"/>\n");
      out.write("                                        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print(product.getId());
      out.write("\"/>\n");
      out.write("                                 \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Subject (Review/Complain) </td>\n");
      out.write("                                    <td><input type=\"text\" name=\"subject\" class=\"form form-control\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                 <tr>\n");
      out.write("                                    <td>email </td>\n");
      out.write("                                    <td><input type=\"email\" name=\"email\" class=\"form form-control\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                \n");
      out.write("                                <tr>\n");
      out.write("                                    <td> Message </td>\n");
      out.write("                                    <td><textarea name=\"message\" class=\"form-control\" required=\"required\"></textarea></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th colspan=\"2\">\n");
      out.write("                                        <input type=\"submit\" class=\"form-control btn btn-dark\" name=\"submitReview\"/>\n");
      out.write("                                    </th>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\t\t \n");
      out.write("\t\t</div>\n");
      out.write("\t</section>\n");
      out.write("\t<!-- Related product section end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<!-- Footer section -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\t<!-- Footer section end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<!--====== Javascripts & Jquery ======-->\n");
      out.write("\t<script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\t<script src=\"js/jquery.slicknav.min.js\"></script>\n");
      out.write("\t<script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("\t<script src=\"js/jquery.nicescroll.min.js\"></script>\n");
      out.write("\t<script src=\"js/jquery.zoom.min.js\"></script>\n");
      out.write("\t<script src=\"js/jquery-ui.min.js\"></script>\n");
      out.write("\t<script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("\t</body>\n");
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
