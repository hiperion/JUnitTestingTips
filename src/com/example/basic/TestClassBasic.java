package com.example.basic;

import junit.framework.TestCase;

public class TestClassBasic extends TestCase {
	public TestClassBasic(String name) {
		super(name);
	}

	public void testBasic() {

		assertEquals("Should be 3 1/3", 3.33, 10.0 / 3.0, 0.01);
		assertNull("it should be null", null);
		assertSame("should be same", "expected", "actual");
		assertNotSame("should be same", "expected", "actual");
		assertTrue("should be same", true);
		assertFalse("should be same", true);

	}

}
