<!DOCTYPE html>
<html lang="en">

<head>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

</head>
<body>
<div class="card o-hidden border-0 shadow-lg my-5">
        
               
                    
                           <div class="jumbotron">
  <h2> 임시 비밀번호가 전송되었습니다. </h2><br/>
  		
  	<h1>${email}</h1><br/>
  	<h2>를 확인해주세요.</h2>
  <button type="button" class="btn btn-primary" onclick="location.href='/member/loginView'">로그인페이지</button>
  <button type="button" class="btn btn-primary" onclick="location.href='/board/list'">메인페이지</button>
  
  </div>
</div>
</body>
</html>