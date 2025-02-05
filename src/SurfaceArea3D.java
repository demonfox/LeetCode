// You are given an n x n grid where you have placed some 1 x 1 x 1 cubes. Each value v = grid[i][j] represents a tower of v cubes 
// placed on top of cell (i, j).
// After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.
// Return the total surface area of the resulting shapes.
// Note: The bottom face of each shape counts toward its surface area.

public class SurfaceArea3D {
  public int surfaceArea(int[][] grid) {
    int result = 0;
    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[0].length; j++) {
        if (grid[i][j] != 0)
          result += 2; // the top and bottom tile
        if (i == 0) 
          result += grid[i][j];
        else
          result += Math.max(grid[i][j] - grid[i-1][j], 0);
        
        if (i == grid.length-1)
          result += grid[i][j];
        else
          result += Math.max(grid[i][j] - grid[i+1][j],0);
        
        if (j == 0)
          result += grid[i][j];
        else
          result += Math.max(grid[i][j] - grid[i][j-1], 0);

        if (j == grid[0].length-1)
          result += grid[i][j];
        else
          result += Math.max(grid[i][j] - grid[i][j+1],0);
      }
    }

    return result;
  }

  public static void Run() {
    SurfaceArea3D obj = new SurfaceArea3D();
    int[][] grid = {{1,2},{3,4}};
    System.out.println(obj.surfaceArea(grid));
    grid = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
    System.out.println(obj.surfaceArea(grid));
    grid = new int[][] {{2,2,2},{2,1,2},{2,2,2}};
    System.out.println(obj.surfaceArea(grid));
  }
}
