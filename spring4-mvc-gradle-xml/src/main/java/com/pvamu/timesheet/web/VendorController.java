package com.pvamu.timesheet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pvamu.timesheet.domain.Vendor;
import com.pvamu.timesheet.service.VendorService;

@RestController
@EnableWebMvc
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	VendorService service  ;
	
	 @RequestMapping(value="/registoration",method = RequestMethod.POST,headers="Accept=application/json")
	 @ResponseBody
	 public Vendor save(@RequestBody Vendor req) {
		return service.save(req);	 
	 }
	 
	 @RequestMapping(value="/getAllVendor",method = RequestMethod.GET,headers="Accept=application/json")
	 @ResponseBody
	 public List<Vendor> getAllVendor() {
		return service.getAllVendor();	 
	 }
	
}
