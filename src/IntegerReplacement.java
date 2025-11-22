// Given a positive integer n, you can apply one of the following operations:
// If n is even, replace n with n / 2.
// If n is odd, replace n with either n + 1 or n - 1.
// Return the minimum number of operations needed for n to become 1.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class IntegerReplacement {
  public int integerReplacement1(int n) {
    // Define a state transition function DP[i] as follows:
    // DP[i] = 1 + DP[i/2] if i % 2 == 0
    // DP[i] = min(2 + DP[(i+1)/2], 1 + DP[i-1]) when i % 2 == 1
    // the reason for the i -> i+1 when i is odd case is that we do not know DP[i+1] just yet when calculating DP[i],
    // but we know i+1 is even, so we are going to do the i+1 -> (i+1)/2 for the next step so we lump these two steps
    // together for the DP[i] state transition
    if (n==1) return 0;
    if (n==2) return 1;

    int[] DP = new int[n+1];
    DP[1] = 0;
    DP[2] = 1;
    for (int i=3; i<=n; i++) {
      if (i % 2 == 0) {
        DP[i] = 1 + DP[i/2];
      } else {
        DP[i] = Math.min(2 + DP[(i+1)/2], 2 + DP[(i-1)/2]);
      }
    }
    return DP[n];
  }

  public int integerReplacement2(int n) {
    if (n == Integer.MAX_VALUE) return 32;
    Queue<Integer> q = new LinkedList<>();
    HashSet<Integer> seen = new HashSet<>();
    q.add(n);
    seen.add(n);
    int result = 0;
    while (!q.isEmpty()) {
      int len = q.size();
      for (int i = 0; i < len; i++) {
        int curr = q.poll();
        if (curr == 1)
          return result;

        if (curr % 2 == 1) {
          if (!seen.contains(curr + 1)) {
            q.add(curr + 1);
            seen.add(curr + 1);
          }
          if (!seen.contains(curr - 1)) {
            q.add(curr - 1);
            seen.add(curr - 1);
          }
        } else {
          if (!seen.contains(curr / 2)) {
            q.add(curr / 2);
            seen.add(curr / 2);
          }
        }
      }
      result++;
    }
    return result;
  }

  public int integerReplacement(int n) {
    if (n == 1) return 0;
    if (n == Integer.MAX_VALUE) return 32;
    int result = 0;
    if (n % 2 == 1)
        result = Math.min(integerReplacement(n+1)+1, integerReplacement(n-1)+1);
    else
        result = integerReplacement(n/2) + 1;
    return result;
  }

  public static void Run() {
    IntegerReplacement i = new IntegerReplacement();
    System.out.println(i.integerReplacement(8));
    System.out.println(i.integerReplacement(7));
  }
}
