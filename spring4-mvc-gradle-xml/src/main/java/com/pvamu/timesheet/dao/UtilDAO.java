package com.pvamu.timesheet.dao;

import java.util.List;

import com.pvamu.timesheet.domain.Person;
import com.pvamu.timesheet.domain.ProjectDeatil;

public interface UtilDAO {

	
	ProjectDeatil saveProjectDetail(ProjectDeatil req);
	List<ProjectDeatil> getAllProjectDetail();
}
