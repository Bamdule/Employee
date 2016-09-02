package com.kim.employee.dto;

import java.util.List;

import com.kim.common.dto.SkillDto;

public class EmployeeDto {
	private int emp_seq;
	private String emp_id;
	private String emp_pwd;
	private String emp_name;
	private String res_num;


	private String emp_phone;
	private String emp_addr;
	private String emp_detailaddr;
	private String emp_email;
	private String front_email;
	private String back_email;
	
	private String zipcode;
	private String enter_dt;
	private String retire_dt;
	private String update_dt;
	
	private int emp_sal;
	private String emp_imgpath;
	private String emp_imgpathorn;
	
	private String dept_id;
	private String dept_name;
	private String rank_id;
	private String rank_name;
	private String role_id;
	private String role_name;


	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	private List<SkillDto> skillList;
	
	
	
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public List<SkillDto> getSkillList() {
		return skillList;
	}
	public void setSkillList(List<SkillDto> skillList) {
		this.skillList = skillList;
	}
	public String getFront_email() {
		return front_email;
	}
	public void setFront_email(String front_email) {
		this.front_email = front_email;
	}
	public String getBack_email() {
		return back_email;
	}
	public void setBack_email(String back_email) {
		this.back_email = back_email;
	}
	public int getEmp_seq() {
		return emp_seq;
	}
	public void setEmp_seq(int emp_seq) {
		this.emp_seq = emp_seq;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getRank_name() {
		return rank_name;
	}
	public void setRank_name(String rank_name) {
		this.rank_name = rank_name;
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
	public String getRes_num() {
		return res_num;
	}
	public void setRes_num(String res_num) {
		this.res_num = res_num;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_addr() {
		return emp_addr;
	}
	public void setEmp_addr(String emp_addr) {
		this.emp_addr = emp_addr;
	}
	
	public String getEmp_detailaddr() {
		return emp_detailaddr;
	}
	public void setEmp_detailaddr(String emp_detailaddr) {
		this.emp_detailaddr = emp_detailaddr;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEnter_dt() {
		return enter_dt;
	}
	public void setEnter_dt(String enter_dt) {
		this.enter_dt = enter_dt;
	}
	public String getRetire_dt() {
		return retire_dt;
	}
	public void setRetire_dt(String retire_dt) {
		this.retire_dt = retire_dt;
	}
	public String getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	public int getEmp_sal() {
		return emp_sal;
	}
	public void setEmp_sal(int emp_sal) {
		this.emp_sal = emp_sal;
	}
	public String getEmp_imgpath() {
		return emp_imgpath;
	}
	public void setEmp_imgpath(String emp_imgpath) {
		this.emp_imgpath = emp_imgpath;
	}
	public String getEmp_imgpathorn() {
		return emp_imgpathorn;
	}
	public void setEmp_imgpathorn(String emp_imgpathorn) {
		this.emp_imgpathorn = emp_imgpathorn;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getRank_id() {
		return rank_id;
	}
	public void setRank_id(String rank_id) {
		this.rank_id = rank_id;
	}
	
	public String getEmp_pwd() {
		return emp_pwd;
	}
	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}
	@Override
	public String toString() {
		return "EmployeeDto [emp_seq=" + emp_seq + ", emp_id=" + emp_id + ", emp_pwd=" + emp_pwd + ", emp_name="
				+ emp_name + ", res_num=" + res_num + ", emp_phone=" + emp_phone + ", emp_addr=" + emp_addr
				+ ", emp_detailaddr=" + emp_detailaddr + ", emp_email=" + emp_email + ", front_email=" + front_email
				+ ", back_email=" + back_email + ", zipcode=" + zipcode + ", enter_dt=" + enter_dt + ", retire_dt="
				+ retire_dt + ", update_dt=" + update_dt + ", emp_sal=" + emp_sal + ", emp_imgpath=" + emp_imgpath
				+ ", emp_imgpathorn=" + emp_imgpathorn + ", dept_id=" + dept_id + ", dept_name=" + dept_name
				+ ", rank_id=" + rank_id + ", rank_name=" + rank_name + ", role_name=" + role_name + ", role_id="
				+ role_id + ", skillList=" + skillList + "]";
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
	

}
