package com.pvamu.timesheet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.pvamu.timesheet.domain.EmployeeTimeSheet;
import com.pvamu.timesheet.domain.Person;
import com.pvamu.timesheet.domain.ProjectDeatil;
@Repository("UtilDAO")
public class UtilDAOImpl implements UtilDAO {

	@Qualifier("mongoTemplate")
	@Autowired
	private MongoOperations mongoOps;
	
	private static final String PROJECT_DETAIL = "ProjectDeatil";

	@Override
	public ProjectDeatil saveProjectDetail(ProjectDeatil req) {		
		mongoOps.insert(req,PROJECT_DETAIL );
		return req;
	}

	@Override
	public List<ProjectDeatil> getAllProjectDetail() {		
		return mongoOps.findAll(ProjectDeatil.class);
	}
	

}
