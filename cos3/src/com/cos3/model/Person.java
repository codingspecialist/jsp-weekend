package com.cos3.model;

public class Person {

	private int id;
	private String pw;
	private String name;
	
	public Person(int id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
