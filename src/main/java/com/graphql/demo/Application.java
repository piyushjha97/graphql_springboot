package com.graphql.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.graphql.query")
public class Application {

	public static void main(String[] args) {
		System.out.println("before project started");
		SpringApplication.run(Application.class, args);
		System.out.println("project started");
	}
}
