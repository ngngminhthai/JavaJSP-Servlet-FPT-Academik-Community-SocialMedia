<%-- 
    Document   : header4
    Created on : Mar 1, 2022, 10:35:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <div class="header js-header js-dropdown">
        <div class="container">
            <div class="header__logo">
                <h1>
                    <img src="img/Logo_Forum.svg" alt="logo">
                </h1>
                <div class="header__logo-btn" data-dropdown-btn="logo">
                    Unity<i class="icon-Arrow_Below"></i>
                </div>
                <nav class="dropdown dropdown--design-01" data-dropdown-list="logo">
                    <ul class="dropdown__catalog">
                        <li><a href="index.html">Home Page</a></li>
                        <li><a href="single-topic.html">Single Topic Page</a></li>
                        <li><a href="simple-signup.html">Sign up Page</a></li>
                        <li><a href="create-topic.html">Create Topic Page</a></li>
                    </ul>
                </nav>
            </div>
            <div class="header__search">
                <form action="#">
                    <label>
                        <i class="icon-Search js-header-search-btn-open"></i>
                        <input type="search" placeholder="Search all forums" class="form-control">
                    </label>
                </form>
                <div class="header__search-close js-header-search-btn-close"><i class="icon-Cancel"></i></div>
                <div class="header__search-btn" data-dropdown-btn="search">
                    Topics<i class="icon-Arrow_Below"></i>
                </div>
                <div class="dropdown dropdown--design-01" data-dropdown-list="search">
                    <ul>
                        <li>
                            <label>
                                <label class="custom-checkbox">
                                    <input type="checkbox" checked="checked">
                                    <i></i>
                                </label>Search Titles Only
                            </label>

                        </li>
                        <li>
                            <label>
                                <label class="custom-checkbox">
                                    <input type="checkbox">
                                    <i></i>
                                </label>Show Results as Posts
                            </label>
                        </li>
                        <li>
                            <a href="#">
                                <i class="icon-Advanced_Search"></i>Advanced Search
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="header__menu">
                <div class="header__menu-btn" data-dropdown-btn="menu">
                    Latest Topics<i class="icon-Menu_Icon"></i>
                </div>
                <nav class="dropdown dropdown--design-01" data-dropdown-list="menu">
                    <div>
                        <ul class="dropdown__catalog row">
                            <li class="col-xs-6"><a href="#">New</a></li>
                            <li class="col-xs-6"><a href="#">Unread</a></li>
                            <li class="col-xs-6"><a href="#">Groups</a></li>
                            <li class="col-xs-6"><a href="#">Users</a></li>
                            <li class="col-xs-6"><a href="#">Tags</a></li>
                            <li class="col-xs-6"><a href="#">Shortcuts</a></li>
                        </ul>
                    </div>
                    <div>
                        <h3>Categories</h3>
                        <ul class="dropdown__catalog row">
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-f9bc64"></i>Hobbies</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-348aa7"></i>Social</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-4436f8"></i>Video</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-5dd39e"></i>Random</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-ff755a"></i>Arts</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-bce784"></i>Tech</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-83253f"></i>Gaming</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-c49bbb"></i>Science</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-3ebafa"></i>Exchange</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-c6b38e"></i>Pets</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-a7cdbd"></i>Entertainment</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-525252"></i>Education</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-777da7"></i>Q&amp;As</a></li>
                            <li class="col-xs-6"><a href="#" class="category"><i class="bg-368f8b"></i>Politics</a></li>
                        </ul>
                    </div>
                    <div>
                        <ul class="dropdown__catalog row">
                            <li class="col-xs-6"><a href="#">Support</a></li>
                            <li class="col-xs-6"><a href="#">Forum Rules</a></li>
                            <li class="col-xs-6"><a href="#">Blog</a></li>
                            <li class="col-xs-6"><a href="#">About</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
            <div class="header__notification">
                <div class="header__notification-btn" data-dropdown-btn="notification">
                    <i class="icon-Notification"></i>
                    <span>6</span>
                </div>
                <div class="dropdown dropdown--design-01" data-dropdown-list="notification">
                    <div>
                        <a href="#">
                            <i class="icon-Favorite_Topic"></i>
                            <p>Roswell . 16 feb, 17<span>Which movie have you watched recently?</span></p>
                        </a>
                        <a href="#">
                            <i class="icon-Reply_Empty"></i>
                            <p>Callis . 18 feb, 17<span>I got an amzon thingie!</span></p>
                        </a>
                        <a href="#">
                            <i class="icon-Badge"></i>
                            <p>Earned Badge . 19 feb, 17<span><img src="img/Lets_talk.svg" alt="Lets Talk">Lets Talk</span></p>
                        </a>
                        <a href="#">
                            <i class="icon-Badge"></i>
                            <p>Earned Badge . 21 feb, 17<span><img src="img/Intermediate.svg" alt="Intermediate">Intermediate</span></p>
                        </a>
                        <a href="#">
                            <i class="icon-Share_Topic"></i>
                            <p>Charlie . 22 feb, 17<span>Need Video file of that cat.</span></p>
                        </a>
                        <a href="#">
                            <i class="icon-Pencil"></i>
                            <p>Greentea . 22 feb, 17<span>New Facebook like and share button.</span></p>
                        </a>
                        <span><a href="#">view older notifications...</a></span>
                    </div>
                </div>
            </div>
            <div class="header__user">
                <div class="header__user-btn" data-dropdown-btn="user">
                    <img src="img/A.svg" alt="avatar">
                    azyrusmax<i class="icon-Arrow_Below"></i>
                </div>
                <nav class="dropdown dropdown--design-01" data-dropdown-list="user">
                    <div>
                        <div class="dropdown__icons">
                            <a href="#"><i class="icon-Bookmark"></i></a>
                            <a href="#"><i class="icon-Message"></i></a>
                            <a href="#"><i class="icon-Preferences"></i></a>
                            <a href="#"><i class="icon-Logout"></i></a>
                        </div>
                    </div>
                    <div>
                        <ul class="dropdown__catalog">
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Badges</a></li>
                            <li><a href="#">My Groups</a></li>
                            <li><a href="#">Notifications</a></li>
                            <li><a href="#">Topics</a></li>
                            <li><a href="#">Likes</a></li>
                            <li><a href="#">Solved</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <div class="header__offset-btn">
            <a href="create-topic.html"><img src="img/New_Topic.svg" alt="New Topic"></a>
        </div>
    </div>
</header>