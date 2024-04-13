<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
input[type=text], input[type=password], input[type=tel], select {
    width: 100%;
    padding: 8px 8px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ff8f8f;
    border-radius: 14px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 30%;
    background-color: #4CAF50;
    color: white;
    padding: 8px 8px;
    margin: 8px 0;
    border: none;
    border-radius: 14px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #bfbfbf;
}

#Table {
    font-family: Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 80%;
}

#Table td {
    border: 1px solid #ddd;
    padding: 8px;
}

#Table tr:nth-child(even) {
    background-color: #ebebeb;
}

#Table tr:hover {
    background-color: #ffc6c6;
}
</style>
</head>

<body>

	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div>
		<h2>쓴 글 목록</h2>
		<h1>내가 쓴 뉴스</h1>
    <hr>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성내용</th>
                <th>작성일자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${news}">
            <tr>
                <td><a href="n_selectOne.do?news_num=${vo.news_num}">${vo.news_num}</a></td>
                <td>${vo.title}</td>
                <td>${vo.nickname}</td>
                <td>${vo.content}</td>
                <td>${vo.wdate}</td>
            </tr>
        	</c:forEach>
            
        </tbody>
        
        <tfoot>
            <tr>
                <td colspan="7">
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
		<table>
				<h1>내가 쓴 커뮤니티</h1>
    <hr>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>            
                <th>제목</th>
                <th>작성자</th>
                <th>작성내용</th>
                <th>작성일자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${boards}">
            <tr>
                <td><a href="b_selectOne.do?board_num=${vo.board_num}">${vo.board_num}</a></td>       
                <td>${vo.title}</td>
                <td>${vo.nickname}</td>
                <td>${vo.content}</td>
                <td>${vo.wdate}</td>
            </tr>
        	</c:forEach>
            
        </tbody>
        
        <tfoot>
            <tr>
                <td colspan="7">
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
				<table>
				<h1>내가 쓴 스토리</h1>
    <hr>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>            
                <th>제목</th>
                <th>작성자</th>
                <th>작성내용</th>
                <th>작성일자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${storys}">
            <tr>
                <td><a href="s_selectOne.do?board_num=${vo.story_num}">${vo.story_num}</a></td>       
                <td>${vo.title}</td>
                <td>${vo.nickname}</td>
                <td>${vo.content}</td>
                <td>${vo.wdate}</td>
            </tr>
        	</c:forEach>
            
        </tbody>
        
        <tfoot>
            <tr>
                <td colspan="7">
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
				<table>
				<h1>내가 쓴 공지사항</h1>
    <hr>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>            
                <th>제목</th>
                <th>작성자</th>
                <th>작성내용</th>
                <th>작성일자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${annoucnements}">
            <tr>
                <td><a href="a_selectOne.do?board_num=${vo.announcement_num}">${vo.announcement_num}</a></td>       
                <td>${vo.title}</td>
                <td>${vo.nickname}</td>
                <td>${vo.content}</td>
                <td>${vo.wdate}</td>
            </tr>
        	</c:forEach>
            
        </tbody>
        
        <tfoot>
            <tr>
                <td colspan="7">
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
</body>

</html>