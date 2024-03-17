// You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
// Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there 
// is exactly one island (i.e., one or more connected land cells).
// The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a 
// square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

public class IslandPerimeter {
  public int islandPerimeter(int[][] grid) {
    int totalLen = 0;
    int width = grid[0].length;
    int height = grid.length;
    for (int i=0; i<height; i++) {
      for (int j=0; j<width; j++) {
        if (grid[i][j] == 1) {
          // check left, top, right, bottom edge, in that order
          if (j == 0 || grid[i][j-1] == 0)
            totalLen++;
          if (i == 0 || grid[i-1][j] == 0)
            totalLen++;
          if (j == width - 1 || grid[i][j+1] == 0)
            totalLen++;
          if (i == height - 1 || grid[i+1][j] == 0)
            totalLen++;
        }
      }
    }
    return totalLen;
  }

  public static void Run() {
    IslandPerimeter i = new IslandPerimeter();
    int[][] grid = new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    System.out.println(i.islandPerimeter(grid));
    grid = new int[][] {{1}};
    System.out.println(i.islandPerimeter(grid));
    grid = new int[][] {{1,0}};
    System.out.println(i.islandPerimeter(grid));
  }
}
