package com.kodkata.kata.roman.kata;

import java.util.*;

public class TestRec {
	
	public static void main(String[] args) {
		
		recursion(Arrays.asList(1,2,3,4,5,6,7,8));
	}

	private static void recursion(List<Integer> asList) {
		
		try {
			execute(asList);
		} catch (Exception e) {
			execute(asList.subList(1,asList.size()));
		}
	}

	private static void execute(List<Integer> asList) {
		if(asList.size() > 0 && asList.get(0) == 1)
		{
			throw new RuntimeException();
		}
		else if(asList.size() > 0)
		{
			System.out.println(asList.get(0));
		}
		else
		{
			System.out.println("End");
		}
		
	}

}
