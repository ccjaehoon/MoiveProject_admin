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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">
$(function() {
	console.log("jquery test");
	console.log($(".s_increaseGood"));
	$(".s_increaseGood").click(function() {
		console.log("increaseGood Click");
		console.log('${vo2.story_num}');
		console.log('${nickname}');
		$.ajax({
			url : "http://localhost:8070/movie/s_increaseGood.do",
			type : "get",
			data : {
				story_num : '${vo2.story_num}',
				nickname : '${nickname}'
			},
			dataType : "json",
			success : function(obj) {
				console.log(obj);
				let goodCount = obj.goodCount;
				if( obj.goodCount > 0) $('.s_increaseGood').val(goodCount); 
			},
			error : function(xhr, status) {
				console.log("status...", status);
			}
		});
		return false;
	});
	
	$(".sc_increaseGood").each(function(index, item) {
		console.log(index);
		$(this).click(function() {
			console.log("increaseGood Click");
			console.log($("#story_comments_num" + index).val());
			console.log('${nickname}');
			
			$.ajax({
				url : "http://localhost:8070/movie/api/sc_increaseGood.do",
				type : "get",
				data : {
					story_comments_num : $("#story_comments_num" + index).val(),
					nickname :'${nickname}'
				},
				dataType : "json",
				success : function(obj) {
					console.log(obj);
					if(obj.goodCount>0)item.value = obj.goodCount;
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



<script>
/*페이지가 로드될 때 #report 요소를 다이얼로그로 설정하지만, 자동으로 열리지 않도록 설정.(예: 버튼 클릭)를 통해 다이얼로그를 열기
 $("#report").dialog("open"); 코드를 사용하여 다이얼로그를 수동으로 열 수 있습니다*/
	$(function() {
		$("#report").dialog({
			autoOpen : false
		});
	});

	function showDialogReport(story_num, nickname, id) {
		console.log(story_num);
		console.log(nickname);
		console.log(id); // 디버깅 목적으로 id를 로그로 출력
		$('#story_num').val(story_num);
		$('#nickname').val(nickname);
		$("#report").dialog("open");
	}
</script>

<script>
	function submitReportForm() {
		location.reload();
	}
	$("#reportForm").submit(function(event) {
		event.preventDefault();
		$.ajax({
			type : "POST",
			url : $(this).attr("action"),
			data : $(this).serialize(),
			success : function(response) {
				console.log(response);
				submitReportForm();
			},
			error : function(xhr, status, error) {
				console.error(status, error);
			}
		});
	});
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
				<th colspan="3">작성자: ${vo2.nickname}</th>

			</tr>
		</thead>
		<tbody>

			<tr>
				<td>내용</td>
				<td colspan="3">${vo2.content}</td>
			</tr>
			
			<tr>
			<td colspan="4"><img src="resources/uploadimg/${vo2.save_img}" width="200"></td>
			</tr>
			
			<tr>
				<td>작성일자</td>
				<td colspan="3">${vo2.wdate}</td>
			</tr>
		</tbody>

		<tbody>

			<tr>
				<td><input type="hidden" name="story_num"
					value="${vo2.story_num}" id="story_num${vs.index}"> <input
					type="hidden" name="story_num" value="${vo2.story_num}"
					id="story_num"> <input type="hidden" name="good"
					value="${vo2.good}" id="good${vs.index}"> <input
					type="button" value="${vo2.good}" class="s_increaseGood"></td>

				<td><input type="button" id="reportBtn" class="report" onClick="showDialogReport('${vo2.story_num}','${vo2.nickname}')"
						value="신고" /></td>

				<td><a href="s_update.do?story_num=${vo2.story_num}">글수정</a></td>
				<td><a href="s_delete.do?story_num=${vo2.story_num}">글삭제</a></td>
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
					<td>${nickname}<input type="hidden" name="nickname"
						value="${nickname}"> <input type="hidden" name="story_num"
						value="${vo2.story_num}">
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
					<td>${cvo.story_comments_num}</td>
					<td>${cvo.content}
						<form action="SComments_updateOK.do">
							<c:if test="${nickname == cvo.nickname}">
								<input type="text" name="content" value="${cvo.content}">
								<input type="hidden" name="story_comments_num" value="${cvo.story_comments_num}">
								<input type="hidden" name="story_num" value="${cvo.story_num}">
								<input type="submit" value="수정">
							</c:if>
						</form>
					</td>

					<td>${cvo.nickname}<input type="hidden" name="nickname"
									value="${nickname}" id="nickname${vs.index}"></td>

					<td><input type="hidden" name="story_comments_num"
							   value="${cvo.story_comments_num}"
							   id="story_comments_num${vs.index}">
							   
						<input type="hidden" name="story_num" value="${vo2.story_num}" id="story_num">
								
						<input type="hidden" name="good" value="${cvo.good}" id="good${vs.index}">
						<%-- <input type="button" value="${cvo.good}" id="btn_good" class="sc_increaseGood"
							   onclick="fn_good(${cvo.story_comments_num})"></td> --%>
						<input type="button" value="${cvo.good}" class="sc_increaseGood"></td>

					<td>${cvo.wdate}</td>



					<td><input type="button" id="reportBtn_comment" class="report"
								onClick="showDialogReport('${cvo.story_comments_num}','${cvo.nickname}')"
								value="신고" /></td>



					<td><c:if test="${nickname == cvo.nickname}">
							<%-- 자바스크립트를 쓸 경우						
<input type="button" id="deleteBtn" class="delete" value="삭제" onclick="deleteComment(${cvo.story_comments_num})"> --%>
						<a href="SComments_deleteOK.do?story_comments_num=${cvo.story_comments_num}&story_num=${cvo.story_num}">댓글삭제</a>
						</c:if></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<div id="report">

		<form id="reportForm" action="rp_insertOK.do" method="post">
			<table id="rp" border="2">
				<tr>
					<td id="font" width="100">신고 내용<input type="text"
						id="nickname" name="nickname" value="${cvo.nickname}" readonly>
						<input type="text" id="story_comments_num" name="story_comments_num"
						value="${cvo.story_comments_num}" readonly></td>
				</tr>
				<tr>
					<td width="500"><textarea id="text_report" name="content"
							placeholder="신고내용을 적으세요">test report</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="신고접수"
						class="report"></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>