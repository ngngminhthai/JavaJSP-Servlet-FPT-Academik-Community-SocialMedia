package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Major;
import java.util.ArrayList;
import java.util.ArrayList;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/pages/../assets/header.jsp");
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
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/style1.css\">\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css\"\n");
      out.write("            />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    ");
 ArrayList<Major> majorList = (ArrayList<Major>) request.getAttribute("majorList");

    
      out.write("\n");
      out.write("    <body >\n");
      out.write("        <!--    <my-header></my-header>-->\n");
      out.write("        ");
      out.write("\n");
      out.write("<header class=\"nav-container\"> \n");
      out.write("    <div class=\"nav-above\">\n");
      out.write("        <span style=\"\n");
      out.write("              font-size: 35px;\n");
      out.write("              font-weight: bold;\n");
      out.write("              \">FU <span style=\"    font-style: italic;\n");
      out.write("                   font-weight: bold;\n");
      out.write("                   color: #4caf50;\">PASS</span></span>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</header>\n");
      out.write("<div class=\"nav-under-container\" style=\"position: sticky; top: 0px; z-index: 100;\">\n");
      out.write("    <div class=\"nav-under\">\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\n");
      out.write("               \">We are FPTers</a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">Trang Chủ <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">Khóa Học</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            Tin Tức\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Action</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Another action</a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Something else here</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link disabled\" href=\"#\">Đóng góp</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"login btn btn-outline-success my-2 my-sm-0\" style=\"margin-right: 10px; display: none;\">\n");
      out.write("                    <a id=\"login-btn\" style=\"text-decoration: none; color: #28a745;\" href=\"login\">Đăng nhập</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"nav-account\">\n");
      out.write("                    <div>\n");
      out.write("                        <p id=\"user-name\">Username</p>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!--                    <div class=\"account-user\">\n");
      out.write("                                            <i class=\"fas fa-user\"></i>\n");
      out.write("                                        </div>-->\n");
      out.write("\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <button class=\"btn btn-primary dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\" aria-expanded=\"false\"> <i class=\"fas fa-user\"></i>\n");
      out.write("                            <span class=\"caret\"></span></button>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("\n");
      out.write("                            <li style=\"padding-left: 10px;\"><a href=\"logout\"><i class=\"fas fa-sign-out-alt\"></i> Logout</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"account-message\">\n");
      out.write("                        <i class=\"far fa-envelope\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"account-notification\" onclick=\"notification()\">\n");
      out.write("                        <i class=\"fas fa-bell\"></i>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                    <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Cậu muốn tìm cái gì nè\" aria-label=\"Tìm kiếm\" style=\"padding-bottom: 0px;\n");
      out.write("                           padding-top: 0px;\">\n");
      out.write("                    <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Tìm kiếm</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("    function notification() {\n");
      out.write("        window.location.href = \"Notification?userID=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    const event11 = window.addEventListener('scroll', function (e) {\n");
      out.write("\n");
      out.write("        if (this.scrollY > 49) {\n");
      out.write("            document.querySelector(\".breadcrumb-container\").style.zIndex = \"0\";\n");
      out.write("        } else {\n");
      out.write("            document.querySelector(\".breadcrumb-container\").style.zIndex = \"999\";\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("</script>\n");
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
      out.write("                    <i class=\"fas fa-laptop-code\"></i>\n");
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
      out.write("                <h5 class=\"text-uppercase\">Cộng đồng học tập của sinh viên FPT</h5>\n");
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
