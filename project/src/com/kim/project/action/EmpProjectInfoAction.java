package com.kim.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;

public class EmpProjectInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jsp/employee/employee_Project_Info.jsp";
		
		
		
		RequestDispatcher disp =request.getRequestDispatcher(url);
		disp.forward(request, response);

	}

}
