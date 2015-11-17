package com.pvamu.timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pvamu.timesheet.dao.PersonDAO;
import com.pvamu.timesheet.domain.Person;

@Component
public class ManagerServiceImpl implements ManagerService {

	
	
	@Autowired
	private PersonDAO personDao;
	public static final String PERSON_COLLECTION = "users";

	

	public void addTask(Person p) {		
		personDao.create(p);

	}

	public void archiveTask(int taskId) {

	}

	public Person updateTask(Person p)  {
		personDao.update(p);
		
		return null;
	}

	public void changeTaskStatus(int taskId, String status)  {

	}

	
}