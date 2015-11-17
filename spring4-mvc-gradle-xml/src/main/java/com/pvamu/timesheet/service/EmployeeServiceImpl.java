package com.pvamu.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pvamu.timesheet.dao.EmployeeTimeSheetDAO;
import com.pvamu.timesheet.domain.EmployeeExpences;
import com.pvamu.timesheet.domain.EmployeeTimeSheet;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeTimeSheetDAO dao;
	
	@Override
	public EmployeeTimeSheet savetimeSheet(EmployeeTimeSheet  req) {
		
		return dao.savetimeSheet(req);
	}

	@Override
	public EmployeeExpences saveExpences(EmployeeExpences req) {
		
		return dao.saveExpences(req);
	}

	@Override
	public List<EmployeeTimeSheet> gettimeSheet(EmployeeTimeSheet req) {
		
		return dao.gettimeSheet(req);
	}

	@Override
	public List<EmployeeExpences> getExpences(String name) {
		
		return dao.getExpences(name);
	}

}
