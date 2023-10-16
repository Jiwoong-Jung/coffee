$(function(){

    // alert("나온다");

    $.ajax({
        url: '/check',
        method: 'get',
        dataType: "text",
        success: function (data) {
            if (data == 'ok') {
                $('#order').attr('disabled', true);
            }
            console.log(data);

        }
    });


    // $("p").on("click", function() {        // <p> 요소를 모두 선택
    //     $("span").css("fontSize", "10px");  // <span> 요소를 모두 선택
    // });
});