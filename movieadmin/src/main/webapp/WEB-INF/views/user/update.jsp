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

</head>
<body>
	<div style="position: relative; z-index: 2;">
    <jsp:include page="../top_menu.jsp"></jsp:include>
</div>
<div id="main" style="position: relative; z-index: 1;">
<br>
		<h3>회원정보 수정하기</h3>

		<form action="u_updateOK.do" method="post"
			enctype="multipart/form-data">
			<table class="alt">		
				<tr>
					<td><label for="user_id">아이디:</label></td>
					<td>${param.user_id}<input type="hidden" id="user_id"
						name="user_id" value="${param.user_id}" placeholder="아이디"></td>
				</tr>
				<tr>
					<td><label for="password">비밀번호:</label></td>
					<td><input type="password" id="password" name="password"
						value="${vo2.password}" placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td><label for="nickname">별명:</label></td>
					<td><input type="text" id="nickname" name="nickname"
						value="${vo2.nickname}" placeholder="이름"></td>
				</tr>
				<tr>
					<td><label for="email">이메일:</label></td>
					<td><input type="text" id="email" name="email"
						value="${vo2.email}" placeholder="이메일"></td>
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
					<td><label for="tel">전화번호:</label></td>
					<td><input type="tel" id="tel" name="tel" value="${vo2.tel}"
						placeholder="전화번호"></td>
				</tr>


				<tr>
					<td colspan="2"><input type="submit" value="회원수정"></td>
				</tr>
			</table>
		</form>
	</div>
	    <div id = "copyright">
<jsp:include page="../footer_menu.jsp"></jsp:include></div>
</body>

</html>