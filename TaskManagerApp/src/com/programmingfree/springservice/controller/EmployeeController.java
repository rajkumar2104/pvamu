package com.programmingfree.springservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.programmingfree.springservice.EmployeeService;
import com.programmingfree.springservice.EmployeeServiceImpl;
import com.programmingfree.springservice.domain.EmployeeExpences;
import com.programmingfree.springservice.domain.EmployeeTimeSheet;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
		
	 EmployeeService service = new EmployeeServiceImpl();	
	
	 @RequestMapping(value="/save/timesheet",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<EmployeeTimeSheet> saveTimesheet(@RequestBody ArrayList<EmployeeTimeSheet> req) {
		return service.savetimeSheet(req);	 
	 }
	 
	 @RequestMapping(value="/save/expences",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<EmployeeExpences> saveExpences(@RequestBody ArrayList<EmployeeExpences> req) {
		return service.saveExpences(req);	 
	 }	 
	 
//	 @RequestMapping(value="/get/allExpences/{name}",method = RequestMethod.GET,headers="Accept=application/json")
//	 public List<EmployeeExpences> getAllExpences(@PathVariable("name")  String name) {
//		return service.getExpences(name);	 
//	 }	
//	 
//	 @RequestMapping(value="/get/allTimesheet/{name}",method = RequestMethod.GET,headers="Accept=application/json")
//	 public List<EmployeeTimeSheet> getAllTimeSheet(@PathVariable("name") String name) {
//		return service.gettimeSheet(name);	 
//	 }	

}
