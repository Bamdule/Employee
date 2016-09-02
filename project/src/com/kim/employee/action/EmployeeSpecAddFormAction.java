package com.kim.employee.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;

public class EmployeeSpecAddFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jsp/employee/employee_Spec_Add.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(url);
		
		String emp_id = request.getParameter("emp_id");
		System.out.println(emp_id);
		disp.forward(request, response);
	}

}
