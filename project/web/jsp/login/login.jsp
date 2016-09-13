<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project - 로그인</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>

<script type="text/javascript">
	$(function(){
		
		
		$("#frm").on("submit", function(event) {		
				var valid = loginCheck();
			return valid;
		});

	});
	function loginCheck()
	{
		var valid =false;
		var d = $("#frm").serialize();
		$.ajax({
			url: "LoginServlet"
				  , type:"post"
				  , data:d
				  , async: false
				  , datatype : "json"
				  , success:function(result){	  
					  if(result=="success")
					  {
						  valid = true;
					  }
					  else if(result=="pass_failed")
					  {
						  alert('비밀번호가 일치하지 않습니다.')
						  $("#emp_pwd").val("");
						  $("#emp_pwd").focus();
						  valid = false;
					  }
					  else{
						  alert('아이디가 일치하지 않습니다.')
						  $("#emp_id").val("");
						  $("#emp_id").focus();
						  valid = false;
					  }				  
				  },error:function(request,status,error){
					  alert(request+' '+status+' '+error);			  
				  }				
				});
		return valid;
	}
	
	
	
</script>

</head>
<body>
	<div id="wrap">
		<div id="main">
			<div class="container">
				<div class="top">
					<div class="main_title"><h2>Employee Management</h2></div>
					<div class="login_title"><h2>Login</h2></div>
				</div>
				<div class="middle">
					<form action="ProjectServlet?command=main" method="post" id="frm">
						<div class="id_div">
							<input type="text" name="emp_id" id="emp_id" value="201608230000" placeholder="User ID">
						</div>
						<div class="password_div"> 
							<input type="password" name="emp_pwd" id="emp_pwd" value="1234" placeholder="User Password">
						</div>
						<div class="login_div">
							<input type="submit" value="로그인">
						</div>
					</form>
				</div>
				<div class="bottom"></div>
			</div>
		</div>
		<jsp:include page="/footer.jsp"></jsp:include>
	</div>


</body>
</html>