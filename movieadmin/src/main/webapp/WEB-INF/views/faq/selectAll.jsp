<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<body class="is-preload">


	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>
		<h2>FAQ</h2>

		<form action="f_searchList.do">
			<span style="float: left"> <select name="searchKey"
				style="width: 150px;">
					<option value="title">제목</option>
					<option value="content">내용</option>
			</select>
			</span><span style="float: left"> <input type="text"
				name="searchWord" value="검색어" style="width: 150px;">
			</span><input type="submit" value="search">

		</form>

		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${vos}">
						<tr>
							<td width=200px><a
								href="f_selectOne.do?faq_num=${vo.faq_num}&nickname=${vo.nickname}">${vo.faq_num}</a></td>
							<td>${vo.title}</td>
							<td>${vo.nickname}</td>

						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="3" align="center"><c:forEach var="i" begin="1"
								end="${totalPageCount}">
								<c:if test="${param.searchKey == null }">
									<a href="f_selectAll.do?cpage=${i}">${i} &nbsp;</a>
								</c:if>
								<c:if test="${param.searchKey != null }">
									<a
										href="f_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i}
										&nbsp;</a>
								</c:if>
							</c:forEach></td>
					</tr>
				</tfoot>
			</table>
		</div>
		<c:if test="${authority == 'admin' }">
			<form action="f_insert.do">
				<input type="submit" value="FAQ 작성">
			</form>
		</c:if>

	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>

</body>

</html>