// Given a 2D integer array matrix, return the transpose of matrix.

// The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

public class TransposeMatrix {
  public int[][] transpose(int[][] matrix) {
    int[][] result = new int[matrix[0].length][matrix.length];
    for (int j=0; j<matrix[0].length; j++) {
      for (int i=0; i<matrix.length; i++) {
        result[j][i] = matrix[i][j];
      }
    }
    return result;
  }

  public static void Run() {
    TransposeMatrix tm = new TransposeMatrix();
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    int[][] result = tm.transpose(matrix);
    for (int i=0; i<result.length; i++) {
      for (int j=0; j<result[0].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
  }
}
