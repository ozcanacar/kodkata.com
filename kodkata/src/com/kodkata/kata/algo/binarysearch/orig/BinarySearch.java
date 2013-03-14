package com.kodkata.kata.algo.binarysearch.orig;

public class BinarySearch {

	private static final int NOT_FOUND = -1;

	public static int findIndex(int key, int[] list) {
		
		int low = 0;
		int high = list.length-1;
		
		while(low <= high)
		{
			int mid = (low+high) >>> 1;
			int midValue =list[mid];
			
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
		
		return NOT_FOUND;
	}

	public static int findIndex2(int key,int[] list) {
		int low = 0;
		int high = list.length - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			long midVal = list[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

}
