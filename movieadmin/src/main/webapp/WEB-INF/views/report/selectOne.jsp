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
<div id = main>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>신고정보</h2>
	<table class="alt">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>신고내용</th>
				<th>신고번호(게시판,댓글,스토리,스토리댓글,뉴스,뉴스댓글,정보,리뷰)</th>
				
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${vo2.report_num}</td>
				<td>${vo2.nickname}</td>
				<td>${vo2.content}</td>
				<td>${vo2.board_num},${vo2.comments_num},${vo2.story_num},${vo2.story_comments_num},${vo2.news_num},${vo2.news_comments_num},${vo2.info_num},${vo2.review_num}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${vo2.content}</td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td colspan="3">${vo2.wdate}</td>
			</tr>
			<form action="rp_go.do">
			<tr>
				<input type="hidden" name="report_num" value="${vo2.report_num}">
				<td colspan="4"><input type="submit" value="글로 이동"></td>

				
			</tr>
			</form>
		</tbody>
	</table>



</div>
</body>
</html>