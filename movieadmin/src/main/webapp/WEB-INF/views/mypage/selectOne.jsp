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
			<thead>
				<tr>
					<th>유저번호</th>
				</tr>

				<tr>
					<th>아이디</th>
				</tr>

				<tr>
					<th>비밀번호</th>
				</tr>

				<tr>
					<th>별명</th>
				</tr>

				<tr>
					<th>이메일</th>
				</tr>

				<tr>
					<th>전화번호</th>
				</tr>

				<tr>
					<th>생일</th>
				</tr>

				<tr>
					<th>권위</th>
				</tr>

				<tr>
					<th>회원가입날짜</th>
				</tr>


			</thead>

			<tbody>
				<tr>
					<td>${vo2.user_num}</td>
					<td>${vo2.user_id}</td>
					<td>${vo2.password}</td>
					<td>${vo2.nickname}</td>
					<td>${vo2.email}</td>
					<td>${vo2.tel}</td>
					<td>${vo2.birth}</td>
					<td>${vo2.authority}</td>
					<td>${vo2.reg_date}</td>

				</tr>
			</tbody>
		</table>
	</div>
</body>

</html>