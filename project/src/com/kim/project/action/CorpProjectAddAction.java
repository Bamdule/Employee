package com.kim.project.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.project.dao.ProjectDao;
import com.kim.project.dto.CorpProjectDto;

public class CorpProjectAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean result=false;
		String data = request.getParameter("projectInfo");
		System.out.println(data);
		ProjectDao pDao = ProjectDao.getInstance();
		String project_id = pDao.getNextCorpProjectId();
	
		CorpProjectDto cpDto =new CorpProjectDto();
		cpDto.setProject_id(project_id);
		cpDto.setProject_name(request.getParameter("project_name"));
		cpDto.setCorp_name(request.getParameter("corp_name"));
		cpDto.setStart_dt(request.getParameter("start_dt"));
		cpDto.setEnd_dt(request.getParameter("end_dt"));
		cpDto.setProject_content(request.getParameter("project_content"));
		cpDto.setCorp_own(request.getParameter("corp_own"));
		cpDto.setRemarks(request.getParameter("remarks"));
		System.out.println(cpDto);

		String[] skills=request.getParameterValues("skills[]");
		String[] empList=request.getParameterValues("empList[]");
		String[] emp_Roles=request.getParameterValues("emp_roles[]");
		

		boolean corp_projec_skills=true;
		boolean corp_project_join_emp=true;
		
	
		boolean insertCorpProject = pDao.insertCorpProject(cpDto);
		if(insertCorpProject){
			System.out.println(cpDto);
			if(empList!=null && empList.length!=0){
				corp_project_join_emp=false;
				corp_project_join_emp=pDao.insertCorpProjectJoinEmps(project_id, empList, emp_Roles);
			}
			
			if(skills!=null && skills.length!=0){
				corp_projec_skills=false;
				corp_projec_skills=pDao.insertCorpProjectSkills(project_id, skills);
			}
			
			System.out.println("joinEmps : "+corp_project_join_emp);
			System.out.println("projectSkills : "+corp_projec_skills);
			result=corp_projec_skills&&corp_project_join_emp;
		}
		
		
		System.out.println(result);
		response.setContentType("application/x-json; charset=UTF-8");
		if(result){
			response.getWriter().print(project_id);
		}
		else{
			response.getWriter().print("false");
		}
	}

}
