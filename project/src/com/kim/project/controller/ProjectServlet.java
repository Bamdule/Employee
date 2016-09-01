package com.kim.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.common.controller.Action;

@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String emp_id = (String) session.getAttribute("emp_id");
		
		if (emp_id == null) {
			System.out.println("비 로그인 접근 시도");
			response.sendRedirect("LoginServlet");
		} 
		
		else {
			String command = request.getParameter("command");

			if (command == null)
				command = "corp_project_list";

			Action action = null;
			ProjectActionFactory actionFactory = ProjectActionFactory.getInstance();

			action = actionFactory.getAction(command);

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
