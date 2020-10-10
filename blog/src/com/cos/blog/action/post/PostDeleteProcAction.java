package com.cos.blog.action.post;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;

public class PostDeleteProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		// PostDao 연결
		PostDao postDao = new PostDao();
		int result = postDao.삭제하기(id);
		
		if(result == 1) {
			pw.print("ok");
		}else {
			pw.print("fail");
		}
		
		pw.flush();
	}
}




