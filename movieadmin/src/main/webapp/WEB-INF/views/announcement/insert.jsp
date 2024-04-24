<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
  
</head>

<body class="is-preload">
   
<div style="position: relative; z-index: 2;">
    <jsp:include page="../top_menu.jsp"></jsp:include>
</div>
<div id="main" style="position: relative; z-index: 1;">
<br>
        <h3>공지사항 작성하기</h3>
        <form action="a_insertOK.do" method="post" enctype="multipart/form-data">
            <table class="alt">
               
                <tr>
                    <td><label for="title">제목 :</label></td>
                    <td><input type="text" id="title" name="title" value="제목" placeholder="제목을 입력하세요"></td>
                </tr>
                 <tr>
					<td><label for="nickname">이름 :</label></td>
					<td>${nickname}<input type="hidden" id="nickname"
						name="nickname" value="${nickname}" ></td>
				</tr>
                <tr>
                    <td><label for="content">내용 :</label></td>
                    <td><textarea name="content" id="content" cols="30" rows="10">공지사항을 적으세요</textarea></td>
                </tr>
                 <tr>
                    <td><label for="file_img">올릴 이미지 :</label></td>
                    <td><input type="file" id="file_img" name="file_img"></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="글쓰기 완료"></td>
                </tr>
            </table>
        </form>
    </div>
  <div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
		</div>
</body>

</html>