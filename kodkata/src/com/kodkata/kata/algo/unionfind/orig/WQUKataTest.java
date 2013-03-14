package com.kodkata.kata.algo.unionfind.orig;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

public class WQUKataTest {

	@Test
	public void test_quick_union() {

		final WQUKata kata = new WQUKata(10);
		kata.union(3, 4);
		Assert.assertThat(kata.id, equalTo(new int[] { 0, 1, 2, 4, 4, 5, 6, 7, 8, 9 }));

		kata.union(4, 9);
		Assert.assertThat(kata.id, equalTo(new int[] { 0, 1, 2, 4, 4, 5, 6, 7, 8, 4 }));

		kata.union(8, 0);
		Assert.assertThat(kata.id, equalTo(new int[] { 0, 1, 2, 4, 4, 5, 6, 7, 0, 4 }));

		kata.union(2, 3);
		Assert.assertThat(kata.id, equalTo(new int[] { 0, 1, 4, 4, 4, 5, 6, 7, 0, 4 }));

		kata.union(5, 6);
		Assert.assertThat(kata.id, equalTo(new int[] { 0, 1, 4, 4, 4, 6, 6, 7, 0, 4 }));

		kata.union(5, 9);
		Assert.assertThat(kata.id, equalTo(new int[] { 0, 1, 4, 4, 4, 4, 6, 7, 0, 4 }));

		kata.union(7, 3);
		Assert.assertThat(kata.id, equalTo(new int[] { 0, 1, 4, 4, 4, 4, 6, 4, 0, 4 }));

		kata.union(4, 8);
		Assert.assertThat(kata.id, equalTo(new int[] { 0, 1, 4, 4, 4, 4, 6, 4, 4, 4 }));

		kata.union(6, 1);
		Assert.assertThat(kata.id, equalTo(new int[] { 0, 6, 4, 4, 4, 4, 6, 4, 4, 4 }));

	}
}