package com.example.product;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(CreditCardTestSuite.class);
		suite.addTestSuite(ShoppingCartTest.class);
		//$JUnit-END$
		return suite;
	}

}
