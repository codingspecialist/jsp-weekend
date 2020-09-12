package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post")
@RestController
public class IndexController {
	
	@GetMapping("/list")
	public String test1() {
		return "리스트페이지";
	}
	
	@GetMapping("/detail")
	public String test2() {
		return "상세페이지";
	}
	
	@GetMapping("/saveForm")
	public String test3() {
		return "글쓰기페이지";
	}
	
	@GetMapping("/updateForm")
	public String test4() {
		return "수정페이지";
	}
}
