package com.kim.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.notice.dao.NoticeDao;
import com.kim.notice.dto.NoticeDto;

public class NoticeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder url =new StringBuilder("NoticeServlet?command=notice_info");
		
		
		NoticeDto nDto = new NoticeDto();
		NoticeDao nDao = NoticeDao.getInstance();
		nDto.setNotice_id(request.getParameter("notice_id"));
		nDto.setNotice_content(request.getParameter("notice_content"));
		nDto.setNotice_title(request.getParameter("notice_title"));
		
		if(!nDao.updateNotice(nDto)){
			response.sendRedirect("NoticeServlet");
			
		}
		else{
			url.append("&notice_id="+nDto.getNotice_id());
			RequestDispatcher disp =request.getRequestDispatcher(url.toString());
			disp.forward(request, response);
		}

	}

}
