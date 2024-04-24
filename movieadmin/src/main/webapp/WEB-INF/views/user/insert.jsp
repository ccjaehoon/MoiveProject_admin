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

			  var minLength = 6;
			    var maxLength = 12;
			    // 결과 초기화
			      $("#result").html(""); // 새로 추가된 부분
			        $("#result4").html(""); // 새로 추가된 부분

			  
			    var userIdInput = document.getElementById("user_id");
				let result = '';

			    var userInputLength = userIdInput.value.length;
		        if (userInputLength < minLength || userInputLength > maxLength) {
		         
		            document.getElementById("result4").innerHTML = "아이디는 6글자 이상 12글자 이하로 입력해주세요.";
		          
		            userIdInput.style.borderColor = "red";
		            userIdInput.focus();
		                       
		            
		        } else {        
		            document.getElementById("result4").innerHTML = "";      
		            userIdInput.style.borderColor = "";
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
								result = "사용 가능합니다"
							} else {
								result = "중복된 아이디입니다"
							}

							$("#result").html(result);
						},
						error : function(xhr, status) {
							console.log("status...", status);
						}
					});  
		        }
			
			
			return false;
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
		            $("#result6").html("올바른 이메일 형식이 아닙니다."); // 수정된 부분
		            return false; // 올바르지 않은 형식이므로 AJAX 요청을 보내지 않음
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
		<h3>회원가입</h3>

		<form action="u_insertOK.do" method="post"
			enctype="multipart/form-data">
			<table class="alt">
				<tr>
					<td><label for="user_id">아이디:</label></td>
					<td><input type="text" id="user_id" name="user_id" value=""
						placeholder="아이디" maxlength="12"> <span id="result"></span>
						<span id="result4"></span></td>
					<td width=150><a href="#" id="u_idCheck">아이디중복체크</a></td>
				</tr>
				<tr>
					<td><label for="password">비밀번호:</label></td>
					<td colspan="2"><input type="password" id="password"
						name="password" value="" placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td><label for="nickname">별명:</label></td>
					<td><input type="text" id="nickname" name="nickname" value=""
						placeholder="별명" maxlength="8"> <span id="result2"></span>
						<span id="result5"></span></td>
					<td width=150><a href="#" id="u_nicknameCheck">닉네임중복체크</a></td>
				</tr>
				<tr>
					<td><label for="email">이메일:</label></td>
					<td><input type="text" id="email" name="email" value=""
						placeholder="이메일"> <span id="result3"></span>
							<span id="result6"></span></td>
					<td width=150><a href="#" id="u_emailCheck">이메일중복체크</a></td>
				</tr>
				<tr>
					<td><label for="tel">전화번호:</label></td>
					<td colspan="2"><input type="tel" id="tel" name="tel"
						value="010" placeholder="전화번호"></td>
				</tr>
				<tr>
					<td><label for="birth">생년월일</label></td>
					<td colspan="2"><input type="date" id="birth" name="birth"
						value=""></td>
				</tr>
				<tr>
					<td><label for="gender">성별:</label></td>
					<td colspan="2"><input type="radio" id="gender_male" name="gender"
						value="남자" ${vo2.gender == '남자' ? 'checked' : ''}> <label
						for="남자">남자</label> <input type="radio" id="gender_female" name="gender"
						value="여자" ${vo2.gender == '여자' ? 'checked' : ''}> <label
						for="여자">여자</label> <input type="radio" id="gender_no" name="gender"
						value="비공개" ${vo2.gender == '비공개' ? 'checked' : ''}> <label
						for="비공개">비공개</label></td>
				</tr>


				<tr>
					<td colspan="3"><input type="submit" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
			<div id = "copyright">
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

       
        if (!allFieldsFilled) {
            alert("모든 필수 항목을 작성해주세요."); // 사용자에게 알림
            event.preventDefault(); 
        }
    });
</script>
</html>