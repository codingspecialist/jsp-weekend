package com.cos;

import java.util.Random;

public class RandomNumber {

	public static int getNum() {
		Random r = new Random();
		return r.nextInt(100);
	}
}
