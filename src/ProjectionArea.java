// You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.
// Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).
// We view the projection of these cubes onto the xy, yz, and zx planes.
// A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane. We are viewing the "shadow" 
// when looking at the cubes from the top, the front, and the side.
// Return the total area of all three projections.

public class ProjectionArea {
  public int projectionArea(int[][] grid) {
    int result = 0;
    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid.length; j++) {
        if (grid[i][j] != 0) {
          result++;
        }
      }
    }

    int maxHeight = 0;
    for (int j=0; j<grid.length; j++) {
      for (int i=0; i<grid.length; i++) {
        maxHeight = Math.max(maxHeight, grid[i][j]);
      }
      result += maxHeight;
      maxHeight = 0;
    }

    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid.length; j++) {
        maxHeight = Math.max(maxHeight, grid[i][j]);
      }
      result += maxHeight;
      maxHeight = 0;
    }

    return result;
  }

  public static void Run() {
    ProjectionArea p = new ProjectionArea();
    int[][] grid = {{1,2},{3,4}};
    System.out.println(p.projectionArea(grid));

    grid = new int[][] {{2}};
    System.out.println(p.projectionArea(grid));

    grid = new int[][] {{1,0},{0,2}};
    System.out.println(p.projectionArea(grid));
  }
}
