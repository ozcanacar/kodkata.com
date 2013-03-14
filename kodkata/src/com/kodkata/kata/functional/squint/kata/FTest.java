package com.kodkata.kata.functional.squint.kata;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class FTest {

	@Test
	public void check() throws Exception {

		assertThat(Arrays.asList(1, 4, 9, 16), CoreMatchers.equalTo(take(4, squareOf(integers()))));

	}

	private List<Integer> take(final int n, final Iterator<Integer> squareOf) {
		List<Integer> taken = new ArrayList<Integer>();
		for (int j = 0; j < n; j++) {
			taken.add(squareOf.next());
		}
		return taken;
	}

	private Iterator<Integer> squareOf(final Iterator<Integer> integers) {

		final Func<Integer> func = new Func<Integer>() {
			@Override
			public Integer f(final Integer t) {
				return t * t;
			}
		};

		return map(func, integers);
	}

	private Iterator<Integer> map(final Func<Integer> func, final Iterator<Integer> integers) {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return integers.hasNext();
			}

			@Override
			public Integer next() {
				return func.f(integers.next());
			}

			@Override
			public void remove() {
			}
		};
	}

	private Iterator<Integer> integers() {
		return new Iterator<Integer>() {

			int i=1;

			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public Integer next() {
				return i++;
			}

			@Override
			public void remove() {
			}
		};
	}

	public interface Func<T> {
		T f(T t);
	}
}
