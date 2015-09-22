package com.programmingfree.springservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.programmingfree.springservice.TaskManagerService;
import com.programmingfree.springservice.TaskManagerServiceImpl;
import com.programmingfree.springservice.domain.Person;


@RestController
public class TaskManagerController {
	
	
	TaskManagerService taskmanagerservice = new TaskManagerServiceImpl();
	
	 @RequestMapping(value="/tasks",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<Person> getAllTasks() {	 
		
	  List<Person> tasks=  new ArrayList<Person>();
	  	Person task = new Person();
		 task.setName("Rajkumar");
		 task.setAddress("123456678990");		
		 tasks.add(task);
		 taskmanagerservice.addTask(task);	
		 
		 
		 
//		 RestTemplate restTemplate = new RestTemplate();
//		 ResponseEntity<String> response = restTemplate.getForEntity("https://data.sparkfun.com/streams/dZ4EVmE8yGCRGx5XRX1W.json", String.class);
//
//		 System.out.println(response);
//		 
	  return tasks;
	
	 }
	 
	 
	 @RequestMapping(value="/tasks/archive/{taskIds}",method = RequestMethod.POST,headers="Accept=application/json")
	 public Person archiveAllTasks(@PathVariable String taskIds) {	
		 Person task = new Person();
		 task.setName("Rajkumar");
		 task.setAddress("123232323");	
		 task.setId("134");
	
	  return  taskmanagerservice.updateTask(task);
	
	 }
	 
//	 @RequestMapping(value="/tasks/{taskId}/{taskStatus}",method = RequestMethod.POST,headers="Accept=application/json")
//	 public List<Task> changeTaskStatus(@PathVariable int taskId,@PathVariable String taskStatus) throws ParseException {	
//		// taskmanagerservice.changeTaskStatus(taskId,taskStatus);		 
//		 return null;//taskmanagerservice.getAllTasks();
//		 
//	 }
	 
//	 @RequestMapping(value="/tasks/insert/{taskName}/{taskDesc}/{taskPriority}/{taskStatus}",method = RequestMethod.POST,headers="Accept=application/json")
//	 public List<Task> addTask(@PathVariable String taskName,@PathVariable String taskDesc,@PathVariable String taskPriority,@PathVariable String taskStatus) throws ParseException {	
//		
//		return null;//taskmanagerservice.getAllTasks();
//		 
//	 }	 	 	 	 
}