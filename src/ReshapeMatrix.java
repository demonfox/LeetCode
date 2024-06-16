// In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one 
// with a different size r x c keeping its original data.
// You are given an m x n matrix mat and two integers r and c representing the number of rows and the 
// number of columns of the wanted reshaped matrix.
// The reshaped matrix should be filled with all the elements of the original matrix in the same 
// row-traversing order as they were.
// If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; 
// Otherwise, output the original matrix.


public class ReshapeMatrix {
  public int[][] matrixReshape(int[][] mat, int r, int c) {
    int m = mat.length;
    int n = mat[0].length;
    if (m * n != r * c) return mat;

    int[][] result = new int[r][c];

    int row, col;
    row = col = 0;

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        result[row][col] = mat[i][j];
        col++;
        if (col % c == 0) {
          row++;
          col = 0;
        }
      }
    }

    return result;
  }

  public static void Run() {
    // generate a test case with mat = [[1,2],[3,4]], r = 1, c = 4
    // and then print the result
    ReshapeMatrix rm = new ReshapeMatrix();
    int[][] mat = {{1,2},{3,4}};
    int r = 1;
    int c = 4;
    int[][] result = rm.matrixReshape(mat, r, c);
    for (int i=0; i<result.length; i++) {
      for (int j=0; j<result[0].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }


    // generate another test case with mat = [[1,2],[3,4]], r = 4, c = 1
    // then print the result
    int[][] mat2 = {{1,2},{3,4}};
    int r2 = 4;
    int c2 = 1;
    int[][] result2 = rm.matrixReshape(mat2, r2, c2);
    for (int i=0; i<result2.length; i++) {
      for (int j=0; j<result2[0].length; j++) {
        System.out.print(result2[i][j] + " ");
      }
      System.out.println();
    }


    // generate another test case with mat = [[1,2,3],[4,5,6]], r = 3, c = 2 and then print the result
    int[][] mat3 = {{1,2,3},{4,5,6}};
    int r3 = 3;
    int c3 = 2;
    int[][] result3 = rm.matrixReshape(mat3, r3, c3);
    for (int i=0; i<result3.length; i++) {
      for (int j=0; j<result3[0].length; j++) {
        System.out.print(result3[i][j] + " ");
      }
      System.out.println();
    }
  }
}
