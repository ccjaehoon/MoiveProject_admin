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
        <h1>스토리 만들기</h1>
        <form action="s_insertOK.do" method="post">
            <table id="insertTable">
                <tr>
                    <td><label for="">항목</label></td>
                    <td>입력</td>
                </tr>
                
                <tr>
                    <td><label for="writer">작성자</label></td>
                    <td>${user_id}<input type="hidden" id="writer" name="writer" value="${user_id}"></td>
                </tr>

                <tr>
                    <td><label for="content">한줄평</label></td>
                    <td><textarea name="content" id="content" cols="30" rows="10" placeholder="한줄평을 입력하세요"></textarea></td>
                </tr>
                
				<tr>
				    <td><input type="file" name="file_img"></td>
				    <td><input type="file" name="file_video"></td>
				    <td><input type="submit" value="글수정 완료"></td>
				</tr> 
               

                <tr>
                    <td colspan="2"><input type="submit" value="글쓰기 완료"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>