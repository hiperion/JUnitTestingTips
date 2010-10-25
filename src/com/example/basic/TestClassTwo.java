package com.example.basic;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestClassTwo extends TestCase {

  public TestClassTwo(String method) {
    super(method);
  }

   public void testLongRunner() {
    assertEquals(2300, 50);
  }

  public void testShortTest() {
    assertEquals(140, 5);
  }

  public void testAnotherShortTest() {
    assertEquals(586, 10);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    // Only include short tests
    suite.addTest(new TestClassTwo("testShortTest"));
    suite.addTest(new TestClassTwo("testAnotherShortTest"));

    TestSetup wrapper = new TestSetup(suite) {
      protected void setUp() {
        oneTimeSetUp();
      }

      protected void tearDown() {
        oneTimeTearDown();
      }
    };
    return wrapper;
  }

  public static void oneTimeSetUp() {
  }

  public static void oneTimeTearDown() {
  }
}