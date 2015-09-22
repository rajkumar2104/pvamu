package com.programmingfree.springservice;

import com.programmingfree.springservice.domain.Person;

public interface TaskManagerService {	

	public void addTask(Person p);
	public Person updateTask(Person p);
}