// Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int setColumnOneTo = 1;
    if (matrix[0][0] == 0) {
      setColumnOneTo = 0;
    } else {
      for (int j = 1; j < n; j++) {
        if (matrix[0][j] == 0) {
          matrix[0][0] = 0;
          break;
        }
      }
      for (int i=1; i<m; i++) {
        if (matrix[i][0] == 0) {
          setColumnOneTo = 0;
          break;
        }
      }
    }

    for (int i=1; i<m; i++) {
      for (int j=1; j<n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int j=1; j<n; j++) {
      if (matrix[0][j] == 0) {
        for (int i=1; i<m; i++)
          matrix[i][j] = 0;
      }
    }
    
    for (int i=0; i<m; i++) {
      if (matrix[i][0] == 0) {
        for (int j=1; j<n; j++)
          matrix[i][j] = 0;
      }
    }

    if (setColumnOneTo == 0) {
      for (int i=0; i<m; i++)
        matrix[i][0] = 0;
    }
  }

  private static void PrintMatrix(int[][] matrix) {
    for (int i=0; i<matrix.length; i++) {
      for (int j=0; j<matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }   
  }
  public static void Run() {
    SetMatrixZeroes s = new SetMatrixZeroes();
    int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    PrintMatrix(matrix);
    s.setZeroes(matrix);
    PrintMatrix(matrix);
  }
}
