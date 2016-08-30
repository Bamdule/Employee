<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project - 사원 수정</title>




<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/employee_common.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript" src="js/emp_update_valid.js"></script>
<script type="text/javascript" src="js/employee.js"></script>

<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script type="text/javascript">
$(function() {
	
	
	var emp_skills = new Array();
	<c:forEach items="${employee.skillList}" var="skill">
	emp_skills.push("${skill.skill_id}");
	</c:forEach>
	for (var i = 0; i < emp_skills.length; i++) {
		console.log(emp_skills[i]);
	}
	
	
	var checkboxArray = new Array();
	$(".skillsArea :checkbox").each(function(){
		checkboxArray.push($(this));			
	});
	
	for(var i = 0 ; i <emp_skills.length;i++)
	{
		
		if(!checkboxArray[i].is(":checked")){
			for(var j = 0 ; j <checkboxArray.length;j++){
				if(emp_skills[i] == checkboxArray[j].val()){
						checkboxArray[j].attr("checked","true");
						console.log(emp_skills[i]);
						break;
				}
			}
		}	
	}
	

   
  });
</script>


<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<link type="text/css" rel="stylesheet" href="css/employee_common.css"></link>

</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<form method="post" action="EmployeeServlet?command=employee_update"  enctype="multipart/form-data" name="frm" id="frm">
				<input type="hidden" name="imgNotUpdate" value="${employee.emp_imgpath }"/>	
				<div class="top">
					<div class="title">
						<h2>사원 수정</h2>
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
								<p><input type="file" id="emp_imgpath" name="emp_imgpath"  value="${employee.emp_imgpath }" class="input3" /></p>
								<p><img id="emp_img" alt="" src="imageUpload/${employee.emp_imgpath }"></p>
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
								<input type="text" id="emp_id" name="emp_id" value="${employee.emp_id}" class="input2" readonly="readonly"/>
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
								<input type="text" id="emp_name" name="emp_name" value="${employee.emp_name}" class="input2"  placeholder="이름을 입력해주세요."/>
							</div>
						</div>
						<hr>
						<div class="input_frame">							
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>비밀번호</p>
								</div>
							</div>
							<div class="input_content">
								<input type="password" id="emp_pwd" name="emp_pwd" value="${employee.emp_pwd}" class="input3"  placeholder="비밀번호를 입력해주세요."/>
							</div>
						</div>
						<hr>
						<div class="input_frame">							
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>비밀번호 확인</p>
								</div>
							</div>
							<div class="input_content">
								<input type="password" id="emp_pwd_check" name="emp_pwd_check" value="${employee.emp_pwd}"  class="input3"  placeholder="비밀번호를 다시 입력해주세요."/>
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
								<p>${employee.res_num}</p>
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
								<input type="text"  maxlength="11" id= "emp_phone" name="emp_phone" value="${employee.emp_phone}"class="input2" placeholder="('-')를 빼고 입력해주세요"/>
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
								<input type="text" id="front_email" name="front_email" value="${employee.front_email}" class="input2" placeholder="email"/>@ 
								<input type="text" id="back_email" name="back_email" value="${employee.back_email}" class="input2" />
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
								<input type="text" id="zipcode" name="zipcode" class="input2" value="${employee.zipcode}" placeholder="우편번호"/>
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
								<input type="text" id="emp_addr" name="emp_addr" value="${employee.emp_addr}" class="input3" placeholder="주소를 입력해주세요."/>
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
								<input type="text" id="emp_detailaddr" name="emp_detailaddr" value="${employee.emp_detailaddr}" class="input2" placeholder="상세주소" />
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
								<input type="text" id="emp_sal" name="emp_sal" value="${employee.emp_sal}" class="input2" placeholder="단위  : 만 " />
							</div>
						</div>
						<hr>


						<div class="input_frame3">
							<div class="input_title_frame">
								<div class="input_title_name">
									<p>보유 스킬</p>
								</div>
							</div>
							<div class="input_content">
							<div class="skillsArea">
								<c:forEach var="skill" items="${skillList}" varStatus="status">
										<span class="skillArea">
											<c:if test=""></c:if>
											<input type="checkbox" id="skills" name="skills" value="${skill.skill_id}"/>${skill.skill_name}
										</span>
									<c:if test="${status.count%4==0}">
										<br>				
									</c:if>
								</c:forEach>		
							</div>
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
								<select name="dept_id" id="dept_id">			
									<option value="none">:: 없음 ::</option>
									<c:forEach var="dept" items="${deptList}">
										
										<c:if test="${employee.dept_id == dept.dept_id}">
											<option value="${dept.dept_id}" selected="selected">${dept.dept_name}</option>
										</c:if>
										<c:if test="${employee.dept_id != dept.dept_id}">
											<option value="${dept.dept_id}">${dept.dept_name}</option>
										</c:if>
									</c:forEach>
									
									
								</select>

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
								<select name="rank_id" id="rank_id">
									<option value="none">:: 없음 ::</option>
										<c:forEach var="rank" items="${rankList}">
										
										<c:if test="${employee.rank_id == rank.rank_id}">
											<option value="${rank.rank_id}" selected="selected">${rank.rank_name}</option>
										</c:if>
										<c:if test="${employee.rank_id != rank.rank_id}">
											<option value="${rank.rank_id}">${rank.rank_name}</option>
										</c:if>
									</c:forEach>
								</select>
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
							<p>${employee.enter_dt}</p>
							</div>
						</div>
						<hr>

					</div>
					<div class="spec_info">
						<h2>기타 정보</h2>
						<hr class="top_hr">
					</div>
				</div>
				<div class="bottom">
					<hr>
					<input type="submit" value="저장" onclick="return addCheck();">
					<input type="button" value="취소" onclick="location='EmployeeServlet?command=employee_list';">
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>