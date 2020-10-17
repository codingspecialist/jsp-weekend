package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserLoginProcAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("UserLoginProcAction : "+request.getParameter("remember"));
		
		User user = User.builder()
				.username(request.getParameter("username"))
				.password(request.getParameter("password"))
				.build();

		System.out.println(user);
		UserDao userDao = UserDao.getInstance();
		User userEntity = userDao.로그인(user);
		if(userEntity != null) {
			
			if(request.getParameter("remember") != null) {
//				Cookie cookie = new Cookie("remember", userEntity.getUsername());
//				response.addCookie(cookie);
				response.setHeader("Set-Cookie", "remember="+userEntity.getUsername());
			}else {
				Cookie cookie = new Cookie("remember", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			 
			HttpSession session = request.getSession();
			session.setAttribute("principal", userEntity);
			System.out.println("로그인 정상적으로 진행됨.");
			response.sendRedirect("/index.jsp");
		}
		// 1. 로그인 진행 (select) Model로 이동
		// 2. 세션에 저장
		// 3. 메인 페이지로 이동 Redirect
	}
}
