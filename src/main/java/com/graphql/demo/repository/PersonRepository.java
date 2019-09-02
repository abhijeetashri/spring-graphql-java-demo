package com.graphql.demo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.graphql.demo.model.ContactNumber;
import com.graphql.demo.model.Person;

@Component
public class PersonRepository {

	private List<Person> persons = new ArrayList<>();

	@PostConstruct
	public void initializeData() {
		Person p1 = new Person();
		p1.setName("Infant");
		p1.setAge(1);
		persons.add(p1);

		Person p2 = new Person();
		ContactNumber c2 = new ContactNumber();
		c2.setHome("1234567890");
		c2.setMobile("9876054321");
		p2.setName("Adult");
		p2.setAge(35);
		p2.setContacts(c2);
		persons.add(p2);
	}

	public List<Person> findAll() {
		return this.persons;
	}
}
