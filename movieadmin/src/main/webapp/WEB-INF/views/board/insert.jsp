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

</head>
<body>
	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>
		<h2>게시글 작성페이지</h2>
		<form id="boardForm" action="b_insertOK.do" method="post"
			enctype="multipart/form-data">
			<div class="table-wrapper">
				<table id="alt">
					<tr>
						<td><label for="title">제목</label></td>
						<td><input type="text" id="title" name="title" placeholder="제목을 입력하세요"></td>
					</tr>
					<tr>
						<td><label for="content">내용</label></td>
						<td><textarea name="content" id="content" cols="30" rows="10"  placeholder="내용을 적으세요"></textarea></td>
					</tr>
					<tr>
						<td><label for="nickname">작성자</label></td>
						<td>${nickname}<input type="hidden" id="nickname" name="nickname" value="${nickname}"></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="3"><fmt:formatDate value="${vo2.wdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
					<tr>
						<td><label for="file_img">이미지파일</label></td>
						<td><input type="file" id="file_img" name="file_img"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="글쓰기 완료"></td>
					</tr>
				</table>
			</div>
		</form>
		<div id="copyright">
			<jsp:include page="../footer_menu.jsp"></jsp:include>
		</div>
	</div>

</body>

</html>