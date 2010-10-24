package com.example.basic;

import java.lang.reflect.Method;

import junit.framework.TestCase;
import junit.framework.TestSuite;

class TestFinder {

  @SuppressWarnings({ "rawtypes", "unchecked" })
public static void run(@SuppressWarnings("rawtypes") Class which, String[] args) {
    TestSuite suite = null;
    if (args.length != 0) {
      try {
        java.lang.reflect.Constructor ctor;
        ctor = which.getConstructor(new Class[] { String.class });
        suite = new TestSuite();
        for (int i = 0; i < args.length; i++) {
          suite.addTest((TestCase) ctor.newInstance(new Object[] { args[i] }));
        }
      } catch (Exception e) {
        System.err.println("Unable to instantiate " + which.getName() + ": " + e.getMessage());
        System.exit(1);
      }

    } else {
      try {
        Method suite_method = which.getMethod("suite", new Class[0]);
        suite = (TestSuite) suite_method.invoke(null, null);
      } catch (Exception e) {
        suite = new TestSuite(which);
      }
    }
    junit.textui.TestRunner.run(suite);
  }
}