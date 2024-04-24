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
	<div style="position: relative; z-index: 2;">
    	<jsp:include page="../top_menu.jsp"></jsp:include>
    </div>
    <div id="main" style="position: relative; z-index: 1;">
	    <br>
	    <h2>게시글 수정</h2>
	    <form action="b_updateOK.do" method="post">
	   		<div class="table=wrapper">
	            <table id=alt>
	                <tr>
	                    <td><label for="board_num">글번호</label></td>
	                    <td>${vo2.board_num}<input type="hidden" id="board_num" name="board_num" value="${param.board_num}"></td>
	                </tr>
	                <tr>
	                    <td><label for="title">제목</label></td>
	                    <td><input type="text" id="title" name="title" value="${vo2.title}" ></td>
	                </tr>
	                <tr>
	                    <td><label for="content">내용</label></td>
	                    <td><textarea name="content" id="content" cols="30" rows="10">${vo2.content}</textarea></td>
	                </tr>
	               	<tr>
						<td><label for="nickname">작성자</label></td>
						<td>${vo2.nickname}<input type="hidden" id="nickname" name="nickname"
							value="${vo2.nickname}" placeholder="작성자"></td>
					</tr>
	                <tr>
	                    <td colspan="2"><input type="submit" value="글수정 완료"></td>
	                </tr>
	            </table>
	        </div>
		</form>
		<jsp:include page="../footer_menu.jsp"></jsp:include>
 	</div>
	<br>
	<br>
	<br>
</body>

</html>