package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class Profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/pages/../assets/header3.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Merienda+One\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/style/style2.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                color: #6F8BA4;\n");
      out.write("                margin-top:20px;\n");
      out.write("            }\n");
      out.write("            .section {\n");
      out.write("                padding: 100px 0;\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("            .gray-bg {\n");
      out.write("                background-color: #f5f5f5;\n");
      out.write("            }\n");
      out.write("            img {\n");
      out.write("                max-width: 100%;\n");
      out.write("            }\n");
      out.write("            img {\n");
      out.write("                vertical-align: middle;\n");
      out.write("                border-style: none;\n");
      out.write("            }\n");
      out.write("            /* About Me \n");
      out.write("            ---------------------*/\n");
      out.write("            .about-text h3 {\n");
      out.write("                font-size: 45px;\n");
      out.write("                font-weight: 700;\n");
      out.write("                margin: 0 0 6px;\n");
      out.write("            }\n");
      out.write("            @media (max-width: 767px) {\n");
      out.write("                .about-text h3 {\n");
      out.write("                    font-size: 35px;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            .about-text h6 {\n");
      out.write("                font-weight: 600;\n");
      out.write("                margin-bottom: 15px;\n");
      out.write("            }\n");
      out.write("            @media (max-width: 767px) {\n");
      out.write("                .about-text h6 {\n");
      out.write("                    font-size: 18px;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            .about-text p {\n");
      out.write("                font-size: 18px;\n");
      out.write("                max-width: 450px;\n");
      out.write("            }\n");
      out.write("            .about-text p mark {\n");
      out.write("                font-weight: 600;\n");
      out.write("                color: #20247b;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .about-list {\n");
      out.write("                padding-top: 10px;\n");
      out.write("            }\n");
      out.write("            .about-list .media {\n");
      out.write("                padding: 5px 0;\n");
      out.write("            }\n");
      out.write("            .about-list label {\n");
      out.write("                color: #20247b;\n");
      out.write("                font-weight: 600;\n");
      out.write("                width: 88px;\n");
      out.write("                margin: 0;\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("            .about-list label:after {\n");
      out.write("                content: \"\";\n");
      out.write("                position: absolute;\n");
      out.write("                top: 0;\n");
      out.write("                bottom: 0;\n");
      out.write("                right: 11px;\n");
      out.write("                width: 1px;\n");
      out.write("                height: 12px;\n");
      out.write("                background: #20247b;\n");
      out.write("                -moz-transform: rotate(15deg);\n");
      out.write("                -o-transform: rotate(15deg);\n");
      out.write("                -ms-transform: rotate(15deg);\n");
      out.write("                -webkit-transform: rotate(15deg);\n");
      out.write("                transform: rotate(15deg);\n");
      out.write("                margin: auto;\n");
      out.write("                opacity: 0.5;\n");
      out.write("            }\n");
      out.write("            .about-list p {\n");
      out.write("                margin: 0;\n");
      out.write("                font-size: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            @media (max-width: 991px) {\n");
      out.write("                .about-avatar {\n");
      out.write("                    margin-top: 30px;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .about-section .counter {\n");
      out.write("                padding: 22px 20px;\n");
      out.write("                background: #ffffff;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                box-shadow: 0 0 30px rgba(31, 45, 61, 0.125);\n");
      out.write("            }\n");
      out.write("            .about-section .counter .count-data {\n");
      out.write("                margin-top: 10px;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("            .about-section .counter .count {\n");
      out.write("                font-weight: 700;\n");
      out.write("                color: #20247b;\n");
      out.write("                margin: 0 0 5px;\n");
      out.write("            }\n");
      out.write("            .about-section .counter p {\n");
      out.write("                font-weight: 600;\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("            mark {\n");
      out.write("                background-image: linear-gradient(rgba(252, 83, 86, 0.6), rgba(252, 83, 86, 0.6));\n");
      out.write("                background-size: 100% 3px;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-position: 0 bottom;\n");
      out.write("                background-color: transparent;\n");
      out.write("                padding: 0;\n");
      out.write("                color: currentColor;\n");
      out.write("            }\n");
      out.write("            .theme-color {\n");
      out.write("                color: #fc5356;\n");
      out.write("            }\n");
      out.write("            .dark-color {\n");
      out.write("                color: #20247b;\n");
      out.write("            }\n");
      out.write("            img{\n");
      out.write("                width: 100%;\n");
      out.write("                height: 100vh;\n");
      out.write("            }\n");
      out.write("            .media{\n");
      out.write("                white-space: nowrap;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<nav class=\"panel-menu\" id=\"mobile-menu\">\n");
      out.write("    <ul>\n");
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    <div class=\"mm-navbtn-names\">\n");
      out.write("        <div class=\"mm-closebtn\">\n");
      out.write("            Close\n");
      out.write("            <div class=\"tt-icon\">\n");
      out.write("                <svg>\n");
      out.write("                <use xlink:href=\"#icon-cancel\"></use>\n");
      out.write("                </svg>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"mm-backbtn\">Back</div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("<header id=\"tt-header\">\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"row tt-row no-gutters\">\n");
      out.write("\n");
      out.write("            <div class=\"col-auto\">\n");
      out.write("                <!-- toggle  menu -->\n");
      out.write("                <a class=\"toggle-mobile-menu\" href=\"#\">\n");
      out.write("                    <svg class=\"tt-icon\">\n");
      out.write("                    <use xlink:href=\"#icon-menu_icon\"></use>\n");
      out.write("                    </svg>\n");
      out.write("                </a>\n");
      out.write("                <!-- /toggle mobile menu -->\n");
      out.write("                <!-- logo -->\n");
      out.write("                <div class=\"tt-logo\">\n");
      out.write("                    <a href=\"home\"><img src=\"assets/logo.png\" alt=\"\"></a>\n");
      out.write("                </div>\n");
      out.write("                <!-- /logo -->\n");
      out.write("                <!-- desctop menu -->\n");
      out.write("                <div class=\"tt-desktop-menu\">\n");
      out.write("                    <nav>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"page-categories.html\"><span style=\"color: blue; font-weight: bold;\">Môn học</span></a></li>\n");
      out.write("                            <li><a href=\"page-tabs.html\"><span>Thông tin</span></a></li>\n");
      out.write("                            <li><a href=\"page-create-topic.html\"><span>Đăng bài viết</span></a></li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"page-single-user.html\"><span>Theo dõi</span></a>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                                    <li><a href=\"page-single-topic.html\">Single Topic</a></li>\n");
      out.write("                                    <li><a href=\"page-create-topic.html\">Create Topic</a></li>\n");
      out.write("                                    <li><a href=\"page-single-user.html\">Single User Activity</a></li>\n");
      out.write("                                    <li><a href=\"page-single_threads.html\">Single User Threads</a></li>\n");
      out.write("                                    <li><a href=\"page-single_replies.html\">Single User Replies</a></li>\n");
      out.write("                                    <li><a href=\"page-single_followers.html\">Single User Followers</a></li>\n");
      out.write("                                    <li><a href=\"page-single_categories.html\">Single User Categories</a></li>\n");
      out.write("                                    <li><a href=\"page-single_settings.html\">Single User Settings</a></li>\n");
      out.write("                                    <li><a href=\"page-signup.html\">Đăng kí</a></li>\n");
      out.write("                                    <li><a href=\"page-login.html\">Đăng nhập</a></li>\n");
      out.write("                                    <li><a href=\"page-categories.html\">Categories</a></li>\n");
      out.write("                                    <li><a href=\"page-categories-single.html\">Single Category</a></li>\n");
      out.write("                                    <li><a href=\"page-tabs.html\">About</a></li>\n");
      out.write("                                    <li><a href=\"page-tabs_guidelines.html\">Guidelines</a></li>\n");
      out.write("                                    <li><a href=\"_demo_modal-advancedSearch.html\">Advanced Search</a></li>\n");
      out.write("                                    <li><a href=\"error404.html\">Error 404</a></li>\n");
      out.write("                                    <li><a href=\"_demo_modal-age-confirmation.html\">Age Verification</a></li>\n");
      out.write("                                    <li><a href=\"_demo_modal-level-up.html\">Level up Notification</a></li>\n");
      out.write("                                    <li><a href=\"messages-page.html\">Message</a></li>\n");
      out.write("                                    <li><a href=\"messages-compose.html\">Message Compose</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("                <!-- /desctop menu -->\n");
      out.write("                <!-- tt-search -->\n");
      out.write("                <div class=\"tt-search\">\n");
      out.write("                    <!-- toggle -->\n");
      out.write("                    <button class=\"tt-search-toggle\" data-toggle=\"modal\" data-target=\"#modalAdvancedSearch\">\n");
      out.write("                        <svg class=\"tt-icon\">\n");
      out.write("                        <use xlink:href=\"#icon-search\"></use>\n");
      out.write("                        </svg>\n");
      out.write("                    </button>\n");
      out.write("                    <!-- /toggle -->\n");
      out.write("                    <form class=\"search-wrapper\" method=\"get\" action=\"search\">\n");
      out.write("                        <div class=\"search-form\">\n");
      out.write("                            <input name=\"q\" type=\"text\" class=\"tt-search__input\" placeholder=\"Tìm kiếm\">\n");
      out.write("                            <button class=\"tt-search__btn\" type=\"submit\">\n");
      out.write("                                <svg class=\"tt-icon\">\n");
      out.write("                                <use xlink:href=\"#icon-search\"></use>\n");
      out.write("                                </svg>\n");
      out.write("                            </button>\n");
      out.write("                            <button class=\"tt-search__close\">\n");
      out.write("                                <svg class=\"tt-icon\">\n");
      out.write("                                <use xlink:href=\"#cancel\"></use>\n");
      out.write("                                </svg>\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"search-results\">\n");
      out.write("                            <div class=\"tt-search-scroll\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"page-single-topic.html\">\n");
      out.write("                                            <h6 class=\"tt-title\">Rdr2 secret easter eggs</h6>\n");
      out.write("                                            <div class=\"tt-description\">\n");
      out.write("                                                Here’s what I’ve found in Red Dead Redem..\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"page-single-topic.html\">\n");
      out.write("                                            <h6 class=\"tt-title\">Top 10 easter eggs in Red Dead Rede..</h6>\n");
      out.write("                                            <div class=\"tt-description\">\n");
      out.write("                                                You can find these easter eggs in Red Dea..\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"page-single-topic.html\">\n");
      out.write("                                            <h6 class=\"tt-title\">Red Dead Redemtion: Arthur Morgan..</h6>\n");
      out.write("                                            <div class=\"tt-description\">\n");
      out.write("                                                Here’s what I’ve found in Red Dead Redem..\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"page-single-topic.html\">\n");
      out.write("                                            <h6 class=\"tt-title\">Rdr2 secret easter eggs</h6>\n");
      out.write("                                            <div class=\"tt-description\">\n");
      out.write("                                                Here’s what I’ve found in Red Dead Redem..\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"page-single-topic.html\">\n");
      out.write("                                            <h6 class=\"tt-title\">Top 10 easter eggs in Red Dead Rede..</h6>\n");
      out.write("                                            <div class=\"tt-description\">\n");
      out.write("                                                You can find these easter eggs in Red Dea..\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"page-single-topic.html\">\n");
      out.write("                                            <h6 class=\"tt-title\">Red Dead Redemtion: Arthur Morgan..</h6>\n");
      out.write("                                            <div class=\"tt-description\">\n");
      out.write("                                                Here’s what I’ve found in Red Dead Redem..\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"button\" class=\"tt-view-all\" data-toggle=\"modal\" data-target=\"#modalAdvancedSearch\">Advanced Search</button>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <!-- /tt-search -->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-auto ml-auto\">\n");
      out.write("                ");
 if (session.getAttribute("userID") != null) {
      out.write(" \n");
      out.write("                <a href=\"OpenMessage\" class=\"tt-user-info d-flex justify-content-center\">\n");
      out.write("                    <i style=\"font-size: 18px; color: #607d8b\" class=\"fa fa-envelope\" aria-hidden=\"true\"></i>\n");
      out.write("                </a>\n");
      out.write("                <a href=\"Notification\" class=\"tt-btn-icon\">\n");
      out.write("                    <i class=\"tt-icon\"><svg><use xlink:href=\"#icon-notification\"></use></svg></i>\n");
      out.write("                </a>\n");
      out.write("                <form action=\"profile\" method=\"get\">\n");
      out.write("                    <div class=\"tt-avatar-icon tt-size-md\" onclick=\"profile()\">\n");
      out.write("                        <img style=\"width: 30px;;\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/img/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.img}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <!--                        <i  style=\"font-size: 18px; color: #607d8b\" class=\"tt-icon\"><svg><use xlink:href=\"#icon-ava-a\"></use></svg></i>-->\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <script>\n");
      out.write("                        function profile(){\n");
      out.write("                            window.location.href = \"profile\";\n");
      out.write("                        }\n");
      out.write("                </script>\n");
      out.write("\n");
      out.write("                <div class=\"custom-select-01\">\n");
      out.write("                    <select>\n");
      out.write("                        <option value=\"Default Sorting\">");
      out.print(session.getAttribute("username"));
      out.write("</option>\n");
      out.write("                        <option value=\"value 01\">value 01</option>\n");
      out.write("                        <option value=\"value 02\">value 02</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("            <div class=\"tt-account-btn\">\n");
      out.write("                <div>      <a href=\"#\" data-toggle=\"dropdown\" aria-expanded=\"true\" class=\"btn btn-primary nav-link dropdown-toggle\">Đăng nhập</a>\n");
      out.write("                    <div class=\"dropdown-menu action-form\">\n");
      out.write("                        <form action=\"login\" method=\"post\">\n");
      out.write("                            <p class=\"hint-text\">Sign in with your social media account</p>\n");
      out.write("                            <div class=\"form-group social-btn clearfix\">\n");
      out.write("                                <a href=\"#\" class=\"btn btn-secondary facebook-btn float-left\"><i class=\"fa fa-facebook\"></i> Facebook</a>\n");
      out.write("                                <a href=\"#\" class=\"btn btn-secondary twitter-btn float-right\"><i class=\"fa fa-twitter\"></i> Twitter</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"or-seperator\"><b>or</b></div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Username\" required=\"required\" name=\"username\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" placeholder=\"Password\" required=\"required\" name=\"password\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div> <input type=\"checkbox\" name=\"Remember\" >Remember me</div>\n");
      out.write("\n");
      out.write("                            <input type=\"submit\" class=\"btn btn-primary btn-block\" value=\"Login\">\n");
      out.write("                            <div class=\"text-center mt-2\">\n");
      out.write("                                <a href=\"#\">Forgot Your password?</a>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div></div>\n");
      out.write("\n");
      out.write("                <div>     <a href=\"#\" data-toggle=\"dropdown\" aria-expanded=\"true\" style=\"    margin-left: 8px;\n");
      out.write("                             \" class=\"btn btn-secondary dropdown-toggle sign-up-btn\">Đăng kí</a>\n");
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
      out.write("                    </div></div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<a href=\"ask\" class=\"tt-btn-create-topic\">\n");
      out.write("    <span class=\"tt-icon\">\n");
      out.write("        <svg>\n");
      out.write("        <use xlink:href=\"#icon-create_new\"></use>\n");
      out.write("        </svg>\n");
      out.write("    </span>\n");
      out.write("</a>\n");
      out.write("\n");
      out.write("    ");
 User u = (User)request.getAttribute("user");  
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <section class=\"section about-section gray-bg\" id=\"about\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row align-items-center flex-row-reverse\">\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <div class=\"about-text go-to\">\n");
      out.write("                            <h3 class=\"dark-color\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                            <h6 class=\"theme-color lead\">A Lead UX &amp; UI designer based in Canada</h6>\n");
      out.write("                            <p>I <mark>design and develop</mark> services for customers of all sizes, specializing in creating stylish, modern websites, web services and online stores. My passion is to design digital user experiences through the bold interface and meaningful interactions.</p>\n");
      out.write("                            <div class=\"row about-list\">\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                   \n");
      out.write("                                 \n");
      out.write("                                    <div class=\"media\">\n");
      out.write("                                        <label>Tên người dùng</label>\n");
      out.write("                                        <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("                                 \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <div class=\"media\">\n");
      out.write("                                        <label>E-mail</label>\n");
      out.write("                                        <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("                                 \n");
      out.write("                                    \n");
      out.write("                                    <div class=\"media\">\n");
      out.write("                                        <label>Chuyên ngành</label>\n");
      out.write("                                        <p>Kĩ thuật phần mềm</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <form method=\"POST\" action=\"upload2\" enctype=\"multipart/form-data\" >\n");
      out.write("                            <label for=\"upload\">Sửa ảnh đại diện</label>\n");
      out.write("                            <input class=\"form-control\" type=\"file\" name=\"file\" id=\"upload\" /><br/>\n");
      out.write("                            <div class=\"\"><button class=\"btn btn-primary mt-3 btn-rounded waves-effect w-md waves-light\">Update profile picture</button></div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <div class=\"about-avatar\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/img/");
      out.print( u.getImg() );
      out.write("\" title=\"\" alt=\"\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"counter\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-6 col-lg-3\">\n");
      out.write("                            <div class=\"count-data text-center\">\n");
      out.write("                                <h6 class=\"count h2\" data-to=\"500\" data-speed=\"500\">500</h6>\n");
      out.write("                                <p class=\"m-0px font-w-600\">Happy Clients</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-6 col-lg-3\">\n");
      out.write("                            <div class=\"count-data text-center\">\n");
      out.write("                                <h6 class=\"count h2\" data-to=\"150\" data-speed=\"150\">150</h6>\n");
      out.write("                                <p class=\"m-0px font-w-600\">Project Completed</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-6 col-lg-3\">\n");
      out.write("                            <div class=\"count-data text-center\">\n");
      out.write("                                <h6 class=\"count h2\" data-to=\"850\" data-speed=\"850\">850</h6>\n");
      out.write("                                <p class=\"m-0px font-w-600\">Photo Capture</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-6 col-lg-3\">\n");
      out.write("                            <div class=\"count-data text-center\">\n");
      out.write("                                <h6 class=\"count h2\" data-to=\"190\" data-speed=\"190\">190</h6>\n");
      out.write("                                <p class=\"m-0px font-w-600\">Telephonic Talk</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
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
