package com.graphql.demo.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.demo.model.Book;
import com.graphql.demo.model.Person;
import com.graphql.demo.repository.BooksRepository;
import com.graphql.demo.repository.PersonRepository;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private PersonRepository personRepository;

	public List<Person> persons() {
		return personRepository.findAll();
	}

	public List<Book> books() {
		return booksRepository.findAll();
	}

	public List<Book> booksByMinimumPrice(Integer minPrice) {
		return booksRepository.findBooksWithPriceLessThanEqualTo(minPrice.toString());
	}
}
