import java.util.Arrays;

// Given an integer n, return the least number of perfect square numbers that sum to n.
// A perfect square is an integer that is the square of an integer; in other words, 
// it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect 
// squares while 3 and 11 are not.

public class PerfectSquares {
  //  3 = 1 + 1 + 1
  //  4 = 4
  //  5 = 4 + 1
  //  6 = 4 + 1 + 1
  //  7 = 4 + 1 + 1 + 1
  //  8 = 4 + 4
  //  9 = 9
  // 10 = 9 + 1
  // 11 = 9 + 1 + 1
  // 12 = 4 + 4 + 4
  // 13 = 9 + 4
  // 14 = 9 + 4 + 1
  public int numSquares(int n) {
    if (n <= 3)
      return n;

    int[] dp = new int[n+1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;

    for (int i=3; i<=n; i++) {
      int sqrt = (int)Math.sqrt(i);
      for (int j=sqrt; j>=1; j--) {
        dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
      }
    }

    return dp[n];
  }

  public static void Run() {
    PerfectSquares p = new PerfectSquares();
    System.out.println(p.numSquares(12));
    System.out.println(p.numSquares(13));
    System.out.println(p.numSquares(14));
    System.out.println(p.numSquares(25));
    System.out.println(p.numSquares(26));
    System.out.println(p.numSquares(27));
    System.out.println(p.numSquares(35));
    System.out.println(p.numSquares(36));
    System.out.println(p.numSquares(41));
    System.out.println(p.numSquares(100));
    System.out.println(p.numSquares(109));
  }
}
