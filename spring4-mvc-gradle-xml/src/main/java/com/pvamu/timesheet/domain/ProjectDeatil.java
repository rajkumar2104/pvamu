package com.pvamu.timesheet.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "ProjectDeatil")
public class ProjectDeatil implements Serializable{

	private static final long serialVersionUID = 7195196513984212363L;
	@Id
	private String id;	
	private String name;
	private String manager_id;
	private Date startDate;
	private Date endDate;
	private long totalFund;
	private long burrendAmount;
	private long remaningAmount;
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getTotalFund() {
		return totalFund;
	}
	public void setTotalFund(long totalFund) {
		this.totalFund = totalFund;
	}
	public long getBurrendAmount() {
		return burrendAmount;
	}
	public void setBurrendAmount(long burrendAmount) {
		this.burrendAmount = burrendAmount;
	}
	public long getRemaningAmount() {
		return remaningAmount;
	}
	public void setRemaningAmount(long remaningAmount) {
		this.remaningAmount = remaningAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProjectDeatil [id=" + id + ", name=" + name + ", manager_id=" + manager_id + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", totalFund=" + totalFund + ", burrendAmount=" + burrendAmount
				+ ", remaningAmount=" + remaningAmount + ", status=" + status + "]";
	}

}
