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
	 <script type="text/javascript">



	var msg = "${msg}";
		 
		if (msg != "") {
			alert(msg);
		}


</script>
	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>
		<h2>비밀번호 찾기</h2>
		<form id="pwForm" action="u_findPw.do" method="post">
			<table class="alt">
				<tr>
					<td><label for="user_id">id:</label></td>
					<td><input type="text" id="user_id" name="user_id"
						value="admin" placeholder="아이디"></td>
				</tr>
				<tr>
					<td><label for="email">email:</label></td>
					<td><input type="email" id="email" name="email"
						value="" placeholder="이메일"></td>
				</tr>

				<tr>

					<td colspan="2" align="right"><input type="submit"
						value="이메일 전송"></td>
				</tr>


			</table>
		</form>
		<table>
			<tr>
				<td colspan="2" align="center">
				<form action="u_insert.do">
				<input type="submit" value="회원 가입">
			</form>
				</td>
			</tr>
		</table>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include></div>
</body>
</html>
