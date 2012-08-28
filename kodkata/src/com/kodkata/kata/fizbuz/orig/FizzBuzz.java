package com.kodkata.kata.fizbuz.orig;

public class FizzBuzz {

	protected static final String NO_DATA = "";
	protected static final String FIZZ = "fizz";
	protected static final String BUZZ = "buzz";

	public String classify(int number) {
		String result ="";
		if(0 == number % 3) result+= FIZZ;
		if(0 == number % 5) result+= BUZZ;
		return result.isEmpty() ? ""+number : result;
	}
	

}
