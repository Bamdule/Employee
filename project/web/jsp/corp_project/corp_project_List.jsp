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
.middle	.searchArea {
	height: 10%;
}

.middle	.projectArea {
	height: 90%;
}
.projectArea table {
	width: 100%;
	border-collapse: collapse;
	margin: 0 auto;
}

.projectArea th {
	height: 25px;
	background-color: #F6F6F6;
	font-weight: bold;
}

.projectArea td {
	height: 35px;
	border-bottom: 1px solid #eee;
}

.projectArea tr {
	text-align: center;
}

.bottom .btnArea {
	text-align: right;
	height: 33%;
}

.btnArea input {
	width: 120px;
}

.buttom .pageArea {
	height: 33%;
}


</style>

</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="top">
				<div class="title">
					<h2>회사 프로젝트 리스트</h2>
					<hr>
				</div>
			</div>
			<div class="middle">
				<div class="searchArea"></div>
				<div class="projectArea">
					<table>
						<thead>
							<tr>
								<th>순번</th>
								<th>프로젝트 이름</th>
								<th>회사</th>
								<th>시작일</th>
								<th>종료일</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>

				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="button" value="새 프로젝트 작성" onclick="location.href='ProjectServlet?command=corp_project_add'"> 
				</div>
				<div class="pageArea"></div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>