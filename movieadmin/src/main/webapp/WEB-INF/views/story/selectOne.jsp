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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
    <h1>글정보</h1>
    <hr>
    <table id="customers">
        <thead>
            <tr>
                <th>번호: ${vo2.story_num}</th>
                <th>작성자: ${vo2.nickname}</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
           <%--  <tr>
                <td>${vo2.story_num}</td>
                <td>${vo2.nickname}</td>
            </tr> --%>
            <tr>
                <td>내용</td>
                <td colspan="2">${vo2.content}</td>
            </tr>
            <tr>
                <td>내용</td>
                <td colspan="2"><img alt="" src="resources/uploadimg/thumb_${vo2.save_img}"></td>
            </tr>
            <tr>
                <td>작성일자</td>
                <td colspan="2">${vo2.wdate}</td>
            </tr>
        </tbody>
        
        <tbody>
        
       		 <tr>
       		 	<td><a href="s_increaseGoodOK.do?story_num=${vo.good}">추천</a></td>
       		 	<td><a href="s_increaseReportOK.do?story_num=${vo.report}">신고하기</a></td>
       		 	<td><a href="s_delete.do?story_num=${vo.story_num}">글삭제</a></td>
            </tr>
        </tbody>
    </table>
    
 
    <hr>
    <h3>댓글작성</h3>
    <form action="SComments_insertOK.do">
	    <table id="customers">
	        <thead>
	            <tr>
	                <th>댓글 내용 ${param.msg}</th>
	                <th>댓글 작성자</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	        	<tr>
	        		<td><input type="text" name="content" value="hello" size="50"></td>
	        		<td>
	        			${nickname}<input type="hidden" name="nickname" value="${nickname}">
	        			<input type="hidden" name="story_num" value="${vo2.story_num}">
	        		</td>
	        		<td><input type="submit"  value="댓글작성"></td>
	        	</tr>
	        </tbody>
	    </table>
	    
    </form>
         
    <hr>
    <h3>댓글목록</h3>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>
				<th>내용</th>
				<th>작성자</th>
				<th>좋아요</th>
				<th>작성일자</th>
				<th>신고</th>
				<th>삭제</th>
            </tr>
        </thead>
		<tbody>
			<c:forEach var="cvo" items="${cvos}" varStatus="vs">

				<tr>
					<td>${cvo.story_comments_num}</td>
					<td>${cvo.content}
						<form action="SComments_updateOK.do">
							<c:if test="${param.nickname == cvo.nickname}">
								<input type="text" name="content" value="${cvo.content}">

								<input type="hidden" name="story_comments_num"
									value="${cvo.story_comments_num}">
								<input type="hidden" name="story_num" value="${cvo.story_num}">
								<input type="submit" value="수정">
							</c:if>

						</form>
					</td>

					<td>${cvo.nickname}<input type="hidden" name="nickname"
						value="${user_id}" id="nickname${vs.index}"></td>

					<td><input type="hidden" name="story_comments_num"
						value="${cvo.story_comments_num}" id="story_comments_num${vs.index}">
						<input type="hidden" name="story_num" value="${vo2.story_num}"
						id="story_num"> <input type="hidden" name="good"
						value="${cvo.good}" id="good${vs.index}"> <input
						type="button" value="${cvo.good}" class="sc_increaseGood"></td>


					<td>${cvo.wdate}</td>



					<td>
						<input type="button" id="reportBtn" class="report" value="신고" />
						
					</td>


 				
					<td>
					
						<c:if test="${nickname == cvo.nickname}">
<%-- 						<input type="button" id="deleteBtn" class="delete" value="삭제" onclick="deleteComment(${cvo.story_comments_num})"> --%>
<a href="SComments_deleteOK.do?story_comments_num=${cvo.story_comments_num}&story_num=${cvo.story_num}">댓글삭제</a>
						</c:if>
					</td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
    
    
</body>
</html>