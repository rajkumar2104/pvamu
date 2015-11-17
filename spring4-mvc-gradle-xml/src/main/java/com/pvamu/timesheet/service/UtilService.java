package com.pvamu.timesheet.service;

import java.util.List;

import com.pvamu.timesheet.domain.Person;
import com.pvamu.timesheet.domain.ProjectDeatil;

public interface UtilService {
	
	
	
	ProjectDeatil saveProjectDetail(ProjectDeatil req);
	List<ProjectDeatil> getAllProjectDetail();
	
	Person getPerson(Person req);
	Person savePerson(Person req);
	Person updatePerson(Person req);
	Person updateStatus(Person req);
	
	
}
