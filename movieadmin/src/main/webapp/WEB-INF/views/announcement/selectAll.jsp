<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
		<h2>공지사항</h2>

	<form action="a_searchList.do">
			<span style="float: left"> <select name="searchKey"
				style="width: 150px;">
					<option value="title">title</option>
					<option value="content">content</option>
			</select>
			</span><span style="float: left"> <input type="text"
				name="searchWord" value="검색어" style="width: 150px;">
			</span><input type="submit" value="search">
		

		</form>
	
		<table class="alt">

			<thead>
				<tr>
					<th style="width: 7%; text-align: center;">번호</th>
					<th style="width: 10%; text-align: center;">썸네일</th>
					<th style="width: 35%; text-align: center;">제목</th>
					<th style="width: 15%; text-align: center;">작성자</th>
					<th style="width: 15%; text-align: center;">작성일자</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos}">
						<tr>
							<td style="text-align: center; vertical-align: middle;"><a
								href="a_selectOne.do?announcement_num=${vo.announcement_num}&nickname=${vo.nickname}">${vo.announcement_num}</a>
							</td>
							<td style="text-align: center; vertical-align: middle;"><img
								alt="" src="resources/uploadimg/${vo.save_img}"
								style="width: 70%; display: block; margin: 0 auto;"></td>
							<td style="text-align: left; vertical-align: middle;">${vo.title}</td>
							<td style="text-align: center; vertical-align: middle;">${vo.nickname}</td>
							<td style="text-align: center; vertical-align: middle;"><fmt:formatDate
									value="${vo.wdate}" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="5" style="text-align: center;"><c:forEach var="i"
							begin="1" end="${totalPageCount}">
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
		<c:if test="${authority == 'admin' }">
			<form action="a_insert.do">
				<input type="submit" value="announcement 작성">
			</form>
		</c:if>


	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include></div>






</body>

</html>