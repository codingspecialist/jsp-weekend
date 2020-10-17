package com.cos.blog.model;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {
	private int id;
	private String title;
	private String content;
	private int readCount; // 조회수
	private Timestamp createDate; // 인서트 된 시간
	private int userId;
}
