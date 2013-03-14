package com.kodkata.kata.algo.unionfind.orig;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class QUKataTest {

	@Test
	public void test_quick_union() {

		final QUKata kata = new QUKata(10);

		kata.union(3, 4);
		Assert.assertThat(kata.id, CoreMatchers.equalTo(new int[] { 0, 1, 2, 4, 4, 5, 6, 7, 8, 9 }));

		kata.union(4, 9);
		Assert.assertThat(kata.id, CoreMatchers.equalTo(new int[] { 0, 1, 2, 4, 9, 5, 6, 7, 8, 9 }));

		kata.union(8, 0);
		Assert.assertThat(kata.id, CoreMatchers.equalTo(new int[] { 0, 1, 2, 4, 9, 5, 6, 7, 0, 9 }));

		kata.union(2, 3);
		Assert.assertThat(kata.id, CoreMatchers.equalTo(new int[] { 0, 1, 9, 4, 9, 5, 6, 7, 0, 9 }));

		kata.union(5, 6);
		Assert.assertThat(kata.id, CoreMatchers.equalTo(new int[] { 0, 1, 9, 4, 9, 6, 6, 7, 0, 9 }));
	}

}