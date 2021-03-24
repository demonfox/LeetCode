// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. The robot is trying to reach 
// the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// How many possible unique paths are there?

public class UniquePaths {
  public int uniquePaths2(int m, int n) {
    // The robot need to go down m-1 steps, and go right n-1 steps, so the answer is
    // C(m+n-2, m-1)
    // But this only works if result does not go overflow at some point, and it will since
    // the constraints we are given is: 1 <= m, n <= 100
    // 50! = 3.04140932E64, which is much more than a 64-bit long integer can hold
    int result = 1;
    int d1 = 0;
    int d2 = 0;
    for (int i=1; i<=m+n-2; i++) {
      result *= i;
      if (i == m-1)
        d1 = result;
      if (i == n-1)
        d2 = result;
    }
    return result / d1 / d2;
  }

  // use dynamic programming
  public int uniquePaths(int m, int n) {
    // define a state function DP[m][n] as follows:
    // DP[i][j] is the number of unique paths that go from (0,0) to (i,j)
    // Observe:
    // DP[i][j] = DP[i-1][j] + DP[i][j-1]
    // DP[0][j] = 1 (for the first row, the robot can only go right)
    // DP[i][0] = 1 (for the first column, the robot can only go down)
    int[][] DP = new int[m][n];
    for (int i=0; i<m; i++)
      DP[i][0] = 1;
    for (int j=0; j<n; j++)
      DP[0][j] = 1;
    for (int i=1; i<m; i++) {
      for (int j=1; j<n; j++) {
        DP[i][j] = DP[i-1][j] + DP[i][j-1];
      }
    }

    return DP[m-1][n-1];
  }

  public static void Run() {
    UniquePaths u = new UniquePaths();
    System.out.println(u.uniquePaths(3, 7));
    System.out.println(u.uniquePaths(3, 2));
    System.out.println(u.uniquePaths(7, 3));
    System.out.println(u.uniquePaths(3, 3));
    System.out.println(u.uniquePaths(10, 10));
  }
}
