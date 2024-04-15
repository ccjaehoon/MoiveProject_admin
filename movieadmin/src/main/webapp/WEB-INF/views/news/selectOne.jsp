<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뉴스 수정 페이지</title>
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

#Report {
	width: 500px;
	height: 500px;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("jquery test");
		console.log($(".nc_increaseGood"));
		$(".nc_increaseGood")
				.each(
						function(index, item) {
							//			console.log(index);

							$(this)
									.click(
											function() {

												console
														.log("increaseGood Click");
												console.log($(
														"#news_comments_num"
																+ index).val());
												console.log($("#good" + index)
														.val());

												$
														.ajax({
															url : "http://localhost:8070/movie/nc_increaseGood.do",
															type : "get",
															data : {
																news_comments_num : $(
																		"#news_comments_num"
																				+ index)
																		.val(),
																news_num : $(
																		"#news_num")
																		.val(),
																nickname : $(
																		"#nickname"
																				+ index)
																		.val(),
																good : $(
																		"#good"
																				+ index)
																		.val()
															},
															dataType : "json",
															success : function(
																	obj) {
																console
																		.log(obj);
																let good = obj.good;
																//						console.log(item);
																item.value = good;
															},
															error : function(
																	xhr, status) {
																console
																		.log(
																				"status...",
																				status);
															}
														});

												return false;
											});
						});

		

	});
</script>
<script>
	$(function() {
		console.log("jquery test");
		console.log($(".report"));
		$(".report")
				.each(
						function(index, item) {
							//			console.log(index);

							$(this)
									.click(
											function() {
	
												console.log("report Click");
												console.log($(
														"#news_comments_num"
																+ index).val());

												$.ajax({
															url : "http://localhost:8070/movie/rp_insertOK",
															type : "post",
															data : {
																news_comments_num : $(
																		"#news_comments_num"
																				+ index)
																		.val(),
																nickname : $(
																		"#nickname"
																				+ index)
																		.val()
															},
															dataType : "json",
															success : function(
																	obj) {
																console
																		.log(obj);
															},
															error : function(
																	xhr, status) {
																console
																		.log(
																				"status...",
																				status);
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
	<h1>뉴스정보</h1>
	<hr>
	<table id="customers">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>썸네일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${vo2.news_num}</td>
				<td>${vo2.title}</td>
				<td>${vo2.nickname}</td>
				<td><img src="resources/uploadimg/${vo2.save_img}" width="200"></td>
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
	<a
		href="n_update.do?news_num=${param.news_num}&nickname=${param.nickname}">글수정</a>
	<a href="n_delete.do?news_num=${param.news_num}">글삭제</a>
	<hr>
	<h3>댓글작성</h3>
	<form action="nc_insertOK.do">
		<table id="customers">
			<thead>
				<tr>
					<th>댓글 내용${param.msg}</th>
					<th>댓글 작성자</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="content" value="hello" size="50"></td>
					<td>${nickname}<input type="hidden" name="nickname"
						value="${nickname}"> <input type="hidden" name="news_num"
						value="${vo2.news_num}">
					</td>
					<td><input type="submit" value="댓글작성"></td>
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
					<td>${cvo.news_comments_num}</td>
					<td>${cvo.content}
						<form action="nc_updateOK.do">
							<c:if test="${param.nickname == cvo.nickname}">
								<input type="text" name="content" value="${cvo.content}">

								<input type="hidden" name="news_comments_num"
									value="${cvo.news_comments_num}">
								<input type="hidden" name="news_num" value="${cvo.news_num}">
								<input type="submit" value="수정">
							</c:if>

						</form>
					</td>

					<td>${cvo.nickname}<input type="hidden" name="nickname"
						value="${user_id}" id="nickname${vs.index}"></td>

					<td><input type="hidden" name="news_comments_num"
						value="${cvo.news_comments_num}" id="news_comments_num${vs.index}">
						<input type="hidden" name="news_num" value="${vo2.news_num}"
						id="news_num"> <input type="hidden" name="good"
						value="${cvo.good}" id="good${vs.index}"> <input
						type="button" value="${cvo.good}" class="nc_increaseGood"></td>


					<td>${cvo.wdate}</td>



					<td><input type="button" id="reportBtn" class="report"
						value="신고" /></td>



					<td><c:if test="${param.nickname == cvo.nickname}">
							<a
								href="nc_deleteOK.do?news_comments_num=${cvo.news_comments_num}&news_num=${cvo.news_num}">댓글삭제</a>
						</c:if></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>

	<div id="report" title="신고 내용">
		<form action="rp_insertOK.do" method="post">
			<input type="hidden" id="nickname" name="nickname"
				value="${param.nickname}"> <input type="hidden"
				id="news_comments_num" name="news_comments_num"
				value="${cvo.news_comments_num}">
			<textarea id="Report"></textarea>
			<input type="submit" value="신고접수" class="report">
		</form>
	</div>

</body>
</html>