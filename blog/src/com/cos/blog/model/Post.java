package com.cos.blog.model;

import java.sql.Timestamp;

public class Post {
	private int id;
	private String title;
	private String content;
	private int readCount; // 조회수
	private Timestamp createDate; // 인서트 된 시간
	
	private int userId;

	public Post(int id, String title, String content, int readCount, Timestamp createDate, int userId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.createDate = createDate;
		this.userId = userId;
	}
	
	public Post(String title, String content, int readCount, int userId) {
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.userId = userId;
	}

	public Post(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
