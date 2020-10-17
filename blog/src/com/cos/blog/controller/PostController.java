package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.action.post.PostDeleteProcAction;
import com.cos.blog.action.post.PostDetailAction;
import com.cos.blog.action.post.PostListAction;
import com.cos.blog.action.post.PostSaveFormAction;
import com.cos.blog.action.post.PostSaveProcAction;
import com.cos.blog.action.post.PostUpdateFormAction;
import com.cos.blog.action.post.PostUpdateProcAction;

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
		System.out.println("cmd : " + cmd);
		
		Action action = route(cmd);
		if(action != null) action.execute(request, response);
	}

	private Action route(String cmd) {
		if(cmd.equals("list")) {
			return new PostListAction();
		}else if (cmd.equals("saveForm")) {
			return new PostSaveFormAction();
		} else if (cmd.equals("saveProc")) {
			return new PostSaveProcAction();
		} else if (cmd.equals("detail")) {
			return new PostDetailAction();
		} else if (cmd.equals("deleteProc")) {
			return new PostDeleteProcAction();
		} else if (cmd.equals("updateForm")) {
			return new PostUpdateFormAction();
		} else if (cmd.equals("updateProc")) {
			return new PostUpdateProcAction();
		} 
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	
}
