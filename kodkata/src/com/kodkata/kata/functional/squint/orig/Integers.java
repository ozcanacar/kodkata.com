package com.kodkata.kata.functional.squint.orig;
import java.util.Iterator;

public class Integers implements Iterable<Integer> {
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      private int i = 1;

      public boolean hasNext() {return true;}
      public Integer next() {return i++;}
      public void remove() { }
    };
  }

  public static Iterator<Integer> get() {
    return new Integers().iterator();
  }
}