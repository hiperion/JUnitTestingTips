package com.example.basic;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$		
		suite.addTestSuite(TestClassBasic.class);
		suite.addTest(TestClassTwo.suite());
		suite.addTestSuite(TestClassOne.class);
		suite.addTest(TestSample.suite());
		//$JUnit-END$
		return suite;
	}

}
