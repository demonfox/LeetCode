// Given a 2D matrix matrix, handle multiple queries of the following type:
// Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) 
// and lower right corner (row2, col2).
// Implement the NumMatrix class:
// NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
// int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the 
// rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
// You must design an algorithm where sumRegion works on O(1) time complexity.

public class NumMatrix {
  int[][] sumMatrix;
  public NumMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    sumMatrix = new int[m][];
    for (int i=0; i<matrix.length; i++) {
      sumMatrix[i] = new int[n];
    }
    sumMatrix[m-1][0] = matrix[m-1][0];
    for (int i=m-2; i>=0; i--)
      sumMatrix[i][0] = matrix[i][0] + sumMatrix[i+1][0];
    for (int j=1; j<n; j++)
      sumMatrix[m-1][j] = matrix[m-1][j] + sumMatrix[m-1][j-1];
    
    for (int i=m-2; i>=0; i--) {
      for (int j=1; j<n; j++) {
        sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j-1] + sumMatrix[i+1][j] - sumMatrix[i+1][j-1];
      }
    }
  }
  
  public int sumRegion(int row1, int col1, int row2, int col2) {
    int m = sumMatrix.length;
    int s1 = sumMatrix[row1][col2];
    int s2 = (col1 > 0) ? sumMatrix[row1][col1 - 1] : 0;
    int s3 = (row2 < m - 1) ? sumMatrix[row2 + 1][col2] : 0;
    int s4 = (col1 > 0 && row2 < m - 1) ? sumMatrix[row2 + 1][col1 - 1] : 0;
    return s1 - s2 - s3 + s4;
  }

  public static void Run() {
    int[][] matrix = {
      {3, 0, 1, 4, 2},
      {5, 6, 3, 2, 1},
      {1, 2, 0, 1, 5},
      {4, 1, 0, 1, 7}, 
      {1, 0, 3, 0, 5}
    };
    NumMatrix numMatrix = new NumMatrix(matrix);
    System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // -> 8
    System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // -> 11
    System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // -> 12

    matrix = new int[][] {
      {-4, -5}
    };
    numMatrix = new NumMatrix(matrix);
    System.out.println(numMatrix.sumRegion(0, 0, 0, 0)); // -> -4

    matrix = new int[][] {
      {1}, 
      {-7}
    };
    numMatrix = new NumMatrix(matrix);
    System.out.println(numMatrix.sumRegion(1, 0, 1, 0)); // -> 1

  }
}
