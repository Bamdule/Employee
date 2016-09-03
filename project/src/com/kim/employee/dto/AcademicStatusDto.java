package com.kim.employee.dto;

public class AcademicStatusDto {

	private String academic_status_id;
	private String academic_status_name;
	
	public String getAcademic_status_id() {
		return academic_status_id;
	}
	public void setAcademic_status_id(String academic_status_id) {
		this.academic_status_id = academic_status_id;
	}
	public String getAcademic_status_name() {
		return academic_status_name;
	}
	public void setAcademic_status_name(String academic_status_name) {
		this.academic_status_name = academic_status_name;
	}
	@Override
	public String toString() {
		return "AcademicStatusDto [academic_status_id=" + academic_status_id + ", academic_status_name="
				+ academic_status_name + "]";
	}
	
	
	

}
