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
#movies {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#movies td, #movies th {
	border: 1px solid #ddd;
	padding: 8px;
}

#movies tr:nth-child(even) {
	background-color: #ff6565;
}

#movies tr:hover {
	background-color: #fca2a2;
}

#movies th {
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	console.log("jquery test");
	console.log($(".c_increaseGood"));
	$(".c_increaseGood").each(function(index,item){
//			console.log(index);
		
		$(this).click(function() {
			
			console.log("increaseGood Click");
			console.log($("#comments_num"+index).val());
			console.log($("#good"+index).val());
			
			$.ajax({
				url : "http://localhost:8070/movie/c_increaseGood.do",
				type : "get",
				data : {
					comments_num : $("#comments_num"+index).val(),
					board_num : $("#board_num").val(),
					nickname : $("#nickname"+index).val(),
					good : $("#good"+index).val()
				},
				dataType : "json",
				success : function(obj) {
					console.log(obj);
					let good = obj.good;
//						console.log(item);
					item.value = good;
				},
				error : function(xhr, status) {
					console.log("status...", status);
				}
			});
			return false;
		});
	});
});
</script>

</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h1>글정보</h1>
	<hr>
	<table id="movies">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${vo2.board_num}</td>
				<td>${vo2.title}</td>
				<td>${vo2.nickname}</td>
				<td>
					<form action="b_increaseGood.do" method="post">
						<input type="hidden" name="board_num" value="${vo2.board_num}">
						<button type="submit">좋아요 ${vo2.good}</button>
					</form>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${vo2.content}</td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td colspan="3">${vo2.wdate}</td>
			</tr>
		</tbody>
	</table>
	<c:if test="${param.nickname == vo2.nickname}">
		<a href="b_update.do?board_num=${vo2.board_num}&nickname=${param.nickname}&title=${param.title}&content=${param.content}">글수정</a>
		<a href="b_delete.do?board_num=${vo2.board_num}">글삭제</a>
	</c:if>
	<hr>
	<h3>댓글작성</h3>
	<form action="c_insertOK.do">
		<table id="movies">
			<thead>
				<tr>
					<th>댓글 내용</th>
					<th>댓글 작성자</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="content" value="hello" size="50"></td>
					<td>${nickname}<input type="hidden" name="nickname"
						value="${nickname}"> <input type="hidden" name="board_num" value="${vo2.board_num}">
					</td>
					<td><input type="submit" value="댓글작성"></td>
				</tr>
			</tbody>
		</table>

	</form>
	<hr>
	<h3>댓글목록</h3>
	<table id="movies">
		<thead>
			<tr>
				<th>번호</th>
				<th>내용</th>
				<th>작성자</th>
				<th>좋아요</th>
				<th>작성일자</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cvo" items="${cvos}">
				
				<tr>
					<td>${cvo.comments_num}</td>
					<td>${cvo.content}
						<form action="c_updateOK.do">
							<input type="text" name="content" value="${cvo.content}">
							<input type="hidden" name="comments_num" value="${cvo.comments_num}">
							<input type="hidden" name="board_num" value="${cvo.board_num}">
							<input type="submit" value="수정">
						</form>
					</td>
					<td>${cvo.nickname}<input type="hidden" name="nickname"
						value="${user_id}" id="nickname${vs.index}"></td>
					<td><input type="hidden" name="comments_num"
						value="${cvo.comments_num}"  id="comments_num${vs.index}">
							<input type="hidden" name="board_num" value="${vo2.board_num}" id="board_num">
							<input type="hidden" name="good" value="${cvo.good}" id="good${vs.index}">
							<input type="button" value="${cvo.good}" class="c_increaseGood">
					<td>${cvo.wdate}</td>
					<td>
						<a href="c_deleteOK.do?comments_num=${cvo.comments_num}&board_num=${cvo.board_num}">삭제</a>
					</td>
					
				</tr>
			</c:forEach>

		</tbody>
	</table>


</body>
</html>