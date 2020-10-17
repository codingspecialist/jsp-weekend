package com.cos.blog.action.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1번 id 값 받기 (null 인지 체크)
		int id = Integer.parseInt(request.getParameter("id"));
		
		// 2번 DAO 연결해서 Post postEntity = 상세보기(id) 함수 호출
		PostDao postDao = PostDao.getInstance();
		// 추가 : 조회수 증가
		int result = postDao.조회수증가(id);
		
		if(result == 1) {
			Post postEntity = postDao.상세보기(id);
			
			// 3번 request에 postEntity 담기
			request.setAttribute("post", postEntity);
			
			// 4번 detail.jsp 이동 => RequestDispatcher 사용하기
			RequestDispatcher dis = request.getRequestDispatcher("/post/detail.jsp");
			dis.forward(request, response);
		}else {
			response.sendRedirect("/");
		}

	}
}




