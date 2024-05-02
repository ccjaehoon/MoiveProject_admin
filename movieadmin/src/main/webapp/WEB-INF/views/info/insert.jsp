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
	<div id = "main" style="position: relative; z-index: 1;">
	<br>
		<h2>영화 작성하기</h2>
		<form action="i_insertOK.do" method="post" enctype="multipart/form-data">
			<table class="alt">
				<tr>
					<td><label for="nickname">작성자:</label></td>
					<td>${nickname}<input type="hidden" id="nickname"
						name="nickname" value="${nickname}" placeholder="작성자"></td>
				</tr>
				<tr>
					<td><label for="title">제목</label></td>
					<td><input type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<td><label for="genre">장르</label></td>
					<td><input type="text" id="genre" name="genre"></td>
				</tr>
				<tr>
					<td><label for="directors">감독</label></td>
					<td><input type="text" id="directors" name="directors"></td>
				</tr>
				<tr>
					<td><label for="actor">배우</label></td>
					<td><input type="text" id="actor" name="actor"></td>
				</tr>
				<tr>
					<td><label for="releaseDate">개봉일</label></td>
					<td colspan="2"><input type="date" id="releaseDate" name="releaseDate"
						value=""></td>
				</tr>
				<tr>
					<td><label for="showtime">상영시간(분)</label></td>
					<td><input type="text" id="showtime" name="showtime"></td>
				</tr>
				<tr>
					<td><label for="content">내용</label></td>
					<td><textarea name="content" id="content" cols="30" rows="10"></textarea></td>
				</tr>
				<tr>
					<td><label for="file_img">이미지파일</label></td>
					<td><input type="file" id="file_img" name="file_img"></td>
				</tr>
				<tr>
					<td><label for="watchGrade">시청등급</label></td>
					<td><input type="text" id="watchGrade" name="watchGrade"></td>
				</tr>
				<tr>
					<td><label for="companys">제작사</label></td>
					<td><input type="text" id="companys" name="companys"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="영화 등록"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>

</html>