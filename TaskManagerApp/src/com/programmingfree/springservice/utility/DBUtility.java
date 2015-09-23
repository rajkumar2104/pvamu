package com.programmingfree.springservice.utility;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.programmingfree.springservice.domain.Person;

public class DBUtility {
	private static MongoOperations connection = null;

	public static final String DB_NAME = "pvamu";
	public static final String PERSON_COLLECTION = "users";
	public static final String MONGO_HOST = "ds041643.mongolab.com";
	public static final int MONGO_PORT = 41643;
	private static MongoClient mongo = null;
	public static MongoOperations getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				
				//MongoCredential  uri = MongoCredential.createMongoCRCredential("root",DB_NAME,"admin".toCharArray());
				
				MongoClientURI uri = new MongoClientURI("mongodb://root:admin@ds041643.mongolab.com:41643/?authSource=pvamu");
				
				MongoClient mongo = new MongoClient(uri);
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
	
	public static void  CloseConnection() {
		mongo.close();
	}


}