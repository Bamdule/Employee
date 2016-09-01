package com.kim.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.common.controller.Action;
import com.kim.common.dao.SkillDao;
import com.kim.common.dto.SkillDto;

public class CorpProjectAddFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="jsp/corp_project/corp_project_Add.jsp";
		
		SkillDao sDao =SkillDao.getInstance();
		List<SkillDto> skillList =sDao.selectAllSkills();
		
		request.setAttribute("skillList", skillList);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
