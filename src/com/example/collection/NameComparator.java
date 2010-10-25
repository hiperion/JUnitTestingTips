package com.example.collection;

import java.util.Comparator;

class NameComparator implements Comparator {

  public int compare(Object o1, Object o2) {
    User u1 = (User) o1;
    User u2 = (User) o2;
    return u1.getName().compareTo(u2.getName());
  }

  public boolean equals(Object o) {
    return this == o;
  }
}
