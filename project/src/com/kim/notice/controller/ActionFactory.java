package com.kim.notice.controller;

import com.kim.notice.action.NoticeAddAction;
import com.kim.notice.action.NoticeAddFormAction;
import com.kim.notice.action.NoticeListAction;
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
		
			
		return action;
	}
	
	

}
