package com.kodkata.kata.algo.unionfind.orig;

public class QFKata {

	public int[] id;

	public QFKata(final int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public static void main(final String[] args) {

		final QFKata kata = new QFKata(10);
		kata.union(5, 6);

	}

	public void union(final int p, final int q) {
		final int idP = find(p);
		final int idQ = find(q);

		if (idP == idQ) {
			return;
		}

		for (int i = 0; i < id.length; i++) {
			if (id[i] == idP) {
				id[i] = idQ;
			}
		}
	}

	private int find(final int i) {
		return id[i];
	}
}
