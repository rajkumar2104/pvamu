package com.programmingfree.dao;

import java.util.List;

import com.programmingfree.springservice.domain.EmployeeExpences;
import com.programmingfree.springservice.domain.EmployeeTimeSheet;

public interface EmployeeTimeSheetDAO {

	List<EmployeeTimeSheet> savetimeSheet(List<EmployeeTimeSheet> req);
	List<EmployeeExpences> saveExpences(List<EmployeeExpences> req);	
	
	
}
