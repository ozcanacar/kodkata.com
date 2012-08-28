package com.kodkata.kata.roman.kata;

import org.hamcrest.*;
import org.junit.*;

import static org.junit.Assert.*;

public class RomanNumeralTest {

	@Test
	public void 
	convert_I_as_1() throws Exception {
		RomanNumeral roman = new RomanNumeral();
		assertThat(roman.convert("I"), CoreMatchers.is(CoreMatchers.equalTo(1)));
	}
}
