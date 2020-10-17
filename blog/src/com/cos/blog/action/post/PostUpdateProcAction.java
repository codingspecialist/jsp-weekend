package com.cos.blog.action.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostUpdateProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션확인
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) return;
		
		// 2. 공백, null 확인
		
		// 3. 값 검증 ( title에 <  > 코드가 들어오는걸 방지 )
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		String content = request.getParameter("content");
		
		Post post = Post.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();
		
		PostDao postDao = PostDao.getInstance();
		postDao.글수정하기(post);
		
		response.sendRedirect("index.jsp");
	}
}



