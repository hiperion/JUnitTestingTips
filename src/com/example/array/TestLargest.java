package com.example.array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

public class TestLargest {

	@Rule
	public TestWatchman watchman = new TestWatchman() {
		public void starting(FrameworkMethod method) {
			log.info("Being run..." + method.getName());
		}
	};

	private static Logger log = Logger.getLogger(TestLargest.class);

	@Test
	public void testOrder1() {
		assertEquals(9, Largest.largest(new int[] { 8, 9, 7 }));
	}

	@Test
	public void testOrder2() {
		int[] arr = new int[3];
		arr[0] = 8;
		arr[1] = 9;
		arr[2] = 7;
		assertEquals(9, Largest.largest(arr));
	}
	
	@Test
	public void listEquality() {
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(5);

		List<Integer> actual = new ArrayList<Integer>();
		actual.add(5);

		assertEquals(expected, actual);
	}


}
