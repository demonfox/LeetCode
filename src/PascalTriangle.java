// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    ArrayList<Integer> prevRow = new ArrayList<>();
    for (int i=1; i<=numRows; i++) {
      ArrayList<Integer> newRow = new ArrayList<>();
      newRow.add(1);
      for (int j=1; j<i-1; j++) {
        newRow.add(j, prevRow.get(j-1) + prevRow.get(j));
      }
      if (i>=2)
        newRow.add(1);
      result.add(newRow);
      prevRow = newRow;
    }
    return result;
  }

  public static void Run() {
    PascalTriangle p = new PascalTriangle();
    List<List<Integer>> result = p.generate(5);
    for (List<Integer> l : result) {
      l.forEach((s) -> System.out.print(s));
      System.out.println();
    }
  }
}
