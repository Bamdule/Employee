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


function submitCheck(){
	var valid=true;
    var project_name=$("#project_name");
 	var corp_name=$("#corp_name");
 	var start_dt=$("#start_dt");
 	var end_dt=$("#end_dt");
 	var project_content=$("#project_content");
 	
 	valid=valid&&inputCheck(project_name,"프로젝트 이름",3);
 	valid=valid&&inputCheck(corp_name,"회사 이름",2);
 	valid=valid&&inputCheck(start_dt,"시작 일",3);
 	valid=valid&&inputCheck(end_dt,"종료 일",3);
 	valid=valid&&inputCheck(project_content,"프로젝트 내용",3);
 	
 	return valid;
}