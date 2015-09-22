package com.programmingfree.springservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.programmingfree.springservice.AddressService;
import com.programmingfree.springservice.AddressServiceImpl;
import com.programmingfree.springservice.domain.PodsAddress;

@RestController
public class AddressController {
		
	 AddressService service = new AddressServiceImpl();	
	
	 @RequestMapping(value="/getAllAddress",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<PodsAddress> getAllAddress() {
		return service.getAllData();	 
	 }
	 

}
