<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	border-radius: 5px;
	background-color: #bfbfbf;
}

#Table {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 80%;
}

#Table td {
	border: 1px solid #ddd;
	padding: 8px;
}

#Table tr:nth-child(even) {
	background-color: #ebebeb;
}

#Table tr:hover {
	background-color: #ffc6c6;
}
</style>
</head>

<body>

	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div>
		<h2>내 정보</h2>
		<hr>
		<table id="customers">

			<tr>
				<td>유저번호</td>
				<td>${vo2.user_num}</td>
			</tr>

			<tr>
				<td>아이디</td>
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






		</table>
	</div>
</body>

</html>