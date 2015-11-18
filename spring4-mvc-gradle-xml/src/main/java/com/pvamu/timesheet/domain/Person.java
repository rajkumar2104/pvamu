package com.pvamu.timesheet.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = 6669770348882646019L;
	
	//id will be used for storing MongoDB _id
	@Id
	private String id;	
	private String firstName;
	private String lastName;
	private String emplyeeType;
	private String employeeId;
	private Propertites properties;
	private List<ProjectDeatil> projectName;
	private String startDate;
	private String endDate;
	private boolean activeStatus;
	private String emailId;
	private String phone;
	private int hoursAmount;
	private Vendor Vendor_Id;
	private String userName;
	private String password;
	
	public Person(){
		
	}
	public Person(String id, String name , String loca){
		firstName = name;
		emplyeeType = loca;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmplyeeType() {
		return emplyeeType;
	}
	public void setEmplyeeType(String emplyeeType) {
		this.emplyeeType = emplyeeType;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public Propertites getProperties() {
		return properties;
	}
	public void setProperties(Propertites properties) {
		this.properties = properties;
	}
	public List<ProjectDeatil> getProjectName() {
		return projectName;
	}
	public void setProjectName(List<ProjectDeatil> projectName) {
		this.projectName = projectName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public boolean isActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getHoursAmount() {
		return hoursAmount;
	}
	public void setHoursAmount(int hoursAmount) {
		this.hoursAmount = hoursAmount;
	}
	public Vendor getVendor_Id() {
		return Vendor_Id;
	}
	public void setVendor_Id(Vendor vendor_Id) {
		Vendor_Id = vendor_Id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emplyeeType="
				+ emplyeeType + ", employeeId=" + employeeId + ", properties=" + properties + ", projectName="
				+ projectName + ", startDate=" + startDate + ", endDate=" + endDate + ", activeStatus=" + activeStatus
				+ ", emailId=" + emailId + ", phone=" + phone + ", hoursAmount=" + hoursAmount + ", Vendor_Id="
				+ Vendor_Id + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
