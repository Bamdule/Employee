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
import com.kim.employee.dto.EmpCareerDto;
import com.kim.employee.dto.EmpLicenceDto;

public class AjaxEmployeeSpecAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		boolean result=false;
		EmployeeDao eDao =EmployeeDao.getInstance();
		String emp_id=request.getParameter("emp_id");
		String academic_Flag=request.getParameter("academic_Flag");
		String career_Flag=request.getParameter("career_Flag");
		String licence_Flag=request.getParameter("licence_Flag");
		
		String[] academic_level_selector=request.getParameterValues("academic_level_selector[]");
		String[] academic_name=request.getParameterValues("academic_name[]");
		String[] major_name=request.getParameterValues("major_name[]");
		String[] academic_status_selector=request.getParameterValues("academic_status_selector[]");
		String[] enter_dt=request.getParameterValues("enter_dt[]");
		String[] graduation_dt=request.getParameterValues("graduation_dt[]");
		
		String[] corp_name=request.getParameterValues("corp_name[]");
		String[] rank_name=request.getParameterValues("rank_name[]");
		String[] emp_role=request.getParameterValues("emp_role[]");
		String[] career_enter_dt=request.getParameterValues("career_enter_dt[]");
		String[] career_retire_dt=request.getParameterValues("career_retire_dt[]");
		
		String[] institution=request.getParameterValues("institution[]");
		String[] licence_name=request.getParameterValues("licence_name[]");
		String[] licence_number=request.getParameterValues("licence_number[]");
		String[] get_dt=request.getParameterValues("get_dt[]");
		String[] ins_type=request.getParameterValues("ins_type[]");

		List<EmpAcademicDto> academicList = null;
		List<EmpCareerDto> careerList = null;
		List<EmpLicenceDto> licenceList = null;
		
		System.out.println("emp_id : "+emp_id);
		System.out.println("academic_Flag : "+academic_Flag);
		System.out.println("career_Flag : "+career_Flag);
		System.out.println("licence_Flag : "+licence_Flag);
		

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

		if(career_Flag.equals("1"))
		{
			careerList=new ArrayList<EmpCareerDto>();
			EmpCareerDto ecDto=null;
			for(int i=0;i<corp_name.length;i++){
				ecDto=new EmpCareerDto();
			
				ecDto.setCorp_name(corp_name[i]);
				ecDto.setRank_name(rank_name[i]);
				ecDto.setEmp_role(emp_role[i]);
				ecDto.setCareer_enter_dt(career_enter_dt[i]);
				ecDto.setCareer_retire_dt(career_retire_dt[i]);

				System.out.println(ecDto);
				careerList.add(ecDto);
			}

			result=eDao.insertEmpCareer(emp_id, careerList);	
		}
		
		if(licence_Flag.equals("1"))
		{
			licenceList=new ArrayList<EmpLicenceDto>();
			EmpLicenceDto elDto=null;
			for(int i=0;i<ins_type.length;i++){
				elDto=new EmpLicenceDto();
			
				elDto.setInstitution(institution[i]);
				elDto.setLicence_name(licence_name[i]);
				elDto.setLicence_number(licence_number[i]);
				elDto.setGet_dt(get_dt[i]);
				elDto.setIns_type(ins_type[i]);

				System.out.println(elDto);
				licenceList.add(elDto);
			}

			result=eDao.insertEmpLicence(emp_id, licenceList);	
		}
		
		
		System.out.println("AjaxEmployeeSpecAddAction : "+result);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(String.valueOf(result));

	}

}
