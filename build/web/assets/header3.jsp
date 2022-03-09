
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="panel-menu" id="mobile-menu">
    <ul>

    </ul>
    <div class="mm-navbtn-names">
        <div class="mm-closebtn">
            Close
            <div class="tt-icon">
                <svg>
                <use xlink:href="#icon-cancel"></use>
                </svg>
            </div>
        </div>
        <div class="mm-backbtn">Back</div>
    </div>
</nav>
<header id="tt-header">

    <div class="container">


        <div class="row tt-row no-gutters">

            <div class="col-auto">
                <!-- toggle  menu -->
                <a class="toggle-mobile-menu" href="#">
                    <svg class="tt-icon">
                    <use xlink:href="#icon-menu_icon"></use>
                    </svg>
                </a>
                <!-- /toggle mobile menu -->
                <!-- logo -->
                <div class="tt-logo">
                    <a href="home"><img src="assets/logo.png" alt=""></a>
                </div>
                <!-- /logo -->
                <!-- desctop menu -->
                <div class="tt-desktop-menu">
                    <nav>
                        <ul>
                            <li><a href="page-categories.html"><span style="color: blue; font-weight: bold;">Môn học</span></a></li>
                            <li><a href="page-tabs.html"><span>Thông tin</span></a></li>
                            <li><a href="page-create-topic.html"><span>Đăng bài viết</span></a></li>
                            <li>
                                <a href="page-single-user.html"><span>Theo dõi</span></a>
                                <ul>
                                    <li><a href="index.html">Home</a></li>
                                    <li><a href="page-single-topic.html">Single Topic</a></li>
                                    <li><a href="page-create-topic.html">Create Topic</a></li>
                                    <li><a href="page-single-user.html">Single User Activity</a></li>
                                    <li><a href="page-single_threads.html">Single User Threads</a></li>
                                    <li><a href="page-single_replies.html">Single User Replies</a></li>
                                    <li><a href="page-single_followers.html">Single User Followers</a></li>
                                    <li><a href="page-single_categories.html">Single User Categories</a></li>
                                    <li><a href="page-single_settings.html">Single User Settings</a></li>
                                    <li><a href="page-signup.html">Đăng kí</a></li>
                                    <li><a href="page-login.html">Đăng nhập</a></li>
                                    <li><a href="page-categories.html">Categories</a></li>
                                    <li><a href="page-categories-single.html">Single Category</a></li>
                                    <li><a href="page-tabs.html">About</a></li>
                                    <li><a href="page-tabs_guidelines.html">Guidelines</a></li>
                                    <li><a href="_demo_modal-advancedSearch.html">Advanced Search</a></li>
                                    <li><a href="error404.html">Error 404</a></li>
                                    <li><a href="_demo_modal-age-confirmation.html">Age Verification</a></li>
                                    <li><a href="_demo_modal-level-up.html">Level up Notification</a></li>
                                    <li><a href="messages-page.html">Message</a></li>
                                    <li><a href="messages-compose.html">Message Compose</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
                <!-- /desctop menu -->
                <!-- tt-search -->
                <div class="tt-search">
                    <!-- toggle -->
                    <button class="tt-search-toggle" data-toggle="modal" data-target="#modalAdvancedSearch">
                        <svg class="tt-icon">
                        <use xlink:href="#icon-search"></use>
                        </svg>
                    </button>
                    <!-- /toggle -->
                    <form class="search-wrapper" method="get" action="search">
                        <div class="search-form">
                            <input name="q" type="text" class="tt-search__input" placeholder="Tìm kiếm">
                            <button class="tt-search__btn" type="submit">
                                <svg class="tt-icon">
                                <use xlink:href="#icon-search"></use>
                                </svg>
                            </button>
                            <button class="tt-search__close">
                                <svg class="tt-icon">
                                <use xlink:href="#cancel"></use>
                                </svg>
                            </button>
                        </div>
                        <div class="search-results">
                            <div class="tt-search-scroll">
                                <ul>
                                    <li>
                                        <a href="page-single-topic.html">
                                            <h6 class="tt-title">Rdr2 secret easter eggs</h6>
                                            <div class="tt-description">
                                                Here’s what I’ve found in Red Dead Redem..
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="page-single-topic.html">
                                            <h6 class="tt-title">Top 10 easter eggs in Red Dead Rede..</h6>
                                            <div class="tt-description">
                                                You can find these easter eggs in Red Dea..
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="page-single-topic.html">
                                            <h6 class="tt-title">Red Dead Redemtion: Arthur Morgan..</h6>
                                            <div class="tt-description">
                                                Here’s what I’ve found in Red Dead Redem..
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="page-single-topic.html">
                                            <h6 class="tt-title">Rdr2 secret easter eggs</h6>
                                            <div class="tt-description">
                                                Here’s what I’ve found in Red Dead Redem..
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="page-single-topic.html">
                                            <h6 class="tt-title">Top 10 easter eggs in Red Dead Rede..</h6>
                                            <div class="tt-description">
                                                You can find these easter eggs in Red Dea..
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="page-single-topic.html">
                                            <h6 class="tt-title">Red Dead Redemtion: Arthur Morgan..</h6>
                                            <div class="tt-description">
                                                Here’s what I’ve found in Red Dead Redem..
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <button type="button" class="tt-view-all" data-toggle="modal" data-target="#modalAdvancedSearch">Advanced Search</button>
                        </div>
                    </form>
                </div>
                <!-- /tt-search -->
            </div>
            <div class="col-auto ml-auto">
                <% if (session.getAttribute("userID") != null) {%> 
                <a href="OpenMessage" class="tt-user-info d-flex justify-content-center">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                </a>
                <a href="Notification" class="tt-btn-icon">
                    <i class="tt-icon"><svg><use xlink:href="#icon-notification"></use></svg></i>
                </a>
                <div class="tt-avatar-icon tt-size-md">
                    <i class="tt-icon"><svg><use xlink:href="#icon-ava-a"></use></svg></i>
                </div>
                <div class="custom-select-01">
                    <select>
                        <option value="Default Sorting"><%=session.getAttribute("username")%></option>
                        <option value="value 01">value 01</option>
                        <option value="value 02">value 02</option>
                    </select>
                </div>
            </div>
            <% } else { %>
            <div class="tt-account-btn">
                <div>      <a href="#" data-toggle="dropdown" aria-expanded="true" class="btn btn-primary nav-link dropdown-toggle">Đăng nhập</a>
                    <div class="dropdown-menu action-form">
                        <form action="login" method="post">
                            <p class="hint-text">Sign in with your social media account</p>
                            <div class="form-group social-btn clearfix">
                                <a href="#" class="btn btn-secondary facebook-btn float-left"><i class="fa fa-facebook"></i> Facebook</a>
                                <a href="#" class="btn btn-secondary twitter-btn float-right"><i class="fa fa-twitter"></i> Twitter</a>
                            </div>
                            <div class="or-seperator"><b>or</b></div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Username" required="required" name="username" value="">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password" required="required" name="password" value="">
                            </div>
                            <div> <input type="checkbox" name="Remember" >Remember me</div>

                            <input type="submit" class="btn btn-primary btn-block" value="Login">
                            <div class="text-center mt-2">
                                <a href="#">Forgot Your password?</a>
                            </div>
                        </form>
                    </div></div>

                <div>     <a href="#" data-toggle="dropdown" aria-expanded="true" style="    margin-left: 8px;
                             " class="btn btn-secondary dropdown-toggle sign-up-btn">Đăng kí</a>
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
                    </div></div>

            </div>
            <%}%>

        </div>
    </div>
</div>

</header>

<a href="ask" class="tt-btn-create-topic">
    <span class="tt-icon">
        <svg>
        <use xlink:href="#icon-create_new"></use>
        </svg>
    </span>
</a>
