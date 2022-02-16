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
        <%@include file="../components/Bootstrap.jsp" %>
        <link rel="stylesheet" type="text/css" href="style/body.css">
        <link rel="stylesheet" type="text/css" href="style/footer.css">

        <link rel="stylesheet" href="style/thread.css">

        <link rel="stylesheet" href="style/header.css">



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <style>
            ul{
                display: flex;
            }
            ul li{
                margin: 0px 4px;
                list-style-type: none;
                color: #007bff! important;
            }
            ul li:first-child{
                margin-left: 0px;
                list-style-type: none;
            }
            ul li:hover{
                text-decoration: underline;
                cursor: pointer;
            }
            main {
                padding: 0px;
            }
            .app {
                padding: 0px;
                margin: 0px;
                max-width: 100%;
            }
            .element-with-the-scrollbar {
                overflow-y: scroll;
                scroll-behavior: smooth;
            }
            h6{
                width: 100%;
            }
            .replied-comment{
                padding-right: 0px;

            }
        </style>
    </head>


    <body class="d-flex flex-column min-vh-100">
        <div class="alert alert-primary" role="alert">
            This is a primary alert—check it out!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <%@include file="../assets/header2.jsp" %>
        <% Question clickedQuestion = (Question) request.getAttribute("clickedQues");
            User user = (User) request.getAttribute("userid");
            ArrayList<Question_Tag> tagList = (ArrayList<Question_Tag>) request.getAttribute("taglist");
            ArrayList<Comment> commentList = (ArrayList<Comment>) request.getAttribute("comlist");
        %>
        <!--        <div class="breadcrumb-container">
                    <nav aria-label="breadcrumb ">
                        <ol class="breadcrumb arr-right bg-dark ">
                            <li class="breadcrumb-item "><a href="#" class="text-light">Trang chủ</a></li>
                            <li class="breadcrumb-item text-light active" aria-current="page"><a href="#" class="text-light"><%= clickedQuestion.getMajorID()%></a></li>
        
                        </ol>
                    </nav>
                </div>-->

        <div class="card" style="
             ">
            <div class="card-body">
                <div class="d-flex flex-start align-items-center">
                    <img class="rounded-circle shadow-1-strong me-3" src="pages/thai.jpg" alt="avatar" width="60" height="60">
                    <div>
                        <h6 class="fw-bold text-primary mb-1"><%=user.getUsername()%></h6>
                        <p class="text-muted small mb-0">
                            <%=clickedQuestion.getCreatedAt()%>
                        </p>
                    </div>
                    <div class="tag-container fw-bold text-primary mb-1" style="display: flex;">
                        <div class="icon-tag"><i class="fa fa-tags" aria-hidden="true"></i></div>
                        <div class="tags" style="display:flex;"><% for (Question_Tag tag : tagList) {%>
                            <p><%= tag.getTagID()%></p>
                            <%}%></div>
                    </div>
                </div>

                <p class="mt-3 mb-4 pb-2">
                    <%= clickedQuestion.getTitle()%>
                </p>
                <p class="mt-3 mb-4 pb-2">
                    <%= clickedQuestion.getContent()%>
                </p>

                <div class="small d-flex justify-content-start">
                    <a href="" class="d-flex align-items-center me-3">
                        <i class="fa fa-heart-o" aria-hidden="true"></i>

                        <p class="mb-0"> Yêu thích</p>
                    </a>
                    <a href="" class="d-flex align-items-center me-3">
                        <i class="fa fa-comment-o" aria-hidden="true"></i>
                        <p class="mb-0"> Bình luận</p>
                    </a>

                </div>
                <div class="react-bar">Nam, và 3 người khác</div>
            </div>

        </div>


        <% Object useridComment = session.getAttribute("userID");
            int isEdited = -1;
            if (useridComment != null) {
                isEdited = (Integer) useridComment;
            }
        %>

        <% for (Comment elem : commentList) {%>
        <div class="card mb-3">
            <div class="card-body">
                <div class="d-flex flex-start">
                    <img class="rounded-circle shadow-1-strong me-3" src="pages/thai.jpg" alt="avatar" width="40" height="40">
                    <div class="w-100">
                        <div class="d-flex justify-content-between align-items-center mb-3" style="position: relative;">
                            <h6 class="text-primary fw-bold mb-0">
                                <%=elem.getUser().getUsername()%>

                                <% if (elem.getReplyToComment().getContent() != null) {%>
                                <div style="color: black; margin-top: 5px;" class="replied-comment">
                                    <div class="replied-comment-user">
                                        <%= elem.getReplyToComment().getUser().getUsername()%>
                                        <i class="fa fa-level-up" aria-hidden="true"></i>

                                    </div>
                                    <div class="replied-comment-conent">
                                        <%= elem.getReplyToComment().getContent()%>
                                    </div>
                                </div>
                                <% }%>

                                <p style="margin-top: 5px;" class="text-dark ms-2"><%= elem.getContent()%></p>
                            </h6>
                            <p style="   position: absolute;
                               top: 0px;
                               right: 0px;" class="mb-0">2 days ago</p>
                        </div>
                        <div class="d-flex justify-content-between align-items-center">
                            <!--                                                        <p class="small mb-0" style="color: #aaa;">
                                                                                        <a href="" class="link-grey">Thích</a> •
                                                                                        <a href="" class="link-grey">Trả lời</a> •
                                                                                        <a href="" class="link-grey">Translate</a>
                                                                                    </p>-->
                            <ul class="small mb-0" style="color: #aaa;" >
                                <li class="<%=elem.getUser().getUsername()%>"></li>
                                <li class="<%=elem.getUser().getUserID()%>"></li>
                                <li class="link-grey" value="<%=elem.getUser().getUserID()%>">Thích</li> • 
                                <li class="link-grey <%=elem.getUser().getUserID()%>" onclick="scrollingToComment(this)">Trả lời</li> • 
                                <li class="link-grey" value="<%=elem.getUser().getUserID()%>">Translate</li>
                            </ul>
                            <div class="d-flex flex-row">
                                <i class="fas fa-star text-warning me-2"></i>
                                <i class="far fa-check-circle" style="color: #aaa;"></i>
                            </div>                     
                        </div>
                    </div>
                </div>
                <div class="react-bar">Nam, và 3 người khác</div>
            </div>
        </div>

        <% }
        %>


        <% if (session.getAttribute("userID") != null) {%>
        <form action="Comment" method="POST">
            <div class="commnet-writer">


                <main>

                    <div ng-app="textAngularTest" ng-controller="wysiwygeditor" class="container app">
                        <p class="first-comment">Bình luận</p>
                        <div class="reply-status" style="    
                             /*                             display: none;*/
                             background-color: white;
                             border: 1px solid #9e9e9e;
                             border-bottom: none;
                             padding: 5px;
                             padding-left: 18px;
                             padding-right: 20px;">Đang trả lời <span style="font-style: italic; font-weight: bold;"></span><i class="fas fa-times close"></i></div>

                        <div class="text" text-angular="text-angular" name="htmlcontent" ng-model="htmlcontent" ta-disabled='disabled'></div>
                        <p>Mã văn bản</p>
                        <textarea ng-model="htmlcontent" style="width: 100%"></textarea>
                        <div ng-bind-html="htmlcontent"></div>
                        <div class="d-none" ta-bind="text" ng-model="htmlcontent" ta-readonly='disabled'></div>
                    </div>

                </main>
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
        <%} else { %>
        <div class="login-warning btn btn-primary">
            <p>Bạn cần đăng nhập hoặc đăng kí để gửi bình luận</p>
        </div>
        <%}
        %>



        <!-- Angular JS -->
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular.min.js'></script>
        <!-- Angular Sanitize JS -->
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular-sanitize.min.js'></script>
        <!-- Text Angular JS -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/textAngular/1.1.2/textAngular.min.js'></script>

        <%@include file="../assets/footer.jsp" %>

        <script>
                            angular.module("textAngularTest", ['textAngular']);
                            function wysiwygeditor($scope) {
                                $scope.orightml = '';
                                $scope.htmlcontent = $scope.orightml;
                                $scope.disabled = false;
                            }
                            ;

                            function scrollingToComment(ele) {
                                var text = document.querySelector(".first-comment");
                                var comment = document.querySelector(".commentOwner");
                                console.log(ele.classList[1]);

                                comment.value = ele.classList[1];

                                text.scrollIntoView();
                                document.querySelector(".text").focus();
                            }

        </script>
    </body>
</html>
