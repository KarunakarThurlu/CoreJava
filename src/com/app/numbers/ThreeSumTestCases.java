package com.app.numbers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ThreeSumTestCases {

	 
	@Test
	public void testOne() {
		ThreeSum ts=new ThreeSum();
		int a[]= {-1,0,1,2,-1,-4};
		var l1=List.of(-1,-1,2);
		var l2=List.of(-1,0,1);
		List<List<Integer>> expeted=new ArrayList<>();
		expeted.add(l1);expeted.add(l2);
		List<List<Integer>> actual= ts.findThreeSum(a);
		assertEquals(expeted, actual);
	}
	@Test
	public void testTwo() {
		ThreeSum ts=new ThreeSum();
		int a[]= {};
		List<List<Integer>> expeted=new ArrayList<>();
		List<List<Integer>> actual= ts.findThreeSum(a);
		assertEquals(expeted, actual);
	}
	@Test
	public void testThree() {
		ThreeSum ts=new ThreeSum();
		int a[]= {0};
		List<List<Integer>> expeted=new ArrayList<>();
		List<List<Integer>> actual= ts.findThreeSum(a);
		assertEquals(expeted, actual);
	}

}
