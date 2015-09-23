package com.programmingfree.springservice;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import com.programmingfree.dao.EmployeeTimeSheetDAO;
import com.programmingfree.dao.EmployeeTimeSheetDAOImpl;
import com.programmingfree.springservice.domain.EmployeeExpences;
import com.programmingfree.springservice.domain.EmployeeTimeSheet;
import com.programmingfree.springservice.utility.DBUtility;

public class EmployeeServiceImpl implements EmployeeService {

	
	private MongoOperations connection = DBUtility.getConnection();
	private EmployeeTimeSheetDAO dao = new EmployeeTimeSheetDAOImpl(connection);
	@Override
	public List<EmployeeTimeSheet> savetimeSheet(List<EmployeeTimeSheet>  req) {
		// TODO Auto-generated method stub
		return dao.savetimeSheet(req);
	}

	@Override
	public List<EmployeeExpences> saveExpences(List<EmployeeExpences> req) {
		// TODO Auto-generated method stub
		return dao.saveExpences(req);
	}

}
