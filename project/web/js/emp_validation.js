


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
	var front_res_FailMsg="앞 주민번호에는 6자리 숫자만 입력되야합니다.";
	var back_res_FailMsg="뒷 주민번호에는 7자리 숫자만 입력되야합니다.";
	var phone_FailMsg="휴대폰 번호에는 숫자만 입력 되야합니다."
	var email_FailMsg="이메일은 [ exam01@exam.com ] 형식으로 입력되어야합니다.";
	var enter_dt_FailMsg = "날짜 형식에 맞지 않습니다.";
	
	var emp_name = $("#emp_name");
	var emp_pwd = $("#emp_pwd");
	var emp_pwd_check = $("#emp_pwd_check");
	var front_resident_num =$("#front_resident_num");
	var back_resident_num=$("#back_resident_num");
	var emp_phone = $("#emp_phone");
	var front_email=$("#front_email");
	var back_email=$("#back_email");
	var enter_dt = $("#datepicker");
		
	var nameReg=/^[가-힣]{3,20}$/;
	var pwdReg=/^[^\s]{4,13}$/;
	var front_res_Reg=/^[0-9]{6}$/;
	var back_res_Reg=/^[0-9]{7}$/;
	var phone_Reg=/^[0-9]{10,11}$/;
	var front_email_Reg=/^\w{5,12}$/;
	var back_email_Reg=/^[a-z]{2,10}[\.][a-z]{2,3}$/;
	var enter_dt_Reg=/^(19[2-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;

	
	valid = valid && checkReg(emp_name,nameReg,nameFailMsg);		
	if(emp_pwd.val()!=emp_pwd_check.val()){
		alert("두 개의 비밀번호가 일치하지 않습니다.");
		return false;
	}
	valid = valid && checkReg(emp_pwd,pwdReg,pwdFailMsg);	
	valid = valid && checkReg(front_resident_num,front_res_Reg,front_res_FailMsg);	
	valid = valid && checkReg(back_resident_num,back_res_Reg,back_res_FailMsg);	
	valid = valid && checkReg(emp_phone,phone_Reg,phone_FailMsg);	
	valid = valid && checkReg(front_email,front_email_Reg,email_FailMsg);	
	valid = valid && checkReg(back_email,back_email_Reg,email_FailMsg);	
	valid = valid && checkReg(enter_dt,enter_dt_Reg,enter_dt_FailMsg);	
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