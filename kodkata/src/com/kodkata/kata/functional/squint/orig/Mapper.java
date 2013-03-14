package com.kodkata.kata.functional.squint.orig;
import java.util.Iterator;

public class Mapper<T> {
  public Iterator<T> map(final Func<T> func, final Iterator<T> xs) {
    return new Iterator<T>() {

      public boolean hasNext() {
        return xs.hasNext();
      }

      public T next() {
        return func.f(xs.next());
      }

      public void remove() {
      }
    };
  }
}