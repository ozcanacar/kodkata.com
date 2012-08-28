package com.kodkata.kata.roman.orig;

import static org.junit.Assert.fail;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Assert;
import org.junit.Test;

import com.kodkata.kata.roman.orig.RomanNumeral.UnknownRoman;

public class RomanNumeralErrorTest {
	private RomanNumeral roman = new RomanNumeral();

	@Test
	public void fails_to_convert_unknown_numeral() throws Exception {
		try {
			roman.convert("Z");
			fail("should fail to convert numaral Z");
		} catch (UnknownRoman e) {
			Assert.assertThat(e.getMessage(), containsString("Z"));
		}

	}
}
