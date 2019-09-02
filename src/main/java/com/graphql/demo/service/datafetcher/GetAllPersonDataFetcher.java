package com.graphql.demo.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.demo.model.Person;
import com.graphql.demo.repository.PersonRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetAllPersonDataFetcher implements DataFetcher<List<Person>> {

	@Autowired
	private PersonRepository repository;

	@Override
	public List<Person> get(DataFetchingEnvironment environment) {
		return repository.findAll();
	}

}
