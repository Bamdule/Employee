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

public class EmpProjectListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jsp/employee/employee_Project_List.jsp";
		
		ProjectDao pDao = ProjectDao.getInstance();
		final int pagePerRecord=10;
		List<CorpProjectDto> projectList =null;
		
		
		String pageNum = request.getParameter("curPage");
		int curPage=1;
		try{
			curPage= (pageNum==null)?1:Integer.parseInt(pageNum);
		}catch(Exception e)
		{
			e.printStackTrace();
			curPage=1;
		}
		
		int totalRecord=pDao.getEmpProjectTotal();
		projectList=pDao.selectAllEmpPorject(curPage, pagePerRecord);
		PageDto pDto=PageHelper.getBlockGroup(curPage, pagePerRecord, totalRecord);
		
		request.setAttribute("projectList", projectList);
		request.setAttribute("page", pDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

	
}
