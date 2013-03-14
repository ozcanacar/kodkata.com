package com.kodkata.kata.algo.binarysearch.kata;

import static com.kodkata.kata.algo.binarysearch.kata.BinarySearch.NOTHING_FOUND;
import static com.kodkata.kata.algo.binarysearch.kata.BinarySearch.findIndex;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void finds_nothing_in_an_empty_array() throws Exception {
		assertThat(findIndex(1, toList()), equalTo(NOTHING_FOUND));
	}
	
	@Test public void 
	number_not_in_array_returns_minus_1() throws Exception {
		assertThat(findIndex(4, toList(1,2,3)), equalTo(NOTHING_FOUND));		
	}
	
	@Test public void 
	returns_last_elements_index() throws Exception {
		assertThat(findIndex(3, toList(1,2,3)), equalTo(2));				
	}
	
	@Test public void 
	retuns_first_elements_index() throws Exception {
		assertThat(findIndex(1, toList(1,2,3)), equalTo(0));				
	}

	private int[] toList(Integer... integers) {
		int list[] = new int[integers.length];
		for (int i = 0; i < integers.length; i++) {
			list[i] = integers[i];
		}
		return list;
	}

}
