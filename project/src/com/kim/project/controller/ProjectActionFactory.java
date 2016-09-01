package com.kim.project.controller;

import com.kim.common.action.AjaxEmployeeListAction;
import com.kim.common.controller.Action;
import com.kim.project.action.CorpProjectAddAction;
import com.kim.project.action.CorpProjectAddFormAction;
import com.kim.project.action.CorpProjectListAction;


public class ProjectActionFactory {
	private static ProjectActionFactory instance =null;
	private ProjectActionFactory() {
	}
	
	public static ProjectActionFactory getInstance()
	{
		instance = new ProjectActionFactory();
		return instance;
	}
	
	public Action getAction(String command)
	{
		Action action =null;
		if(command.equals("corp_project_list")){
			action = new CorpProjectListAction();
		}
		else if(command.equals("corp_project_add")){
			action = new CorpProjectAddAction();
		}
		else if(command.equals("corp_project_addform")){
			action = new CorpProjectAddFormAction();
		}
		else if(command.equals("ajax_emp_list"))
			action = new AjaxEmployeeListAction();
		return action;
	}
}
