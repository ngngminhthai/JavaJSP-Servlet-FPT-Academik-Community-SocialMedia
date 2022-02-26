<%-- 
    Document   : home3
    Created on : Feb 24, 2022, 12:01:48 PM
    Author     : Admin
--%>

<%@page import="model.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% ArrayList<Question> questionList = (ArrayList<Question>) request.getAttribute("ques");%>
        <table border="1">
            <thead>
                <tr>
                    <th>title</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <% for (Question elem : questionList) { %>
                <tr>
                    <td><% if (elem.getMainTag() != null) {
                            out.print(elem.getMainTag().getTagid());
                        }%></td>
                    <td><%= elem.getQuestionID()%></td>
                    <td>                 <% for (int j = 0; j < elem.getTags().size(); j++) {
                    %>
            <li><a href="#"><span class="tt-badge"><% if (elem.getTags().get(j) != null) {
                                                out.print(elem.getTags().get(j).getTagID());
                                            } %></span></a></li>
                    <%
                        }
                    %></td>
   
        </tr>
        <%     }
        %>


    </tbody>
</table>

</body>
</html>
