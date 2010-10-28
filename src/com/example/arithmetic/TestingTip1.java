package com.example.arithmetic;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

import com.example.common.Principal;

public class TestingTip1 extends Principal {	

	// How do I test a method that returns an array?
	// assertEquals doesn't work for arrays. However, the Arrays class has a
	// static method Arrays.equals(oneArray, theOtherArray), for one-dimensional
	// arrays. For two-dimensional arrays or greater, use the method
	// Arrays.deepEquals(oneArray, theOtherArray).
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test1() throws Exception {
		try {
			// exam.setScore(-1);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void test2() throws Exception {

		int i = 0;
		assertTrue("It's equal 3", i != 3);

	}

	@After
	public void tearDown() throws Exception {
	}

}
