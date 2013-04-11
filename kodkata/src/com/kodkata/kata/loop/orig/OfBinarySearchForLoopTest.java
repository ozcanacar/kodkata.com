package com.kodkata.kata.loop.orig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class OfBinarySearchForLoopTest {

	@Test
	public void find_element_in_list_without_for_loop() {

		final List<String> list = new ArrayList<String>();

		for (int i = 0; i < 2999999; i++) {
			list.add("" + i + 1);

		}
		Collections.sort(list);

		class Finder {

			public String find(final List<String> list, final String key) {

				final long begin = System.currentTimeMillis();

				for (final String string : list) {

					if (key.equals(string)) {
						final long end = System.currentTimeMillis();
						System.out.println((end - begin));
						return key;
					}
				}

				final long end = System.currentTimeMillis();
				System.out.println((end - begin));
				return "";

			}
		}
		final Finder finder = new Finder();
		// assertThat(finder.find(list, "KJY"), equalTo("KJY"));

		finder.find(list, "111111111111111111");
	}
}
