package com.yxy.startup.javaspringmybatisredis.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.yxy.startup.javaspringmybatisredis.domain.Author;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Repository
public class AuthorDataFetcher implements DataFetcher<Author> {

	
	private static final Map<Integer,Author> authorStorage = new HashMap<>();
	
	@PostConstruct
	public void init(){
		authorStorage.put(1, new Author("QQQQ",23,"HhhHA"));
		authorStorage.put(2, new Author("FDS",11,"JACK"));
	}
	
	
	@Override
	public Author get(DataFetchingEnvironment environment) {
		String id = environment.getArgument("id").toString();
		Author author = authorStorage.get(Integer.parseInt(id));
		return author;
	}
}
