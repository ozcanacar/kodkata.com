package com.kodkata.kata.roman.orig;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RomanNumeralTest {

	final RomanNumeral roman = new RomanNumeral();
	private String romanNumeral;
	private Integer expected;

	public RomanNumeralTest(String romanNumeral, Integer expected) {
		super();
		this.romanNumeral = romanNumeral;
		this.expected = expected;
	}

	@Test
	public void convert_as_expected() throws Exception {
		assertThat(roman.convert(romanNumeral), equalTo(expected));
	}

	@Parameters
	public static Collection<Object[]> testData() throws Exception {
		return asList(new Object[][]{{"I", 1}, {"V", 5}, {"X", 10}, {"L", 50},
				{"C", 100}, {"D", 500}, {"M", 1000}, {"VI", 6}, {"XXI", 21},
				{"MCMXCIX", 1999}

		});
	}

}
