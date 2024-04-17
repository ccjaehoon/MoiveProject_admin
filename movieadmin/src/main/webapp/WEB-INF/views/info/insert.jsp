<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
input[type=text], textarea, select {
	width: 100%;
	padding: 8px 8px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ff8f8f;
	border-radius: 14px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 30%;
	background-color: #4CAF50;
	color: white;
	padding: 8px 8px;
	margin: 8px 0;
	border: none;
	border-radius: 14px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #b7e5b9;
}

div {
	border-radius: 15px;
	background-color: #f0f0f0;
	padding: 20px;
}

#insertTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#insertTable td {
	border: 1px solid #ddd;
	padding: 8px;
}

#insertTable tr:nth-child(even) {
	background-color: #ebebeb;
}

#insertTable tr:hover {
	background-color: #ffc6c6;
}
</style>
</head>

<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div>
		<h1>영화 작성페이지</h1>
		<form action="i_insertOK.do" method="post">
			<table id="insertTable">
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
					<td><label for="showTime">상영시간(분)</label></td>
					<td><input type="text" id="showTime" name="showTime"></td>
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
</body>

</html>