package com.pvamu.timesheet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.pvamu.timesheet.domain.Vendor;
@Repository("VendorDAO")
public class VendorDAOImpl implements VendorDAO {
	@Qualifier("mongoTemplate")
	@Autowired
	private MongoOperations mongoOps;
	private static final String VENDOR_COLLECTION = "Vendor";
	
	@Override
	public Vendor save(Vendor req) {
		mongoOps.insert(req, VENDOR_COLLECTION);
		return req;
	}
	@Override
	public List<Vendor> getAllVendor() {		
		return mongoOps.findAll(Vendor.class);
	}
	
	
}
