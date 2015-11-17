package com.pvamu.timesheet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.pvamu.timesheet.domain.EmployeeExpences;
import com.pvamu.timesheet.domain.EmployeeTimeSheet;

@Repository("EmployeeTimeSheetDAO")
public class EmployeeTimeSheetDAOImpl implements EmployeeTimeSheetDAO {

	@Qualifier("mongoTemplate")
	@Autowired
	private MongoOperations mongoOps;
	private static final String EMPLOYEE_TIMESHEET_COLLECTION = "employeeTimeSheet";
	private static final String EMPLOYEE_EXPENCES_COLLECTION = "employeeExpences";
	
	
	
	@Override
	public EmployeeTimeSheet savetimeSheet(EmployeeTimeSheet req) {
		mongoOps.save(req,EMPLOYEE_TIMESHEET_COLLECTION );
		return req;
	}

	@Override
	public EmployeeExpences saveExpences(EmployeeExpences req) {
		mongoOps.save(req,EMPLOYEE_EXPENCES_COLLECTION );
		return req;
	}

	@Override
	public List<EmployeeTimeSheet> gettimeSheet(EmployeeTimeSheet req) {
		Query query = new Query(Criteria.where("employeeId").is(req.getEmployeeId()));
		if(req.getDate() != null){
		query.addCriteria(Criteria.where("date").is(req.getDate()));
		}
		
		return mongoOps.find(query, EmployeeTimeSheet.class,EMPLOYEE_TIMESHEET_COLLECTION);
	}

	@Override
	public List<EmployeeExpences> getExpences(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		return mongoOps.find(query, EmployeeExpences.class);
	}

}
