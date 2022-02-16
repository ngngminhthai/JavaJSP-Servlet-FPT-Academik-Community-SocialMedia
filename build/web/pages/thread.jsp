<%-- 
    Document   : thread
    Created on : Feb 7, 2022, 8:23:00 PM
    Author     : Admin
--%>

<%@page import="model.Comment"%>
<%@page import="model.Question_Tag"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="model.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog==" crossorigin="anonymous" />
        <link
            rel="stylesheet"
            href="https://unicons.iconscout.com/release/v4.0.0/css/thinline.css"
            />
        <!--Import Pure Css files-->
        <link
            rel="stylesheet"
            href=
            "https://unpkg.com/purecss@1.0.0/build/pure-min.css"
            integrity=
            "sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
            crossorigin="anonymous"/>
        <link rel="stylesheet" href="style/style1.css">
        <style>
            .listInline.listInline--bullet li {
                display: flex;
                margin-right: 10px;
            }
            .listInline.listInline--bullet i {
                margin-top: 4px;
                margin-right: 12px;
            }
            .p-title-value {
                font-size: 32px;
                font-weight: 400;
            }
            .p-body-header {
                /*                margin-top: 1.5rem !important;*/
                width: 83%;
                margin: 0 auto;
            }
            .body-content, .comment-section{
                -webkit-text-size-adjust: 100%;
                font: 17px / 1.4 sans-serif;
                font-family: 'Segoe UI','Helvetica Neue',Helvetica,Roboto,Oxygen,Ubuntu,Cantarell,'Fira Sans','Droid Sans',sans-serif;
                font-weight: 400;
                word-wrap: break-word;
                list-style: none;
                color: #141414;
                box-sizing: border-box;
                display: flex;
                background-color: white;
                width: 83%;
                margin: 0 auto;
                padding: 17px;
                text-align: justify;
                border-radius: 6px;
                border: 0.5px solid lightgrey;
                margin-bottom: 20px;
                position: relative;
            }
            .body-content{
                padding-bottom: 0px;
                flex-direction: column;
            }
            .comment-section{
                margin-bottom: 0px;
                padding-top: 5px;
                flex-direction: column;
                margin-bottom: 20px;
                padding-bottom: 0px;
            }
            .comment-section p{
                width: 100%;
                border-bottom: 1px solid #9e9e9e;
                float: left;
            }
            .comment-content{
                clear: left;
            }
            .tag-container p{
                background-color: #8bc34a;
                color: hsl(205deg 14% 97%);
                padding: 0px;
                font-size: 15px;
                padding-left: 5px;
                padding-right: 5px;
                border-radius: 4px;
                margin-left: 5px;
            }
            .login-warning, .comment-btn{
                width: 100%;
                margin: 0 auto;
                margin-bottom: 29px;
                display: flex;
                justify-content: center;
                align-items: center;
                margin-top: 20px;
            }
            .login-warning p{
                margin-top: 0;

                margin-bottom: 0px;
                padding: 1px;
            }
            .commnet-writer{
                width: 83%;
                margin: 0 auto;
                border: none;

            }
            .text-function, #a{
                background-color: white;
                resize: auto;
            }
            #a{
                border: 1px solid gray;
                min-height: 50px;  /* if you want Flexible textarea/div then give min-height instead of height */
                overflow: auto; 
                padding: 2px;
                resize: both;
                width: 400px;
                font-size:15px;
                color:#000;
            }
            .alert{
                position: absolute;
                right: 0px;
                top: 200px;
            }
            .inner-comment-action{
                display: flex;
                flex-direction: row-reverse;
            }
            .inner-comment-action li{
                margin-right: 5px;  
                font-size: 13px;
            }
            .inner-comment-action li{
                cursor: pointer;
                list-style-type: none;
                text-decoration: underline;
            }
            .inner-comment-action li:hover{
                color: blue;
                font-weight: bold;
            }
            .replied-comment{
                border-left: 3px solid #f2930d;
                font-size: 15px;
                padding: 5px; 
                padding-left: 12px;
            }
            .replied-comment-user{
                background-color: #fafafa;
            }
            .replied-comment-conent{
                background-color: #f5f5f5
            }
            .replied-comment .fas{
                cursor: pointer;
            }
            .replied-comment .fas:hover{
                color: red;
            }
            .fa-ellipsis-h{
                position: absolute;
                right: 20px;
                top: 7px;
            }
        </style>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    </head>


    <body class="d-flex flex-column min-vh-100">
        <div class="alert alert-primary" role="alert">
            This is a primary alert—check it out!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <%@include file="../assets/header.jsp" %>
        <% Question clickedQuestion = (Question) request.getAttribute("clickedQues");
            User user = (User) request.getAttribute("userid");
            ArrayList<Question_Tag> tagList = (ArrayList<Question_Tag>) request.getAttribute("taglist");
            ArrayList<Comment> commentList = (ArrayList<Comment>) request.getAttribute("comlist");
        %>
        <div class="breadcrumb-container">
            <nav aria-label="breadcrumb ">
                <ol class="breadcrumb arr-right bg-dark ">
                    <li class="breadcrumb-item "><a href="#" class="text-light">Trang chủ</a></li>
                    <li class="breadcrumb-item text-light active" aria-current="page"><a href="#" class="text-light"><%= clickedQuestion.getMajorID()%></a></li>

                </ol>
            </nav>
        </div>

        <div class="p-body-header " style=" ">
            <div class="p-title ">
                <h1 class="p-title-value"><%= clickedQuestion.getTitle()%></h1>
            </div>
            <div class="p-description">
                <ul class="listInline listInline--bullet" style="
                    display: flex;
                    list-style-type: none;
                    padding-left: 0px;
                    ">
                    <li style="
                        ">
                        <i class="fa--xf far fa-user" aria-hidden="true" title="Tạo bởi"></i>
                        <p><%=user.getUsername()%></p>
                    </li>
                    <li>
                        <i class="fa--xf far fa-clock" aria-hidden="true" title="Start date"></i>

                        <p><%= clickedQuestion.getCreatedAt()%></p>
                    </li>
                    <li class="tag-container">
                        <!--                        <p>mas291</p>
                                                <p>prj301</p>-->
                        <% for (Question_Tag tag : tagList) {%>
                        <p><%= tag.getTagID()%></p>
                        <%}%>
                    </li>
                </ul>

            </div>
        </div>

        <div class="body-content">
            <div class="content-column">
                <%= clickedQuestion.getContent()%>
            </div>
            <ul class="inner-comment-action">
                <li class="dislike">Dislike</li>
                <li class="like" >Like</li><i class="far fa-heart"></i><i class="fas fa-heart"></i>
                <li class="reply">Trả lời</li><i class="far fa-comment-alt"></i>
            </ul>
        </div>
        <% Object useridComment = session.getAttribute("userID");
            int isEdited = -1;
            if (useridComment != null) {
                isEdited = (Integer) useridComment;
            }
        %>

        <% for (Comment elem : commentList) {%>
        <div comment-container>
<!--            <div class="user-comment-img"><img src="pages/gaixinh.jpg" class="img-responsive"></div>-->

            <div class="comment-section" id="<%= elem.getCommentID()%>">

                <p><i class="fa--xf far fa-user"></i><%= elem.getUser().getUsername()%></p>
                <p style="display: none;" class="comment-Owner"><%=elem.getUser().getUserID()%></p>
                <% if (isEdited == elem.getUser().getUserID()) { %> 
                <i class="fas fa-ellipsis-h"></i>
                <%}%>

                <% if (elem.getReplyToComment().getContent() != null) {%>
                <div class="replied-comment">
                    <div class="replied-comment-user">
                        <%= elem.getReplyToComment().getUser().getUsername()%>
                        <i class="fas fa-arrow-up"></i>
                    </div>
                    <div class="replied-comment-conent">
                        <%= elem.getReplyToComment().getContent()%>
                    </div>
                </div>
                <% }%>
                <p class="user-comment-id" style="display: none;"><%= elem.getUser().getUserID()%></p>
                <div class="comment-content">
                    <%= elem.getContent()%>
                </div>

                <ul class="inner-comment-action">
                    <li class="dislike" value="<%= elem.getUser().getUserID()%>" onclick="dislike()">Dislike</li>
                    <li class="like" value="<%= elem.getUser().getUserID()%>" onclick="like()">Like</li><i class="far fa-heart"></i><i class="fas fa-heart"></i>
                    <li class="reply" onclick="scrollingToComment(this.parentNode.parentNode)" value="<%= elem.getUser().getUserID()%>" at>Trả lời</li><i class="far fa-comment-alt"></i>
                </ul>
            </div>
        </div>
        <% }
        %>

        <div class="login-warning btn btn-primary">
            <p>Bạn cần đăng nhập hoặc đăng kí để gửi bình luận</p>
        </div>
        <form action="Comment" method="POST">
            <div class="commnet-writer">
                <div class="text-function" style="display: flex; border: 1px solid #9e9e9e; border-bottom: none; padding: 5px;">

                    <div title="bold" class="func"> <button class="pure-button boldText" type="button">
                            <i class="fas fa-bold"></i>
                        </button></div>
                    <div title="italic" class="func"><button class="pure-button italicText" type="button">
                            <i class="fas fa-italic"></i>
                        </button></div>  
                    <div title="underline" class="func"> <button class="pure-button underlineText" type="button">
                            <i class="fa fa-underline"></i>
                        </button></div>
                </div>
                <div class="reply-status" style="    
                     display: none;
                     background-color: white;
                     border: 1px solid #9e9e9e;
                     border-bottom: none;
                     padding: 5px;
                     padding-left: 18px;
                     padding-right: 20px;">Đang trả lời <span style="font-style: italic; font-weight: bold;"></span><i class="fas fa-times close"></i></div>

                <div contenteditable="true" id="a" oninput="convert()" onchange="convert()" style="width: 100%; outline: none; border: 1px solid #9e9e9e; padding: 10px; max-width: 100%; min-height: 150px; max-height: 80%; min-width: 100%;"></div>
                <input value="<%= clickedQuestion.getQuestionID()%>" style="display: none;" name="questionid">
                <input class="sourceType" value="" style="display: none;" name="sourceType">
                <div>
                    <p class="warning-empty-comment" style="color: #795548;">Bình luận không được để trống</p>
                    <button class="post-comment comment-btn btn btn-primary" type="submit">Gửi bình luận</button>
                </div>
                <textarea style="display: none" id="my-text" name="comment-content"></textarea>
                <input name="questionOwner" value="<%=user.getUserID()%>">
                <input name="commentOwner" value="" class="commentOwner"> 
            </div>
        </form>




        <%@include file="../assets/footer.jsp" %>

        <script>
            function loadAjax() {
                var username = document.getElementById("username").value;
                var email = document.getElementById("email").value;
                var tel = document.getElementById("tel").value;
                var division = document.getElementById("division").value;


                var url = "test?username=" + username + "&email=" + email + "&division=" + division + "&tel=" + tel;
                alert(url);

                if (window.XMLHttpRequest) {

                    request = new XMLHttpRequest();

                } else if (window.ActiveXObject) {

                    request = new ActiveXObject("Microsoft.XMLHTTP");
                }

                try {
                    request.onreadystatechange = sendInfo;
                    request.open("POST", url, true);
                    request.send();

                } catch (e) {
                    alert("Unable to connect server");
                }

            }

            function sendInfo() {
                var p = document.getElementById("print");

                if (request.readyState == 1) {
                    var text = request.responseText;
                    p.innerHTML = "Please Wait.....";
                    console.log("1");
                }

                if (request.readyState == 2) {
                    var text = request.responseText;
                    console.log("2");

                }
                if (request.readyState == 3) {
                    var text = request.responseText;
                    console.log("3");

                }
                if (request.readyState == 4) {
                    var text = request.responseText;
                    p.innerHTML = " Request Processed  " + text;
                }
            }
