package com.kim.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.notice.dao.NoticeDao;
import com.kim.notice.dto.NoticeDto;
import com.kim.notice.dto.ReplyDto;

public class NoticeInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="jsp/notice/notice_Info.jsp";
		
		String notice_id = request.getParameter("notice_id");
		NoticeDto nDto =new NoticeDto();
		NoticeDao nDao = NoticeDao.getInstance();
		nDto=nDao.selectNoticeById(notice_id);
		nDao.updateReadCount(notice_id);
		
		List<ReplyDto> replyList = nDao.selectNoticeReplyListById(notice_id);
		
		request.setAttribute("notice", nDto);
		request.setAttribute("replyList", replyList);
		
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
		

	}

}
