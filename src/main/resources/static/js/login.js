function f1() {
    let login = document.getElementById("loginForm");
    let userParameters = {
        userid: login.userid.value,
        passwd: login.passwd.value
    }
    $.ajax({
        url: "/doLogin",
        method: "get",
        data: userParameters,
        dataType: "text",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            // alert(userParameters.userid + "/" + userParameters.passwd)
            f(userParameters.userid,userParameters.passwd)
        },
        error: function (request, status, error) {
            // alert("status : " + request.status + ", message : " + request.responseText + ", error : " + error);
            alert("잘못된 회원 정보입니다.");
        }
    });
}
function f(userId, userPw) {
    userId = document.getElementById("u_id").value;
    userPw = document.getElementById("u_pw").value;

    console.log(userId,userPw);
    alert("ddd");
    if ('' !== userId) {
        if ('' !== userPw) {
            location.replace("main");
        } else {
            location.replace("login");
        }
    } else {
        location.replace("login");
    }
}
