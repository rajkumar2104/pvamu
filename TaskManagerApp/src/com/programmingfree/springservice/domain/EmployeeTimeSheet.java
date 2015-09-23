package com.programmingfree.springservice.domain;

import java.io.Serializable;
import java.util.Date;

public class EmployeeTimeSheet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 28351839853066330L;
	
	private Date date ;
	private float workedHour ;
	private String day;
	private String comments;
	private String projectName;
	private String employeeId;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getWorkedHour() {
		return workedHour;
	}
	public void setWorkedHour(float workedHour) {
		this.workedHour = workedHour;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
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
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + Float.floatToIntBits(workedHour);
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
		EmployeeTimeSheet other = (EmployeeTimeSheet) obj;
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
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (Float.floatToIntBits(workedHour) != Float.floatToIntBits(other.workedHour))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "employeeTimeSheet [date=" + date + ", workedHour=" + workedHour + ", day=" + day + ", comments="
				+ comments + ", projectName=" + projectName + ", employeeId=" + employeeId + "]";
	}
	
	

}
