package com.cos.blog.action.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostUpdateFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션확인
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) return;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PostDao postDao = PostDao.getInstance();
		Post postEntity = postDao.상세보기(id);
		
		request.setAttribute("post", postEntity);
		
		RequestDispatcher dis
			 = request.getRequestDispatcher("post/updateForm.jsp");
		dis.forward(request, response);

	}
}



