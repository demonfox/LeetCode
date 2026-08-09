// Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.
// A boomerang is a set of three points that are all distinct and not in a straight line.

public class ValidBoomerang {
  public boolean isBoomerang(int[][] points) {
    int x1 = points[0][0], y1 = points[0][1], x2 = points[1][0], y2 = points[1][1], x3 = points[2][0], y3 = points[2][1];
    return (x3 - x2) * (y2 - y1) != (y3 - y2) * (x2 - x1);
  }

  public static void Run() {
    ValidBoomerang solution = new ValidBoomerang();

    int[][][] testCases = {
      {{1, 1}, {2, 3}, {3, 2}},       // non-collinear
      {{1, 1}, {2, 2}, {3, 3}},       // diagonal line
      {{0, 0}, {1, 0}, {2, 0}},       // horizontal line
      {{0, 0}, {0, 1}, {0, 2}},       // vertical line
      {{1, 1}, {1, 1}, {2, 3}},       // duplicate points
      {{-2, -1}, {0, 2}, {3, -2}}     // negative coordinates
    };
    boolean[] expected = {true, false, false, false, false, true};

    for (int i = 0; i < testCases.length; i++) {
      boolean actual = solution.isBoomerang(testCases[i]);
      if (actual != expected[i]) {
        throw new AssertionError(
          "Test case " + (i + 1) + " failed: expected " + expected[i] + ", got " + actual
        );
      }
    }

    System.out.println("ValidBoomerang: all " + testCases.length + " tests passed.");
  }
}
