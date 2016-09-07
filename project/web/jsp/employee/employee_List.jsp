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
<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>

<style type="text/css">
form {
	height: 100%;
}

.top {
	line-height: 80px;
}
#main {
	height: 630px;;
}


.empSearch {
	height: 10%;
}

.empList {
	height: 80%;
}

.empList table {
	width:100%;
	border-collapse: collapse;
	margin: 0 auto;
}

.empList th {
	background-color: #F6F6F6;
	font-weight: bold;
	border-bottom: 1px solid #eee;
	height: 25px;

}

.empList td {
	border-bottom: 1px solid #eee;
	height: 35px;
}

.empList tr {
	text-align: center;
}

.empList .empRow {
	
}

.empPaging {
	text-align: center;
}

.pageBlock {
	width: 100%;
	height: 100%;
	text-align: center;
}

.pageBlock strong {
/* 	line-height: 80px; */
	display: inline-block;
}
.block{
	cursor:pointer;
	width: 20px;
	display: inline-block;
}

.btnArea { 
	text-align: right;
}
.btnArea input {width:100px;}
.bottom .searchArea{
	margin-top:20px;
	text-align: center;
}
</style>

<script type="text/javascript">

	var keyword_value;
	var searchField_value;
	$(function(){
		window.scroll(0, 215);
		
		$(".empRow").hover(function(){
			$(this).css("background-color","#eee");
		},function(){

			$(this).css("background-color","white");
		});
		
		
		//검색 버튼 누를 시 실행되는 이벤트
		$("#searchBtn").click(function(){
			controllEmpList();
		});
		
		//EmployeeList Controll
		function controllEmpList(){
			var keyword =$(".keyword").val();
			var searchField =$(".searchField :selected").val();
			createEmpList(keyword,searchField,1);
		}
		
		//EmployeeList를 뿌려주는 함수
		function createEmpList(keyword, searchField, curPage){
			if(keyword==null)
				keyword="";
			if(searchField==null)
				searchField="";
			
			$(".employee_tbody").html("");
			$(".employee_thead").html("");
			
			$(".empPaging").html("");
			console.log(searchField+" "+keyword);
			
			$.ajax({
	    		url: "EmployeeServlet?command=ajax_search_employee"
	    	     , type:"post"
	    	     , data:{
	    	    	 'keyword':keyword
	    	       , 'searchField':searchField	 
	    	       , 'requestInfo':'empList'
	     	       , 'curPage': curPage
	    	    }
	     	     , dataType:"json" 
	    	     , success:function(result){
	    	    	 var curPage = result.curPage;
	    	    	 keyword_value = result.keyword;
	    	    	 searchField_value = result.searchField;  
	    	    	//JsonArray로 만든다.
	    	    	 var jsonArray=JSON.parse(result.empList);
	    	    	 $(".employee_thead").append(
	    	    	   +"<tr>"
	    	    	   +"<th>순번</th>"
	    	    	   +"<th>사번</th>"
	    	    	   +"<th>이름</th>"
	    	    	   +"<th>부서</th>"
	    	    	   +"<th>직급</th>"
	    	    	   +"<th>입사일</th>"
	    	    	   +"</tr>");
	    			 var count = 0;
	    	    	 for(;count<jsonArray.length;count++){
	    	    		//JsonObject를 한개씩 꺼낸다.
	    	    	 	var JsonObject=JSON.stringify(jsonArray[count]);
	    	    	 	//JsonObject를 파싱한다.
	    	    	 	var emp =JSON.parse(JsonObject);
	    	    	 	$(".employee_tbody").append(
	    	    	 	  "<tr class='empRow'>"
	    				 +"<td>"+emp.emp_seq+"</td>"
	    				 +"<td>"+emp.emp_id+"</td>"
	    				 +"<td><a href='EmployeeServlet?command=employee_info&emp_id="+emp.emp_id+"'>"+emp.emp_name+"</a></td>"
	    				 +"<td>"+emp.dept_name+"</td>"
	    				 +"<td>"+emp.rank_name+"</td>"
	    				 +"<td>"+emp.enter_dt+"</td>"
	    				 +"</tr>"	
	    	    	 	);
	    	    	 }     
	    	    	 
	    	    	$(".empPaging").append("<div class='pageBlock'><p>");
	    	        if(result.prevPage!=0){
		    	    	 $(".empPaging").append("<strong id='prevPage'>[<]</strong>");
		    	    	 $("#prevPage").on("click",function(){
		    	    		 createEmpList(keyword_value,searchField_value,result.prevPage);
		    	    	 });
	    	    	}	
	    			for(var start=result.firstBlock;start<=result.lastBlock;start++){
	    				 $(".empPaging").append("<strong class='block' id='p"+start+"'>"+start+"</strong>");
	    				 if(start==curPage)
	    					 $("#p"+start).css("color","red");
	    				 $("#p"+start).on("click",function(){
	    	    				createEmpList(keyword_value,searchField_value,$(this).text());
	    	    			});
	    			}
	    			if(result.nextPage!=0){			
		    			 $(".empPaging").append("<strong id='nextPage'>[>]</strong>");			
		    			 $("#nextPage").on("click",function(){
		    	    		 createEmpList(keyword_value,searchField_value,result.nextPage);
		    	    	 });
	    			} 
	    			$(".empPaging").append("</p></div>");
	    	    }
	     	     
	     	     ,error:function(msg1,msg2,msg3){
	    	    	alert(msg1+" "+msg2+""+msg3);
	    	    }
	    	}); 
		} 
		createEmpList();
	});
	

	
	
	
</script>
</head>
<body>

	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="top">			
			<h2>사원 리스트</h2>
			<hr>
			</div>
			<div class="middle">
				<form action="EmployeeServlet?" id="frm" method="post">			
					<input type="hidden" value="employee_info" name="command">
					<input type="hidden" name="emp_id" id="emp_id">
				<div class="empSearch"></div>
				<div class="empList">
					<table>
						<thead class="employee_thead">
							<tr>
								<th>순번</th>
								<th>사번</th>
								<th>이름</th>
								<th>부서</th>
								<th>직급</th>
								<th>입사일</th>
							</tr>
						</thead>
						<tbody class="employee_tbody">			
						</tbody>
					</table>
				</div>
				<div class="btnArea">
					<input type="button" value="사원 추가" onclick="location.href='EmployeeServlet?command=employee_addform';">
				</div>
				<div class="empPaging">
				</div>     
				</form>
			</div>
			<div class="bottom">
				<div class="searchArea">
					<select class="searchField">
						<option value="emp_id" selected="selected">사번</option>
						<option value="emp_name">이름</option>
						<option value="dept_name">부서</option>
						<option value="rank_name">직급</option>
					</select>
					<input type="text" class="keyword">
					<input type="button" value="검색" id="searchBtn">
				</div>
				
			
			</div>			
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>