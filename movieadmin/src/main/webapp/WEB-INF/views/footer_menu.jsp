<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            min-height: 100vh;
            flex-direction: column;
        }

        main {
            flex: 1;
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
            position: fixed;
            bottom: 0;
            left: 50%;
            transform: translateX(-50%);
            width: 100%;
        }
    </style>
</head>
<body>
    <main>
        <!-- Your main content here -->
    </main>
    <footer>
        <a href="about_us.do">이용약관</a>
        <a href="contact.do">개인정보처리방침</a>
        <a href="service_center.do">고객센터</a>
        <a href="advertisement.do">광고임대문의</a>
        <p>대표 전화번호: 02 - 0000 - 0000</p>
    </footer>
</body>
</html>
