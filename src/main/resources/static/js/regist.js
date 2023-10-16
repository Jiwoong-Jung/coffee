$(document).ready(function (){
            $("#btn").click(function (){
                if ($("#m_id").val().length< 1){
                    alert("아이디를 입력해주세요.");
                    $("#m_id").focus();
                    return false;
                }

                if ($("#m_pw").val() != $("#pw2").val()) {
                    alert("비밀번호가 일치하지 않습니다.");
                    $("#pw2").focus();
                    return false;
                }

                if($("#m_pw").val().length< 4){
                    alert("비밀번호를 4자 이상 입력해주세요.")
                    $("#m_pw").focus();
                    return false;
                }
                if($("#m_name").val().length < 2){
                    alert("이름을 2자 이상 입력해주세요.")
                    $("#m_name").focus();
                    return false;
                }

                if ($("#nickname").val().length< 1) {
                    alert("닉네임을 입력해주세요.");
                    $("#nickname").focus();
                    return false;
                }

                if (!$("#male").is(":checked") && !$("#female").is(":checked")){
                    alert("성별을 선택해주세요");
                    $("#gender").focus();
                    return false;
                }

                $.ajax({
                    url : "idcheck",
                    type : "post",
                    data : {"id" :$("#m_id").val()},//보낼 데이터
                    dataType : "text",

                    success : function (result1){  //()는 받을 데이터
                        var idChk = result1;
                        if(idChk == "false" ) {    //""가 필요
                            alert("중복된 아이디입니다! 다른 아이디를 사용해주세요");
                            location.reload(); // 새로 고침 되서 쓰는 사람이 열받을 거 같다
                        }
                    }
                })

                $.ajax({
                    url : "nickcheck",
                    type : "post",
                    data : {"nickname" :$ ("#nickname").val()},//보낼 데이터
                    dataType : "text",

                    success : function (result2){  //()는 받을 데이터
                        var nickChk = result2;
                        if(nickChk == "false" ) {    //""가 필요
                            alert("중복된 닉네임입니다! 다른 닉네임을 사용해주세요");
                            location.reload();

                        }
                    }
                })
            })

        });