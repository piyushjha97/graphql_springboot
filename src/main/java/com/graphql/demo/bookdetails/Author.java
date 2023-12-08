package com.graphql.demo.bookdetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Author {
    private String id;
    private String firstName;
    private String lastName;
    private String contactId;
    private int age;

   
    public Author(String id, String firstName, String lastName, String contactId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactId = contactId;
    }
    
    private static List<Author> temp = Arrays.asList( new Author("author-1", "Joanne", "Rowling", "contact-1"),
            new Author("author-2", "Herman", "Melville", "contact-2"),
            new Author("author-3", "Anne", "Rice", "contact-3"));

    private static ArrayList<Author> authors = new ArrayList<Author>(temp);

    public static Author getAutherById(String id) {
    	for(Author author:authors) {
			if(author.getAuthorId().equals(id)) return author;
		}
		return null;
        //return authors.stream().filter(author -> author.getAutherId().equals(id)).findFirst().orElse(null);
    }

    public String getAuthorId() {
        return id;
    }

    public String getContactId() {
        return contactId;
    }
    
    public static void addAuthor(String authorId) {
    	Author newAuthor = new Author(authorId, "N C", "Vij", "contact-4");
    	AuthorContactDetails.addAuthorContactDetails(newAuthor.getContactId());
    	authors.add(newAuthor);
    }
}