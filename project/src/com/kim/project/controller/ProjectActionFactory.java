package com.kim.project.controller;

import com.kim.common.action.AjaxEmployeeListAction;
import com.kim.common.controller.Action;
import com.kim.project.action.CorpProjectAddAction;
import com.kim.project.action.CorpProjectAddFormAction;
import com.kim.project.action.CorpProjectInfoAction;
import com.kim.project.action.CorpProjectListAction;
import com.kim.project.action.EmpProjectAddAction;
import com.kim.project.action.EmpProjectAddFormAction;
import com.kim.project.action.EmpProjectListAction;


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
		if(command.equals("corp_project_list")) // 회사 프로젝트 리스트
			action = new CorpProjectListAction();
		else if(command.equals("corp_project_add")) //회사프로젝트 추가처리
			action = new CorpProjectAddAction();		
		else if(command.equals("corp_project_addform")) //회사프로젝트 추가 JSP
			action = new CorpProjectAddFormAction();	
		else if(command.equals("corp_project_info")) //회사프로젝트 정보
			action = new CorpProjectInfoAction();
		else if(command.equals("ajax_emp_list")) // 사원정보 list Ajax호출
			action = new AjaxEmployeeListAction();	
		else if(command.equals("emp_project_list")) // 사원정보 list Ajax호출
			action = new EmpProjectListAction();
		else if(command.equals("emp_project_addform")) // 사원정보 list Ajax호출
			action = new EmpProjectAddFormAction();
		else if(command.equals("emp_project_add")) // 사원정보 list Ajax호출
			action = new EmpProjectAddAction();
		
		return action;
	}
}
