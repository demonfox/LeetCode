// Given a triangle array, return the minimum path sum from top to bottom.
// For each step, you may move to an adjacent number of the row below. 
// More formally, if you are on index i on the current row, you may move 
// to either index i or index i + 1 on the next row.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    int m = triangle.size();
    int[] MPS = new int[m];

    for (int j=0; j<m; j++) {
       MPS[j] = triangle.get(m-1).get(j);
    }

    for (int i=m-2; i>=0; i--) {
      for (int j=0; j<triangle.get(i).size(); j++) {
        MPS[j] = Math.min(MPS[j], MPS[j+1]) + triangle.get(i).get(j);
      }
    }
    
    return MPS[0];
  }

  public static void Run() {
    Triangle t = new Triangle();
    List<List<Integer>> input = new ArrayList<List<Integer>>();
    input.add(Arrays.asList(2));
    input.add(Arrays.asList(3,4));
    input.add(Arrays.asList(6,5,7));
    input.add(Arrays.asList(4,1,8,3));
    System.out.println(t.minimumTotal(input));
  }
}
