package com.kodkata.kata.roman.orig;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

	private Map<String, Integer> digits = new HashMap<String, Integer>() {
		{
			put("I", new Integer(1));
			put("V", new Integer(5));
			put("X", new Integer(10));
			put("L", new Integer(50));
			put("C", new Integer(100));
			put("D", new Integer(500));
			put("M", new Integer(1000));

		}
	};

	public int convert(String roman) {

		Integer result = 0;
		String unparsedRoman = roman;

		while (unparsedRoman.length() > 1) {
			int current = toNumber(unparsedRoman.substring(0, 1));
			System.out.println(current);
			int next = toNumber(unparsedRoman.substring(1, 2));
			System.out.println(next);

			result += current < next ? -current : +current;
			unparsedRoman = unparsedRoman.substring(1);
		}

		return result += toNumber(unparsedRoman);
	}
	private int toNumber(String roman) {
		checkForUnknownRoman(roman);

		return digits.get(roman);
	}

	private void checkForUnknownRoman(String roman) {
		if (!digits.containsKey(roman)) {
			throw new UnknownRoman("roman " + roman + " is not known");
		}
	}

	public class UnknownRoman extends RuntimeException {
		public UnknownRoman(String s) {
			super(s);
		}
	}
}
