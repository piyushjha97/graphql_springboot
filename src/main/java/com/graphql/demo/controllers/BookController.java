package com.graphql.demo.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphql.demo.bookdetails.Book;
import com.graphql.demo.bookdetails.Author;
import com.graphql.demo.bookdetails.AuthorContactDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {
	
	@QueryMapping
	public Book bookById(@Argument String id) {
		log.info("Querying database to get the book by its id: "+ id);
		return Book.getBookById(id);
	}
	
	
	@MutationMapping
	public Book addBook(@Argument String name, @Argument int pageCount) {
		Book newBook = new Book("book-4", name,pageCount, "author-4");
		Book.storeBook(newBook);
		return newBook;
	}
	
	@SchemaMapping
	public Author author(Book book) {
		log.info("making a query to Author data base for getting relevent Author based on the book id passed by the client");
		return Author.getAutherById(book.getAuthorId());
	}
	
	@SchemaMapping
	public AuthorContactDetails AuthorContactDetails(Book book) {
		log.info("making a query to the authordetails database to get the authordetails for a particular author in order to match the schema defined");
		Author temp = Author.getAutherById(book.getAuthorId());
		return AuthorContactDetails.getContactDetailsById(temp.getContactId());
		
	}

}
