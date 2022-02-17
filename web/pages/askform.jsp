
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../components/Bootstrap.jsp" %>

        <link rel="stylesheet" type="text/css" href="style/body.css">
        <link rel="stylesheet" type="text/css" href="style/footer.css">
        <link rel="stylesheet" type="text/css" href="style/header.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <style>
            @import url('https://fonts.googleapis.com/css?family=Roboto&display=swap');
            @import url('https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css');
            *{ margin: 0; padding: 0;}
            body{
                font-family: 'Roboto', sans-serif;
                font-style: normal;
                font-weight: 300;
                font-smoothing: antialiased;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
                font-size: 15px;
                background: #eee;
            }
            .intro{
                background: #fff;
                padding: 60px 30px;
                color: #333;
                margin-bottom: 15px;
                line-height: 1.5;
                text-align: center;
            }
            .intro h1 {
                font-size: 18pt;
                padding-bottom: 15px;

            }
            .intro p{
                font-size: 14px;
            }

            .action{
                text-align: center;
                display: block;
                margin-top: 20px;
            }

            a.btn {
                text-decoration: none;
                color: #666;
                border: 2px solid #666;
                padding: 10px 15px;
                display: inline-block;
                margin-left: 5px;
            }
            a.btn:hover{
                background: #666;
                color: #fff;
                transition: .3s;
                -webkit-transition: .3s;
            }
            .btn:before{
                font-family: FontAwesome;
                font-weight: normal;
                margin-right: 10px;
            }
            .github:before{content: "\f09b"}
            .down:before{content: "\f019"}
            .back:before{content:"\f112"}
            .credit{
                background: #fff;
                padding: 12px;
                font-size: 9pt;
                text-align: center;
                color: #333;
                margin-top: 40px;

            }
            .credit span:before{
                font-family: FontAwesome;
                color: #e41b17;
                content: "\f004";


            }
            .credit a{
                color: #333;
                text-decoration: none;
            }
            .credit a:hover{
                color: #1DBF73; 
            }
            .credit a:hover:after{
                font-family: FontAwesome;
                content: "\f08e";
                font-size: 9pt;
                position: absolute;
                margin: 3px;
            }
            main{
                background: #fff;
                padding: 20px;

            }

            article li{
                color: #444;
                font-size: 15px;
                margin-left: 33px;
                line-height: 1.5;
                padding: 5px;
            }
            article h1,
            article h2,
            article h3,
            article h4,
            article p{
                padding: 14px;
                color: #333;
            }
            article p{
                font-size: 15px;
                line-height: 1.5;
            }

            @media only screen and (min-width: 1280px){
                main{
                    max-width: 1160px;
                    margin-left: auto;
                    margin-right: auto; 
                    padding: 24px;
                }


            }

            .set-overlayer,
            .set-glass,
            .set-sticky {
                cursor: pointer;
                height: 45px;
                line-height: 45px;
                padding: 0 15px;
                color: #333;
                font-size: 16px;
            }
            .set-overlayer:after,
            .set-glass:after,
            .to-active:after,
            .set-sticky:after {
                font-family: FontAwesome;
                font-size: 18pt;
                position: relative;
                float: right;
            }
            .set-overlayer:after,
            .set-glass:after,
            .set-sticky:after {
                content: "\f204";
                transition: .6s;
            }

            .to-active:after {
                content: "\f205";
                color: #008080;
                transition: .6s;
            }
            .set-overlayer,
            .set-glass,
            .set-sticky,
            .source,
            .theme-tray {
                margin: 10px;
                background: #f2f2f2;
                border-radius: 5px;
                border: 2px solid #f1f1f1;
                box-sizing: border-box;
            }
            /* Syntax Highlighter*/

            pre.prettyprint {
                padding: 15px !important;
                margin: 10px;
                border: 0 !important;
                background: #f2f2f2;
                overflow: auto;
            }

            .source {
                white-space: pre;
                overflow: auto;
                max-height: 400px;
            }
            code{
                border:1px solid #ddd;
                padding: 2px;
                border-radius: 2px;
            }
            .ta-editor {
                min-height: 300px;
                height: auto;
                overflow: auto;
                font-family: inherit;
                font-size: 100%;
            }

            .ta-hidden-input {
                width: 1px;
                height: 1px;
                border: none;
                margin: 0;
                padding: 0;
                position: absolute;
                top: -10000px;
                left: -10000px;
                opacity: 0;
                overflow: hidden;
            }

            /* add generic styling for the editor */
            .ta-root.focussed > .ta-scroll-window.form-control {
                border-color: #555;
                outline: 0;
                -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(102, 175, 233, 0.6);
                -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(102, 175, 233, 0.6);
                box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(102, 175, 233, 0.6);
            }

            .ta-editor.ta-html, .ta-scroll-window.form-control {
                min-height: 300px;
                height: auto;
                overflow: auto;
                font-family: inherit;
                font-size: 100%;
            }

            .ta-scroll-window.form-control {
                position: relative;
                padding: 0;
            }

            .ta-scroll-window > .ta-bind {
                height: auto;
                min-height: 300px;
                padding: 6px 12px;
            }

            .ta-editor:focus {
                user-select: text;
            }

            /* add the styling for the awesomness of the resizer */
            .ta-resizer-handle-overlay {
                z-index: 100;
                position: absolute;
                display: none;
            }

            .ta-resizer-handle-overlay > .ta-resizer-handle-info {
                position: absolute;
                bottom: 16px;
                right: 16px;
                border: 1px solid black;
                background-color: #555;
                padding: 0 4px;
                opacity: 0.7;
            }

            .ta-resizer-handle-overlay > .ta-resizer-handle-background {
                position: absolute;
                bottom: 5px;
                right: 5px;
                left: 5px;
                top: 5px;
                border: 1px solid black;
                background-color: rgba(0, 0, 0, 0.2);
            }

            .ta-resizer-handle-overlay > .ta-resizer-handle-corner {
                width: 10px;
                height: 10px;
                position: absolute;
            }

            .ta-resizer-handle-overlay > .ta-resizer-handle-corner-tl{
                top: 0;
                left: 0;
                border-left: 1px solid black;
                border-top: 1px solid black;
            }

            .ta-resizer-handle-overlay > .ta-resizer-handle-corner-tr{
                top: 0;
                right: 0;
                border-right: 1px solid black;
                border-top: 1px solid black;
            }

            .ta-resizer-handle-overlay > .ta-resizer-handle-corner-bl{
                bottom: 0;
                left: 0;
                border-left: 1px solid black;
                border-bottom: 1px solid black;
            }

            .ta-resizer-handle-overlay > .ta-resizer-handle-corner-br{
                bottom: 0;
                right: 0;
                border: 1px solid black;
                cursor: se-resize;
                background-color: #555;
            }

            /* copy the popover code from bootstrap so this will work even without it */
            .popover {
                position: absolute;
                top: 0;
                left: 0;
                z-index: 1060;
                display: none;
                max-width: 276px;
                padding: 1px;
                font-size: 14px;
                font-weight: normal;
                line-height: 1.42857143;
                text-align: left;
                white-space: normal;
                background-color: #fff;
                -webkit-background-clip: padding-box;
                background-clip: padding-box;
                border: 1px solid #ccc;
                border: 1px solid rgba(0, 0, 0, .2);
                border-radius: 6px;
                -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
                box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
            }
            .popover.top {
                margin-top: -10px;
            }
            .popover.bottom {
                margin-top: 10px;
            }
            .popover-title {
                padding: 8px 14px;
                margin: 0;
                font-size: 14px;
                background-color: #f7f7f7;
                border-bottom: 1px solid #ebebeb;
                border-radius: 5px 5px 0 0;
            }
            .popover-content {
                padding: 9px 14px;
            }
            .popover > .arrow,
            .popover > .arrow:after {
                position: absolute;
                display: block;
                width: 0;
                height: 0;
                border-color: transparent;
                border-style: solid;
            }
            .popover > .arrow {
                border-width: 11px;
            }
            .popover > .arrow:after {
                content: "";
                border-width: 10px;
            }
            .popover.top > .arrow {
                bottom: -11px;
                left: 50%;
                margin-left: -11px;
                border-top-color: #999;
                border-top-color: rgba(0, 0, 0, .25);
                border-bottom-width: 0;
            }
            .popover.top > .arrow:after {
                bottom: 1px;
                margin-left: -10px;
                content: " ";
                border-top-color: #fff;
                border-bottom-width: 0;
            }
            .popover.bottom > .arrow {
                top: -11px;
                left: 50%;
                margin-left: -11px;
                border-top-width: 0;
                border-bottom-color: #999;
                border-bottom-color: rgba(0, 0, 0, .25);
            }
            .popover.bottom > .arrow:after {
                top: 1px;
                margin-left: -10px;
                content: " ";
                border-top-width: 0;
                border-bottom-color: #fff;
            }
            body{
                background-color: hsl(210deg 8% 95%);
            }
            #first-container{
                width: 73%;
                height: 82vh;
                background-color: white;

                box-shadow: 0px 0px 3px 0px;
                border-radius: 9px;
                padding: 2%;
                height: max-content;
                margin-bottom: 4% !important;
                margin: 0 auto;

            }
            #first-container input{
                padding-left: 10px;
                width: 100%;
                border: none;
                outline: none;
            }
            #first-container input:focus{
                border-bottom: 1px solid blue;
            }
            .title{
                color: black;
                font-size: 15px;
                font-weight: bold;
            }
            .aftertitle{
                font-size: 13px;
                color: hsl(210deg 8% 25%);
            }
            .func{
                margin-left: 10px;
            }
            func .fas, .fa{
                font-size: 15px;

                cursor: pointer;
                transition: color 0.5s;
            }
            .func:hover .fas{
                color: black;
            }
            .func:hover .fa{
                color: black;
            }
            .preview{
                height: max-content;
                width: 100%;
            }
            #a{
                overflow: auto;

                resize: both;
            }

            .nav-under-container{
                margin-bottom: 40px;
            }


            .tag-wrapper {
                width: 500px;
                background: #fff;
                border-radius: 10px;
                padding: 18px 25px 20px;
                box-shadow: 0 0 30px rgba(0, 0, 0, 0.06);
                font-family: "Poppins", sans-serif;
            }

            .title h2 {
                font-size: 21px;
                font-weight: 600;
            }

            .tag-content ul {
                display: flex;
                flex-wrap: wrap;
                padding: 10px;
                margin: 20px 0;
                border-radius: 5px;
                border: 1px solid #888;
            }

            .tag-content ul li {
                color: #333;
                margin: 4px 3px;
                list-style: none;
                border-radius: 5px;
                background: #8cc84c;
                padding: 5px 8px 5px 10px;
                color: white;
            }

            .tag-content ul li i {
                margin-left: 8px;
                font-size: 16px;
                cursor: pointer;
            }

            .tag-content ul input {
                flex: 1;
                padding: 5px;
                border: none;
                outline: none;
                font-size: 16px;
            }

            .btn-removeAll {
                border: none;
                outline: none;
                color: #fff;
                font-size: 16px;
                cursor: pointer;
                padding: 9px 15px;
                border-radius: 5px;
                background: #8cc84c;
                transition: all 0.3s ease;
            }

            .btn-removeAll:hover {
                background: #7cac49;
            }

        </style>

    </head>
    <body>
        <%@include file="../assets/header2.jsp" %>

        <div id="first-container"> 
            <div class="title">Nhập tiêu đề bài viết</div>
            <p class="aftertitle">Tiêu đề bài viết cần cụ thể và rõ ràng 
            </p>
            <form action="ask" method="post">
                <input name="question-title" type="text" maxlength="300" tabindex="100" placeholder="Nhập tiêu đề của bạn ở đây" data-min-length="15" data-max-length="150" autocomplete="off">
                <div class="title" style="
                     margin-top: 15px;">Nội dung</div>
                <p class="aftertitle">Bao gồm tất cả những thông tin mà bạn có để mọi người có thể hiểu và phân tích

                </p>
                <main>
                    <!-- DEMO HTML -->
                    <div ng-app="textAngularTest" ng-controller="wysiwygeditor" class="container app">
                        <div text-angular="text-angular" name="htmlcontent" ng-model="htmlcontent" ta-disabled='disabled'></div>
                        <h3>Đầu ra</h3>
                        <textarea ng-model="htmlcontent" style="width: 100%"></textarea>
