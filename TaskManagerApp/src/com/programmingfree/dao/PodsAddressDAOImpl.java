package com.programmingfree.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.programmingfree.springservice.domain.PodsAddress;

public class PodsAddressDAOImpl implements PodsAddressDAO {

	private MongoOperations mongoOps;
	private static final String ADDRESS_COLLECTION = "address";
	
	public PodsAddressDAOImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}
	
	@Override
	public void insert(List<PodsAddress> address) {
		mongoOps.insert(address,ADDRESS_COLLECTION );

	}

	@Override
	public List<PodsAddress> getAllData() {		
		return mongoOps.findAll(PodsAddress.class,ADDRESS_COLLECTION);
	}

	@Override
	public PodsAddress getAddressById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoOps.findOne(query, PodsAddress.class, ADDRESS_COLLECTION);
	}

	@Override
	public List<PodsAddress> getAddressByState(String state) {
		Query query = new Query(Criteria.where("Location_state_cd").is(state));
		return mongoOps.find(query, PodsAddress.class);
	}

}
