<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/noscript.css" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성페이지</title>
</head>
<body>
<div id="main">
    <jsp:include page="../top_menu.jsp"></jsp:include>
        <h1>게시글 작성페이지</h1>
        <form id="boardForm" action="b_insertOK.do" method="post" enctype="multipart/form-data">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" value="title" placeholder="제목을 입력하세요">
            <label for="content">내용</label>
            <textarea name="content" id="content" cols="30" rows="10">내용</textarea>
            <label for="nickname">작성자</label>
            <input type="hidden" id="nickname" name="nickname" value="${nickname}">
            <label for="file_img">이미지파일</label>
            <input type="file" id="file_img" name="file_img">
            <input type="submit" value="글쓰기 완료">
        </form>
	<jsp:include page="../footer_menu.jsp"></jsp:include>
</div>
</body>

</html>