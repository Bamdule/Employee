/**
 * 
 */

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
	
	var notice_title=$("#notice_title");
	var notice_content=$("#notice_content");
	
	valid=valid&&inputCheck(notice_title,"공지사항 이름",2);
	valid=valid&&inputCheck(notice_contnet,"공지사항 내용",3);
	
	return valid;
}