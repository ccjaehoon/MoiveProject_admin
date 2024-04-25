<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뉴스 목록 페이지</title>
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
		<h2>news</h2>

		<form action="n_searchList.do">
			<select name="searchKey">
				<option value="title">title</option>
				<option value="content">content</option>
			</select> <input type="text" name="searchWord" value="title"> <input
				type="submit" value="search">

		</form>
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<th style="width: 4%; text-align: center;">번호</th>
					<th style="width: 8%; text-align: center;">썸네일</th>
					<th style="width: 40%; text-align: center;">제목</th>		
					<th style="width: 15%; text-align: center;">작성자</th>
					<th style="width: 15%; text-align: center;">작성일자</th>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${vos}">
						<tr>
							<td style="text-align: center; vertical-align: middle;"><a
								href="n_selectOne.do?news_num=${vo.news_num}&nickname=${vo.nickname}">${vo.news_num}</a>
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
						<td colspan="6" align="center"><c:forEach var="i" begin="1"
								end="${totalPageCount}">
								<c:if test="${param.searchKey == null }">
									<a href="n_selectAll.do?cpage=${i}">${i} &nbsp;</a>
								</c:if>
								<c:if test="${param.searchKey != null }">
									<a
										href="n_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i}
										&nbsp;</a>
								</c:if>
							</c:forEach></td>
					</tr>
				</tfoot>
			</table>
		</div>
		<c:if test="${authority == 'admin' }">
			<a href="n_insert.do">뉴스 작성</a>
		</c:if>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>
</html>