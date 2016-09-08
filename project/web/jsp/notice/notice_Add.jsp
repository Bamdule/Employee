<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript">
	$(function(){
		$("#frm").submit(function(){
			return submitCheck();
		});
	});
</script>
<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<style type="text/css">
#main {
	height: 700px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

.btnArea {
	text-align: right;
}

.btnArea input {
	width: 100px;
}

.notice_write th {
	width: 20%;
	height: 40px;
	border: 1px solid #eee;
	background-color: #F6F6F6;
}

.notice_write td {
	width: 80%;
	border: 1px solid #eee;
}

.notice_write input {
	width: 100%;
	height: 100%;
	border: none;
}

.notice textarea {
	border: none;
	resize: none;
}
</style>
</head>


<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<form action="NoticeServlet" method="post">
				<input type="hidden" name="command" value="notice_add">
				<div class="top">
					<div class="title">
						<h2>공지사항 작성</h2>
						<hr>
					</div>
				</div>

				<div class="middle">
					<table class="notice_write">
						<tr>
							<th>제목</th>
							<td><input type="text" name="notice_title" id="notice_title">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea cols="120" rows="20" name="notice_content" id="notice_content"></textarea>
							</td>
						</tr>
					</table>
				</div>
				<div class="bottom">
					<div class="btnArea">
						<input type="submit" value="저장" id="frm"> 
						<input type="button" value="취소" onclick="location.href='NoticeServlet';">
					</div>
				</div>
			</form>
		</div>

	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>