package com.kim.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.common.controller.Action;
import com.kim.project.dao.ProjectDao;
import com.kim.project.dto.CorpProjectDto;

public class EmpProjectAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="ProjectServlet?command=emp_project_list";
		
		
		HttpSession session = request.getSession();
		
		String emp_id = (String)session.getAttribute("emp_id");
		if(emp_id !=null){
			ProjectDao pDao = ProjectDao.getInstance();
			String project_id=pDao.getNextEmpProjectId();
			CorpProjectDto pDto =new CorpProjectDto();
			
			String project_name =request.getParameter("project_name");
			String corp_name =request.getParameter("corp_name");
			String project_content =request.getParameter("project_content");
			String start_dt =request.getParameter("start_dt");
			String end_dt =request.getParameter("end_dt");
			String role =request.getParameter("role");
			
			pDto.setProject_id(project_id);
			pDto.setProject_name(project_name);
			pDto.setCorp_name(corp_name);
			pDto.setProject_content(project_content);
			pDto.setStart_dt(start_dt);
			pDto.setEnd_dt(end_dt);
			pDto.setCorp_own("외부");
			pDto.setRole(role);
			
			System.out.println(pDto);
			pDao.insertEmpProject(emp_id, pDto);
		}
		
		response.sendRedirect(url);

	}

}
