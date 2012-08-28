package com.kodkata.kata.primefactor.orig;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PrimeFactorTest {
	private int numeral;
	private List<Integer> list;

	private static List<Integer> list(Integer... integers) {
		return Arrays.asList(integers);
	}

	
	public PrimeFactorTest(List<Integer> list, int numeral) {
		super();
		this.numeral = numeral;
		this.list = list;
	}


	@Test
	public void generate_as_expected() throws Exception {
		assertEquals(list, PrimeFactors.generate(numeral));
	}

	@Parameters
	public static Collection<Object[]> testData() throws Exception {

		return asList(new Object[][] {
				{ list(), 1 },
				{ list(2), 2 },
				{ list(3), 3 },
				{ list(2,2), 4 },
				{ list(5), 5 },
				{ list(2,3), 6 },
				{ list(7), 7 },
				{ list(2,2,2), 8 },
				{ list(3,3), 9 },
				{ list(2,5), 10 },
				{ list(2,2,2,5,5), 200 },
				});
	}

}
