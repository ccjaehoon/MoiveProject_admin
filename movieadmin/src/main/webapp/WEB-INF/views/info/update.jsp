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
    <div style="position: relative; z-index: 2;">
        <h1>영화정보 수정페이지</h1>
        <form action="i_updateOK.do" method="post" enctype="multipart/form-data">
			<table id="updateTable">
                <tr>
                    <td><label for="">항목</label></td>
                    <td>입력</td>
                </tr>
                <tr>
                    <td><label for="info_num">뉴스번호</label></td>
                    <td>${param.info_num}<input type="hidden" id="info_num" name="info_num" value="${param.info_num}"></td>
                </tr>
                <tr>
					<td><label for="nickname">작성자:</label></td>
					<td>${vo2.nickname}<input type="hidden" id="nickname" name="nickname"
						value="${vo2.nickname}" placeholder="작성자"></td>
				</tr>
				<tr>
					<td><label for="title">제목</label></td>
					<td><input type="text" id="title" name="title" value="${vo2.title}"></td>
				</tr>
				
				<tr>
					<td><label for="genre">장르</label></td>
					<td><input type="text" id="genre" name="genre" value="${vo2.genre}"></td>
				</tr>
				<tr>
					<td><label for="directors">감독</label></td>
					<td><input type="text" id="directors" name="directors" value="${vo2.directors}"></td>
				</tr>
				<tr>
					<td><label for="actor">배우</label></td>
					<td><input type="text" id="actor" name="actor" value="${vo2.actor}"></td>
				</tr>
				<tr>
					<td><label for="releaseDate">개봉일</label></td>
					<td colspan="2"><input type="date" id="releaseDate" name="releaseDate"
						value="${vo2.releaseDate}"></td>
				</tr>
				<tr>
					<td><label for="showtime">상영시간(분)</label></td>
					<td><input type="text" id="showtime" name="showtime" value="${vo2.showtime}"></td>
				</tr>
				<tr>
					<td><label for="content">내용</label></td>
					<td><textarea name="content" id="content" cols="30" rows="10">${vo2.content}</textarea></td>
				</tr>
				<tr>
					<td><label for="file_img">이미지파일</label></td>
					<td><input type="file" id="file_img" name="file_img"></td>
				</tr>
				<tr>
					<td><label for="views"></label></td>
					<td><input type="hidden" id="views" name="views" value="${vo2.views}"></td>
				</tr>
				<tr>
					<td><label for="watchGrade">시청등급</label></td>
					<td><input type="text" id="watchGrade" name="watchGrade" value="${vo2.watchGrade}"></td>
				</tr>
				<tr>
					<td><label for="companys">제작사</label></td>
					<td><input type="text" id="companys" name="companys" value="${vo2.companys}"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="영화 등록"></td>
				</tr>
			</table>
		</form>
    </div>
</body>

</html>