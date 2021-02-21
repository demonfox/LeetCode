// Implement a first in first out (FIFO) queue using only two stacks. 
// The implemented queue should support all the functions of a normal 
// queue (push, peek, pop, and empty).

import java.util.*;

public class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!s2.empty()) {
            return s2.pop();
        } else {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if (!s2.empty()) {
            return s2.peek();
        } else {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }

    public static void Run() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
