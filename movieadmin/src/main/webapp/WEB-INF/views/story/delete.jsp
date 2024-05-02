<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div style="position: relative; z-index: 2;">
    <jsp:include page="../top_menu.jsp"></jsp:include>
</div>
<div id="main" style="position: relative; z-index: 1;">
<br>
        <h2>스토리 삭제하기</h2>
        <!-- <form action="#" method="post" enctype="multipart/form-data"> -->
        <form action="s_deleteOK.do" method="post">
            <table id="storyTable">
                <tr>
                    <td><label for="story_num">번호:</label></td>
                    <td>[${param.story_num}] 번 글을 정말 삭제하시겠습니까?
                    	<input type="hidden" id="story_num" name="story_num" value="${param.story_num}" placeholder="번호"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="글삭제"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>