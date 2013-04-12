package com.kodkata.kata.iterator.orig;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class IteratorTest {

	@Test
	public void test_iterator() {

		final List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");

		class IteratorImpl {

			List<String> list;

			public IteratorImpl(final List<String> s) {
				this.list = s;
			}

			public Iterator<String> iterator() {
				return new Iterator<String>() {

					int i;

					@Override
					public boolean hasNext() {
						return i < list.size() ? true : false;
					}

					@Override
					public String next() {
						return list.get(i++);
						// return hasNext() ? : "";
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		}

		final IteratorImpl impl = new IteratorImpl(list);

		final Iterator<String> iterator = impl.iterator();

		assertThat(iterator.next(), CoreMatchers.equalTo("A"));
		assertThat(iterator.next(), CoreMatchers.equalTo("B"));
		assertThat(iterator.next(), CoreMatchers.equalTo("C"));
		assertThat(iterator.next(), CoreMatchers.equalTo(""));

	}

}
