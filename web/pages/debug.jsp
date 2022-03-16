<%-- 
    Document   : debug
    Created on : Mar 15, 2022, 10:36:49 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="tt-item">
            <div class="tt-col-avatar uelem.getUserID() 
                    elem.getUser().getUsername()" onclick="displayProfile(this)">
                <% if (elem.getUser().getImg() != null) {%>
                <div class="tt-icon">
                    <img class="useavatar" src="${pageContext.request.contextPath}/img/<%=elem.getUser().getImg()%>">
                </div>
                <%} else {%>
                <svg class="tt-icon"> 
                <use  class="useavatar" xlink:href="#icon-ava-<%= elem.getUser().getUsername().charAt(0)%>"></use>
                </svg>

                <%}
                                            }%>
            </div>
            <div class="tt-col-description">
                <h6 class="tt-title"><a href="thread?questionid=<%=elem.getQuestionID()%>">
                        <%= elem.getTitle()%> 
                    </a></h6>
                <div class="row align-items-center no-gutters">
                    <div class="col-11">
                        <ul class="tt-list-badge">
                                        <li class="show-mobile"><a href="#"><span onclick="follow(this, ${sessionScope.userID})" class="tt-color<%=random.nextInt(21 - 1) + 1%> tt-badge main"><% if (elem.getMainTag() != null) {
                                                            out.print(elem.getMainTag().getTagid());
                                                        } %><i class="fa <% if (elem.getMainTag() != null && !elem.getMainTag().isIsLike()) {
                                                    out.print("fa-plus");
                                                } else {
                                                    out.print("fa-check");
                                                } %>" aria-hidden="true"></i></span></a></li>
                                        <% for (int j = 0; j < elem.getTags().size(); j++) {
                                        %>
                            <li><a href="#"><span class="tt-badge"><% if (elem.getTags().get(j) != null) {
                                    out.print(elem.getTags().get(j).getTagID());
                                } %><i class="fa <% if (elem.getMainTag() != null && !elem.getMainTag().isIsLike()) {
                                        out.print("fa-plus");
                                    } else {
                                        out.print("fa-check");
                                    } %>" aria-hidden="true" style="display: block; margin-left: 3px;"></i></span></a></li>
                                        <%
                                            }
                                        %>


                        </ul>
                    </div>
                    <div class="col-1 ml-auto show-mobile">
                        <div class="tt-value">elem.getLastActive()</div>
                    </div>
                </div>
            </div>

            <div class="tt-col-value  hide-mobile"><%= elem.getTotalLike()%></div>
            <div class="tt-col-value tt-color-select  hide-mobile"><%= elem.getTotalComment()%></div>
            <div class="tt-col-value  hide-mobile"><%= elem.getViews()%></div>

            <div class="col-lg-4">
                <div class="text-center card-box">
                    <div class="member-card pt-2 pb-2">
                        <div hidden="" class="thumb-lg member-thumb mx-auto"><img src="pages/thai.jpg" class="rounded-circle img-thumbnail" alt="profile-image"></div>
                        <div class="">
                            <h4></h4>
                            <p class="text-muted">@Software Engineering<span>| </span><span><a href="#" class="text-pink">useremail@gmail.com</a></span></p>
                        </div>
                        <ul class="social-links list-inline">
                            <li class="list-inline-item"><a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a></li>
                            <li class="list-inline-item"><a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a></li>
                            <li class="list-inline-item"><a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Skype"><i class="fa fa-skype"></i></a></li>
                        </ul>
                        <form action="createconversation" method="POST">
                            <input value="<%=elem.getUserID()%>" hidden="" name="userone">
                            <button type="submit" class="btn btn-primary mt-3 btn-rounded waves-effect w-md waves-light">Gửi tin nhắn</button>
                        </form>
                        <div class="mt-4">
                            <div class="row">
                                <div class="col-4">
                                    <div class="mt-3">
                                        <h4>2563</h4>
                                        <p class="mb-0 text-muted">So bai viet</p>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="mt-3">
                                        <h4>6952</h4>
                                        <p class="mb-0 text-muted">Luot tra loi</p>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="mt-3">
                                        <h4>1125</h4>
                                        <p class="mb-0 text-muted">Luot thich</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
