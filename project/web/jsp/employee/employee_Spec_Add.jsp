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

<!--Tabs-->
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<!--Tabs-->
 <script>
	var nameReg=/^[가-힣a-zA-z]{1,20}$/;
	var IDReg=/^[가-힣a-zA-z0-9]{1,20}$/;
	var date_Reg=/^(19[2-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	var tabSelector=0;
	
	  //스펙 입력란 삭제
	  function specFormDelete(o)
	  {
		  o.remove();
	  }
	  
	  //사용자가 입력한 내용에 대해 옳바르게 입력했는지 검증한다.
	  function validation(values,reg,msg)
	  {
		  for(var i=0;i<values.length;i++){
			  console.log("values : "+values[i].value);
				if (!(reg.test(values[i].value))) {
					alert(msg);
					values[i].focus();
					return false;
				} 
		  }
		 return true;  
	  }
	  //요소들을 순수 String배열로 변환
	  function changeArray(o)
	  {
		  for(var i=0; i<o.length;i++)
		  {
				o[i]=o[i].value;  
		  }
		  return o;
	  }
	
  $( function() {
	   //저장 버튼을 눌렀을 때
	   $("#saveBtn").click(function(){

	    /*
	    		각 탭의 정보들이 DB에 저장될 수 있는지 검사한다.
			  	academic_Flag 
			  	career_Flag
			  	licence_Flag
			  	---------------------------------
			  	- 0 DB에 저장하지 않는다.
			  	- 1 DB에 저장한다.
		 */
		   var academic_Flag=0;
		   var career_Flag=0;
		   var licence_Flag=0;
		   var valid=true;
		   var academic_count = $("#academic_tbody").children().length;
		   var career_count   = $("#career_tbody").children().length;
		   var licence_count  = $("#licence_tbody").children().length;
		   
		   var academic_level_selector=[];
		   var academic_name=[];
		   var major_name=[];
		   var academic_status_selector=[];
		   var enter_dt=[];
		   var graduation_dt=[];
		   
		 
		   		   
		   console.log("academic_count : "+academic_count);
		   console.log("career_count : "+career_count);
		   console.log("licence_count : "+ licence_count);
		   
		  //학력 Check
		  if(academic_count>0){
			  academic_level_selector = $("#academic_tbody #academicArea #academic_level_selector").map(function(){
				   return this;
			   }).get();
			  academic_name = $("#academic_tbody #academicArea #academic_name").map(function(){
				   return this;
			   }).get();
			  major_name = $("#academic_tbody #academicArea #major_name").map(function(){
				   return this;
			   }).get();
			  academic_status_selector = $("#academic_tbody #academicArea #academic_status_selector").map(function(){
				   return this;
			   }).get();
			  enter_dt = $("#academic_tbody #academicArea .enter_dt").map(function(){
				   return this;
			   }).get();
			  graduation_dt = $("#academic_tbody #academicArea .graduation_dt").map(function(){
				   return this;
			   }).get();
			  
			  //학력 입력폼이 한개이고, 입력 폼 안에 값들이 없을 때
			  if(academic_count==1&& (academic_name[0].value.length==0&&major_name[0].value.length==0
				 &&enter_dt[0].value.length==0&&graduation_dt[0].value.length==0)){
				academic_Flag=0;			 
			  }
			  //입력 폼이 한개 이상일 때, 모든 폼을 검증한다.
			  else if(academic_count!=0){
				  valid=valid&&validation(academic_name,nameReg,"학교이름은 영어또는 한글로 적어주시고, 3~20자 사이로 입력해주세요.");
				  valid=valid&&validation(major_name,nameReg,"전공이름은 영어또는 한글로 적어주시고, 3~20자 사이로 입력해주세요.");
				  valid=valid&&validation(enter_dt,date_Reg,"입학 일자를 (ex: 2016-04-02) 형식으로 입력해주세요.");
				  valid=valid&&validation(graduation_dt,date_Reg,"졸업 일자를 (ex: 2016-04-02) 형식으로 입력해주세요.");  
				  if(valid)
				  	academic_Flag=1;
			  }
		  }
		   var corp_name=[];
		   var rank_name=[];
		   var emp_role=[];
		   var career_enter_dt=[];
		   var career_retire_dt=[];
		   

		  //학력 Check
		  if(career_count>0){
			  corp_name = $("#career_tbody #careerArea #corp_name").map(function(){
				   return this;
			   }).get();
			  rank_name = $("#career_tbody #careerArea #rank_name").map(function(){
				   return this;
			   }).get();
			  emp_role = $("#career_tbody #careerArea #emp_role").map(function(){
				   return this;
			   }).get();
			  career_enter_dt = $("#career_tbody #careerArea .career_enter_dt").map(function(){
				   return this;
			   }).get();
			  career_retire_dt = $("#career_tbody #careerArea .career_retire_dt").map(function(){
				   return this;
			   }).get();
			  
			  //학력 입력폼이 한개이고, 입력 폼 안에 값들이 없을 때
			  if(career_count==1&& (corp_name[0].value.length==0&&rank_name[0].value.length==0&&emp_role[0].value.length==0&&career_enter_dt[0].value.length==0&&career_retire_dt[0].value.length==0))
			  {
				career_Flag=0;			 
			  }
			  //입력 폼이 한개 이상일 때, 모든 폼을 검증한다.
			  else if(career_count!=0){
				  valid=valid&&validation(corp_name,nameReg,"회사이름은 영어 또는 한글로 적어주시고, 3~20자 사이로 입력해주세요.");
				  valid=valid&&validation(rank_name,nameReg,"직급이름은 영어 또는 한글로 적어주시고, 3~20자 사이로 입력해주세요.");
				  valid=valid&&validation(emp_role,nameReg,"수행역할이름은 영어 또는 한글로 적어주시고, 3~20자 사이로 입력해주세요.");
				  valid=valid&&validation(career_enter_dt,date_Reg,"입사 일을 (ex: 2016-04-02) 형식으로 입력해주세요.");
				  valid=valid&&validation(career_retire_dt,date_Reg,"퇴사 일를 (ex: 2016-04-02) 형식으로 입력해주세요.");  
				  if(valid)
					  career_Flag=1;
			  }
		  }
		  
		   var institution=[];
		   var licence_name=[];
		   var licence_number=[];
		   var get_dt=[];
		   var ins_type=[];
		  //경력 check
		  if(licence_count>0){
			  institution = $("#licence_tbody #licenceArea #institution").map(function(){
				   return this;
			   }).get();
			  licence_name = $("#licence_tbody #licenceArea #licence_name").map(function(){
				   return this;
			   }).get();
			  licence_number = $("#licence_tbody #licenceArea #licence_number").map(function(){
				   return this;
			   }).get();
			  get_dt = $("#licence_tbody #licenceArea .get_dt").map(function(){
				   return this;
			   }).get();
			  ins_type = $("#licence_tbody #licenceArea #ins_type").map(function(){
				   return this;
			   }).get();
			  
			  //학력 입력폼이 한개이고, 입력 폼 안에 값들이 없을 때
			  if(licence_count==1&& (institution[0].value.length==0 && licence_name[0].value.length==0 && licence_number[0].value.length==0 && get_dt[0].value.length==0))
			  {
				 licence_Flag=0;			 
			  }
			  //입력 폼이 한개 이상일 때, 모든 폼을 검증한다.
			  else if(licence_count!=0){
				  valid=valid&&validation(institution,nameReg,"시행기관은 영어 또는 한글로 적어주시고, 3~20자 사이로 입력해주세요.");
				  valid=valid&&validation(licence_name,nameReg,"자격증이름은 영어 또는 한글로 적어주시고, 3~20자 사이로 입력해주세요.");
				  valid=valid&&validation(licence_number,IDReg,"자격증코드는 영어,숫자,한글 형식으로 적어주시고, 3~20자 사이로 입력해주세요.");
				  valid=valid&&validation(get_dt,date_Reg,"취득 일을 (ex: 2016-04-02) 형식으로 입력해주세요.");
				  if(valid)
					  licence_Flag=1;
			  }
		  }

		  	 console.log("academic_Flag : "+academic_Flag);
			 console.log("career_Flag : "+career_Flag);
			 console.log("licence_Flag : "+licence_Flag);

		  if(valid)
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
				 
				 , 'career_Flag':career_Flag
				 , 'corp_name':changeArray(corp_name)
				 , 'rank_name':changeArray(rank_name)
				 , 'emp_role':changeArray(emp_role)
				 , 'career_enter_dt':changeArray(career_enter_dt)
				 , 'career_retire_dt':changeArray(career_retire_dt)
				 
				 , 'licence_Flag':licence_Flag
				 , 'institution':changeArray(institution)
				 , 'licence_name':changeArray(licence_name)
				 , 'licence_number':changeArray(licence_number)
				 , 'get_dt':changeArray(get_dt)
				 , 'ins_type':changeArray(ins_type)
			 }
		     , dataType:'json'
		     , success:function(result){
		    	console.log("result : "+result);
		    	if(result==true)
		    	 location.href='EmployeeServlet?command=employee_info&emp_id=${emp_id}';
		     },
		     error:function(request,status,error){
				  alert(request+' '+status+' '+error);	
		     }
			  
		  });    
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
    function settingDataPicker(start,end)
    {
    	start.datepicker({
   	    	dateFormat: "yy-mm-dd"
   	      , changeYear: true
   	      , changeMonth: true
   	      , onSelect: function(selected) {
   	    	end.datepicker("option","minDate", selected)
   	    	}
   	      , prevText: '이전 달'
   	      , nextText: '다음 달'
   	      , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
   	      , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
   	      , dayNames: ['일', '월', '화', '수', '목', '금', '토']
   	      , dayNamesShort: ['일', '월', '화', '수', '목', '금', '토']
   	      , dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
   	    });
   	    
    	end.datepicker({
   	    	dateFormat: "yy-mm-dd"
   	      , changeYear: true
   	      , changeMonth: true
   	      , onSelect: function(selected) {
   	    	start.datepicker("option","maxDate", selected)	
   	   		}
   	      , prevText: '이전 달'
	   	  , nextText: '다음 달'
	   	  , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
	   	  , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
	   	  , dayNames: ['일', '월', '화', '수', '목', '금', '토']
	   	  , dayNamesShort: ['일', '월', '화', '수', '목', '금', '토']
	   	  , dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'] 
   	    });
    }

    //학력 입력 폼 생성
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
   	    		
   				settingDataPicker( $("#ac_enter"+index ),$("#ac_grad"+index));
    }

    //경력 입력 폼 생성
    function createCareerForm(){
       	var index=$("#career_tbody").children().length;
   		$("#career_tbody").append(
   			"<tr id='careerArea'>"														
				+"<td>"
					+"<input type='text' id='corp_name' name='corp_name' >"
				+"</td>"									
				+"<td>"
					+"<input type='text' id='rank_name' name='rank_name' >"
				+"</td>"							
				+"<td>"
					+"<input type='text' id=emp_role name='emp_role' >"
				+"</td>"	
				+"<td>"
					+"<input type='text' id='career_enter_dt"+index+"' class='career_enter_dt' name='career_enter_dt' >"
				+"</td>"
				+"<td>"
					+"<input type='text' id='career_retire_dt"+index+"' class='career_retire_dt' name='career_retire_dt' >"
				+"</td>"
				+"<td>"
					+"<p id='deleteBtn' onclick='specFormDelete($(this).parent().parent());'>삭제</p>"
				+"</td>"
			+"</tr> ");
   		settingDataPicker( $("#career_enter_dt"+index ),$("#career_retire_dt"+index));
    }
    //자격증입력 폼 생성
    function createLicenceForm()
    {
    	var index=$("#licence_tbody").children().length;
		$("#licence_tbody").append(
    	"<tr id='licenceArea'>"														
			+"<td>"
				+"<input type='text' id='institution' name='institution' >"
			+"</td>"									
			+"<td>"
				+"<input type='text' id='licence_name' name='licence_name' >"
			+"</td>"							
			+"<td>"
				+"<input type='text' id=licence_number name='licence_number' >"
			+"</td>"	
			+"<td>"
				+"<input type='text' id='get_dt"+index+"'class='get_dt' name='get_dt' >"
			+"</td>"
			+"<td>"
				+"<select id='ins_type'>"
					+"<option value='국가' selected='selected'>국가</option>"
					+"<option value='민간'>민간</option>"
				+"</select>"
			+"</td>"
			+"<td>"
				+"<p id='deleteBtn' onclick='specFormDelete($(this).parent().parent());'>삭제</p>"
				
			+"</td>"
		+"</tr>");

   		settingDataPicker( $("#get_dt"+index),$("#expire_dt"+index));
    }
    
    //스펙 추가버튼을 눌렀을 때
    $("#specAddBtn").click(function(){
    	switch(tabSelector)
    	{
    	case 0:
    		createAcademicForm();
    		break;
    	case 1:
    		createCareerForm();
    		break;
    	case 2:
    		createLicenceForm();
    		break;
    	}
    });
    
    
    createAcademicForm();
    createCareerForm();
    createLicenceForm();
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
		font-size:13px;
		border-bottom: 1px solid #eee;
	}
	.emp_specArea input{
	width: 150px;
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
/* 		background-color: #F6F6F6;	 */
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
										<th></th>
									</tr>
								</thead>
								<tbody id="career_tbody">	
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
										<th></th>
									</tr>
								</thead>
								<tbody id="licence_tbody">
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="button" id="saveBtn" value="모두 저장">
					<input type="button" id="cancelBtn" value="취소">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
	</div>
</body>
</html>