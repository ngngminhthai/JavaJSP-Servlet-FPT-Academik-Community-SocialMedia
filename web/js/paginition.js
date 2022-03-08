/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function pagger(id, pageindex, totalpage, gap, field)
{
    var url_string = window.location;
    var url = new URL(url_string);
    var page = url.searchParams.get("page");
    var currentPage = parseInt(page);

    var container = document.getElementsByClassName(id)[0];
    var result = '';
//    if (pageindex - gap > 1)
//        result += '<a href="list?page=1">First</a>';
    if (currentPage > 1)
        result += '<li class="page__btn btn"><span class="material-icons">chevron_left</span></li>';
    else
        result += '<li class="page__btn btn"><span class="material-icons">chevron_left</span></li>';


    for (var i = pageindex - gap; i < pageindex; i++) {
        if (i > 0)
            result += '<a href="home?page=' + i + ''+field+'" class="page__numbers">' + i + '</a>';
    }

    result += '<li class="page__numbers active">' + i + '</li>';


    for (var i = pageindex + 1; i <= pageindex + gap; i++)
        if (i <= totalpage)
            result += '<a href="home?page=' + i + ''+field+'" class="page__numbers">' + i + '</a>';

    result += '<li class="page__btn btn"><span class="material-icons">chevron_right</span></li>';

//    if (pageindex + gap < totalpage)
//        result += '<a href="list?page=' + totalpage + '">Last</a>';
    container.innerHTML = result;
}

function addFunc(totalpage) {
    var pagebtn = [];
      pagebtn =     document.querySelectorAll("li.btn")
    var next = pagebtn[1];
    var previous = pagebtn[0];
    var url_string = window.location;
    var url = new URL(url_string);
    var page = url.searchParams.get("page");
    var currentPage = parseInt(page);
    var currentPageNext = currentPage + 1;
    var currentPagePre = currentPage - 1;
    if (currentPage < totalpage) {
        next.addEventListener("click", () => {
            window.location.href = "home?page=" + currentPageNext;
        })
    }
    if (currentPage > 1) {
        previous.addEventListener("click", () => {
            window.location.href = "home?page=" + currentPagePre;
        })
    }
}

