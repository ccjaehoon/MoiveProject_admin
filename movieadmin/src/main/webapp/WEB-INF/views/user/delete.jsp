<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div id = "main">
		<h3>회원 삭제하기</h3>

		<!-- <form action="#" method="post" enctype="multipart/form-data"> -->
		<form action="u_deleteOK.do" method="post">
			
			<table id="memberTable">
				<tr>
					<td><label for="user_num">번호:</label></td>
					<td>[${param.user_num}] 번 회원을 정말 삭제하시겠습니까? <input type="hidden"
						id="user_num" name="user_num" value="${param.user_num}" placeholder="번호"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="회원삭제"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>