package com.kim.employee.controller;

import com.kim.common.action.AjaxAddressSearchAction;
import com.kim.common.controller.Action;
import com.kim.employee.action.AjaxEmployeeSpecAddAction;
import com.kim.employee.action.AjaxEmployeeSpecDeleteAction;
import com.kim.employee.action.AjaxSearchEmployeeAction;
import com.kim.employee.action.EmployeeAddAction;
import com.kim.employee.action.EmployeeAddFormAction;
import com.kim.employee.action.EmployeeInfoAction;
import com.kim.employee.action.EmployeeListAction;
import com.kim.employee.action.EmployeeSpecAddFormAction;
import com.kim.employee.action.EmployeeSpecUpdateFormAction;
import com.kim.employee.action.EmployeeUpdateAction;
import com.kim.employee.action.EmployeeUpdateFormAction;

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
		else if(command.equals("address_search"))
		{
			action = new AjaxAddressSearchAction();
		}
		else if(command.equals("employee_spec_addform"))
			action = new EmployeeSpecAddFormAction();
		else if(command.equals("ajax_employee_spec_add"))
			action = new AjaxEmployeeSpecAddAction();
		else if(command.equals("ajax_search_employee"))
			action = new AjaxSearchEmployeeAction();
		else if(command.equals("employee_spec_updateform"))
			action = new EmployeeSpecUpdateFormAction();
		else if(command.equals("ajax_employee_spec_delete"))
			action = new AjaxEmployeeSpecDeleteAction();
		
		return action;
		
		
	}
	

}
