package com.pvamu.timesheet.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Propertites")
public class Propertites implements Serializable {

	
	private static final long serialVersionUID = -4304617592238607877L;
	@Id
	private String id;
	private boolean laptop;
	private boolean phone;
	private boolean car;
	private String employeeId;
	private boolean prodServerAccess;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isLaptop() {
		return laptop;
	}
	public void setLaptop(boolean laptop) {
		this.laptop = laptop;
	}
	public boolean isPhone() {
		return phone;
	}
	public void setPhone(boolean phone) {
		this.phone = phone;
	}
	public boolean isCar() {
		return car;
	}
	public void setCar(boolean car) {
		this.car = car;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public boolean isProdServerAccess() {
		return prodServerAccess;
	}
	public void setProdServerAccess(boolean prodServerAccess) {
		this.prodServerAccess = prodServerAccess;
	}
	@Override
	public String toString() {
		return "Propertites [id=" + id + ", laptop=" + laptop + ", phone=" + phone + ", car=" + car + ", employeeId="
				+ employeeId + ", prodServerAccess=" + prodServerAccess + "]";
	}
	

}
