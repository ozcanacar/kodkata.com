package com.kodkata.kata.algo.insertionsort.orig;

public class InsertionSorter {

	public int[] sort(int[] is) {
		if (is == null)
			return is;

		for (int i = 1; i < is.length; i++) {
			int value = is[i];
			int j = i;

			while (j > 0 && is[j - 1] > value) {
				is[j] = is[j - 1];
				j--;
			}
			is[j] = value;
		}
		return is;
	}
}
