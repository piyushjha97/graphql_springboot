package com.graphql.query;

import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
	
	Query () {
		System.out.println("project inside Query class constructor");
	}
	
	public String firstQuery() {
			return "first graphql query";
	}

}
