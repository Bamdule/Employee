package com.kim.employee.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kim.common.controller.Action;
import com.kim.common.dto.PageDto;
import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.EmployeeDto;

import util.PageHelper;

public class AjaxSearchEmployeeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestInfo = request.getParameter("requestInfo");
		String keyword = request.getParameter("keyword");
		String searchField = request.getParameter("searchField");
		String pageNum = request.getParameter("curPage");
		
		if(searchField==null){
			searchField="";
		}
		if(keyword==null){
			keyword="";
		} 
		int curPage=1;
		try{
			curPage= (pageNum==null)?1:Integer.parseInt(pageNum);
		}catch(Exception e){
			e.printStackTrace();
			curPage=1;
		}
		
		final int pagePerRecord=10;
		EmployeeDao eDao = EmployeeDao.getInstance();	
		List<EmployeeDto> empList=null;
		PageDto pDto=null;
		String json=null;
		System.out.println("keyword : "+keyword);
		System.out.println("searchField : "+searchField);
		System.out.println("pageNum : " + pageNum);
		JsonObject jsonObject=null;
		int totalRecord=eDao.getSearchEmployeeCount(searchField, keyword);
		
		if(requestInfo.equals("empList")){
			empList =eDao.searchEmployee(curPage, pagePerRecord, searchField, keyword);
			json=new Gson().toJson(empList);

			jsonObject = new JsonObject();
			jsonObject.addProperty("empList", json);
			jsonObject.addProperty("curPage", curPage);
			jsonObject.addProperty("keyword", keyword);
			jsonObject.addProperty("searchField", searchField);

			pDto=PageHelper.getBlockGroup(curPage, pagePerRecord, totalRecord);
			jsonObject.addProperty("isEmpty", pDto.getIsEmpty());
			jsonObject.addProperty("firstBlock", pDto.getFirstBlock());
			jsonObject.addProperty("lastBlock", pDto.getLastBlock());
			jsonObject.addProperty("nextPage", pDto.getNextPage());
			jsonObject.addProperty("prevPage", pDto.getPrevPage());
			
		}

		

		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jsonObject);

	}

}
