<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
<div id = "main">
	<jsp:include page="../top_menu.jsp"></jsp:include>
    <h1>회원정보</h1>
    <hr>
    <table class="alt">
        <thead>
            <tr>
                <th>유저번호</th>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>별명</th>
                <th>이메일</th>
                <th>전화번호</th>
                <th>생일</th>
                <th>직위</th>              
                <th>가입날짜</th>
                
               
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
        <td colspan = "9"><a href="u_update.do?user_num=${param.user_num}&user_id=${param.user_id}">회원수정</a>
    <a href="u_delete.do?user_num=${param.user_num}">회원삭제</a></td>
    </tr>
    </table>
    
    </div>
</body>
</html>