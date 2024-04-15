<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
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

#Table td, #Table th {
	border: 1px solid #ddd;
	padding: 8px;
}

#Table tr:nth-child(even) {
	background-color: #ff6565;
}

#Table tr:hover {
	background-color: #fca2a2;
}

#Table th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}

tfoot td {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div>
		<h1>글목록</h1>
		<hr>
		<form action="b_searchList.do">
			<select name="searchKey">
				<option value="title">title</option>
				<option value="content">content</option>
			</select> <input type="text" name="searchWord" value="ja"> <input
				type="submit" value="search">

		</form>
		<table id="Table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th>댓글수</th>
					<th>좋아요</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos}">
					<tr>
						<td><a href="b_selectOne.do?board_num=${vo.board_num}&nickname=${vo.nickname}&title=${vo.title}&content=${vo.content}">${vo.board_num}</a></td>
						<td>${vo.title}</td>
						<td>${vo.nickname}</td>
						<td>${vo.wdate}</td>
						<td>${vo.commentscount}</td>
						<td>
							<form action="b_increaseGood.do" method="post">
								<input type="hidden" name="board_num" value="${vo.board_num}">
								<button type="submit">좋아요 ${vo.good}</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6"><c:forEach var="i" begin="1"
							end="${totalPageCount}">
							<c:if test="${param.searchKey == null}">
								<a href="b_selectAll.do?cpage=${i}">${i} &nbsp;</a>
							</c:if>
							<c:if test="${param.searchKey != null}">
								<a
									href="b_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i}
									&nbsp;</a>
							</c:if>
						</c:forEach></td>
				</tr>
			</tfoot>
		</table>
	<a href="b_insert.do">글쓰기</a>

	</div>
</body>
</html>