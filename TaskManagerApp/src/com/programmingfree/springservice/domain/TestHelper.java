package com.programmingfree.springservice.domain;

import java.util.Date;

public class TestHelper {
	
	Date date ;
	String lastYearVal ;
	String currentYearVal;
	String midemVal ;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLastYearVal() {
		return lastYearVal;
	}
	public void setLastYearVal(String lastYearVal) {
		this.lastYearVal = lastYearVal;
	}
	public String getCurrentYearVal() {
		return currentYearVal;
	}
	public void setCurrentYearVal(String currentYearVal) {
		this.currentYearVal = currentYearVal;
	}
	public String getMidemVal() {
		return  ""+((Integer.parseInt(lastYearVal)+ Integer.parseInt(currentYearVal)) /2);
	}
	public void setMidemVal(String midemVal) {
		this.midemVal = midemVal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentYearVal == null) ? 0 : currentYearVal.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((lastYearVal == null) ? 0 : lastYearVal.hashCode());
		result = prime * result + ((midemVal == null) ? 0 : midemVal.hashCode());
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
		TestHelper other = (TestHelper) obj;
		if (currentYearVal == null) {
			if (other.currentYearVal != null)
				return false;
		} else if (!currentYearVal.equals(other.currentYearVal))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (lastYearVal == null) {
			if (other.lastYearVal != null)
				return false;
		} else if (!lastYearVal.equals(other.lastYearVal))
			return false;
		if (midemVal == null) {
			if (other.midemVal != null)
				return false;
		} else if (!midemVal.equals(other.midemVal))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TestHelper [date=" + date + ", lastYearVal=" + lastYearVal + ", currentYearVal=" + currentYearVal
				+ ", midemVal=" + midemVal + "]";
	}
	
	
	
	
	
	
}
