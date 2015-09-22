package com.programmingfree.springservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.programmingfree.dao.PersonDAO;
import com.programmingfree.dao.PersonDAOImpl;
import com.programmingfree.springservice.domain.Person;
import com.programmingfree.springservice.utility.DBUtility;

@Service(value = "TaskManagerService")
public class TaskManagerServiceImpl implements TaskManagerService {

	private MongoOperations connection = DBUtility.getConnection();
	 
	private PersonDAO personDao = new PersonDAOImpl(connection) ;
	
	
	public static final String PERSON_COLLECTION = "users";

	public TaskManagerServiceImpl() {
		connection = DBUtility.getConnection();
	}

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