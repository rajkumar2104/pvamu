package com.pvamu.timesheet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pvamu.timesheet.domain.EmployeeExpences;
import com.pvamu.timesheet.domain.EmployeeTimeSheet;
import com.pvamu.timesheet.service.EmployeeService;

@Controller
@EnableWebMvc
@RequestMapping("/employee")
public class EmployeeController {	
	
	@Autowired
	public EmployeeService service;	
	

	
	 @RequestMapping(value="/save/timesheet",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public EmployeeTimeSheet saveTimesheet(@RequestBody EmployeeTimeSheet req) {
		return service.savetimeSheet(req);	 
	 }
	 
	 @RequestMapping(value="/save/expences",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public EmployeeExpences saveExpences(@RequestBody EmployeeExpences req) {
		return service.saveExpences(req);	 
	 }	 
	 
//	 @RequestMapping(value="/get/allExpences/{name}",method = RequestMethod.GET,headers="Accept=application/json")
//	 public List<EmployeeExpences> getAllExpences(@PathVariable("name")  String name) {
//		return service.getExpences(name);	 
//	 }	
//	 
	 @RequestMapping(value="/get/allTimesheet",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public List<EmployeeTimeSheet> getAllTimeSheet(@RequestBody EmployeeTimeSheet req) {
		 return service.gettimeSheet(req);
	 }	
	 
	 @RequestMapping(value="/get/getHistory",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public List<EmployeeTimeSheet> getHistory(@RequestBody EmployeeTimeSheet req) {
		 return service.gettimeSheet(req);
	 }	

}