//            var scrollUpToComment = document.querySelector(".replied-comment fas");
//            scrollUpToComment
            function scrollingToComment(ele) {
                var elem = document.querySelector(".commnet-writer");
                var text = document.querySelector("#a");
                var reply_status = document.querySelector(".reply-status span");
                var commentOwner = document.querySelector(".commentOwner");

                reply_status.innerHTML = "";
                commentOwner.value = "";

                document.querySelector(".sourceType").value = ele.id;
                text.focus();
                reply_status.innerHTML += ele.childNodes[1].innerText;
                commentOwner.value = ele.childNodes[3].innerText;
                console.log(reply_status);
                console.log(commentOwner);
                reply_status.parentNode.style.display = "block";
                elem.scrollIntoView();
            }
            var textOfDiv = document.getElementById("a");
            var textArea = document.getElementById("my-text");
            function convert() {
                textArea.value = textOfDiv.innerHTML;
                if (textArea.value == '') {
                    document.querySelector(".post-comment").type = "button";
                    document.querySelector(".warning-empty-comment").style.display = "block"
                } else
                {
                    document.querySelector(".post-comment").type = "submit";
                    document.querySelector(".warning-empty-comment").style.display = "none"
                }
                console.log(textArea.value);
            }
            var username = "${sessionScope.username}";
            if (username == '') {
                document.querySelector(".login-warning").style.display = "block"
                document.querySelector(".login-warning").style.width = "83%"
                document.querySelector(".comment-btn").style.display = "none"
                document.querySelector(".commnet-writer").style.display = "none"
                document.querySelector(".nav-account").style.display = "none"
                document.querySelector(".login").style.display = "block"
            } else {
                document.querySelector(".login-warning").style.display = "none"
                document.querySelector(".comment-btn").style.display = "block"
                document.querySelector(".commnet-writer").style.display = "block"
            }
            document.querySelector('#user-name').innerHTML = "${sessionScope.username}"

            $(document).ready(function () {
                $('.boldText').click(function () {
                    document.execCommand('bold');
                });
            });
            $(document).ready(function () {
                $('.italicText').click(function () {
                    document.execCommand('italic');
                });
            });
            $(document).ready(function () {
                $('.underlineText').click(function () {
                    document.execCommand('underline');
                });
            });
        </script>
    </body>
</html>
