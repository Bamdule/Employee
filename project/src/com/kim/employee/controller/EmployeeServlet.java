package com.kim.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.project.common.controller.Action;
import com.kim.project.common.controller.LoginServlet;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String emp_id = (String) session.getAttribute("emp_id");
		if (emp_id == null) {
			System.out.println("비 로그인 접근 시도");
			response.sendRedirect("LoginServlet");
		} else {

/*
			System.out.println("emp_id : " + emp_id);
			System.out.println("emp_name : " + emp_name);
			System.out.println("isManager : " + isManager);*/

			String msg = request.getParameter("imgNotUpdate");
			String command = request.getParameter("command");
			System.out.println("Command : " + command);
			System.out.println("testMsg : " + msg);

			if (command == null) {
				command = "employee_list";
			}

			ActionFactory af = ActionFactory.getInstance();
			Action action = af.getAction(command);

			if (action != null)
				action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
