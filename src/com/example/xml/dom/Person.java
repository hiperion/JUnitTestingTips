package com.example.xml.dom;


import org.jdom.*;

public class Person extends Element{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Person(int year) {
    super("author");
    addContent(new Element("name").setText("John Smith"));
    addContent(new Element("email").setText("john@smit.com"));
    addContent(new Element("age").setText(Integer.toString(year)));
  }
}
