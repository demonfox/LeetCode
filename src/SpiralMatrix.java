// Given an m x n matrix, return all elements of the matrix in spiral order.

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    // Let's view the matrix from a layered perspective: from the outer-most
    // layer going inwards. The result is obviously formed by traversing through
    // each layer clockwise from the top-left corner (say (r0, c0)) to the
    // bottom-right corner (say (r1, c1)). And then we check for some conditions to 
    // see if there are two more edges (i.e. the bottom edge and the left edge) to go.
    int m = matrix.length;
    int n = matrix[0].length;
    int r0 = 0;
    int c0 = 0;
    int r1 = m - 1;
    int c1 = n - 1;
    List<Integer> result = new LinkedList<>();

    while (r0 <= r1 && c0 <= c1) {
      for (int c = c0; c <= c1; c++)
        result.add(matrix[r0][c]);
      for (int r = r0 + 1; r <= r1; r++)
        result.add(matrix[r][c1]);
      if (r0 < r1)
        for (int c = c1 - 1; c >= c0; c--)
          result.add(matrix[r1][c]);
      if (c0 < c1)
        for (int r = r1 - 1; r >= r0+1; r--)
          result.add(matrix[r][c0]);
      r0++;
      r1--;
      c0++;
      c1--;
    }

    return result;
  }

  public static void Run() {
    SpiralMatrix s = new SpiralMatrix();
    List<Integer> l = s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    l.forEach(i -> System.out.print(i + " "));
    System.out.println();
    l = s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    l.forEach(i -> System.out.print(i + " "));
  }
}
