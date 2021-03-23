// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
// You have to rotate the image in-place, which means you have to modify the input 2D matrix 
// directly. DO NOT allocate another 2D matrix and do the rotation.

public class RotateImage {
  public void rotate(int[][] matrix) {
    // Let's see some examples:
    // {{1,2,3},{4,5,6},{7,8,9}}
    // Number   |   prevIndex   |   afterIndex
    //   1      |   i=0, j=0    |   i=0, j=2
    //   2      |   i=0, j=1    |   i=1, j=2
    //   3      |   i=0, j=2    |   i=2, j=2
    //   4      |   i=1, j=0    |   i=0, j=1
    //   5      |   i=1, j=1    |   i=1, j=1
    //   6      |   i=1, j=2    |   i=2, j=1
    //   7      |   i=2, j=0    |   i=0, j=0
    //   8      |   i=2, j=1    |   i=1, j=0
    //   9      |   i=2, j=2    |   i=2, j=0
    // {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}
    // Number   |   prevIndex   |   afterIndex
    //   5      |   *i=0, j=0    |   i=0, j=3
    //   1      |   *i=0, j=1    |   i=1, j=3
    //   9      |   *i=0, j=2    |   i=2, j=3
    //  11      |   *i=0, j=3    |   i=3, j=3
    //   2      |   *i=1, j=0    |   i=0, j=2
    //   4      |   *i=1, j=1    |   i=1, j=2
    //   8      |   *i=1, j=2    |   i=2, j=2
    //  10      |   *i=1, j=3    |   i=3, j=2
    //  13      |   *i=2, j=0    |   i=0, j=1
    //   3      |   *i=2, j=1    |   i=1, j=1
    //   6      |   *i=2, j=2    |   i=2, j=1
    //   7      |   *i=2, j=3    |   i=3, j=1
    //  15      |   *i=3, j=0    |   i=0, j=0
    //  14      |   *i=3, j=1    |   i=1, j=0
    //  12      |   *i=3, j=2    |   i=2, j=0
    //  16      |   *i=3, j=3    |   i=3, j=0
    // We sse some patten here before and after the rotation:
    // 1) the i-index of a number becomes its j-index
    // 2) the j-index of a number becomes (length-i-1)
    
    // using two integers to track which position has been updated
    int n = matrix.length;
    int[] bitmaps = new int[n*n/32 + 1];
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        int currI = i;
        int currJ = j;
        int currVal = matrix[i][j];
        while (!cellMoved(currI + currJ * n, bitmaps)) {
          int newI = currJ;
          int newJ = n - currI - 1;
          int temp = matrix[newI][newJ];
          matrix[newI][newJ] = currVal;
          markCellMoved(currI + currJ * n, bitmaps);
          currI = newI;
          currJ = newJ;
          currVal = temp;
        }
      }
    }
  }

  private boolean cellMoved(int index, int[] bitmaps) {
    int bIndex = index / 32;
    int shift = index % 32;
    return (bitmaps[bIndex] & (1<<shift)) != 0;
  }

  private void markCellMoved(int index, int[] bitmaps) {
    int bIndex = index / 32;
    int shift = index % 32;
    bitmaps[bIndex] |= (1<<shift);
  }

  public static void Run() {
    RotateImage r = new RotateImage();
    //int[][] image = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    int[][] image = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
    r.rotate(image);
    for (int i=0; i<image.length; i++) {
      for (int j=0; j<image.length; j++) {
        System.out.print(image[i][j] + " ");
      }
      System.out.println();
    }
  }
}
