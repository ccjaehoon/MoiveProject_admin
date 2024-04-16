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
    <h1>글정보</h1>
    <hr>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>
                <th>작성자</th>
                <th>신고내용</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${vo2.report_num}</td>
                <td>${vo2.nickname}</td>
                <td>${vo2.content}</td>
            </tr>
            <tr>
                <td>내용</td>
                <td colspan="2">${vo2.content}</td>
            </tr>
            <tr>
                <td>작성일자</td>
                <td colspan="2">${vo2.wdate}</td>
            </tr>
        </tbody>
    </table>

	    <a href="rp_update.do?report_num=${vo2.report_num}">글수정</a>
	    <a href="rp_delete.do?report_num=${vo2.report_num}">글삭제</a>

    <hr>
    
</body>
</html>