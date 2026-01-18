// You are given an m x n grid where each cell can have one of three values:
// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

import java.util.*;

record Cell(int x, int y) {}

class RottingOranges {

  public int orangesRotting(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    Queue<Cell> queue = new ArrayDeque<>();
    Set<Cell> fresh = new HashSet<>();

    // Initialization
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new Cell(i, j));
        } else if (grid[i][j] == 1) {
          fresh.add(new Cell(i, j));
        }
      }
    }

    int minutes = 0;
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    // BFS
    while (!queue.isEmpty() && !fresh.isEmpty()) {
      int size = queue.size();
      boolean rottedThisRound = false;

      for (int i = 0; i < size; i++) {
        Cell cur = queue.poll();

        for (int[] d : dirs) {
          int nx = cur.x() + d[0];
          int ny = cur.y() + d[1];
          Cell next = new Cell(nx, ny);

          if (nx >= 0 && nx < rows &&
              ny >= 0 && ny < cols &&
              fresh.remove(next)) {

            queue.offer(next);
            rottedThisRound = true;
          }
        }
      }

      if (rottedThisRound)
        minutes++;
    }

    return fresh.isEmpty() ? minutes : -1;
  }

  public static void Run() {
    RottingOranges r = new RottingOranges();
    int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
    System.out.println(r.orangesRotting(grid));
  }
}
