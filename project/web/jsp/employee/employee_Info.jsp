<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project - 사원 정보 보기</title>



<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>

<!--Tabs-->
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<!--Tabs-->


<!--datePicker-->
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<!--datePicker-->


<script type="text/javascript" src="js/employee_common.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<link type="text/css" rel="stylesheet" href="css/employee_common.css"></link>

 

<script type="text/javascript">
$(function(){
   
	$( "#tabs" ).tabs({
    	activate: function( event, ui ) { 
    		switch(ui.newTab.index())
    		{
    		case 0:
    			tabSelector=0;
    			break;
    		case 1:
    			tabSelector=1;
    			break;
    		case 2:
    			tabSelector=2;
    			break;
    		}
    	}
    });
	
	$("#staff_spec_update_btn").click(function(){
		$("#command").val("employee_spec_updateform");
		$("#frm").submit();
		
	});
	$("#staff_info_update_btn").click(function(){
		$("#command").val("employee_updateform");
		$("#frm").submit();
		
	});
});
</script>
<style>

	.btnArea{
		margin-top:30px;
		text-align: right;
	}
	.btnArea input {
		width: 100px;
		height: 30px;
		
	}
	.spec_info table{
		width: 100%;
		border-collapse: collapse;
	}
	.spec_info tr{
	
	}
	.spec_info td{
		height:50px;
		font-size:15px;
		border-bottom: 1px solid #eee;
		text-align: center;
	}
	.spec_info th{
		height:40px;
		font-size:13px;
		border-bottom: 1px solid #eee;
	}
	.bottom input{
		width:100px;
		height:30px;
	}
</style>

</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<form action="EmployeeServlet" method="post" name="frm" id="frm">
				<input type="hidden" id="command" name="command">
				<input type="hidden" name="h_empid" value="${employee.emp_id }" />
				<div class="top">
					<div class="title">
						<h2>사원 정보</h2>
						<hr>
					</div>
				</div>
				<div class="middle">		
					 <div class="staff_info">					
						<h2>기본 정보</h2>
						<hr class="top_hr">
						<div class="input_frame3">							
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>사원 사진</p>
								</div>
							</div>
							<div class="input_content">
								<p><img alt="" src="imageUpload/${employee.emp_imgpath }"></p>
							</div>
						</div>
						<hr>
						<div class="input_frame">							
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>사번</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.emp_id }</p>
							</div>
						</div>
						<hr>
						<div class="input_frame">							
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>이름</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.emp_name }</p>
							</div>
						</div>
						<hr>
						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>주민등록번호</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.res_num }</p>
							</div>
						</div>
						<hr>

						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>휴대폰</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.emp_phone }</p>
							</div>
						</div>
						<hr>

						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>이메일</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.emp_email }</p>
							</div>
						</div>
						<hr>


						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>우편 번호</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.zipcode }</p>
							</div>
						</div>
						<hr>
						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>주소</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.emp_addr }</p>
							</div>
						</div>
						<hr>

						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>상세주소</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.emp_detailaddr }</p>
							</div>
						</div>
						<hr>

						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>급여</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.emp_sal }</p>
							</div>
						</div>
						<hr>
						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>습득 스킬</p>
								</div>
							</div>
							<div class="input_content">
								<c:forEach var="skill" items="${employee.skillList}">
								<span>${skill.skill_name }, </span>
								</c:forEach>
							</div>
						</div>
						<hr>

					</div> 

					
					 <div class="dept_info">
						<h2>부서 정보</h2>
						<hr class="top_hr">
						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>부서명</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.dept_name }</p>
							</div>
						</div>
						<hr>

						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>직급</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.rank_name }</p>
							</div>
						</div>
						<hr>


						<div class="input_frame">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>입사일</p>
								</div>
							</div>
							<div class="input_content">
								<p>${employee.enter_dt }</p>
							</div>
						</div>
						<hr>
						<div class="btnArea">
						<input type="button" id="staff_info_update_btn" value="사원 정보 수정">
						</div>
					</div> 
					<div class="spec_info">
						<h2>추가 정보</h2>
						
						<div id="tabs">
						<ul>
							<li><a href="#academic_tab"><b>학력 사항</b></a></li>
							<li><a href="#career_tab"><b>경력 사항</b></a></li>
							<li><a href="#license_tab"><b>자격 사항</b></a></li>
						</ul>
						
						<div id="academic_tab">
							<table>
								<thead>
									<tr>
										<th>학력구분</th>															
										<th>학교명</th>									
										<th>전공</th>	
										<th>졸업여부</th>									
										<th>입학일자</th>
										<th>졸업일자</th>
									</tr>
								</thead>
								<tbody id="academic_tbody">
									<c:forEach var="academic" items="${academicList}">
										<tr>
											<td>${academic.academic_lev_name }</td>
											<td>${academic.academic_name }</td>
											<td>${academic.major_name }</td>
											<td>${academic.academic_status_name }</td>
											<td>${academic.enter_dt }</td>
											<td>${academic.graduation_dt }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div id="career_tab">
							<table>
								<thead>
									<tr>														
										<th>회사명</th>									
										<th>직급</th>	
										<th>담당업무</th>									
										<th>입사일</th>
										<th>퇴사일</th>
									</tr>
								</thead>
								<tbody id="career_tbody">
									<c:forEach var="career" items="${careerList}">
										<tr>
											<td>${career.corp_name }</td>
											<td>${career.rank_name }</td>
											<td>${career.emp_role }</td>
											<td>${career.career_enter_dt }</td>
											<td>${career.career_retire_dt }</td>
										</tr>
									</c:forEach>	
								</tbody>
							</table>	
						</div>
						<div id="license_tab">
							<table>
								<thead>
									<tr>														
										<th>시행기관</th>									
										<th>자격증 명</th>	
										<th>자격증 ID</th>									
										<th>취득일</th>
										<th>자격증종류</th>
									</tr>
								</thead>
								<tbody id="licence_tbody">
									<c:forEach var="licence" items="${licenceList}">
										<tr>
											<td>${licence.institution }</td>
											<td>${licence.licence_name }</td>
											<td>${licence.licence_number }</td>
											<td>${licence.get_dt }</td>
											<td>${licence.ins_type }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					</div>
				</div>
				<div class="bottom">
				<hr>
					<input type="button" value="추가 정보 수정" id="staff_spec_update_btn">
					<c:if test="${sessionScope.isManager!=false}">
						<input type="button" value="목록" onclick="history.go(-1);">
					</c:if>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>