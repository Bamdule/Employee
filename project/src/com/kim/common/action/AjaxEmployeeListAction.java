package com.kim.common.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kim.common.controller.Action;
import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.EmployeeDto;

public class AjaxEmployeeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] emp_ids = request.getParameterValues("empList[]");
		List<EmployeeDto> empList=null;
		
		EmployeeDao dao = EmployeeDao.getInstance();
		if(emp_ids==null){
			int totalRecord = dao.getEmpCount();
			empList = dao.selectAllEmployee(1, totalRecord);
		}
		else{
			empList=new ArrayList<EmployeeDto>();
			for(int i=0;i<emp_ids.length;i++){
				EmployeeDto eDto = dao.selectEmpById(emp_ids[i]);
				eDto.setEmp_seq(i+1);	
				empList.add(eDto);
			}
		}
		String json = new Gson().toJson(empList);
		
		//JsonArray jsonArray =new JsonArray(); //JsonArray생성

		/*for(int i=0;i<empList.size();i++){
			JsonObject json = new JsonObject();
			json.addProperty("emp_seq", empList.get(i).getEmp_seq());
			json.addProperty("emp_id", empList.get(i).getEmp_id());
			json.addProperty("emp_name", empList.get(i).getEmp_name());
			json.addProperty("dept_name", empList.get(i).getDept_name());
			json.addProperty("rank_name", empList.get(i).getRank_name());

			jsonArray.add(json);
		}*/
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(json);


	}

}
