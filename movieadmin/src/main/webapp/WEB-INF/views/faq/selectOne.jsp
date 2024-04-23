<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
</head>
<body>
	<div id="main">
		<jsp:include page="../top_menu.jsp"></jsp:include>
		<h1>FAQ</h1>
		<hr>
		<div class="table-wrapper">
			<table id="alt">
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



					<c:if test="${authority == 'admin'}">
						<td colspan="4" align="right"><a
							href="f_update.do?faq_num=${param.faq_num}&content=${param.content}">FAQ수정</a>
							<a href="f_delete.do?faq_num=${param.faq_num}">FAQ삭제</a></td>
					</c:if>
				</tbody>

			</table>
		</div>
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>
</html>