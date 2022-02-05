// Given an array of distinct integers candidates and a target integer target, return a list of 
// all unique combinations of candidates where the chosen numbers sum to target. You may return 
// the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times. Two combinations 
// are unique if the frequency of at least one of the chosen numbers is different.
// It is guaranteed that the number of unique combinations that sum up to target is less than 150 
// combinations for the given input.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    LinkedList<Integer> currCombo = new LinkedList<Integer>();
    Arrays.sort(candidates);
    dfs(candidates, target, 0, currCombo, result);
    return result;
  }

  private void dfs(int[] candidates, int target, int sIndex, LinkedList<Integer> currCombo, List<List<Integer>> result) {
    if (target == 0) {
      List<Integer> newEntry = new LinkedList<Integer>();
      newEntry.addAll(currCombo);
      result.add(newEntry);
      return;
    }

    for (int i=sIndex; i<candidates.length; i++) {
      if (candidates[i] > target)
        return;
      currCombo.addLast(candidates[i]);
      dfs(candidates, target - candidates[i], i, currCombo, result);
      currCombo.removeLast();
    }
  }

  public static void Run() {
    CombinationSum c = new CombinationSum();
    List<List<Integer>> result = c.combinationSum(new int[]{2,3,6,7}, 7);
    result.forEach(l ->  System.out.println(Arrays.toString(l.toArray())));
    result = c.combinationSum(new int[]{2,3,5}, 8);
    result.forEach(l ->  System.out.println(Arrays.toString(l.toArray())));
    result = c.combinationSum(new int[]{1}, 1);
    result.forEach(l ->  System.out.println(Arrays.toString(l.toArray())));
    result = c.combinationSum(new int[]{2}, 1);
    result.forEach(l ->  System.out.println(Arrays.toString(l.toArray())));
  }
}
