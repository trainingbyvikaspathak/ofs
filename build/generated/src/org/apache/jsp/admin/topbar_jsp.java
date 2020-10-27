package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class topbar_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\r\n");
      out.write("\r\n");
      out.write("          <!-- Sidebar Toggle (Topbar) -->\r\n");
      out.write("          <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\r\n");
      out.write("            <i class=\"fa fa-bars\"></i>\r\n");
      out.write("          </button>\r\n");
      out.write("\r\n");
      out.write("          <!-- Topbar Search -->\r\n");
      out.write("          <form class=\"d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search\">\r\n");
      out.write("            <div class=\"input-group\">\r\n");
      out.write("              <input type=\"text\" class=\"form-control bg-light border-0 small\" placeholder=\"Search for...\" aria-label=\"Search\" aria-describedby=\"basic-addon2\">\r\n");
      out.write("              <div class=\"input-group-append\">\r\n");
      out.write("                <button class=\"btn btn-primary\" type=\"button\">\r\n");
      out.write("                  <i class=\"fas fa-search fa-sm\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("\r\n");
      out.write("          <!-- Topbar Navbar -->\r\n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Nav Item - Search Dropdown (Visible Only XS) -->\r\n");
      out.write("            <li class=\"nav-item dropdown no-arrow d-sm-none\">\r\n");
      out.write("              <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"searchDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                <i class=\"fas fa-search fa-fw\"></i>\r\n");
      out.write("              </a>\r\n");
      out.write("              <!-- Dropdown - Messages -->\r\n");
      out.write("              <div class=\"dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in\" aria-labelledby=\"searchDropdown\">\r\n");
      out.write("                <form class=\"form-inline mr-auto w-100 navbar-search\">\r\n");
      out.write("                  <div class=\"input-group\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control bg-light border-0 small\" placeholder=\"Search for...\" aria-label=\"Search\" aria-describedby=\"basic-addon2\">\r\n");
      out.write("                    <div class=\"input-group-append\">\r\n");
      out.write("                      <button class=\"btn btn-primary\" type=\"button\">\r\n");
      out.write("                        <i class=\"fas fa-search fa-sm\"></i>\r\n");
      out.write("                      </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </form>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <!-- Nav Item - Alerts -->\r\n");
      out.write("            <li class=\"nav-item dropdown no-arrow mx-1\">\r\n");
      out.write("              <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"alertsDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                <i class=\"fas fa-bell fa-fw\"></i>\r\n");
      out.write("                <!-- Counter - Alerts -->\r\n");
      out.write("                <span class=\"badge badge-danger badge-counter\">3+</span>\r\n");
      out.write("              </a>\r\n");
      out.write("              <!-- Dropdown - Alerts -->\r\n");
      out.write("              <div class=\"dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in\" aria-labelledby=\"alertsDropdown\">\r\n");
      out.write("                <h6 class=\"dropdown-header\">\r\n");
      out.write("                  Alerts Center\r\n");
      out.write("                </h6>\r\n");
      out.write("                <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n");
      out.write("                  <div class=\"mr-3\">\r\n");
      out.write("                    <div class=\"icon-circle bg-primary\">\r\n");
      out.write("                      <i class=\"fas fa-file-alt text-white\"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div>\r\n");
      out.write("                    <div class=\"small text-gray-500\">December 12, 2019</div>\r\n");
      out.write("                    <span class=\"font-weight-bold\">A new monthly report is ready to download!</span>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </a>\r\n");
      out.write("                <a class=\"dropdown-item text-center small text-gray-500\" href=\"#\">Show All Alerts</a>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <!-- Nav Item - Messages -->\r\n");
      out.write("            <li class=\"nav-item dropdown no-arrow mx-1\">\r\n");
      out.write("              <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"messagesDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                <i class=\"fas fa-envelope fa-fw\"></i>\r\n");
      out.write("                <!-- Counter - Messages -->\r\n");
      out.write("                <span class=\"badge badge-danger badge-counter\">7</span>\r\n");
      out.write("              </a>\r\n");
      out.write("              <!-- Dropdown - Messages -->\r\n");
      out.write("              <div class=\"dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in\" aria-labelledby=\"messagesDropdown\">\r\n");
      out.write("                <h6 class=\"dropdown-header\">\r\n");
      out.write("                  Message Center\r\n");
      out.write("                </h6>\r\n");
      out.write("                <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n");
      out.write("                  <div class=\"dropdown-list-image mr-3\">\r\n");
      out.write("                    <img class=\"rounded-circle\" src=\"https://source.unsplash.com/fn_BT9fwg_E/60x60\" alt=\"\">\r\n");
      out.write("                    <div class=\"status-indicator bg-success\"></div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"font-weight-bold\">\r\n");
      out.write("                    <div class=\"text-truncate\">Hi there! I am wondering if you can help me with a problem I've been having.</div>\r\n");
      out.write("                    <div class=\"small text-gray-500\">Emily Fowler · 58m</div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </a>\r\n");
      out.write("                <a class=\"dropdown-item text-center small text-gray-500\" href=\"#\">Read More Messages</a>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"topbar-divider d-none d-sm-block\"></div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Nav Item - User Information -->\r\n");
      out.write("            <li class=\"nav-item dropdown no-arrow\">\r\n");
      out.write("              <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                  <span class=\"mr-2 d-none d-lg-inline text-gray-600 small\"><b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b></span>\r\n");
      out.write("                <img class=\"img-profile rounded-circle\" src=\"../");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("              </a>\r\n");
      out.write("              <!-- Dropdown - User Information -->\r\n");
      out.write("              <div class=\"dropdown-menu dropdown-menu-right shadow animated--grow-in\" aria-labelledby=\"userDropdown\">\r\n");
      out.write("                <a class=\"dropdown-item\" href=\"#\">\r\n");
      out.write("                  <i class=\"fas fa-user fa-sm fa-fw mr-2 text-gray-400\"></i>\r\n");
      out.write("                  Profile\r\n");
      out.write("                </a>\r\n");
      out.write("                <a class=\"dropdown-item\" href=\"#\">\r\n");
      out.write("                  <i class=\"fas fa-cogs fa-sm fa-fw mr-2 text-gray-400\"></i>\r\n");
      out.write("                  Settings\r\n");
      out.write("                </a>\r\n");
      out.write("                <a class=\"dropdown-item\" href=\"#\">\r\n");
      out.write("                  <i class=\"fas fa-list fa-sm fa-fw mr-2 text-gray-400\"></i>\r\n");
      out.write("                  Activity Log\r\n");
      out.write("                </a>\r\n");
      out.write("                <div class=\"dropdown-divider\"></div>\r\n");
      out.write("                <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#logoutModal\">\r\n");
      out.write("                  <i class=\"fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400\"></i>\r\n");
      out.write("                  Logout\r\n");
      out.write("                </a>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("          </ul>\r\n");
      out.write("\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("<!-- Logout Modal-->\r\n");
      out.write("  <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <h5 class=\"modal-title\" id=\"exampleModalLabel\">Ready to Leave?</h5>\r\n");
      out.write("          <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("            <span aria-hidden=\"true\">×</span>\r\n");
      out.write("          </button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-body\">Select \"Logout\" below if you are ready to end your current session.</div>\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("          <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">Cancel</button>\r\n");
      out.write("          <a class=\"btn btn-primary\" href=\"logout.jsp\">Logout</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>");
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
