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

<!--datePicker-->
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<!--datePicker-->


 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
 <script>
	var nameReg=/^[가-힣a-z]{2,20}$/;
/* 	var pwdReg=/^[^\s]{4,13}$/;
	var front_res_Reg=/^[0-9]{6}$/;
	var back_res_Reg=/^[0-9]{7}$/;
	var phone_Reg=/^[0-9]{10,11}$/;
	var front_email_Reg=/^\w{5,12}$/;
	var back_email_Reg=/^[a-z]{2,10}[\.][a-z]{2,3}$/;
	var enter_dt_Reg=/^(19[2-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	var emp_sal_Reg =/^[0-9]{2,10}$/; */
 	var date_Reg=/^(19[2-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;

 	var academic_Flag=1;
	var tabSelector=0;
	  function specFormDelete(o)
	  {
		  o.remove();
		/*  o.eq(o.index()).remove();
	    */
	  }
	  

	  function validation(values,reg,msg)
	  {
		  for(var i=0;i<values.length;i++){
				if (!(reg.test(values[i].value))) {
					alert(msg);
					values[i].focus();
					return false;
				} 
		  }
		 return true;  
	  }
	  
	  function changeArray(o)
	  {
		  for(var i=0; i<o.length;i++)
		  {
				o[i]=o[i].value;  
		  }
		  return o;
	  }
  $( function() {
	   $("#saveBtn").click(function(){
		   var valid=true;
		   
		  var academic_level_selector = $("#academic_tbody #academicArea #academic_level_selector").map(function(){
			   return this;
		   }).get();
		  var academic_name = $("#academic_tbody #academicArea #academic_name").map(function(){
			   return this;
		   }).get();
		  var major_name = $("#academic_tbody #academicArea #major_name").map(function(){
			   return this;
		   }).get();
		  var academic_status_selector = $("#academic_tbody #academicArea #academic_status_selector").map(function(){
			   return this;
		   }).get();
		  var enter_dt = $("#academic_tbody #academicArea .enter_dt").map(function(){
			   return this;
		   }).get();
		  var graduation_dt = $("#academic_tbody #academicArea .graduation_dt").map(function(){
			   return this;
		   }).get();
		  
		  if($("#academic_tbody").children().length==1&& (academic_name[0].value.length==0&&major_name[0].value.length==0&&enter_dt[0].value.length==0&&graduation_dt[0].value.length==0))
		  {
			academic_Flag=0;			 
		  }
		  else if($("#academic_tbody").children().length!=0){
			  valid=valid&&validation(academic_name,nameReg,"학교이름은 영어또는 한글로 적어주시고, 3글자 이상 입력해주세요.");
			  valid=valid&&validation(major_name,nameReg,"전공이름은 영어또는 한글로 적어주시고, 3글자 이상 입력해주세요.");
			  valid=valid&&validation(enter_dt,date_Reg,"입학 일자를 (ex: 2016-04-02) 형식으로 입력해주세요.");
			  valid=valid&&validation(graduation_dt,date_Reg,"졸업 일자를 (ex: 2016-04-02) 형식으로 입력해주세요.");  
			  academic_Flag=1;
		  }
		  else
			  academic_Flag=0;
		   
		  
	/* 	   academic_name=changeArray(academic_name);
		   
		  for(var i=0; i<academic_name.length;i++)
			  console.log(academic_name[i]);
		     */
		  console.log(academic_Flag);
 		  $.ajax({
			   url:"EmployeeServlet?command=ajax_employee_spec_add"
		     , type:'post'
			 , data:{
				   'emp_id':'${emp_id}'
				 , 'academic_Flag':academic_Flag
				 , 'academic_level_selector':changeArray(academic_level_selector)  
				 , 'academic_name':changeArray(academic_name)
				 , 'major_name':changeArray(major_name)
				 , 'academic_status_selector':changeArray(academic_status_selector)
				 , 'enter_dt':changeArray(enter_dt)
				 , 'graduation_dt':changeArray(graduation_dt)
			 }
		     , dataType:'json'
		     , succsess: function(result){
		    	 alert(result);
		     },
		     error:function(request,status,error){
				  alert(request+' '+status+' '+error);	
		     }
			  
		  }); 
	/* 	   for(var i=0; i<academic_level_selector.length;i++)
			  alert(academic_level_selector[i].value+" "+academic_name[i].value+" "+major_name[i].value+" "+academic_status_selector[i].value+" "+enter_dt[i].value+" "+graduation_dt[i].value+" ");
		     */
	   });

	  

	  
	  
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
    
    function createAcademicForm()
    {
    	var index=$("#academic_tbody").children().length;
   		$("#academic_tbody").append(
   				"<tr id='academicArea'><td>"
   					+"<select id='academic_level_selector'>"
   						+"<c:forEach var='academic_level' items='${academicLevelList}'>"
   							+"<option value='${academic_level.academic_lev_id}'>${academic_level.academic_lev_name}</option>"
   						+"</c:forEach>"
   					+"</select>"
   				+"</td>"													
   				+"<td>"
   					+"<input type='text' id='academic_name' name='academic_name' >"
   				+"</td>"									
   				+"<td>"
   					+"<input type='text' id='major_name' name='major_name' >"
   				+"</td>"
   				+"<td>"
   					+"<select id='academic_status_selector'>"
   						+"<c:forEach var='academic_status' items='${academicStatusList}'>"
   							+"<option value='${academic_status.academic_status_id}'>${academic_status.academic_status_name}</option>"
   						+"</c:forEach>"
   					+"</select>"	
   				+"</td>"							
   				+"<td>"
   					+"<input type='text' class='enter_dt' name='enter_dt' id='ac_enter"+index+"' >"
   				+"</td>"
   				+"<td>"
   					+"<input type='text' class='graduation_dt' name='graduation_dt' id='ac_grad"+index+"'>"
   				+"</td>"
   				+"<td>"
   					+"<p id='deleteBtn' onclick='specFormDelete($(this).parent().parent());'>삭제</p>"
   				+"</td>"
   				+"</tr>");
   	    		
   				console.log("#ac_enter"+index);
   				console.log("#ac_grad"+index);
   				
   	    	    $( "#ac_enter"+index ).datepicker({
   	    	    	dateFormat: "yy-mm-dd"
   	    	    	  	
   	    	    });
   	    	    
   	    	    $("#ac_grad"+index).datepicker({
   	    	    	dateFormat: "yy-mm-dd"
   	    	    });
    }
    //스펙 추가버튼을 눌렀을 때
    $("#specAddBtn").click(function(){
    	switch(tabSelector)
    	{
    	case 0:
    		createAcademicForm();
    		break;
    	case 1:
    		break;
    	case 2:
    		break;
    	}
    });
    createAcademicForm();
  });
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
										<th></th>
									</tr>
									
								</thead>
								<tbody id="academic_tbody">
							<%-- 	<tr id='academicArea'>
									<td>
										<select id='academic_level_selector'>
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
										<select id='academic_status_selector'>
											<c:forEach var="academic_status" items="${academicStatusList}">
												<option value="${academic_status.academic_status_id}">${academic_status.academic_status_name}</option>
											</c:forEach>
										</select>		
									</td>							
									<td>
										<input type="text" id="enter_dt" name="enter_dt" >
									</td>
									<td>
										<input type="text" id="graduation_dt" name="graduation_dt">
									</td>
									<td>
										<p id='deleteBtn' onclick='specFormDelete($(this).parent().parent());'>삭제</p>
									</td>
								</tr> --%>
			
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