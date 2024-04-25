<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
		<h2>즐겨찾기 목록</h2>
		<table class="alt">
		
			<tbody>
			<c:set var="count" value="0" />
<c:forEach var="vo" items="${favorites}">
    <c:if test="${count % 5 == 0}">
        <c:set var="newRow" value="true" />
        <tr>
    </c:if>
    <td style="text-align: center;">
        <a href="i_selectOne.do?info_num=${vo.info_num}">
            <img alt="" src="resources/uploadimg/${vo.save_img}" style="width: 50%; display: block; margin: 0 auto;">
        </a>
        <div>${vo.title}</div>
    </td>

    <c:if test="${(count + 1) % 5 == 0 or count == fn:length(favorites) - 1}">
        </tr>
    </c:if>
    
    <c:set var="count" value="${count + 1}" />
</c:forEach>

			</tbody>

		</table>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>

</html>