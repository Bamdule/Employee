<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="../../js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../../js/validation.js"></script>

<style type="text/css">
</style>
</head>
<body>
<div>

	<form action="#" id="frm" name="frm">
		<p>	<label for="emp_name">이름</label></p>
		<p>	<input type="text" id="emp_name" name="emp_name"/></p>
		<p><label for="emp_pwd">비밀번호</label></p>
		<p>	<input type="text" id="emp_pwd" name="emp_pwd"/></p>
		
		<p><label for="emp_phone">휴대폰번호</label></p>
		<p>	<input type="text" id="emp_phone" name="emp_phone"/></p>
		
		
		<p><label for="name">이메일 </label></p>
			<p><input type="text" id="front_email" name="front_email" placeholder="email"/> @
			<input type="text" id="back_email" name="back_email"/>
		</p>
		
		
		<p><label for="name">주민등록 번호 </label></p>
			<p><input type="text" id="front_resident_num" name="front_resident_num" placeholder="앞자리 6자"/> - 
			<input type="text" id="back_resident_num" name="back_resident_num"placeholder="뒷자리 7자"/>
		</p>
		
		
		<p><label for="emp_sal">급여</label></p>
		<p>	<input type="number" id="emp_sal" name="emp_sal"/></p>
		
		<p><label for="enter_dt">입사일</label></p>
		<p>	<input type="text" id="enter_dt" name="enter_dt"/></p>
		
		<p class="content"></p>
		<input type="submit" value="저장">
	</form>

</div>
</body>
</html>