package org.apache.jsp.assets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <title>Bootstrap All in One Navbar</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Merienda+One\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\n");
      out.write("  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n");
      out.write("  <style>\n");
      out.write("    body {\n");
      out.write("      background: #eeeeee;\n");
      out.write("    }\n");
      out.write("    .form-inline {\n");
      out.write("      display: inline-block;\n");
      out.write("    }\n");
      out.write("    .navbar-header.col {\n");
      out.write("      padding: 0 !important;\n");
      out.write("    }\n");
      out.write("    .navbar {   \n");
      out.write("      background: #fff;\n");
      out.write("      padding-left: 16px;\n");
      out.write("      padding-right: 16px;\n");
      out.write("      border-bottom: 1px solid #d6d6d6;\n");
      out.write("      box-shadow: 0 0 4px rgba(0,0,0,.1);\n");
      out.write("    }\n");
      out.write("    .nav-link img {\n");
      out.write("      border-radius: 50%;\n");
      out.write("      width: 36px;\n");
      out.write("      height: 36px;\n");
      out.write("      margin: -8px 0;\n");
      out.write("      float: left;\n");
      out.write("      margin-right: 10px;\n");
      out.write("    }\n");
      out.write("    .navbar .navbar-brand {\n");
      out.write("      color: #555;\n");
      out.write("      padding-left: 0;\n");
      out.write("      padding-right: 50px;\n");
      out.write("      font-family: 'Merienda One', sans-serif;\n");
      out.write("    }\n");
      out.write("    .navbar .navbar-brand i {\n");
      out.write("      font-size: 20px;\n");
      out.write("      margin-right: 5px;\n");
      out.write("    }\n");
      out.write("    .search-box {\n");
      out.write("      position: relative;\n");
      out.write("    } \n");
      out.write("    .search-box input {\n");
      out.write("      box-shadow: none;\n");
      out.write("      padding-right: 35px;\n");
      out.write("      border-radius: 3px !important;\n");
      out.write("    }\n");
      out.write("    .search-box .input-group-addon {\n");
      out.write("      min-width: 35px;\n");
      out.write("      border: none;\n");
      out.write("      background: transparent;\n");
      out.write("      position: absolute;\n");
      out.write("      right: 0;\n");
      out.write("      z-index: 9;\n");
      out.write("      padding: 7px;\n");
      out.write("      height: 100%;\n");
      out.write("    }\n");
      out.write("    .search-box i {\n");
      out.write("      color: #a0a5b1;\n");
      out.write("      font-size: 19px;\n");
      out.write("    }\n");
      out.write("    .navbar .nav-item i {\n");
      out.write("      font-size: 18px;\n");
      out.write("    }\n");
      out.write("    .navbar .dropdown-item i {\n");
      out.write("      font-size: 16px;\n");
      out.write("      min-width: 22px;\n");
      out.write("    }\n");
      out.write("    .navbar .nav-item.open > a {\n");
      out.write("      background: none !important;\n");
      out.write("    }\n");
      out.write("    .navbar .dropdown-menu {\n");
      out.write("      border-radius: 1px;\n");
      out.write("      border-color: #e5e5e5;\n");
      out.write("      box-shadow: 0 2px 8px rgba(0,0,0,.05);\n");
      out.write("    }\n");
      out.write("    .navbar .dropdown-menu a {\n");
      out.write("      color: #777;\n");
      out.write("      padding: 8px 20px;\n");
      out.write("      line-height: normal;\n");
      out.write("    }\n");
      out.write("    .navbar .dropdown-menu a:hover, .navbar .dropdown-menu a:active {\n");
      out.write("      color: #333;\n");
      out.write("    } \n");
      out.write("    .navbar .dropdown-item .material-icons {\n");
      out.write("      font-size: 21px;\n");
      out.write("      line-height: 16px;\n");
      out.write("      vertical-align: middle;\n");
      out.write("      margin-top: -2px;\n");
      out.write("    }\n");
      out.write("    .navbar .badge {\n");
      out.write("      color: #fff;\n");
      out.write("      background: #f44336;\n");
      out.write("      font-size: 11px;\n");
      out.write("      border-radius: 20px;\n");
      out.write("      position: absolute;\n");
      out.write("      min-width: 10px;\n");
      out.write("      padding: 4px 6px 0;\n");
      out.write("      min-height: 18px;\n");
      out.write("      top: 5px;\n");
      out.write("    }\n");
      out.write("    .navbar a.notifications, .navbar a.messages {\n");
      out.write("      position: relative;\n");
      out.write("      margin-right: 10px;\n");
      out.write("    }\n");
      out.write("    .navbar a.messages {\n");
      out.write("      margin-right: 20px;\n");
      out.write("    }\n");
      out.write("    .navbar a.notifications .badge {\n");
      out.write("      margin-left: -8px;\n");
      out.write("    }\n");
      out.write("    .navbar a.messages .badge {\n");
      out.write("      margin-left: -4px;\n");
      out.write("    } \n");
      out.write("    .navbar .active a, .navbar .active a:hover, .navbar .active a:focus {\n");
      out.write("      background: transparent !important;\n");
      out.write("    }\n");
      out.write("    @media (min-width: 1200px){\n");
      out.write("      .form-inline .input-group {\n");
      out.write("        width: 300px;\n");
      out.write("        margin-left: 30px;\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("    @media (max-width: 1199px){\n");
      out.write("      .form-inline {\n");
      out.write("        display: block;\n");
      out.write("        margin-bottom: 10px;\n");
      out.write("      }\n");
      out.write("      .input-group {\n");
      out.write("        width: 100%;\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head> \n");
      out.write("<body>\n");
      out.write("  <nav class=\"navbar navbar-expand-xl navbar-light bg-light\">\n");
      out.write("    <a href=\"#\" class=\"navbar-brand\"><i class=\"fa fa-cube\"></i>FPTers<b>Community</b></a>\n");
      out.write("    <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\">\n");
      out.write("      <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("    </button>\n");
      out.write("    <!-- Collection of nav links, forms, and other content for toggling -->\n");
      out.write("    <div id=\"navbarCollapse\" class=\"collapse navbar-collapse justify-content-start\">\n");
      out.write("      <div class=\"navbar-nav\">\n");
      out.write("        <a href=\"#\" class=\"nav-item nav-link active\">Home</a>\n");
      out.write("        <a href=\"#\" class=\"nav-item nav-link\">About</a>\n");
      out.write("        <div class=\"nav-item dropdown\">\n");
      out.write("          <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\">Services</a>\n");
      out.write("          <div class=\"dropdown-menu\">\n");
      out.write("            <a href=\"#\" class=\"dropdown-item\">Web Design</a>\n");
      out.write("            <a href=\"#\" class=\"dropdown-item\">Web Development</a>\n");
      out.write("            <a href=\"#\" class=\"dropdown-item\">Graphic Design</a>\n");
      out.write("            <a href=\"#\" class=\"dropdown-item\">Digital Marketing</a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <a href=\"#\" class=\"nav-item nav-link\">Blog</a>\n");
      out.write("        <a href=\"#\" class=\"nav-item nav-link\">Contact</a>\n");
      out.write("      </div>\n");
      out.write("      <form class=\"navbar-form form-inline\">\n");
      out.write("        <div class=\"input-group search-box\">                \n");
      out.write("          <input type=\"text\" id=\"search\" class=\"form-control\" placeholder=\"Search by Name\">\n");
      out.write("          <span class=\"input-group-addon\"><i class=\"material-icons\">&#xE8B6;</i></span>\n");
      out.write("        </div>\n");
      out.write("      </form>\n");
      out.write("      <div class=\"navbar-nav ml-auto\">\n");
      out.write("        <a href=\"#\" class=\"nav-item nav-link notifications\"><i class=\"fa fa-bell-o\"></i><span class=\"badge\">1</span></a>\n");
      out.write("        <a href=\"#\" class=\"nav-item nav-link messages\"><i class=\"fa fa-envelope-o\"></i><span class=\"badge\">10</span></a></a>\n");
      out.write("        <div class=\"nav-item dropdown\">\n");
      out.write("          <a href=\"#\" data-toggle=\"dropdown\" class=\"nav-link dropdown-toggle user-action\"><img src=\"/examples/images/avatar/2.jpg\" class=\"avatar\" alt=\"Avatar\"> Paula Wilson <b class=\"caret\"></b></a>\n");
      out.write("          <div class=\"dropdown-menu\">\n");
      out.write("            <a href=\"#\" class=\"dropdown-item\"><i class=\"fa fa-user-o\"></i> Profile</a></a>\n");
      out.write("            <a href=\"#\" class=\"dropdown-item\"><i class=\"fa fa-calendar-o\"></i> Calendar</a></a>\n");
      out.write("            <a href=\"#\" class=\"dropdown-item\"><i class=\"fa fa-sliders\"></i> Settings</a></a>\n");
      out.write("            <div class=\"dropdown-divider\"></div>\n");
      out.write("            <a href=\"#\" class=\"dropdown-item\"><i class=\"material-icons\">&#xE8AC;</i> Logout</a></a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </nav>\n");
      out.write("</body>\n");
      out.write("\n");
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
