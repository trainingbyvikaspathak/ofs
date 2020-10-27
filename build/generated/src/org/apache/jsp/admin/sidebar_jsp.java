package org.apache.jsp.admin;

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

      out.write("<ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\n");
      out.write("\n");
      out.write("      <!-- Sidebar - Brand -->\n");
      out.write("      <a class=\"sidebar-brand d-flex align-items-center justify-content-center\" href=\"#\">\n");
      out.write("        <div class=\"sidebar-brand-icon rotate-n-15\">\n");
      out.write("          <i class=\"fas fa-laugh-wink\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"sidebar-brand-text mx-3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'s Dashboard</div>\n");
      out.write("      </a>\n");
      out.write("\n");
      out.write("      <!-- Divider -->\n");
      out.write("      <hr class=\"sidebar-divider my-0\">\n");
      out.write("\n");
      out.write("      <!-- Nav Item - Dashboard -->\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <a class=\"nav-link\" href=\"adminhome.jsp\">\n");
      out.write("          <i class=\"fas fa-fw fa-tachometer-alt\"></i>\n");
      out.write("          <span>Dashboard</span></a>\n");
      out.write("      </li>\n");
      out.write("\n");
      out.write("      <!-- Divider -->\n");
      out.write("      <hr class=\"sidebar-divider\">\n");
      out.write("\n");
      out.write("      <!-- Nav Item - Pages Collapse Menu -->\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"true\" aria-controls=\"collapseTwo\">\n");
      out.write("          <i class=\"fas fa-fw fa-cog\"></i>\n");
      out.write("          <span>Manage Reporters</span>\n");
      out.write("        </a>\n");
      out.write("        <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\n");
      out.write("          <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("            <h6 class=\"collapse-header\">Custom Reporters:</h6>\n");
      out.write("            <a class=\"collapse-item\" href=\"addReporter.jsp\">Add Reporter</a>\n");
      out.write("            <a class=\"collapse-item\" href=\"viewReporter.jsp\">View Reporters</a>\n");
      out.write("            <a class=\"collapse-item\" href=\"statusReporter.jsp\">Update Status</a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("\n");
      out.write("      <!-- Nav Item - Utilities Collapse Menu -->\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\" aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\n");
      out.write("          <i class=\"fas fa-fw fa-wrench\"></i>\n");
      out.write("          <span>Manage News</span>\n");
      out.write("        </a>\n");
      out.write("        <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\n");
      out.write("          <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("            <h6 class=\"collapse-header\">Custom News:</h6>\n");
      out.write("            <a class=\"collapse-item\" href=\"showNews.jsp\">All News</a>\n");
      out.write("            <a class=\"collapse-item\" href=\"updateNews.jsp\">Update News</a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("\n");
      out.write("      <!-- Divider -->\n");
      out.write("      <hr class=\"sidebar-divider\">\n");
      out.write("\n");
      out.write("      <!-- Heading -->\n");
      out.write("      <div class=\"sidebar-heading\">\n");
      out.write("        Addons\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <!-- Nav Item - Pages Collapse Menu -->\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapsePages\" aria-expanded=\"true\" aria-controls=\"collapsePages\">\n");
      out.write("          <i class=\"fas fa-fw fa-folder\"></i>\n");
      out.write("          <span>Pages</span>\n");
      out.write("        </a>\n");
      out.write("        <div id=\"collapsePages\" class=\"collapse\" aria-labelledby=\"headingPages\" data-parent=\"#accordionSidebar\">\n");
      out.write("          <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("            <h6 class=\"collapse-header\">Login Screens:</h6>\n");
      out.write("            <a class=\"collapse-item\" href=\"#\">Add Admin</a>\n");
      out.write("            <a class=\"collapse-item\" href=\"#\">Remove Admin</a>\n");
      out.write("            <a class=\"collapse-item\" href=\"forgot-password.html\">Forgot Password</a>\n");
      out.write("            <div class=\"collapse-divider\"></div>\n");
      out.write("            <h6 class=\"collapse-header\">Other Pages:</h6>\n");
      out.write("            <a class=\"collapse-item\" href=\"404.html\">404 Page</a>\n");
      out.write("            <a class=\"collapse-item\" href=\"blank.html\">Blank Page</a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("\n");
      out.write("      <!-- Nav Item - Charts -->\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"viewQueries.jsp\">\n");
      out.write("          <i class=\"fas fa-fw fa-chart-area\"></i>\n");
      out.write("          <span>Queries</span></a>\n");
      out.write("      </li>\n");
      out.write("\n");
      out.write("      <!-- Nav Item - Tables -->\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"viewSubscribers.jsp\">\n");
      out.write("          <i class=\"fas fa-fw fa-table\"></i>\n");
      out.write("          <span>Subscribers</span></a>\n");
      out.write("      </li>\n");
      out.write("\n");
      out.write("      <!-- Divider -->\n");
      out.write("      <hr class=\"sidebar-divider d-none d-md-block\">\n");
      out.write("\n");
      out.write("          \n");
      out.write("\n");
      out.write("\n");
      out.write("    </ul>\n");
      out.write("\n");
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
