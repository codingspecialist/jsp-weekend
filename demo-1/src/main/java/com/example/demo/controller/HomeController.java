package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;

@Controller
public class HomeController {
	
	@GetMapping("/test")
	public @ResponseBody String test() {
		return "ok";
	}
	
	
	// http://localhost:8080/home
	@GetMapping("/home")
	public String home(String name, String addr) {
		System.out.println(name);
		System.out.println(addr);
		return "home";
	}
	
	// [GET] http://localhost:8080/post
	@GetMapping("/post")
	public String post() {
		return "post";
	}
	
	// [GET] http://localhost:8080/user
	@GetMapping("/user")
	public String user(User user, Model model) {
		System.out.println(user.getName()); 
		System.out.println(user.getAddr());
		model.addAttribute("user", user);
		return "user";
	}
}





