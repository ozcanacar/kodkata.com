package com.kodkata.kata.factorial;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FactorialTest {

	private Factorial factorial = new Factorial();
	private int given;
	private int expected;

	public FactorialTest(int given, int expected) {
		super();
		this.given = given;
		this.expected = expected;
	}

	@Test
	public void 
	factial_of_x_is_y() {
		int fact = factorial.fact(given);
		System.err.println(fact);
		assertThat(fact, is(expected));
		
	}

	@Parameters
	public static Collection<Object[]> testData() throws Exception {
		return asList(new Object[][] { 
				{ 1, 1 }, 
				{ 2, 2 }, 
				{ 3, 6 }, 
				{ 4, 24 }, }
		);
	}
}