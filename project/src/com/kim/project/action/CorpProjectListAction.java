package com.kim.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.common.dto.PageDto;
import com.kim.project.dao.ProjectDao;
import com.kim.project.dto.CorpProjectDto;

import util.PageHelper;

public class CorpProjectListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="jsp/corp_project/corp_project_List.jsp";
		
		String pageNum = request.getParameter("curPage");
		int curPage = 1;
		int recordPerPage=15;
		try {
			curPage = (pageNum == null) ? 1 : Integer.parseInt(pageNum);
		} catch (Exception e) {
			e.printStackTrace();
			curPage = 1;
		}
		
		List<CorpProjectDto> projectList = null;
		ProjectDao pDao = ProjectDao.getInstance();
		projectList=pDao.selectAllCorpPorject(curPage, recordPerPage);
		PageDto pageDto=null;
		int totalRecord=pDao.getCorpProjectTotal();
		pageDto=PageHelper.getBlockGroup(curPage, recordPerPage, totalRecord);
		
		System.out.println(projectList);
		request.setAttribute("projectList", projectList);
		request.setAttribute("page", pageDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
