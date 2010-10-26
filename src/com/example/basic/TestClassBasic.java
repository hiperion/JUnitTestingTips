package com.example.basic;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

import com.example.arithmetic.TestingTip1;

import junit.framework.TestCase;

public class TestClassBasic extends TestCase {

	@Rule
	public TestWatchman watchman = new TestWatchman() {
		public void starting(FrameworkMethod method) {
			log.info("Being run..." + method.getName());
		}
	};

	private static Logger log = Logger.getLogger(Class.class);

	public TestClassBasic(String name) {
		super(name);
	}

	public void testBasic() {

		assertEquals("Should be 3 1/3", 3.33, 10.0 / 3.0, 0.01);
		assertNull("it should be null", null);
		assertSame("should be same", "expected", "expected");
		assertNotSame("should be same", "expected", "actual");
		assertTrue("should be same", true);
		assertFalse("should be same", false);
		
		if (log.isDebugEnabled()) log.debug("My debug message ");

	}

}
