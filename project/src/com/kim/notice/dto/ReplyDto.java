package com.kim.notice.dto;


public class ReplyDto {
	private int reply_id;
	private String notice_id;
	private String emp_id;
	private String emp_name;
	private String reply_content;
	private String register_dt;
	
	public String getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getRegister_dt() {
		return register_dt;
	}
	public void setRegister_dt(String register_dt) {
		this.register_dt = register_dt;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	@Override
	public String toString() {
		return "ReplyDto [reply_id=" + reply_id + ", notice_id=" + notice_id + ", emp_id=" + emp_id + ", emp_name="
				+ emp_name + ", reply_content=" + reply_content + ", register_dt=" + register_dt + "]";
	}
	
	
	
	
	
	
	

}
