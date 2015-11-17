package com.pvamu.timesheet.dao;

import java.util.List;

import com.pvamu.timesheet.domain.Vendor;

public interface VendorDAO {
	Vendor save(Vendor req);
	List<Vendor> getAllVendor();
}
