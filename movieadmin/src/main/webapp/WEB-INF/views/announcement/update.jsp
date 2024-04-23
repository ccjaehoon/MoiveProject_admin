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

<body>
   
    <div id ="main">
     <jsp:include page="../top_menu.jsp"></jsp:include>
        <h3>게시글 수정하기</h3>
        <form action="a_updateOK.do" method="post" enctype="multipart/form-data">
            <table id="insertTable">
                <tr>
                    <td><label for="">항목</label></td>
                    <td>입력</td>
                </tr>
                <tr>
                    <td><label for="announcement_num">글번호</label></td>
                    <td>${param.announcement_num}<input type="hidden" id="announcement_num" name="announcement_num" value="${param.announcement_num}"></td>
                </tr>
                <tr>
                    <td><label for="title">제목</label></td>
                    <td>${param.title}<input type="text" id="title" name="title" value="${vo2.title}" ></td>
                </tr>
                <tr>
                    <td><label for="content">내용</label></td>
                    <td>${param.content}<textarea name="content" id="content" cols="30" rows="10">${vo2.content}</textarea></td>
                </tr>
              
               <tr>
                    <td><label for="file_img">올릴 이미지:</label></td>
                    <td><input type="file" id="file_img" name="file_img"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="글수정 완료"></td>
                </tr>
            </table>
        </form>
    </div>
    <jsp:include page="../footer_menu.jsp"></jsp:include>
</body>

</html>