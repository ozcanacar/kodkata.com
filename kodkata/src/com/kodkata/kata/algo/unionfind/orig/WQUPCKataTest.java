package com.kodkata.kata.algo.unionfind.orig;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;


public class WQUPCKataTest {
	
	@Test
	public void 
	test_quick_union(){
		 
		final WQUPCKata kata = new WQUPCKata(10);
		kata.union(4, 3);
		Assert.assertThat(kata.id, equalTo(new int[]{0,1,2,4,4,5,6,7,8,9}));
		
		kata.union(3, 8);
		Assert.assertThat(kata.id, equalTo(new int[]{0,1,2,4,4,5,6,7,4,9}));
		
		kata.union(6, 5);
		Assert.assertThat(kata.id, equalTo(new int[]{0,1,2,4,4,6,6,7,4,9}));
		
		kata.union(9, 4);
		Assert.assertThat(kata.id, equalTo(new int[]{0,1,2,4,4,6,6,7,4,4}));
		
		kata.union(8, 2);
		Assert.assertThat(kata.id, equalTo(new int[]{0,1,4,4,4,6,6,7,4,4}));	
	}
}


