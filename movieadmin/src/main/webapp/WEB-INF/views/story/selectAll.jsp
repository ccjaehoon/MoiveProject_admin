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
			url:"http://localhost:8090/movie/api/selectCommentList.do",
			type:"get",
			data:{story_num:story_num},
			dataType:"json",
			success:function(arr){
				console.log(arr);
			},error:function(){
				
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
					<td><button onclick="selectCommentList(${vo.story_num})">댓글목록</button></td>
				</tr>
				<tr>
					<td>
						<table>
							<tbody>
								<tr>
									<td>1</td>
									<td>nickname4</td>
									<td>1등댓글2</td>
									<td>2024-04-12</td>
								</tr>
								<tr>
									<td>1</td>
									<td>nickname4</td>
									<td>1등댓글2</td>
									<td>2024-04-12</td>
								</tr>
								<tr>
									<td>1</td>
									<td>nickname4</td>
									<td>1등댓글2</td>
									<td>2024-04-12</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>

			</c:forEach>

		</tbody>

	</table>
</body>
</html>