// Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    // use one integer to save both the max width (leftward) and height (upward) at one grid like this:
    // counter[i][j] = width + 1000 * height
    // so for a grid == 1, the value of its corresponding counter is 1001
    int maxSquareSize = 0;
    int[][] counter = new int[matrix.length][matrix[0].length];
    for (int j=0; j<matrix[0].length; j++) {
      if (matrix[0][j] == '1') {
        maxSquareSize = 1;
        counter[0][j] = 1001;
      } else
        counter[0][j] = 0;
    }
    for (int i=0; i<matrix.length; i++) {
      if (matrix[i][0] == '1') {
        maxSquareSize = 1;
        counter[i][0] = 1001;
      } else
        counter[i][0] = 0;
    }

    for (int i=1; i<matrix.length; i++) {
      for (int j=1; j<matrix[0].length; j++) {
        if (matrix[i][j] == '0')
          counter[i][j] = 0;
        else {
          if (counter[i-1][j-1] == 0 || counter[i-1][j] == 0 || counter[i][j-1] == 0) {
            if (matrix[i][j] == '1') {
              counter[i][j] = 1001;
              maxSquareSize = Math.max(maxSquareSize, 1);
            }
          } else {
            int minWidth = Math.min(counter[i][j-1]%1000, counter[i-1][j-1]%1000);
            int minHeight = Math.min(counter[i-1][j]/1000, counter[i-1][j-1]/1000);
            counter[i][j] = (minWidth + 1) + (minHeight + 1) * 1000;
            int temp = Math.min(minWidth + 1, minHeight + 1);
            maxSquareSize = Math.max(maxSquareSize, temp * temp);
          }
        }
      }
    }

    // int maxSquareSize = 0;
    // for (int i=0; i<counter.length; i++) {
    //   for (int j=0; j<counter[0].length; j++) {
    //     int temp = Math.min(counter[i][j]%1000, counter[i][j]/1000);
    //     maxSquareSize = Math.max(maxSquareSize, temp * temp);
    //   }
    // }
    return maxSquareSize;
  }

  public static void Run() {
    MaximalSquare ms = new MaximalSquare();
    char[][] matrix = new char[][] {
      {'1','0','1','0','0'},
      {'1','0','1','1','1'},
      {'1','1','1','1','1'},
      {'1','0','0','1','0'}
    };
    System.out.println(ms.maximalSquare(matrix));

    matrix = new char[][] {
      {'0','1'},
      {'1','0'}
    };
    System.out.println(ms.maximalSquare(matrix));

    matrix = new char[][] {
      {'0'}
    };
    System.out.println(ms.maximalSquare(matrix));
  }
}
