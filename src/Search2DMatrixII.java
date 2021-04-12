// Write an efficient algorithm that searches for a target value in an m x n integer matrix. 
// The matrix has the following properties:
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.

public class Search2DMatrixII {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length-1;
    int cols = matrix[0].length-1;

    int l = 0;
    int r = rows;
    int m;
    int ll = l;
    int lr = r;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (matrix[m][0] == target)
        return true;
      else if (matrix[m][0] < target) {
        ll = l;
        l = m + 1;
      } else {
        lr = r;
        r = m - 1;
      }
    }

    int rowIndexUpper = lr;
    for (m = ll; m <= lr; m++) {
      if (target < matrix[m][0]) {
        rowIndexUpper = Math.max(m - 1, 0);
        break;
      }
    }

    l = 0;
    r = rows;
    ll = l;
    lr = r;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (matrix[m][cols] == target)
        return true;
      else if (matrix[m][cols] < target) {
        ll = l;
        l = m + 1;
      } else {
        lr = r;
        r = m - 1;
      }
    }

    int rowIndexLower = ll;
    for (m=ll; m<=lr; m++) {
      if (target < matrix[m][cols]) {
        rowIndexLower = Math.max(m, rowIndexLower);
        break;
      }
    }

    for (int row = rowIndexLower; row <= rowIndexUpper; row++) {
      l = 0;
      r = cols;
      while (l <= r) {
        m = l + (r - l) / 2;
        if (matrix[row][m] == target)
          return true;
        else if (matrix[row][m] < target) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }
    }

    return false;
  }

  public boolean searchMatrix2(int[][] matrix, int target) {
    // start searching from lower left corner
    int rowIndex = matrix.length - 1;
    int colIndex = 0;
    while (rowIndex >= 0 && colIndex <= matrix[0].length - 1) {
      if (matrix[rowIndex][colIndex] == target)
        return true;
      if (matrix[rowIndex][colIndex] < target)
        colIndex++;
      else
        rowIndex--;
    }
    return false;
  }

  public static void Run() {
    Search2DMatrixII s = new Search2DMatrixII();
    int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
        { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
    System.out.println(s.searchMatrix(matrix, 5));
    System.out.println(s.searchMatrix2(matrix, 5));
    System.out.println(s.searchMatrix(matrix, 25));
    System.out.println(s.searchMatrix2(matrix, 25));
    System.out.println(s.searchMatrix(matrix, 26));
    System.out.println(s.searchMatrix2(matrix, 26));

    matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
        { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
    System.out.println(s.searchMatrix(matrix, 19));
    System.out.println(s.searchMatrix2(matrix, 19));

    matrix = new int[][] { { 1, 4 }, { 2, 5 } };
    System.out.println(s.searchMatrix(matrix, 5));
    System.out.println(s.searchMatrix2(matrix, 5));
  }
}
