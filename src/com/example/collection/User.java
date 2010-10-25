package com.example.collection;

public class User {

	  private String name;
	  private int age;

	  User(String name, int age) {
	    this.name = name;
	    this.age = age;
	  }

	  public String getName() {
	    return name;
	  }

	  public int getAge() {
	    return age;
	  }

	  public String toString() {
	    return name + " (" + age + ")";
	  }
	  
	  public int compareTo(Object o) {
		    User userA = (User) o;
		    //podemos hacer esto porque String implementa Comparable
		    return name.compareTo(userA.getName());
		  }

	  

	  
}
