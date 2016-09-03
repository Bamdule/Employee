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

<!--다이알로그  -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<!--다이알로그  -->

<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<script type="text/javascript">

var empList = new Array();
$( function() {
	
	var empList ;
	var emp_tbody = $(".empListFrame");
    $( "#start_dt" ).datepicker({
    	dateFormat: "yy-mm-dd"
    });
    
    $( "#end_dt" ).datepicker({
    	dateFormat: "yy-mm-dd"
    });
    


	//페이지에 사원 리스트를 뿌린다.
    function registerEmp()
    {
    	$(".eList").html("");//사원리스트 초기화
    	$(".empListFrame :checked").each(function(){
    		empList.push($(this).val());
    	});
    	
    	emp_tbody.html("");//다이알로그 사원 리스트 초기화
    	
    	if(empList.length!=0)
    	{
	    	$.ajax({
	    		url: "ProjectServlet?command=ajax_emp_list"
	    	     , type:"post"
	    	     , data : {'empList':empList}
	    	 	 , dataType : 'json'
	    	     , success:function(result){
	    	    	 for(var index=0;index<result.length;index++)
	    	 		{
	    	 			var jsonObject = JSON.stringify(result[index]);
	    	 			var emp_info = JSON.parse(jsonObject);
	    	 			
	    	 			$(".eList").append(
	    	 					"<tr>"
	    	    				+"<td>"+emp_info.emp_seq+"</td>"
	    	    				+"<td>"+emp_info.emp_id+"</td>"
	    	    					+"<td>"+emp_info.emp_name+"</td>"
	    	    					+"<td>"+emp_info.dept_name+"</td>"
	    	    					+"<td>"+emp_info.rank_name+"</td>"	
	    	    					+"<td><select id='emp_role'>"
	    	    					+"<option value='0001'>개발자</option>"
	    	    					+"<option value='0002'>디자이너</option>"
	    	    					+"<option value='0003'>기획자</option>"
	    	    					+"<option value='0004'>PM</option>"
	    	    					+"<option value='0005'>PL</option>"  					
	    	    					+"</select></td>"
	    	    			+"</tr>"
	    	    			);
	
	    	 			console.log(emp_info.emp_name);
	    	  	       }
	    	    }
	   		 }); 
    	}
        dialog.dialog( "close" );
    }

});


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
.projectArea p {font-size: 13px;}

.projectArea td{
	width: 80%;
}
.projectArea textarea {
	text-align:left;
	resize:none;
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

.skillArea {
	width: 150px; 
	display: inline-block; 
	margin-left: 5px; 
	margin-top: 5px;
}

.join_empArea{
	height:700px; 
	margin-top: 50px;
	margin-bottom: 30px;
}
.join_empArea table {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
}
.join_empArea th{
	height: 25px;
	background-color: #F6F6F6;
	font-weight: bold;
}
.join_empArea td{
	height: 35px;
	border-bottom: 1px solid #eee;
}
.join_empArea .join_emp{
	height:80%;
	overflow: auto;
}
.join_empArea .title{
	height: 5%;
}
.join_empArea .btnArea{
	margin-top: 30px;
	height:5%;
	text-align: right;
}


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
					<h2>프로젝트 작성</h2>
					<hr>
				</div>
			</div>
			<div class="middle">
				<div class="blank">
				</div>
				<form>
				<div class="projectArea">
					<table>
						<tbody>
						<tr>
							<th><span>프로젝트 ID</span></th>
								<td><p id="project_name"> ${corpProject.project_id} </p></td>
							</tr>
							<tr>
								<th><span>프로젝트 이름</span></th>
								<td><p id="project_name"> ${corpProject.project_name} </p></td>
							</tr>
							<tr>
								<th><span>회사 이름</span></th>
								<td><p id="corp_name"> ${corpProject.corp_name} </p></td>
							</tr>
							<tr>
								<th><span>회사 구분</span></th>
								<td><p id="corp_own"> ${corpProject.corp_own}</p></td>		
							</tr>
							<tr>
								<th><span>시작 일</span></th>
								<td><p id="start_dt"> ${corpProject.start_dt} </p></td>		
							</tr>
							<tr>
								<th><span>종료 일</span></th>
								<td><p id="end_dt">${corpProject.end_dt} </p></td>		
							</tr>
							<tr>
								<th><span>프로젝트 내용</span></th>
								<td>
									<textarea name="project_content" id="project_content" cols="120" rows="15" readonly="readonly" >${corpProject.project_content}</textarea>
								</td>
							</tr>
							<tr>
								<th><span>사용 기술</span></th>
								<td>
									<c:forEach var="skill" items="${skillList}">
										<span>${skill.skill_name }, </span>
									</c:forEach>
								</td>	
							</tr>
						
							
							<tr>
								<th><span>비고</span></th>
								<td><p id="remarks"> ${corpProject.remarks} </p></td>	
							</tr>
							
						</tbody>
					</table>
				</div>
				</form>
				<div class="join_empArea">
					<div class="title">
						<h2>참가 사원</h2>
					</div>
					<div class="join_emp">
						<table>	
							<thead>
							<tr>
								<th>순번</th>
								<th>사번</th>
								<th>사원 이름</th>
								<th>부서</th>
								<th>직급</th>
								<th>역할</th>
							</tr>
							</thead>	
							<tbody>
								<c:forEach var="emp" items="${empList}">
									<tr>
										<td>${emp.emp_seq}</td>
										<td>${emp.emp_id}</td>
										<td>${emp.emp_name}</td>
										<td>${emp.dept_name}</td>
										<td>${emp.rank_name}</td>
										<td>${emp.role_name}</td>
									</tr>
								</c:forEach>
							</tbody>									
						</table>
					</div>
				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="button" id="projectSaveBtn" value="수정">
					<input type="button" value="목록" onclick="location.href='ProjectServlet?command=corp_project_list';">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>