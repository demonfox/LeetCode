// You are given a nested list of integers nestedList. Each element is either an integer or a list 
// whose elements may also be integers or other lists. Implement an iterator to flatten it.
// Implement the NestedIterator class:
// NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
// int next() Returns the next integer in the nested list.
// boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();
  
  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();
  
  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return empty list if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
  Stack<Iterator<NestedInteger>> iterStack = null;
  List<Integer> flattenedList = null;
  Iterator<Integer> flattenedListIter = null;

  public NestedIterator(List<NestedInteger> nestedList) {
    iterStack = new Stack<Iterator<NestedInteger>>();
    Iterator<NestedInteger> iter = nestedList.iterator();
    iterStack.push(iter);
    flattenedList = new LinkedList<Integer>();
    constructFlattenedList();
    flattenedListIter = flattenedList.iterator();
  }

  private void constructFlattenedList() {
    Iterator<NestedInteger> currIter = null;
    if (!iterStack.isEmpty()) {
      currIter = iterStack.pop();
    }
    
    while (null != currIter && currIter.hasNext()) {
      NestedInteger next = currIter.next();
      if (next.isInteger())
        flattenedList.add(next.getInteger());
      else {
        iterStack.push(next.getList().iterator());
        constructFlattenedList();
      }
    }
  }

  @Override
  public Integer next() {
    return flattenedListIter.next();
  }

  @Override
  public boolean hasNext() {
    return flattenedListIter.hasNext();
  }
}
