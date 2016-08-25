

function addCheck(){
	if(!addEmployee())
	{
		return false;
	}
	return true;
}

function addEmployee()
{
	var valid = true;
	
	//에러문장
	var nameFailMsg="이름은 한글만 입력해야하며, 3~10자 이내로 입력해야합니다.";
	var pwdFailMsg="비밀번호는 3~20자로 입력해야합니다.";
	var phone_FailMsg="휴대폰 번호는 숫자만 입력해야하고 최대 11자 까지 입력가능합니다.";
	var email_FailMsg="이메일은 [ exam01@exam.com ] 형식으로 입력되어야합니다.";
	
	var emp_name = $("#emp_name");
	var emp_pwd = $("#emp_pwd");
	var emp_phone = $("#emp_phone");
	var front_email=$("#front_email");
	var back_email=$("#back_email");
		
	var nameReg=/^[가-힣]{3,20}$/;
	var pwdReg=/^[^\s]{4,13}$/;
	var phone_Reg=/^[0-9]{10,11}$/;
	var front_email_Reg=/^\w{5,12}$/;
	var back_email_Reg=/^[a-z]{2,10}[\.][a-z]{2,3}$/;

	
	
	
	valid = valid && checkReg(emp_name,nameReg,nameFailMsg);		
	valid = valid && checkReg(emp_pwd,pwdReg,pwdFailMsg);	
	valid = valid && checkReg(emp_phone,phone_Reg,phone_FailMsg);	
	valid = valid && checkReg(front_email,front_email_Reg,email_FailMsg);	
	valid = valid && checkReg(back_email,back_email_Reg,email_FailMsg);	
	return valid;
}

function checkReg(o, reg,failMsg) {
	if (!(reg.test(o.val()))) {
		alert(failMsg);
		o.focus();
		return false;
	} else {
		return true;
	}
}