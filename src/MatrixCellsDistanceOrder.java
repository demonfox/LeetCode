// You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the 
// cell with the coordinates (rCenter, cCenter).
// Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the 
// smallest distance to the largest distance. You may return the answer in any order that satisfies this condition.
// The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixCellsDistanceOrder {
  public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
    int[][] result = new int[rows * cols][2];
    HashSet<Integer> visited = new HashSet<>();
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{rCenter, cCenter});
    int i = 0;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    while (!q.isEmpty()) {
      int[] cell = q.poll();
      result[i][0] = cell[0];
      result[i][1] = cell[1];
      visited.add(100 * cell[0] + cell[1]);
      for (int j=0; j<4; j++) {
        int x = cell[0] + dx[j];
        int y = cell[1] + dy[j];
        if (x >=0 && x < rows && y>=0 && y < cols && !visited.contains(100 * x + y)) {
          q.add(new int[]{x, y});
          visited.add(100 * x + y);
        }
      }
      i++;
    }
    return result;
  }

  public static void Run() {
    MatrixCellsDistanceOrder m = new MatrixCellsDistanceOrder();
    int[][] result = m.allCellsDistOrder(1, 2, 0, 0);
    printResult(result);

    result = m.allCellsDistOrder(2, 2, 0, 1);
    printResult(result);

    result = m.allCellsDistOrder(2, 3, 1, 2);
    printResult(result);
  }
  private static void printResult(int[][] result) {
    for (int i=0; i<result.length; i++) {
      System.out.print("[" + result[i][0] + ", " + result[i][1] + "] ");
    }
    System.out.println();
  }
}
