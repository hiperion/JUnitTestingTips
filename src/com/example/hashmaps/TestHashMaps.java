package com.example.hashmaps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.TransformerUtils;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

import com.example.common.Principal;

//import org.apache.commons.collections.MultiMap;
//import org.apache.commons.collections.map.MultiValueMap;

public class TestHashMaps extends Principal {

	int j = 10;
	private HashMap theMap = new HashMap();
	HashMap myMap = new HashMap(121);
	HashMap aMap = new HashMap(121, 0.65f); // 65% load factor

	private static Logger log = Logger.getLogger(Class.class);

	@After
	public void tearDown() {
		// collection.clear();
	}

	@Test
	public void testEmptyCollection() {
		// assertTrue(collection.isEmpty());
	}

	@Before
	public void setUp() {
		// collection = new ArrayList();
	}

	@Test
	public void testHashMap1() {
		// Example of Creating a Java Hash Table
		// A hash table, or map, holds key/value pairs.
		// Create a hash table
		Map map = new HashMap(); // hash table
		map = new TreeMap(); // sorted map

		// Add key/value pairs to the map
		log.info("Add key/value pairs to the map");
		map.put("1", new Integer(1));
		map.put("2", new Integer(2));
		map.put("3", new Integer(3));

		// Get number of entries in map
		int size = map.size(); // 2

		// Adding an entry whose key exists in the map causes
		// the new value to replace the old value
		Object oldValue = map.put("a", new Integer(9)); // 1

		// Remove an entry from the map and return the value of the removed
		// entry
		oldValue = map.remove("c"); // 3

		// Iterate over the keys in the map
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			// Get key
			Object key = it.next();
		}

		// Iterate over the values in the map
		it = map.values().iterator();
		while (it.hasNext()) {
			// Get value
			Object value = it.next();
			// assertEquals(value, value);
		}

	}

	@Test
	public void testHashMapOrderOfInsertion() {
		// Creating a Map That Retains Order-of-Insertion() (Java HashMap
		// tutorial)
		Map map = new LinkedHashMap();

		// Add some elements
		map.put("1", "value1");
		map.put("2", "value2");
		map.put("3", "value3");
		map.put("2", "value4");

		// List the entries
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			Object key = it.next();
			Object value = map.get(key);
		}

	}

	@Test
	public void testHashMap2() {

		Map mapa = new HashMap();

		mapa.put("String", "String");

		Iterator it = mapa.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			log.info(e.getKey() + "llllllllllll " + e.getValue());
			assertEquals(1, 1);
		}

	}

	@Test
	public void testArray4() {
		Map nameToLetter = new HashMap();
		nameToLetter.put("ALPHA", "a");
		nameToLetter.put("BETA", "b");
		nameToLetter.put("GAMMA", "g");
		nameToLetter.put("DELTA", "d");

		String[] values = { "ALPHA", "BETA", "GAMMA", "GAMMA", "DELTA",
				"EPSILON" };
		List valueList = Arrays.asList(values);

		Collection resultCollection = CollectionUtils.collect(valueList,
				TransformerUtils.mapTransformer(nameToLetter));

		System.out.println(resultCollection);

		Map letterToName = MapUtils.invertMap(nameToLetter);

		resultCollection = CollectionUtils.collect(resultCollection,
				TransformerUtils.mapTransformer(letterToName));
		System.out.println(resultCollection);

		Map guardedMap = MapUtils.lazyMap(nameToLetter,
				FactoryUtils.exceptionFactory());
		CollectionUtils.collect(valueList,
				TransformerUtils.mapTransformer(guardedMap));

		Map guessingMap = MapUtils.lazyMap(nameToLetter, new Transformer() {
			public Object transform(Object o) {
				return ((String) o).substring(0, 1).toLowerCase();
			}
		});

		resultCollection = CollectionUtils.collect(valueList,
				TransformerUtils.mapTransformer(guessingMap));

		System.out.println(resultCollection);

	}

	@Test
	public void testArray5() {

	}

}
