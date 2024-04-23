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
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

h1 {
    text-align: center;
}
#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 80%;
    margin: 0 auto;
    border-collapse: collapse;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

 #customers th {
       padding-top: 12px;
       padding-bottom: 12px;
       text-align: center;
       background-color: #4CAF50;
       color: white;
 }

tfoot td {
	text-align: center;
}

.story-container {
    border: 1px solid #ddd;
    margin-bottom: 20px;
    padding: 10px;
}

.story-container img {
    max-width: 100%;
    height: auto;
    display: block;
    margin: 0 auto;
}

.story-content {
    margin-bottom: 10px;
}

.story-content p {
    margin: 0;
}

.story-link {
    text-decoration: none;
    color: #333;
    font-weight: bold;
}

.comment-btn {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 4px;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	function selectCommentList(story_num){
		console.log("selectCommentList()...",story_num);
		
		$.ajax({
			url:"http://localhost:8070/movie/api/selectCommentList.do",
			type:"get",
			data:{story_num:story_num},
			dataType:"json",
			success:function(arr){
				console.log(arr);
				let data = '';
				arr.forEach(function(item){
					console.log(item);
					
					data += `<tr>
						<td>\${item.story_comments_num}</td>
						<td>\${item.nickname}</td>
						<td>\${item.content}</td>
						<td>\${item.good}</td>
						<td>\${item.report}</td>
						<td>\${item.wdate}</td>
					</tr>`;
					
				});
				
				$('#sc_comm_list'+story_num).html(data);
			},error:function(){ // 서버로부터 데이터를 받아오는 과정에서 오류가 발생했을 때 실행되는 콜백 함수
				
			}
		});
	}	
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	    <h1>글목록</h1>
    <hr>
    <a href="s_insert.do" class="comment-btn">스토리 만들기</a>
    <table id="customers">
        <tbody>
            <c:forEach var="vo" items="${vos}">
                <tr>
                    <td>
                        <div class="story-container">
                            <a href="s_selectOne.do?story_num=${vo.story_num}&nickname=${vo.nickname}" class="story-link">${vo.story_num}</a>
                            <div class="story-content">
                                <p>${vo.content}</p>
                                <p>${vo.nickname}</p>
                            </div>
                            <img src="resources/uploadimg/images/thumb_${vo.save_img}" alt="">
                            <img src="resources/uploadimg/videos/thumb_${vo.save_video}" alt="">
                            <button class="comment-btn" onclick="selectCommentList(${vo.story_num})">댓글목록</button>
                            <table>
                                <tbody id="sc_comm_list${vo.story_num}">
                                    <!-- Comment list will be inserted here dynamically -->
                                </tbody>
                            </table>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>