package com.kim.employee.dto;

public class EmpLicenceDto {
	private String licence_seq;
	private String institution;
	private String licence_name;
	private String licence_number;
	private String get_dt;
	private String ins_type;
	
	
	public String getLicence_seq() {
		return licence_seq;
	}
	public void setLicence_seq(String licence_seq) {
		this.licence_seq = licence_seq;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getLicence_name() {
		return licence_name;
	}
	public void setLicence_name(String licence_name) {
		this.licence_name = licence_name;
	}
	public String getLicence_number() {
		return licence_number;
	}
	public void setLicence_number(String licence_number) {
		this.licence_number = licence_number;
	}
	public String getGet_dt() {
		return get_dt;
	}
	public void setGet_dt(String get_dt) {
		this.get_dt = get_dt;
	}
	public String getIns_type() {
		return ins_type;
	}
	public void setIns_type(String ins_type) {
		this.ins_type = ins_type;
	}
	@Override
	public String toString() {
		return "EmpLicenceDto [licence_seq=" + licence_seq + ", institution=" + institution + ", licence_name="
				+ licence_name + ", licence_number=" + licence_number + ", get_dt=" + get_dt + ", ins_type=" + ins_type
				+ "]";
	}
	
	
	
}
