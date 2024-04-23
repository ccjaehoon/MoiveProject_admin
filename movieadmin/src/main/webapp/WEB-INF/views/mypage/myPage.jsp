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

	
	<div id = "main">
	<jsp:include page="../top_menu.jsp"></jsp:include>
		<h2>MYPAGE</h2>
		<table class="alt">
			<tbody>
				<tr>
					<td>
						<form action="m_favorite.do">
							<input type="submit" value="즐겨찾기">

						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form action="m_selectOne.do">
							<input type="submit" value="내 정보">

						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form action="m_myPost.do">
							<input type="submit" value="쓴 글">

						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form action="m_myComments.do">
							<input type="submit" value="쓴 댓글">

						</form>
					</td>
				</tr>

			</tbody>
		</table>

	</div>
	<jsp:include page="../footer_menu.jsp"></jsp:include>
</body>

</html>