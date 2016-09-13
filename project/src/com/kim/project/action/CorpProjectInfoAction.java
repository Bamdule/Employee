package com.kim.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.common.dto.SkillDto;
import com.kim.employee.dto.EmployeeDto;
import com.kim.project.dao.ProjectDao;
import com.kim.project.dto.CorpProjectDto;

public class CorpProjectInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jsp/corp_project/corp_project_Info.jsp";
		
		String project_id = (String)request.getParameter("project_id");
		CorpProjectDto cpDto = null;
		List<SkillDto> skillList =null;
		List<EmployeeDto> empList = null;
		
		if(project_id!=null){
			ProjectDao pDao = ProjectDao.getInstance(); 
			//project_id="201609020007";
			cpDto=pDao.selectCorpPorjectById(project_id);
			skillList=pDao.selectCorpPorjectSkillsById(project_id);
			empList=pDao.selectCorpPorjectJoinEmpById(project_id);
			
		/*	
			System.out.println("project_id : " + project_id);
			System.out.println(cpDto);
			System.out.println(skillList);
			System.out.println(empList);
			*/
			request.setAttribute("project_id", project_id);
			request.setAttribute("corpProject", cpDto);
			request.setAttribute("skillList", skillList);
			request.setAttribute("empList", empList);
		}
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);		

	}

}
