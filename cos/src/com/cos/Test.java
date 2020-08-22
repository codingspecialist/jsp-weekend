package com.cos;

public class Test<T> {
	
	T data;
	
	public T getData() {
		return data;
	}
	
	public static void main(String[] args) {
		Test<Integer> t = new Test();
		int num = t.getData();
		System.out.println(num);
	}
}
