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

<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<script type="text/javascript">

var empList = new Array();
$( function() {
	var empList ;
	var emp_tbody = $(".empListFrame"); 
    
    $( "#start_dt" ).datepicker({
	    	dateFormat: "yy-mm-dd"
	      , changeYear: true
	      , changeMonth: true
	      , onSelect: function(selected) {
	    	  $( "#end_dt" ).datepicker("option","minDate", selected)
	    	}
	      , prevText: '이전 달'
	      , nextText: '다음 달'
	      , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
	      , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
	      , dayNames: ['일', '월', '화', '수', '목', '금', '토']
	      , dayNamesShort: ['일', '월', '화', '수', '목', '금', '토']
	      , dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
	    });
    
    $( "#end_dt" ).datepicker({
    	dateFormat: "yy-mm-dd"
      , changeYear: true
      , changeMonth: true
      , onSelect: function(selected) {
    	 $( "#start_dt" ).datepicker("option","maxDate", selected)
    	}
      , prevText: '이전 달'
      , nextText: '다음 달'
      , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
      , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
      , dayNames: ['일', '월', '화', '수', '목', '금', '토']
      , dayNamesShort: ['일', '월', '화', '수', '목', '금', '토']
      , dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
    });
});

function data_submit(){
	$("#frm").submit();
}
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
					<h2>개인 프로젝트 작성</h2>
					<hr>
				</div>
			</div>
			<div class="middle">
				<div class="blank">
				</div>
				
				<div class="projectArea">
					<form method="post" action="ProjectServlet?command=emp_project_add" id="frm">
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
										<option value="외부" selected="selected">외부</option>
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
								<th><span>수행역할</span></th>
								<td><input type="text" name="role" id="role" class="input_type3"></td>
							</tr>
							
						</tbody>
					</table>
					</form>
				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="button" id="projectSaveBtn" value="프로젝트 저장" onclick="data_submit();">
					<input type="button" value="취소" >
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>