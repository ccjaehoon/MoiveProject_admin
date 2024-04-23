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

        <h3>회원삭제폼</h3>

        <!-- <form action="#" method="post" enctype="multipart/form-data"> -->
        <form action="f_deleteOK.do" method="post">
        <div class="table-wrapper">
            <table class="alt">
                <tr>
                    <td><label for="faq_num">번호:</label></td>
                    <td>[${param.faq_num}] 번 글을 정말 삭제하시겠습니까?
                    	<input type="hidden" id="faq_num" name="faq_num" value="${param.faq_num}" placeholder="번호"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="글삭제"></td>
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