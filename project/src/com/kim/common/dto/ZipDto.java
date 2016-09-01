package com.kim.common.dto;

public class ZipDto {
    private String seq;
    private String zipcode;
    private String sido;
    private String gugun;
    private String dong;
    private String ri;
    private String bldg;
    private String bunji;
    
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
	}
	public String getBldg() {
		return bldg;
	}
	public void setBldg(String bldg) {
		this.bldg = bldg;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	@Override
	public String toString() {
		return "ZipDto [seq=" + seq + ", zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong
				+ ", ri=" + ri + ", bldg=" + bldg + ", bunji=" + bunji + "]";
	}
   
   
    
}