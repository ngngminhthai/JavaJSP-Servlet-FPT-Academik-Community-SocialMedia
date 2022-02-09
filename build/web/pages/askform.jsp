<%-- 
    Document   : createQuestion
    Created on : Jan 31, 2022, 9:17:54 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog==" crossorigin="anonymous" />

        Import Pure Css files
        <link
            rel="stylesheet"
            href=
            "https://unpkg.com/purecss@1.0.0/build/pure-min.css"
            integrity=
            "sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
            crossorigin="anonymous"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="navbar.js"></script>
        <link rel="stylesheet" href="../style/style1.css">
        <style>
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
                color: graytext;
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
            /*            
                        .container {
                        border: 1px solid gray;
                        min-height: 50px; 
                        overflow: auto;
                        padding: 2px;
                        resize: both;
                        width: 400px;
                        font-size:15px;
                        color:#000;
                    }
                    div:empty:before{
                        content: attr(placeholder);
                        color: #ccc;
                    }*/
            .nav-under-container{
                margin-bottom: 40px;
            }
        </style>

            <script>
                function divide() {
                    var txt;
                    txt = document.getElementById('a').value;
                    var text = txt.split("  ");
                    var str = text.join('</br>');
                    document.write(str);
                }
                function breakline() {
                    var txt;
                    txt = document.getElementsByClassName('f1')[0].value;
        
                    txt = txt.replace(/\r?\n/g, '</br>');
                }
            </script>

    </head>
    <body>
    <my-header></my-header>
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
            <div class="text-function" style="display: flex; border: 1px solid hsl(210deg 8% 25%); border-bottom: none; padding: 5px;">
                
                                        <div title="bold" class="f1"><i class="fas fa-bold"></i></div>
                                                    <button id="jBold" title="bold" type="button"><b>B</b></button>
                                        <div title="italic" class="f2"><i class="fas fa-italic"></i></div>  
                                        <div title="break line" class="f3"><i class="fas fa-level-down-alt"></i></div>
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
            <div contenteditable="true" id="a" oninput="convert()" onchange="convert()" style="height: 300px; width: 100%; outline: none; border: 1px solid hsl(210deg 8% 25%); padding: 10px; max-width: 100%; min-height: 300px; max-height: 80%; min-width: 100%;"></div>
            <p style="margin-top: 10px; font-weight: bold">Thêm tag</p>
            <input style="margin-bottom: 10px;" type="text" list="datalist" onkeyup="ac(this.value)" placeholder="Nhập tag cho bài viết/ câu hỏi ở đây">
             On keyup calls the function everytime a key is released 
            <datalist id="datalist">

                <option value="Delhi"></option>
                <option value="Ahemdabad"></option>
                <option value="Punjab"></option>
                <option value="Uttar Pradesh"></option>
                <option value="Himachal Pradesh"></option>
                <option value="Karnatka"></option>
                <option value="Kerela"></option>
                <option value="Maharashtra"></option>
                <option value="Gujrat"></option>
                <option value="Rajasthan"></option>
                <option value="Bihar"></option>
                <option value="Tamil Nadu"></option>
                <option value="Haryana"></option>

                 This data list will be edited through javascript     
            </datalist>
                    <h2 style="font-size: 15px;"> Preview your post </h2>
            <textarea style="display: none" id="my-text" name="question-content"></textarea>
                    <div class="preview" style="border: 1px solid hsl(210deg 8% 25%); margin-top: 10px; padding: 10px;" contenteditable>
            <input type="submit" class="btn btn-primary" style="margin-top: 10px; height: 50px; width: 131px;" value="Gửi bài viết"/>

        </form>

    </div>




        <a class="btn btn-primary" href="ask" style="margin-top: 10px;">Post your question</a>
</div>

<my-footer></my-footer>
<script>
    var textOfDiv = document.getElementById("a");
    var textArea = document.getElementById("my-text");
    function convert() {
        textArea.value = textOfDiv.innerHTML;
    }
//    function makeBold() {
//        // obtain the object reference for the <textarea>
//        var txtarea = document.getElementById("a");
//
//        // obtain the index of the first selected character
//        var start = txtarea.selectionStart;
//        // obtain the index of the last selected character
//        var finish = txtarea.selectionEnd;
//        // obtain the selected text
//        var sel = txtarea.value.substring(start, finish);
//
//        if (txtarea.value.charAt(start - 1) == '<b>' && txtarea.value.charAt(finish + 1) == '</b>')
//        {
//            txtarea.value = txtarea.value.substring(0, start - 4) + sel + txtarea.value.substring(finish + 4);
//        } else {
//            // do something with the selected content
//            txtarea.value = txtarea.value.substring(0, start) + '<b>' + sel + '</b>' + txtarea.value.substring(finish);
//        }
//        preview();
//    }
//
//    txt = document.getElementById("a");
//    function breakline() {
//
//        txt.value = txt.value + '<br>';
//        txt.focus();
//    }
//    txt.addEventListener("keydown", (pressedKey) => {
////        if (pressedKey.keyCode == 27)
////            gallery.classList.remove("show");
//        if (pressedKey.keyCode == 13)
//            pressedKey.preventDefault();
//        if (pressedKey.keyCode == 13) {
//            txt.value = txt.value + '<br>';
//            txt.focus();
//        }
//
//    });
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


    <script src = "../view/navbardropdown.js" ></script>

</body>
</html>-->

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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="navbar.js"></script>
        <link rel="stylesheet" href="style/style1.css">
        <style>
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
                color: graytext;
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
        <%@include file="../assets/header.jsp" %>

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
                <div class="text-function" style="display: flex; border: 1px solid hsl(210deg 8% 25%); border-bottom: none; padding: 5px;">

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
                <div contenteditable="true" id="a" oninput="convert()" onchange="convert()" style="height: 300px; width: 100%; outline: none; border: 1px solid hsl(210deg 8% 25%); padding: 10px; max-width: 100%; min-height: 300px; max-height: 80%; min-width: 100%;"></div>


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


    <!--    <script src = "../view/navbardropdown.js" ></script>-->

</body>
</html>
