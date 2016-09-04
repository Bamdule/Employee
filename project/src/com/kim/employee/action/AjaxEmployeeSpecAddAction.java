package com.kim.employee.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.EmpAcademicDto;

public class AjaxEmployeeSpecAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		boolean result=true;
		EmployeeDao eDao =EmployeeDao.getInstance();
		String emp_id=request.getParameter("emp_id");
		String academic_Flag=request.getParameter("academic_Flag");
		String[] academic_level_selector=request.getParameterValues("academic_level_selector[]");
		String[] academic_name=request.getParameterValues("academic_name[]");
		String[] major_name=request.getParameterValues("major_name[]");
		String[] academic_status_selector=request.getParameterValues("academic_status_selector[]");
		String[] enter_dt=request.getParameterValues("enter_dt[]");
		String[] graduation_dt=request.getParameterValues("graduation_dt[]");
		List<EmpAcademicDto> academicList = null;
		
		System.out.println(emp_id);
		System.out.println(academic_Flag);
		

		if(academic_Flag.equals("1"))
		{
			academicList=new ArrayList<EmpAcademicDto>();
			EmpAcademicDto acDto=null;
			for(int i=0;i<academic_name.length;i++){
				acDto=new EmpAcademicDto();
			
				acDto.setAcademic_lev_id(academic_level_selector[i]);
				acDto.setAcademic_name(academic_name[i]);
				acDto.setMajor_name(major_name[i]);
				acDto.setAcademic_status_id(academic_status_selector[i]);
				acDto.setEnter_dt(enter_dt[i]);
				acDto.setGraduation_dt(graduation_dt[i]);
				
				System.out.println(acDto);
				academicList.add(acDto);
			}
			result=eDao.insertEmpAcademic(emp_id, academicList);
			
		}
		System.out.println("AjaxEmployeeSpecAddAction : "+result);
		
		response.setContentType("aplication/x-json; charset=UTF-8");
		response.getWriter().print(result);

	}

}
