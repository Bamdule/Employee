

function addCheck(){
	if(!addEmployee())
	{
		return false;
	}
	skillCheck();
	return true;
}
function skillCheck(){
	$(".skillsArea :checked").each(function(){
		
		if($(this).attr("disabled"))
		{
			$(this).attr("checked","false");
		}
	});
	
}
function inputCheck(o,name,len)
{
	if(o.val()==null && o.val()==undefined){
		o.focus();
		alert(name+"를/을 입력해주세요");
		return false;
	}
	else if(o.val().length<len){
		o.focus();
		alert(name+"는/은 "+len+"자 이상 입력하셔야합니다.");
		return false;
	}
	return true;
}
/*
 *  이름 - 비밀번호 - 주민번호 - 휴대폰 - 이메일 - 우편번호 - 주소 - 상세주소 - 급여 - 보유스킬 - 부서명 - 직급 - 입사일 
 */
function addEmployee()
{
	var valid = true;
	
	//에러문장
	var nameFailMsg="이름은 한글만 입력해야하며, 3~10자 이내로 입력해야합니다.";
	var pwdFailMsg="비밀번호는 3~20자로 입력해야합니다.";
	var phone_FailMsg="휴대폰 번호에는 숫자만 입력 되야합니다."
	var email_FailMsg="이메일은 [ exam01@exam.com ] 형식으로 입력되어야합니다.";
	var dept_FailMsg ="부서를 선택해 주세요.";
	var rank_FailMsg ="직급을 선택해 주세요.";
	

	var zipcode_FailMsg ="주소를 선택해주세요."; 
	var emp_addr_FailMsg ="주소를 선택해주세요.";
	var emp_detailaddr_FailMsg = "상세주소를 입력해주세요.";
	var emp_sal_FailMsg= "연봉을 입력해주세요";
	
	var emp_name = $("#emp_name");
	var emp_pwd = $("#emp_pwd");
	var emp_pwd_check = $("#emp_pwd_check");
	var emp_phone = $("#emp_phone");
	var front_email=$("#front_email");
	var back_email=$("#back_email");
	var dept_id = $("#dept_id");
	var rank_id = $("#rank_id");
	
	var zipcode = $("#zipcode");
	var emp_addr = $("#emp_addr");
	var emp_detailaddr = $("#emp_detailaddr");
	var emp_sal= $("#emp_sal");
	

	var nameReg=/^[가-힣]{3,20}$/;
	var pwdReg=/^[^\s]{4,13}$/;
	var phone_Reg=/^[0-9]{10,11}$/;
	var front_email_Reg=/^\w{5,12}$/;
	var back_email_Reg=/^[a-z]{2,10}[\.][a-z]{2,3}$/;
	var emp_sal_Reg =/^[0-9]{2,10}$/;
	
	
	 // 이름 - 비밀번호 - 주민번호 - 휴대폰 - 이메일 - 우편번호 - 주소 - 상세주소 - 급여 - 보유스킬 - 부서명 - 직급 - 입사일 
	 
	
	
	valid = valid && checkReg(emp_name,nameReg,nameFailMsg);	//이름
	valid = valid && checkReg(emp_pwd,pwdReg,pwdFailMsg);		//비밀번호
	
	if(valid&&emp_pwd.val()!=emp_pwd_check.val()){
		emp_pwd_check.focus();
		alert("두 개의 비밀번호가 일치하지 않습니다.");
		return false;
	}
	valid = valid && checkReg(emp_phone,phone_Reg,phone_FailMsg);					//휴대폰번호
	valid = valid && checkReg(front_email,front_email_Reg,email_FailMsg);			// 이메일앞
	valid = valid && checkReg(back_email,back_email_Reg,email_FailMsg); 			//이메일 뒤	
	valid = valid && inputCheck(zipcode,"우편 번호",4);									//우편번호
	valid = valid && inputCheck(emp_addr,"주소",4);									// 주소
	valid = valid && inputCheck(emp_detailaddr,"상세주소",4);							// 상세주소
	valid = valid && checkReg(emp_sal,emp_sal_Reg,emp_sal_FailMsg);	 				// 급여
	if(valid&&dept_id.val()=="none")												//부서
	{
		dept_id.focus();
		alert(dept_FailMsg);
		return false;
	}
	if(valid&&rank_id.val()=="none"){												//직급
		dept_id.focus();
		alert(rank_FailMsg);
		return false;
	}
		
		
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