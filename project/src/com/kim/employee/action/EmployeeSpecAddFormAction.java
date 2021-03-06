package com.kim.employee.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.common.controller.Action;
import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.AcademicLevelDto;
import com.kim.employee.dto.AcademicStatusDto;
import com.kim.employee.dto.EmployeeDto;

public class EmployeeSpecAddFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jsp/employee/employee_Spec_Add.jsp";
		EmployeeDao eDao =EmployeeDao.getInstance();
		EmployeeDto eDto = null;
		List<AcademicLevelDto> academicLevelList =null;
		List<AcademicStatusDto> academicStatusList =null;
		HttpSession session = request.getSession();
		String emp_id= (String) session.getAttribute("new_emp_id");
		session.setAttribute("new_emp_id", null);
		if(emp_id!=null){
			eDto=eDao.selectEmpById(emp_id);
			academicLevelList=eDao.selectAllAcademicLevel();
			academicStatusList=eDao.selectAllAcademicStatus();
			request.setAttribute("academicLevelList", academicLevelList);
			request.setAttribute("academicStatusList", academicStatusList);
			request.setAttribute("emp_id", eDto.getEmp_id());
			request.setAttribute("emp_name", eDto.getEmp_name());
			request.setAttribute("dept_name", eDto.getDept_name());
			request.setAttribute("rank_name", eDto.getRank_name());
			System.out.println(emp_id);
			RequestDispatcher disp = request.getRequestDispatcher(url);
			disp.forward(request, response);
		}
		else{
			response.sendRedirect("EmployeeServlet?command=employee_list");
		}

	}

}
