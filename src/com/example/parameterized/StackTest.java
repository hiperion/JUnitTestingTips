package com.example.parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class StackTest {
	Stack<Integer> stack;

	private int number;

	public StackTest(int number) {
		this.number = number;
	}

	@Parameters
	public static Collection data() {
		Object[][] data = new Object[][] { { 1 }, { 2 }, { 3 }, { 4 } };
		return Arrays.asList(data);
	}

	@Before
	public void noSetup() {
		stack = new Stack<Integer>();
	}

	@After
	public void noTearDown() {
		stack = null;
	}

	@Test
	public void pushTest() {
		stack.push(number);
		assertEquals((int)stack.peek(), number);

	}

	@Test
	public void popTest() {
	}

	@Test(expected = EmptyStackException.class)
	public void peekTest() {
		stack = new Stack<Integer>();
		stack.peek();
	}

	@Test
	public void emptyTest() {
		stack = new Stack<Integer>();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void searchTest() {
	}
}
