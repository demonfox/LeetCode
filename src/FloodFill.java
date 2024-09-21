// You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel 
// value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill 
// on the image starting from the pixel image[sr][sc].
// To perform a flood fill:
// Begin with the starting pixel and change its color to color.
// Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original 
// pixel, either horizontally or vertically) and shares the same color as the starting pixel.
// Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if 
// it matches the original color of the starting pixel.
// The process stops when there are no more adjacent pixels of the original color to update.
// Return the modified image after performing the flood fill.

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if (image[sr][sc] == color) return image;
    int oldColor = image[sr][sc];
    Queue<Pair<Integer, Integer>> q = new LinkedList<Pair<Integer, Integer>>();
    q.add(new Pair<Integer,Integer>(sr, sc));
    while(!q.isEmpty()) {
      Pair<Integer, Integer> curr = q.poll();
      int r = curr.getKey();
      int c = curr.getValue();
      image[r][c] = color;
      if (r > 0 && image[r-1][c] == oldColor)
        q.add(new Pair<Integer,Integer>(r-1, c));
      if (r < image.length-1 && image[r+1][c] == oldColor)
        q.add(new Pair<Integer,Integer>(r+1, c));
      if (c > 0 && image[r][c-1] == oldColor)
        q.add(new Pair<Integer,Integer>(r, c-1));
      if (c < image[0].length-1 && image[r][c+1] == oldColor)
        q.add(new Pair<Integer,Integer>(r, c+1));
    }
    return image;
  }

  public static void Run() {
    FloodFill f = new FloodFill();
    int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
    int[][] result = f.floodFill(image, 1, 1, 2);
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
  }
}
