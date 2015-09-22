package com.programmingfree.dao;

import com.programmingfree.springservice.domain.Person;

public interface PersonDAO {

	public void create(Person p);
	
	public Person readById(String id);
	
	public void update(Person p);
	
	public int deleteById(String id);
}
