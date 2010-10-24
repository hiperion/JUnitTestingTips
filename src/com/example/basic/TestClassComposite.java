package com.example.basic;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

class TestClassComposite extends TestCase {

  public TestClassComposite(String method) {
    super(method);
  }

  static public Test suite() {
    TestSuite suite = new TestSuite();
    // Grab everything:
    suite.addTestSuite(TestClassOne.class);
    // Use the suite method:
    suite.addTest(TestClassTwo.suite());
    return suite;
  }
}