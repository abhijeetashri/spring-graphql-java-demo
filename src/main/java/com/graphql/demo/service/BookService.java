package com.graphql.demo.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.graphql.demo.service.datafetcher.GetAllBookDataFetcher;

import graphql.schema.idl.RuntimeWiring;

@Service
public class BookService extends AbstractService {

	@Value("classpath:book.graphql")
	private Resource resource;

	@Autowired
	private GetAllBookDataFetcher allBooksDataFetcher;

	@PostConstruct
	public void loadGraphQLSchema() throws IOException {
		buildSchema(resource);
	}

	@Override
	protected RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring().type("Query", typeWiring -> typeWiring
				.dataFetcher("books", allBooksDataFetcher).dataFetcher("booksByMinimumPrice", allBooksDataFetcher))
				.build();
	}
}
