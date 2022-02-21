<%-- 
    Document   : forum
    Created on : Feb 5, 2022, 6:19:41 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT University community</title>
        <title></title>
        <%@include file="../components/Bootstrap.jsp" %>

        <link rel="stylesheet" type="text/css" href="style/body.css">
        <link rel="stylesheet" type="text/css" href="style/footer.css">
        <link rel="stylesheet" type="text/css" href="style/home.css">

        <link rel="stylesheet" type="text/css" href="style/header.css">

<!--        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
            />-->

    </head>
    <% ArrayList<Question> questionList = (ArrayList<Question>) request.getAttribute("clickedForum");
        int forumID = (Integer) request.getAttribute("forumID");
        request.setAttribute("forumID", forumID);
    %> 
    <body >
        <%@include file="../assets/header2.jsp" %>

        <div id="post" style="margin: 0 auto; width: 85%; position: relative; height: 50px; margin-top: 20px;">
            <a style="    -webkit-text-size-adjust: 100%;
               font: 17px / 1.4 sans-serif;
               font-family: 'Segoe UI','Helvetica Neue',Helvetica,Roboto,Oxygen,Ubuntu,Cantarell,'Fira Sans','Droid Sans',sans-serif;
               font-weight: 400;
               word-wrap: break-word;
               float:right;
               right: 0px;
               box-sizing: border-box;
               display: inline-flex;
               align-items: center;
               justify-content: center;
               text-decoration: none;
               cursor: pointer;
               border: 1px solid transparent;
               white-space: nowrap;
               transition: background-color .125s ease, border-color .125s ease, color .125s ease;
               font-size: 14px;
               transform: translate(0px, 20px);
               bottom: 0px;
               border-radius: 4px;
               padding-top: 5px;
               padding-right: 10px;
               padding-bottom: 5px;
               padding-left: 10px;
               text-align: center;
               color: #fff;
               background: #f44336;
               border-color: #f39e25 #da840c #da840c #f39e25;" href="ask?forum=<%= forumID%>"><i style="margin-right: 5px;" class="far fa-edit"></i> Đăng bài viết</a>
        </div>

        <div class="content-container" style="margin-top: 10px; width: 85%;">

            <div class="content-title">
                Bài viết gần đây
            </div>

            <% for (int i = 0; i < questionList.size(); i++) {%>
            <div class="content">
                <div class="major-icon">

                </div>

                <div class="major-content">
                    <a href="thread?questionid=<%= questionList.get(i).getQuestionID()%>"><%= questionList.get(i).getTitle()%></a>
                    <p><%= questionList.get(i).getSummary()%></p>
                </div>

            </div>
            <%  }
            %>
            <!--        <div class="content">
                        <div class="major-icon">
                            <i class="fas fa-laptop-code"></i>
                        </div>
            
                        <div class="major-content">
                            <a href="#">Software Engineering</a>
                            <p>Chuyên ngành kĩ thuật phần mềm</p>
                        </div>
            
                    </div>-->



            <div class="active-user">

            </div>
        </div>
        <script>
//            document.getElementById("login-btn").href += '&?locate=' + window.location.href;
//            console.log(' href => ' + window.location.href);
//            console.log(' host => ' + window.location.host);
//            console.log(' hostname => ' + window.location.hostname);
//            console.log(' port => ' + window.location.port);
//            console.log(' protocol => ' + window.location.protocol);
//            console.log(' pathname => ' + window.location.pathname);
//            console.log(' hashpathname => ' + window.location.hash);
//            console.log(' search=> ' + window.location.search);

            var username = "${sessionScope.username}";
            if (username == '') {
                document.querySelector(".nav-account").style.display = "none"
                document.querySelector('#post').innerHTML = 'Bạn cần đăng nhập để đăng bài viết'
                document.querySelector(".login").style.display = "block"
            }
            document.querySelector('#user-name').innerHTML = "${sessionScope.username}"
        </script>
        <%@include file="../assets/footer.jsp" %>

        <script src="components/header_footer_template.js"></script>
    </body>

</html>
