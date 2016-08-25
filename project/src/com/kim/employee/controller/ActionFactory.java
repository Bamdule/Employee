package com.kim.employee.controller;

import com.kim.employee.action.EmployeeAddAction;
import com.kim.employee.action.EmployeeAddFormAction;
import com.kim.employee.action.EmployeeInfoAction;
import com.kim.employee.action.EmployeeListAction;
import com.kim.employee.action.EmployeeUpdateAction;
import com.kim.employee.action.EmployeeUpdateFormAction;
import com.kim.project.common.controller.Action;

public class ActionFactory {
	private static ActionFactory instance=null;
	
	private ActionFactory()
	{
		
	}
	
	public static ActionFactory getInstance()
	{
		if(instance == null)
			instance= new ActionFactory();
		return instance;
	}
	
	public Action getAction(String command)
	{
		Action action = null;
		if(command.equals("employee_list"))
		{
			action = new EmployeeListAction();
		}
		else if(command.equals("employee_addform"))
		{
			action = new EmployeeAddFormAction();
		}
		else if(command.equals("employee_add"))
		{
			action = new EmployeeAddAction();
		}
		else if(command.equals("employee_info"))
		{
			action = new EmployeeInfoAction();
		}
		else if(command.equals("employee_updateform"))
		{
			action = new EmployeeUpdateFormAction();
		}
		else if(command.equals("employee_update"))
		{
			action = new EmployeeUpdateAction();
		}
		
		return action;
		
		
	}
	

}
