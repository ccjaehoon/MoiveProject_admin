<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    <title>Home</title>
    <link href="${path}/resources/css/main.css" rel="stylesheet"/> 

</head>
<body>
    <jsp:include page="top_menu.jsp"></jsp:include>
    <h1>영화 정보사이트입니다</h1>
    <p>The time on the server is ${serverTime}.</p>
    <jsp:include page="footer_menu.jsp"></jsp:include>
</body>
</html>

