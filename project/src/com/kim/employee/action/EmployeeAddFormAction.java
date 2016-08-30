package com.kim.employee.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.common.dao.SkillDao;
import com.kim.common.dto.SkillDto;
import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.DepartmentDto;
import com.kim.employee.dto.RankDto;

public class EmployeeAddFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		EmployeeDao dao = EmployeeDao.getInstance(); 
		SkillDao sDao =SkillDao.getInstance();
		List<RankDto> rankList = dao.selectAllRank();
		List<DepartmentDto> deptList = dao.selectAllDept();
		List<SkillDto> skillList =sDao.selectAllSkills();
		
		
		request.setAttribute("rankList", rankList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("skillList", skillList);
		RequestDispatcher disp = request.getRequestDispatcher("jsp/employee/employee_Add.jsp");
		disp.forward(request, response);		
	}

}
