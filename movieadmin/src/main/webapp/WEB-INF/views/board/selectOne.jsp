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

#rp {
	background-color: white;
}

#font {
	font-size: 30px;
}

#text_report {
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
	console.log($(".b_increaseGood"));
	$(".b_increaseGood").click(function() {
		console.log("increaseGood Click");
		console.log('${vo2.board_num}');
		console.log('${nickname}');
		$.ajax({
			url : "http://localhost:8070/movie/b_increaseGood.do",
			type : "get",
			data : {
				board_num : '${vo2.board_num}',
				nickname : '${nickname}'
				good : $("#good"+index).val()
			},
			dataType : "json",
			success : function(obj) {
				console.log(obj);
				let good = obj.good;
				if( obj.good > 0) $('.b_increaseGood').val(good); 
			},
			error : function(xhr, status) {
				console.log("status...", status);
			}
		});
		return false;
	});
	
	$(".c_increaseGood").each(function(index,item){//console.log(index);
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

<script>
/*페이지가 로드될 때 #report 요소를 다이얼로그로 설정하지만, 자동으로 열리지 않도록 설정.(예: 버튼 클릭)를 통해 다이얼로그를 열기
 $("#report").dialog("open"); 코드를 사용하여 다이얼로그를 수동으로 열 수 있습니다*/
	$(function() {
		$("#report").dialog({
			autoOpen : false
		});
	});

	function showDialogReport(board_num, nickname) {
		console.log(board_num);
		console.log(nickname);
		$('#board_num').val(board_num);
		$('#nickname').val(nickname);
		$("#report").dialog("open");
	}
</script>

<script>
	$(function() {
		$("#report").dialog({
			autoOpen : false
		});
	});

	function showDialogReport(comments_num, nickname) {
		console.log(comments_num);
		console.log(nickname);
		$('#comments_num').val(comments_num);
		$('#nickname').val(nickname);
		$("#report").dialog("open");
	}
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
				<th>썸네일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${vo2.board_num}</td>
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
		
		<tbody>
				<tr>
					<td>
						<input type="hidden" name="board_num" value="${vo2.board_num}" id="board_num${vs.index}">
						<input type="hidden" name="good" value="${vo2.good}" id="good${vs.index}">
						<input type="button" value="${vo2.good}" class="b_increaseGood">
					</td>
					<td>
					<input type="button" id="reportBtn" class="report"
						onClick="showDialogReport('${vo2.board_num}','${vo2.nickname}')" value="신고" /></td>
					<td><a href="b_update.do?board_num=${param.board_num}&nickname=${param.nickname}">글수정</a></td>
					<td><a href="b_delete.do?board_num=${param.board_num}&nickname=${param.nickname}">글삭제</a></td>
				</tr>
		</tbody>
	</table>
	<hr>
	<h3>댓글작성</h3>
	<form action="c_insertOK.do">
		<table id="movies">
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
					<td>${nickname}
						<input type="hidden" name="nickname" value="${nickname}">
						<input type="hidden" name="board_num" value="${vo2.board_num}">
					</td>
					<td>
						<input type="submit" value="댓글작성">
					</td>
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
				<th>닉네임</th>
				<th>좋아요</th>
				<th>작성일자</th>
				<th>신고</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cvo" items="${cvos}" varStatus="vs">
				<tr>
					<td>${cvo.comments_num}</td>
					<td>${cvo.content}
						<form action="c_updateOK.do">
							<c:if test="${param.nickname == cvo.nickname}">
								<input type="text" name="content" value="${cvo.content}">
								<input type="hidden" name="comments_num" value="${cvo.comments_num}">
								<input type="hidden" name="board_num" value="${cvo.board_num}">
								<input type="submit" value="수정">
							</c:if>
						</form>
					</td>
					<td>${cvo.nickname}<input type="hidden" name="nickname"
						value="${nickname}" id="nickname${vs.index}">
					</td>
					<td>
						<input type="hidden" name="comments_num" value="${cvo.comments_num}"  id="comments_num${vs.index}">
						<input type="hidden" name="board_num" value="${vo2.board_num}" id="board_num">
						<input type="hidden" name="good" value="${cvo.good}" id="good${vs.index}">
						<input type="button" value="${cvo.good}" class="c_increaseGood">
					</td>
					<td>${cvo.wdate}</td>
					<td>
						<input type="button" id="reportBtn" class="report"
						onClick="showDialogReport('${cvo.comments_num}','${cvo.nickname}')" value="신고" />
					</td>
					<td>
						<c:if test="${nickname == cvo.nickname}">
							<a href="c_deleteOK.do?comments_num=${cvo.comments_num}&board_num=${cvo.board_num}">댓글삭제</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<div id="report">

		<form id="reportForm" action="rp_insertOK.do" method="post">
			<table id="rp" border="2">
				<tr>
					<td id="font" width="100">신고 내용
						<input type="text" id="nickname" name="nickname" value="${cvo.nickname}" readonly>
						<input type="text" id="comments_num" name="comments_num"
						value="${cvo.comments_num}" readonly>
					</td>
				</tr>
				<tr>
					<td width="500"><textarea id="text_report" name="content"
							placeholder="신고내용을 적으세요"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="신고접수"
						class="report">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
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
</body>
</html>