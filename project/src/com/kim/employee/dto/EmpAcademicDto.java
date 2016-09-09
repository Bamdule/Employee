package com.kim.employee.dto;

public class EmpAcademicDto {
	private String academic_seq;
	private String emp_id;
	private String academic_lev_id;
	private String academic_lev_name;
	private String academic_status_id;
	private String academic_status_name;
	private String academic_name;
	private String major_name;
	private String enter_dt;
	private String graduation_dt;
	
	
	
	public String getAcademic_seq() {
		return academic_seq;
	}
	public void setAcademic_seq(String academic_seq) {
		this.academic_seq = academic_seq;
	}
	public String getAcademic_lev_name() {
		return academic_lev_name;
	}
	public void setAcademic_lev_name(String academic_lev_name) {
		this.academic_lev_name = academic_lev_name;
	}
	public String getAcademic_status_name() {
		return academic_status_name;
	}
	public void setAcademic_status_name(String academic_status_name) {
		this.academic_status_name = academic_status_name;
	}
	public String getAcademic_name() {
		return academic_name;
	}
	public void setAcademic_name(String academic_name) {
		this.academic_name = academic_name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getAcademic_lev_id() {
		return academic_lev_id;
	}
	public void setAcademic_lev_id(String academic_lev_id) {
		this.academic_lev_id = academic_lev_id;
	}
	public String getAcademic_status_id() {
		return academic_status_id;
	}
	public void setAcademic_status_id(String academic_status_id) {
		this.academic_status_id = academic_status_id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getEnter_dt() {
		return enter_dt;
	}
	public void setEnter_dt(String enter_dt) {
		this.enter_dt = enter_dt;
	}
	public String getGraduation_dt() {
		return graduation_dt;
	}
	public void setGraduation_dt(String graduation_dt) {
		this.graduation_dt = graduation_dt;
	}
	@Override
	public String toString() {
		return "EmpAcademicDto [academic_seq=" + academic_seq + ", emp_id=" + emp_id + ", academic_lev_id="
				+ academic_lev_id + ", academic_lev_name=" + academic_lev_name + ", academic_status_id="
				+ academic_status_id + ", academic_status_name=" + academic_status_name + ", academic_name="
				+ academic_name + ", major_name=" + major_name + ", enter_dt=" + enter_dt + ", graduation_dt="
				+ graduation_dt + "]";
	}
	
	

}
