<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
.pageBlock{
	text-align:center;
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
								<th>인원</th>
								<th>내/외</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${page.isEmpty !=0}">
							<c:forEach var="project" items="${projectList}">
								<tr>
									<td>${project.project_seq}</td>
									<td><a href="ProjectServlet?command=corp_project_info&project_id=${project.project_id}">${project.project_name}</a></td>
									<td>${project.corp_name}</td>
									<td>${project.start_dt}</td>
									<td>${project.end_dt}</td>
									<td>${project.join_num}</td>
									<td>${project.corp_own}</td>
								</tr>
							</c:forEach>
							</c:if>
								<c:if test="${page.isEmpty == 0}">
							<tr>
								<td colspan="7">프로젝트 정보가 없습니다.</td>
							</tr>
						</c:if>	
						</tbody>
					</table>

				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<c:if test="${sessionScope.isManager!=false}">
						<input type="button" value="새 프로젝트 작성" onclick="location.href='ProjectServlet?command=corp_project_addform'"> 
					</c:if>
				</div>
				<div class="pageArea">
					<div class="pageBlock">
					<p>
							<c:if test="${page.prevPage !=0 }">
								<strong><a href="ProjectServlet?command=corp_project_list&curPage=${page.prevPage}">[<]</a></strong>
							</c:if>
							<c:forEach var="block" begin="${page.firstBlock}" end="${page.lastBlock }">
								<strong><a href="ProjectServlet?command=corp_project_list&curPage=${block}">${block}</a></strong>
							</c:forEach>		
							<c:if test="${page.nextPage !=0 }">
								<strong><a href="ProjectServlet?command=corp_project_list&curPage=${page.nextPage}">[>]</a></strong>
							</c:if>								
					</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>