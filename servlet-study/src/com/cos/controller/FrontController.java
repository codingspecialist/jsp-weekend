package com.cos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
    }

    // 데이터줘(SELECT) -> 어떤 데이터줘? (쿼리스트링 : ?키=값&키=값)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(uri.equals("/user.do")) {
			System.out.println("/user 접근");
			response.sendRedirect("user.jsp");
		}else if(uri.equals("/profile.do")) { // 회원정보 보고 싶어
			// DB에 연결해서 회원정보를  SELECT 하기
			//  JavaObject에 담기
			System.out.println("/profile 접근");
			response.sendRedirect("profile.jsp");
		}else if(uri.equals("/")) {
			System.out.println("/ 접근");
			response.sendRedirect("index.jsp");
		}else if(uri.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}

	// 데이터 줄께(INSERT, DELETE, UPDATE) -> 어떤 데이터 (Http Body - MIME타입)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
	}

}
