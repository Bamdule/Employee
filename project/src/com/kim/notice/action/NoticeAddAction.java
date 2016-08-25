package com.kim.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.project.common.controller.Action;

public class NoticeAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="NoticeServlet?command=notice_list";
		HttpSession session =request.getSession();
		
		String emp_id=(String)session.getAttribute("emp_id");
		String emp_name=(String)session.getAttribute("emp_name");
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		
		System.out.println(emp_id);
		System.out.println(emp_name);
		System.out.println(notice_title);
		System.out.println(notice_content);
		
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);

	}

}
