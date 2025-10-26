// You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:
// Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
// Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
// Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
// Given the integer n, return the last number that remains in arr.

import java.util.Stack;

public class EliminationGame {
  public int lastRemaining(int n) {
    int head = 1;
    int remain = n;
    boolean leftToRight = true;
    int step = 1;
    while (remain > 1) {
      if (leftToRight || remain % 2 == 1) 
        head += step;
      
        remain /= 2;
        step *= 2;
        leftToRight = !leftToRight;
    }
    return head;
  }
  
  public int lastRemaining1(int n) {
    if (n == 1) return 1;

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    for (int i=2; i<=n; i+=2)
      s1.push(i);
    
    while (true) {
      if (s2.empty()) {
        if (s1.size() == 1)
            return s1.pop();
        while (!s1.empty()) {
          s1.pop();
          if (!s1.empty())
            s2.push(s1.pop());
        }
      } else {
        if (s2.size() == 1)
            return s2.pop();
        while (!s2.empty()) {
          s2.pop();
          if (!s2.empty())
            s1.push(s2.pop());
        }
      }
    }
  }

  public static void Run() { 
    EliminationGame eliminationGame = new EliminationGame();
    System.out.println(eliminationGame.lastRemaining(12));
    System.out.println(eliminationGame.lastRemaining(9));
    System.out.println(eliminationGame.lastRemaining(3));
    System.out.println(eliminationGame.lastRemaining(1));
  }
}
