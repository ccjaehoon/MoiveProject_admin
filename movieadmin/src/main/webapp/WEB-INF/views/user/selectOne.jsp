<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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
		<h2>회원정보</h2>
		<hr>
		<table class="alt">
			<thead>
				<tr>
					<th style="width: 10%; text-align: center;">유저번호</th>
					<th style="width: 10%; text-align: center;">아이디</th>
					<th style="width: 10%; text-align: center;">비밀번호</th>
					<th style="width: 10%; text-align: center;">별명</th>
					<th style="width: 15%; text-align: center;">이메일</th>
					<th style="width: 10%; text-align: center;">전화번호</th>
					<th style="width: 10%; text-align: center;">생일</th>
					<th style="width: 10%; text-align: center;">직위</th>
					<th style="width: 15%; text-align: center;">가입날짜</th>



				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${vo2.user_num}</td>
					<td>${vo2.user_id}</td>
					<td>${vo2.password}</td>
					<td>${vo2.nickname}</td>
					<td>${vo2.email}</td>
					<td>${vo2.tel}</td>
					<td>${vo2.birth}</td>
					<td>${vo2.authority}</td>
					<td>${vo2.reg_date}</td>

				</tr>
			</tbody>
			<tr>
				<td colspan="9" align="right"><a
					href="u_update.do?user_num=${param.user_num}&user_id=${param.user_id}">회원수정</a>
					<a href="u_delete.do?user_num=${param.user_num}">회원삭제</a></td>
			</tr>
		</table>
		
		<h3>회원이 쓴 커뮤니티</h3>

		<table class="alt">
			<thead>
				<tr>
					<th style="width: 10%; text-align: center;">번호</th>
					<th style="width: 30%; text-align: center;">제목</th>
					<th style="width: 15%; text-align: center;">작성자</th>
					<th style="width: 30%; text-align: center;">작성내용</th>
					<th style="width: 15%; text-align: center;">작성일자</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${boards}">
					<tr>
						<td><a href="b_selectOne.do?board_num=${vo.board_num}">${vo.board_num}</a></td>
						<td style="text-align: center;">${vo.title}</td>
						<td style="text-align: center;">${vo.nickname}</td>
						<td style="text-align: center;">${vo.content}</td>
						<td style="text-align: center; vertical-align: middle;">${fn:substring(vo.wdate,0,10) }</td>
					</tr>
				</c:forEach>
			</tbody>

			<tfoot>
				<tr>
					<td colspan="5"><c:forEach var="i" begin="1"
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
		
		<h3>스토리</h3>

		<table class="alt">
			<thead>
				<tr>
					<th style="width: 10%; text-align: center;">번호</th>
					<th style="width: 15%; text-align: center;">작성자</th>
					<th style="width: 30%; text-align: center;">작성내용</th>
					<th style="width: 15%; text-align: center;">작성일자</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${storys}">
					<tr>
						<td style="text-align: center;"><a href="s_selectOne.do?story_num=${vo.story_num}">${vo.story_num}</a></td>
						<td style="text-align: center;">${vo.nickname}</td>
						<td style="text-align: center;">${vo.content}</td>
						<td style="text-align: center; vertical-align: middle;">${fn:substring(vo.wdate,0,10) }</td>
					</tr>
				</c:forEach>

			</tbody>

			<tfoot>
				<tr>
					<td colspan="7"><c:forEach var="i" begin="1"
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
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include></div>
</body>
</html>