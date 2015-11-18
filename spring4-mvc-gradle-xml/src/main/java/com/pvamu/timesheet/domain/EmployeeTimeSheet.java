package com.pvamu.timesheet.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "EmployeeTimeSheet")
public class EmployeeTimeSheet implements Serializable {

	private static final long serialVersionUID = 28351839853066330L;
	@Id
	private String id;	
	private String date ;
	private float workedHours ;
	private String projectName;
	private String employeeId;
	private List<EmployeeWeekDeatilTimeSheet> detaillTimeSheet;
	private List<EmployeeExpences> detaillExpences;
	private int totalExpencesAmount;
	private int totalworkAmount;
	private String approveStatus;
	private int totalAmount;
	private boolean paidStatus;
	private String commends;
	
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
	public float getWorkedHours() {
		return workedHours;
	}
	public void setWorkedHours(float workedHours) {
		this.workedHours = workedHours;
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
	public List<EmployeeWeekDeatilTimeSheet> getDetaillTimeSheet() {
		return detaillTimeSheet;
	}
	public void setDetaillTimeSheet(List<EmployeeWeekDeatilTimeSheet> detaillTimeSheet) {
		this.detaillTimeSheet = detaillTimeSheet;
	}
	public List<EmployeeExpences> getDetaillExpences() {
		return detaillExpences;
	}
	public void setDetaillExpences(List<EmployeeExpences> detaillExpences) {
		this.detaillExpences = detaillExpences;
	}
	public int getTotalExpencesAmount() {
		return totalExpencesAmount;
	}
	public void setTotalExpencesAmount(int totalExpencesAmount) {
		this.totalExpencesAmount = totalExpencesAmount;
	}
	public int getTotalworkAmount() {
		return totalworkAmount;
	}
	public void setTotalworkAmount(int totalworkAmount) {
		this.totalworkAmount = totalworkAmount;
	}
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public boolean isPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(boolean paidStatus) {
		this.paidStatus = paidStatus;
	}
	public String getCommends() {
		return commends;
	}
	public void setCommends(String commends) {
		this.commends = commends;
	}
	@Override
	public String toString() {
		return "EmployeeTimeSheet [id=" + id + ", date=" + date + ", workedHours=" + workedHours + ", projectName="
				+ projectName + ", employeeId=" + employeeId + ", detaillTimeSheet=" + detaillTimeSheet
				+ ", detaillExpences=" + detaillExpences + ", totalExpencesAmount=" + totalExpencesAmount
				+ ", totalworkAmount=" + totalworkAmount + ", approveStatus=" + approveStatus + ", totalAmount="
				+ totalAmount + ", paidStatus=" + paidStatus + ", commends=" + commends + "]";
	}
	

}
