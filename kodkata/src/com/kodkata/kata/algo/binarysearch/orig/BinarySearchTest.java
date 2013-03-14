package com.kodkata.kata.algo.binarysearch.orig;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void 
	finds_nothing_if_the_list_is_empty() throws Exception {
		assertThat(BinarySearch.findIndex(1, new int[] {}), is(equalTo(-1)));
	}

	@Test
	public void 
	finds_1_if_the_list_contains_only_1() throws Exception {
		assertThat(BinarySearch.findIndex(1, new int[] { 1 }), is(equalTo(0)));
	}
	
	@Test
	public void 
	number_not_in_array_returns_minus_1() throws Exception {
		assertThat(BinarySearch.findIndex(3, new int[] { 1,2 }), is(equalTo(-1)));
	}
	
	@Test
	public void 
	returns_last_element() throws Exception {
		assertThat(BinarySearch.findIndex(3, new int[] { 1,2,3 }), is(equalTo(2)));
	}
	
	@Test
	public void 
	returns_first_element() throws Exception {
		assertThat(BinarySearch.findIndex(1, new int[] { 1,2,3 }), is(equalTo(0)));
	}
	
	@Test
	public void 
	find_3_in_a_list_of_1_2_3_4() throws Exception {
		assertThat(BinarySearch.findIndex(3, new int[] { 1,2,3,4}), is(equalTo(2)));
	}

}
