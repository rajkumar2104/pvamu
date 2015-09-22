package com.programmingfree.springservice;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import com.programmingfree.dao.PodsAddressDAO;
import com.programmingfree.dao.PodsAddressDAOImpl;
import com.programmingfree.springservice.domain.PodsAddress;
import com.programmingfree.springservice.utility.DBUtility;

public class AddressServiceImpl implements AddressService {

	private MongoOperations connection = DBUtility.getConnection();
	private PodsAddressDAO personDao = new PodsAddressDAOImpl(connection);

	@Override
	public List<PodsAddress> getAllData() {
		return personDao.getAllData();
	}

	@Override
	public PodsAddress getAddressById(String id) {
		return personDao.getAddressById(id);
	}

	@Override
	public List<PodsAddress> getAddressByState(String state) {
		return personDao.getAddressByState(state);
	}

	@Override
	public void insert(List<PodsAddress> address) {
		personDao.insert(address);

	}

}
