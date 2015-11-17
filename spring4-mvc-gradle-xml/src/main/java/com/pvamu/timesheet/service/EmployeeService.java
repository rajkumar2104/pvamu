package com.pvamu.timesheet.service;

import java.util.List;

import com.pvamu.timesheet.domain.EmployeeExpences;
import com.pvamu.timesheet.domain.EmployeeTimeSheet;

public interface EmployeeService {
	
	EmployeeTimeSheet savetimeSheet(EmployeeTimeSheet req);
	EmployeeExpences saveExpences(EmployeeExpences req);
	List<EmployeeTimeSheet> gettimeSheet(EmployeeTimeSheet req);
	List<EmployeeExpences> getExpences(String name);
	

}
