package com.yxy.startup.javaspringmybatisredis.domain;


public class Book {

	private String isn;
	
	private String title;
	
	private String publisher;
	
	private Author author;
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book() {
		super();
	}

	public Book(String isn, String title, String publisher) {
		super();
		this.isn = isn;
		this.title = title;
		this.publisher = publisher;
	}

	public String getIsn() {
		return isn;
	}

	public void setIsn(String isn) {
		this.isn = isn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
