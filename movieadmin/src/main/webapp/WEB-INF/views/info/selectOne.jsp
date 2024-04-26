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
				console.log($("#nicknameF").val());

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
	$(function() {
		$("#report").dialog({
			autoOpen : false
		});
	});
	function closeReportDialog() {
	    $("#report").dialog("close");
	}

	// 	});

	function showDialogReport(review_num, nickname, info_num) {
		console.log(review_num);
		console.log(nickname);
		console.log(info_num);
		$('#review_num').val(review_num);
		$('#nickname').val(nickname);
		$('#info_numR').val(info_num);
		$("#report").dialog("open");
	}
</script>
<script src="https://apis.google.com/js/api.js"></script>
<script>
	// API 키
		var apiKey = 'AIzaSyAQKl4LzmCkMYJEgzTZsPkzgOGlLWZ8Q1w';
//	var apiKey = 'AIzaSyA2_FqIb29PSrabB5sVlRYChqGo2iMRUzU';

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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
<style>
#report, #reportC {
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
		<h2>${vo2.title}</h2>
		<table id="customers">
			<thead>
				<tr>
					<th><img src="resources/uploadimg/${vo2.save_img}"
						style="width: 60%; height: auto;"></th>
					<th align="right"><iframe id="trailerFrame" style="width: 100%; height: 300px; frameborder="0" allowfullscreen
								></iframe></th>
				</tr>
			</thead>
			<tbody>
				<tr>

					<td colspan="7">${vo2.content}</td>

				</tr>
				<tr>
					<td>장르</td>
					<td colspan="5">${vo2.genre}</td>
				</tr>
				<tr>
					<td>감독</td>
					<td colspan="5">${vo2.directors}</td>
				</tr>
				<tr>
					<td>배우</td>
					<td colspan="5">${vo2.actor}</td>
				</tr>
				<tr>
					<td>상영시간(분)</td>
					<td colspan="5">${vo2.showtime}</td>
				</tr>
				<tr>
					<td>출시일</td>
					<td colspan="5">${vo2.releaseDate}</td>
				</tr>
				<tr>
					<td>제작사</td>
					<td colspan="5">${vo2.companys}</td>
				</tr>
				<tr>
					<td>글 조회수</td>
					<td>${vo2.views}</td>
					<td><input type="hidden" name="info_num"
						value="${vo2.info_num}" id="info_num"> <input
						type="hidden" name="nickname" value="${nickname}" id="nicknameF">
					</td>
					<td style="text-align: right; vertical-align: middle;"><input
						type="submit" value="즐겨찾기" class="i_favorite"></td>

				</tr>
				<tr>
					<c:if test="${authority == 'admin'}">
                        <td colspan="5">
                            <form action="i_update.do" method="GET"
                                style="text-align: center;">
                                <input type="hidden" name="info_num" value="${vo2.info_num}">
                                <input type="submit" value="영화 수정">
                            </form>
                        </td>
                    </c:if>
				</tr>
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
		<h3>리뷰 목록</h3>
		<table id="customers">
			<thead>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>작성자</th>

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
									<input type="hidden" name="review_num"
										value="${ivo.review_num}">
									<input type="hidden" name="info_num" value="${ivo.info_num}">
									<input type="submit" value="수정">
								</c:if>

							</form>
						</td>

						<td>${ivo.nickname}<input type="hidden" name="nickname"
							value="${nickname}" id="nickname${vs.index}"></td>



						<td><input type="button" id="reportBtn" class="report"
							onClick="showDialogReport('${ivo.review_num}','${nickname}','${vo2.info_num}')"
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
	</div>

	<div id="report" class="table=wrapper"
		style="position: relative; z-index: 2;">

		<form id="reportForm" action="rp_insertOK.do" method="post">
			<table id="rp" border="2">
				<tr>
					<td id="font" width="100">신고 내용<input type="text"
						id="nickname" name="nickname" value="${nickname}" readonly>
						<input type="text" id="review_num" name="review_num" readonly>
						<input type="hidden" id="info_numR" name="info_num"></td>
				</tr>
				<tr>
					<td><textarea id="text_report" name="content"
							placeholder="신고내용을 적으세요">test report</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="신고접수"
						class="report">
						<button type="button" onclick="closeReportDialog()">닫기</button></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
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