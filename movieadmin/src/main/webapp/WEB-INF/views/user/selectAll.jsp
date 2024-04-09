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
        #customers {
          font-family: Arial, Helvetica, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }
        
        #customers td, #customers th {
          border: 1px solid #ddd;
          padding: 8px;
        }
        
        #customers tr:nth-child(even){background-color: #ff6565;}
        
        #customers tr:hover {background-color: #fca2a2;}
        
        #customers th {
          padding-top: 12px;
          padding-bottom: 12px;
          text-align: left;
          background-color: #04AA6D;
          color: white;
        }

        tfoot td{
            text-align: center; 
        }
        </style>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
    <h1>회원목록</h1>
    <hr>
    <form action="u_searchList.do">
    	<select name="searchKey">
    		<option value="user_id">아이디</option>
    		<option value="nickname">닉네임</option>
    	</select>
    	<input type="text" name="searchWord" value="ad">
    	<input type="submit" value="search">
    	
    </form>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>
                <th>이미지</th>
                <th>아이디</th>
                <th>비번</th>
                <th>이름</th>
                <th>폰번</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="vo" items="${vos}">
            <tr>
                <td><a href="u_selectOne.do?user_num=${vo.user_num}&user_id=${vo.user_id}">${vo.user_num}</a></td>
                <td>${vo.user_id}</td>
                <td>${vo.password}</td>
                <td>${vo.nickname}</td>
                <td>${vo.tel}</td>
                <td><a href="u_delete.do?user_num=${vo.user_num}">회원삭제</a></td>
            </tr>
        	</c:forEach>
            
        </tbody>
        <tfoot>
            <tr>
                <td colspan="7">
                	<c:forEach var="i" begin="1" end="${totalPageCount}">
	                	<c:if test="${param.searchKey == null }">
		                	<a href="u_selectAll.do?cpage=${i}">${i} &nbsp;</a>
                		</c:if>
                		<c:if test="${param.searchKey != null }">
		                	<a href="u_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i} &nbsp;</a>
                		</c:if>
                	</c:forEach>
                </td>
            </tr>
        </tfoot>
    </table>
</body>
</html>