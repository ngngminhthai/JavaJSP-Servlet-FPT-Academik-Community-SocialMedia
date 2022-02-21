<%-- 
    Document   : Conversation
    Created on : Feb 11, 2022, 10:16:53 AM
    Author     : Admin
--%>

<%@page import="model.Message"%>
<%@page import="model.Conversation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-color: #eee !important;
                margin-top:20px;

            }
            .card {
                background: #fff;
                transition: .5s;
                border: 0;
                margin-bottom: 30px;
                border-radius: .55rem;
                position: relative;
                width: 100%;
                box-shadow: 0 1px 2px 0 rgb(0 0 0 / 10%);
            }
            .chat-app .people-list {
                width: 280px;
                position: absolute;
                left: 0;
                top: 0;
                padding: 20px;
                z-index: 7
            }

            .chat-app .chat {
                margin-left: 280px;
                border-left: 1px solid #eaeaea
            }

            .people-list {
                -moz-transition: .5s;
                -o-transition: .5s;
                -webkit-transition: .5s;
                transition: .5s
            }

            .people-list .chat-list li {
                padding: 10px 15px;
                list-style: none;
                border-radius: 3px
            }

            .people-list .chat-list li:hover {
                background: #efefef;
                cursor: pointer
            }

            .people-list .chat-list li.active {
                background: #efefef
            }

            .people-list .chat-list li .name {
                font-size: 15px
            }

            .people-list .chat-list img {
                width: 45px;
                border-radius: 50%
            }

            .people-list img {
                float: left;
                border-radius: 50%
            }

            .people-list .about {
                float: left;
                padding-left: 8px
            }

            .people-list .status {
                color: #999;
                font-size: 13px
            }

            .chat .chat-header {
                padding: 15px 20px;
                border-bottom: 2px solid #f4f7f6
            }

            .chat .chat-header img {
                float: left;
                border-radius: 40px;
                width: 40px
            }

            .chat .chat-header .chat-about {
                float: left;
                padding-left: 10px
            }

            .chat .chat-history {
                padding: 20px;
                border-bottom: 2px solid #fff
            }

            .chat .chat-history ul {
                padding: 0
            }

            .chat .chat-history ul li {
                list-style: none;
                margin-bottom: 30px
            }

            .chat .chat-history ul li:last-child {
                margin-bottom: 0px
            }

            .chat .chat-history .message-data {
                margin-bottom: 15px
            }

            .chat .chat-history .message-data img {
                border-radius: 40px;
                width: 40px
            }

            .chat .chat-history .message-data-time {
                color: #434651;
                padding-left: 6px
            }

            .chat .chat-history .message {
                color: #444;
                padding: 18px 20px;
                line-height: 26px;
                font-size: 16px;
                border-radius: 7px;
                display: inline-block;
                position: relative
            }

            .chat .chat-history .message:after {
                bottom: 100%;
                left: 7%;
                border: solid transparent;
                content: " ";
                height: 0;
                width: 0;
                position: absolute;
                pointer-events: none;
                border-bottom-color: #fff;
                border-width: 10px;
                margin-left: -10px
            }

            .chat .chat-history .my-message {
                background: #efefef
            }

            .chat .chat-history .my-message:after {
                bottom: 100%;
                left: 30px;
                border: solid transparent;
                content: " ";
                height: 0;
                width: 0;
                position: absolute;
                pointer-events: none;
                border-bottom-color: #efefef;
                border-width: 10px;
                margin-left: -10px
            }

            .chat .chat-history .other-message {
                background: #e8f1f3;
                text-align: right
            }

            .chat .chat-history .other-message:after {
                border-bottom-color: #e8f1f3;
                left: 93%
            }

            .chat .chat-message {
                padding: 20px
            }

            .online,
            .offline,
            .me {
                margin-right: 2px;
                font-size: 8px;
                vertical-align: middle
            }

            .online {
                color: #86c541
            }

            .offline {
                color: #e47297
            }

            .me {
                color: #1d8ecd
            }

            .float-right {
                float: right
            }

            .clearfix:after {
                visibility: hidden;
                display: block;
                font-size: 0;
                content: " ";
                clear: both;
                height: 0
            }

            @media only screen and (max-width: 767px) {
                .chat-app .people-list {
                    height: 465px;
                    width: 100%;
                    overflow-x: auto;
                    background: #fff;
                    left: -400px;
                    display: none
                }
                .chat-app .people-list.open {
                    left: 0
                }
                .chat-app .chat {
                    margin: 0
                }
                .chat-app .chat .chat-header {
                    border-radius: 0.55rem 0.55rem 0 0
                }
                .chat-app .chat-history {
                    height: 300px;
                    overflow-x: auto
                }
            }

            @media only screen and (min-width: 768px) and (max-width: 992px) {
                .chat-app .chat-list {
                    height: 650px;
                    overflow-x: auto
                }
                .chat-app .chat-history {
                    height: 600px;
                    overflow-x: auto
                }
            }

            @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) and (orientation: landscape) and (-webkit-min-device-pixel-ratio: 1) {
                .chat-app .chat-list {
                    height: 480px;
                    overflow-x: auto
                }
                .chat-app .chat-history {
                    height: calc(100vh - 350px);
                    overflow-x: auto
                }
            }
            .chat-history ul{
                min-height: 500px !important;
            }
            .container{
                max-width: 1600px !important;
                margin-top: 3rem;
            }
        </style>
        <%@include file="../components/Bootstrap.jsp" %>

        <link rel="stylesheet" type="text/css" href="style/home.css">
        <link rel="stylesheet" type="text/css" href="style/footer.css">
        <link rel="stylesheet" type="text/css" href="style/header.css">
    </head>

    <body>
        <%@include file="../assets/header2.jsp" %>
        <% ArrayList<Conversation> cons = (ArrayList<Conversation>) request.getAttribute("conversations");%>

        <div class="container">
            <div class="row clearfix">
                <div class="col-lg-12">
                    <div class="card chat-app">
                        <div id="plist" class="people-list">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-search"></i></span>
                                </div>
                                <input type="text" class="form-control" placeholder="Search...">
                            </div>
                            <ul class="list-unstyled chat-list mt-2 mb-0">
                                <!--                                <li class="clearfix active">
                                                                    <img src="pages/thai.jpg" alt="avatar">
                                                                    <div class="about">
                                                                        <div class="name">tranducthuan</div>
                                                                        <div class="status"> <i class="fa fa-circle offline"></i> hoạt động 7 phút trước </div>                                            
                                                                    </div>
                                                                </li>-->
                                <% for (Conversation elem : cons) {%>
                                <li class="clearfix <%= elem.getUsername()%> <%= elem.getC_id()%>">
                                    <img src="pages/thai.jpg" alt="avatar">
                                    <div class="about">
                                        <div class="name userlist<%= elem.getC_id()%>"><%= elem.getUsername()%></div>
                                        <div class="status"> <i class="fa fa-circle online"></i> đang hoạt động </div>
                                    </div>
                                </li>
                                <% }
                                %>


                            </ul>
                        </div>
                        <div class="chat">
                            <div class="chat-header clearfix">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <a href="javascript:void(0);" data-toggle="modal" data-target="#view_info">
                                            <img src="pages/thai.jpg" alt="avatar">
                                        </a>
                                        <div class="chat-about">
                                            <h6 class="m-b-0">tranducthuan</h6>
                                            <small>Last seen: 2 hours ago</small>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 hidden-sm text-right">
                                        <a href="javascript:void(0);" class="btn btn-outline-secondary"><i class="fa fa-camera"></i></a>
                                        <a href="javascript:void(0);" class="btn btn-outline-primary"><i class="fa fa-image"></i></a>
                                        <a href="javascript:void(0);" class="btn btn-outline-info"><i class="fa fa-cogs"></i></a>
                                        <a href="javascript:void(0);" class="btn btn-outline-warning"><i class="fa fa-question"></i></a>
                                    </div>
                                </div>
                            </div>
                            <div class="chat-history" style="overflow-y: scroll; max-height: 400px;">
                                <ul class="m-b-0">

                                    <!--                                    <li class="clearfix">
                                                                            <div class="message-data">
                                                                                <span class="message-data-time">10:12 AM, Today</span>
                                                                            </div>
                                                                            <div class="message my-message">Are we meeting today?</div>                                    
                                                                        </li>                               -->
                                    <!--                                    <li class="clearfix">
                                                                            <div class="message-data">
                                                                                <span class="message-data-time">10:15 AM, Today</span>
                                                                            </div>
                                                                            <div class="message my-message">Project has been already finished and I have results to show you.</div>
                                                                        </li>
                                                                        <li class="clearfix">
                                                                            <div class="message-data">
                                                                                <span class="message-data-time">10:15 AM, Today</span>
                                                                            </div>
                                                                            <div class="message my-message">Project has been already finished and I have results to show you.</div>
                                                                        </li>-->

                                </ul>
                            </div>
                            <div class="chat-message clearfix">
                                <div class="input-group mb-0">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-send"></i></span>
                                    </div>


                                    <input type="text" class="form-control content" placeholder="Enter text here..." name="content">                    


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
    <%@include file="../assets/footer.jsp" %>
    <script>

        function Message(c_id, content, replyid) {
            this.c_id = c_id;
            this.content = content;
            this.replyid = replyid;


        }
        var messages = [];
        <% for (Conversation elem : cons) {
                for (int i = 0; i < elem.getMessages().size(); i++) {
        %>
        messages.push(new Message(<%= elem.getC_id()%>, '<%= elem.getMessages().get(i).getContent()%>',<%=elem.getMessages().get(i).getUserID()%>));
        <%    }
            }
        %>

        var currentActive = document.querySelector("li.clearfix");
        var userlist = document.querySelectorAll("ul.chat-list li.clearfix");
        var chatNameCurrent = document.querySelector(".chat-about h6");
        currentActive.classList.add("active");
        chatNameCurrent.innerHTML = currentActive.classList[1];
        var chatHistory = document.querySelector(".chat-history ul");
        var textmessgage = document.querySelector(".content");

        textmessgage.addEventListener("keydown", (key) => {
            console.log(key.keyCode)
            if (key.keyCode == 13) {
                var replyid = '<%=request.getSession().getAttribute("userID")%>';
                var cid = currentActive.classList[2];
                $.ajax({
                    url: "/FUWePass/message",
                    type: "post", //send it through get method
                    data: {
                        replyid: replyid,
                        cid: cid,
                        content: textmessgage.value
                    },
                    success: function (data) {
                        textmessgage.value = ""
                        chatHistory.innerHTML += data
                        document.querySelector(".chat-history").scrollTo(0,document.querySelector(".chat-history").scrollHeight);
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
        })


        for (var i = 0; i < messages.length; i++) {
            if (messages[i].c_id == currentActive.classList[2] && messages[i].replyid != '<%=request.getSession().getAttribute("userID")%>') {
                chatHistory.innerHTML += ` 
                                    <li class="clearfix">
                                        <div class="message-data">
                                            <span class="message-data-time">10:12 AM, Today</span>
                                        </div>
                                        <div class="message my-message">` + messages[i].content + `</div>                                    
                                    </li>                `
            } else if (messages[i].c_id == currentActive.classList[2]) {
                chatHistory.innerHTML += `  <li class="clearfix">
                            <div class="message-data text-right">
                                <span class="message-data-time">10:10 AM, Today</span>
                                <img src="pages/thai.jpg" alt="avatar">
                            </div>
                            <div class="message other-message float-right">` + messages[i].content + `</div>
                        </li>`
            }
        }

        userlist.forEach((elem) => {
            elem.addEventListener("click", () => {
                if (!elem.classList.contains("active")) {
                    currentActive.classList.remove("active");
                    currentActive = elem;
                    elem.classList.add("active");
                    chatNameCurrent.innerHTML = elem.classList[1];
                    chatHistory.innerHTML = ``;
                    for (var i = 0; i < messages.length; i++) {
                        if (messages[i].c_id == elem.classList[2] && messages[i].replyid != '<%=request.getSession().getAttribute("userID")%>') {
                            chatHistory.innerHTML += ` 
                                    <li class="clearfix">
                                        <div class="message-data">
                                            <span class="message-data-time">10:12 AM, Today</span>
                                        </div>
                                        <div class="message my-message">` + messages[i].content + `</div>                                    
                                    </li>                `
                        } else if (messages[i].c_id == elem.classList[2]) {
                            chatHistory.innerHTML += `  <li class="clearfix">
                            <div class="message-data text-right">
                                <span class="message-data-time">10:10 AM, Today</span>
                                <img src="pages/thai.jpg" alt="avatar">
                            </div>
                            <div class="message other-message float-right">` + messages[i].content + `</div>
                        </li>`
                        }
                    }
                }
            });
        });




    </script>
</html>
