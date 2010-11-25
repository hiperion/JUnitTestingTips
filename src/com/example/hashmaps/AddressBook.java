package com.example.hashmaps;

import java.util.*;
import java.io.*;
class AddressBook implements Serializable {
	
	private File filename = new File("Addressbook.bin");
	  private HashMap addressbook = new HashMap();
	  
	  public AddressBook() {
		    if(filename.exists())
		    try {
		      ObjectInputStream in = new ObjectInputStream(
		      new FileInputStream(filename));
		      addressbook = (HashMap)in.readObject();
		      in.close();

		    } catch(ClassNotFoundException e) {
		      System.out.println(e);

		    } catch(IOException e) {
		      System.out.println(e);
		    }
		  }

		  public void save() {
		    try {
		      System.out.println("Saving address book");
		      ObjectOutputStream out = new ObjectOutputStream(
		      new FileOutputStream(filename));
		      out.writeObject(addressbook);
		      out.close();

		    } catch(IOException e) {
		      System.out.println(e);
		    }
		  }

		}