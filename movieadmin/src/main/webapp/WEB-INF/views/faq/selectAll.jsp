<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
input[type=text], input[type=password], input[type=tel], select {
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
	background-color: #45a049;
}

div {
	border-radius: 15px;
	background-color: #bfbfbf;
	padding: 20px;
}

#Table {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#Table td {
	border: 1px solid #ddd;
	padding: 8px;
}

#Table tr:nth-child(even) {
	background-color: #ebebeb;
}

#Table tr:hover {
	background-color: #ffc6c6;
}
</style>
</head>

<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div>

		<h2>FAQ</h2>
		<form action="f_searchList.do">
			<select name="searchKey">
				<option value="title">title</option>
				<option value="content">content</option>
			</select> <input type="text" name="searchWord" value="ja"> <input
				type="submit" value="search">
		</form>
		<table id="Table">
			<tr>
				<td width=200px>번호</td>
				<td>제목</td>
			</tr>
			<tr>
				<td>${vo.faq_num}</td>
				<td>${vo.title}</td>
			</tr>
		</table>
		<button><a href="f_insert.do">글쓰기</a></button>

	</div>
</body>

</html>