<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
 <script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
  </script>
<style type="text/css">
	#main{
		height:auto;
	}
	
	.emp_infoArea{
		height:200px;
	}
	
	.emp_specArea{
		heigth:auto;
	}
	.emp_specArea table{
		width: 100%;
		border-collapse: collapse;
	}
	.emp_specArea tr{
	}
	.emp_specArea td{
		height:50px;
		border-bottom: 1px solid #eee;
		text-align: center;
	}
	.emp_specArea th{
		height:40px;
		border-bottom: 1px solid #eee;
		background-color: #F6F6F6;	
	}
	
	.btnArea {
		height:100px;
	}
	
	.emp_infoArea table{
		width: 100%;
		border-collapse: collapse;
	}
	.emp_infoArea tr{
	
		height:40px;
	}
	.emp_infoArea th{
		width:20%;
		border-bottom: 1px solid #eee;
		background-color: #F6F6F6;	
	}
	.emp_infoArea td{
		width:80%;
		padding-left:10px;
		border-bottom: 1px solid #eee;		
	}
	
	.specBtnArea{
		height:30px;
		text-align: right;
	}
	.specBtnArea input{
		width: 100px;
	}

	
	.bottom .btnArea{
		text-align: right;
	}
	
	.bottom .btnArea{
		line-height:50px;
		text-align: right;
	}
	
	.bottom .btnArea input {
		width: 100px;
	}
	
	
</style>
</head>
<body>
	<div id="wrap">
	
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="top">
				<div class="title">
					<h2>사원 추가 정보</h2>
					<hr>
				</div>
			</div>

			<div class="middle">
				<div class="emp_infoArea">
					<table>
						<thead>
						</thead>
						<tbody>
							<tr>
								<th>사번</th>
								<td>${emp_id}</td>
							</tr>
							<tr>
								<th>사원 이름</th>
								<td>${emp_name}</td>
							</tr>
							<tr>
								<th>부서</th>
								<td>${dept_name}</td>
							</tr>
							<tr>
								<th>직급</th>
								<td>${rank_name}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="specBtnArea">
					<input type="button" id="specAddBtn" value="추가 등록">
				</div>
				<div class="emp_specArea">
					<div id="tabs">
						<ul>
							<li><a href="#academic_tab">학력 사항</a></li>
							<li><a href="#career_tab">경력 사항</a></li>
							<li><a href="#license_tab">자격 사항</a></li>
						</ul>
	<!-- 					
학력
학교명
전공
학력 상태
입학일자
졸업일자 -->
						
						<div id="academic_tab">
							<table>
								<thead>
									<tr>
										<th>학력 구분</th>															
										<th>학교 명</th>									
										<th>전공</th>	
										<th>졸업 여부</th>									
										<th>입학 일자</th>
										<th>졸업 일자</th>
									</tr>
									
								</thead>
								<tbody id="academic_tbody">
								<tr>
									<td>
										<select>
											<c:forEach var="academic_level" items="${academicLevelList}">
												<option value="${academic_level.academic_lev_id}">${academic_level.academic_lev_name}</option>
											</c:forEach>
										</select>
									</td>															
									<td>
										<input type="text" id="academic_name" name="academic_name" >
									</td>									
									<td>
										<input type="text" id="major_name" name="major_name" >
									</td>
									<td>
										<select>
											<c:forEach var="academic_status" items="${academicStatusList}">
												<option value="${academic_status.academic_status_id}">${academic_status.academic_status_name}</option>
											</c:forEach>
										</select>		
									</td>							
									<td>
										<input type="text" id="enter_dt" name="enter_dt" placeholder="입학 일자">
									</td>
									<td>
										<input type="text" id="graduation_dt" name="graduation_dt" placeholder="졸업 일자">
									</td>
								</tr>
								</tbody>
							</table>
						</div>
						<div id="career_tab">
						</div>
						<div id="license_tab">
						</div>
					</div>
				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="button" id="saveBtn" value="저장">
					<input type="button" id="cancelBtn" value="취소">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
	</div>
</body>
</html>