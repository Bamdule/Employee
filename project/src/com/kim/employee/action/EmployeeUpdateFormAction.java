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
import com.kim.employee.dto.EmployeeDto;
import com.kim.employee.dto.RankDto;

public class EmployeeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emp_id=request.getParameter("h_empid");
		String url = "jsp/employee/employee_Update.jsp";
		
		if(emp_id!=null)
		{
			EmployeeDao dao = EmployeeDao.getInstance(); 
			SkillDao sDao =SkillDao.getInstance();
			EmployeeDto eDto=dao.selectEmpById(emp_id);
			List<RankDto> rankList = dao.selectAllRank();
			List<DepartmentDto> deptList = dao.selectAllDept();
			
			List<SkillDto> skillList =sDao.selectAllSkills();
			request.setAttribute("rankList", rankList);
			request.setAttribute("deptList", deptList);
			request.setAttribute("employee", eDto);
			request.setAttribute("skillList", skillList);
			
			RequestDispatcher disp = request.getRequestDispatcher(url);
			disp.forward(request, response);
		}
		else{
			response.sendRedirect("EmployeeServlet?command=employee_list");
		}
	}

}
