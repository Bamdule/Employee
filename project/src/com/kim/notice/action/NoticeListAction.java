package com.kim.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.common.dto.PageDto;
import com.kim.notice.dao.NoticeDao;
import com.kim.notice.dto.NoticeDto;

import util.PageHelper;

public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "jsp/notice/notice_List.jsp";

		final int pagePerRecord = 15;

		String pageNum = request.getParameter("curPage");
		int curPage = 1;
		try {
			curPage = (pageNum == null) ? 1 : Integer.parseInt(pageNum);
		} catch (Exception e) {
			e.printStackTrace();
			curPage = 1;
		}

		NoticeDao nDao = NoticeDao.getInstance();
		List<NoticeDto> noticeList = nDao.selectAllNotice(curPage, pagePerRecord);
		
		int totalRecord = nDao.getTotalNotice();
		PageDto pDto=PageHelper.getBlockGroup(curPage, pagePerRecord,totalRecord);	
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("paging", pDto);

		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);

	}

}
