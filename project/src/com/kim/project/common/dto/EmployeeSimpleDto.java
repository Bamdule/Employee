package com.kim.project.common.dto;

public class EmployeeSimpleDto {
	private String emp_id;
	private String emp_name;
	private boolean isManager;
	private int result;
	
	
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
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
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	@Override
	public String toString() {
		return "EmployeeSimpleDto [emp_id=" + emp_id + ", emp_name=" + emp_name + ", isManager=" + isManager
				+ ", result=" + result + "]";
	}

}
