<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

</head>

<body >



<div id="main">
	<jsp:include page="../top_menu.jsp"></jsp:include>

		<h2>공지사항</h2>

		<form action="a_searchList.do">
			<span style="float: left"><select name="searchKey" style="width: 150px;">
					<option value="title">title</option>
					<option value="content">content</option>
			</select></span><span style="float: left"> <input type="text"
				name="searchWord" value="검색어" style="width: 150px;">
			</span> <input type="submit" value="search">

		</form>

		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성날짜</th>

						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${vos}">
						<tr>
							<td width=200px><a
								href="a_selectOne.do?announcement_num=${vo.announcement_num}&nickname=${vo.nickname}">${vo.announcement_num}</a></td>
							<td>${vo.title}</td>
							<td>${vo.nickname}</td>
							<td>${vo.wdate}</td>
						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="5" style="text-align: center;"><c:forEach
								var="i" begin="1" end="${totalPageCount}">
								<c:if test="${param.searchKey == null }">
									<a href="a_selectAll.do?cpage=${i}">${i} &nbsp;</a>
								</c:if>
								<c:if test="${param.searchKey != null }">
									<a
										href="a_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i}
										&nbsp;</a>
								</c:if>
							</c:forEach></td>
					</tr>
				</tfoot>
			</table>
		</div>
		<c:if test="${authority == 'admin' }">
			<form action="a_insert.do">
				<input type="submit" value="announcement 작성">
			</form>
		</c:if>
</div>
<br>
<div id = "footer">
<jsp:include page="../footer_menu.jsp"></jsp:include>
</div>

	

</body>

</html>