<!--                        <div ng-bind-html="htmlcontent"></div>-->
                        <div class="d-none" ta-bind="text" ng-model="htmlcontent" ta-readonly='disabled'></div>
                    </div>


                    <!-- Angular JS -->
                    <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular.min.js'></script>
                    <!-- Angular Sanitize JS -->
                    <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular-sanitize.min.js'></script>
                    <!-- Text Angular JS -->
                    <script src='https://cdnjs.cloudflare.com/ajax/libs/textAngular/1.1.2/textAngular.min.js'></script>

                    <script>
                            angular.module("textAngularTest", ['textAngular']);
                            function wysiwygeditor($scope) {
                                $scope.orightml = '';
                                $scope.htmlcontent = $scope.orightml;
                                $scope.disabled = false;
                            }
                            ;
                    </script>


                </main>

                <div class="tag-wrapper">
                    <div class="title">
                        <p>Thêm Tags</p>
                    </div>
                    <div class="tag-content">
                        <ul class="tag-container">
                            <input id="tag-inputed"
                                   style="border-bottom: none;"
                                   class="tag-input"
                                   type="text"
                                   spellcheck="false"
                                   placeholder="Type and enter space"
                                   />
                        </ul>
                    </div>
                    <button class="btn-removeAll" type="button">Remove All</button>
                </div>

                <!--        <h2 style="font-size: 15px;"> Preview your post </h2>-->
                <!--            Text area for saving content-->
                <textarea style="display: none" id="my-text" name="question-content"></textarea>
                <!--            Text area for saving tag name-->
                <textarea style="display: none" id="my-tag" name="tag-content"></textarea>
                <!--        <div class="preview" style="border: 1px solid hsl(210deg 8% 25%); margin-top: 10px; padding: 10px;" contenteditable>-->
                <input type="submit" class="btn btn-primary" style="margin-top: 10px; height: 50px; width: 131px;" value="Gửi bài viết"/>
                <input name="forumID" type="text" style="display: none" value="<%= request.getAttribute("forumID")%>">
            </form>

        </div>




        <!--    <a class="btn btn-primary" href="ask" style="margin-top: 10px;">Post your question</a>-->
    </div>

    <%@include file="../assets/footer.jsp" %>

    <script>




                            var username = "${sessionScope.username}";
                            if (username == '') {
                                document.querySelector(".nav-account").style.display = "none"

                                document.querySelector(".login").style.display = "block"
                            }
                            document.querySelector('#user-name').innerHTML = "${sessionScope.username}"


                            const ul = document.querySelector(".tag-container"),
                                    input = document.querySelector(".tag-input");

                            let tags = [];

                            createTag();

                            function createTag() {
                                ul.querySelectorAll("li").forEach((li) => li.remove());
                                tags
                                        .slice()
                                        .reverse()
                                        .forEach((tag) => {
                                            let liTag = `
                <li>` + tag + `
                <i class="uit uit-multiply" onclick="removeTag(this, '${tag}')"></i>
                </li>
                `;
                                            ul.insertAdjacentHTML("afterbegin", liTag);
                                        });
                                input.focus();
                            }

                            function removeTag(element, tag) {
                                let index = tags.indexOf(tag);
                                tags.splice(index, 1);
                                element.parentElement.remove();
                                input.focus();
                            }

                            function addTag(e) {
                                if (e.keyCode == 32) {
                                    let tag = e.target.value.trim();
                                    if (tag != "" && !tags.includes(tag)) {
                                        tags.push(tag);
                                        createTag();
                                    }
                                    e.target.value = "";
                                }
                            }

                            input.addEventListener("keyup", addTag);

                            const removeBtn = document.querySelector(".btn-removeAll");
                            removeBtn.addEventListener("click", () => {
                                tags.length = 0;
                                ul.querySelectorAll("li").forEach((li) => li.remove());
                                input.focus();
                            });


                            var textOfDiv = document.getElementById("a");
                            var textArea = document.getElementById("my-text");
                            var tagEntered = document.getElementById("tag-inputed");
                            var tagArea = document.getElementById("my-tag");

                            function convert() {
                                textArea.value = textOfDiv.innerHTML;
                            }

                            tagEntered.addEventListener('keydown', (pressed) => {
                                if (pressed.keyCode == 32) {
                                    tagArea.value += " " + tagEntered.value;
                                    console.log(tagArea.value);
                                }
                            })

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

                            function preview() {
                                var x = document.getElementById("a").value;
                                document.getElementById("demo").innerHTML = "";
                                document.getElementById("demo").innerHTML += x;
                            }

    </script>
    <script src="../components/header_footer_template.js"></script>


</body>
</html>
