package com.graphql.demo.service.datafetcher;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.demo.model.Book;
import com.graphql.demo.repository.BooksRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetAllBookDataFetcher implements DataFetcher<List<Book>> {

	@Autowired
	private BooksRepository repository;

	@Override
	public List<Book> get(DataFetchingEnvironment environment) {
		if (environment.getArguments().isEmpty()) {
			return repository.findAll();
		} else if (environment.containsArgument("min")) {
			return repository.findBooksWithPriceLessThanEqualTo(environment.getArgument("min").toString());
		}
		return Collections.emptyList();
	}

}
