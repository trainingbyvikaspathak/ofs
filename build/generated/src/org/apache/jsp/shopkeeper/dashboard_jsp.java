package org.apache.jsp.shopkeeper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\n");
      out.write("        <meta name=\"generator\" content=\"Jekyll v3.8.6\">\n");
      out.write("        <title>Shopkeeper Dashboard</title>\n");
      out.write("\n");
      out.write("        <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.4/examples/dashboard/\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("        <!-- Favicons -->\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"/docs/4.4/assets/img/favicons/apple-touch-icon.png\" sizes=\"180x180\">\n");
      out.write("        <link rel=\"icon\" href=\"/docs/4.4/assets/img/favicons/favicon-32x32.png\" sizes=\"32x32\" type=\"image/png\">\n");
      out.write("        <link rel=\"icon\" href=\"/docs/4.4/assets/img/favicons/favicon-16x16.png\" sizes=\"16x16\" type=\"image/png\">\n");
      out.write("        <link rel=\"manifest\" href=\"/docs/4.4/assets/img/favicons/manifest.json\">\n");
      out.write("        <link rel=\"mask-icon\" href=\"/docs/4.4/assets/img/favicons/safari-pinned-tab.svg\" color=\"#563d7c\">\n");
      out.write("        <link rel=\"icon\" href=\"/docs/4.4/assets/img/favicons/favicon.ico\">\n");
      out.write("        <meta name=\"msapplication-config\" content=\"/docs/4.4/assets/img/favicons/browserconfig.xml\">\n");
      out.write("        <meta name=\"theme-color\" content=\"#563d7c\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .bd-placeholder-img {\n");
      out.write("                font-size: 1.125rem;\n");
      out.write("                text-anchor: middle;\n");
      out.write("                -webkit-user-select: none;\n");
      out.write("                -moz-user-select: none;\n");
      out.write("                -ms-user-select: none;\n");
      out.write("                user-select: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            @media (min-width: 768px) {\n");
      out.write("                .bd-placeholder-img-lg {\n");
      out.write("                    font-size: 3.5rem;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body> ");
      com.beans.Shopkeeper shopkeeper = null;
      synchronized (session) {
        shopkeeper = (com.beans.Shopkeeper) _jspx_page_context.getAttribute("shopkeeper", PageContext.SESSION_SCOPE);
        if (shopkeeper == null){
          shopkeeper = new com.beans.Shopkeeper();
          _jspx_page_context.setAttribute("shopkeeper", shopkeeper, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("                 \n");
      out.write("        \n");
      out.write("        ");

            if(session.getAttribute("shopkeeper")==null){
                response.sendRedirect("/fashion_store/login.jsp");
                return;
            }
            System.out.println("welcome " + (shopkeeper.getName()));
       
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navbar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("                    <button class=\"btn btn-primary\" id=\"menu-toggle\">Toggle Menu</button>\n");
      out.write("\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("            <div class=\"row\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                <main role=\"main\" class=\"col-md-9 ml-sm-auto col-lg-10 px-4\">\n");
      out.write("                    <div class=\"d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom\">\n");
      out.write("                        <h1 class=\"h2\">Shopkeeper Dashboard</h1>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </main>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
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
