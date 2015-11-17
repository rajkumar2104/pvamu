package com.pvamu.timesheet.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository("FinanceDAO")
public class FinanceDAOImpl implements FinanceDAO {

	@Qualifier("mongoTemplate")
	@Autowired
	private MongoOperations mongoOps;
	private static final String EMPLOYEE_TIMESHEET_COLLECTION = "employeeTimeSheet";
	private static final String EMPLOYEE_EXPENCES_COLLECTION = "employeeExpences";
	
	
	
}
