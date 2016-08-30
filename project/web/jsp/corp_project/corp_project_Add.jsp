<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script type="text/javascript">
$( function() {
    $( "#start_dt" ).datepicker({
    	dateFormat: "yy-mm-dd"
    });
    
    $( "#end_dt" ).datepicker({
    	dateFormat: "yy-mm-dd"
    });
});

</script>
<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
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
.join_empArea{height:300px;}
.skillArea {width: 150px; display: inline-block; margin-left: 5px; margin-top: 5px;}


</style>
</head>
<!-- 
		project_id		varchar2(15)
      ,	project_name		varchar2(30)
      ,	corp_name		varchar2(30)
      ,	start_dt		Date
      ,	end_dt			Date
      ,	project_content	varchar2(3000)
      ,	corp_own	char(1)		default '1'	
      ,	remarks		varchar2(300)	 
-->

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
				<div class="projectArea">
					<table>
						<tbody>
							<tr>
								<th><span>프로젝트 이름</span></th>
								<td><input type="text" name="" id="" class="input_type5"></td>
							</tr>
							<tr>
								<th><span>회사 이름</span></th>
								<td><input type="text" name="" id="" class="input_type4"></td>
							</tr>
							<tr>
								<th><span>회사 구분</span></th>
								<td>
									<select>
										<option value="내부" selected="selected">내부</option>
										<option value="외부">외부</option>
									</select>
								</td>
							</tr>
							<tr>
								<th><span>시작 일</span></th>
								<td><input type="text" name="" id="start_dt" class="input_type2"></td>
							</tr>
							<tr>
								<th><span>종료 일</span></th>
								<td><input type="text" name="" id="end_dt" class="input_type2"></td>
							</tr>
							<tr>
								<th><span>프로젝트 내용</span></th>
								<td>
									<textarea cols="120" rows="15">
									</textarea>
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
								<th>참가 인원</th>
								<td>
									<div class="join_empArea">
										<table>
											
										</table>
									</div>
								<td>
							</tr>
							
							<tr>
								<th><span>비고</span></th>
								<td><input type="text" name="" id="" class="input_type3"></td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="button" value="저장">
					<input type="button" value="취소">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>