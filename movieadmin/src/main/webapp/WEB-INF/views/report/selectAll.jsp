<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <h2>신고 목록</h2>
    <table class="alt">
        <thead>
            <tr>
                <th>번호</th>
                <th>작성자</th>
                <th>작성일자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${vos}">
            <tr>
                <td><a href="rp_selectOne.do?report_num=${vo.report_num}">${vo.report_num}</a></td>
                <td>${vo.nickname}</td>
                <td>${vo.wdate}</td>
                <td><a href="rp_delete.do?report_num=${vo.report_num}">글삭제</a></td>
            </tr>
        	</c:forEach>
        </tbody>
    </table>
    </div>
    		<div id = "copyright">
<jsp:include page="../footer_menu.jsp"></jsp:include></div>
</body>
</html>