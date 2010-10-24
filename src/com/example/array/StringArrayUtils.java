package com.example.array;

import java.util.*;

/**
 * Class with utility methods for String Arrays
 * @author
 * @see 
 */
public class StringArrayUtils {
	
	// Class Attributes
	private java.util.Vector<String> elements;
	
	/**
	 * Constructor 
	 */
	public StringArrayUtils(String[] data){
		// We verified that the list has values
		if ((data == null) || (data.length == 0))
			throw new IllegalArgumentException();
		
		this.elements = new Vector<String>();
		for (String element : data){
			elements.addElement(element);
		}
	}
	
	/**
	 * @return Returns the string has more characters
	 */
	public String getMaxLength(){
		String max = "";
		
		for (String element : elements){
			if (element.length() > max.length()){
				max = element;
			}
		}
		
		return max;
	}
	
	/**
	 * @return Returns the total length of all chains
	 */
	public int getTotalLength(){
		int total = 0;
		
		for (String d : elements){
			total += d.length();
		}
		
		return total;	
	}
	
	/**
	 * @param searched Search string
	 * @return Returns the position of an element within the array
	 * @throws java.util.NoSuchElementException If the item does not exist in the list
	 */
	public int getIndexOf(String searched) throws java.util.NoSuchElementException {
		int pos = 0;
		
		// We note that the argument is valid
		if (searched == null){
			throw new IllegalArgumentException();
		}
		
		// We follow the information to find the item
		for (String d : elements){
			if (d.equals(searched)){
				return pos;
			}
			pos++;
		}
		
		// The element did not exist, throw exception
		throw new java.util.NoSuchElementException(searched);	
	}
}
