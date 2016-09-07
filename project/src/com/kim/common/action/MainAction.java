package com.kim.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.notice.dao.NoticeDao;
import com.kim.notice.dto.NoticeDto;
import com.kim.project.dao.ProjectDao;
import com.kim.project.dto.CorpProjectDto;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="main.jsp";
		List<CorpProjectDto> projectList = null;
		NoticeDao nDao = NoticeDao.getInstance();
		ProjectDao pDao = ProjectDao.getInstance();
		List<NoticeDto> noticeList = nDao.selectAllNotice(1, 5);
		projectList=pDao.selectAllCorpPorject(1, 5);

		request.setAttribute("projectList", projectList);
		request.setAttribute("noticeList", noticeList);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
