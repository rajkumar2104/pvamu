package com.programmingfree.springservice.utility;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.programmingfree.springservice.domain.Person;

public class DBUtility {
	private static MongoOperations connection = null;

	public static final String DB_NAME = "hpInc";
	public static final String PERSON_COLLECTION = "users";
	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;

	public static MongoOperations getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
				MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
				Person p = new Person("113", "PankajKr", "Bangalore, India");
				mongoOps.insert(p, PERSON_COLLECTION);

				Person p1 = mongoOps.findOne(
						new Query(Criteria.where("name").is("PankajKr")),
						Person.class, PERSON_COLLECTION);

				System.out.println(p1);
				
				//mongoOps.dropCollection(PERSON_COLLECTION);
				//mongo.close();
				connection = mongoOps;
			 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}

	}

}