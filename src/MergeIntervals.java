// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and 
// return an array of the non-overlapping intervals that cover all the intervals in the input.

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    ArrayList<int[]> result = new ArrayList<int[]>();
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
    int[] prevInterval = intervals[0];
    for (int i=1; i<intervals.length; i++) {
      int[] currInterval = intervals[i];
      if (prevInterval[1] < currInterval[0]) {
        // two adjacent intervals do not overlap
        result.add(prevInterval);
        prevInterval = currInterval;
      } else if (prevInterval[1] < currInterval[1]) {
        // two adjacent intervals overlaps
        prevInterval[1] = currInterval[1];
      } else {
        // two adjacent intervals overlaps and the first interval encompasses the second one
        // we just move on
      }
    }
 
    result.add(prevInterval);
    return result.toArray(new int[result.size()][]);
  }

  public static void Run() {
    MergeIntervals m = new MergeIntervals();
    int[][] r = m.merge(new int[][]{{3,3},{2,6},{8,10},{15,18}});
    for (int[] i : r) {
      System.out.print("[" + i[0] + "," + i[1] + "] ");
    }
    System.out.println();
    r = m.merge(new int[][]{{2,3},{5,5},{2,2},{3,4},{3,4}});
    for (int[] i : r) {
      System.out.print("[" + i[0] + "," + i[1] + "] ");
    }
    System.out.println();
  }
}
