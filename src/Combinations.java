// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// You may return the answer in any order.

import java.util.LinkedList;
import java.util.List;

public class Combinations {
  private List<List<Integer>> result = new LinkedList<List<Integer>>();

  public List<List<Integer>> combine(int n, int k) {
    int[] nums = new int[k];
    helper(0, 0, n, k, nums);
    return result;
  }

  private void helper(int start, int curr, int n, int k, int[] nums) {
    if (curr >= k) {
      List<Integer> newList = new LinkedList<Integer>();
      for (int i : nums)
        newList.add(i);
      result.add(newList);
      return;
    }

    for (int i=start; i<=n-(k-curr); i++) {
      nums[curr] = i+1; // since index starts at 0, but we are filling the result from 1 to n
      helper(i+1, curr+1, n, k, nums);
    }
  }

  public static void Run() {
    Combinations c = new Combinations();
    List<List<Integer>> r = c.combine(5, 3);
    for (List<Integer> l : r) {
      l.forEach(i -> System.out.print(i + " "));
      System.out.println();
    }
  }
}
