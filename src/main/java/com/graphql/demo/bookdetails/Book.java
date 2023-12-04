package com.graphql.demo.bookdetails;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;



import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Book {
	
	private String id;
	private String name;
	private String authorId;
	private int pageCount;
	private Date releaseDate;
	
	
	
	public Book(String id, String name, int pageCount, String authorId) {
		log.info("constructor called for: "+ id);
		System.out.println("Book class");
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }
	
	private static List<Book> books =  Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            new Book("book-2", "Moby Dick", 635, "author-2"),
            new Book("book-3", "Interview with the vampire", 371, "author-3"));
	
	public String getBookId() {
		return this.id;
	}
	
	public static Book getBookById(String id) {
		
		for(Book book:books) {
			if(book.getBookId().equals(id)) return book;
		}
		return null;
	}
	
	public  String getAuthorId() {
		return authorId;
	}

}
