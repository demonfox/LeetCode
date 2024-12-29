// Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
// To flip an image horizontally means that each row of the image is reversed.
// For example, flipping [1,1,0] horizontally results in [0,1,1].
// To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
// For example, inverting [0,1,1] results in [1,0,0].


public class FlipImage {
  public int[][] flipAndInvertImage(int[][] image) {
    for (int i=0; i<image.length; i++) {
      int j = 0;
      int k = image[0].length - 1;
      while (j < k) {
        int temp = image[i][j];
        image[i][j] = 1 - image[i][k];
        image[i][k] = 1 - temp;
        j++;
        k--;
      }
      if (j == k)
        image[i][j] = 1 - image[i][j];
    }
    return image;
  }

  public static void Run() {
    FlipImage f = new FlipImage();
    int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
    int[][] result = f.flipAndInvertImage(image);
    for (int i=0; i<result.length; i++) {
      for (int j=0; j<result[0].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }

    image = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
    result = f.flipAndInvertImage(image);
    for (int i=0; i<result.length; i++) {
      for (int j=0; j<result[0].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
  }
}
