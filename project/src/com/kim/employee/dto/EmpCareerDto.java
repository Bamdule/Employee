package com.kim.employee.dto;

public class EmpCareerDto {
	private String corp_name;
	private String rank_name;
	private String emp_role;
	private String career_enter_dt;
	private String career_retire_dt;
	
	public String getCorp_name() {
		return corp_name;
	}
	public void setCorp_name(String corp_name) {
		this.corp_name = corp_name;
	}
	public String getRank_name() {
		return rank_name;
	}
	public void setRank_name(String rank_name) {
		this.rank_name = rank_name;
	}
	public String getEmp_role() {
		return emp_role;
	}
	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}
	public String getCareer_enter_dt() {
		return career_enter_dt;
	}
	public void setCareer_enter_dt(String career_enter_dt) {
		this.career_enter_dt = career_enter_dt;
	}
	public String getCareer_retire_dt() {
		return career_retire_dt;
	}
	public void setCareer_retire_dt(String career_retire_dt) {
		this.career_retire_dt = career_retire_dt;
	}
	@Override
	public String toString() {
		return "EmpCareerDto [corp_name=" + corp_name + ", rank_name=" + rank_name + ", emp_role=" + emp_role
				+ ", career_enter_dt=" + career_enter_dt + ", career_retire_dt=" + career_retire_dt + "]";
	}
	
	
	


}