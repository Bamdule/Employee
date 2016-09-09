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
import com.kim.employee.dto.EmpAcademicDto;
import com.kim.employee.dto.EmpCareerDto;
import com.kim.employee.dto.EmpLicenceDto;
import com.kim.employee.dto.EmployeeDto;

public class EmployeeSpecUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jsp/employee/employee_Spec_Update.jsp";
		EmployeeDao eDao =EmployeeDao.getInstance();
		EmployeeDto eDto = null;
		List<AcademicLevelDto> academicLevelList =null;
		List<AcademicStatusDto> academicStatusList =null;
		String emp_id = request.getParameter("h_empid");
		
		if(emp_id!=null){
			eDto=eDao.selectEmpById(emp_id);
			academicLevelList=eDao.selectAllAcademicLevel();
			academicStatusList=eDao.selectAllAcademicStatus();
			List<EmpAcademicDto> academicList = eDao.selectAllEmpAcademicById(emp_id);
			List<EmpCareerDto> careerList = eDao.selectAllEmpCareerById(emp_id);
			List<EmpLicenceDto> licenceList = eDao.selectAllEmpLicenceById(emp_id);
			
			

			request.setAttribute("academicList", academicList);
			request.setAttribute("careerList", careerList);
			request.setAttribute("licenceList", licenceList);
			
			request.setAttribute("academicLevelList", academicLevelList);
			request.setAttribute("academicStatusList", academicStatusList);
			request.setAttribute("emp_id", eDto.getEmp_id());
			request.setAttribute("emp_name", eDto.getEmp_name());
			request.setAttribute("dept_name", eDto.getDept_name());
			request.setAttribute("rank_name", eDto.getRank_name());
			System.out.println(emp_id);
			
			RequestDispatcher disp = request.getRequestDispatcher("jsp/employee/employee_Spec_Update.jsp");
			disp.forward(request, response);
		}
		else{
			response.sendRedirect("EmployeeServlet?command=employee_list");
		}
		
		/*
		 * 		HttpSession session = request.getSession();
		String update_emp_id=(String)session.getAttribute("update_emp_id");
		session.setAttribute("update_emp_id", null);
		
		 */

	}

}
