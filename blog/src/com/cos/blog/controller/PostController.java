package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.model.Post;

// http://localhost:8080/blog/fd/fdas/fads/fsad.do
// 모든 .do 요청은 FrontController를 탄다. 
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostController() {
        super();
    }

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/post 요청됨");
		String cmd = request.getParameter("cmd");
		if(cmd.equals("list")) {
			response.sendRedirect("/post/list.jsp");
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
}
