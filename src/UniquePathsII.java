// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. The robot is trying to reach 
// the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// An obstacle and space is marked as 1 and 0 respectively in the grid.

public class UniquePathsII {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] DP = new int[m][n];
    boolean flag = false;
    for (int i=0; i<m; i++) {
      if (obstacleGrid[i][0] != 1 && !flag)
        DP[i][0] = 1;
      else {
        DP[i][0] = 0;
        flag = true;
      }
    }
    flag = false;
    for (int j=0; j<n; j++) {
      if (obstacleGrid[0][j] != 1 && !flag)
       DP[0][j] = 1;
      else {
        DP[0][j] = 0;
        flag = true;
      }
    }

    for (int i=1; i<m; i++) {
      for (int j=1; j<n; j++) {
        DP[i][j] = (obstacleGrid[i][j] == 1) ? 0 : DP[i-1][j] + DP[i][j-1];
      }
    }

    return DP[m-1][n-1];
  }

  public static void Run() {
    UniquePathsII u = new UniquePathsII();
    System.out.println(u.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    System.out.println(u.uniquePathsWithObstacles(new int[][]{{1,0}}));
  }
}
