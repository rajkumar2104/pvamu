package com.programmingfree.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import com.programmingfree.springservice.domain.EmployeeExpences;
import com.programmingfree.springservice.domain.EmployeeTimeSheet;

public class EmployeeTimeSheetDAOImpl implements EmployeeTimeSheetDAO {

	private MongoOperations mongoOps;
	private static final String EMPLOYEE_TIMESHEET_COLLECTION = "employeeTimeSheet";
	private static final String EMPLOYEE_EXPENCES_COLLECTION = "employeeExpences";
	
	public EmployeeTimeSheetDAOImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}
	
	@Override
	public List<EmployeeTimeSheet> savetimeSheet(List<EmployeeTimeSheet> req) {
		mongoOps.insert(req,EMPLOYEE_TIMESHEET_COLLECTION );
		return req;
	}

	@Override
	public List<EmployeeExpences> saveExpences(List<EmployeeExpences> req) {
		mongoOps.insert(req,EMPLOYEE_EXPENCES_COLLECTION );
		return req;
	}

}
