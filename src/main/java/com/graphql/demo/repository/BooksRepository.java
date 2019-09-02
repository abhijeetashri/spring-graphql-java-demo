package com.graphql.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.graphql.demo.model.Book;

@Repository
public class BooksRepository {

	private List<Book> books = new ArrayList<>();

	@PostConstruct
	public void initializeData() {
		Book b1 = new Book();
		b1.setTitle("Harry Potter and the Sorcerer's stone");
		b1.setPrice("1000");
		b1.setAuthor("J.K. Rowling");
		b1.setIsbn("1234567890");
		books.add(b1);

		Book b2 = new Book();
		b2.setTitle("Harry Potter and the Chamber of Secrets");
		b2.setPrice("1000");
		b2.setAuthor("J.K. Rowling");
		b2.setIsbn("1234098756");
		books.add(b2);

		Book b3 = new Book();
		b3.setTitle("Harry Potter and the Prisoner of Azkaban");
		b3.setPrice("1000");
		b3.setAuthor("J.K. Rowling");
		b3.setIsbn("9870123456");
		books.add(b3);

		Book b4 = new Book();
		b4.setTitle("Lord of the Rings");
		b4.setPrice("1500");
		b4.setAuthor("J.R.R. Tolkein");
		b4.setIsbn("5678123490");
		books.add(b4);
	}

	public List<Book> findAll() {
		return this.books;
	}

	public List<Book> findBooksWithPriceLessThanEqualTo(String price) {
		List<Book> allBooks = this.books;
		return allBooks.stream().filter(b -> b.getPrice().equals(price)).collect(Collectors.toList());
	}

	public Book addBook(String title, String price, String author, String isbn) {
		Book newBook = new Book(title, price, author, isbn);
		this.books.add(newBook);
		return newBook;
	}

	public Book updateBook(String title, String price, String author, String isbn) {
		List<Book> allBooks = this.books;
		Optional<Book> bookToUpdate = allBooks.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
		if(bookToUpdate.isPresent()) {
			Book book = bookToUpdate.get();
			book.setAuthor(author);
			book.setPrice(price);
			book.setTitle(title);
			book.setIsbn(isbn);
			return book;
		}
		return null;
	}

	public Book deleteBook(String isbn) {
		List<Book> allBooks = this.books;
		Optional<Book> bookToUpdate = allBooks.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
		if(bookToUpdate.isPresent()) {
			System.out.println("Book removed");
		}
		return null;
	}
}
