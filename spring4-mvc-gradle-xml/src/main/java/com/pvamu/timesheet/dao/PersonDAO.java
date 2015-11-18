package com.pvamu.timesheet.dao;

import java.util.List;

import com.pvamu.timesheet.domain.Person;

public interface PersonDAO {	
	
	Person getPerson(Person req);
	Person savePerson(Person req);
	Person updatePerson(Person req);
	Person updateStatus(Person req);
	List<Person> getAllPerson();
}
