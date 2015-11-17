package com.pvamu.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pvamu.timesheet.dao.UtilDAO;
import com.pvamu.timesheet.dao.VendorDAO;
import com.pvamu.timesheet.domain.Vendor;
@Component
public class VendorServiceImpl implements VendorService {

	
	@Autowired
	private VendorDAO dao;

	@Override
	public Vendor save(Vendor req) {
		return dao.save(req);
	}

	@Override
	public List<Vendor> getAllVendor() {
		
		return dao.getAllVendor();
	}
}
