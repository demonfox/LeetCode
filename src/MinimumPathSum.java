// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, 
// which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

public class MinimumPathSum {
  public int minPathSum(int[][] grid) {
    // define a state function DP[][j] as follows:
    // DP[i][j] - the cost of the minimum path from (0,0) to (i,j)
    // Observe:
    // DP[i][j] = min(DP[i-1][j], DP[i][j-1]) + grid[i][j]
    int m = grid.length;
    int n = grid[0].length;
    int[][] DP = new int[m][n];
    
    DP[0][0] = grid[0][0];
    for (int i=1; i<m; i++)
      DP[i][0] = DP[i-1][0] + grid[i][0];
    for (int j=1; j<n; j++)
      DP[0][j] = DP[0][j-1] + grid[0][j];
    for (int i=1; i<m; i++) {
      for (int j=1; j<n; j++) {
        DP[i][j] = Math.min(DP[i-1][j], DP[i][j-1]) + grid[i][j];
      }
    }
    return DP[m-1][n-1];
  }

  public static void Run() {
    MinimumPathSum m = new MinimumPathSum();
    System.out.println(m.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    System.out.println(m.minPathSum(new int[][]{{1,2,3},{4,5,6}}));
  }
}
