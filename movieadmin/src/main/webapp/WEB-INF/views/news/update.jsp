<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뉴스 수정 페이지</title>
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
		<h2>뉴스 수정페이지</h2>
		<form action="n_updateOK.do" method="post"
			enctype="multipart/form-data">
			<div class="table-wrapper">
				<table class="alt">
					<tr>
						<td><label for="">항목</label></td>
						<td>입력</td>
					</tr>
					<tr>
						<td><label for="news_num">뉴스번호</label></td>
						<td>${param.news_num}<input type="hidden" id="news_num"
							name="news_num" value="${param.news_num}"></td>
					</tr>
					<tr>
						<td><label for="title">제목</label></td>
						<td><input type="text" id="title" name="title"
							value="${vo2.title}" placeholder="제목을 입력하세요"></td>
					</tr>
					<tr>
						<td><label for="content">내용</label></td>
						<td><textarea name="content" id="content" cols="30" rows="10">${vo2.content}</textarea></td>
					</tr>
					<tr>
						<td><label for="nickname">작성자:</label></td>
						<td>${param.nickname}<input type="hidden" id="nickname"
							name="nickname" value="${vo2.nickname}" placeholder="작성자"></td>
					</tr>
					<tr>
						<td><label for="file_img">이미지파일</label></td>
						<td><input type="file" id="file_img" name="file_img"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="글수정 완료"></td>
					</tr>
				</table>
			</div>
		</form>

	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>

</html>