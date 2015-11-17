package com.pvamu.timesheet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pvamu.timesheet.service.UtilService;
import com.pvamu.timesheet.service.UtilServiceImpl;
import com.pvamu.timesheet.domain.Person;

@RestController
@EnableWebMvc
@RequestMapping("/login")
public class LoginContoller {
	@Autowired
	UtilService service ;	
	
	
	 
	 @RequestMapping(value="/registoration",method = RequestMethod.POST,headers="Accept=application/json")
	 public Person registoration(@RequestBody Person req) {
		return null; //service.savetimeSheet(req);	 
	 }
	 
	 @RequestMapping(value="/activate",method = RequestMethod.POST,headers="Accept=application/json")
	 public Person activate(@RequestBody Person req) {
		return null; //service.savetimeSheet(req);	 
	 }
	
	
	
}
