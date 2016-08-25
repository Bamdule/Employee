package com.kim.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.notice.dao.NoticeDao;
import com.kim.notice.dto.NoticeDto;
import com.kim.project.common.controller.Action;

public class NoticeAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="NoticeServlet?command=notice_list";
		HttpSession session =request.getSession();
			
		NoticeDto nDto = new NoticeDto();
		nDto.setEmp_id((String)session.getAttribute("emp_id"));
		nDto.setEmp_name((String)session.getAttribute("emp_name"));
		nDto.setNotice_title(request.getParameter("notice_title"));
		nDto.setNotice_content(request.getParameter("notice_content"));
		
		System.out.println(nDto);
		
		NoticeDao nDao = NoticeDao.getInstance();
		if(!nDao.insertNotice(nDto)){
			response.sendRedirect("NoticeServlet?command=notice_add");
		}
		else{	
			RequestDispatcher disp = request.getRequestDispatcher(url);
			disp.forward(request, response);
		}

	}

}
