// Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
// Return the maximum product you can get.

public class IntegerBreak {
  public int integerBreak(int n) {
    // Define a state transition function DP[i] as: the max integer break value of i
    // then DP[i] = max (DP[j] * DP[i-j]) for all j = 1 ... i-1
    // that is, you break i into 2 parts: j & i-j, and since DP[j] is the max integer break
    // for j and DP[i-j] is the max integer break for i-j, then the max of such products must be the value for DP[i]
    // Also notice that for some j or i-j, it's better not to break it further
    int[] DP = new int[n+1];
    DP[1] = 1;
    for (int i=2; i<=n; i++) {
      for (int j=1; j<i; j++) {
        DP[i] = Math.max(DP[i], Math.max(j, DP[j]) * Math.max(i-j, DP[i-j])); // Also notice that the expression here means we will at
                                                                              // least break i into 2 parts, fulfilling the k>=2 condition
      }
    }
    return DP[n];
  }

  public static void Run() {
    IntegerBreak ib = new IntegerBreak();
    System.out.println(ib.integerBreak(10));
  }
}
