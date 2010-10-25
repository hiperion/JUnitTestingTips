package com.example.collection;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import org.junit.Test;

public class TestSort {

	@Test
	public void testSort1() {
		ArrayList<User> lista = new ArrayList<User>();
		lista.add(new User("one", 11));
		lista.add(new User("two", 2));
		lista.add(new User("three", 3));
		lista.add(new User("four", 44));

		Collections.sort(lista, new NameComparator());

	}

	@Test
	public void testSort2() {
		Collator esCollator = Collator.getInstance(new Locale("es", "ES", "EURO"));
		 
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("one");
		lista.add("two");
		lista.add("three");
		lista.add("four");
		
		Collections.sort(lista,esCollator);
		 
		

	}
}
