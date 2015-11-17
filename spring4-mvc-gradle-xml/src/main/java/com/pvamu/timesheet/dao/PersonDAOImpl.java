package com.pvamu.timesheet.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.pvamu.timesheet.domain.Person;

@Repository("PersonDAO")
public class PersonDAOImpl implements PersonDAO {

	@Qualifier("mongoTemplate")
	@Autowired
	private MongoOperations mongoOps;
	private static final String PERSON_COLLECTION = "Person";
	
	

	@Override
	public Person getPerson(Person req) {
		Query query = new Query(Criteria.where("userName").is(req.getUserName()).and("password").is(req.getPassword()));
		return this.mongoOps.findOne(query, Person.class, PERSON_COLLECTION);
	}

	@Override
	public Person savePerson(Person req) {
		this.mongoOps.save(req, PERSON_COLLECTION);
		return req;
	}

	@Override
	public Person updatePerson(Person req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person updateStatus(Person req) {
		Query query = new Query(Criteria.where("userName").is(req.getUserName()));
		 Update update = new Update();
		 update.set("activeStatus", req.isActiveStatus());
		 return this.mongoOps.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Person.class);
		
	}

}
