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
import com.kim.employee.dto.EmpAcademicDto;
import com.kim.employee.dto.EmpCareerDto;
import com.kim.employee.dto.EmpLicenceDto;
import com.kim.employee.dto.EmployeeDto;

public class EmployeeInfoAction  implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jsp/employee/employee_Info.jsp";
		
		String param_emp_id=(String)request.getParameter("emp_id");
		String emp_id= (param_emp_id==null)?(String)request.getAttribute("emp_id"):param_emp_id;
		
		HttpSession session = request.getSession();
		if(emp_id!=null)		
		{
		}
		else if(session.getAttribute("emp_id")!=null)
		{
			emp_id=(String)session.getAttribute("emp_id");
			
		}
		else{
			url="EmployeeServlet?command=employee_list";
			response.sendRedirect(url);
		}

		List<EmpAcademicDto> academicList =null;
		List<EmpCareerDto> careerList =null;
		List<EmpLicenceDto> licenceList =null;
		EmployeeDao dao = EmployeeDao.getInstance();
		EmployeeDto dto = dao.selectEmpById(emp_id);
		academicList = dao.selectAllEmpAcademicById(emp_id);
		careerList = dao.selectAllEmpCareerById(emp_id);
		licenceList = dao.selectAllEmpLicenceById(emp_id);
		request.setAttribute("employee", dto);
		request.setAttribute("academicList", academicList);
		request.setAttribute("careerList", careerList);
		request.setAttribute("licenceList", licenceList);
		RequestDispatcher disp = request.getRequestDispatcher(url);	
		disp.forward(request, response);
		
	
	}

}
