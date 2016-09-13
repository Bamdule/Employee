package com.kim.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.common.dto.SkillDto;
import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.Emp_Role;
import com.kim.employee.dto.EmployeeDto;
import com.kim.project.dao.ProjectDao;
import com.kim.project.dto.CorpProjectDto;

public class CorpProjectUpdateFormAction implements Action {
//ProjectServlet?command=corp_project_updateform
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="jsp/corp_project/corp_project_Update.jsp";
		String project_id = request.getParameter("project_id");
		EmployeeDao eDao = EmployeeDao.getInstance();
		ProjectDao pDao = ProjectDao.getInstance();
		CorpProjectDto pDto = pDao.selectCorpPorjectById(project_id);
		List<SkillDto> skillList = pDao.selectCorpPorjectSkillsById(project_id);
		List<EmployeeDto> empList =pDao.selectCorpPorjectJoinEmpById(project_id);
		List<Emp_Role> empRole = eDao.selectAllEmpRole();
		
		System.out.println(project_id);
		System.out.println(pDto);
		System.out.println(skillList);
		System.out.println(empList);
		System.out.println(empRole);
		
		request.setAttribute("project_id", project_id);
		request.setAttribute("corpProject", pDto);
		request.setAttribute("skillList", skillList);
		request.setAttribute("empList", empList);
		request.setAttribute("empRole", empRole);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}
