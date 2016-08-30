package com.kim.common.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.common.dto.EmployeeSimpleDto;
import com.kim.employee.dao.EmployeeDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "jsp/login/login.jsp";

		System.out.println("LoginGet");
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("LoginPost");
		String emp_id = request.getParameter("emp_id");
		String emp_pwd = request.getParameter("emp_pwd");
		String result_msg;
		EmployeeSimpleDto simpleDto=null;
		EmployeeDao dao =EmployeeDao.getInstance();
		simpleDto=dao.loginCheck(emp_id, emp_pwd);
		
		System.out.println(simpleDto);
		/*
		 * result : 
		 * 1 : success
		 * 2 : id check failed
		 * 3 : pass check faild
		 */
		switch(simpleDto.getResult())
		{
		case 1:
			result_msg="success";
			HttpSession session =request.getSession();
			session.setAttribute("emp_name", simpleDto.getEmp_name());
			session.setAttribute("emp_id", simpleDto.getEmp_id());
			session.setAttribute("isManager", simpleDto.isManager());
			session.setMaxInactiveInterval(1800);//30분	
			break;
		case 2:
			result_msg="id_failed";
			break;
		case 3:
			result_msg="pass_failed";
			break;
		default:
			result_msg="id_failed";
			break;
		}
		
		System.out.println("Login Info : "+result_msg);
		PrintWriter out = response.getWriter();	
		out.print(result_msg);
	}

}
