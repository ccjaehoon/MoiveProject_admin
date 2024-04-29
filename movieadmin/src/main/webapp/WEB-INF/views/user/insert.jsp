<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


<head>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
    $("#u_idCheck").click(function() {
        console.log("click...");
        console.log("user_id:", $("#user_id").val());
		
        document.getElementById("result").innerHTML = "";
        
        var userIdInput = document.getElementById("user_id");
        var userId = userIdInput.value.trim();
        var result = '';

        // 아이디의 정규식: 최소 6글자, 최대 12글자, 알파벳과 숫자만 허용
        var userIdRegex = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{6,12}$/;

        if (!userIdRegex.test(userId)) {
            // 아이디가 유효하지 않은 경우
            document.getElementById("result4").innerHTML = "아이디는 6글자 이상 12글자 이하의 알파벳과 숫자로 입력해주세요.";
            userIdInput.style.borderColor = "red";
            userIdInput.focus();
            return false; // 유효하지 않은 아이디이므로 함수를 종료하고 다음 단계로 진행하지 않음
        } else {
            // 아이디가 유효한 경우
            document.getElementById("result4").innerHTML = ""; // 결과 메시지 초기화
            userIdInput.style.borderColor = ""; // 테두리 색상 초기화

            // 여기서부터는 중복 체크를 위한 AJAX 요청 등을 수행할 수 있습니다.

            $.ajax({
                url : "http://localhost:8070/movie/u_idCheck.do",
                type : "get",
                data : {
                    user_id : $("#user_id").val()
                },
                dataType : "json",

                success : function(obj) {
                    console.log(obj);

                    if (obj.result == "OK") {
                        result = "사용 가능한 아이디입니다.";
                        $("#result").html(result); // 사용 가능한 아이디 메시지 표시
                    } else {
                        result = "중복된 아이디입니다.";
                        $("#result").html(result); // 중복된 아이디 메시지 표시
                    }
                    
                    // AJAX 요청 후에 input 테두리 색상 초기화
                    userIdInput.style.borderColor = "";
                },
                error : function(xhr, status) {
                    console.log("status...", status);
                }
            });
        }
        return false;
 
});


		  $("#password").blur(function() {
		        var passwordInput = $(this);
		        var password = passwordInput.val().trim();

		        // 비밀번호의 정규식: 최소 8자, 최소 하나의 대문자, 하나의 소문자, 하나의 숫자
		      var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[a-zA-Z\d!@#$%^&*]{8,}$/;

		        if (!passwordRegex.test(password)) {
		            // 비밀번호에 대한 오류 메시지 표시
		            passwordInput.css("borderColor", "red");
		            // 비밀번호에 대한 오류 메시지 표시 처리
		        } else {
		            // 비밀번호가 유효한 경우
		            passwordInput.css("borderColor", ""); // 테두리 색상 초기화
		        }
		    });
		$("#u_nicknameCheck").click(function() {
		    console.log("click...");
		    console.log("nickname:", $("#nickname").val());

		    var minLength = 2;
		    var maxLength = 8;

		    var nicknameInput = document.getElementById("nickname");

		    var nicknameInputLength = nicknameInput.value.length; // 변수 이름 수정
		    
		    // 결과 초기화
		      $("#result2").html(""); // 새로 추가된 부분
		        $("#result5").html(""); // 새로 추가된 부분

		    if (nicknameInputLength < minLength || nicknameInputLength > maxLength) {
		        document.getElementById("result5").innerHTML = "닉네임은 2글자 이상 8글자 이하로 입력해주세요.";
		        nicknameInput.style.borderColor = "red";
		        nicknameInput.focus();
		    } else {
		        document.getElementById("result5").innerHTML = "";
		        nicknameInput.style.borderColor = "";

		        $.ajax({
		            url: "http://localhost:8070/movie/u_nicknameCheck.do",
		            type: "get",
		            data: {
		                nickname: $("#nickname").val()
		            },
		            dataType: "json",
		            success: function(obj) {
		                console.log(obj);
		                let result = '';
		                if (obj.result == "OK") {
		                    result = "사용 가능합니다"
		                } else {
		                    result = "중복된 닉네임입니다"
		                }

		                $("#result2").html(result);
		            },
		            error: function(xhr, status) {
		                console.log("status...", status);
		            }
		        });
		    }

		        return false;	    
		});
		

		function isValidEmail(email) {
		    // 이메일 형식을 정의하는 정규 표현식
		    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		    return emailRegex.test(email); // 이메일 형식이 맞으면 true 반환, 아니면 false 반환
		}
		

		$(function() {
		    $("#u_emailCheck").click(function() {
		        console.log("click...");
		        console.log("email:", $("#email").val());

		        var email = $("#email").val();
		        
		     // 결과 초기화
		      $("#result3").html(""); // 새로 추가된 부분
		        $("#result6").html(""); // 새로 추가된 부분

		        // 이메일 형식이 올바른지 확인
		        if (!isValidEmail(email)) {
		        	$("#email").css("borderColor", "red");
		            $("#result6").html("올바른 이메일 형식이 아닙니다."); // 수정된 부분
		            return false; // 올바르지 않은 형식이므로 AJAX 요청을 보내지 않음
		        }else {
		            // 이메일 형식이 올바를 때
		            $("#email").css("borderColor", ""); // 테두리 색상을 초기화하여 기본값으로 설정
		        }

		        // 이메일 중복 확인 AJAX 요청
		        $.ajax({
		            url: "http://localhost:8070/movie/u_emailCheck.do",
		            type: "get",
		            data: {
		                email: email
		            },
		            dataType: "json",
		            success: function(obj) {
		                console.log(obj);
		                let result = '';
		                if (obj.result == "OK") {
		                    result = "사용 가능합니다"
		                } else {
		                    result = "중복된 이메일입니다"
		                }
		                $("#result3").html(result);
		            },
		            error: function(xhr, status) {
		                console.log("status...", status);
		            }
		        });

		        return false;
		    });
		  });
	  });
