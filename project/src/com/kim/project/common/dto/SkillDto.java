package com.kim.project.common.dto;

public class SkillDto {
	private String skill_id;
	private String skill_name;
	public String getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(String skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	
	@Override
	public String toString() {
		return "SkillDto [skill_id=" + skill_id + ", skill_name=" + skill_name + "]";
	}
	
	
}
