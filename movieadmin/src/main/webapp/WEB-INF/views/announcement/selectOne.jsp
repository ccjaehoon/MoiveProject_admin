<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



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
<script type="text/javascript">
	console.log(${vo2.wdate});
	</script>
</head>
<body class="is-preload">

	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>

		<table class="alt">
			<tbody>


				<tr>
					<td id="announcementR">번호</td>
					<td>${vo2.announcement_num}</td>
					<td id="announcementR">작성자</td>
					<td>${vo2.nickname}</td>		
					<td id="announcementR">작성날짜</td>
					<td>${vo2.wdate}</td>
				</tr>

				<tr>
					<td id="announcementR">제목</td>
					<td colspan="6">${vo2.title}</td>

				</tr>
				<tr>

					<td align="left" colspan="6"><img
						src="resources/uploadimg/${vo2.save_img}" width="300"> <br>
						${vo2.content}</td>
				</tr>
				<c:if test="${authority == 'admin' }">
					<td colspan="6" align="right"><a
						href="a_update.do?announcement_num=${vo2.announcement_num}&nickname=${vo2.nickname}&title=${vo2.title}&content=${vo2.content}">공지사항
							수정</a> <a
						href="a_delete.do?announcement_num=${param.announcement_num}">공지사항
							삭제</a></td>
				</c:if>
			</tbody>
		</table>

	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>
</html>