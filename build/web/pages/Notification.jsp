<%-- 
    Document   : Notification
    Created on : Feb 11, 2022, 10:16:29 AM
    Author     : Admin
--%>

<%@page import="model.Notification"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Notification</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="style/style1.css">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
            />
        <style>
            @import url(https://fonts.googleapis.com/css?family=Roboto:300,400,700&display=swap);body {
                font-family: "Roboto", sans-serif;
                background: #EFF1F3;
                min-height: 100vh;
                position: relative;
            }

            .section-50 {
                padding: 50px 0;
            }

            .m-b-50 {
                margin-bottom: 50px;
            }

            .dark-link {
                color: #333;
            }

            .heading-line {
                position: relative;
                padding-bottom: 5px;
            }

            .heading-line:after {
                content: "";
                height: 4px;
                width: 75px;
                background-color: #29B6F6;
                position: absolute;
                bottom: 0;
                left: 0;
            }

            .notification-ui_dd-content {
                margin-bottom: 30px;
            }

            .notification-list {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-pack: justify;
                -ms-flex-pack: justify;
                justify-content: space-between;
                padding: 20px;
                margin-bottom: 7px;
                background: #fff;
                -webkit-box-shadow: 0 3px 10px rgba(0, 0, 0, 0.06);
                box-shadow: 0 3px 10px rgba(0, 0, 0, 0.06);
            }

            .notification-list--unread {
                border-left: 2px solid #29B6F6;
            }

            .notification-list .notification-list_content {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
            }

            .notification-list .notification-list_content .notification-list_img img {
                height: 48px;
                width: 48px;
                border-radius: 50px;
                margin-right: 20px;
            }

            .notification-list .notification-list_content .notification-list_detail p {
                margin-bottom: 5px;
                line-height: 1.2;
            }

            .notification-list .notification-list_feature-img img {
                height: 48px;
                width: 48px;
                border-radius: 5px;
                margin-left: 20px;
            }
            .mr-sm-2{
                height: 37px;
            }
        </style>
    </head>
    <body>
        <!--        <header>
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <div class="container">
                            <a class="navbar-brand" href="#">Navbar</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav ml-auto">
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Home</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">About</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Contact</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Login</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Signup</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </header>-->
        <%@include file="../assets/header.jsp" %>
        <section class="section-50">
            <div class="container">
                <h3 class="m-b-50 heading-line">Thông báo <i class="fa fa-bell text-muted"></i></h3>
                    <% ArrayList<Notification> notifications = (ArrayList<Notification>) request.getAttribute("notis");  %>
                <div class="notification-ui_dd-content">

                    <% for(int i = notifications.size()-1; i >= 0; i--)  {%>

                    <div class="notification-list notification-list--unread">
                        <div class="notification-list_content">
                            <div class="notification-list_img">
                                <img src="images/users/user1.jpg" alt="user">
                            </div>
                            <div class="notification-list_detail">
                                <p><b><%= notifications.get(i).getSender().getUsername()%></b> 
                                    <%if (notifications.get(i).getType().trim().equals("comment".trim())) {
                                    %>đã bình luận ở bài viết của bạn<%} else { %>đã trả lời bình luận của bạn<% }
                                    %>
                                </p>
                                <a href="thread?questionid=<%=notifications.get(i).getSource().getQuestionID()%>" class="text-muted"><%= notifications.get(i).getSource().getTitle()%></a>
                                <p class="text-muted"><small><%=notifications.get(i).getCreatedAt()%></small></p>
                            </div>
                        </div>
                        <div class="notification-list_feature-img">
                            <img src="images/features/random1.jpg" alt="Feature image">
                        </div>
                    </div>

                    <%   }
                    %>


                </div>

                <div class="text-center">
                    <a href="#!" class="dark-link">Load more activity</a>
                </div>

            </div>
        </section>
        <script>   var username = "${sessionScope.username}";
            if (username == '') {
                document.querySelector(".nav-account").style.display = "none"
                document.querySelector(".login").style.display = "block"
            }
            document.querySelector('#user-name').innerHTML = "${sessionScope.username}"</script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>