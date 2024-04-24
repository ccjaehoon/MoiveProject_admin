<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<h2>내 정보</h2>
		<table class="alt">


			<tr>
				<td width=300px;>아이디</td>
				<td>${vo2.user_id}</td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td>${vo2.password}</td>
			</tr>

			<tr>
				<td>별명</td>
				<td>${vo2.nickname}</td>
			</tr>

			<tr>
				<td>이메일</td>
				<td>${vo2.email}</td>
			</tr>

			<tr>
				<td>전화번호</td>
				<td>${vo2.tel}</td>
			</tr>

			<tr>
				<td>생일</td>
				<td>${vo2.birth}</td>
			</tr>

			<tr>
				<td>권위</td>
				<td>${vo2.authority}</td>
			</tr>

			<tr>
				<td>회원가입날짜</td>
				<td>${vo2.reg_date}</td>
			</tr>

			<tr>
				<td colspan="2" align="center"><a
					href="u_update.do?user_num=${vo2.user_num}&user_id=${vo2.user_id}">회원수정</a></td>
			</tr>


		</table>

	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>

</html>