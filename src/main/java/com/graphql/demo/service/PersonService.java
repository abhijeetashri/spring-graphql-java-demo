package com.graphql.demo.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.graphql.demo.service.datafetcher.GetAllPersonDataFetcher;

import graphql.schema.idl.RuntimeWiring;

@Service
public class PersonService extends AbstractService {

	@Value("classpath:person.graphql")
	private Resource resource;

	@Autowired
	private GetAllPersonDataFetcher allPersonDataFetcher;

	@PostConstruct
	public void loadGraphQLSchema() throws IOException {
		buildSchema(resource);
	}

	protected RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring.dataFetcher("persons", allPersonDataFetcher)).build();
	}
}
