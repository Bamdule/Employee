<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project - 프로젝트 작성</title>

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<!--datePicker-->
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<!--datePicker-->

<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<script type="text/javascript">

$( function() {

});

function data_submit(){
	$("#frm").submit();
}
</script>

<style type="text/css">
#main {height: auto;}
.middle	.blank {
	height: 10%;
}

.middle	.projectArea {
	height: 90%;
}

.projectArea table {
	width: 100%;
	border-collapse: collapse;
	text-align: left;
}
.projectArea tr{
	height: 45px;
	border-bottom: 1px solid #eee;
}
.projectArea th{
	width: 20%;
}

.projectArea td{
	width: 80%;
}
.bottom .btnArea {
	text-align: right;
	height: 33%;
}

.btnArea input {
	width: 100px;
}
.input_type1 {width: 50px;}
.input_type2 {width: 100px;}
.input_type3 {width: 150px;}
.input_type4 {width: 200px;}
.input_type5 {width: 400px;}






table {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="top">
				<div class="title">
					<h2>개인 프로젝트 작성</h2>
					<hr>
				</div>
			</div>
			<div class="middle">
				<div class="blank">
				</div>
				
				<div class="projectArea">
					<form method="post" action="ProjectServlet?command=emp_project_add" id="frm">
					<table>
						<tbody>
							<tr>
								<th><span>프로젝트 이름</span></th>
								<td></td>
							</tr>
							<tr>
								<th><span>회사 이름</span></th>
								<td></td>
							</tr>
							<tr>
								<th><span>회사 구분</span></th>
								<td></td>
							</tr>
							<tr>
								<th><span>시작 일</span></th>
								<td></td>
							</tr>
							<tr>
								<th><span>종료 일</span></th>
								<td></td>
							</tr>
							<tr>
								<th><span>프로젝트 내용</span></th>
								<td>
									<textarea name="project_content" id="project_content" cols="120" rows="15"></textarea>
								</td>
							</tr>
							<tr>
								<th><span>수행역할</span></th>
								<td></td>
							</tr>
							
						</tbody>
					</table>
					</form>
				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="button" value="수정" >
					<input type="button" value="목록" >
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>