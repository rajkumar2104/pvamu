package com.pvamu.timesheet.service;

import com.pvamu.timesheet.domain.Person;

public interface ManagerService {	

	public void addTask(Person p);
	public Person updateTask(Person p);
}