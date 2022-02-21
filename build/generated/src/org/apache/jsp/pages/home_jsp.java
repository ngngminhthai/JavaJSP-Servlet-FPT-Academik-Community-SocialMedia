package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Major;
import java.util.ArrayList;
import java.util.ArrayList;
import db.NotificationDBContext;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/pages/../components/Bootstrap.jsp");
    _jspx_dependants.add("/pages/../assets/header2.jsp");
    _jspx_dependants.add("/pages/../assets/footer.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>FPT University community</title>\n");
      out.write("        <title></title>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Merienda+One\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>");
      out.write("\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/home.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/body.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/footer.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/header.css\">\n");
      out.write("<!--        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css\"\n");
      out.write("            />-->\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    ");
 ArrayList<Major> majorList = (ArrayList<Major>) request.getAttribute("majorList");

    
      out.write("\n");
      out.write("    <body >\n");
      out.write("        <!--    <my-header></my-header>-->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    ");
      Cookie[] cookies = request.getCookies();
        String username = "";
        String pass = "";
        String rem = "";
        if (cookies != null) {
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("username")) {
                    username = cooky.getValue();
                }
                if (cooky.getName().equals("password")) {
                    pass = cooky.getValue();
                }
                if (cooky.getName().equals("remember")) {
                    rem = cooky.getValue();
                }
            }
        }
        NotificationDBContext notiDB = new NotificationDBContext();
        int totalNoti = -1;
        if (session.getAttribute("userID") != null) {
            totalNoti = notiDB.totalNotification((Integer) session.getAttribute("userID"));
        }
    
      out.write("\n");
      out.write("    <nav style=\"   position: sticky;\n");
      out.write("         top: 0px;\n");
      out.write("         z-index: 100;\" class=\"navbar navbar-expand-xl navbar-light bg-light\">\n");
      out.write("\n");
      out.write("        <a href=\"#\" class=\"navbar-brand\"><i class=\"fa fa-graduation-cap\" aria-hidden=\"true\"></i>\n");
      out.write("            FPTers<b>Community</b></a>\n");
      out.write("        <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <!-- Collection of nav links, forms, and other content for toggling -->\n");
      out.write("        <div id=\"navbarCollapse\" class=\"collapse navbar-collapse justify-content-start\">\n");
      out.write("            <div class=\"navbar-nav\">\n");
      out.write("                <a href=\"#\" class=\"nav-item nav-link active\">Trang chủ</a>\n");
      out.write("                <a href=\"#\" class=\"nav-item nav-link\">Thông tin</a>\n");
      out.write("                <div class=\"nav-item dropdown\">\n");
      out.write("                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\">Môn học</a>\n");
      out.write("                    <div class=\"dropdown-menu\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-item\">Web Design</a>\n");
      out.write("                        <a href=\"#\" class=\"dropdown-item\">Web Development</a>\n");
      out.write("                        <a href=\"#\" class=\"dropdown-item\">Graphic Design</a>\n");
      out.write("                        <a href=\"#\" class=\"dropdown-item\">Digital Marketing</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <a href=\"#\" class=\"nav-item nav-link\">Bài viết</a>\n");
      out.write("                <a href=\"#\" class=\"nav-item nav-link\">Liên hệ</a>\n");
      out.write("            </div>\n");
      out.write("            <form class=\"navbar-form form-inline\">\n");
      out.write("                <div class=\"input-group search-box\">                \n");
      out.write("                    <input type=\"text\" id=\"search\" class=\"form-control\" placeholder=\"Tìm kiếm\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            ");
 if (session.getAttribute("userID") != null) {
      out.write("\n");
      out.write("            <div class=\"navbar-nav ml-auto\">\n");
      out.write("                <a href=\"Notification\" class=\"nav-item nav-link notifications\"><i class=\"fa fa-bell-o\"></i><span class=\"badge\">");
      out.print( totalNoti);
      out.write("</span></a>\n");
      out.write("                <a href=\"message\" class=\"nav-item nav-link messages\"><i class=\"fa fa-envelope-o\"></i><span class=\"badge\">10</span></a></a>\n");
      out.write("                <div class=\"nav-item dropdown\">\n");
      out.write("                    <a href=\"#\" data-toggle=\"dropdown\" class=\"nav-link dropdown-toggle user-action\"><img src=\"pages/gaixinh.jpg\" class=\"avatar\" alt=\"Avatar\">username<b class=\"caret\"></b></a>\n");
      out.write("                    <div class=\"dropdown-menu\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-item\"><i class=\"fa fa-user-o\"></i> Hồ sơ</a></a>\n");
      out.write("\n");
      out.write("                        <a href=\"#\" class=\"dropdown-item\"><i class=\"fa fa-sliders\"></i> Cài đặt</a></a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a href=\"logout\" class=\"dropdown-item\"><i class=\"material-icons\">&#xE8AC;</i> Đăng xuất</a></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("            <div class=\"navbar-nav ml-auto action-buttons\">\n");
      out.write("                <div class=\"nav-item dropdown\">\n");
      out.write("                    <a href=\"#\" data-toggle=\"dropdown\" class=\"nav-link dropdown-toggle mr-4\">Login</a>\n");
      out.write("                    <div class=\"dropdown-menu action-form\">\n");
      out.write("                        <form action=\"login\" method=\"post\">\n");
      out.write("                            <p class=\"hint-text\">Sign in with your social media account</p>\n");
      out.write("                            <div class=\"form-group social-btn clearfix\">\n");
      out.write("                                <a href=\"#\" class=\"btn btn-secondary facebook-btn float-left\"><i class=\"fa fa-facebook\"></i> Facebook</a>\n");
      out.write("                                <a href=\"#\" class=\"btn btn-secondary twitter-btn float-right\"><i class=\"fa fa-twitter\"></i> Twitter</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"or-seperator\"><b>or</b></div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Username\" required=\"required\" name=\"username\" value=\"");
      out.print(username);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" placeholder=\"Password\" required=\"required\" name=\"password\" value=\"");
      out.print(pass);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div> <input type=\"checkbox\" name=\"Remember\" ");
