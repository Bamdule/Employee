package com.kim.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kim.notice.dao.NoticeDao;
import com.kim.notice.dto.ReplyDto;
import com.kim.project.common.controller.Action;

public class NoticeReplyDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	request.setCharacterEncoding("UTF-8");
		
		List<ReplyDto> replyList = null;
		String notice_id=request.getParameter("notice_id");
		int reply_id=Integer.parseInt(request.getParameter("reply_id"));
		
		System.out.println(notice_id + "  "+ reply_id);
		NoticeDao nDao =NoticeDao.getInstance();
		replyList=nDao.deleteNoticeReplyById(notice_id, reply_id);
		
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
