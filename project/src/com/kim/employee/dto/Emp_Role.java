package com.kim.employee.dto;

public class Emp_Role {
	String role_name;
	String role_id;
	
	public String getRole_name() {
		return role_name;
	}
	
	public String getRole_id() {
		return role_id;
	}
	
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
	@Override
	public String toString() {
		return "Emp_Role [role_name=" + role_name + ", role_id=" + role_id + "]";
	}
	
	

}
