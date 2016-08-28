package com.kim.notice.controller;

import com.kim.notice.action.NoticeAddAction;
import com.kim.notice.action.NoticeAddFormAction;
import com.kim.notice.action.NoticeDeleteAction;
import com.kim.notice.action.NoticeInfoAction;
import com.kim.notice.action.NoticeListAction;
import com.kim.notice.action.NoticeReplyAddAction;
import com.kim.notice.action.NoticeReplyDeleteAction;
import com.kim.notice.action.NoticeUpdateAction;
import com.kim.notice.action.NoticeUpdateFormAction;
import com.kim.project.common.controller.Action;

public class ActionFactory {
	private static ActionFactory instance =null;
	private ActionFactory() {
	}
	
	public static ActionFactory getInstance()
	{
		instance = new ActionFactory();
		return instance;
	}
	
	public Action getAction(String command)
	{
		Action action =null;
		if(command.equals("notice_list"))
			action=new NoticeListAction();
		else if(command.equals("notice_addform"))
			action=new NoticeAddFormAction();
		else if(command.equals("notice_add"))
			action=new NoticeAddAction();
		else if(command.equals("notice_info"))
			action=new NoticeInfoAction();
		else if(command.equals("notice_update"))
			action=new NoticeUpdateAction();
		else if(command.equals("notice_updateform"))
			action=new NoticeUpdateFormAction();
		else if(command.equals("notice_replyadd"))
			action=new NoticeReplyAddAction();
		else if(command.equals("notice_delete"))
			action=new NoticeDeleteAction();
		else if(command.equals("noticereply_delete"))
			action=new NoticeReplyDeleteAction();
		
	
		return action;
	}
	
	

}
