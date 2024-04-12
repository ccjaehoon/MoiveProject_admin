<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            min-height: 100vh;
            flex-direction: column;
        }

        main {
            flex: 1;
            text-align: center; /* 중앙 정렬 */
        }

        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
            position: fixed;
            top: 0;
            left: 50%;
            transform: translateX(-50%);
            width: 100%;
        }

        header a {
            color: #fff;
            margin: 0 10px;
            text-decoration: none;
        }

        header hr {
            margin-top: 5px;
            border: none;
            border-top: 1px solid #fff;
            width: 80%;
        }
    </style>
</head>
<body>
    <header>
        <a href="home.do">홈</a>
        <a href="i_selectAll.do">영화정보</a>
        <a href="b_selectAll.do">커뮤니티</a>
        <a href="s_selectAll.do">스토리</a>
        <a href="a_selectAll.do">공지사항</a>
        <a href="n_selectAll.do">뉴스</a>
        <a href="f_selectAll.do">FAQ</a>
        <a href="u_insert.do">회원가입</a>
        <a href="u_selectAll.do">회원목록</a>
        <a href="m_myPage.do">마이페이지</a>
        <a href="rp_selectAll.do">신고목록</a>
        <c:choose>
            <c:when test="${user_id != null}"><a href="u_logout.do">로그아웃</a></c:when>
            <c:otherwise><a href="u_login.do">로그인</a></c:otherwise>
        </c:choose>

    </header>

    <main>
    </main>
</body>
</html>

