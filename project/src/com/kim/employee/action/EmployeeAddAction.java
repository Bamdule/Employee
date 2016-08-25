package com.kim.employee.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.DepartmentDto;
import com.kim.employee.dto.EmployeeDto;
import com.kim.employee.dto.RankDto;
import com.kim.project.common.controller.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import util.CreateEmployeeID;
import util.UploadManager;

public class EmployeeAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "EmployeeServlet?command=employee_info";

		
			
		EmployeeDao dao = EmployeeDao.getInstance();
		EmployeeDto dto = new EmployeeDto();
		MultipartRequest multi = UploadManager.getMultiPartRequest(request);

		dto.setEmp_id(CreateEmployeeID.createEmpID(multi.getParameter("enter_dt")));
		dto.setEmp_name(multi.getParameter("emp_name"));
		dto.setEmp_pwd(multi.getParameter("emp_pwd"));
		dto.setRes_num(multi.getParameter("front_resident_num") + multi.getParameter("back_resident_num"));
		dto.setEmp_phone(multi.getParameter("emp_phone"));
		dto.setZipcode(multi.getParameter("zipcode"));
		dto.setEmp_addr(multi.getParameter("emp_addr"));
		dto.setEmp_detailaddr(multi.getParameter("emp_detailaddr"));
		dto.setEmp_email(multi.getParameter("front_email") +'@'+ multi.getParameter("back_email"));
		dto.setEnter_dt(multi.getParameter("enter_dt"));
		dto.setEmp_sal(Integer.parseInt(multi.getParameter("emp_sal")));
		dto.setEmp_imgpath(multi.getFilesystemName("emp_imgpath"));
		dto.setEmp_imgpathorn(multi.getOriginalFileName("emp_imgpath"));
		dto.setDept_id(multi.getParameter("dept_id"));
		dto.setRank_id(multi.getParameter("rank_id"));
		

		if (!dao.insertEmployeeInfo(dto)) {
			url = "EmployeeServlet?command=employee_addform";
		}
		else
			request.setAttribute("emp_id", dto.getEmp_id());
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);

	}

}
