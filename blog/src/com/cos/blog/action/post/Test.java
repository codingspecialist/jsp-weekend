package com.cos.blog.action.post;

interface Call {
	public void start();
}

public class Test {
	
	void go(Call call) {
		call.start();
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.go(()-> {});
		
	}
}



