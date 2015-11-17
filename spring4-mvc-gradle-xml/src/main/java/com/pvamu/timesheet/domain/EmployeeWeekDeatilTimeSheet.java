package com.pvamu.timesheet.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeWeekDeatilTimeSheet")
public class EmployeeWeekDeatilTimeSheet implements Serializable{
	
	
	private static final long serialVersionUID = 2398122688966083512L;
	@Id
	private String id;	
	private String date ;
	private float workedHour ;
	private String day;
	private String comments;
	
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
	@Override
	public String toString() {
		return "EmployeeWeekDeatilTimeSheet [id=" + id + ", date=" + date + ", workedHour=" + workedHour + ", day="
				+ day + ", comments=" + comments + "]";
	}
}
