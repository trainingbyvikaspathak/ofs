package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.*;
import com.daos.*;
import java.util.ArrayList;

public final class viewReporter_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("        <title>List of Reporters</title>\r\n");
      out.write("        <link rel=\"icon\" href=\"assets/img/admin.ico\" type=\"x/image\"/>\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom fonts for this template-->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\r\n");
      out.write("            <script>\r\n");
      out.write("                function submitForm() {\r\n");
      out.write("                    document.getElementById(\"form1\").submit();\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            </script>\r\n");
      out.write("        </head>\r\n");
      out.write("\r\n");
      out.write("        <body id=\"page-top\">\r\n");
      out.write("        ");

            if (session.getAttribute("admin") == null) {
                response.sendRedirect("../login.jsp");
                return;
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Page Wrapper -->\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Sidebar -->\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("                <!-- End of Sidebar -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Content Wrapper -->\r\n");
      out.write("                <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Main Content -->\r\n");
      out.write("                    <div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("                        <!-- Topbar -->\r\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "topbar.jsp", out, false);
      out.write("\r\n");
      out.write("                        <!-- End of Topbar -->\r\n");
      out.write("\r\n");
      out.write("                        <!-- Begin Page Content -->\r\n");
      out.write("                        <div class=\"container-fluid\">\r\n");
      out.write("                            <form id=\"form1\">\r\n");
      out.write("                                <div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\r\n");
      out.write("                                    <h1 class=\"h3 mb-0 text-gray-800\">List of Reporters</h1>\r\n");
      out.write("                                    <select onchange=\"submitForm();\" name=\"filter\" id=\"filter\" class=\"d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm\">\r\n");
      out.write("                                        <option value=\"-1\">Select Status</option>\r\n");
      out.write("                                        <option value=\"\">All</option>\r\n");
      out.write("                                        <option value=\"approved\">Approved</option>\r\n");
      out.write("                                        <option value=\"rejected\">Rejected</option>\r\n");
      out.write("                                        <option value=\"pending\">Rejected</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <table width='700' border='1' cellspacing='0' class=\"table table-striped\">\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>ID</th>\r\n");
      out.write("                                        <th>Shop Name</th>\r\n");
      out.write("                                        <th>contact Person</th>\r\n");
      out.write("                                        <th>RN</th>\r\n");
      out.write("                                        <th>Address</th>\r\n");
      out.write("                                        <th>PIN</th>\r\n");
      out.write("                                        <th>Contact</th>\r\n");
      out.write("                                        <th>Email </th>\r\n");
      out.write("                                        <th>Status</th>\r\n");
      out.write("                                        <th>Image</th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                ");

                                    ShopkeeperDao sd = new ShopkeeperDao();
                                    ArrayList<Shopkeeper> rows = new ArrayList();
                                    String op = request.getParameter("filter");
                                    System.out.println("op:" + op);
                                    if (op == null || op.equals("") || op.equals("-1")) {
                                      rows = sd.getAllRecords();
                                    } else  {
                                        System.out.println("====");
                                        rows =sd.getAllRecordsByStatus(op);
                                        System.out.println("rows:" + rows.size());
                                    }
                                    int start = request.getParameter("start") != null ? Integer.parseInt(request.getParameter("start")) : 0;
                                    int end = 3;
                                    int total = rows.size(); 
                                    ArrayList<Shopkeeper> rows1;
                                    rows1 = sd.getRowsByLimit(start, end);

                                    for (Shopkeeper shopkeeper : rows) {
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>");
      out.print(shopkeeper.getId());
      out.write(" </td>\r\n");
      out.write("                                    <td>");
      out.print(shopkeeper.getShopName() );
      out.write(" </td>\r\n");
      out.write("                                    <td>");
      out.print(shopkeeper.getName());
      out.write(" </td>\r\n");
      out.write("                                    <td>");
      out.print(shopkeeper.getRN());
      out.write(" </td>\r\n");
      out.write("                                    <td>");
      out.print(shopkeeper.getAddress());
      out.write("</td>\r\n");
      out.write("                                    <td>");
      out.print(shopkeeper.getPin());
      out.write(" </td>\r\n");
      out.write("                                    <td>");
      out.print(shopkeeper.getContact());
      out.write(" </td>\r\n");
      out.write("                                    <td>");
      out.print(shopkeeper.getEmail());
      out.write("</td>\r\n");
      out.write("                                    <td>");
      out.print(shopkeeper.getStatus());
      out.write(" </td>\r\n");
      out.write("                                    <td><img src=\"../");
      out.print(shopkeeper.getImage());
      out.write("\" style=\"width:60px; height: 60px;\"></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("\r\n");
      out.write("                                ");
}
                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </table>\r\n");
      out.write("                            <br/>\r\n");
      out.write("                               <span style=\"float:left\"><a href=\"viewReporter.jsp?start=");
      out.print(start - end);
      out.write("\" class=\"btn btn-primary ");
if (start == 0) {
                                         out.println("disabled");
                                     }
      out.write("\">Previous</a></span>\r\n");
      out.write("                                 <center>\r\n");
      out.write("                                     ");

                                         int pages = total / end + (total % end == 0 ? 0 : 1);
                                         for (int i = 0; i < pages; i++) {
      out.write("\r\n");
      out.write("                                     <span style=\"text-decoration: none; align-content: center;  ");
 if (Math.floor(start / end) == i) {
                                             out.println("background-color: orange");
                                         }
      out.write("\" class=\"btn btn-dark\"><a href=\"viewReporter.jsp?start=");
      out.print(end * i);
      out.write('"');
      out.write('>');
      out.print(i + 1);
      out.write("</a></span> \r\n");
      out.write("                                         ");
}
                                         
      out.write("\r\n");
      out.write("                                                                  <span style=\"float:right\"><a href=\"viewReporter.jsp?start=");
      out.print(start + end);
      out.write("\" class=\"btn btn-primary ");
 if (start + end >= total) {
                                             out.println(" disabled");
                                         }
      out.write("\">Next</a></span>\r\n");
      out.write("\r\n");
      out.write("                            </center> \r\n");
      out.write("                            <br/><br/>  --%>\r\n");
      out.write("                            <a href='addReporter.jsp' class=\"btn btn-primary\"><i class=\"fa fa-plus-square\" aria-hidden=\"true\"></i>Add More Reporters</a>\r\n");
      out.write("\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- End of Main Content -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Footer -->\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("                <!-- End of Footer -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- End of Content Wrapper -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End of Page Wrapper -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
