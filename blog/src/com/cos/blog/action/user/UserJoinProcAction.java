package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserJoinProcAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("UserController : joinProc : ");
		
		User user = User.builder()
				.username(request.getParameter("username"))
				.password(request.getParameter("password"))
				.email(request.getParameter("email"))
				.address(request.getParameter("address"))
				.build();
	
		System.out.println(user.toString());
		// 1. 회원가입 진행 (insert) Model로 이동
		UserDao userDao = UserDao.getInstance();
		userDao.회원가입(user);
		
		// 2. 로그인 페이지로 이동 Redirect
		response.sendRedirect("/user/loginForm.jsp");
	}
}
