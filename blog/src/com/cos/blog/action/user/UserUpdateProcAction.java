package com.cos.blog.action.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserUpdateProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 1. 세션 확인
		if(session.getAttribute("principal") == null) {
			return;
		}
		
		// 2. 공백, null 확인
//		if(request.getParameter("id") == null || request.getParameter("id").equals("")) {
//			return;
//		}
		
		// 3. 데이터 검증 숫자 검증 
	
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		System.out.println("id : "+id);
		System.out.println("username : "+username);
		System.out.println("password : "+password);
		System.out.println("email : "+email);
		System.out.println("address : "+address);
		
		User user = User.builder()
				.id(id)
				.username(username)
				.password(password)
				.email(email)
				.address(address)
				//.createDate(null)
				.build();
		
		UserDao userDao = UserDao.getInstance();
		int result = userDao.회원수정(user);
		
		if(result == 1) {
			session.setAttribute("principal", user);
		}
		
		response.sendRedirect("index.jsp");
		
//		BufferedReader br = request.getReader();
//
//		StringBuilder sb = new StringBuilder();
//		
//		String input = "";
//		
//		while((input = br.readLine()) != null) {
//			sb.append(input); 
//		}
//		
//		System.out.println(sb.toString());
	}

}
