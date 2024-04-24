<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뉴스목록</title>
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/noscript.css" />
	</head>
</head>
<body class="is-preload">
	
	<div id="main">
	<jsp:include page="../top_menu.jsp"></jsp:include>
    <h2>news</h2>
    <br> <br>
    <form action="n_searchList.do">
    	<select name="searchKey">
    		<option value="title">title</option>
    		<option value="content">content</option>
    	</select>
    	<input type="text" name="searchWord" value="title">
    	<input type="submit" value="search">
    	
    </form>
    <div class="table-wrapper">
	    <table class="alt">
	        <thead>
	            <tr>
	                <th>번호</th>
	                <th>썸네일</th>
	                <th>제목</th>
	                <th>작성자</th>
	                <th>작성내용</th>
	                <th>작성일자</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach var="vo" items="${vos}">
	            <tr>
	                <td><a href="n_selectOne.do?news_num=${vo.news_num}&nickname=${vo.nickname}">${vo.news_num}</a></td>
	               <td><img alt="" src="resources/uploadimg/thumb_${vo.save_img}"></td>
	                <td>${vo.title}</td>
	                <td>${vo.nickname}</td>
	                <td>${vo.content}</td>
	                <td><fmt:formatDate value="${vo.wdate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                <td><a href="b_delete.do?board_num=${vo.news_num}">글삭제</a></td>
	            </tr>
	        	</c:forEach>
	            
	        </tbody>
	        
	        <tfoot>
	            <tr>
	                <td colspan="7" align = "center">
	                	<c:forEach var="i" begin="1" end="${totalPageCount}">
		                	<c:if test="${param.searchKey == null }">
			                	<a href="n_selectAll.do?cpage=${i}">${i} &nbsp;</a>
	                		</c:if>
	                		<c:if test="${param.searchKey != null }">
			                	<a href="n_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i} &nbsp;</a>
	                		</c:if>
	                	</c:forEach>
	                </td>
	            </tr>
	        </tfoot>
	    </table>
    </div>
    <c:if test="${authority == 'admin' }">
    <a href="n_insert.do">뉴스 작성</a>
    </c:if>
    </div>
</body>
</html>