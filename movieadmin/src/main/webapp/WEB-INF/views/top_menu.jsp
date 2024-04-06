<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="home.do">홈</a>
<!-- <a href="i_selectAll.do">영화정보</a> -->
<!-- <a href="b_selectAll.do">커뮤니티</a> -->
<!-- <a href="s_selectAll.do">스토리</a> -->
<!-- <a href="a_selectAll.do">공지사항</a> -->
<!-- <a href="n_selectAll.do">뉴스</a> -->
<a href="f_selectAll.do">FAQ</a>
<a href="m_insert.do">회원가입</a>
<c:choose>
	<c:when test="${user_id != null}"><a href="logout.do">로그아웃</a></c:when>
	<c:otherwise><a href="login.do">로그인</a></c:otherwise>
</c:choose>
<a href="u_selectAll.do">회원목록</a>
<hr>
