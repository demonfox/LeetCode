// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
// return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or 
// vertically. You may assume all four edges of the grid are all surrounded by water.

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslands {
  class Pair {
    public int x;
    public int y;
    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  // FloodFill algorithm
  public int numIslands(char[][] grid) {
    int result = 0;
    int m = grid.length;
    int n = grid[0].length;

    Queue<Pair> q = new LinkedList<Pair>();
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j] != '0') {
          result++;
          q.add(new Pair(i, j));
          grid[i][j] = '0';
          while (!q.isEmpty()) {
            Pair p = q.poll();
            int[] dx = new int[]{1,-1,0,0};
            int[] dy = new int[]{0,0,1,-1};
            for (int k=0; k<4; k++) {
              int ni = p.x + dx[k];
              int nj = p.y + dy[k];
              if (ni >=0 && ni < m && nj >=0 && nj < n && grid[ni][nj] == '1') {
                q.add(new Pair(ni, nj));
                grid[ni][nj] = '0';
              }
            }
          }
        }
      }
    }

    return result;
  }

  // Using DisjointSet
  public int numIslands2(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    DisjointSet ds = new DisjointSet(m*n);
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j] == '1')
          ds.numOfSets++;
      }
    }

    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j] != '0') {
          for (int k=0; k<4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >=0 && ni < m && nj >=0 && nj < n && grid[ni][nj] == '1')
              ds.union(i*n+j, ni*n+nj);
          }
        }
      }
    }

    return ds.numOfSets;
  }

  public static void Run() {
    NumOfIslands n = new NumOfIslands();
    System.out.println(n.numIslands(new char[][]{{'1','1','1','1','0'},
                                                 {'1','1','0','1','0'},
                                                 {'1','1','0','0','0'},
                                                 {'0','0','0','0','0'}}));
    System.out.println(n.numIslands(new char[][]{{'1','1','0','0','0'},
                                                 {'1','1','0','0','0'},
                                                 {'0','0','1','0','0'},
                                                 {'0','0','0','1','1'}}));
    System.out.println(n.numIslands(new char[][]{{'1','1','1','0','0'},
                                                 {'0','1','1','0','0'},
                                                 {'1','1','1','0','0'},
                                                 {'0','0','0','0','0'}}));                                        
  }
}
