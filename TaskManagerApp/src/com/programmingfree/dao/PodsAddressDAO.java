package com.programmingfree.dao;

import java.util.List;

import com.programmingfree.springservice.domain.PodsAddress;

public interface PodsAddressDAO {	
	
	List<PodsAddress> getAllData();
	PodsAddress getAddressById(String id);
	List<PodsAddress> getAddressByState(String state);
	void insert(List<PodsAddress> address);
}
