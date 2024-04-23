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

 <style>
        #main {
            margin-top: 100px; /* 탑 메뉴의 높이만큼 상단 마진 추가 */
        }

        #top-menu {
            position: fixed; /* 화면에 고정 */
            top: 0; /* 화면 상단에 위치 */
            left: 0; /* 화면 왼쪽에 위치 */
            width: 100%; /* 전체 너비로 확장 */
            background-color: #fff; /* 배경색 지정 */
            z-index: 1000; /* 다른 요소 위에 표시 */
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
        }
    </style>
</head>

<body >

<jsp:include page="../top_menu.jsp"></jsp:include>

<div id="main">
	

		<h2>공지사항</h2>

		<form action="a_searchList.do">
			<span style="float: left"><select name="searchKey" style="width: 150px;">
					<option value="title">title</option>
					<option value="content">content</option>
			</select></span><span style="float: left"> <input type="text"
				name="searchWord" value="검색어" style="width: 150px;">
			</span> <input type="submit" value="search">

		</form>

			<table id="main">
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
		<c:if test="${authority == 'admin' }">
			<form action="a_insert.do">
				<input type="submit" value="announcement 작성">
			</form>
		</c:if>
		

</div>
<div id = "copyright">
<jsp:include page="../footer_menu.jsp"></jsp:include></div>




	

</body>

</html>