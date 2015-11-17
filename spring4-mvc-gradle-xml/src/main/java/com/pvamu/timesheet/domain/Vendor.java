package com.pvamu.timesheet.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Vendor")
public class Vendor implements Serializable {

	private static final long serialVersionUID = -2551103827749615063L;
	@Id
	private String id;	
	private String companyName;
	private String email;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", companyName=" + companyName + ", email=" + email + ", phone=" + phone + "]";
	}
	

}
