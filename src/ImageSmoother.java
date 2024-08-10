// An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average 
// of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of 
// the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells 
// in the red smoother).
// Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on 
// each cell of it.

import java.util.Arrays;

public class ImageSmoother {
  public int[][] imageSmoother(int[][] img) {
    int m = img.length;
    int n = img[0].length;
    int[][] result = new int[m+2][n+2];

    for (int j=0; j<n+2; j++) {
      result[0][j] = 0;
      result[m+1][j] = 0;
    }
    for (int i=0; i<m+2; i++) {
      result[i][0] = 0;
      result[i][n+1] = 0;
    }

    for (int i = 0; i <= m-1; i++) {
      for (int j = 0; j <= n-1; j++) {
        result[i+1][j+1] = img[i][j];
      }
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        double sum = Math.floor((double)(result[i - 1][j - 1] + result[i - 1][j] + result[i - 1][j + 1]
                                                  + result[i][j - 1] + result[i][j] + result[i][j + 1] 
                                                  + result[i + 1][j - 1] + result[i + 1][j] + result[i + 1][j + 1]));
        int divisor = 9;
        if ((i == 1 && j == 1) || (i == 1 && j == n) || (i == m && j == 1) || (i == m && j == n)) {
          if (m == 1 && n == 1)
            divisor = 1;
          else if (m == 1)
            divisor = 2;
          else if (n == 1)
            divisor = 2;
          else
            divisor = 4;
        } else if (i == 1 || i == m || j == 1 || j == n) {
          if (m == 1 || n == 1)
            divisor = 3;
          else
            divisor = 6;
        }

        img[i-1][j-1] = (int)(sum / divisor);
      }
    }

    return img;
  }

  public static void Run() {
    ImageSmoother imageSmoother = new ImageSmoother();
    int[][] img = {{1,1,1},{1,0,1},{1,1,1}};
    int[][] result = imageSmoother.imageSmoother(img);
    System.out.println(Arrays.deepToString(result));

    img = new int[][]{{100,200,100},{200,50,200},{100,200,100}};
    result = imageSmoother.imageSmoother(img);
    System.out.println(Arrays.deepToString(result));

    img = new int[][] {{1}};
    result = imageSmoother.imageSmoother(img);
    System.out.println(Arrays.deepToString(result));

    img = new int[][]{{6, 9, 7}};
    result = imageSmoother.imageSmoother(img);
    System.out.println(Arrays.deepToString(result));
  }
}
