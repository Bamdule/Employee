package com.kim.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.notice.dao.NoticeDao;

public class NoticeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "NoticeServlet?command=notice_list";
		String notice_id =request.getParameter("notice_id");
		System.out.println("notice_id : "+notice_id);
		NoticeDao nDao = NoticeDao.getInstance();
		
		nDao.deleteNoticeById(notice_id);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);

	}

}
