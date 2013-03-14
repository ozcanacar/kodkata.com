package com.kodkata.kata.algo.unionfind.orig;

public class QUKata {

	public int[] id;

	public QUKata(final int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public void union(final int p, final int q) {
		final int idP = find(p);
		final int idQ = find(q);

		if (idP == idQ) {
			return;
		}

		id[p] = idQ;
	}

	private int find(int i) {

		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}

}
