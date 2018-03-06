package com.yxy.startup.javaspringmybatisredis.service.fetcher;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.yxy.startup.javaspringmybatisredis.domain.Author;
import com.yxy.startup.javaspringmybatisredis.domain.Book;

import graphql.schema.DataFetchingEnvironment;

@Repository
public class BookDataFetcher extends GraphqlDataFetcherAdapter<Book> {

	
	private static final Map<Integer,Book> bookStorage = new HashMap<>();
	
	@PostConstruct
	public void init(){
		bookStorage.put(1, new Book("ABCD1","JAVA解惑","一个牛人"));
		bookStorage.put(2, new Book("ABCD2","代码大全","什么什么出版社"));
		bookStorage.put(3, new Book("ABCD3","JAVA核心技术","Sun"));
		bookStorage.put(4, new Book("ABCD4","冰与火之歌","TOM"));
		bookStorage.put(5, new Book("ABCD5","盗墓笔记","南派三叔"));
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
