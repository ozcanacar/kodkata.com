package com.kodkata.kata.fizbuz.orig;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FizzBuzzTest {
	private FizzBuzz fizzbuzz = new FizzBuzz();

	@Test
	public void 
	classifies_divisible_3_as_fizz() throws Exception {
		assertEquals(FizzBuzz.FIZZ, fizzbuzz.classify(3));
		assertEquals(FizzBuzz.FIZZ, fizzbuzz.classify(6));
	}
	
	@Test
	public void 
	classifies_divisible_5_as_buzz() throws Exception {
		assertEquals(FizzBuzz.BUZZ, fizzbuzz.classify(5));
		assertEquals(FizzBuzz.BUZZ, fizzbuzz.classify(10));
		assertEquals(FizzBuzz.BUZZ, fizzbuzz.classify(20));
	}
	
	@Test
	public void 
	classifies_divisible_both_3_and_5_as_fizzbuzz() throws Exception {
		assertEquals(FizzBuzz.FIZZ+FizzBuzz.BUZZ, fizzbuzz.classify(15));
		assertEquals(FizzBuzz.FIZZ+FizzBuzz.BUZZ, fizzbuzz.classify(30));
		assertEquals(FizzBuzz.FIZZ+FizzBuzz.BUZZ, fizzbuzz.classify(45));
	}
	
	@Test
	public void 
	classifies_divisible_neither_3_nor_5_as_is() throws Exception {
		assertEquals("1", fizzbuzz.classify(1));
		
	}
	
	

}
