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
#announcement {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#announcement td, #announcement th {
	border: 1px solid #ddd;
	padding: 8px;
}

#announcementR{
	background-color: #ff6565;
}

#announcement tr:hover {
	background-color: #fca2a2;
}

#announcement th {
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
	<h1>announcement</h1>
	<hr>
	<table id="announcement">
	<tbody>
		
			
				<tr>
					<td id="announcementR">번호</td>
					<td>${vo2.announcement_num}</td>
					<td id="announcementR">작성자</td>
					<td>${vo2.nickname}</td>
				</tr>

				<tr>
					<td id="announcementR">제목</td>
					<td colspan="3">${vo2.title}</td>

				</tr>
				<tr>
					<td id="announcementR">내용</td>
					<td colspan="3">${vo2.content}</td>

				</tr>
			
		
		</tbody>
	</table>
	<a href="a_update.do?announcement_num=${param.announcement_num}&nickname=${param.nickname}&title=${param.title}&content=${param.content}">공지사항 수정</a>
	<a href="a_delete.do?announcement_num=${param.announcement_num}">공지사항 삭제</a>
</body>
</html>