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
		<h2>쓴 댓글 목록</h2>
		<h3>게시판</h3>
		  <table id="Table">
        <thead>
            <tr>
                <th>게시판</th>
                <th>댓글</th>
                <th>작성자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${comments}">
            <tr>
                <td><a href="b_selectOne.do?board_num=${vo.board_num}">${vo.comments_num}</a></td>
                <td>${vo.content}</td>
                <td>${vo.nickname}</td>
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
		<h3>뉴스</h3>
		  <table id="Table">
        <thead>
            <tr>
                <th>뉴스</th>
                <th>댓글</th>
                <th>작성자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${nComments}">
            <tr>
                <td><a href="n_selectOne.do?news_num=${vo.news_num}">${vo.news_comments_num}</a></td>
                <td>${vo.content}</td>
                <td>${vo.nickname}</td>
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
		
		
		
		<h3>스토리</h3>
		  <table id="Table">
        <thead>
            <tr>
                <th>스토리</th>
                <th>댓글</th>
                <th>작성자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${sComments}">
            <tr>
                <td><a href="s_selectOne.do?story_num=${vo.story_num}">${vo.story_comments_num}</a></td>
                <td>${vo.content}</td>
                <td>${vo.nickname}</td>
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
		
		
		<h3>리뷰</h3>
		  <table id="Table">
        <thead>
            <tr>
                <th>리뷰</th>
                <th>댓글</th>
                <th>작성자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${review}">
            <tr>
                <td><a href="r_selectOne.do?reiew_num=${vo.review_num}">${vo.review_num}</a></td>
                <td>${vo.content}</td>
                <td>${vo.nickname}</td>
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