package com.yxy.startup.javaspringmybatisredis.domain;

public class Author {

	public Author() {
		super();
	}

	public Author(String name, Integer age, String intro) {
		super();
		this.name = name;
		this.age = age;
		this.intro = intro;
	}

	private String name;
	
	private Integer age;
	
	private String intro;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
}
