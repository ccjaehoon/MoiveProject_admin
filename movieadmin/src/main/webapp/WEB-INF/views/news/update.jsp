<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뉴스 수정 페이지</title>
    <style>
        input[type=text],
        textarea,
        select {
            width: 100%;
            padding: 8px 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ff8f8f;
            border-radius: 14px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 30%;
            background-color: #4CAF50;
            color: white;
            padding: 8px 8px;
            margin: 8px 0;
            border: none;
            border-radius: 14px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #b7e5b9;
        }

        div {
            border-radius: 15px;
            background-color: #f0f0f0;
            padding: 20px;
        }

        #insertTable {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #insertTable td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #insertTable tr:nth-child(even) {
            background-color: #ebebeb;
        }

        #insertTable tr:hover {
            background-color: #ffc6c6;
        }
    </style>
</head>

<body>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <div>
        <h1>뉴스 수정페이지</h1>
        <form action="n_updateOK.do" method="post" enctype="multipart/form-data">
            <table id="insertTable">
                <tr>
                    <td><label for="">항목</label></td>
                    <td>입력</td>
                </tr>
                <tr>
                    <td><label for="news_num">뉴스번호</label></td>
                    <td>${param.news_num}<input type="hidden" id="news_num" name="news_num" value="${param.news_num}"></td>
                </tr>
                <tr>
                    <td><label for="title">제목</label></td>
                    <td><input type="text" id="title" name="title" value="${vo2.title}" placeholder="제목을 입력하세요"></td>
                </tr>
                <tr>
                    <td><label for="content">내용</label></td>
                    <td><textarea name="content" id="content" cols="30" rows="10">${vo2.content}</textarea></td>
                </tr>
                <tr>
                    <td><label for="nickname">작성자</label></td>
                    <td>${vo2.nickname}<input type="hidden" id="nickname" name="nickname" value="${user_id}"></td>
                </tr>
                <tr>
                    <td><label for="file_img">이미지파일</label></td>
                    <td><input type="file" id="file_img" name="file_img"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="글수정 완료"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>