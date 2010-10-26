package com.example.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

//import org.apache.commons.collections.MultiMap;
//import org.apache.commons.collections.map.MultiValueMap;

public class TestArray {

	int j = 10;
	private Collection collection;

	@Rule
	public TestWatchman watchman = new TestWatchman() {
		public void starting(FrameworkMethod method) {
			log.info("Being run..." + method.getName());
		}
	};

	private static Logger log = Logger.getLogger(Class.class);
	
	@After
	public void tearDown() {
		collection.clear();
	}
	
	@Test
	public void testEmptyCollection() {
		assertTrue(collection.isEmpty());
	}

	@Before
	public void setUp() {
		collection = new ArrayList();
	}

	@Test
	public void testArray1() {
		List myList = new ArrayList();

		// Populate the ArrayList
		for (int i = 0; i < j; i++) {
			myList.add(i);
		}

		// Print the ArrayList
		for (int i = 0; i < myList.size(); i++) {
			assertEquals(i, myList.get(i));
			log.info("Element " + i + ": " + myList.get(i));
		}
	}

	@Test
	public void testArray2() {
		Integer k=0;
		List myList = new ArrayList();

		// Populate the ArrayList
		for (int i = 0; i < j; i++) {
			myList.add(Integer.toString(i));
		}

		// Print the ArrayList
		String temp = "";
		Iterator i = myList.iterator();
		while (i.hasNext()) {			
			temp = (String) i.next();
			assertEquals(k.toString() , temp);
			log.info("Element " + k + ": " + temp);
			k++;
		}
	}

	@Test
	public void testArray3() {
		List myList = new ArrayList();

		// Populate the ArrayList
		for (int i = 0; i < 6; i++) {
			myList.add(i);
		}

		// Print the ArrayList
		String temp = "";
		int index = 0;
		ListIterator i = myList.listIterator();
		while (i.hasNext()) {
			index = i.nextIndex();
			temp = (String) i.next();
			System.out.println("Element " + index + " :" + temp);
		}
	}

	@Test
	public void testArray4() {
		List myList = new LinkedList();

		// Populate the ArrayList
		for (int i = 0; i < 6; i++) {
			myList.add(i);
		}

		// Print the ArrayList
		String temp = "";
		Iterator i = myList.iterator();
		while (i.hasNext()) {
			temp = (String) i.next();
			System.out.println("Element: " + temp);
		}
	}

	@Test
	public void testArray5() {
		
		  HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		  MultiMap mvm = MultiValueMap.decorate(hm);
		  
		  mvm.put(1, 1); mvm.put(1, 2); mvm.put(2, 1); mvm.put(2, 3);
		  mvm.put(3, 1);
		  
		  System.out.println("MultiValueMap: " + mvm);
		  
		  for (Iterator iter = mvm.entrySet().iterator(); iter.hasNext(); ) {
		  Map.Entry entry = (Map.Entry)iter.next(); 
		  Integer key = (Integer)  entry.getKey(); 
		  System.out.format("Key: %d\n", key);
		  
		  Collection vals = (Collection) entry.getValue(); 
		  for (Iterator  valIter = vals.iterator(); valIter.hasNext(); ) 
		  { Integer num =  (Integer) valIter.next(); 
		    System.out.format("\tVal: %d\n", num); } 
		  }
		 
	}

	@Test
	public void testArray6() {/*
	String[] strings = new String[] { "A", "B", "C", "D", "E", "F" };
	List list = new ArrayList( Arrays.asList( strings ) );
	Iterator iterator = new ArrayListIterator( list, 3, 6 );
	while( iterator.hasNext( ) ) {
	        int index = iterator.nextIndex( );
	    String element = (String) iterator.next( );
	    System.out.println( "Element at " + index + ": " + element );
	}
	*/}
	
	
	@Test
	public void testArray7() {/*
	String[] strings = new String[] { "A", "B", "C", "D", "E", "F" };
	List list = new ArrayList( Arrays.asList( strings ) );
	// Iterate over all elements
	Iterator iterator1 = new ArrayListIterator( list );
	// Iterate over "C", "D", "E", "F"
	Iterator iterator2 = new ArrayListIterator( list, 2 );
	// Iterate over "B", "C", "D"
	Iterator iterator3 = new ArrayListIterator( list, 1, 4 );
	*/}
	
	@Test
	public void testArray8(){/*
		
		String[] strings = new String[] { "A", "B", "C", "D", "E", "F" };
		List list = new ArrayList( Arrays.asList( strings ) );
		System.out.println( "Original List: " + Arrays.toString( list.toArray( ) );
		ResettableIterator iterator = new ArrayListIterator( list, 2 );
		// Retrieve an Element from the List
		int index = iterator.nextIndex( );
		String element = (String) iterator.next( );
		System.out.println( "Element at " + index + ": " + element );
		// Set the Current Element
		iterator.set( "G" );
		System.out.println( "Modifying index: " + index + " to G");
		// Retrieve the Next Element from the List
		index = iterator.nextIndex( );
		element = (String) iterator.next( );
		System.out.println( "Element at " + index + ": " + element );
		// Set the Current Element
		iterator.set( "H" );
		System.out.println( "Modifying index: " + index + " to H");
		// Reset the Iterator (Go to beginning of iteration)
		iterator.reset( );
		System.out.println( "Reset" );
		index = iterator.nextIndex( );
		element = (String) iterator.next( );
		System.out.println( "Element at " + index + ": " + element );
		System.out.println( "Modified List: " + Arrays.toString( list.toArray( ) );
	*/}
	
	@Test
	public void testArray9(){
		 /*Map nameToLetter = new HashMap();
		    nameToLetter.put("ALPHA","a");
		    nameToLetter.put("BETA","b");
		    nameToLetter.put("GAMMA","g");
		    nameToLetter.put("DELTA","d");

		    String[] values = {"ALPHA","BETA","GAMMA","GAMMA","DELTA","EPSILON"};
		    List valueList = Arrays.asList(values);
		    
		    Collection resultCollection = CollectionUtils.collect
		    (
		      valueList,
		      TransformerUtils.mapTransformer(nameToLetter)
		    );

		    System.out.println(resultCollection);*/
	    
		
	}
	
	
		
}
