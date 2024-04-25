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
        <h1>스토리 만들기</h1>
        <form action="s_insertOK.do" method="post" enctype="multipart/form-data">
        	<div class="table-wrapper">
            <table id="alt">
                <!-- <tr>
                    <td><label for="title">제목</label></td>
                    <td><input type = "text" id = "title" name ="title" ></td>
                </tr> -->
                
                <tr>
                    <td><label for="nickname">작성자</label></td>
                    <td>${nickname}<input type="hidden" id="nickname" name="nickname" value ="${nickname}"></td>
                </tr>

                <tr>
                    <td><label for="content">한줄평</label></td>
                    <td><textarea name="content" id="content" cols="30" rows="10" placeholder="한줄평을 입력하세요"></textarea></td>
                </tr>
                
                	<!--<tr>
                	 <td>
					<input type="file" name="file_img" accept="image/*" multiple>
					</td>
					<td>
					 <input type="file" name="file_video" accept="video/*" multiple>
					</td> 
					</tr>-->
				<tr>
					<td><input type="file" name="file" accept="image/*,video/*,audio/*" multiple></td>
				</tr>
				
               

                <tr>
                    <td colspan="2"><input type="submit" value="글쓰기 완료"></td>
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