// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the 
// start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an 
// interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still 
// does not have any overlapping intervals (merge overlapping intervals if necessary).

//Return intervals after the insertion.

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new LinkedList<int[]>();

    int i = 0;
    boolean done = false;
    for (; i<intervals.length; i++) {
      if (done) {
        result.add(intervals[i]);
        continue;
      }
      if (newInterval[1] < intervals[i][0]) {
        result.add(newInterval);
        i--;
        done = true;
      } else if (newInterval[1] == intervals[i][0]) {
        result.add(new int[]{newInterval[0], intervals[i][1]});
        done = true;
      } else if (newInterval[1] <= intervals[i][1]) {
        result.add(new int[]{Math.min(intervals[i][0], newInterval[0]), intervals[i][1]});
        done = true;
      } else if (newInterval[0] > intervals[i][1]) { // newInterval[1] > intervals[i][1]
        result.add(intervals[i]);
      } else { // newInterval[0] <= intervals[i][1] && newInterval[1] > intervals[i][1]
        newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      }
    }

    if (!done) {
      result.add(newInterval);
      return (int[][])result.toArray(new int[0][]);
    }

    return (int[][])result.toArray(new int[0][]);
  }

  public static void Run() {
    InsertInterval in = new InsertInterval();
    List<int[]> l = new LinkedList<int[]>();
    l.add(new int[]{1,2});
    l.add(new int[]{3,5});
    l.add(new int[]{6,7});
    l.add(new int[]{8,10});
    l.add(new int[]{12,16});
    int[][] result = in.insert((int[][])l.toArray(new int[0][]), new int[]{4,8});
    System.out.print("[");
    for (int i=0; i<result.length; i++) {   
      System.out.print(String.format("[%d, %d],", result[i][0], result[i][1]));
    }
    System.out.println("]");
  }
}
