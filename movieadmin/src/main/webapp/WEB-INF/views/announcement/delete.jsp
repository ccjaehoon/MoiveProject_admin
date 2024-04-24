<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css" />
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
        <h3>게시글 삭제하기</h3>
  
        <form action="a_deleteOK.do" method="post">
            <table class="alt">
                <tr>
                    <td><label for="announcement_num">번호:</label></td>
                    <td>[${param.announcement_num}] 번 글을 정말 삭제하시겠습니까?
                    	<input type="hidden" id="announcement_num" name="announcement_num" value="${param.announcement_num}" placeholder="번호"></td>
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