<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<script src="https://apis.google.com/js/api.js"></script>
<script>
	// API 키
	var apiKey = 'AIzaSyAQKl4LzmCkMYJEgzTZsPkzgOGlLWZ8Q1w';

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
				<th colspan="4"><img src="resources/uploadimg/${vo2.save_img}" width="200"></th>
				<th colspan="3"><iframe id="trailerFrame" width="420" height="315"
						frameborder="0" allowfullscreen></iframe></th>
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
			</tr>
			<tr>
				<td>${vo2.genre}</td>
				<td>${vo2.directors}</td>
				<td>${vo2.actor}</td>
				<td>${vo2.showtime}</td>
				<td>${vo2.releaseDate}</td>
				<td>${vo2.companys}</td>
			</tr>

		</tbody>
	</table>
	<%--     <c:if test="${nickname == vo2.nickname }"> --%>
	<%-- 	    <a href="i_update.do?num=${vo2.num}">글수정</a> --%>
	<%-- 	    <a href="i_delete.do?num=${vo2.num}">글삭제</a> --%>
	<%--     </c:if> --%>
	<!--     <hr> -->
	<!--     <h3>댓글작성</h3> -->
	<!--     <form action="c_insertOK.do"> -->
	<!-- 	    <table id="customers"> -->
	<!-- 	        <thead> -->
	<!-- 	            <tr> -->
	<%-- 	                <th>댓글 내용 ${param.msg}</th> --%>
	<!-- 	                <th>댓글 작성자</th> -->
	<!-- 	                <th></th> -->
	<!-- 	            </tr> -->
	<!-- 	        </thead> -->
	<!-- 	        <tbody> -->
	<!-- 	        	<tr> -->
	<!-- 	        		<td><input type="text" name="content" value="hello" size="50"></td> -->
	<!-- 	        		<td> -->
	<%-- 	        			${user_id}<input type="hidden" name="writer" value="${user_id}"> --%>
	<%-- 	        			<input type="hidden" name="bnum" value="${vo2.num}"> --%>
	<!-- 	        		</td> -->
	<!-- 	        		<td><input type="submit"  value="댓글작성"></td> -->
	<!-- 	        	</tr> -->
	<!-- 	        </tbody> -->
	<!-- 	    </table> -->

	<!--     </form> -->
	<!--     <hr> -->
	<!--     <h3>댓글목록</h3> -->
	<!--     <table id="customers"> -->
	<!--         <thead> -->
	<!--             <tr> -->
	<!--                 <th>댓글 번호</th> -->
	<!--                 <th>댓글 내용</th> -->
	<!--                 <th>댓글 작성자</th> -->
	<!--                 <th>댓글 작성일자</th> -->
	<!--                 <th></th> -->
	<!--             </tr> -->
	<!--         </thead> -->
	<!--         <tbody> -->
	<%--         	<c:forEach var="cvo" items="${cvos}"> --%>
	<!--         	<tr> -->
	<%--                 <td>${cvo.num}</td> --%>
	<!--                 <td> -->
	<%--                 	${cvo.content} --%>
	<%--                 	<c:if test="${user_id == cvo.writer }"> --%>
	<!-- 	                	<form action="c_updateOK.do"> -->
	<%-- 							 <input type="text" name="content" value="${cvo.content}" > --%>
	<%-- 							 <input type="hidden" name="num" value="${cvo.num}">               	 --%>
	<%-- 							 <input type="hidden" name="bnum" value="${cvo.bnum}"> --%>
	<!-- 							 <input type="submit"  value="댓글수정">               	 -->
	<!-- 	                	</form> -->
	<%--                 	</c:if> --%>
	<!--                 </td> -->
	<%--                 <td>${cvo.writer}</td> --%>
	<%--                 <td>${cvo.wdate}</td> --%>
	<!--                 <td> -->
	<%--                 	<c:if test="${user_id == cvo.writer }"> --%>
	<%--                 		<a href="c_deleteOK.do?num=${cvo.num}&bnum=${cvo.bnum}">댓글삭제</a> --%>
	<%--                 	</c:if> --%>
	<!--                 </td> -->
	<!--             </tr> -->
	<%--         	</c:forEach> --%>

	<!--         </tbody> -->
	<!--     </table> -->


</body>
</html>