package com.kodkata.kata.algo.insertionsort.orig;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class InsertionSortTest {

	private InsertionSorter sorter = new InsertionSorter();
	private int[] input;
	private int[] output;

	private static int[] list(Integer... integers) {
		int[] list = new int[integers.length];
		for (int i = 0; i < integers.length; i++) {
			list[i] = integers[i].intValue();
		}
		return list;
	}
	

	public InsertionSortTest(int[] input, int[] output) {
		super();
		this.input = input;
		this.output = output;
	}


	@Test
	public void 
	sort_as_expected() throws Exception {
		assertThat(sorter.sort(input), is(equalTo(output)));
	}

	@Parameters
	public static Collection<Object[]> testData() throws Exception {
		return asList(new Object[][] { 
				{list(), list()}, 
				{list(1), list(1)}, 
				{list(2,1), list(1,2)}, 
				{list(2, 3, 1), list(1,2,3)}, 
				{list(9,8,7,6,5,4,3,2,1,0), list(0,1,2,3,4,5,6,7,8,9)}, 
				
		
		});
	}
}