</script>

</head>

<body>
	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>
		<h2>회원가입</h2>

		<form action="u_insertOK.do" method="post"
			enctype="multipart/form-data">
			<table class="alt">
				<tr>
					<td style="text-align: center;"><label for="user_id" >아이디</label></td>
					<td><input type="text" id="user_id" name="user_id" value=""
						placeholder="아이디" maxlength="12"> <span id="result"></span>
						<span id="result4"></span></td>
					<td width=150><a href="#" id="u_idCheck">아이디체크</a></td>
				</tr>
				<tr>
					<td style="text-align: center;"><label for="password">비밀번호</label></td>
					<td colspan="2"><input type="password" id="password"
						name="password" value="" placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td style="text-align: center;"><label for="nickname">별명</label></td>
					<td><input type="text" id="nickname" name="nickname" value=""
						placeholder="별명" maxlength="8"> <span id="result2"></span>
						<span id="result5"></span></td>
					<td width=150><a href="#" id="u_nicknameCheck">닉네임체크</a></td>
				</tr>
				<tr>
					<td style="text-align: center;"><label for="email">이메일</label></td>
					<td><input type="text" id="email" name="email" value=""
						placeholder="이메일"> <span id="result3"></span> <span
						id="result6"></span></td>
					<td width=150><a href="#" id="u_emailCheck">이메일체크</a></td>
				</tr>
				<tr>
					<td style="text-align: center;"><label for="tel">전화번호</label></td>
					<td colspan="2"><input type="tel" id="tel" name="tel"
						value="010" placeholder="전화번호"></td>
				</tr>
				<tr>
					<td style="text-align: center;"><label for="birth">생년월일</label></td>
					<td colspan="2"><input type="date" id="birth" name="birth"
						value=""></td>
				</tr>
				<tr>
					<td style="text-align: center;"><label for="gender">성별</label></td>
					<td colspan="2"><input type="radio" id="gender_male"
						name="gender" value="남자" ${vo2.gender == '남자' ? 'checked' : ''}>
						<label for="gender_male">남자</label> <input type="radio"
						id="gender_female" name="gender" value="여자"
						${vo2.gender == '여자' ? 'checked' : ''}> <label
						for="gender_female">여자</label> <input type="radio" id="gender_no"
						name="gender" value="비공개" ${vo2.gender == '비공개' ? 'checked' : ''}>
						<label for="gender_no">비공개</label></td>
				</tr>


				<tr>
					<td colspan="3"><input type="submit" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include></div>
</body>
<script>
  
  
</script>
<script>
    
    document.querySelector("form").addEventListener("submit", function(event) {
        console.log("sumbit");

        var userIdInput = document.getElementById("user_id");
        var passwordIdInput = document.getElementById("password");
        var nicknameInput = document.getElementById("nickname");
        var emailInput = document.getElementById("email");
        var telInput = document.getElementById("tel");
        var birthInput = document.getElementById("birth");
        var gender_male = document.getElementById("gender_male");
        var gender_female = document.getElementById("gender_female");
        var gender_no = document.getElementById("gender_no");

       
        var userInput = userIdInput.value.trim();
        var passwordInput = passwordIdInput.value.trim();
        var nickname = nicknameInput.value.trim();
        var email = emailInput.value.trim();
        var tel = telInput.value.trim();
        var birth = birthInput.value.trim();
        var gender_male_checked = gender_male.checked;
        var gender_female_checked = gender_female.checked;
        var gender_no_checked = gender_no.checked;
        

       
        var allFieldsFilled = true;
        if (userInput === "") {
            allFieldsFilled = false;
            userIdInput.style.borderColor = "red"; 
        }
        if (passwordInput === "") {
            allFieldsFilled = false;
            passwordIdInput.style.borderColor = "red";
        } else {
        	var passwordValid = true; // 비밀번호 유효성 여부를 저장할 변수
            // 비밀번호의 정규식: 최소 8자, 최소 하나의 대문자, 하나의 소문자, 하나의 숫자, 특수문자 허용
            var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[a-zA-Z\d!@#$%^&*]{8,}$/;
            if (!passwordRegex.test(passwordInput)) {
            	passwordValid = false; // 비밀번호 유효성을 false로 설정
                allFieldsFilled = false;
                passwordIdInput.style.borderColor = "red";
             
            }
        }
        if (nickname === "") {
            allFieldsFilled = false;
            nicknameInput.style.borderColor = "red";
        }
        if (email === "") {
            allFieldsFilled = false;
            emailInput.style.borderColor = "red";
        }
        if (tel === "") {
            allFieldsFilled = false;
            telInput.style.borderColor = "red";
        }
        if (birth === "") {
            allFieldsFilled = false;
            birthInput.style.borderColor = "red";
        }
        if (!gender_male_checked && !gender_female_checked && !gender_no_checked) {
            allFieldsFilled = false;
        }

       
        if (!passwordValid) {
            alert("비밀번호는 최소 8자 이상, 하나의 대문자, 하나의 소문자, 하나의 숫자, 하나의 특수문자를 포함해야 합니다."); // 사용자에게 알림
            event.preventDefault(); 
        } else if (!allFieldsFilled) {
            alert("모든 필수 항목을 작성해주세요."); // 사용자에게 알림
            event.preventDefault(); 
        }
    });
</script>
</html>