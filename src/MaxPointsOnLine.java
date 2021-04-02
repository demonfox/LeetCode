// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, 
// return the maximum number of points that lie on the same straight line.

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class MaxPointsOnLine {
  public int maxPoints(int[][] points) {
    int maxCount = 1;

    Map<Pair<Integer, Integer>, Integer> counter = new HashMap<Pair<Integer, Integer>, Integer>();

    for (int i=0; i<points.length; i++) {
      int duplicates = 0;
      int x1 = points[i][0];
      int y1 = points[i][1];
      for (int j=i+1; j<points.length; j++) {
        int x2 = points[j][0];
        int y2 = points[j][1];
        if (x1 == x2 && y1 == y2) {
          duplicates++;
        }
        else {
          Pair<Integer, Integer> pseudoSlope = calcPseudoSlope(x1, y1, x2, y2);
          int count = counter.getOrDefault(pseudoSlope, 1) + 1;
          counter.put(pseudoSlope, count);
          maxCount = Math.max(count+duplicates, maxCount);
        }
      }
      counter.clear();
    }
    
    return maxCount;
  }

  private Pair<Integer, Integer> calcPseudoSlope(int x1, int y1, int x2, int y2) {
    if (x1 == x2) {
      return new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MAX_VALUE);
    } else if (y1 == y2) {
      return new Pair<Integer, Integer>(0, 0);
    } else {
      int gcd = BigInteger.valueOf(x2-x1).gcd(BigInteger.valueOf(y2-y1)).intValue();
      int coord1 = (x2-x1) / gcd;
      int coord2 = (y2-y1) / gcd;
      if (coord1 < 0) {
        coord1 = -coord1;
        coord2 = -coord2;
      }
      return new Pair<Integer, Integer>(coord1, coord2);
    }
  }

  public static void Run() {
    MaxPointsOnLine m = new MaxPointsOnLine();
    int[][] points = new int[6][2];
    points[0][0] = 1;
    points[0][1] = 1;
    points[1][0] = 3;
    points[1][1] = 2;
    points[2][0] = 5;
    points[2][1] = 3;
    points[3][0] = 4;
    points[3][1] = 1;
    points[4][0] = 2;
    points[4][1] = 3;
    points[5][0] = 1;
    points[5][1] = 4;
    System.out.println(m.maxPoints(points));
  }
}
