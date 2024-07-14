// You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] 
// means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
// Count and return the number of maximum integers in the matrix after performing all the operations.

public class RangeAdditionII {
  public int maxCount(int m, int n, int[][] ops) {
    if (ops.length == 0) return m * n;

    int xMin, yMin;
    xMin = yMin = Integer.MAX_VALUE;

    for (int i=0; i<ops.length; i++) {
      // This works faster than the 2 lines commented out
      if (xMin != 1 && ops[i][0] < xMin)
        xMin = ops[i][0];
      if (yMin != 1 && ops[i][1] < yMin)
        yMin = ops[i][1];

      //xMin = Math.min(xMin, ops[i][0]);
      //yMin = Math.min(yMin, ops[i][1]);
    }

    return xMin * yMin;
  }

  public static void Run() {
    int[][] ops = {{2,2},{3,3}};
    RangeAdditionII test = new RangeAdditionII();
    System.out.println(test.maxCount(3, 3, ops));

    ops = new int[][]{{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}};
    System.out.println(test.maxCount(3, 3, ops));
  }
}
