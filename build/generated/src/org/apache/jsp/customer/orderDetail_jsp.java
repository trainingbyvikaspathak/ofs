package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Product;
import com.beans.Cart;
import com.beans.Address;
import com.daos.AddressDao;
import com.daos.ProductDao;
import com.beans.Orders;
import com.beans.Customer;
import com.sun.xml.ws.rx.rm.policy.metro200603.OrderedDeliveryAssertion;
import com.daos.OrderDao;
import com.beans.Queries;
import com.daos.QueryDao;
import java.util.ArrayList;

public final class orderDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("  <title>All Queries</title>\n");
      out.write(" <link rel=\"icon\" href=\"assets/img/admin.ico\" type=\"x/image\"/>\n");
      out.write("  <!-- Custom fonts for this template-->\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body id=\"page-top\">\n");
      out.write("    ");

        Customer customer = (Customer)session.getAttribute("customer");
        if (customer==null){
            response.sendRedirect("../login.jsp");
            return;
        }
        
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("        function makeConfirm(){\n");
      out.write("            if(confirm(\"do you want to cancel order ?\"))\n");
      out.write("                return true;\n");
      out.write("            else\n");
      out.write("                return false;\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("  <!-- Page Wrapper -->\n");
      out.write("  <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("    <!-- Sidebar -->\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\n");
      out.write("    <!-- End of Sidebar -->\n");
      out.write("\n");
      out.write("    <!-- Content Wrapper -->\n");
      out.write("    <div id=\"content-wrapper\" class=\"d-flex flex-column\">\n");
      out.write("\n");
      out.write("      <!-- Main Content -->\n");
      out.write("      <div id=\"content\">\n");
      out.write("\n");
      out.write("        <!-- Topbar -->\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "topbar.jsp", out, false);
      out.write("\n");
      out.write("        <!-- End of Topbar -->\n");
      out.write("\n");
      out.write("        <!-- Begin Page Content -->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\n");
      out.write("              <a href=\"#\" class=\"d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm\"><i class=\"fas fa-download fa-sm text-white-50\"></i> Generate Report</a>\n");
      out.write("          </div>\n");
      out.write("            <h3>Order Details :</h3>\n");
      out.write("             <table>\n");
      out.write("                                         \n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Product Image</td>\n");
      out.write("                                                <th>Name</th>\n");
      out.write("                                                <th>Price</th>\n");
      out.write("                                                <th>Quantity</th>\n");
      out.write("                                                <th>Size</th>\n");
      out.write("                                                \n");
      out.write("                                                <th class=\"total-th\">Amount</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        \n");
      out.write("                                    ");

                                        int orderId  = Integer.parseInt(request.getParameter("order_id"));
                                        float total=0;
                                        OrderDao od = new OrderDao();
                                        ArrayList<Cart> cart = od.getOrderDetails(orderId);
                                        ProductDao pd = new ProductDao();
                                        //System.out.println("hello.....");
                                        System.out.println("cart size : "+ cart.size());
                                        int i = 0;
                                        for (Cart c : cart) {
                                            Product product = pd.getById(c.getProduct_id());
                                            System.out.println("one....");
                                        
                                    
      out.write("\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"product-col\">\n");
      out.write("                                                <img src=\"../");
      out.print(product.getImage());
      out.write(" \" alt=\"\">\n");
      out.write("                                                <div class=\"pc-title\">\n");
      out.write("                                                    <h4>");
      out.print(product.getName());
      out.write("</h4>\n");
      out.write("                                                    <p>&#x20B9; ");
      out.print(product.getSelling_price());
      out.write("</p>\n");
      out.write("                                                </div>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td class=\"quy-col\">\n");
      out.write("                                                <div class=\"quantity\">\n");
      out.write("                                                   ");
      out.print(c.getQuanity());
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td class=\"size-col\"><h4>Size ");
      out.print(product.getSize());
      out.write("</h4></td>\n");
      out.write("                                            <td class=\"total-col\"><h4>&#x20B9; ");
      out.print(c.getAmount());
      out.write("</h4></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        ");
 total += c.getAmount();i++;}
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                                    <h4>Total Billing Amount : &#x20B9;");
      out.print(total);
      out.write("</h4>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <!-- End of Main Content -->\n");
      out.write("\n");
      out.write("      <!-- Footer -->\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("      <!-- End of Footer -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- End of Content Wrapper -->\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <!-- End of Page Wrapper -->\n");
      out.write("</body>\n");
      out.write("\n");
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
