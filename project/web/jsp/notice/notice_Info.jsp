<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<style type="text/css">
	.btnArea {text-align: right;}
	.btnArea input{width:100px;}

	
	.middle .blank{height:20%;}
	.middle .noticeArea{height:80%;}
	.noticeArea {text-align: center}
	.noticeArea table {border-collapse: collapse;}
	.noticeArea tr{height: 35px;} 
	.noticeArea th{background-color: #eee;} 
	.noticeArea td{border: 1px solid #eee;} 
	.noticeArea textarea {resize:none; outline: none;}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="top">
				<div class="title">
					<h2>공지사항 내용</h2>
					<hr>
				</div>
			</div>
			
			<div class="middle">
				<div class="blank"></div>
				<div class="noticeArea">
				<table class="notice">
					<tr>
						<th>작성자</th>
						<td>${notice.emp_name}</td>
						
						<th>작성일</th>
						<td>${notice.register_dt }</td>
						<th>조회수</th>
						<td>${notice.readcount }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="5">${notice.notice_title}</td>

					</tr>
					<tr>
						<td colspan="6"><textarea cols="145" rows="20" readonly="readonly">${notice.notice_content }</textarea></td>
					</tr>
				</table> 
				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="submit" value="수정" onclick="location.href='NoticeServlet?command=notice_updateform&notice_id=${notice.notice_id}';">
					<input type="button" value="삭제">
					<input type="button" value="목록" onclick="location.href='NoticeServlet?command=notice_list';">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>