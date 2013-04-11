package com.kodkata.kata.loop.orig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class BinarySearchForLoopTest {

	@Test
	public void find_element_in_list_without_for_loop() {

		final List<String> list = new ArrayList<String>();

		for (int i = 0; i < 2999999; i++) {
			list.add("" + i);

		}
		Collections.sort(list);

		class Finder {

			public String find(final List<String> list, final String key) {

				final long begin = System.currentTimeMillis();

				final int index = Collections.binarySearch(list, key, new Comparator<String>() {

					@Override
					public int compare(final String o1, final String o2) {
						return o1.compareTo(o2);
					}
				});

				final long end = System.currentTimeMillis();
				if (index >= 0) {

					System.out.println((end - begin));
					return list.get(index);
				}

				System.out.println((end - begin));
				return "";

			}
		}
		final Finder finder = new Finder();
		// assertThat(finder.find(list, "KJY"), equalTo("KJY"));

		finder.find(list, "9900eeeeeeee00");
	}
}
