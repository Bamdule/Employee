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
form {
	height: 100%;
}

.top {
	line-height: 80px;
}

#main {
	height: 900px;
}

.container {
	width: 1200px;
}

.empSearch {
	height: 10%;
}

.empList {
	height: 80%;
}

.empList table {
	border-collapse: collapse;
	margin: 0 auto;
}

.empList th {
	background-color: #F6F6F6;
	font-weight: bold;
	border-bottom: 1px solid #eee;
	height: 25px;

}

.empList td {
	border-bottom: 1px solid #eee;
	height: 35px;
}

.empList tr {
	text-align: center;
}

.empList .empRow {
	
}

.empPaging {
	height: 10%;
	text-align: center;
}

.pageBlock {
	width: 100%;
	height: 100%;
	text-align: center;
}

.pageBlock strong {
	line-height: 80px;
	width: 40px;
	display: inline-block;
}
.btnArea { text-align: right;
}
.btnArea input {width:100px;}
</style>

<script type="text/javascript">

	$(function(){
		
		window.scroll(0, 215);
		$(".empList th").each(function(i,k){
			switch(i)
			{
			case 0:
				$(k).css("width","100px");
				break;
			case 1:
				$(k).css("width","300px");
				break;
			case 2:
				$(k).css("width","200px");
				break;
			case 3:
				$(k).css("width","200px");
				break;
			case 4:
				$(k).css("width","200px");
				break;
			case 5:
				$(k).css("width","200px");
				break;
			}
		});
		
		$(".empList .empRow").click(function(){
			//선택한 유저의 id를 히든 값에 넣어서 보낸다.
			$("#emp_id").val($(this).children().eq(1).text());
			$("#frm").submit();
		});
		
		$(".empRow").hover(function(){
			$(this).css("background-color","#eee");
		},function(){

			$(this).css("background-color","white");
		});
	});
</script>
</head>
<body>

	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="top">			
			<h2>사원 리스트</h2>
			<hr>
			</div>
			<div class="middle">
				<form action="EmployeeServlet?" id="frm" method="post">			
					<input type="hidden" value="employee_info" name="command">
					<input type="hidden" name="emp_id" id="emp_id">
				<div class="empSearch"></div>
				<div class="empList">
					<table>
						<thead>
							<tr>
								<th>순번</th>
								<th>사번</th>
								<th>이름</th>
								<th>부서</th>
								<th>직급</th>
								<th>입사일</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${paging.isEmpty !=0}">
						<c:forEach var="employee" items="${empList}">
							<tr class="empRow">
								<td>${employee.emp_seq}</td>
								<td>${employee.emp_id}</td>
								<td>${employee.emp_name}</td>
								<td>${employee.dept_name}</td>
								<td>${employee.rank_name}</td>
								<td>${employee.enter_dt}</td>
							</tr>
						</c:forEach>
						</c:if>
						<c:if test="${paging.isEmpty == 0}">
							<tr>
								<td colspan="6">사원 정보가 없습니다.</td>
							</tr>
						</c:if>			
						</tbody>
					</table>
				</div>
				<div class="btnArea">
					<input type="button" value="사원 추가" onclick="location.href='EmployeeServlet?command=employee_addform';">
				</div>
				<div class="empPaging">
					<div class="pageBlock">
					<p>
							<c:if test="${paging.prevPage !=0 }">
								<strong><a href="EmployeeServlet?command=employee_list&curPage=${paging.prevPage}">[<]</a></strong>
							</c:if>
							<c:forEach var="block" begin="${paging.firstBlock}" end="${paging.lastBlock }">
								<strong><a href="EmployeeServlet?command=employee_list&curPage=${block}">${block}</a></strong>
							</c:forEach>		
							<c:if test="${paging.nextPage !=0 }">
								<strong><a href="EmployeeServlet?command=employee_list&curPage=${paging.nextPage}">[>]</a></strong>
							</c:if>								
					</p>
					</div>
				</div>
				</form>
			</div>
			<div class="bottom">
			
			</div>			
		</div>
	</div>



	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>