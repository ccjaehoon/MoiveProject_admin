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
<<<<<<< HEAD
                <th>영화제목</th>
                <th>포스터</th>
                <th>줄거리</th>
                <th>감독</th>
                <th>출연진</th>
=======
                <th>번호</th>
                <th>제목</th>
                <th>포스터</th>

                <th></th>
>>>>>>> branch 'main' of https://github.com/ccjaehoon/MoiveProject_admin.git
            </tr>
        </thead>
        <tbody>
<<<<<<< HEAD
        	<c:forEach var="vo" items="${vos}">
					<tr>
						<td width=200px><a
							href="i_selectOne.do?info_num=${vo.info_num}&title=${vo.title}">${vo.info_num}</a></td>
						<td>${vo.title}</td>
						<td>${vo.save_img}</td>

					</tr>
				</c:forEach>
=======
            <c:forEach var="vo" items="${vos}">
                    <tr>
                        <td width=200px><a
                            href="i_selectOne.do?info_num=${vo.info_num}">${vo.info_num}</a></td>
                        <td>${vo.title}</td>
                        <td>${vo.save_img}</td>
                                         </tr>
                </c:forEach>
>>>>>>> branch 'main' of https://github.com/ccjaehoon/MoiveProject_admin.git
        </tbody>
        <tfoot>
            <tr>
                <td colspan="5">
                    <c:forEach var="i" begin="1" end="${totalPageCount}">
                        <c:if test="${param.searchKey == null }">
                            <a href="i_selectAll.do?cpage=${i}">${i} &nbsp;</a>
                        </c:if>
                        <c:if test="${param.searchKey != null }">
                            <a href="i_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i} &nbsp;</a>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
        </tfoot>
    </table>
</body>

</html>