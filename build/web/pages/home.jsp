<%-- 
    Document   : home.jsp
    Created on : Feb 4, 2022, 7:11:15 PM
    Author     : Admin
--%>

<%@page import="model.Major"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT University community</title>
        <title></title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="style/style1.css">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
            />

    </head>
    <% ArrayList<Major> majorList = (ArrayList<Major>) request.getAttribute("majorList");

    %>
    <body >
        <!--    <my-header></my-header>-->
        <%@include file="../assets/header.jsp" %>
        <div class="content-container">
            <div class="content-title">
                Các chuyên ngành học
            </div>

            <% for (int i = 0; i < majorList.size(); i++) {%>
            <div class="content">
                <div class="major-icon">
                    <i class="fas fa-laptop-code"></i>
                </div>

                <div class="major-content">
                    <a href="forums?id=<%= i + 1%>"><%= majorList.get(i).getName()%></a>
                    <p><%= majorList.get(i).getSummary()%></p>
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

        <!--    <my-footer></my-footer>-->
        <script>
//            document.getElementById("#login-btn").href += '&?locate=' + window.location.href;
            var username = "${sessionScope.username}";
            if (username == '') {
                document.querySelector(".nav-account").style.display = "none"
                document.querySelector(".login").style.display = "block"
            }
            document.querySelector('#user-name').innerHTML = "${sessionScope.username}"
        </script>
        <!--    <script src="components/header_footer_template.js"></script>-->
        <%@include file="../assets/footer.jsp" %>

    </body>
</html>
