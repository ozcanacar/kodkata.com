package com.kodkata.kata.algo.unionfind.orig;

public class WQUKata {

	public int[] id;
	public int[] size;

	public WQUKata(final int n) {
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	public void union(final int p, final int q) {
		final int idP = find(p);
		final int idQ = find(q);

		if (idP == idQ) {
			return;
		}

		if (size[p] <= size[q]) {
			id[p] = idQ;
			size[q] += size[p];
		} else {
			id[q] = idP;
			size[p] += size[q];
		}
	}

	private int find(int i) {

		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}
}
