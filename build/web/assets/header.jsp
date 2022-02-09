<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="nav-container"> 
    <div class="nav-above">
        <span style="
              font-size: 35px;
              font-weight: bold;
              ">FU <span style="    font-style: italic;
                   font-weight: bold;
                   color: #4caf50;">PASS</span></span>
    </div>

</header>
<div class="nav-under-container" style="position: sticky; top: 0px; z-index: 100;">
    <div class="nav-under">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#
               ">We are FPTers</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Trang Chủ <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Khóa Học</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Tin Tức
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Đóng góp</a>
                    </li>
                </ul>
                <div class="login btn btn-outline-success my-2 my-sm-0" style="margin-right: 10px; display: none;">
                    <a id="login-btn" style="text-decoration: none; color: #28a745;" href="login">Đăng nhập</a>
                </div>
                <div class="nav-account">
                    <div>
                        <p id="user-name">Username</p>

                    </div>
                    <!--                    <div class="account-user">
                                            <i class="fas fa-user"></i>
                                        </div>-->

                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false"> <i class="fas fa-user"></i>
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">

                            <li style="padding-left: 10px;"><a href="logout"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
                        </ul>
                    </div>
                    <div class="account-message">
                        <i class="far fa-envelope"></i>
                    </div>
                    <div class="account-notification">
                        <i class="fas fa-bell"></i>
                    </div>
                </div>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Cậu muốn tìm cái gì nè" aria-label="Tìm kiếm" style="padding-bottom: 0px;
                           padding-top: 0px;">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
                </form>
            </div>
        </nav>
    </div>
</div>

