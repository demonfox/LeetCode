// Write an algorithm to determine if a number n is happy.
// A happy number is a number defined by the following process:
// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a 
// cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
// Return true if n is a happy number, and false if not.

import java.util.HashSet;

public class HappyNumber {
  public boolean isHappy(int n) {
    HashSet<Integer> sumOfSquares = new HashSet<Integer>();
    while (!sumOfSquares.contains(n)) {
      sumOfSquares.add(n);
      int nextN = 0;
      // calculate next n
      while (n != 0) {
        nextN += (n%10) * (n%10);
        n /= 10;
      }
      if (nextN == 1)
        return true;
      n = nextN;
    }
    return false;
  }

  public static void Run() {
    HappyNumber h = new HappyNumber();
    System.out.println(h.isHappy(1));
    System.out.println(h.isHappy(19));
    System.out.println(h.isHappy(2));
  }
}
