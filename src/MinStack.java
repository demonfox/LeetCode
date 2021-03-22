// Design a stack that supports push, pop, top, and retrieving the minimum 
// element in constant time.
// Implement the MinStack class:
// MinStack() initializes the stack object.
// void push(val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
  private Stack<Integer> stack;
  private PriorityQueue<Integer> pqueue;

  /** initialize your data structure here. */
  public MinStack() {
    stack = new Stack<Integer>();
    pqueue = new PriorityQueue<Integer>();
  }
  
  public void push(int val) {
    stack.push(val);
    pqueue.add(val);   
  }
  
  public void pop() {
    Integer val = stack.pop();
    pqueue.remove(val);
  }
  
  public int top() {
    return stack.peek();
  }
  
  public int getMin() {
    return pqueue.peek();
  }

  public static void Run() {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}
