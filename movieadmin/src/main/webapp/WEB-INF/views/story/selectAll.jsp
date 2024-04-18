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
#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #ff6565;
}

#customers tr:hover {
	background-color: #fca2a2;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}

tfoot td {
	text-align: center;
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
	<a href="s_insert.do">스토리 만들기</a>
	<table id="customers">
		<tbody>
			<c:forEach var="vo" items="${vos}">

				<tr>
				<%-- 	<td><a href="s_selectRandomList.do?story_num=${vo.story_num}">${vo.story_num}</a></td> --%>
					<td><a href="s_selectOne.do?story_num=${vo.story_num}?nickname=${vo.nickname}">${vo.story_num}</a></td>
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
					<td><button onclick="selectCommentList(${vo.story_num})">댓글목록</button></td>
				</tr>
				<tr>
					<td>
						<table>
							<tbody id="sc_comm_list${vo.story_num}">
							</tbody>
						</table>
					</td>
				</tr>

			</c:forEach>

		</tbody>

	</table>
</body>
</html>