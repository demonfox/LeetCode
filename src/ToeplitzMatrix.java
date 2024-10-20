// Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
// A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

public class ToeplitzMatrix {
  public boolean isToeplitzMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (i > 0 && j > 0) {
          if (matrix[i-1][j-1] != matrix[i][j])
            return false;
        }
        if (i < m-1 && j < n-1) {
          if (matrix[i+1][j+1] != matrix[i][j])
            return false;
        }
      }
    }
    return true;
  }

  public static void Run() {
    int[][] matrix = new int[][] {
      new int[] {1,2,3,4},
      new int[] {5,1,2,3},
      new int[] {9,5,1,2}
    };

    ToeplitzMatrix tm = new ToeplitzMatrix();
    System.out.println(tm.isToeplitzMatrix(matrix));

    matrix = new int[][] {
      new int[] {1,2},
      new int[] {2,2}
    };

    System.out.println(tm.isToeplitzMatrix(matrix));
  }
}
