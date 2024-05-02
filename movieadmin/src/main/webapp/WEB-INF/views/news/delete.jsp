<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
</head>

<body class="is-preload">
	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id=main style="position: relative; z-index: 1;">
		<br>
		<h2>뉴스 삭제하기</h2>

		<!-- <form action="#" method="post" enctype="multipart/form-data"> -->
		<form action="n_deleteOK.do" method="post">
			<table id="boardTable">
				<tr>
					<td><label for="news_num">번호:</label></td>
					<td>[${param.news_num}] 번 뉴스를 정말 삭제하시겠습니까? <input
						type="hidden" id="news_num" name="news_num"
						value="${param.news_num}" placeholder="번호"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="글삭제"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>

</html>