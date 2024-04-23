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
		<h2>즐겨찾기 목록</h2>
		<table class="alt">
			<thead>
				<tr>
					<th>영화 제목</th>
					<th>포스터</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${favorites}">
					<tr>
						<td align = "center"><a href="i_selectOne.do?info_num=${vo.info_num}">${vo.title}</a></td>
						<td> <img src="resources/uploadimg/${vo.save_img}" width="150"></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>

	</div>
</body>

</html>