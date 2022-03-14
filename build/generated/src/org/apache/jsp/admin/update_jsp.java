package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\" class=\"fontawesome-i2svg-active fontawesome-i2svg-complete\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("            <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("                    <meta name=\"description\" content=\"\">\n");
      out.write("                        <meta name=\"author\" content=\"\">\n");
      out.write("                            <title>Tables - SB Admin</title>\n");
      out.write("                            <style type=\"text/css\">svg:not(:root).svg-inline--fa{overflow:visible}.svg-inline--fa{display:inline-block;font-size:inherit;height:1em;overflow:visible;vertical-align:-.125em}.svg-inline--fa.fa-lg{vertical-align:-.225em}.svg-inline--fa.fa-w-1{width:.0625em}.svg-inline--fa.fa-w-2{width:.125em}.svg-inline--fa.fa-w-3{width:.1875em}.svg-inline--fa.fa-w-4{width:.25em}.svg-inline--fa.fa-w-5{width:.3125em}.svg-inline--fa.fa-w-6{width:.375em}.svg-inline--fa.fa-w-7{width:.4375em}.svg-inline--fa.fa-w-8{width:.5em}.svg-inline--fa.fa-w-9{width:.5625em}.svg-inline--fa.fa-w-10{width:.625em}.svg-inline--fa.fa-w-11{width:.6875em}.svg-inline--fa.fa-w-12{width:.75em}.svg-inline--fa.fa-w-13{width:.8125em}.svg-inline--fa.fa-w-14{width:.875em}.svg-inline--fa.fa-w-15{width:.9375em}.svg-inline--fa.fa-w-16{width:1em}.svg-inline--fa.fa-w-17{width:1.0625em}.svg-inline--fa.fa-w-18{width:1.125em}.svg-inline--fa.fa-w-19{width:1.1875em}.svg-inline--fa.fa-w-20{width:1.25em}.svg-inline--fa.fa-pull-left{margin-right:.3em;width:auto}.svg-inline--fa.fa-pull-right{margin-left:.3em;width:auto}.svg-inline--fa.fa-border{height:1.5em}.svg-inline--fa.fa-li{width:2em}.svg-inline--fa.fa-fw{width:1.25em}.fa-layers svg.svg-inline--fa{bottom:0;left:0;margin:auto;position:absolute;right:0;top:0}.fa-layers{display:inline-block;height:1em;position:relative;text-align:center;vertical-align:-.125em;width:1em}.fa-layers svg.svg-inline--fa{-webkit-transform-origin:center center;transform-origin:center center}.fa-layers-counter,.fa-layers-text{display:inline-block;position:absolute;text-align:center}.fa-layers-text{left:50%;top:50%;-webkit-transform:translate(-50%,-50%);transform:translate(-50%,-50%);-webkit-transform-origin:center center;transform-origin:center center}.fa-layers-counter{background-color:#ff253a;border-radius:1em;-webkit-box-sizing:border-box;box-sizing:border-box;color:#fff;height:1.5em;line-height:1;max-width:5em;min-width:1.5em;overflow:hidden;padding:.25em;right:0;text-overflow:ellipsis;top:0;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:top right;transform-origin:top right}.fa-layers-bottom-right{bottom:0;right:0;top:auto;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:bottom right;transform-origin:bottom right}.fa-layers-bottom-left{bottom:0;left:0;right:auto;top:auto;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:bottom left;transform-origin:bottom left}.fa-layers-top-right{right:0;top:0;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:top right;transform-origin:top right}.fa-layers-top-left{left:0;right:auto;top:0;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:top left;transform-origin:top left}.fa-lg{font-size:1.3333333333em;line-height:.75em;vertical-align:-.0667em}.fa-xs{font-size:.75em}.fa-sm{font-size:.875em}.fa-1x{font-size:1em}.fa-2x{font-size:2em}.fa-3x{font-size:3em}.fa-4x{font-size:4em}.fa-5x{font-size:5em}.fa-6x{font-size:6em}.fa-7x{font-size:7em}.fa-8x{font-size:8em}.fa-9x{font-size:9em}.fa-10x{font-size:10em}.fa-fw{text-align:center;width:1.25em}.fa-ul{list-style-type:none;margin-left:2.5em;padding-left:0}.fa-ul>li{position:relative}.fa-li{left:-2em;position:absolute;text-align:center;width:2em;line-height:inherit}.fa-border{border:solid .08em #eee;border-radius:.1em;padding:.2em .25em .15em}.fa-pull-left{float:left}.fa-pull-right{float:right}.fa.fa-pull-left,.fab.fa-pull-left,.fal.fa-pull-left,.far.fa-pull-left,.fas.fa-pull-left{margin-right:.3em}.fa.fa-pull-right,.fab.fa-pull-right,.fal.fa-pull-right,.far.fa-pull-right,.fas.fa-pull-right{margin-left:.3em}.fa-spin{-webkit-animation:fa-spin 2s infinite linear;animation:fa-spin 2s infinite linear}.fa-pulse{-webkit-animation:fa-spin 1s infinite steps(8);animation:fa-spin 1s infinite steps(8)}@-webkit-keyframes fa-spin{0%{-webkit-transform:rotate(0);transform:rotate(0)}100%{-webkit-transform:rotate(360deg);transform:rotate(360deg)}}@keyframes fa-spin{0%{-webkit-transform:rotate(0);transform:rotate(0)}100%{-webkit-transform:rotate(360deg);transform:rotate(360deg)}}.fa-rotate-90{-webkit-transform:rotate(90deg);transform:rotate(90deg)}.fa-rotate-180{-webkit-transform:rotate(180deg);transform:rotate(180deg)}.fa-rotate-270{-webkit-transform:rotate(270deg);transform:rotate(270deg)}.fa-flip-horizontal{-webkit-transform:scale(-1,1);transform:scale(-1,1)}.fa-flip-vertical{-webkit-transform:scale(1,-1);transform:scale(1,-1)}.fa-flip-both,.fa-flip-horizontal.fa-flip-vertical{-webkit-transform:scale(-1,-1);transform:scale(-1,-1)}:root .fa-flip-both,:root .fa-flip-horizontal,:root .fa-flip-vertical,:root .fa-rotate-180,:root .fa-rotate-270,:root .fa-rotate-90{-webkit-filter:none;filter:none}.fa-stack{display:inline-block;height:2em;position:relative;width:2.5em}.fa-stack-1x,.fa-stack-2x{bottom:0;left:0;margin:auto;position:absolute;right:0;top:0}.svg-inline--fa.fa-stack-1x{height:1em;width:1.25em}.svg-inline--fa.fa-stack-2x{height:2em;width:2.5em}.fa-inverse{color:#fff}.sr-only{border:0;clip:rect(0,0,0,0);height:1px;margin:-1px;overflow:hidden;padding:0;position:absolute;width:1px}.sr-only-focusable:active,.sr-only-focusable:focus{clip:auto;height:auto;margin:0;overflow:visible;position:static;width:auto}.svg-inline--fa .fa-primary{fill:var(--fa-primary-color,currentColor);opacity:1;opacity:var(--fa-primary-opacity,1)}.svg-inline--fa .fa-secondary{fill:var(--fa-secondary-color,currentColor);opacity:.4;opacity:var(--fa-secondary-opacity,.4)}.svg-inline--fa.fa-swap-opacity .fa-primary{opacity:.4;opacity:var(--fa-secondary-opacity,.4)}.svg-inline--fa.fa-swap-opacity .fa-secondary{opacity:1;opacity:var(--fa-primary-opacity,1)}.svg-inline--fa mask .fa-primary,.svg-inline--fa mask .fa-secondary{fill:#000}.fad.fa-inverse{color:#fff}</style><style type=\"text/css\">svg:not(:root).svg-inline--fa{overflow:visible}.svg-inline--fa{display:inline-block;font-size:inherit;height:1em;overflow:visible;vertical-align:-.125em}.svg-inline--fa.fa-lg{vertical-align:-.225em}.svg-inline--fa.fa-w-1{width:.0625em}.svg-inline--fa.fa-w-2{width:.125em}.svg-inline--fa.fa-w-3{width:.1875em}.svg-inline--fa.fa-w-4{width:.25em}.svg-inline--fa.fa-w-5{width:.3125em}.svg-inline--fa.fa-w-6{width:.375em}.svg-inline--fa.fa-w-7{width:.4375em}.svg-inline--fa.fa-w-8{width:.5em}.svg-inline--fa.fa-w-9{width:.5625em}.svg-inline--fa.fa-w-10{width:.625em}.svg-inline--fa.fa-w-11{width:.6875em}.svg-inline--fa.fa-w-12{width:.75em}.svg-inline--fa.fa-w-13{width:.8125em}.svg-inline--fa.fa-w-14{width:.875em}.svg-inline--fa.fa-w-15{width:.9375em}.svg-inline--fa.fa-w-16{width:1em}.svg-inline--fa.fa-w-17{width:1.0625em}.svg-inline--fa.fa-w-18{width:1.125em}.svg-inline--fa.fa-w-19{width:1.1875em}.svg-inline--fa.fa-w-20{width:1.25em}.svg-inline--fa.fa-pull-left{margin-right:.3em;width:auto}.svg-inline--fa.fa-pull-right{margin-left:.3em;width:auto}.svg-inline--fa.fa-border{height:1.5em}.svg-inline--fa.fa-li{width:2em}.svg-inline--fa.fa-fw{width:1.25em}.fa-layers svg.svg-inline--fa{bottom:0;left:0;margin:auto;position:absolute;right:0;top:0}.fa-layers{display:inline-block;height:1em;position:relative;text-align:center;vertical-align:-.125em;width:1em}.fa-layers svg.svg-inline--fa{-webkit-transform-origin:center center;transform-origin:center center}.fa-layers-counter,.fa-layers-text{display:inline-block;position:absolute;text-align:center}.fa-layers-text{left:50%;top:50%;-webkit-transform:translate(-50%,-50%);transform:translate(-50%,-50%);-webkit-transform-origin:center center;transform-origin:center center}.fa-layers-counter{background-color:#ff253a;border-radius:1em;-webkit-box-sizing:border-box;box-sizing:border-box;color:#fff;height:1.5em;line-height:1;max-width:5em;min-width:1.5em;overflow:hidden;padding:.25em;right:0;text-overflow:ellipsis;top:0;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:top right;transform-origin:top right}.fa-layers-bottom-right{bottom:0;right:0;top:auto;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:bottom right;transform-origin:bottom right}.fa-layers-bottom-left{bottom:0;left:0;right:auto;top:auto;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:bottom left;transform-origin:bottom left}.fa-layers-top-right{right:0;top:0;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:top right;transform-origin:top right}.fa-layers-top-left{left:0;right:auto;top:0;-webkit-transform:scale(.25);transform:scale(.25);-webkit-transform-origin:top left;transform-origin:top left}.fa-lg{font-size:1.3333333333em;line-height:.75em;vertical-align:-.0667em}.fa-xs{font-size:.75em}.fa-sm{font-size:.875em}.fa-1x{font-size:1em}.fa-2x{font-size:2em}.fa-3x{font-size:3em}.fa-4x{font-size:4em}.fa-5x{font-size:5em}.fa-6x{font-size:6em}.fa-7x{font-size:7em}.fa-8x{font-size:8em}.fa-9x{font-size:9em}.fa-10x{font-size:10em}.fa-fw{text-align:center;width:1.25em}.fa-ul{list-style-type:none;margin-left:2.5em;padding-left:0}.fa-ul>li{position:relative}.fa-li{left:-2em;position:absolute;text-align:center;width:2em;line-height:inherit}.fa-border{border:solid .08em #eee;border-radius:.1em;padding:.2em .25em .15em}.fa-pull-left{float:left}.fa-pull-right{float:right}.fa.fa-pull-left,.fab.fa-pull-left,.fal.fa-pull-left,.far.fa-pull-left,.fas.fa-pull-left{margin-right:.3em}.fa.fa-pull-right,.fab.fa-pull-right,.fal.fa-pull-right,.far.fa-pull-right,.fas.fa-pull-right{margin-left:.3em}.fa-spin{-webkit-animation:fa-spin 2s infinite linear;animation:fa-spin 2s infinite linear}.fa-pulse{-webkit-animation:fa-spin 1s infinite steps(8);animation:fa-spin 1s infinite steps(8)}@-webkit-keyframes fa-spin{0%{-webkit-transform:rotate(0);transform:rotate(0)}100%{-webkit-transform:rotate(360deg);transform:rotate(360deg)}}@keyframes fa-spin{0%{-webkit-transform:rotate(0);transform:rotate(0)}100%{-webkit-transform:rotate(360deg);transform:rotate(360deg)}}.fa-rotate-90{-webkit-transform:rotate(90deg);transform:rotate(90deg)}.fa-rotate-180{-webkit-transform:rotate(180deg);transform:rotate(180deg)}.fa-rotate-270{-webkit-transform:rotate(270deg);transform:rotate(270deg)}.fa-flip-horizontal{-webkit-transform:scale(-1,1);transform:scale(-1,1)}.fa-flip-vertical{-webkit-transform:scale(1,-1);transform:scale(1,-1)}.fa-flip-both,.fa-flip-horizontal.fa-flip-vertical{-webkit-transform:scale(-1,-1);transform:scale(-1,-1)}:root .fa-flip-both,:root .fa-flip-horizontal,:root .fa-flip-vertical,:root .fa-rotate-180,:root .fa-rotate-270,:root .fa-rotate-90{-webkit-filter:none;filter:none}.fa-stack{display:inline-block;height:2em;position:relative;width:2.5em}.fa-stack-1x,.fa-stack-2x{bottom:0;left:0;margin:auto;position:absolute;right:0;top:0}.svg-inline--fa.fa-stack-1x{height:1em;width:1.25em}.svg-inline--fa.fa-stack-2x{height:2em;width:2.5em}.fa-inverse{color:#fff}.sr-only{border:0;clip:rect(0,0,0,0);height:1px;margin:-1px;overflow:hidden;padding:0;position:absolute;width:1px}.sr-only-focusable:active,.sr-only-focusable:focus{clip:auto;height:auto;margin:0;overflow:visible;position:static;width:auto}.svg-inline--fa .fa-primary{fill:var(--fa-primary-color,currentColor);opacity:1;opacity:var(--fa-primary-opacity,1)}.svg-inline--fa .fa-secondary{fill:var(--fa-secondary-color,currentColor);opacity:.4;opacity:var(--fa-secondary-opacity,.4)}.svg-inline--fa.fa-swap-opacity .fa-primary{opacity:.4;opacity:var(--fa-secondary-opacity,.4)}.svg-inline--fa.fa-swap-opacity .fa-secondary{opacity:1;opacity:var(--fa-primary-opacity,1)}.svg-inline--fa mask .fa-primary,.svg-inline--fa mask .fa-secondary{fill:#000}.fad.fa-inverse{color:#fff}</style><link href=\"https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css\" rel=\"stylesheet\">\n");
      out.write("                                <link href=\"css/styles.css\" rel=\"stylesheet\">\n");
      out.write("                                    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("                                    </head>\n");
      out.write("                                    <body class=\"sb-nav-fixed\">\n");
      out.write("                                        <nav class=\"sb-topnav navbar navbar-expand navbar-dark bg-dark\">\n");
      out.write("                                            <!-- Navbar Brand-->\n");
      out.write("                                            <a class=\"navbar-brand ps-3\" href=\"index.html\">Start Bootstrap</a>\n");
      out.write("                                            <!-- Sidebar Toggle-->\n");
      out.write("                                            <button class=\"btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0\" id=\"sidebarToggle\" href=\"#!\"><svg class=\"svg-inline--fa fa-bars fa-w-14\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"bars\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 448 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M16 132h416c8.837 0 16-7.163 16-16V76c0-8.837-7.163-16-16-16H16C7.163 60 0 67.163 0 76v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16z\"></path></svg><!-- <i class=\"fas fa-bars\"></i> Font Awesome fontawesome.com --></button>\n");
      out.write("                                            <!-- Navbar Search-->\n");
      out.write("                                            <form class=\"d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0\">\n");
      out.write("                                                <div class=\"input-group\">\n");
      out.write("                                                    <input class=\"form-control\" type=\"text\" placeholder=\"Search for...\" aria-label=\"Search for...\" aria-describedby=\"btnNavbarSearch\">\n");
      out.write("                                                        <button class=\"btn btn-primary\" id=\"btnNavbarSearch\" type=\"button\"><svg class=\"svg-inline--fa fa-search fa-w-16\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"search\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 512 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z\"></path></svg><!-- <i class=\"fas fa-search\"></i> Font Awesome fontawesome.com --></button>\n");
      out.write("                                                </div>\n");
      out.write("                                            </form>\n");
      out.write("                                            <!-- Navbar-->\n");
      out.write("                                            <ul class=\"navbar-nav ms-auto ms-md-0 me-3 me-lg-4\">\n");
      out.write("                                                <li class=\"nav-item dropdown\">\n");
      out.write("                                                    <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdown\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\"><svg class=\"svg-inline--fa fa-user fa-w-14 fa-fw\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"user\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 448 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M224 256c70.7 0 128-57.3 128-128S294.7 0 224 0 96 57.3 96 128s57.3 128 128 128zm89.6 32h-16.7c-22.2 10.2-46.9 16-72.9 16s-50.6-5.8-72.9-16h-16.7C60.2 288 0 348.2 0 422.4V464c0 26.5 21.5 48 48 48h352c26.5 0 48-21.5 48-48v-41.6c0-74.2-60.2-134.4-134.4-134.4z\"></path></svg><!-- <i class=\"fas fa-user fa-fw\"></i> Font Awesome fontawesome.com --></a>\n");
      out.write("                                                    <ul class=\"dropdown-menu dropdown-menu-end\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                                        <li><a class=\"dropdown-item\" href=\"#!\">Settings</a></li>\n");
      out.write("                                                        <li><a class=\"dropdown-item\" href=\"#!\">Activity Log</a></li>\n");
      out.write("                                                        <li><hr class=\"dropdown-divider\"></li>\n");
      out.write("                                                        <li><a class=\"dropdown-item\" href=\"#!\">Logout</a></li>\n");
      out.write("                                                    </ul>\n");
      out.write("                                                </li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </nav>\n");
      out.write("                                        <div id=\"layoutSidenav\">\n");
      out.write("                                            <div id=\"layoutSidenav_nav\">\n");
      out.write("                                                <nav class=\"sb-sidenav accordion sb-sidenav-dark\" id=\"sidenavAccordion\">\n");
      out.write("                                                    <div class=\"sb-sidenav-menu\">\n");
      out.write("                                                        <div class=\"nav\">\n");
      out.write("                                                            <div class=\"sb-sidenav-menu-heading\">Core</div>\n");
      out.write("                                                            <a class=\"nav-link\" href=\"index.html\">\n");
      out.write("                                                                <div class=\"sb-nav-link-icon\"><svg class=\"svg-inline--fa fa-tachometer-alt fa-w-18\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"tachometer-alt\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 576 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M288 32C128.94 32 0 160.94 0 320c0 52.8 14.25 102.26 39.06 144.8 5.61 9.62 16.3 15.2 27.44 15.2h443c11.14 0 21.83-5.58 27.44-15.2C561.75 422.26 576 372.8 576 320c0-159.06-128.94-288-288-288zm0 64c14.71 0 26.58 10.13 30.32 23.65-1.11 2.26-2.64 4.23-3.45 6.67l-9.22 27.67c-5.13 3.49-10.97 6.01-17.64 6.01-17.67 0-32-14.33-32-32S270.33 96 288 96zM96 384c-17.67 0-32-14.33-32-32s14.33-32 32-32 32 14.33 32 32-14.33 32-32 32zm48-160c-17.67 0-32-14.33-32-32s14.33-32 32-32 32 14.33 32 32-14.33 32-32 32zm246.77-72.41l-61.33 184C343.13 347.33 352 364.54 352 384c0 11.72-3.38 22.55-8.88 32H232.88c-5.5-9.45-8.88-20.28-8.88-32 0-33.94 26.5-61.43 59.9-63.59l61.34-184.01c4.17-12.56 17.73-19.45 30.36-15.17 12.57 4.19 19.35 17.79 15.17 30.36zm14.66 57.2l15.52-46.55c3.47-1.29 7.13-2.23 11.05-2.23 17.67 0 32 14.33 32 32s-14.33 32-32 32c-11.38-.01-20.89-6.28-26.57-15.22zM480 384c-17.67 0-32-14.33-32-32s14.33-32 32-32 32 14.33 32 32-14.33 32-32 32z\"></path></svg><!-- <i class=\"fas fa-tachometer-alt\"></i> Font Awesome fontawesome.com --></div>\n");
      out.write("                                                                Dashboard\n");
      out.write("                                                            </a>\n");
      out.write("                                                            <div class=\"sb-sidenav-menu-heading\">Interface</div>\n");
      out.write("                                                            <a class=\"nav-link collapsed\" href=\"#\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseLayouts\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\">\n");
      out.write("                                                                <div class=\"sb-nav-link-icon\"><svg class=\"svg-inline--fa fa-columns fa-w-16\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"columns\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 512 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64V160h160v256zm224 0H288V160h160v256z\"></path></svg><!-- <i class=\"fas fa-columns\"></i> Font Awesome fontawesome.com --></div>\n");
      out.write("                                                                Layouts\n");
      out.write("                                                                <div class=\"sb-sidenav-collapse-arrow\"><svg class=\"svg-inline--fa fa-angle-down fa-w-10\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"angle-down\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 320 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M143 352.3L7 216.3c-9.4-9.4-9.4-24.6 0-33.9l22.6-22.6c9.4-9.4 24.6-9.4 33.9 0l96.4 96.4 96.4-96.4c9.4-9.4 24.6-9.4 33.9 0l22.6 22.6c9.4 9.4 9.4 24.6 0 33.9l-136 136c-9.2 9.4-24.4 9.4-33.8 0z\"></path></svg><!-- <i class=\"fas fa-angle-down\"></i> Font Awesome fontawesome.com --></div>\n");
      out.write("                                                            </a>\n");
      out.write("                                                            <div class=\"collapse\" id=\"collapseLayouts\" aria-labelledby=\"headingOne\" data-bs-parent=\"#sidenavAccordion\">\n");
      out.write("                                                                <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                                                    <a class=\"nav-link\" href=\"layout-static.html\">Static Navigation</a>\n");
      out.write("                                                                    <a class=\"nav-link\" href=\"layout-sidenav-light.html\">Light Sidenav</a>\n");
      out.write("                                                                </nav>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <a class=\"nav-link collapsed\" href=\"#\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapsePages\" aria-expanded=\"false\" aria-controls=\"collapsePages\">\n");
      out.write("                                                                <div class=\"sb-nav-link-icon\"><svg class=\"svg-inline--fa fa-book-open fa-w-18\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"book-open\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 576 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M542.22 32.05c-54.8 3.11-163.72 14.43-230.96 55.59-4.64 2.84-7.27 7.89-7.27 13.17v363.87c0 11.55 12.63 18.85 23.28 13.49 69.18-34.82 169.23-44.32 218.7-46.92 16.89-.89 30.02-14.43 30.02-30.66V62.75c.01-17.71-15.35-31.74-33.77-30.7zM264.73 87.64C197.5 46.48 88.58 35.17 33.78 32.05 15.36 31.01 0 45.04 0 62.75V400.6c0 16.24 13.13 29.78 30.02 30.66 49.49 2.6 149.59 12.11 218.77 46.95 10.62 5.35 23.21-1.94 23.21-13.46V100.63c0-5.29-2.62-10.14-7.27-12.99z\"></path></svg><!-- <i class=\"fas fa-book-open\"></i> Font Awesome fontawesome.com --></div>\n");
      out.write("                                                                Pages\n");
      out.write("                                                                <div class=\"sb-sidenav-collapse-arrow\"><svg class=\"svg-inline--fa fa-angle-down fa-w-10\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"angle-down\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 320 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M143 352.3L7 216.3c-9.4-9.4-9.4-24.6 0-33.9l22.6-22.6c9.4-9.4 24.6-9.4 33.9 0l96.4 96.4 96.4-96.4c9.4-9.4 24.6-9.4 33.9 0l22.6 22.6c9.4 9.4 9.4 24.6 0 33.9l-136 136c-9.2 9.4-24.4 9.4-33.8 0z\"></path></svg><!-- <i class=\"fas fa-angle-down\"></i> Font Awesome fontawesome.com --></div>\n");
      out.write("                                                            </a>\n");
      out.write("                                                            <div class=\"collapse\" id=\"collapsePages\" aria-labelledby=\"headingTwo\" data-bs-parent=\"#sidenavAccordion\">\n");
      out.write("                                                                <nav class=\"sb-sidenav-menu-nested nav accordion\" id=\"sidenavAccordionPages\">\n");
      out.write("                                                                    <a class=\"nav-link collapsed\" href=\"#\" data-bs-toggle=\"collapse\" data-bs-target=\"#pagesCollapseAuth\" aria-expanded=\"false\" aria-controls=\"pagesCollapseAuth\">\n");
      out.write("                                                                        Authentication\n");
      out.write("                                                                        <div class=\"sb-sidenav-collapse-arrow\"><svg class=\"svg-inline--fa fa-angle-down fa-w-10\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"angle-down\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 320 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M143 352.3L7 216.3c-9.4-9.4-9.4-24.6 0-33.9l22.6-22.6c9.4-9.4 24.6-9.4 33.9 0l96.4 96.4 96.4-96.4c9.4-9.4 24.6-9.4 33.9 0l22.6 22.6c9.4 9.4 9.4 24.6 0 33.9l-136 136c-9.2 9.4-24.4 9.4-33.8 0z\"></path></svg><!-- <i class=\"fas fa-angle-down\"></i> Font Awesome fontawesome.com --></div>\n");
      out.write("                                                                    </a>\n");
      out.write("                                                                    <div class=\"collapse\" id=\"pagesCollapseAuth\" aria-labelledby=\"headingOne\" data-bs-parent=\"#sidenavAccordionPages\">\n");
      out.write("                                                                        <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                                                            <a class=\"nav-link\" href=\"login.html\">Login</a>\n");
      out.write("                                                                            <a class=\"nav-link\" href=\"register.html\">Register</a>\n");
      out.write("                                                                            <a class=\"nav-link\" href=\"password.html\">Forgot Password</a>\n");
      out.write("                                                                        </nav>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <a class=\"nav-link collapsed\" href=\"#\" data-bs-toggle=\"collapse\" data-bs-target=\"#pagesCollapseError\" aria-expanded=\"false\" aria-controls=\"pagesCollapseError\">\n");
      out.write("                                                                        Error\n");
      out.write("                                                                        <div class=\"sb-sidenav-collapse-arrow\"><svg class=\"svg-inline--fa fa-angle-down fa-w-10\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"angle-down\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 320 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M143 352.3L7 216.3c-9.4-9.4-9.4-24.6 0-33.9l22.6-22.6c9.4-9.4 24.6-9.4 33.9 0l96.4 96.4 96.4-96.4c9.4-9.4 24.6-9.4 33.9 0l22.6 22.6c9.4 9.4 9.4 24.6 0 33.9l-136 136c-9.2 9.4-24.4 9.4-33.8 0z\"></path></svg><!-- <i class=\"fas fa-angle-down\"></i> Font Awesome fontawesome.com --></div>\n");
      out.write("                                                                    </a>\n");
      out.write("                                                                    <div class=\"collapse\" id=\"pagesCollapseError\" aria-labelledby=\"headingOne\" data-bs-parent=\"#sidenavAccordionPages\">\n");
      out.write("                                                                        <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                                                            <a class=\"nav-link\" href=\"401.html\">401 Page</a>\n");
      out.write("                                                                            <a class=\"nav-link\" href=\"404.html\">404 Page</a>\n");
      out.write("                                                                            <a class=\"nav-link\" href=\"500.html\">500 Page</a>\n");
      out.write("                                                                        </nav>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </nav>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"sb-sidenav-menu-heading\">Addons</div>\n");
      out.write("                                                            <a class=\"nav-link\" href=\"charts.html\">\n");
      out.write("                                                                <div class=\"sb-nav-link-icon\"><svg class=\"svg-inline--fa fa-chart-area fa-w-16\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"chart-area\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 512 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M500 384c6.6 0 12 5.4 12 12v40c0 6.6-5.4 12-12 12H12c-6.6 0-12-5.4-12-12V76c0-6.6 5.4-12 12-12h40c6.6 0 12 5.4 12 12v308h436zM372.7 159.5L288 216l-85.3-113.7c-5.1-6.8-15.5-6.3-19.9 1L96 248v104h384l-89.9-187.8c-3.2-6.5-11.4-8.7-17.4-4.7z\"></path></svg><!-- <i class=\"fas fa-chart-area\"></i> Font Awesome fontawesome.com --></div>\n");
      out.write("                                                                Charts\n");
      out.write("                                                            </a>\n");
      out.write("                                                            <a class=\"nav-link\" href=\"tables.html\">\n");
      out.write("                                                                <div class=\"sb-nav-link-icon\"><svg class=\"svg-inline--fa fa-table fa-w-16\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"table\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 512 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z\"></path></svg><!-- <i class=\"fas fa-table\"></i> Font Awesome fontawesome.com --></div>\n");
      out.write("                                                                Tables\n");
      out.write("                                                            </a>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"sb-sidenav-footer\">\n");
      out.write("                                                        <div class=\"small\">Logged in as:</div>\n");
      out.write("                                                        Start Bootstrap\n");
      out.write("                                                    </div>\n");
      out.write("                                                </nav>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div id=\"layoutSidenav_content\">\n");
      out.write("                                                <main>\n");
      out.write("                                                    <div class=\"container-fluid px-4\">\n");
      out.write("                                                        <h1 class=\"mt-4\">Cập nhật</h1>\n");
      out.write("                                                        <ol class=\"breadcrumb mb-4\">\n");
      out.write("                                                            <li class=\"breadcrumb-item\"><a href=\"index.html\">Dashboard</a></li>\n");
      out.write("                                                            <li class=\"breadcrumb-item active\">Cập nhật</li>\n");
      out.write("                                                        </ol>\n");
      out.write("\n");
      out.write("                                                        <div class=\"card mb-4\">\n");
      out.write("                                                            <div class=\"card-header\">\n");
      out.write("                                                                <svg class=\"svg-inline--fa fa-table fa-w-16 me-1\" aria-hidden=\"true\" focusable=\"false\" data-prefix=\"fas\" data-icon=\"table\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 512 512\" data-fa-i2svg=\"\"><path fill=\"currentColor\" d=\"M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z\"></path></svg><!-- <i class=\"fas fa-table me-1\"></i> Font Awesome fontawesome.com -->\n");
      out.write("                                                                Cập nhật thông tin\n");
      out.write("                                                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"container rounded bg-white mt-5 mb-5\">\n");
      out.write("                                                        <div class=\"row\">\n");
      out.write("                                                            <div class=\"col-md-3 border-right\">\n");
      out.write("                                                                <div class=\"d-flex flex-column align-items-center text-center p-3 py-5\"><img class=\"rounded-circle mt-5\" src=\"#\"><span class=\"font-weight-bold\">Amelly</span><span class=\"text-black-50\">amelly12@bbb.com</span><span> </span></div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"col-md-9 border-right\">\n");
      out.write("                                                                <div class=\"p-3 py-5\">\n");
      out.write("                                                                    <div class=\"d-flex justify-content-between align-items-center mb-3\">\n");
      out.write("                                                                        <h4 class=\"text-right\">Profile Settings</h4>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div class=\"row mt-2\">\n");
      out.write("                                                                        <div class=\"col-md-12\"><label class=\"labels\">Name</label><input type=\"text\" class=\"form-control\" placeholder=\"first name\" value=\"\"></div>\n");
      out.write("\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div class=\"row mt-3\">\n");
      out.write("                                                                        <div class=\"col-md-12\"><label class=\"labels\">PhoneNumber</label><input type=\"text\" class=\"form-control\" placeholder=\"enter phone number\" value=\"\"></div>\n");
      out.write("                                                                        <div class=\"col-md-12\"><label class=\"labels\">Address</label><input type=\"text\" class=\"form-control\" placeholder=\"enter address\" value=\"\"></div>\n");
      out.write("\n");
      out.write("                                                                        <div class=\"col-md-12\"><label class=\"labels\">Education</label><input type=\"text\" class=\"form-control\" placeholder=\"education\" value=\"\"></div>\n");
      out.write("                                                                    </div>\n");
      out.write("\n");
      out.write("                                                                    <div class=\"mt-5 text-center\"><button class=\"btn btn-primary profile-button\" type=\"button\">Save Profile</button></div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                </main>\n");
      out.write("                                                <footer class=\"py-4 bg-light mt-auto\">\n");
      out.write("                                                    <div class=\"container-fluid px-4\">\n");
      out.write("                                                        <div class=\"d-flex align-items-center justify-content-between small\">\n");
      out.write("                                                            <div class=\"text-muted\">Copyright © Your Website 2021</div>\n");
      out.write("                                                            <div>\n");
      out.write("                                                                <a href=\"#\">Privacy Policy</a>\n");
      out.write("                                                                ·\n");
      out.write("                                                                <a href=\"#\">Terms &amp; Conditions</a>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </footer>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("                                        <script src=\"js/scripts.js\"></script>\n");
      out.write("                                        <script src=\"https://cdn.jsdelivr.net/npm/simple-datatables@latest\" crossorigin=\"anonymous\"></script>\n");
      out.write("                                        <script src=\"js/datatables-simple-demo.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <div id=\"edge-translate-notifier-container\" class=\"edge-translate-notifier-center\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </body><div id=\"edge-translate-notifier-container\" class=\"edge-translate-notifier-center\"></div></html>");
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
