package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.Post;

public class PostDao {
	
	private static PostDao instance = new PostDao();
	public static PostDao getInstance() {
		return instance;
	}
	
	private PostDao() {}
	
	public int 글수정하기(Post post) {
		String sql = "UPDATE post SET title = ?, content = ? WHERE id = ?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3, post.getId());
			return pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int 삭제하기(int id) {
		String sql = "DELETE FROM post WHERE id = ?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int 조회수증가(int id) {
		String sql = "UPDATE post SET readCount = readCount+1 WHERE id = ?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Post 상세보기(int id){

		String sql = "SELECT * FROM post WHERE id = ?";
		Connection conn = DBConn.getInstance();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Post postEntity = Post.builder()
						.id(rs.getInt("id"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getTimestamp("createDate"))
						.userId(rs.getInt("userId"))
						.build();
				
				return postEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Post> 글목록(int page){
		List<Post> posts = new ArrayList<>();
		
		String sql = "SELECT * FROM post ORDER BY id DESC limit ?, 3";
		Connection conn = DBConn.getInstance();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Post postEntity = Post.builder()
						.id(rs.getInt("id"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getTimestamp("createDate"))
						.userId(rs.getInt("userId"))
						.build();
				posts.add(postEntity);
			}
			return posts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int 글쓰기(Post post) {
		String sql = "INSERT INTO post(title, content, readCount, userId, createDate) "
				+ "VALUES(?,?,?,?, now())";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3, post.getReadCount());
			pstmt.setInt(4, post.getUserId());
			return pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
