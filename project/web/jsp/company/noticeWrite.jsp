<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 쓰기</title>
<script type="text/javascript" src="/project/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		<jsp:include page="../../js/header.js"></jsp:include>
		$(".middle input[type='text']").css("width","100%");
		$(".bottom input[type='reset']").click(function(){
			
			confirm("정말로 취소하시겠습니까?");
			location.href="noticeList.jsp";
		});
		
		$("td:first-of-type").css("width","150px");
		$("td:first-of-type").css("text-align","left");
		
	});
</script>
<link type="text/css" rel="stylesheet" href="../../css/common.css"  ></link>
<style type="text/css">
	
	#main .container{ width:900px;height:100%; margin:0 auto;}
	#main .top {height:10%;}
	#main .middle {height:70%;}
	#main .bottom {height:20%;}
	
	form {height:100%;}
	.top .title{line-height: 80px;width: 100%;height:100%;} 

	.middle table {width:100%;border-collapse:collapse;}
	.middle textarea{width:100%; resize:none; border: none;}
	.middle td {border:1px solid #eee; height: 40px;}
	.middle input{height:40px; width:100%; border: none;}
	
	.bottom input{width:100px;height:100%;}
	.bottom p{text-align: center};
	
	
</style>
</head>
<body>

	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">	
		  <form action="#" method="post">	
			<div class="top">
			    <div class="title">
		        	<h2>공지사항 쓰기</h2>
		        	<hr>
		    	</div>
			</div>
			<div class="middle">
				<table>
				  <tr>
				    <td>작성자</td>
				    <td>홍길동</td>
				  </tr>
				  <tr>
				    <td>제목</td>
				    <td><input type="text" id="notice_title" name="notice_title"/></td>
				  </tr>
				  <tr>
				    <td>내용</td>
				    <td><textarea rows="25" cols="100" id="notice_content" name="notice_content"></textarea></td>
				  </tr>
				</table>
			</div>
			<div class="bottom">
				<p><input type="submit" value="저장"/>
				<input type="reset" value="취소"/></p>
			</div>
	      </form>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>