package com.kim.common.dto;

public class RoleDto {
	private String ROLE_ID;
	private String ROLE_NAME;
	
	
	public String getROLE_ID() {
		return ROLE_ID;
	}
	public void setROLE_ID(String rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}
	public String getROLE_NAME() {
		return ROLE_NAME;
	}
	public void setROLE_NAME(String rOLE_NAME) {
		ROLE_NAME = rOLE_NAME;
	}
	
	@Override
	public String toString() {
		return "RoleDto [ROLE_ID=" + ROLE_ID + ", ROLE_NAME=" + ROLE_NAME + "]";
	}
	
	

	
}
