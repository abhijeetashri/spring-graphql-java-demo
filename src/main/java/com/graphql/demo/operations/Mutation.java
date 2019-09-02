package com.graphql.demo.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.demo.model.Book;
import com.graphql.demo.repository.BooksRepository;

@Component
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private BooksRepository bookRepository;

	public Book addBook(String title, String price, String author, String isbn) {
		return bookRepository.addBook(title, price, author, isbn);
	}
	
	public Book updateBook(String title, String price, String author, String isbn) {
		return bookRepository.updateBook(title, price, author, isbn);
	}
	
	public Book deleteBook(String isbn) {
		return bookRepository.deleteBook(isbn);
	}
}