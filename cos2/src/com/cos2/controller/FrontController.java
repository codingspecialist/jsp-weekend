package com.cos2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		
		// 응답에 대한 한글 세팅
		response.setContentType("text/html; charset=utf-8");
		
		if(uri.equals("/main.do")) {
			System.out.println("GET: /main.do 요청");
			response.sendRedirect("main.jsp");
		}else if(uri.equals("/login.do")) {
			System.out.println("GET: /login.do 요청");
			response.sendRedirect("login.jsp");
		}else if(uri.equals("/join.do")) {
			System.out.println("GET: /join.do 요청");
			response.sendRedirect("join.jsp");
		}else if(uri.equals("/info.do")) {
			System.out.println("GET: /info.do 요청");
			if(session.getAttribute("auth") == null) {
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('인증되지 않은 사용자입니다');");
				out.print("history.back();");
				out.print("</script>");
			}else {
				response.sendRedirect("info.jsp");
			}
		}else if(uri.equals("/logout.do")) {
			System.out.println("GET: /logout.do 요청");
			session.invalidate();
			response.sendRedirect("/main.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		
		if(uri.equals("/loginProc.do")) {
			System.out.println("POST: /loginProc.do 요청");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			System.out.println("username : "+username);
			System.out.println("password : "+password);
			
			// 아이디:ssar, 비번:1234 일때만 session에 저장
			if(username.equals("ssar") && password.equals("1234")) {
				session.setAttribute("auth", true);
			}

			response.sendRedirect("main.jsp");
		}else if(uri.equals("/joinProc.do")) {
			System.out.println("POST: /joinProc.do 요청");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");

			System.out.println("username : "+username);
			System.out.println("password : "+password);
			System.out.println("email : "+email);
			
			// 회원가입이 되면 session 저장
			session.setAttribute("auth", true);
			response.sendRedirect("main.jsp");
		}
	}

}
