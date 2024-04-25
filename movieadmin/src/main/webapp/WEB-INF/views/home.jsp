<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Home</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
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
</head>
<body>

	<div style="position: relative; z-index: 2;">
		<jsp:include page="top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">

		<section id="features">
			<div class="container">
				<div class="row">
					<div class="col-3 col-6-medium col-12-small">

						<!-- Feature #1 -->
						<section>
							<a href="#" class="bordered-feature-image"><img
								src="images/pic01.jpg" alt="" /></a>
							<h2>Welcome to Halcyonic</h2>
							<p>
								This is <strong>Halcyonic</strong>, a free site template by <a
									href="http://twitter.com/ajlkn">AJ</a> for <a
									href="http://html5up.net">HTML5 UP</a>. It's responsive, built
								on HTML5 + CSS3, and includes 5 unique page layouts.
							</p>
						</section>

					</div>
					<div class="col-3 col-6-medium col-12-small">

						<!-- Feature #2 -->
						<section>
							<a href="#" class="bordered-feature-image"><img
								src="images/pic02.jpg" alt="" /></a>
							<h2>Responsive You Say?</h2>
							<p>Yes! Halcyonic is built to be fully responsive so it looks
								great at every screen size, from desktops to tablets to mobile
								phones.</p>
						</section>

					</div>
					<div class="col-3 col-6-medium col-12-small">

						<!-- Feature #3 -->
						<section>
							<a href="#" class="bordered-feature-image"><img
								src="images/pic03.jpg" alt="" /></a>
							<h2>License Info</h2>
							<p>
								Halcyonic is licensed under the <a
									href="http://html5up.net/license">CCA</a> license, so use it
								for personal/commercial use as much as you like (just keep our
								credits intact).
							</p>
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

					</div>
				</div>
			</div>
		</section>

		<!-- Content -->
		<section id="content">
			<div class="container">
				<div class="row aln-center">
					<div class="col-4 col-12-medium">

						<!-- Box #1 -->
						<section>

							<a href="#" class="feature-image"><img src="images/pic05.jpg"
								alt="" /></a>
							<p>저희 사이트는 영화 정보사이트로 여러 사람들과 영화에 대한 생각을 자유롭게 공유할 수 있습니다</p>
						</section>

					</div>
					<div class="col-4 col-6-medium col-12-small">

						<!-- Box #2 -->
						<section>

							<ul class="check-list">
								<li>영화1</li>
								<li>영화2</li>
								<li>영화3</li>
								<li>영화4</li>
								<li>영화5</li>
							</ul>
						</section>

					</div>
					<div class="col-4 col-6-medium col-12-small">

						<!-- Box #3 -->
						<section>

							<ul class="quote-list">
								<li><img src="images/pic06.jpg" alt="사진1" />
									<p>1등</p></li>
								<li><img src="images/pic07.jpg" alt="사진2" />
									<p>2등</p></li>
								<li><img src="images/pic08.jpg" alt="사진3" />
									<p>3등</p></li>
							</ul>
						</section>

					</div>
				</div>
			</div>

		</section>

	</div>
	<div id="footer">
		<jsp:include page="footer_menu.jsp"></jsp:include>
	</div>
</body>
</html>

