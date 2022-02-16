<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body>
    <%      Cookie[] cookies = request.getCookies();
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
        } %>
    <nav style="   position: sticky;
         top: 0px;
         z-index: 100;" class="navbar navbar-expand-xl navbar-light bg-light">

        <a href="#" class="navbar-brand"><i class="fa fa-graduation-cap" aria-hidden="true"></i>
            FPTers<b>Community</b></a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- Collection of nav links, forms, and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
            <div class="navbar-nav">
                <a href="#" class="nav-item nav-link active">Trang chủ</a>
                <a href="#" class="nav-item nav-link">Thông tin</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Môn học</a>
                    <div class="dropdown-menu">
                        <a href="#" class="dropdown-item">Web Design</a>
                        <a href="#" class="dropdown-item">Web Development</a>
                        <a href="#" class="dropdown-item">Graphic Design</a>
                        <a href="#" class="dropdown-item">Digital Marketing</a>
                    </div>
                </div>
                <a href="#" class="nav-item nav-link">Bài viết</a>
                <a href="#" class="nav-item nav-link">Liên hệ</a>
            </div>
            <form class="navbar-form form-inline">
                <div class="input-group search-box">                
                    <input type="text" id="search" class="form-control" placeholder="Tìm kiếm">
                </div>
            </form>
            <% if (session.getAttribute("userID") != null) {%>
            <div class="navbar-nav ml-auto">
                <a href="Notification" class="nav-item nav-link notifications"><i class="fa fa-bell-o"></i><span class="badge">1</span></a>
                <a href="#" class="nav-item nav-link messages"><i class="fa fa-envelope-o"></i><span class="badge">10</span></a></a>
                <div class="nav-item dropdown">
                    <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle user-action"><img src="pages/gaixinh.jpg" class="avatar" alt="Avatar">username<b class="caret"></b></a>
                    <div class="dropdown-menu">
                        <a href="#" class="dropdown-item"><i class="fa fa-user-o"></i> Hồ sơ</a></a>

                        <a href="#" class="dropdown-item"><i class="fa fa-sliders"></i> Cài đặt</a></a>
                        <div class="dropdown-divider"></div>
                        <a href="logout" class="dropdown-item"><i class="material-icons">&#xE8AC;</i> Đăng xuất</a></a>
                    </div>
                </div>
            </div>
            <%} else {%>
            <div class="navbar-nav ml-auto action-buttons">
                <div class="nav-item dropdown">
                    <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle mr-4">Login</a>
                    <div class="dropdown-menu action-form">
                        <form action="login" method="post">
                            <p class="hint-text">Sign in with your social media account</p>
                            <div class="form-group social-btn clearfix">
                                <a href="#" class="btn btn-secondary facebook-btn float-left"><i class="fa fa-facebook"></i> Facebook</a>
                                <a href="#" class="btn btn-secondary twitter-btn float-right"><i class="fa fa-twitter"></i> Twitter</a>
                            </div>
                            <div class="or-seperator"><b>or</b></div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Username" required="required" name="username" value="<%=username%>">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password" required="required" name="password" value="<%=pass%>">
                            </div>
                                <div> <input type="checkbox" name="Remember" <%if(!rem.isEmpty()){%>checked<%}%> />Remember me</div>

                            <input type="submit" class="btn btn-primary btn-block" value="Login">
                            <div class="text-center mt-2">
                                <a href="#">Forgot Your password?</a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" data-toggle="dropdown" class="btn btn-primary dropdown-toggle sign-up-btn">Sign up</a>
                    <div class="dropdown-menu action-form">
                        <form action="/examples/actions/confirmation.php" method="post">
                            <p class="hint-text">Fill in this form to create your account!</p>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Username" required="required">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password" required="required">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Confirm Password" required="required">
                            </div>
                            <div class="form-group">
                                <label class="form-check-label"><input type="checkbox" required="required"> I accept the <a href="#">Terms &amp; Conditions</a></label>
                            </div>
                            <input type="submit" class="btn btn-primary btn-block" value="Sign up">
                        </form>
                    </div>
                </div>
            </div>
            <% }%>
        </div>
    </nav>
</body>


