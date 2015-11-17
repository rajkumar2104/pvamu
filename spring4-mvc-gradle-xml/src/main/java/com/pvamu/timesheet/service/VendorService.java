package com.pvamu.timesheet.service;

import java.util.List;

import com.pvamu.timesheet.domain.Vendor;

public interface VendorService {
	
	Vendor save(Vendor req);
	List<Vendor> getAllVendor();

}
