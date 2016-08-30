package com.kim.employee.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.common.dto.PageDto;
import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.EmployeeDto;

import util.PageHelper;

public class EmployeeListAction implements Action{
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		String url="jsp/employee/employee_List.jsp";		
		final int pagePerRecord=15;
		
		String pageNum = request.getParameter("curPage");
		int curPage=1;
		try{
			curPage= (pageNum==null)?1:Integer.parseInt(pageNum);
		}catch(Exception e)
		{
			e.printStackTrace();
			curPage=1;
		}
		
		EmployeeDao dao = EmployeeDao.getInstance();
		List<EmployeeDto> empList =dao.selectAllEmployee(curPage,pagePerRecord);
		int totalRecord = dao.getEmpCount();
		
		PageDto pDto=PageHelper.getBlockGroup(curPage, pagePerRecord,totalRecord);
		
		
		request.setAttribute("empList", empList);
		request.setAttribute("paging", pDto);
		
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		
		disp.forward(request, response);
	}

}
