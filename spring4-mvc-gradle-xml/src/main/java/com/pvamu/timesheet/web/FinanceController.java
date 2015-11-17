package com.pvamu.timesheet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pvamu.timesheet.service.FinanceService;

@RestController
@EnableWebMvc
@RequestMapping("/finance")
public class FinanceController {
	@Autowired
	public  FinanceService service  ;
	
//	@Autowired
//	public FinanceController(FinanceService service){
//		this.service = service;
//	}

}
