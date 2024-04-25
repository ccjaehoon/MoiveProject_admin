<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
</head>

<body>
    <div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>
<<<<<<< HEAD
        <h1>게시글 수정페이지</h1>
        <form action="s_updateOK.do" method="post" enctype="multipart/form-data">
=======
        <h2>게시글 수정페이지</h2>
        <form action="s_updateOK.do" method="post">
>>>>>>> branch 'main' of https://github.com/ccjaehoon/MoiveProject_admin.git
            <div class="table=wrapper">
			<table id=alt>
              
                <tr>
                    <td><label for="story_num">글번호</label></td>
                    <td colspan="2">${param.story_num}<input type="hidden" id="story_num" name="story_num" value="${param.story_num}"></td>
                </tr>
                
                <%-- 
                <tr>
                    <td><label for="title">제목</label></td>
                    <td><input type="text" id="title" name="title" value="${vo2.title}" placeholder="제목을 입력하세요"></td>
                </tr>
                 --%>
                 
                <tr>
                    <td><label for="nicname">작성자</label></td>
					<td>${param.nickname}<input type="hidden" id="nickname" name="nickname" value="${vo2.nickname}" placeholder="작성자"></td>
				</tr>
    
                 
                <tr>
                    <td colspan="1"><label for="content">내용</label></td>
                    <td><textarea name="content" id="content" cols="30" rows="10">${vo2.content}</textarea></td>
                </tr>

                <tr>
	                <td><label for="file">파일</label></td>
				    
					<td><input type="file" name="file"  id="file" accept="image/*,video/*,audio/*" multiple></td>
		
				</tr>
                
                <tr>
                    <td colspan="2"><input type="submit" value="글수정 완료"></td>
                </tr>
            </table>
            </div>
        </form>
    </div>
    <div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>

</html>