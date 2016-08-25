<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project - 사원 정보 보기</title>

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/employee_common.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<link type="text/css" rel="stylesheet" href="css/employee_common.css"></link>


</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<form action="EmployeeServlet" method="post" name="frm" id="frm">
				<input type="hidden" value="employee_updateform" name="command">
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
								<p>${employee.dept_id }</p>
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
								<p>${employee.rank_id }</p>
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

					</div>
					<div class="spec_info">
						<h2>기타 정보</h2>
						<hr class="top_hr">
					</div>
				</div>
				<div class="bottom">
				<hr>
					<input type="submit" value="수정">
					<input type="button" value="목록" onclick="location='EmployeeServlet?command=employee_list';">
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>