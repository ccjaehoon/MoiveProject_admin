<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/board.css" />  --%>
 <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noscript.css" />
<link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"
/>

<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	function selectCommentList(story_num){
		console.log("selectCommentList()...",story_num);
		
		$.ajax({
			url:"http://localhost:8070/movie/api/selectCommentList.do",
			type:"get",
			data:{story_num:story_num},
			dataType:"json",
			success:function(arr){
				console.log(arr);
				let data = '';
				arr.forEach(function(item){
					console.log(item);
					
					data += `<tr>
						<td>\${item.story_comments_num}</td>
						<td>\${item.nickname}</td>
						<td>\${item.content}</td>
						<td>\${item.good}</td>
						<td>\${item.report}</td>
						<td>\${item.wdate}</td>
					</tr>`;
					
				});
				
				$('#sc_comm_list'+story_num).html(data);
			},error:function(){ // 서버로부터 데이터를 받아오는 과정에서 오류가 발생했을 때 실행되는 콜백 함수
				
			}
		});
	}	
</script>
<style>
    html,
    body {
      position: relative;
      height: 100%;
    }

    body {
      background: #eee;
      font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
      font-size: 14px;
      color: #000;
      margin: 0;
      padding: 0;
    }

    .swiper {
      width: 1500px;
      height: 800px;
    }

    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;
      justify-content: center;
      align-items: center;
      width :1400px;
      height: 700px;
      display: flex;
      flex-wrap: wrap; /* 요소들이 한 줄에 너무 많이 배치되지 않도록 줄바꿈을 허용 */
	  place-items: center;
      
    }

    .swiper-slide img {
      display: block;
      width: 600px;
      height: 600px;
      
    }
    
    .swiper-slide video {
      display: block;
      width: 600px;
      height: 600px;
      object-fit: cover;
    }
    
    .story-content{
	  width: 100%; /* .story-content를 전체 너비로 설정 */
	 /*  margin-bottom: 20px; /* 이미지, 동영상, 댓글 목록 아래로 두기 위해 마진 추가 */ 
    }
    
  </style>

</head>
<body class="is-preload">


	<div style="position: relative; z-index: 2;">
		<jsp:include page="../top_menu.jsp"></jsp:include>
	</div>
	<div id="main" style="position: relative; z-index: 1;">
		<br>
		
	<h2>스토리</h2>
	
 
    <div class="table-wrapper">
<!-- Swiper -->
  <div class="swiper mySwiper">
    <div class="swiper-wrapper">
      <c:forEach var="vo" items="${vos}">
                    <div class="swiper-slide story-container">
                    <div class="story-content" >
                            <p>${vo.content}</p>
                            <p>${vo.nickname}</p>
                        </div>
                        <a href="s_selectOne.do?story_num=${vo.story_num}&nickname=${vo.nickname}" class="story-link">${vo.story_num}</a>
                        <!-- 이미지가 존재하는 경우 표시 -->
                        <c:if test="${vo.save_img != null && vo.save_video == null }">
                            <img src="resources/uploadimg/images/thumb_${vo.save_img}" alt="">
                        </c:if>
                        <!-- 비디오가 존재하는 경우 표시 -->
                        <c:if test="${vo.save_video != null }">
                            <div>
                                <video controls>
                                    <source src="resources/uploadimg/videos/${vo.save_video}" type="video/mpeg">
                                    <source src="resources/uploadimg/videos/${vo.save_video}" type="video/mp4">
                                    <source src="resources/uploadimg/videos/${vo.save_video}" type="video/avi">
                                    <source src="resources/uploadimg/videos/${vo.save_video}" type="video/quicktime">
                                    <source src="resources/uploadimg/videos/${vo.save_video}" type="video/x-flv">
                                    <source src="resources/uploadimg/videos/${vo.save_video}" type="video/x-matroska">
                                </video>
                            </div>
                        </c:if>
                        <br>
                        <button class="comment-btn" onclick="selectCommentList(${vo.story_num})">댓글목록</button>
                        <table>
                            <tbody id="sc_comm_list${vo.story_num}">
                                <!-- Comment list will be inserted here dynamically -->
                            </tbody>
                        </table>
                    </div>
        </c:forEach>
      
     
    </div>
   <script>
    var swiper = new Swiper(".mySwiper", {
      direction: "vertical",
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
    });
  </script>
    
    <div class="swiper-pagination"></div>
  </div>
   
        
    
   </div>
	<form action="s_insert.do">
				<input type="submit" value="스토리 작성" >
			</form>

	</div>
	<div id="copyright">
		<jsp:include page="../footer_menu.jsp"></jsp:include>
	</div>
</body>
</html>