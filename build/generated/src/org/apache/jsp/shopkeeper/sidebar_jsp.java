package org.apache.jsp.shopkeeper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sidebar_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<ul class=\"navbar-nav bg-success sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Sidebar - Brand -->\r\n");
      out.write("      <a class=\"sidebar-brand d-flex align-items-center justify-content-center\" href=\"#\">\r\n");
      out.write("        <div class=\"sidebar-brand-icon rotate-n-15\">\r\n");
      out.write("          <i class=\"fas fa-laugh-wink\"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"sidebar-brand-text mx-3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shopkeeper.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'s Dashboard</div>\r\n");
      out.write("      </a>\r\n");
      out.write("\r\n");
      out.write("      <!-- Divider -->\r\n");
      out.write("      <hr class=\"sidebar-divider my-0\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Nav Item - Dashboard -->\r\n");
      out.write("      <li class=\"nav-item active\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"shopkeeperhome.jsp\">\r\n");
      out.write("          <i class=\"fas fa-fw fa-tachometer-alt\"></i>\r\n");
      out.write("          <span>Dashboard</span></a>\r\n");
      out.write("      </li>\r\n");
      out.write("\r\n");
      out.write("      <!-- Divider -->\r\n");
      out.write("      <hr class=\"sidebar-divider\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Nav Item - Pages Collapse Menu -->\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"true\" aria-controls=\"collapseTwo\">\r\n");
      out.write("          <i class=\"fas fa-fw fa-cog\"></i>\r\n");
      out.write("          <span>Manage Products</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("          <div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("            <h6 class=\"collapse-header\">Custom Products:</h6>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"addProduct.jsp\">Add Product</a>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"viewProducts.jsp\">View / Update Product</a>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"viewPendingProducts.jsp\">Pending Products</a>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"viewApprovedProducts.jsp\">Approved Products</a>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"viewRejectedProducts.jsp\">Rejected Products</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("\r\n");
      out.write("      <!-- Nav Item - Utilities Collapse Menu -->\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\" aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\r\n");
      out.write("          <i class=\"fas fa-fw fa-wrench\"></i>\r\n");
      out.write("          <span>Shopkeeper Section</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("          <div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("            <h6 class=\"collapse-header\">Manage Profile :</h6>\r\n");
      out.write("             <a class=\"collapse-item\" href=\"#\">View Profile</a>\r\n");
      out.write("              <a class=\"collapse-item\" href=\"#\">Edit Profile</a>\r\n");
      out.write("               <a class=\"collapse-item\" href=\"#\">Change Password</a>\r\n");
      out.write("               <a class=\"collapse-item\" href=\"logout.jsp\">Logout</a>\r\n");
      out.write("                 \r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("\r\n");
      out.write("      <!-- Divider -->\r\n");
      out.write("      <hr class=\"sidebar-divider\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Heading -->\r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("      <!-- Nav Item - Charts -->\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("          <i class=\"fas fa-fw fa-chart-area\"></i>\r\n");
      out.write("          <span>Queries</span></a>\r\n");
      out.write("      </li>\r\n");
      out.write("\r\n");
      out.write("      <!-- Nav Item - Tables -->\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("          <i class=\"fas fa-fw fa-table\"></i>\r\n");
      out.write("          <span>Customers</span></a>\r\n");
      out.write("      </li>\r\n");
      out.write("\r\n");
      out.write("      <!-- Divider -->\r\n");
      out.write("      <hr class=\"sidebar-divider d-none d-md-block\">\r\n");
      out.write("\r\n");
      out.write("          \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
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
