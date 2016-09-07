<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="header">
	<div class="top">
		<div class="container">
			<div class="user_info">
				<p><strong>[ ${sessionScope.emp_name} 님 ] </strong> <a href="LogoutServlet"><strong>로그아웃</strong></a></p>
			</div>
			<div class="main_title">
				<h1>Community</h1>
			</div>
			<div class="sub_title">
				<p>Simple Style</p>
			</div>
			
		</div>
	</div>

	<div class="bottom">
		<div class="main_memu">
			<div class="container">
				<ul>
					<li><a href="#">HOME</a></li>
					<li>회사</li>
					<li>커뮤니티</li>
					<li>마이페이지</li>
				<% 
				if(session.getAttribute("isManager").toString().equals("true")){
				 %>
						<li class="managerPage">관리자페이지</li>
				<%} %>
				</ul>
			</div>
		</div>

		<div class="sub_menu">
			<div class="container">
				<ul>
				</ul>
				<ul>
					<li><a href="NoticeServlet">공지사항</a></li>
					<li><a href="ProjectServlet?command=corp_project_list">회사 프로젝트</a></li>
				</ul>
				<ul>
					<li>자유게시판</li>
					<li>건의 사항</li>
				</ul>
				<ul>
					<li><a href="ProjectServlet?command=emp_project_list">개인 프로젝트</a></li>
					<li><a href="EmployeeServlet?command=employee_info">내정보 보기</a></li>
				</ul>
				<ul>
					<li><a href="EmployeeServlet?command=employee_addform">사원 등록</a></li>
					<li><a href="EmployeeServlet?command=employee_list">사원 리스트</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
