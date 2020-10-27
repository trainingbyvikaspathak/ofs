package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

public final class viewBooked_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            <h1 class=\"h3 mb-0 text-gray-800\">Your Order History : </h1>\n");
      out.write("            <a href=\"#\" class=\"d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm\"><i class=\"fas fa-download fa-sm text-white-50\"></i> Generate Report</a>\n");
      out.write("          </div>\n");
      out.write("        <table width='700' border='1' cellspacing='0' class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Booking(Order) ID </th>\n");
      out.write("                <th> Booking Date </th>\n");
      out.write("                <th> Total Amount </th>\n");
      out.write("                <th> Payment Mode </th>\n");
      out.write("                <th> Delivery Address </th>\n");
      out.write("                <th> Current Status </th>\n");
      out.write("                <th> Action </th>\n");
      out.write("            </tr>\n");
      out.write("         ");

         OrderDao od = new OrderDao();
         ArrayList<Orders> orders = od.getAllOrdersByCustomerId(customer.getId());
         ProductDao pd = new ProductDao();
         AddressDao ad = new AddressDao();
       
         for(Orders order : orders) {   Address address = ad.getById(order.getAddress_id()); 
      out.write("\n");
      out.write("         \n");
      out.write("         <tr>\n");
      out.write("             <td>");
      out.print(order.getId());
      out.write("</td>\n");
      out.write("             <td><a href=\"#\">");
      out.print(order.getDate());
      out.write("</a></td>\n");
      out.write("             <td>");
      out.print(order.getTotal_amount());
      out.write("</td> \n");
      out.write("             <td>");
      out.print(order.getPayment_mode());
      out.write("</td>\n");
      out.write("             <td>");
      out.print(address.getAddress());
      out.write(',');
      out.write(' ');
      out.print(address.getCity());
      out.write(',');
      out.write(' ');
      out.print(address.getPincode());
      out.write("<br/>(");
      out.print(address.getState());
      out.write(")</td>\n");
      out.write("             <td>");
      out.print(od.getCurrentStatus(order.getId()));
      out.write("</td>\n");
      out.write("             <td>");
if(od.getCurrentStatus(order.getId()).equalsIgnoreCase("Booked/Pending")) { 
      out.write("<a href=\"cancelOrder.jsp?order_id=");
      out.print(order.getId());
      out.write("\">Cancel</a>");
}
      out.write("</td>\n");
      out.write("         </tr>\n");
      out.write("         ");
 } 
      out.write("\n");
      out.write("    </table>\n");
      out.write("    <br/>\n");
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
