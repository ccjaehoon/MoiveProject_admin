<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">

<style>
#main {
	margin-top: 100px; /* 탑 메뉴의 높이만큼 상단 마진 추가 */
}

#top-menu {
	position: fixed; /* 화면에 고정 */
	top: 0; /* 화면 상단에 위치 */
	left: 0; /* 화면 왼쪽에 위치 */
	width: 100%; /* 전체 너비로 확장 */
	background-color: #fff; /* 배경색 지정 */
	z-index: 1000; /* 다른 요소 위에 표시 */
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
}

#footer1 {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #fff;
	z-index: 1000;
	box-shadow: 0 -2px 5px rgba(0, 0, 0, 0.2);
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script>
	$(document).ready(function() {
		$('.bxslider').bxSlider(); // ul에 있는 class명을 기준으로 선언을 합니다. 즉, 이미지구성요소들을 감싸고있는 객체에 선언해 줍니다. 
	});
</script>

</head>
<body>

	<div style="position: relative; z-index: 2;">
		<jsp:include page="top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<section id="features">
			<form action="i_selectAll.do">
				<div class="container">
					<div class="row">
						<div class="col-3 col-6-medium col-12-small">
							<section>
								<ul class="bxslider" style="width: 200%;">
									<c:forEach var="ivo" items="${ivos}">
										<li><span style="float: left;"> <a
												href="i_selectOne.do?info_num=${ivo.info_num}">${ivo.title}</a>
										</span> <br /> <img src="resources/uploadimg/${ivo.save_img}"
											width="200" /></li>
									</c:forEach>
								</ul>
							</section>
						</div>
					</div>
					<%-- <div class="col-3 col-6-medium col-12-small">

						<!-- Feature #2 -->
						<section>
							<table class="alt">
								<c:forEach var="ivo" items="${ivos}">
									<tr>
										<td><span style="float: left;"><a href="i_selectOne.do?info_num=${ivo.info_num}">${ivo.title}</a></span></td>
									</tr>
									<tr>
										<td><img src="resources/uploadimg/${ivo.save_img}" width="300" /></td>
									</tr>
								</c:forEach>
							</table>
						</section>

					</div>
					<div class="col-3 col-6-medium col-12-small">

						<!-- Feature #3 -->
						<section>
							<a href="#" class="bordered-feature-image"><img
								src="images/pic03.jpg" alt="" /></a>
							<h2>License Info</h2>
						</section>

					</div>
					<div class="col-3 col-6-medium col-12-small">

						<!-- Feature #4 -->
						<section>
							<a href="#" class="bordered-feature-image"><img
								src="images/pic04.jpg" alt="" /></a>
							<h2>Volutpat etiam aliquam</h2>
							<p>Duis neque nisi, dapibus sed mattis quis, rutrum accumsan
								sed. Suspendisse eu varius nibh. Suspendisse vitae magna mollis.
							</p>
						</section>
						
					</div> --%>
				</div>
			</form>
		</section>
		<section id="content">
			<div class="container">
				<div class="row aln-center">
					<div class="col-4 col-12-medium">
						<section>
							<span style="float: left;">최신글</span> <span style="float: right;"><a
								href="b_selectAll.do">+더보기</a></span>
							<table class="alt" style="width: 100%; table-layout: fixed;">
								<c:forEach var="bvo" items="${bvos}">
									<tr>
										<td style="padding: 5px;"><a
											href="b_selectOne.do?board_num=${bvo.board_num}&nickname=${bvo.nickname}">${bvo.title}</a></td>
									</tr>
								</c:forEach>
							</table>
						</section>

					</div>
					<div class="col-4 col-6-medium col-12-small">
						<!-- Box #2 -->
						<section>
							<span style="float: left">최신 개봉 영화</span> <span
								style="float: right"> <a href="i_selectAll.do">+더보기</a>
							</span>

							<table class="alt">
								<c:forEach var="vo" items="">
									<tr>
										<td align="center"><a
											href="i_selectOne.do?info_num=${ivo.info_num}"> <img
												src="resources/uploadimg/${ivo.save_img}" width="100">
										</a></td>

									</tr>
								</c:forEach>
							</table>
						</section>
					</div>
					<div class="col-4 col-6-medium col-12-small">

						<!-- Box #3 -->
						<section>
							<span style="float: left;">공지사항</span> <span
								style="float: right;"><a href="a_selectAll.do">+더보기</a></span>
							<table class="alt" style="width: 100%; table-layout: fixed;">
								<c:forEach var="avo" items="${avos}">
									<tr>
										<td align="center" style="padding: 5px;"><a
											href="a_selectOne.do?announcement_num=${avo.announcement_num}&nickname=${avo.nickname}">${avo.title}</a></td>
									</tr>
								</c:forEach>
							</table>
						</section>

					</div>
				</div>
			</div>

		</section>
		<!-- Content2 -->
		<section id="content2">
			<div class="container2">
				<div class="row aln-center2">
					<div class="col-4 col-12-medium2">
						<!-- 스토리 Box #1 -->
						<section>
							<span style="float: left;">스토리</span> <span style="float: right;"><a
								href="s_selectAll.do">+더보기</a></span>
							<table class="alt" style="width: 100%; table-layout: fixed;">

								<c:forEach var="svo" items="${svos}">
									<tr>
										<td align="center"><a
											href="s_selectOne.do?story_num=${vo2.story_num}&nickname=${svo.nickname}">
												<img src="resources/uploadimg/images/thumb_${svo.save_img}"
												alt="스토리 사진"> <img
												src="resources/uploadimg/videos/thumb_${svo.save_video}"
												alt="스토리 동영상 썸네일">
										</a></td>
									</tr>
								</c:forEach>
							</table>
						</section>
					</div>
					<!-- 추가적인 열(column) 요소 추가 가능 -->
				</div>
			</div>
		</section>
	</div>
	<div id="footer">
		<jsp:include page="footer_menu.jsp"></jsp:include>
	</div>
</body>
</html>

