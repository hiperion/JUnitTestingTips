package com.example.basic;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestSample extends TestCase {

  public TestSample(String name) {
    super(name);
  }

  public void setUp() {
  }

  public void tearDown() {
  }

  public void testMe() {
    assertTrue(true);
  }

  public static Test suite() {
    return new TestSuite(TestSample.class);
  }

  public static void main(String[] args) {
    TestFinder.run(TestSample.class, args);
  }

}