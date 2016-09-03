package com.kim.employee.dto;

public class AcademicLevelDto {
	private String academic_lev_id;
	private String academic_lev_name;
	
	public String getAcademic_lev_id() {
		return academic_lev_id;
	}
	public void setAcademic_lev_id(String academic_lev_id) {
		this.academic_lev_id = academic_lev_id;
	}
	public String getAcademic_lev_name() {
		return academic_lev_name;
	}
	public void setAcademic_lev_name(String academic_lev_name) {
		this.academic_lev_name = academic_lev_name;
	}
	
	@Override
	public String toString() {
		return "AcademicLevelDto [academic_lev_id=" + academic_lev_id + ", academic_lev_name=" + academic_lev_name
				+ "]";
	}
	
	
	
	

}
