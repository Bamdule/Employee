package com.kim.project.dto;

public class EmpRoleDto {
	private String emp_id;
	private String role_id;
	private String role_name;
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "EmpRoleDto [emp_id=" + emp_id + ", role_id=" + role_id + ", role_name=" + role_name + "]";
	}
	
	

}
