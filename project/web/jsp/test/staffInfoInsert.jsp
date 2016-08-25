<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<!-- <script type="text/javascript" src="js/staff.js"></script> -->
<script type="text/javascript">
	$(function(){
		<jsp:include page="/js/header.js"></jsp:include>
	
		$(":text").css("width","100%");
		$(":text").css("height","100%");
		$(":text").css("border","none");
		
	});
	
	var black_pattern = /\s/g;

	function staffInsertCheck(){
		var name=$("#staff_name").val();
		var front_resNum=$("#front_resident_num").val();
		var back_resNum=$("#back_resident_num").val();
 		
		var phone=$("#staff_phone").val();
		var addr=$("#staff_addr").val();
		var addrdetail=$("#staff_addrdetail").val();
		var enter_date=$("#enter_date").val();
		var retire_date=$("#retire_date").val();
		var img_path =$("#staff_img_path").val();
		var salary =$("#salary").val();	
		var dept_id=$("#dept_id").val();
		var rank_id=$("#rank_id").val(); 

		alert("name : "+name);
		alert("resNum : "+front_resNum + back_resNum);
		alert("phone : "+phone);
		alert("addr : "+addr);
		alert("addrdetail : "+addrdetail);
				
		alert("enter_date : "+enter_date);
		alert("retire_date : "+retire_date);
		alert("img_path : "+img_path);
		alert("salary : "+salary); 
		
		if(name.length < 2)
		{
			alert('이름은 2자리 이상 입력해야합니다');
			$("#staff_name").focus();
			return false;
		}
		
		if(black_pattern.test(name))
		{
			alert('이름에 공백이 들어가면 안됩니다.');
			$("#staff_name").focus();
			return false;
		}
		
		
		
		alert('조건 완료');
		return false;
	}

</script>
<link type="text/css" rel="stylesheet" href="css/common.css"  ></link>
<style type="text/css">

#main h2{height:50px; padding-left:10px;}
#main .top h2{line-height: 60px;}
#main {height:1300px;}
#main .top{height:10%;}
#main .middle{height:80%;}
#main .middle .basicinfo{height:33%; padding-bottom: 50px;}
#main .middle .specinfo{height:33%; }
#main .middle .deptinfo{height:33%;padding-bottom: 50px;}
.deptinfo select{width:100%;height:100%;}

.middle table{width:100%; border-collapse: collapse; table-layout: fixed;}
.middle td {width:200px; border: 1px solid #B2CCFF;}

.middle .deptinfo th {width:110px; height:40px;background-color: #EBE8FF; text-align: center; border: 1px solid #B2CCFF;}
.middle .basicinfo th {width:110px; height:40px;background-color: #EBE8FF; text-align: center; border: 1px solid #B2CCFF;}


.middle .specinfo strong {display:inline-block; width:70px; height:50px;background-color: #EBE8FF; text-align: center; border: 1px solid #B2CCFF; line-height: 50px; }
.middle .specinfo .tab {height:50px; background-color: #eee; border: 1px solid #B2CCFF;}
.middle .specinfo .frame {width:100%; height:300px; border: 1px solid #B2CCFF; }

#main .bottom{height:10%; text-align: right;}
#main .bottom input{width:100px;}

</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

	<div id="main">
	  <div class="container">
		<div class="top">
		  <h2>개인 정보 추가</h2>
		  <hr>
		</div>
		<div class="middle">
		<form action="StaffInfoInsert.do" method="post" name="frm" id="frm"  onsubmit="return staffInsertCheck();">
		  <div class="basicinfo">
		  <h2>기본정보</h2>
		    <table>
		      <tr>
		        <th rowspan="4" id="staffimg">회원사진</th>
		        <th>이름*</th>
		        <td><input type="text" id="staff_name" name="staff_name"  placeholder="이름은 2글자 이상 입력해야합니다."/></td>
		        <th>주민번호*</th>
		        <td><input type="text" id="resident_number" name="resident_number"  placeholder="주민번호 13자리를 입력해주세요"/></td>
		      </tr>
		      <tr>
		        <th>휴대폰*</th>
		        <td><input type="text" id="staff_phone" name="staff_phone"  placeholder="휴대폰 번호를 입력해주세요" ></td>
		        <th>이메일</th>
		        <td><input type="text" id="staff_email" name="staff_email"  placeholder="이메일을 입력해주세요"></td>
		      </tr>
		      <tr>
		        <th>주소*</th>
		        <td colspan="3"><input type="text" id="staff_addr" name="staff_addr" placeholder="주소를 입력해주세요."></td>
		      </tr>
		      <tr>
		        <th>상세주소*</th>
		        <td colspan="3"><input type="text" id="staff_addrdetail" name="staff_addrdetail" placeholder="상세 주소를 입력해주세요."></td>
		      </tr>
		      <tr>
		        <td colspan="5"><input type="file" id="staff_img_path" name="staff_img_path"/></td>
		      </tr>
		    </table>
		  </div>
		  <div class="deptinfo">
		   <h2>부서 정보</h2>
		    <table>
		      <tr>
		        <th>부서명</th>
		        <td>
		          <select name="dept_id">
		            <option>:: 없음 ::</option>
		            <option value="0001">개발부</option>
		            <option value="0002">인사부</option>
		            <option value="0003">영업부</option>
		            <option value="0004">해외사업부</option>
		            <option value="0005">시설관리부</option>
		            <option value="0006">법무부</option>
		            <option value="0007">총무부</option>
		            <option value="0008">기획부</option>
		           </select>
		        </td>
		        <th>직급</th>
		        <td>
		          <select name="rank_id">
		            <option>:: 없음 ::</option>
		            <option value="0001">사원</option>
		            <option value="0002">주임</option>
		            <option value="0003">대리</option>
		            <option value="0004">과장</option>
		            <option value="0005">차장</option>
		            <option value="0006">부장</option>
		            <option value="0007">이사</option>
		            <option value="0008">전무</option>
		            <option value="0009">부사장</option>
		            <option value="0010">사장</option>
		            
		           </select>
		        </td>
		      </tr>
		      <tr>
		        <th>역할</th>
		        <td></td>
		        <th>급여</th>
		        <td><input type="text" id="salary" name="salary" ></td>
		      </tr>
		      <tr>
		        <th>입사일</th>
		        <td><input type="date" name="enter_date" /></td>
		        <th>퇴사일</th>
		        <td></td>
		      </tr>
		      <tr>
		        <th>보유기술</th>
		        <td colspan="3" align="center">
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
		  <div class="specinfo">
		   <h2>기타 정보</h2>
		     <div class="tab"><strong>학력</strong><strong>경력</strong><strong>자격증</strong></div>
		     <div class="frame">
		     
		     </div>
		     
		  <input type="submit" value="수정" id="updatebtn" style="width:100px;  margin-top: 20px;">
		     
		  </div>
		</form>  
		</div>
		<div class="bottom">
		<p>
		</p>
		</div>
	  </div>
	</div>

<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>