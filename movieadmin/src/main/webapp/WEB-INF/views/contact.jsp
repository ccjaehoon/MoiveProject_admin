<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보처리방침</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/noscript.css" />
<style>
	#navigation {
	  background-color: #f2f2f2;
	  overflow: hidden;
	}
	#navigation a {
	  float: left;
	  display: block;
	  color: black;
	  text-align: center;
	  padding: 14px 20px;
	  text-decoration: none;
	  font-size: 17px;
	}
	#navigation a:hover {
	  background-color: #ddd;
	  color: black;
	}
</style>
</head>
<body>
	<div style="position: relative; z-index: 2;">
		<jsp:include page="top_menu.jsp"></jsp:include>
	</div>
	
	<div id="main" style="position: relative; z-index: 1; margin-top: 10px;">
	<div id="navigation">
		<a href="${pageContext.request.contextPath}/about_us.do">이용약관</a>
		<a href="${pageContext.request.contextPath}/contact.do">개인정보처리방침</a>
		<a href="${pageContext.request.contextPath}/advertise.do">광고문의</a>
	</div>
		<br>
		<h2>개인정보처리방침</h2>
		<h3>제1조 (개인정보의 수집 및 이용목적)</h3>
		<p>회사는 다음의 목적을 위해 개인정보를 처리합니다:</p>
		<ul>
			<li>회원 가입 및 관리</li>
			<li>서비스 제공 및 운영</li>
			<li>고객 상담 및 불만 처리</li>
			<li>마케팅 및 광고에 활용</li>
		</ul>
		
		<h3>제2조 (수집하는 개인정보의 항목)</h3>
		<p>회사는 다음의 개인정보를 수집할 수 있습니다:</p>
		<ul>
			<li>이름</li>
			<li>이메일 주소</li>
			<li>전화번호</li>
			<li>주소</li>
			<li>기타 회원 가입 시 수집하는 정보</li>
		</ul>
		
		<h3>제3조 (개인정보의 보유 및 이용기간)</h3>
		<p>회사는 이용자의 개인정보를 이용목적을 달성한 후에는 지체 없이 파기합니다.</p>
		
	</div>
</body>
</html>


