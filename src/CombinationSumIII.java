// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations 
// may be returned in any order.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> answer = new LinkedList<>();
    if (n > 45)
      return results;
    backtrack(answer, n, k, 1, results);
    return results;
  }

  private void backtrack(LinkedList<Integer> answer, int target, int numCount, int currNum, List<List<Integer>> results) {
    if (numCount < 0) return;
    if (target == 0 && numCount == 0) {
      results.add(new LinkedList<Integer>(answer));
      return;
    }

    for (int i=currNum; i<=9; i++) {
      if (target < i)
        break;
      
      answer.addLast(i);
      backtrack(answer, target - i, numCount - 1, i + 1, results);
      answer.removeLast();
    }
  }

  public static void Run() {
    CombinationSumIII cs = new CombinationSumIII();
    List<List<Integer>> results = cs.combinationSum3(3, 9);
    for (List<Integer> result : results) {
      for (Integer i : result)
        System.out.print(i + " ");
      System.out.println();
    }
  }
}
