package com.programmingfree.springservice.domain;

import java.io.Serializable;
import java.util.Date;

public class EmployeeExpences implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7681598422725172466L;

	private Date date ;
	private float amount ;
	private String expencesType;
	private String comments;
	private String projectName;
	private String employeeId;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((expencesType == null) ? 0 : expencesType.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeExpences other = (EmployeeExpences) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (expencesType == null) {
			if (other.expencesType != null)
				return false;
		} else if (!expencesType.equals(other.expencesType))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EmployeeExpences [date=" + date + ", amount=" + amount + ", expencesType=" + expencesType
				+ ", comments=" + comments + ", projectName=" + projectName + ", employeeId=" + employeeId + "]";
	}
}
