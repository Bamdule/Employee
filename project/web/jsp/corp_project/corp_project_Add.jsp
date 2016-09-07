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

/* <!-- 
private String project_id;
private String project_name;
private String corp_name;
private String start_dt;
private String end_dt;	
private String project_content;
private String corp_own;
private String remarks; --> */


var empList = new Array();
$( function() {

	$("#projectSaveBtn").on("click",function(){
	
		//var skills =[];
		var skills=$(".skillsArea :checked").map(function(){
			return this.value;
		}).get();

		var emp_roles=$(".eList select option:selected").map(function(){
			return this.value;
		}).get();
		
		for(var i=0; i<skills.length;i++){
			console.log(skills[i]);		
		}
		for(var j=0;j<empList.length;j++)
			console.log(empList[j]);
		
		for(var j=0;j<emp_roles.length;j++)
			console.log(emp_roles[j]);
		
		
		$.ajax({
    		url: "ProjectServlet?command=corp_project_add"
    	     , type:"post"
    	     , data:{'skills':skills
    	    	    ,'empList':empList
    	    	    ,'emp_roles':emp_roles
    	    	    ,project_name:$("#project_name").val()
    	    	 	,corp_name:$("#corp_name").val()
    	    	 	,start_dt:$("#start_dt").val()
    	    	 	,end_dt:$("#end_dt").val()
    	    	 	,project_content:$("#project_content").val()
    	    	 	,corp_own:$("#corp_own").val()
    	    	 	,remarks:$("#remarks").val()
    	    	 	 }
     	     , dataType:"json" 
    	     , success:function(result){
    	    	 if(result!=false)
    	    	 {
    	    		location.href="ProjectServlet?command=corp_project_info&project_id="+result; 
    	    	 }else
    	    	 	console.log('실패');
    	    }
    	}); 
		

		
		
	});
	
	var empList ;
	var emp_tbody = $(".empListFrame");
    var dialog = $("#empList_dialog" ).dialog({
        autoOpen: false,
        height: 700,
        width: 800,
        modal: true,
        buttons: {
          "사원 등록": registerEmp,
          "취소" : function() {
        	emp_tbody.html("");
            dialog.dialog( "close" );
          }
        },
        close: function() {
        }
      });
    
   
    $( "#start_dt" ).datepicker({
    	dateFormat: "yy-mm-dd"
    	
    	
    });
    
    $( "#end_dt" ).datepicker({
    	dateFormat: "yy-mm-dd"
    });
    

    $( "#dialog_open_btn" ).button().on( "click", function() {
    	dialog_EmpList();
        dialog.dialog( "open" );
      });
    
    //다이알로그에 사원 리스트를 뿌린다.
    function dialog_EmpList(){
    	empList=new Array();
    	for(var i =0 ; i<empList.length; i++)
     		empList.pop();		
    	$.ajax({
    		url: "ProjectServlet?command=ajax_emp_list"
    	     , type:"post"
    	     , success:function(result){
	    		for(var index=0;index<result.length;index++)
	    		{
	    			var jsonObject = JSON.stringify(result[index]);
	    			var emp_info = JSON.parse(jsonObject);
	    			emp_tbody.append(
	    	    			"<tr>"
	    	    				+"<td>"+emp_info.emp_seq+"</td>"
	    	    				+"<td>"+emp_info.emp_id+"</td>"
	    	    					+"<td>"+emp_info.emp_name+"</td>"
	    	    					+"<td>"+emp_info.dept_name+"</td>"
	    	    					+"<td>"+emp_info.rank_name+"</td>"	
	    	    				+"<td>"
	    	    					+"<span>"
	    	    						+"<input  id='check_emp' type='checkbox' value='"+emp_info.emp_id+"'>"
	    	    					+"</span>"
	    	    				+"</td>"
	    	    			+"</tr>"		
	    	    		);			
	    	    }
    	    }
    	}); 
	}

	//페이지에 사원 리스트를 뿌린다.
    function registerEmp(){
    	$(".eList").html("");//사원리스트 초기화
    	$(".empListFrame :checked").each(function(){
    		empList.push($(this).val());
    	});
    	emp_tbody.html("");//다이알로그 사원 리스트 초기화
    	if(empList.length!=0){
	    	$.ajax({
	    		url: "ProjectServlet?command=ajax_emp_list"
	    	     , type:"post"
	    	     , data : {'empList':empList}
	    	 	 , dataType : 'json'
	    	     , success:function(result){
	    	    	 for(var index=0;index<result.length;index++){
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

.projectArea td{
	width: 80%;
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


.dialog_empListArea{
	height: 95%;
}
.dialog_searchArea{
	text-align:right;
	height: 10%;
}

table {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
}

.dialog_empListArea table {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
}

.dialog_empListArea th{
	height: 25px;
	font-weight: bold;
	border-bottom: 1px solid #eee;
	background-color: #F6F6F6;
}
.dialog_empListArea td{
	height: 35px;
	border-bottom: 1px solid #eee;
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
								<th><span>프로젝트 이름</span></th>
								<td><input type="text" name="project_name" id="project_name" class="input_type5" maxlength="30"   placeholder="프로젝트 이름을 입력해주세요 "></td>
							</tr>
							<tr>
								<th><span>회사 이름</span></th>
								<td><input type="text" name="corp_name" id="corp_name" class="input_type4"   maxlength="20"   placeholder="회사 이름을 입력해주세요"></td>
							</tr>
							<tr>
								<th><span>회사 구분</span></th>
								<td>
									<select id="corp_own">
										<option value="내부" selected="selected">내부</option>
										<option value="외부">외부</option>
									</select>
								</td>
							</tr>
							<tr>
								<th><span>시작 일</span></th>
								<td><input type="text" name="start_dt" id="start_dt" class="input_type2" placeholder="프로젝트 시작일"></td>
							</tr>
							<tr>
								<th><span>종료 일</span></th>
								<td><input type="text" name="end_dt" id="end_dt" class="input_type2" placeholder="프로젝트 종료일"></td>
							</tr>
							<tr>
								<th><span>프로젝트 내용</span></th>
								<td>
									<textarea name="project_content" id="project_content" cols="120" rows="15"></textarea>
								</td>
							</tr>
							<tr>
								<th><span>사용 기술</span></th>
								<td>
									<div class="skillsArea">
									<c:forEach var="skill" items="${skillList}" varStatus="status">
											<span class="skillArea">
												<input type="checkbox" id="skills" name="skills" value="${skill.skill_id}"/>${skill.skill_name}
											</span>
											
										<c:if test="${status.count%4==0}">
											<br>				
										</c:if>
										
										
										</c:forEach>	
									</div>
								</td>
							</tr>
						
							
							<tr>
								<th><span>비고</span></th>
								<td><input type="text" name="remarks" id="remarks" class="input_type3"></td>
							</tr>
							
						</tbody>
					</table>
				</div>
				</form>
				<div class="join_empArea">
					<div class="title">
						<h2>참가 사원</h2>
						
					</div>
					<div class="btnArea">
						<input type="button" id="dialog_open_btn" value="사원 등록" >
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
							<tbody class="eList">
							</tbody>									
						</table>
					</div>
				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="button" id="projectSaveBtn" value="프로젝트 저장">
					<input type="button" value="취소" onclick="location.href='ProjectServlet';">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
	
	<div id="empList_dialog" title="사원 등록">
		<div class="dialog_searchArea"></div>
		<div class="dialog_empListArea">
			<table>
				<thead>
					<tr>
						<th>순번</th>
						<th>사번</th>
						<th>사원 이름</th>
						<th>부서</th>
						<th>직급</th>
						<th>선택</th>
					</tr>
				</thead>
				<tbody class="empListFrame">
				</tbody>
				
			</table>
		</div>
	</div>
</body>
</html>