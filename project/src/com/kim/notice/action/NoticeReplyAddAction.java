package com.kim.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kim.common.controller.Action;
import com.kim.notice.dao.NoticeDao;
import com.kim.notice.dto.ReplyDto;

public class NoticeReplyAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session =request.getSession();
		
		ReplyDto rDto = new ReplyDto();
		List<ReplyDto> replyList = null;
		rDto.setNotice_id(request.getParameter("notice_id"));
		rDto.setEmp_id((String)session.getAttribute("emp_id"));
		rDto.setReply_content(request.getParameter("reply_content"));
		
		NoticeDao nDao =NoticeDao.getInstance();
		replyList=nDao.insertReplyToNotice(rDto);
		
		JsonArray jsonArray =new JsonArray(); 
		
		for(ReplyDto dto : replyList)
		{
			JsonObject json = new JsonObject();
			json.addProperty("reply_id", dto.getReply_id());
			json.addProperty("emp_name", dto.getEmp_name());
			json.addProperty("register_dt", dto.getRegister_dt());
			json.addProperty("reply_content", dto.getReply_content());
			jsonArray.add(json);
		}

		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jsonArray);

	}

}
