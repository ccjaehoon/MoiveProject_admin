<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
input[type=text], input[type=password], input[type=tel], select {
	width: 100%;
	padding: 8px 8px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ff8f8f;
	border-radius: 14px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 30%;
	background-color: #4CAF50;
	color: white;
	padding: 8px 8px;
	margin: 8px 0;
	border: none;
	border-radius: 14px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 15px;
	background-color: #bfbfbf;
	padding: 20px;
}

#memberTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#memberTable td {
	border: 1px solid #ddd;
	padding: 8px;
}

#memberTable tr:nth-child(even) {
	background-color: #ebebeb;
}

#memberTable tr:hover {
	background-color: #ffc6c6;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#u_idCheck").click(function() {
			console.log("click...");
			console.log("user_id:", $("#user_id").val());

			$.ajax({
				url : "http://localhost:8070/movie/u_idCheck.do",
				type : "get",
				data : {
					user_id : $("#user_id").val()
				},
				dataType : "json",
				success : function(obj) {
					console.log(obj);
					let result = '';
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

			return false;
		});

		$("#u_nicknameCheck").click(function() {
			console.log("click...");
			console.log("nickname:", $("#nickname").val());

			$.ajax({
				url : "http://localhost:8070/movie/u_nicknameCheck.do",
				type : "get",
				data : {
					nickname : $("#nickname").val()
				},
				dataType : "json",
				success : function(obj) {
					console.log(obj);
					let result = '';
					if (obj.result == "OK") {
						result = "사용 가능합니다"
					} else {
						result = "중복된 닉네임입니다"
					}

					$("#result2").html(result); // 변경된 부분
				},
				error : function(xhr, status) {
					console.log("status...", status);
				}
			});

			return false;
		});

		$("#u_emailCheck").click(function() {
			console.log("click...");
			console.log("email:", $("#email").val());

			$.ajax({
				url : "http://localhost:8070/movie/u_emailCheck.do",
				type : "get",
				data : {
					email : $("#email").val()
				},
				dataType : "json",
				success : function(obj) {
					console.log(obj);
					let result = '';
					if (obj.result == "OK") {
						result = "사용 가능합니다"
					} else {
						result = "중복된 이메일입니다"
					}

					$("#result3").html(result); // 변경된 부분
				},
				error : function(xhr, status) {
					console.log("status...", status);
				}
			});

			return false;
		});
	});
</script>

</head>

<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div>
		<h3>회원가입폼</h3>

		<form action="u_insertOK.do" method="post"
			enctype="multipart/form-data">
			<table id="memberTable">
				<tr>
					<td><label for="user_id">아이디:</label></td>
					<td><input type="text" id="user_id" name="user_id" value=""
						placeholder="아이디"> <a href="#" id="u_idCheck">아이디중복체크</a>
						<span id="result"></span>
						<span id="result2"></span></td>
				</tr>
				<tr>
					<td><label for="password">비밀번호:</label></td>
					<td><input type="password" id="password" name="password"
						value="" placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td><label for="nickname">별명:</label></td>
					<td><input type="text" id="nickname" name="nickname" value=""
						placeholder="별명"> <a href="#" id="u_nicknameCheck">닉네임중복체크</a>
						<span id="result2"></span></td>
				</tr>
				<tr>
					<td><label for="email">이메일:</label></td>
					<td><input type="text" id="email" name="email" value=""
						placeholder="이메일"> <a href="#" id="u_emailCheck">이메일중복체크</a>
						<span id="result3"></span></td>
				</tr>
				<tr>
					<td><label for="tel">전화번호:</label></td>
					<td><input type="tel" id="tel" name="tel" value="010"
						placeholder="전화번호"></td>
				</tr>
				<tr>
					<td><label for="birth">생년월일</label></td>
					<td><input type="date" id="birth" name="birth" value=""></td>
				</tr>
				<tr>
					<td><label for="gender">성별:</label></td>
					<td><input type="radio" id="남자" name="gender" value="남자"
						${vo2.gender == '남자' ? 'checked' : ''}> <label for="남자">남자</label>
						<input type="radio" id="여자" name="gender" value="여자"
						${vo2.gender == '여자' ? 'checked' : ''}> <label for="여자">여자</label>
						<input type="radio" id="비공개" name="gender" value="비공개"
						${vo2.gender == '비공개' ? 'checked' : ''}> <label for="비공개">비공개</label>
					</td>
				</tr>


				<tr>
					<td colspan="2"><input type="submit" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script>
  
    var minLength = 6;
    var maxLength = 12;

  
    var userIdInput = document.getElementById("user_id");


    userIdInput.addEventListener("blur", function() {
    
        var userInputLength = userIdInput.value.length;
        if (userInputLength < minLength || userInputLength > maxLength) {
         
            document.getElementById("result2").innerHTML = "아이디는 6글자 이상 12글자 이하로 입력해주세요.";
          
            userIdInput.style.borderColor = "red";
            userIdInput.focus();
        } else {        
            document.getElementById("result2").innerHTML = "";      
            userIdInput.style.borderColor = "";
        }
    });
</script>
</html>