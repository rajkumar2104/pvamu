package com.pvamu.timesheet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pvamu.timesheet.domain.Person;
import com.pvamu.timesheet.domain.ProjectDeatil;
import com.pvamu.timesheet.service.UtilService;

@RestController
@EnableWebMvc
@RequestMapping("/util")
public class UtilController {
	@Autowired
	UtilService service ;
	
	 @RequestMapping(value="/person/registoration",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public Person savePerson(@RequestBody Person req) {
		return service.savePerson(req);	 
	 }
	 
	 @RequestMapping(value="/person/getPerson",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public Person getPerson(@RequestBody Person req) {
		return service.getPerson(req);	 
	 }
	 
	 @RequestMapping(value="/person/getAllPerson",method = RequestMethod.GET,headers="Accept=application/json")
	 @ResponseBody
	 public List<Person> getAllPerson() {
		return service.getAllPerson();	 
	 }
	 
	 @RequestMapping(value="/person/updatePerson",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public Person updatePerson(@RequestBody Person req) {
		return service.updatePerson(req);	 
	 }
	 
	 @RequestMapping(value="/person/updateStatus",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public Person updateStatus(@RequestBody Person req) {
		return service.updateStatus(req);	 
	 }
	
	 @RequestMapping(value="/project/registoration",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public ProjectDeatil save(@RequestBody ProjectDeatil req) {
		return service.saveProjectDetail(req);	 
	 }
	 
	 @RequestMapping(value="/project/getAllProjectDetail",method = RequestMethod.GET,headers="Accept=application/json")
	 @ResponseBody
	 public List<ProjectDeatil> getAllProjectDetail() {
		return service.getAllProjectDetail();	 
	 }

}
