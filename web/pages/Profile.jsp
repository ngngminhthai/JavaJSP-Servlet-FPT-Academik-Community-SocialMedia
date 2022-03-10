<%-- 
    Document   : Profile
    Created on : Mar 10, 2022, 2:30:43 PM
    Author     : Admin
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Merienda+One">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style2.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                color: #6F8BA4;
                margin-top:20px;
            }
            .section {
                padding: 100px 0;
                position: relative;
            }
            .gray-bg {
                background-color: #f5f5f5;
            }
            img {
                max-width: 100%;
            }
            img {
                vertical-align: middle;
                border-style: none;
            }
            /* About Me 
            ---------------------*/
            .about-text h3 {
                font-size: 45px;
                font-weight: 700;
                margin: 0 0 6px;
            }
            @media (max-width: 767px) {
                .about-text h3 {
                    font-size: 35px;
                }
            }
            .about-text h6 {
                font-weight: 600;
                margin-bottom: 15px;
            }
            @media (max-width: 767px) {
                .about-text h6 {
                    font-size: 18px;
                }
            }
            .about-text p {
                font-size: 18px;
                max-width: 450px;
            }
            .about-text p mark {
                font-weight: 600;
                color: #20247b;
            }

            .about-list {
                padding-top: 10px;
            }
            .about-list .media {
                padding: 5px 0;
            }
            .about-list label {
                color: #20247b;
                font-weight: 600;
                width: 88px;
                margin: 0;
                position: relative;
            }
            .about-list label:after {
                content: "";
                position: absolute;
                top: 0;
                bottom: 0;
                right: 11px;
                width: 1px;
                height: 12px;
                background: #20247b;
                -moz-transform: rotate(15deg);
                -o-transform: rotate(15deg);
                -ms-transform: rotate(15deg);
                -webkit-transform: rotate(15deg);
                transform: rotate(15deg);
                margin: auto;
                opacity: 0.5;
            }
            .about-list p {
                margin: 0;
                font-size: 15px;
            }

            @media (max-width: 991px) {
                .about-avatar {
                    margin-top: 30px;
                }
            }

            .about-section .counter {
                padding: 22px 20px;
                background: #ffffff;
                border-radius: 10px;
                box-shadow: 0 0 30px rgba(31, 45, 61, 0.125);
            }
            .about-section .counter .count-data {
                margin-top: 10px;
                margin-bottom: 10px;
            }
            .about-section .counter .count {
                font-weight: 700;
                color: #20247b;
                margin: 0 0 5px;
            }
            .about-section .counter p {
                font-weight: 600;
                margin: 0;
            }
            mark {
                background-image: linear-gradient(rgba(252, 83, 86, 0.6), rgba(252, 83, 86, 0.6));
                background-size: 100% 3px;
                background-repeat: no-repeat;
                background-position: 0 bottom;
                background-color: transparent;
                padding: 0;
                color: currentColor;
            }
            .theme-color {
                color: #fc5356;
            }
            .dark-color {
                color: #20247b;
            }
            img{
                width: 100%;
                height: 100vh;
            }
            .media{
                white-space: nowrap;
            }
        </style>
    </head>

    <%@include file="../assets/header3.jsp" %>
    <% User u = (User)request.getAttribute("user");  %>
    <body>
        <section class="section about-section gray-bg" id="about">
            <div class="container">
                <div class="row align-items-center flex-row-reverse">
                    <div class="col-lg-6">
                        <div class="about-text go-to">
                            <h3 class="dark-color">${user.username}</h3>
                            <h6 class="theme-color lead">A Lead UX &amp; UI designer based in Canada</h6>
                            <p>I <mark>design and develop</mark> services for customers of all sizes, specializing in creating stylish, modern websites, web services and online stores. My passion is to design digital user experiences through the bold interface and meaningful interactions.</p>
                            <div class="row about-list">
                                <div class="col-md-6">
                                   
                                 
                                    <div class="media">
                                        <label>Tên người dùng</label>
                                        <p>${user.username}</p>
                                    </div>
                                 
                                </div>
                                <div class="col-md-6">
                                    <div class="media">
                                        <label>E-mail</label>
                                        <p>${user.email}</p>
                                    </div>
                                 
                                    
                                    <div class="media">
                                        <label>Chuyên ngành</label>
                                        <p>Kĩ thuật phần mềm</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <form method="POST" action="upload2" enctype="multipart/form-data" >
                            <label for="upload">Sửa ảnh đại diện</label>
                            <input class="form-control" type="file" name="file" id="upload" /><br/>
                            <div class=""><button class="btn btn-primary mt-3 btn-rounded waves-effect w-md waves-light">Update profile picture</button></div>
                        </form>
                    </div>

                    <div class="col-lg-6">
                        <div class="about-avatar">
                            <img src="${pageContext.request.contextPath}/img/<%= u.getImg() %>" title="" alt="">
                        </div>
                    </div>
                </div>
                <div class="counter">
                    <div class="row">
                        <div class="col-6 col-lg-3">
                            <div class="count-data text-center">
                                <h6 class="count h2" data-to="500" data-speed="500">500</h6>
                                <p class="m-0px font-w-600">Happy Clients</p>
                            </div>
                        </div>
                        <div class="col-6 col-lg-3">
                            <div class="count-data text-center">
                                <h6 class="count h2" data-to="150" data-speed="150">150</h6>
                                <p class="m-0px font-w-600">Project Completed</p>
                            </div>
                        </div>
                        <div class="col-6 col-lg-3">
                            <div class="count-data text-center">
                                <h6 class="count h2" data-to="850" data-speed="850">850</h6>
                                <p class="m-0px font-w-600">Photo Capture</p>
                            </div>
                        </div>
                        <div class="col-6 col-lg-3">
                            <div class="count-data text-center">
                                <h6 class="count h2" data-to="190" data-speed="190">190</h6>
                                <p class="m-0px font-w-600">Telephonic Talk</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
