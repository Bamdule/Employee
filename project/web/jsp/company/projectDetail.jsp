<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 상세</title>

<script type="text/javascript" src="/project/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		<jsp:include page="/js/header.js"></jsp:include>
		
		$(":button").css("width","100");
		$("#golist").click(function(){
			$(location).attr('href','/project/jsp/company/projectList.jsp');
		});
	});
</script>
<link type="text/css" rel="stylesheet" href="/project/css/common.css"  ></link>
<style type="text/css">

table {width:100%;border-collapse: collapse;  }
td {border: 1px solid #D5D5D5; color:#444; text-align: center;}
th {border: 1px solid #D5D5D5;padding-left : 10px; font-weight:bold; background-color: #E4F7BA; color:#333;}
#main .top{height:10%;}
#main .middle{height:80%;}
#main .bottom{height:10%;}

#main .top .title{line-height: 80px;}
#main .middle .projectDetail{height:60%;}
#main .middle .projectDetail table{text-align: left;}
#main .middle .enterStaff{height:40%;}



#main .middle .enterStaff .frame table td{width:100px;}
#main .middle .enterStaff .frame table th{width:100px;}

#main .bottom { text-align: right;}

.enterStaff .first_td {width:265px;}
.projectDetail td{height:35px;}
.projectDetail .project_content{height:150px;overflow:auto;}
</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

	<div id="main">
	  <div class="container">
		<div class="top">
		  <div class="title">
		 	<h2>프로젝트 상세</h2>
		  </div>
		</div>
		<div class="middle">
		    <div class="projectDetail">
		    	<table>
		    		<tr>
		    			<th>작성자</th>
		    			<td>홍길동</td>
		    		</tr>
		    		<tr>
		    			<th>부서</th>
		    			<td>개발부 , 디자인부</td>
		    		</tr>
		    		<tr>
		    			<th>프로젝트 명</th>
		    			<td>신한은행 뱅크 어플리케이션 기능 업데이트</td>
		    		</tr>
		    		<tr>
		    			<th>프로젝트 기간</th>
		    			<td>2016-07-23 ~ 2017-03-23</td>
		    		</tr>
		    		<tr>
		    			<th>프로젝트 사용 기술</th>
		    			<td>JavaScript, Jquery, Spring Framework, C#, JAVA</td>
		    		</tr>
		    		<tr>
		    			<th>프로젝트 내용</th>
		    			<td>
		    				<div class="project_content">	
		    					<p>신한은행 앱 업데이트</p>
		    					<p>기능</p>
		    					<p>1. UI 개선</p>
		    					<p>2. 앱 이동간 속도 개선</p>
		    					<p>3. 계좌이체 기능 추가</p>
		    					<p>4. 영화 보기 기능 및 MP3 기능 추가</p>
		    					<p>5. 회원가입이 되지 않았던 문제 수정</p>
		    					<p>6. 각종 버그 수정</p>
		    				</div>
		    			</td>
		    		</tr>
		    	</table>
		    </div>
		    <div class="enterStaff">
		      <table class="frame">
		        <tr>
		        	<th class="first_td">참가 인원</th>
		        	<td>
		        	<div style="width:100%; height:250px; overflow:auto">
		        		<table>
		        			<tr>	
			    			    <th>번호</th>
			    			    <th>이름</th>
			    			    <th>기술</th>
			    			    <th>역할</th>
		        			<tr>
		        			<tr>
		        			    <td>1</td>
		    			        <td>박찬호</td>
		    			        <td>jquery</td>
		    			        <td>PM</td>	
		        			</tr>
		        			<tr>
				    			<td>1</td>
				    			<td>허각</td>
				    			<td>C#	</td>
				    			<td>PM</td>
		    			
				    		</tr>
				    		<tr>
				    	
				    			<td>1</td>
				    			<td>김기수</td>
				    			<td>C</td>
				    			<td>PM</td>		
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>	
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>	
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>	
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>
				    		<tr>		    			
				    			<td>1</td>
				    			<td>최인철</td>
				    			<td>JAVA</td>
				    			<td>PM</td>
				    		</tr>		
		        		</table>
		        		</div>
		        	</td>
		        </tr>
		      </table>
		    </div>
		</div>
		<div class="bottom">
		  <input type="button" value="목록" id="golist"/>
		  <input type="button" value="수정" id="update" style="display: none;"/> 
		</div>
	  </div>
	</div>

<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>