// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

public class SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    int r0 = 0;
    int c0 = 0;
    int r1 = n-1;
    int c1 = n-1;
    int[][] result = new int[n][n];
    int num = 1;

    while (r0 <= r1 && c0 <= c1) {
      for (int c = c0; c <= c1; c++)
        result[r0][c] = num++;
      for (int r = r0 + 1; r <= r1; r++)
        result[r][c1] = num++;
      if (r0 < r1)
        for (int c = c1 - 1; c >= c0; c--)
          result[r1][c] = num++;
      if (c0 < c1)
        for (int r = r1 - 1; r >= r0 + 1; r--)
          result[r][c0] = num++;
      r0++;
      r1--;
      c0++;
      c1--;
    }
    return result;
  }

  public static void Run() {
    SpiralMatrixII s = new SpiralMatrixII();
    int[][] matrix = s.generateMatrix(1);
    for (int[] row : matrix) {
      for (int val : row) {
        System.out.print(String.format("%2d ", val));
      }
      System.out.println();
    }
  }
}
