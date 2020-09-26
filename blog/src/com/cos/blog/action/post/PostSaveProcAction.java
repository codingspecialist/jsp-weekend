package com.cos.blog.action.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostSaveProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션확인
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) return;
		
		// 2. 공백, null 확인
		
		// 3. 값 검증 ( title에 <  > 코드가 들어오는걸 방지 )
		String title = request.getParameter("title");
		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Post post = new Post(
				title,
				content,
				0,
				userId
		);
		
		PostDao postDao = new PostDao();
		postDao.글쓰기(post);
		
		response.sendRedirect("index.jsp");
	}
}



