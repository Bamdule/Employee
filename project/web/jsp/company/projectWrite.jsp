<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script type="text/javascript" src="/project/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		<jsp:include page="/js/header.js"></jsp:include>
		
		$(":reset").click(function(){
			
		});
	});
</script>
<link type="text/css" rel="stylesheet" href="/project/css/common.css"  ></link>
<style type="text/css">

td {width:150px;height:50px; border: 1px solid #D5D5D5;}
#main{height:1000px;}

#main .top{height:10%;}
#main .middle{height:80%;}
#main .bottom{height:10%; line-height: 80px; text-align: right;}
#main .bottom input{width:100px;}
#main .top .title{line-height: 80px;}

#main .middle table{width:100%;heigth:100%;border-collapse: collapse; text-align: left;}
#main .middle .project th{text-align:center;width:100px;border: 1px solid #D5D5D5; font-weight: bold; background-color: #E4F7BA;}
#main .middle .project td{ text-align:center; }

#main .middle .project{height:60%;}
#main .middle .staff{height:40%;}
#main .middle form{height:100%;}

.staff th{width:150px; background-color: #E4F7BA; text-align: center; border: 1px solid #D5D5D5;}
.staff td{text-align: center;width:100px;}

textarea {width:100%; resize:none; border:none;}
#skill {padding:10px; display: inline-block;}
#pname {width:100%; height:100%; border:none;}
.staff #searchStaff td{width:100px;}
.staff #searchStaff p {text-align: right;}


</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

	<div id="main">
	  <div class="container">
		<div class="top">
		  <div class="title">
		 	<h2>프로젝트 내용 작성</h2>
		  </div>
		</div>
		<div class="middle">
		<form action="#" method="post">
		  <div class="project">
		  <table>
		    <tr>
		      <th>등록자</th>
		      <td>홍길동</td>
		    </tr>
		    <tr>
		      <th>부서</th>
		      <td>개발부</td>
		    </tr>
		    <tr>
		      <th>프로젝트 이름</th>
		      <td><input type="text" name="pname" id="pname"/></td>
		    </tr>
		    <tr>
		      <th>프로젝트 기간</th>
		      <td><input type="date" name="beforeDate" id="beforeDate"/> ~ <input type="date" name="afterDate" id="afterDate"/>
		      </td>
		    </tr>
		    <tr>
		      <th>프로젝트 내용</th>
		      <td><textarea cols="" rows="7"></textarea></td>
		    </tr>
		    <tr>
		      <th>프로젝트 사용기술</th>
		      <td>
		      <p><input type="checkbox" id="skill" name="skill" value="1"/>JAVA
		         <input type="checkbox" id="skill" name="skill" value="2"/>JavaScript
		         <input type="checkbox" id="skill" name="skill" value="3"/>JQuery
		         <input type="checkbox" id="skill" name="skill" value="4"/>JSP
		         <input type="checkbox" id="skill" name="skill" value="5"/>Servlet
		         <input type="checkbox" id="skill" name="skill" value="6"/>HTML
		         <input type="checkbox" id="skill" name="skill" value="7"/>CSS
		         <input type="checkbox" id="skill" name="skill" value="8"/>Node.JS
		      </p>
		         <input type="checkbox" id="skill" name="skill" value="1"/>Oracle
		         <input type="checkbox" id="skill" name="skill" value="2"/>Mysql
		         <input type="checkbox" id="skill" name="skill" value="3"/>Mssql
		         <input type="checkbox" id="skill" name="skill" value="4"/>C
		         <input type="checkbox" id="skill" name="skill" value="5"/>C++
		         <input type="checkbox" id="skill" name="skill" value="6"/>C#
		         <input type="checkbox" id="skill" name="skill" value="7"/>Android
		         <input type="checkbox" id="skill" name="skill" value="8"/>IOS
		      </td>
		    </tr>
		  </table>
		  </div>
		  <div class="staff">
		    <table>
		      <tr>
		        <th rowspan="3">프로젝트 참가인원</th>
		        
		      </tr>      
		      <tr>
		        <th>사원이름</th>
		        <th>사원기술</th>
		        <th>역할</th>
		        <th>부서</th>
		      </tr>
		       
		      <tr>
		        <td colspan="4">
		          <div style="width:100%; height:250px; overflow:auto" id="staffList">
		          <table>
		            <tr>
		      	      <td>홍길동</td>
		              <td>Jquery</td>
		              <td>개발</td>
		              <td>개발부</td>
		            </tr>
		            <tr>
		      	      <td>홍길동</td>
		              <td>Jquery</td>
		              <td>개발</td>
		              <td>개발부</td>
		            </tr>
		            <tr>
		      	      <td>홍길동</td>
		              <td>Jquery</td>
		              <td>개발</td>
		              <td>개발부</td>
		            </tr>
		            <tr>
		      	      <td>홍길동</td>
		              <td>Jquery</td>
		              <td>개발</td>
		              <td>개발부</td>
		            </tr>
		            <tr>
		      	      <td>홍길동</td>
		              <td>Jquery</td>
		              <td>개발</td>
		              <td>개발부</td>
		            </tr>
		            <tr>
		      	      <td>홍길동</td>
		              <td>Jquery</td>
		              <td>개발</td>
		              <td>개발부</td>
		            </tr>
		           </table>
		           </div>
		        </td>
		      </tr>
		    </table>
		   <p><input type="button" id="searchStaff" value="사원 검색"/></p>
		  </div>
		  </form>
		  
		</div>
		<div class="bottom">
			<input type="button" value="저장" id="savebtn"/>
			<input type="reset" value="취소" />
		</div>
	  </div>
	</div>

<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>