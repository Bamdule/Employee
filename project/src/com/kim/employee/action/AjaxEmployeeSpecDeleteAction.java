package com.kim.employee.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.kim.common.controller.Action;
import com.kim.employee.dao.EmployeeDao;

public class AjaxEmployeeSpecDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String spec_name = (String) request.getParameter("spec_name");
		String spec_seq = (String) request.getParameter("spec_seq");
		System.out.println(spec_seq);
		EmployeeDao eDao = EmployeeDao.getInstance();
		boolean delete_result=true;
		
		
		if(spec_name.equals("academic")){
			delete_result=eDao.deleteEmployeeAcademic(spec_seq);
		}
		else if(spec_name.equals("career")){
			delete_result=eDao.deleteEmployeeCareer(spec_seq);
		}
		else if(spec_name.equals("licence")){
			delete_result=eDao.deleteEmployeeLicence(spec_seq);
		}
	//	System.out.println("delete_result : "+delete_result);
		
		JsonObject json=new JsonObject();
		json.addProperty("delete_result", delete_result);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(json);
	}

}
