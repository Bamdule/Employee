package com.kim.project.dto;

public class CorpProjectDto {
	private int project_seq;
	private String project_id;
	private String project_name;
	private String corp_name;
	private String start_dt;
	private String end_dt;	
	private String project_content;
	private String corp_own;
	private String remarks;
	private String join_num;
	private String role;
	


	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getProject_seq() {
		return project_seq;
	}
	public void setProject_seq(int project_seq) {
		this.project_seq = project_seq;
	}
	public String getJoin_num() {
		return join_num;
	}
	public void setJoin_num(String join_num) {
		this.join_num = join_num;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getCorp_name() {
		return corp_name;
	}
	public void setCorp_name(String corp_name) {
		this.corp_name = corp_name;
	}
	public String getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}
	public String getEnd_dt() {
		return end_dt;
	}
	public void setEnd_dt(String end_dt) {
		this.end_dt = end_dt;
	}
	public String getProject_content() {
		return project_content;
	}
	public void setProject_content(String project_content) {
		this.project_content = project_content;
	}
	public String getCorp_own() {
		return corp_own;
	}
	public void setCorp_own(String corp_own) {
		this.corp_own = corp_own;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "CorpProjectDto [project_seq=" + project_seq + ", project_id=" + project_id + ", project_name="
				+ project_name + ", corp_name=" + corp_name + ", start_dt=" + start_dt + ", end_dt=" + end_dt
				+ ", project_content=" + project_content + ", corp_own=" + corp_own + ", remarks=" + remarks
				+ ", join_num=" + join_num + ", role=" + role + "]";
	}

}
