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
<body>
	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>
		<h2>회원목록</h2>
		<form action="u_searchList.do">
			<span style="float: left"><select name="searchKey"
				style="width: 150px;">
					<option value="user_id">아이디</option>
					<option value="nickname">닉네임</option>
			</select></span><span style="float: left"> <input type="text"
				name="searchWord" value="검색어" style="width: 150px;"></span> <input
				type="submit" value="search">

		</form>
		<table class="alt">
			<thead>
				<tr>
					<th style="width: 5%; text-align: center;">번호</th>
					<th style="width: 15%; text-align: center;">아이디</th>
					<th style="width: 15%; text-align: center;">비밀번호</th>
					<th style="width: 15%; text-align: center;">이름</th>
					<th style="width: 15%; text-align: center;">전화번호</th>
					<th style="width: 7%; text-align: center;">직위</th>
					<th style="width: 30%; text-align: center;">가입날짜</th>

					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos}">
					<tr>
						<td style="text-align: center;"><a
							href="u_selectOne.do?user_num=${vo.user_num}&user_id=${vo.user_id}">${vo.user_num}</a></td>
						<td style="text-align: center;">${vo.user_id}</td>
						<td style="text-align: center;">${vo.password}</td>
						<td style="text-align: center;">${vo.nickname}</td>
						<td style="text-align: center;">${vo.tel}</td>
						<td style="text-align: center;">${vo.authority}</td>
						<td style="text-align: center;">${vo.reg_date}</td>
					</tr>

				</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="7" align="center"><c:forEach var="i" begin="1"
							end="${totalPageCount}">
							<c:if test="${param.searchKey == null }">
								<a href="u_selectAll.do?cpage=${i}">${i} &nbsp;</a>
							</c:if>
							<c:if test="${param.searchKey != null }">
								<a
									href="u_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i}
									&nbsp;</a>
							</c:if>
						</c:forEach></td>
				</tr>
			</tfoot>
		</table>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include></div>
</body>
</html>