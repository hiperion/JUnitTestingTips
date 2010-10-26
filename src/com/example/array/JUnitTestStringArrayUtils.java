package com.example.array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

/**
 * Perform functional tests on the calculator class
 * @author
 * @see 
 */
public class JUnitTestStringArrayUtils {

	private static StringArrayUtils stringUtils;

	@Rule
	public TestWatchman watchman = new TestWatchman() {
		public void starting(FrameworkMethod method) {
			log.info("Being run..." + method.getName());
		}
	};

	private static Logger log = Logger.getLogger(Class.class);
	/**
  	 * Read from a file, the test data with which we will perform tests
	 */
	@BeforeClass
	public static void inicioClase() {
		// Reading the chains with which we will perform tests from a text file
		try {
			FileReader reader = new FileReader("string.txt");
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			Vector<String> velements = new Vector<String>();
			while (line != null) {
				velements.addElement(line);
				line = buffer.readLine();
			}

			// String Creation from the data read from the file
			String[] elements = new String[velements.size()];
			velements.copyInto(elements);

			JUnitTestStringArrayUtils.stringUtils = new StringArrayUtils(
					elements);

			// Resources freed
			velements.removeAllElements();
			reader.close();
		} catch (IOException ex) {
			// Never happen
		}

	}
	
	/**
	 * This approach would free the resources reserved in BeforeClass
	 */
	@AfterClass
	public static void finClase() {
		// It'll happen at the end.
	}

	/**
	 * This method is executed for each test before invoking the code of each test
	 */
	@Before
	public void testStart() {
		// Write an example.
	}

	/**
	 * This method is executed for each test after invoking the code of each test
	 */
	@After
	public void testEnd() {
		// Write an example.
	}

	/**
         * We found that if given a null as an argument
         * Class constructor throws an IllegalArgumentException	 
        */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void initTest() {
		new StringArrayUtils(null);
	}

	/**
	 * We verified that the longer the string string "Three"
	 */
	@Test
	public void getLengthTest() {
		Assert.assertEquals("Tres", JUnitTestStringArrayUtils.stringUtils.getMaxLength());
	}

	/**
	 * Test the method that returns the sum total of all chains
         * Stored calculations assume that the total size is a method
         * Critical due by 25 milliseconds
	 */
	@Test(timeout = 25)
	public void getTotalLengthTest() {
		Assert.assertEquals(10, JUnitTestStringArrayUtils.stringUtils.getTotalLength());
	}

	/**
         * Test the method that returns the position of a string.
         * Verify that if we pass null as argument throws
         * Right
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void getIndexOfTest() {
		JUnitTestStringArrayUtils.stringUtils.getIndexOf(null);
	}

	/**
         * Test the method that returns the position of a string verified
         * That if we pass a string as an argument there Releases
         * Correct exception
	 */
	@Test(expected = java.util.NoSuchElementException.class)
	public void getIndexOfTest2() {
		Assert.assertEquals(0, JUnitTestStringArrayUtils.stringUtils.getIndexOf("This item does not exist"));
	}

	/**
         * Test the method that returns the position of a string.
         * Verify that if we pass a string that returns the position exists	 
        */
	@Test
	public void getIndexOfTest3() {
		Assert.assertEquals(2, JUnitTestStringArrayUtils.stringUtils.getIndexOf("two"));
	}

	@Ignore("Test ignorated")
	@Test
	public void ignore() {
		// source code
		// ...
		// ...
	}

	/**
	 * @return To maintain compatibility with the tools to deal with earlier versions of JUnit
	 */
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(JUnitTestStringArrayUtils.class);
	}

	/**
	 * tests without backward compatibility, ie it requires Java 5 and installed JUnit4
	 */
	/*public static void main(String[] args) {
		JUnitCore.runClasses(JUnitTestStringArrayUtils.class);
	}*/
}

