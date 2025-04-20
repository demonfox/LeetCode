// Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext and 
// the next operations.
// Implement the PeekingIterator class:
// PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
// int next() Returns the next element in the array and moves the pointer to the next element.
// boolean hasNext() Returns true if there are still elements in the array.
// int peek() Returns the next element in the array without moving the pointer.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {
  Iterator<Integer> it;
  boolean lookAheadCache;
  Integer cache;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    it = iterator;
    lookAheadCache = false;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    if (!lookAheadCache) {
      cache = it.next();
      lookAheadCache = true;
    }
    return cache;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if (!lookAheadCache)
      return it.next();
    else {
      lookAheadCache = false;
      return cache;
    }
  }

  @Override
  public boolean hasNext() {
    return lookAheadCache || it.hasNext();
  }

  public static void Run() {
    PeekingIterator pi = new PeekingIterator(new ArrayList<>(List.of(1,2,3)).iterator());
    System.out.println(pi.peek());
    System.out.println(pi.peek());
    System.out.println(pi.next());
    System.out.println(pi.peek());
    System.out.println(pi.next());
    System.out.println(pi.next());
    System.out.println(pi.hasNext());
  }
}
