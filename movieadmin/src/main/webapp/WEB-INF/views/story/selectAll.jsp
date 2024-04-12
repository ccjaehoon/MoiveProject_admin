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
    <h1>글목록</h1>
    <hr>
    <a href="s_insert.do">스토리 만들기</a>
    <table id="customers">
        <tbody>
        	<c:forEach var="vo" items="${vos}">
            
            <tr>
                <td><a href="s_selectRandomList.do?story_num=${vo.story_num}">${vo.story_num}</a></td>
            </tr>
            <tr>
                <td>${vo.content}</td>
            </tr>
            <tr>
                <td>${vo.nickname}</td>
            </tr>
            <tr>
                <td><img alt="" src="resources/uploadimg/thumb_${vo.save_img}"></td>
            </tr>
            <tr>
                <td><a href="s_delete.do?story_num=${vo.story_num}">글삭제</a></td>
            </tr>
        	</c:forEach>
            
        </tbody>
       
    </table>
</body>
</html>