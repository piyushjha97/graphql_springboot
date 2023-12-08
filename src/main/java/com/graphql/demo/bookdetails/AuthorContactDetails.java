package com.graphql.demo.bookdetails;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AuthorContactDetails {
    private String id;
    private String email;
    private String mobile;
    private String address;

    public AuthorContactDetails(String id, String email, String mobile) {
        this.id = id;
        this.email = email;
        this.mobile = mobile;
    }
    
    private static List<AuthorContactDetails> temp = Arrays.asList(
    		new AuthorContactDetails("contact-1", "joanne@gmail.com", "9999999999"),
            new AuthorContactDetails("contact-2", "herman#yahoo.com", "8888888888"),
            new AuthorContactDetails("contact-3", "anne@hotmail.com", "7777777777"));
    

    private static List<AuthorContactDetails> contacts = new ArrayList<AuthorContactDetails>(temp);

    public static AuthorContactDetails getContactDetailsById(String id) {
    	
    	for(AuthorContactDetails contact: contacts) {
    		if(contact.getContactId().equals(id)) return contact;
    	}
    	return null;
        //return contacts.stream().filter(author -> author.getContactId().equals(id)).findFirst().orElse(null);
    }

    public String getContactId() {
        return id;
    }
    
    public static void addAuthorContactDetails(String contactId) {
    	AuthorContactDetails newAuthorContactDetails = new AuthorContactDetails(contactId, "ncvij@gmail.com", "6666666666");
    	contacts.add(newAuthorContactDetails);
    }
}