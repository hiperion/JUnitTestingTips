package com.example.array;

import junit.framework.TestCase;

public class TestLargest extends TestCase {
  public TestLargest(String name) {
    super(name);
  }

  public void testOrder() {
    assertEquals(9, Largest.largest(new int[] { 8, 9, 7 }));
  }
  
  public void testOrder2() {
	    int[] arr = new int[3];
	    arr[0] = 8;
	    arr[1] = 9;
	    arr[2] = 7;
	    assertEquals(9, Largest.largest(arr));
	  }


}