if (!rem.isEmpty()) {
      out.write("checked");
}
      out.write(" />Remember me</div>\n");
      out.write("\n");
      out.write("                            <input type=\"submit\" class=\"btn btn-primary btn-block\" value=\"Login\">\n");
      out.write("                            <div class=\"text-center mt-2\">\n");
      out.write("                                <a href=\"#\">Forgot Your password?</a>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"nav-item dropdown\">\n");
      out.write("                    <a href=\"#\" data-toggle=\"dropdown\" class=\"btn btn-primary dropdown-toggle sign-up-btn\">Sign up</a>\n");
      out.write("                    <div class=\"dropdown-menu action-form\">\n");
      out.write("                        <form action=\"/examples/actions/confirmation.php\" method=\"post\">\n");
      out.write("                            <p class=\"hint-text\">Fill in this form to create your account!</p>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Username\" required=\"required\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" placeholder=\"Password\" required=\"required\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" placeholder=\"Confirm Password\" required=\"required\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"form-check-label\"><input type=\"checkbox\" required=\"required\"> I accept the <a href=\"#\">Terms &amp; Conditions</a></label>\n");
      out.write("                            </div>\n");
      out.write("                            <input type=\"submit\" class=\"btn btn-primary btn-block\" value=\"Sign up\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"content-container\">\n");
      out.write("            <div class=\"content-title\">\n");
      out.write("                Các chuyên ngành học\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
 for (int i = 0; i < majorList.size(); i++) {
      out.write("\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"major-icon\">\n");
      out.write("<!--                    <i class=\"fas fa-laptop-code\"></i>-->\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"major-content\">\n");
      out.write("                    <a href=\"forums?id=");
      out.print( i + 1);
      out.write('"');
      out.write('>');
      out.print( majorList.get(i).getName());
      out.write("</a>\n");
      out.write("                    <p>");
      out.print( majorList.get(i).getSummary());
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
  }
            
      out.write("\n");
      out.write("            <!--        <div class=\"content\">\n");
      out.write("                        <div class=\"major-icon\">\n");
      out.write("                            <i class=\"fas fa-laptop-code\"></i>\n");
      out.write("                        </div>\n");
      out.write("            \n");
      out.write("                        <div class=\"major-content\">\n");
      out.write("                            <a href=\"#\">Software Engineering</a>\n");
      out.write("                            <p>Chuyên ngành kĩ thuật phần mềm</p>\n");
      out.write("                        </div>\n");
      out.write("            \n");
      out.write("                    </div>-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"active-user\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--    <my-footer></my-footer>-->\n");
      out.write("        <script>\n");
      out.write("//            document.getElementById(\"#login-btn\").href += '&?locate=' + window.location.href;\n");
      out.write("            var username = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("            if (username == '') {\n");
      out.write("                document.querySelector(\".nav-account\").style.display = \"none\"\n");
      out.write("                document.querySelector(\".login\").style.display = \"block\"\n");
      out.write("            }\n");
      out.write("            document.querySelector('#user-name').innerHTML = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("        </script>\n");
      out.write("        <!--    <script src=\"components/header_footer_template.js\"></script>-->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<footer class=\"bg-primary text-white text-center text-lg-start mt-auto\" style=\"background-color: #f44336 !important;\">\n");
      out.write("    <!-- Grid container -->\n");
      out.write("    <div class=\"container p-4\">\n");
      out.write("        <!--Grid row-->\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <!--Grid column-->\n");
      out.write("            <div class=\"col-lg-6 col-md-12 mb-4 mb-md-0\">\n");
      out.write("                <h5 class=\"text-uppercase\">Cộng đồng học tập sinh viên FPTers</h5>\n");
      out.write("\n");
      out.write("                <p>\n");
      out.write("                    Trang web được xây dựng với mục đích giao lưu học hỏi giúp đỡ giữa các bạn sinh viên với nhau thông qua những câu hỏi, những chủ đề được tạo nên từ quá trình gặp khó khăn trong việc giải quyết các bài tập và những vấn đề trên giảng đường\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("            <!--Grid column-->\n");
      out.write("\n");
      out.write("            <!--Grid column-->\n");
      out.write("            <div class=\"col-lg-3 col-md-6 mb-4 mb-md-0\">\n");
      out.write("                <h5 class=\"text-uppercase\">Links</h5>\n");
      out.write("\n");
      out.write("                <ul class=\"list-unstyled mb-0\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#!\" class=\"text-white\">Link 1</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#!\" class=\"text-white\">Link 2</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#!\" class=\"text-white\">Link 3</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#!\" class=\"text-white\">Link 4</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!--Grid column-->\n");
      out.write("\n");
      out.write("            <!--Grid column-->\n");
      out.write("            <div class=\"col-lg-3 col-md-6 mb-4 mb-md-0\">\n");
      out.write("                <h5 class=\"text-uppercase mb-0\">Links</h5>\n");
      out.write("\n");
      out.write("                <ul class=\"list-unstyled\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#!\" class=\"text-white\">Link 1</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#!\" class=\"text-white\">Link 2</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#!\" class=\"text-white\">Link 3</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#!\" class=\"text-white\">Link 4</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!--Grid column-->\n");
      out.write("        </div>\n");
      out.write("        <!--Grid row-->\n");
      out.write("    </div>\n");
      out.write("    <!-- Grid container -->\n");
      out.write("\n");
      out.write("    <!-- Copyright -->\n");
      out.write("    <div class=\"text-center p-3\" style=\"background-color: rgba(0, 0, 0, 0.2);\">\n");
      out.write("        © 2020 Copyright:\n");
      out.write("        <a class=\"text-white\" href=\"https://mdbootstrap.com/\">FUWePass.net</a>\n");
      out.write("    </div>\n");
      out.write("    <!-- Copyright -->\n");
      out.write("</footer>\n");
      out.write("\n");
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
