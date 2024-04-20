<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
        <h1>게시글 수정페이지</h1>
        <form action="b_updateOK.do" method="post">
            <table id="insertTable">
                <tr>
                    <td><label for="">항목</label></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label for="board_num">글번호</label></td>
                    <td>${vo2.board_num}<input type="hidden" id="board_num" name="board_num" value="${param.board_num}"></td>
                </tr>
                <tr>
                    <td><label for="title">제목</label></td>
                    <td><input type="text" id="title" name="title" value="${vo2.title}" ></td>
                </tr>
                <tr>
                    <td><label for="content">내용</label></td>
                    <td><textarea name="content" id="content" cols="30" rows="10">${vo2.content}</textarea></td>
                </tr>
               <tr>
					<td><label for="nickname">작성자</label></td>
					<td>${vo2.nickname}<input type="hidden" id="nickname" name="nickname"
						value="${vo2.nickname}" placeholder="작성자"></td>
				</tr>
                <tr>
                    <td colspan="2"><input type="submit" value="글수정 완료"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>