// Implement a last in first out (LIFO) stack using only two queues. 
/// The implemented stack should support all the functions of a normal queue 
// (push, top, pop, and empty).

import java.util.*;

public class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (q1.isEmpty()) {
            q1.add(x);
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        } else {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!q1.isEmpty())
            return q1.remove();
        else
            return q2.remove();
    }
    
    /** Get the top element. */
    public int top() {
        if (!q1.isEmpty())
            return q1.peek();
        else
            return q2.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void Run() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}
