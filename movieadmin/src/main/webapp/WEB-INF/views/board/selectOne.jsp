<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {

		console.log("jquery test");
		console.log($(".b_increaseGood"));
		$(".b_increaseGood").click(function(item) {
			console.log("increaseGood Click");
			console.log('${vo2.board_num}');
			console.log('${nickname}');
			console.log('${vo2.good}');
			$.ajax({
				url : "http://localhost:8070/movie/b_increaseGood.do",
				type : "get",
				data : {
					board_num : $("#board_num").val(),
					nickname : $("#nickname").val(),
					good : $("#good").val()
				},
				dataType : "json",
				success : function(obj) {
					console.log(obj);
					let good = obj.good;
					item.value = good;
					location.reload();
				},
				error : function(xhr, status) {
					console.log("status...", status);
				}
			});
			return false;
		});

		$(".c_increaseGood").each(function(index, item) {//console.log(index);
			$(this).click(function() {
				console.log("increaseGood Click");
				console.log($("#comments_num" + index).val());
				console.log($("#good" + index).val());

				$.ajax({
					url : "http://localhost:8070/movie/c_increaseGood.do",
					type : "get",
					data : {
						comments_num : $("#comments_num" + index).val(),
						board_num : $("#board_num").val(),
						nickname : $("#nickname" + index).val(),
						good : $("#good" + index).val()
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
	
	function closeReportDialog() {
	    $("#report").dialog("close");
	}

	function closeReportDialogC() {
	    $("#reportC").dialog("close");
	}
</script>

<script>
	$(function() {
		$("#reportC").dialog({
			autoOpen : false
		});
	});

	function showDialogReportC(comments_num, nickname) {
		console.log(comments_num);
		console.log(nickname);
		$('#comments_num').val(comments_num);
		$('#nicknameC').val(nickname);
		$("#reportC").dialog("open");
	}
</script>
<style>
#report, #reportC  {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 1000;
  background-color: white;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
}

#rp {
  width: 100%;
  border-collapse: collapse;
}

#rp td {
  padding: 10px;
}

#font {
  font-weight: bold;
}

#text_report {
  width: 100%;
  height: 100px;
}

.report {
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.report:hover {
  background-color: #0056b3;
}

</style>
</head>
<body>
	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>
		<h2>글정보</h2>
		
			<table class="alt">
				<tbody>
					<tr>
						<td id="boardR" width = "7%">번호</td>
						<td>${vo2.board_num}</td>
						<td id="boardR" width = "10%">작성자</td>
						<td width = "10%">${vo2.nickname}</td>	
						<td width = "10%">작성일자</td>
						<td>${vo2.wdate}</td>				
					</tr>
					<tr>
						<td id="boardR">제목</td>
						<td colspan="5">${vo2.title}</td>
					</tr>
				
					<td align="left" colspan="6"><img
						src="resources/uploadimg/${vo2.save_img}" width="300"> <br>
						${vo2.content}</td>
					</tr>
				
				</tbody>

				<tbody>

						<tr >
							<td colspan = "5">
								<input type="hidden" name="board_num" value="${vo2.board_num}" id="board_num">
								<input type="hidden" name="good" value="${vo2.good}" id="good">
								<input type="hidden" name="nickname" value="${vo2.nickname}" id="nickname">
								<input type="button" value="추천 ${vo2.good}" class="b_increaseGood">
							
								<input type="button" id="reportBtn" class="report"
									onClick="showDialogReport('${vo2.board_num}','${nickname}')" value="신고"/>
							</td>
							<c:if test="${nickname == vo2.nickname}">
								<td  align = "right"><a href="b_update.do?board_num=${param.board_num}&nickname=${param.nickname}">글수정</a>
								<a href="b_delete.do?board_num=${param.board_num}">글삭제</a></td>
							</c:if>
						</tr>

				</tbody>
			</table>
		
		<hr>
		<h3>댓글작성</h3>
		<form action="c_insertOK.do">
			<div class="table-wrapper">
				<table id="alt">
					<thead>
						<tr>
							<th>댓글 내용${param.msg}</th>
							<th>댓글 작성자</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" name="content" value="hello"
								size="50"></td>
							<td>${nickname}<input type="hidden" name="nickname"
								value="${nickname}"> <input type="hidden"
								name="board_num" value="${vo2.board_num}">
							</td>
							<td><input type="submit" value="댓글작성"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
		<hr>
		<h3>댓글목록</h3>
		<div class="table-wrapper">
			<table id="alt">
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
										<input type="hidden" name="comments_num"
											value="${cvo.comments_num}">
										<input type="hidden" name="board_num" value="${cvo.board_num}">
										<input type="submit" value="수정">
									</c:if>
								</form>
							</td>
							<td>${cvo.nickname}<input type="hidden" name="nickname"
								value="${nickname}" id="nickname${vs.index}">
							</td>
							<td><input type="hidden" name="comments_num"
								value="${cvo.comments_num}" id="comments_num${vs.index}">
								<input type="hidden" name="board_num" value="${vo2.board_num}"
								id="board_num"> <input type="hidden" name="good"
								value="${cvo.good}" id="good${vs.index}"> <input
								type="button" value="${cvo.good}" class="c_increaseGood">
							</td>
							<td>${cvo.wdate}</td>
							<td><input type="button" id="reportBtn" class="report"
								onClick="showDialogReportC('${cvo.comments_num}','${nickname}')"
								value="신고" /></td>
							<td><c:if test="${nickname == cvo.nickname}">
									<a
										href="c_deleteOK.do?comments_num=${cvo.comments_num}&board_num=${cvo.board_num}">댓글삭제</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>

	<div id="report" style="position: relative; z-index: 2;">
		<form id="reportForm" action="rp_insertOK.do" method="post">
			<table id="rp" border="2">
				<tr>
					<td id="font" width="100">신고 내용 <input type="text"
						id="nickname" name="nickname" value="${vo2.nickname}" readonly>
						<input type="text" id="board_num" name="board_num"
						value="${vo2.board_num}" readonly>
					</td>
				</tr>
				<tr>
					<td width="500"><textarea id="text_report" name="content"
							placeholder="신고내용을 적으세요"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="신고접수"

						class="report">
						 <button type="button" onclick="closeReportDialog()">닫기</button>
					</td>
					

				</tr>
			</table>
		</form>
	</div>
	<div id="reportC" style="position: relative; z-index: 2;">
		<form id="reportFormC" action="rp_insertOK.do" method="post">
			<table id="rp" border="2">
				<tr>
					<td id="font" width="100">신고 내용 <input type="text"
						id="nicknameC" name="nickname" value="${cvo.nickname}" readonly>
						<input type="text" id="comments_num" name="comments_num"
						value="${cvo.comments_num}" readonly> <input type="hidden"
						id="board_num" name="board_num" value="${vo2.board_num}">
					</td>
				</tr>
				<tr>
					<td width="500"><textarea id="text_report" name="content"
							placeholder="신고내용을 적으세요"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="신고접수"

						class="reportC">
						 <button type="button" onclick="closeReportDialogC()">닫기</button>
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
		$("#reportFormC").submit(function(event) {
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