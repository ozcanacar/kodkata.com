package com.kodkata.kata.functional.squint.orig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Taker<T> {
  public List<T> take(int n, Iterator<T> xs) {
    List<T> taken = new ArrayList<T>();
    for (int i = 0; xs.hasNext() && i < n; i++)
      taken.add(xs.next());
    return taken;
    
    
    
    
    
  }
}

