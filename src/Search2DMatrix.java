public class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length - 1;
    int cols = matrix[0].length - 1;

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
    r = cols;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (matrix[rowIndexUpper][m] == target)
        return true;
      else if (matrix[rowIndexUpper][m] < target) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    return false;
  }

  public boolean searchMatrix2(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    int left = 0;
    int right = rows * cols - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int midVal = matrix[mid / cols][mid % cols];
      if (midVal == target)
        return true;
      else if (midVal < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

  public static void Run() {
    Search2DMatrix s = new Search2DMatrix();
    int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
    System.out.println(s.searchMatrix(matrix, 3));
    System.out.println(s.searchMatrix2(matrix, 3));
    System.out.println(s.searchMatrix(matrix, 13));
    System.out.println(s.searchMatrix2(matrix, 13));
  }
}
