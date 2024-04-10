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
        input[type=password],
        input[type=tel],
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
            background-color: #45a049;
        }

        div {
            border-radius: 15px;
            background-color: #bfbfbf;
            padding: 20px;
        }

        #announcementTable {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #announcementTable td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #announcementTable tr:nth-child(even) {
            background-color: #ebebeb;
        }

        #announcementTable tr:hover {
            background-color: #ffc6c6;
        }

    </style>
</head>

<body>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <div>
        <h3>회원삭제폼</h3>

        <!-- <form action="#" method="post" enctype="multipart/form-data"> -->
        <form action="a_deleteOK.do" method="post">
            <table id="announcementTable">
                <tr>
                    <td><label for="announcement_num">번호:</label></td>
                    <td>[${param.announcement_num}] 번 글을 정말 삭제하시겠습니까?
                    	<input type="hidden" id="announcement_num" name="announcement_num" value="${param.announcement_num}" placeholder="번호"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="글삭제"></td>
                </tr>
            </table>
        </form>
    </div>
    <jsp:include page="../footer_menu.jsp"></jsp:include>
</body>

</html>