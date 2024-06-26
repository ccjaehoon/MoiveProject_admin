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
<body>
	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>
		<h2>영화목록</h2>
		<form action="i_searchList.do">

			<span style="float: left"> <select name="searchKey" style="width: 150px;">
				<option value="title">제목</option>
				<option value="genre">장르</option>
				<option value="actor">배우</option>
			</select></span><span style="float: left">  <input type="text" name="searchWord" value="검색어" style="width: 150px;"></span> <input
				type="submit" value="search">
		</form>

		<table id="customers">
			<thead>
				<tr>
					<th style="width: 10%; text-align: center;">포스터</th>
					<th style="width: 90%; text-align: center;">제목 및 줄거리</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="vo" items="${vos}">
					<tr>						
						<td style="align:center"><a href="i_selectOne.do?info_num=${vo.info_num}"><img src="resources/uploadimg/${vo.save_img}" width="200"></a></td>
						<td style="vertical-align: middle;"><a href="i_selectOne.do?info_num=${vo.info_num}">${vo.title}</a><br><br>${vo.content}</td>
					</tr>
				</c:forEach>


			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><c:forEach var="i" begin="1"
							end="${totalPageCount}">
							<c:if test="${param.searchKey == null }">
								<a href="i_selectAll.do?cpage=${i}">${i} &nbsp;</a>
							</c:if>
							<c:if test="${param.searchKey != null }">
								<a
									href="i_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i}
									&nbsp;</a>
							</c:if>
						</c:forEach></td>
				</tr>
			</tfoot>



		</table>
		<c:if test="${authority == 'admin' }">
			<form action="i_insert.do">
				<input type="submit" value="영화 작성">
			</form>
		</c:if>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>

</html>