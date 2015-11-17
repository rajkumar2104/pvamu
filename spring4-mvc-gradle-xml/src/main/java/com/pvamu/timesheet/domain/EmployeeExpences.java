package com.pvamu.timesheet.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "EmployeeExpences")
public class EmployeeExpences implements Serializable {

	private static final long serialVersionUID = -7681598422725172466L;
	@Id
	private String id;	
	private String date ;
	private float amount ;
	private String expencesType;
	private String comments;
	private String projectName;
	private String employeeId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getExpencesType() {
		return expencesType;
	}
	public void setExpencesType(String expencesType) {
		this.expencesType = expencesType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "EmployeeExpences [id=" + id + ", date=" + date + ", amount=" + amount + ", expencesType=" + expencesType
				+ ", comments=" + comments + ", projectName=" + projectName + ", employeeId=" + employeeId + "]";
	}
	
	
	
}
