<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성페이지</title>
   <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        #board {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        label {
            font-weight: bold;
        }

        input[type=text],
        textarea,
        input[type=file] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            display: block;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            margin-top: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <div id="board">
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
    </div>
</body>

</html>