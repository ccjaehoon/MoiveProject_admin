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
body {
	margin: 0;
	padding: 0;
	display: flex;
	min-height: 20vh;
	flex-direction: column;
}

main {
	flex: 1;
}

footer {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 20px;
	position: fixed;
	bottom: 0;
	left: 50%;
	transform: translateX(-50%);
	width: 100%;
	height: 20px;
}

footer a {
	color: #fff;
	margin: 0 10px;
	text-decoration: none;
}
</style>
</head>
<body>

	<footer>
		<a href="about_us.do">이용약관</a> <a href="contact.do">개인정보처리방침</a><a href="f_selectAll.do?nickname">고객센터</a> <a href="advertisement.do">광고임대문의</a>
	</footer>
</body>
</html>
