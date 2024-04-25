<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 <div style="position: relative; z-index: 2;">
    <jsp:include page="../top_menu.jsp"></jsp:include>
</div>
<div id="main" style="position: relative; z-index: 1;">
<br>
		<h2>로그인</h2>
		<form id="loginForm" action="u_loginOK.do" method="post"
			enctype="multipart/form-data">
			<table class="alt">
				<tr>
					<td><label for="user_id">id:</label></td>
					<td><input type="text" id="user_id" name="user_id"
						value="admin" placeholder="아이디"></td>
				</tr>
				<tr>
					<td><label for="password">password:</label></td>
					<td><input type="password" id="password" name="password"
						value="hi1234" placeholder="비밀번호"></td>
				</tr>	
				
				<tr>
				
					<td colspan="2" align = "right"><input type="submit" value="login">			
					<c:if test="${param.message == 0 }">
		              		아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.
                		</c:if>
                		
					</td>
				</tr>
				<tr>
				<td colspan = "2" align = "center"><a  href="u_insert.do">회원가입</a>
				
				</td>
				</tr>
				
			</table>
		</form>
	</div>
			<div id = "copyright">
<jsp:include page="../footer_menu.jsp"></jsp:include></div>
</body>
</html>
