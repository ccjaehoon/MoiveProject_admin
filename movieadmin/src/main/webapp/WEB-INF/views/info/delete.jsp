<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/noscript.css" />
</head>

<body>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <div id="main" style="position: relative; z-index: 1;">
        <h3>영화 삭제</h3>

        <!-- <form action="#" method="post" enctype="multipart/form-data"> -->
        <form action="b_deleteOK.do" method="post">
            <table id="boardTable">
                <tr>
                    <td><label for="num">번호:</label></td>
                    <td>[${param.num}] 번 영화를 정말 삭제하시겠습니까?
                    	<input type="hidden" id="num" name="num" value="${param.num}" placeholder="번호"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="영화삭제"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>