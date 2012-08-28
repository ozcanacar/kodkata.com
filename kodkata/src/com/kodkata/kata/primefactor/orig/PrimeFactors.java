package com.kodkata.kata.primefactor.orig;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static List<Integer> generate(int i) {
		List<Integer> primes = new ArrayList<Integer>();

		for (int divisor = 2; i > 1; divisor++) {
			for (; i % divisor == 0; i /= divisor)
				primes.add(divisor);
		}
		return primes;
	}
}
