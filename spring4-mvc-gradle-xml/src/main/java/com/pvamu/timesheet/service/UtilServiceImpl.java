package com.pvamu.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pvamu.timesheet.dao.PersonDAO;
import com.pvamu.timesheet.dao.UtilDAO;
import com.pvamu.timesheet.domain.Person;
import com.pvamu.timesheet.domain.ProjectDeatil;
@Component
public class UtilServiceImpl implements UtilService {

	@Autowired
	private UtilDAO utilDao;
	
	@Autowired
	private PersonDAO personDao;
	
	
	@Override
	public ProjectDeatil saveProjectDetail(ProjectDeatil req) {		
		return utilDao.saveProjectDetail(req);
	}

	@Override
	public List<ProjectDeatil> getAllProjectDetail() {		
		return utilDao.getAllProjectDetail();
	}

	@Override
	public Person getPerson(Person req) {	
		
		return personDao.getPerson(req);
	}

	@Override
	public Person savePerson(Person req) {		
		return personDao.savePerson(req);
	}

	@Override
	public Person updatePerson(Person req) {		
		return personDao.updatePerson(req);
	}

	@Override
	public Person updateStatus(Person req) {		
		return personDao.updateStatus(req);
	}

	@Override
	public List<Person> getAllPerson() {
		
		return personDao.getAllPerson();
	}

}
