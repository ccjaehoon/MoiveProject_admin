<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	function selectCommentList(board_num){
		console.log("selectCommentList()...",board_num);
		
		$.ajax({
			url:"http://localhost:8070/movie/api/selectCommentList.do",
			type:"get",
			data:{board_num:board_num},
			dataType:"json",
			success:function(arr){
				console.log(arr);
				let data = '';
				arr.forEach(function(item){
					console.log(item);
					
					data += `<tr>
						<td>\${item.comments_num}</td>
						<td>\${item.nickname}</td>
						<td>\${item.content}</td>
						<td>\${item.good}</td>
						<td>\${item.report}</td>
						<td>\${item.wdate}</td>
					</tr>`;
					
				});
				
				$('#comm_list'+board_num).html(data);
			},error:function(){ // 서버로부터 데이터를 받아오는 과정에서 오류가 발생했을 때 실행되는 콜백 함수
				
			}
		});
	}	
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div id="main">
		<h1>글목록</h1>
		<hr>
		<form action="b_searchList.do">
			<select name="searchKey">
				<option value="title">title</option>
				<option value="content">content</option>
			</select> <input type="text" name="searchWord" value="ja"> <input
				type="submit" value="search">

		</form>
		<div class="table-wrapper">
		<table class="alt">
			<thead>
				<tr>
					<th>번호</th>
					<th>썸네일</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos}">
					<tr>
						<td><a href="b_selectOne.do?board_num=${vo.board_num}&nickname=${vo.nickname}">${vo.board_num}</a></td>
						<td><img alt="" src="resources/uploadimg/thumb_${vo.save_img}"></td>
						<td>${vo.title}</td>
						<td>${vo.nickname}</td>
						<td>${vo.wdate}</td>
						<td>
							<table>
								<tbody id="comm_list${vo.board_num}">
								</tbody>
							</table>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6"><c:forEach var="i" begin="1"
							end="${totalPageCount}">
							<c:if test="${param.searchKey == null}">
								<a href="b_selectAll.do?cpage=${i}">${i} &nbsp;</a>
							</c:if>
							<c:if test="${param.searchKey != null}">
								<a
									href="b_searchList.do?searchKey=${param.searchKey}&searchWord=${param.searchWord}&cpage=${i}">${i}
									&nbsp;</a>
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</tfoot>
		</table>
		</div>
	<a href="b_insert.do">글쓰기</a>
	</div>
	
</body>
</html>