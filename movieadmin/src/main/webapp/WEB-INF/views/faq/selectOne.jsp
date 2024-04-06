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
    <h1>회원정보</h1>
    <hr>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>

            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${vo2.faq_faq_num}</td>

       
            </tr>
        </tbody>
    </table>
    <a href="f_update.do?faq_num=${param.faq_num}">회원수정</a>
    <a href="f_delete.do?faq_num=${param.faq_num}">회원삭제</a>
</body>
</html>