package com.kodkata.kata.functional.squint.orig;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class squintTest {

  private Iterator<Integer> integers() {
    return Integers.get();
  }

  private Iterator<Integer> squaresOf(Iterator<Integer> xs) {
    Func<Integer> square = new Func<Integer>() {
      public Integer f(Integer x) {
        return x * x;
      }
    };
    return new Mapper<Integer>().map(square, xs);
  }

  private void assertNextValue(Iterator<Integer> list, int expectedValue) {
    assertTrue(list.hasNext());
    assertEquals(expectedValue, list.next().intValue());
  }

  private List<Integer> take(int n, Iterator<Integer> xs) {
    return new Taker<Integer>().take(n, xs);
  }

  @Test
  public void integersAreConsecutive() throws Exception {
    Iterator<Integer> ints = integers();
    assertNextValue(ints, 1);
    assertNextValue(ints, 2);
  }

  @Test
  public void mapCreatesNewIterator() throws Exception {
    Iterator<Integer> squares = squaresOf(integers());
    assertNextValue(squares, 1);
    assertNextValue(squares, 4);
  }

  @Test
  public void squaresOfIntegers() throws Exception {
    assertEquals(asList(1, 4, 9, 16, 25), squint(5));
  }

  private List<Integer> squint(int n) {
    return take(n, squaresOf(integers()));
  }

  @Test
  public void infinteIntegers() throws Exception {
    int counter = 1;
    for (int i : new Integers()) {
      assertEquals(counter++, i);
      if (i == 1000) {
        break;
      }
    }
  }
}