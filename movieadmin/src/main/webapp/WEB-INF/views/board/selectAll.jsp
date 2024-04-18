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
input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 15px;
	background-color: #bfbfbf;
	padding: 20px;
}

#Table {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#Table td, #Table th {
	border: 1px solid #ddd;
	padding: 8px;
}

#Table tr:nth-child(even) {
	background-color: #ff6565;
}

#Table tr:hover {
	background-color: #fca2a2;
}

#Table th {
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
<script type="text/javascript">
$(function() {
	console.log("jquery test");
	console.log($(".b_increaseGood"));
	$(".b_increaseGood").each(function(index,item){//console.log(index);
		$(this).click(function() {
			
			console.log("increaseGood Click");
			console.log($("#board_num"+index).val());
			console.log($("#good"+index).val());
			
			$.ajax({
				url : "http://localhost:8070/movie/b_increaseGood.do",
				type : "get",
				data : {
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
<script>
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
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div>
		<h1>글목록</h1>
		<hr>
		<form action="b_searchList.do">
			<select name="searchKey">
				<option value="title">title</option>
				<option value="content">content</option>
			</select> <input type="text" name="searchWord" value="ja"> <input
				type="submit" value="search">

		</form>
		<table id="Table">
			<thead>
				<tr>
					<th>번호</th>
					<th>썸네일</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th>좋아요</th>
					<th>신고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos}">
					<tr>
						<td><a href="b_selectOne.do?board_num=${vo.board_num}">${vo.board_num}</a></td>
						<td><img alt="" src="resources/uploadimg/thumb_${vo.save_img}"></td>
						<td>${vo.title}</td>
						<td>${vo.nickname}</td>
						<td>${vo.wdate}</td>
						<td>
							<input type="hidden" name="board_num" value="${cvo.board_num}"  id="board_num${vs.index}">
							<input type="hidden" name="good" value="${cvo.good}" id="good${vs.index}">
							<input type="button" value="${cvo.good}" class="b_increaseGood">
						</td>
						<td>
						<input type="button" id="reportBtn" class="report"
						onClick="showDialogReport('${cvo.board_num}','${cvo.nickname}')" value="신고" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6"><c:forEach var="i" begin="1"
							end="${totalPageCount}">
							<c:if test="${param.searchKey == null}">
								<a href="b_selectAll.do?cpage=${i}">${i} &nbsp;</a>
							</c:if>
							<c:if test="${param.searchKey != null}">
								<a
									href="b_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i}
									&nbsp;</a>
							</c:if>
						</c:forEach></td>
				</tr>
			</tfoot>
		</table>
	<a href="b_insert.do">글쓰기</a>
	</div>
	
	<div id="report">

		<form id="reportForm" action="rp_insertOK.do" method="post">
			<table id="rp" border="2">
				<tr>
					<td id="font" width="100">신고 내용<input type="text"
						id="nickname" name="nickname" value="${cvo.nickname}" readonly>
						<input type="text" id="board_num" name="board_num"
						value="${cvo.board_num}" readonly></td>
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