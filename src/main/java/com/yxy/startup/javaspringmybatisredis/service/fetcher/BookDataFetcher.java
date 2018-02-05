package com.yxy.startup.javaspringmybatisredis.service.fetcher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.yxy.startup.javaspringmybatisredis.domain.Author;
import com.yxy.startup.javaspringmybatisredis.domain.Book;

import graphql.language.Field;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Repository
public class BookDataFetcher extends GraphqlDataFetcherAdapter<Book> {

	
	private static final Map<Integer,Book> bookStorage = new HashMap<>();
	
	@PostConstruct
	public void init(){
		bookStorage.put(1, new Book("ABCD1","Title1","Tommy"));
		bookStorage.put(2, new Book("ABCD2","Title2","JACK"));
		bookStorage.put(3, new Book("ABCD3","Title3","SDFmy"));
		bookStorage.put(4, new Book("ABCD4","Title4","TOM"));
		bookStorage.put(5, new Book("ABCD5","Title5","Late"));
		bookStorage.put(6, new Book("ABCD6","Title6","Kote"));
		bookStorage.put(7, new Book("ABCD7","Title7","uytt"));
	}
	
	
	@Override
	public Book get(DataFetchingEnvironment environment) {
		String id = environment.getArgument("id").toString();
		Book book = bookStorage.get(Integer.parseInt(id));
		
		//假定Author的非常影响性能，那么如果没有查询Author，就跳过Author的处理
		if(fieldIsSelected(environment,"author")){
			book.setAuthor(authorResolver());
		}
		
		//更多其他...
//		if(fieldIsSelected(environment,"author")){
//			book.setAuthor(authorResolver());
//		}
		
		return book;
	}


	private Author authorResolver() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Author("Yxy", 28, "Stupid Boy...");
	}
	
}
