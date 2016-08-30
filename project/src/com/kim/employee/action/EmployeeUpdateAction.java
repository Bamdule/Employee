package com.kim.employee.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.common.dto.SkillDto;
import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.EmployeeDto;
import com.oreilly.servlet.MultipartRequest;

import util.CreateEmployeeID;
import util.UploadManager;

public class EmployeeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url="EmployeeServlet?command=employee_info";
		String imgPath=null;


		MultipartRequest multi = UploadManager.getMultiPartRequest(request);
			EmployeeDao dao = EmployeeDao.getInstance();
			EmployeeDto dto =new EmployeeDto();
			imgPath=multi.getFilesystemName("emp_imgpath");
			if(imgPath==null){
				imgPath=multi.getParameter("imgNotUpdate");
			}
			String skill_names[] = multi.getParameterValues("skills");
			
			List<SkillDto> skillList = null;
			SkillDto sDto =null;
		
			if(skill_names!=null){
				skillList = new ArrayList<SkillDto>();
				for(int index=0;index<skill_names.length;index++)
				{
					sDto=new SkillDto();
					sDto.setSkill_id(skill_names[index]);
					skillList.add(sDto);
				}
			}
			dto.setSkillList(skillList);
			dto.setEmp_id(multi.getParameter("emp_id"));
			dto.setEmp_name(multi.getParameter("emp_name"));
			dto.setEmp_pwd(multi.getParameter("emp_pwd"));
			dto.setEmp_phone(multi.getParameter("emp_phone"));
			dto.setZipcode(multi.getParameter("zipcode"));
			dto.setEmp_addr(multi.getParameter("emp_addr"));
			dto.setEmp_detailaddr(multi.getParameter("emp_detailaddr"));
			
			
			dto.setEmp_email(multi.getParameter("front_email")+"@"+multi.getParameter("back_email"));
			dto.setEmp_sal(Integer.parseInt(multi.getParameter("emp_sal")));
			dto.setEmp_imgpath(imgPath);
			dto.setEmp_imgpathorn(imgPath);
			dto.setDept_id(multi.getParameter("dept_id"));
			dto.setRank_id(multi.getParameter("rank_id"));
			
			System.out.println(dto);
			
			if(dao.employeeUpdate(dto))
			{
				//dto가 성공적으로 업데이트 되었다면 유저id를 setAttribute한다.
				request.setAttribute("emp_id", dto.getEmp_id());
			}
			
		RequestDispatcher disp =request.getRequestDispatcher(url);
		disp.forward(request, response);
		
		
	}

}
