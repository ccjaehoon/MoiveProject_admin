<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 변경</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/noscript.css" />
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
        <h2>비밀번호 변경</h2>
        <form id="pwChangeForm" action="changePassword.do" method="post">
            <table class="alt">
                <tr>
                    <td><label for="user_id">아이디</label></td>
                    <td><input type="hidden" id="user_id" name="user_id" value="${user_id}" placeholder="아이디">${user_id}</td>
                </tr>
                <tr>
                    <td><label for="password">현재 비밀번호</label></td>
                    <td><input type="password" id="password" name="password" placeholder="현재 비밀번호"></td>
                </tr>
                <tr>
                    <td><label for="new_password">새 비밀번호</label></td>
                    <td><input type="password" id="new_password" name="new_password" placeholder="새 비밀번호"></td>
                </tr>
                <tr>
                    <td><label for="confirm_password">비밀번호 확인</label></td>
                    <td><input type="password" id="confirm_password" name="confirm_password" placeholder="비밀번호 확인"></td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><input type="submit" value="비밀번호 변경"></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="copyright">
        <jsp:include page="../footer_menu.jsp"></jsp:include>
    </div>
</body>
</html>
