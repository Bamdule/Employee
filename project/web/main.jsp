<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project - main </title>

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
#main {
	height: 600px;
}
#main .middle{
	height:350px;
}
.container{
	width:1300px;
}
.imgSize{

	text-align:center;
	width:600px;
	height:500px;
}
.person {
	border: 10px solid transparent;
	margin-bottom: 25px;
	width: 80%;
	height: 80%;
	opacity: 0.7;
}
#imageSlide{
	height:100px;
}
 .img_container {
     padding: 80px 120px;
 }
.person:hover {
	border-color: #f1f1f1;
}
.notice {
	width : 47%;
	float: right;
}
.notice th {
	font-size:12px;
	height: 25px;
	font-weight: bold;
	border-bottom:1px solid black;
}

.notice td {

	font-size:12px;
	text-align: left;
	height: 35px;
	border-bottom: 1px solid #eee;
	
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
	
}

.notice tr {
}

form {
	height: 100%;
}

table {
	text-align:center;
	width: 100%;
	border-collapse: collapse;
	margin: 0 auto;
}
table thead {

text-align:center;
}
.projectArea {
	width:47%;
	float: left;
}


.projectArea table {
	width: 100%;
	border-collapse: collapse;
	margin: 0 auto;
}

.projectArea th {
	font-size:12px;
	height: 25px;
	font-weight: bold;
	
	text-align: left;
	border-bottom: 1px solid black;
}

.projectArea td {

	font-size:12px;
	text-align: left;
	height: 35px;
	border-bottom: 1px solid #eee;
}

.projectArea tr {
	text-align: center;
}


</style>

</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="middle">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active" align="center">
							<img src="images/img1.jpg" alt="New York" class="imgSize">
							<div class="carousel-caption">
							</div>
						</div>

						<div class="item" align="center">
							<img src="images/img2.jpg" alt="Chicago" class="imgSize">
							<div class="carousel-caption">
							</div>
						</div>

						<div class="item" align="center">
							<img src="images/img3.jpg" alt="Los Angeles" class="imgSize">
							<div class="carousel-caption">
							</div>
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>		
			<div class="projectArea">
				<p><span>회사 프로젝트</span><a href="ProjectServlet?command=corp_project_list">more</a></p>		
				<table>
					<thead>
						<tr>
							<th style="text-align: center;">순번</th>
							<th style="text-align: center;">프로젝트 이름</th>
							<th style="text-align: center;">회사</th>
							<th style="text-align: center;">시작일</th>
							<th style="text-align: center;">종료일</th>
							<th style="text-align: center;">인원</th>
							<th style="text-align: center;">내/외</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="project" items="${projectList}">
							<tr>
								<td style="text-align: center;">${project.project_seq}</td>
								<td><a href="ProjectServlet?command=corp_project_info&project_id=${project.project_id}">${project.project_name}</a></td>
								<td style="text-align: center;">${project.corp_name}</td>
								<td style="text-align: center;">${project.start_dt}</td>
								<td style="text-align: center;">${project.end_dt}</td>
								<td style="text-align: center;">${project.join_num}</td>
								<td style="text-align: center;">${project.corp_own}</td>
							</tr>
						</c:forEach>	
					</tbody>
				</table>
			</div>			
			<div class="notice">
				<p><span>공지사항</span><a href="NoticeServlet?command=notice_list">more</a></p>
				<table>
					<thead class="notice_list">
						<tr>
							<th style="text-align: center;">번호</th>
							<th style="text-align: center;">제목</th>
							<th style="text-align: center;">작성자</th>
							<th style="text-align: center;">작성일</th>
							<th style="text-align: center;">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="notice" items="${noticeList}">
							<tr class="noticeRow">
								<td style="text-align: center;">${notice.seq }</td>
								<td><a href="NoticeServlet?command=notice_info&notice_id=${notice.notice_id }">${notice.notice_title }</a></td>
								<td style="text-align: center;"><a href="NoticeServlet?command=notice_info&notice_id=${notice.notice_id }">${notice.emp_name }</a></td>
								<td style="text-align: center;">${notice.register_dt }</td>
								<td style="text-align: center;">${notice.readcount }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>