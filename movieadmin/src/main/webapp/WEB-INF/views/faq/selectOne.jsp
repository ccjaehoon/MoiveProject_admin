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
#faq {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#faq td, #faq th {
	border: 1px solid #ddd;
	padding: 8px;
}

#faqR{
	background-color: #ff6565;
}

#faq tr:hover {
	background-color: #fca2a2;
}

#faq th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}

tfoot td {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h1>FAQ</h1>
	<hr>
	<table id="faq">
	<tbody>
		
			
				<tr>
					<td id="faqR">번호</td>
					<td>${vo2.faq_num}</td>
					<td id="faqR">작성자</td>
					<td>${vo2.nickname}</td>
				</tr>

				<tr>
					<td id="faqR">제목</td>
					<td colspan="3">${vo2.title}</td>

				</tr>
				<tr>
					<td id="faqR">내용</td>
					<td colspan="3">${vo2.content}</td>

				</tr>
			
		
		</tbody>
	</table>
	<a href="f_update.do?faq_num=${param.faq_num}">FAQ수정</a>
	<a href="f_delete.do?faq_num=${param.faq_num}">FAQ삭제</a>
</body>
</html>