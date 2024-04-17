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
    <form action="i_searchList.do">
    	<select name="searchKey">
    		<option value="title">title</option>
    		<option value="content">content</option>
    	</select>
    	<input type="text" name="searchWord" value="ja">
    	<input type="submit" value="search">
    	
    </form>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일자</th>
                <th></th>
            </tr>
        </thead>
        <tbody id="vos">
        	
           
        	
            
        </tbody>
        <tfoot>
            <tr>
                <td colspan="5">
                	<c:forEach var="i" begin="1" end="${totalPageCount}">
	                	<c:if test="${param.searchKey == null }">
		                	<a href="b_selectAll.do?cpage=${i}">${i} &nbsp;</a>
                		</c:if>
                		<c:if test="${param.searchKey != null }">
		                	<a href="b_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i} &nbsp;</a>
                		</c:if>
                	</c:forEach>
                </td>
            </tr>
        </tfoot>
    </table>
</body>
<script>
        // API에서 데이터 가져 오기
//         fetch('http://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=f1c8cf77dd2d86fde938f2770265ac97')
        fetch('http://localhost:8070/movie/json_selectAll.do')
            .then(response => response.json())
            .then(data => {
                // 여기에서 데이터를 처리합니다. 예를 들어:
                console.log(data); // 데이터의 구조를 확인하기 위해 데이터를 로깅합니다.
                //console.log(data.movieListResult.movieList[0].movieNm); // 데이터의 구조를 확인하기 위해 데이터를 로깅합니다.
                
                let vos = '';
                data.movieListResult.movieList.forEach(function(vo){
                	 console.log(vo.movieNm);
                	 vos += ` <tr>
		                         <td>\${vo.movieCd}</td>
		                         <td>\${vo.movieNm}</td>
		                     </tr>`;
		              
                });
				document.getElementById("vos").innerHTML = vos;                
            })
            .catch(error => {
                console.error('데이터 가져오기 오류:', error);
            });
    </script>
</html>