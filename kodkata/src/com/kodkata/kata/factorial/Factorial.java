package com.kodkata.kata.factorial;

public class Factorial {

	public int fact(int i) {

		if(i<=1) return 1;
		return i * fact(i - 1);
	}

}
