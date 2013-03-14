package com.kodkata.kata.algo.unionfind.orig;

public class WQUPCKata {

	public int[] id;
	public int[] size;

	public WQUPCKata(final int n) {
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

		if (size[p] < size[q]) {
			id[p] = idQ;
			size[q] += size[p];
		} else {
			id[q] = idP;
			size[p] += size[q];
		}
		
		for (int i = 0; i < id.length; i++) {
			System.out.print(" " + i);
			
		}
		System.out.println("");
		System.out.println("--------------------");
		for (int i = 0; i < id.length; i++) {
			System.out.print(" " + id[i]);
		}
		System.out.println("");
		System.out.println("");
	}

	private int find(int i) {
		while (id[i] != i) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
}
