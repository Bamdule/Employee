package com.kim.common.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kim.common.controller.Action;
import com.kim.common.dao.ZipDao;
import com.kim.common.dto.ZipDto;

public class AjaxAddressSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String dong = request.getParameter("dong");
		System.out.println(dong);
		ZipDao zDao= ZipDao.getInstance();
		List<ZipDto> zipList =new ArrayList<ZipDto>();
		
		zipList=zDao.searchKeyDong(dong);
		
		for(int i=0;i<zipList.size();i++)
			System.out.println(zipList.get(i));
		
		String json = new Gson().toJson(zipList);
		
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
