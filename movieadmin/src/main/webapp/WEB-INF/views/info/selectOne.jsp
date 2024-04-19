<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("jquery test");
		console.log($(".i_favorite"));
		$(".i_favorite").each(function(index, item) {//console.log(index);
			$(this).click(function() {
				console.log("favorite Click");
				console.log($("#info_num").val());
				console.log($("#nickname").val());

				$.ajax({
					url : "http://localhost:8070/movie/i_favorite.do",
					type : "get",
					data : {
						info_num : $("#info_num").val(),
						nickname : $("#nickname").val()
					},
					dataType : "json",
					success : function(obj) {
						console.log(obj);
						let good = obj.good;
						//console.log(item);
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
	// 	$(function() {
	// 		console.log("jquery test");
	// 		console.log($(".report"));
	// 		$(".report").each(function(index, item) {
	// 			//			console.log(index);

	// 			$(this).click(function() {
	// 				console.log("report Click");
	// 				$("#report").dialog("open");

	// 			});
	// 		});

	$(function() {
		$("#report").dialog({
			autoOpen : false
		});
	});

	// 	});

	function showDialogReport(review_num, nickname) {
		console.log(review_num);
		console.log(nickname);
		$('#review_num').val(review_num);
		$('#nickname').val(nickname);
		$("#report").dialog("open");
	}
</script>
<script src="https://apis.google.com/js/api.js"></script>
<script>
	// API 키
	// 	var apiKey = 'AIzaSyAQKl4LzmCkMYJEgzTZsPkzgOGlLWZ8Q1w';
	var apiKey = 'AIzaSyA2_FqIb29PSrabB5sVlRYChqGo2iMRUzU';

	// YouTube API 클라이언트 초기화
	function init() {
		gapi.client
				.init(
						{
							'apiKey' : apiKey,
							'discoveryDocs' : [ 'https://www.googleapis.com/discovery/v1/apis/youtube/v3/rest' ],
						}).then(function() {

					// YouTube Data API 사용 준비 완료
					searchForTrailer();

				});
	}

	function searchForTrailer() {

		var request = gapi.client.youtube.search.list({

			part : 'snippet',
			q : "${vo2.title} 예고편", // 검색어 설정 (예: 파묘)
			type : 'video',
			maxResults : 1
		// 검색 결과 수
		});

		request.execute(function(response) {
			var videoId = response.result.items[0].id.videoId;
			var trailerUrl = 'https://www.youtube.com/embed/' + videoId;
			document.getElementById('trailerFrame').src = trailerUrl;
		});
	}

	// API 로드
	gapi.load('client', init);
</script>
<script src="https://apis.google.com/js/client.js?onload=init"></script>
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
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h1>글정보</h1>
	<hr>
	<table id="customers">
		<thead>
			<tr>
				<th colspan="3"><img src="resources/uploadimg/${vo2.save_img}"
					width="200"></th>
				<th colspan="5"><iframe id="trailerFrame" width="420"
						height="315" frameborder="0" allowfullscreen></iframe></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${vo2.title}</td>
				<td colspan="6">${vo2.content}</td>
			</tr>
			<tr>
				<td>장르</td>
				<td>감독</td>
				<td>배우</td>
				<td>상영시간(분)</td>
				<td>출시일</td>
				<td>제작사</td>
				<td>글 조회수</td>
				<td>즐겨찾기</td>
			</tr>
			<tr>
				<td>${vo2.genre}</td>
				<td>${vo2.directors}</td>
				<td>${vo2.actor}</td>
				<td>${vo2.showtime}</td>
				<td>${vo2.releaseDate}</td>
				<td>${vo2.companys}</td>
				<td>${vo2.views}</td>
				<td><input type="hidden" name="info_num"
					value="${vo2.info_num}" id="info_num"> <input type="hidden"
					name="nickname" value="${nickname}" id="nickname"> <input
					type="button" value="즐겨찾기" class="i_favorite"></td>
			</tr>

		</tbody>
	</table>

	<h3>리뷰작성</h3>
	<form action="rv_insertOK.do">
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
						value="${nickname}"> <input type="hidden" name="info_num"
						value="${vo2.info_num}">
					</td>
					<td><input type="submit" value="댓글작성"></td>
				</tr>
			</tbody>
		</table>

	</form>
	<hr>
	<h3>리뷰 목록</h3>
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
			<c:forEach var="ivo" items="${ivos}" varStatus="vs">

				<tr>
					<td>${ivo.review_num}</td>
					<td>${ivo.content}
						<form action="rv_updateOK.do">
							<c:if test="${nickname == ivo.nickname}">
								<input type="text" name="content" value="${ivo.content}">
								<input type="hidden" name="review_num" value="${ivo.review_num}">
								<input type="hidden" name="info_num" value="${ivo.info_num}">
								<input type="submit" value="수정">
							</c:if>

						</form>
					</td>

					<td>${ivo.nickname}<input type="hidden" name="nickname"
						value="${nickname}" id="nickname${vs.index}"></td>

					<td><input type="hidden" name="review_num"
						value="${ivo.review_num}" id="review_num${vs.index}"> <input
						type="hidden" name="info_num" value="${vo2.info_num}"
						id="info_num"> <input type="hidden" name="good"
						value="${ivo.good}" id="good${vs.index}"> <input
						type="button" value="${ivo.good}" class="rv_increaseGood"></td>
					<td>${ivo.wdate}</td>

					<td><input type="button" id="reportBtn" class="report"
						onClick="showDialogReport('${ivo.review_num}','${ivo.nickname}')"
						value="신고" /></td>

					<td><c:if test="${nickname == ivo.nickname}">
							<a
								href="rv_deleteOK.do?review_num=${ivo.review_num}&info_num=${ivo.info_num}">리뷰
								삭제</a>
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
						<input type="text" id="review_num" name="review_num"
						value="${ivo.review_num}" readonly></td>
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