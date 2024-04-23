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
	<div id="main">
		<jsp:include page="../top_menu.jsp"></jsp:include>
		<h1>회원목록</h1>
		<hr>
		<form action="u_searchList.do">
			<span style="float: left"><select name="searchKey" style="width: 150px;">
				<option value="user_id">아이디</option>
				<option value="nickname">닉네임</option>
			</select></span><span style="float: left"> <input type="text" name="searchWord" value="검색어" style="width: 150px;"></span> <input
				type="submit" value="search">

		</form>
		<table class="alt">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>직위</th>
					<th>가입날짜</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos}">
					<tr>
						<td><a
							href="u_selectOne.do?user_num=${vo.user_num}&user_id=${vo.user_id}">${vo.user_num}</a></td>
						<td>${vo.user_id}</td>
						<td>${vo.password}</td>
						<td>${vo.nickname}</td>
						<td>${vo.tel}</td>
						<td>${vo.authority}</td>
						<td>${vo.reg_date}</td>					
					</tr>
				</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="7"><c:forEach var="i" begin="1"
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
</body>
</html>