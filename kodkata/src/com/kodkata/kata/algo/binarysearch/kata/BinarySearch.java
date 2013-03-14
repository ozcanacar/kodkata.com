package com.kodkata.kata.algo.binarysearch.kata;

public class BinarySearch {

	protected static final int NOTHING_FOUND = -1;

	public static int findIndex(int key, int[] list) {
		
		int low =0;
		int high = list.length-1;
		
		while (low <= high)
		{
			int mid = (low+high) >>> 1;
			int midValue = list[mid];
			if(midValue < key)
			{
				low = mid+1;
			}
			else if(midValue > key)
			{
				high = mid-1;
			}
			else return mid;
		}
		
		return NOTHING_FOUND;
	}
	
	// EOF (End Of Fun)
	//Özcan Acar
	// KodKata.com
	//KurumsalJava.com

}
