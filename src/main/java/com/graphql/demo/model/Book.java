package com.graphql.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

	private String title;
	private String price;
	private String author;
	private String isbn;
}
