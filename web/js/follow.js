function follow(elem, userid) {
    var tagname = elem.innerText;
    var arr = document.querySelectorAll("." + tagname);

    var icon = elem.querySelector("i");
    var maintagid = elem.innerText;

    if (icon.classList.contains("fa-plus")) {
//        icon.classList.remove("fa-plus");
//        icon.classList.add("fa-check");
        arr.forEach((ele) => {
            var icon2 = ele.querySelector("i");
            icon2.classList.remove("fa-plus");
            icon2.classList.add("fa-check");
        })
    } else {
        arr.forEach((ele) => {
            var icon2 = ele.querySelector("i");
            icon2.classList.remove("fa-check");
            icon2.classList.add("fa-plus");
        })
//        icon.classList.remove("fa-check");
//        icon.classList.add("fa-plus");
    }

    console.log(maintagid, userid);
    sendData(maintagid, userid);
}
function sendData(maintagid, userid) {
    $.ajax({
        url: "/FPTCommunity/tag",
        type: "post", //send it through get method
        data: {
            maintagid: maintagid,
            userid: userid
        },
        success: function () {
            console.log("follow successfully");
        },
        error: function () {
            //Do Something to handle error
        }
    });
}



