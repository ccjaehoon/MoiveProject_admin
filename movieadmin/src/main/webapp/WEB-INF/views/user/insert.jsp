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

        #memberTable {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #memberTable td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #memberTable tr:nth-child(even) {
            background-color: #ebebeb;
        }

        #memberTable tr:hover {
            background-color: #ffc6c6;
        }

    </style>
</head>

<body>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <div>
        <h3>회원가입폼</h3>

        <form action="u_insertOK.do" method="post" enctype="multipart/form-data">
            <table id="memberTable">
                <tr>
                    <td><label for="user_id">아이디:</label></td>
                    <td><input type="text" id="user_id" name="user_id" value="" placeholder="아이디"></td>
                </tr>
                <tr>
                    <td><label for="password">비밀번호:</label></td>
                    <td><input type="password" id="password" name="password" value="" placeholder="비밀번호"></td>
                </tr>
                <tr>
                    <td><label for="nickname">별명:</label></td>
                    <td><input type="text" id="nickname" name="nickname" value="" placeholder="별명"></td>
                </tr>
                 <tr>
                    <td><label for="email">이메일:</label></td>
                    <td><input type="text" id="email" name="email" value="" placeholder="이메일"></td>
                </tr>
                <tr>
                    <td><label for="tel">전화번호:</label></td>
                    <td><input type="tel" id="tel" name="tel" value="010" placeholder="전화번호"></td>
                </tr>
                <tr>
                    <td><label for="birth">생년월일</label></td>
                    <td><input type="date" id="birth" name="birth" value=""></td>
                </tr>
                <tr>
					<td><label for="gender">성별:</label></td>
					<td><input type="radio" id="남자" name="gender" value="남자"
						${vo2.gender == '남자' ? 'checked' : ''}> <label for="남자">남자</label>
						<input type="radio" id="여자" name="gender" value="여자"
						${vo2.gender == '여자' ? 'checked' : ''}> <label for="여자">여자</label>
						<input type="radio" id="비공개" name="gender" value="비공개"
						${vo2.gender == '비공개' ? 'checked' : ''}> <label for="비공개">비공개</label>
					</td>
				</tr>
                

                <tr>
                    <td colspan="2"><input type="submit" value="회원가입"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>