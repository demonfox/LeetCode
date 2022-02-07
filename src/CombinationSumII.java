// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in 
// candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javafx.util.Pair;

public class CombinationSumII {
  public List<List<Integer>> combinationSum3(int[] candidates, int target) {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> answer = new LinkedList<>();
    
    HashMap<Integer, Integer> counter = new HashMap<>();
    for (int candidate : candidates) {
      counter.put(candidate, counter.getOrDefault(candidate, 0) + 1);
    }

    // convert hashmap to a list so that we can enumerate it using its index
    List<Pair<Integer, Integer>> counterList = new ArrayList<>();
    counter.forEach((key, value) -> {
      counterList.add(new Pair<Integer, Integer>(key, value));
    });

    backtrack3(answer, target, 0, counterList, results);
    return results;
  }

  private void backtrack3(LinkedList<Integer> answer, int target, 
                        int currCandidate, List<Pair<Integer, Integer>> counter,
                        List<List<Integer>> results) {
    if (target < 0) return;
    if (target == 0) results.add(new ArrayList<Integer>(answer));

    for (int i=currCandidate; i<counter.size(); i++) {
      Pair<Integer, Integer> item = counter.get(i);
      int candidate = item.getKey();
      int count = item.getValue();
      if (count <= 0)
        continue;

      answer.addLast(candidate);
      counter.set(i, new Pair<Integer, Integer>(candidate, count - 1));

      backtrack3(answer, target - candidate, i, counter, results);

      //backtrack
      answer.removeLast();
      counter.set(i, new Pair<Integer, Integer>(candidate, count));
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> answer = new LinkedList<>();
    Arrays.sort(candidates);

    backtrack(answer, target, 0, candidates, results);
    return results;
  }

  private void backtrack(LinkedList<Integer> answer, int target, int currCandidate, int[] candidates, List<List<Integer>> results) {
    if (target == 0) results.add(new LinkedList<Integer>(answer));

    for (int i=currCandidate; i<candidates.length; i++) {
      // for consecutive identical numbers, calling "backtrack(..., i + 1, ...)" will cover those
      if (i > currCandidate && candidates[i] == candidates[i-1])
        continue;

      int candidate  = candidates[i];
      if (target < candidate)
        break;
      
      answer.addLast(candidate);
      backtrack(answer, target - candidate, i + 1, candidates, results);
      answer.removeLast();
    }
  }
  
  public static void Run() {
    CombinationSumII c = new CombinationSumII();
    List<List<Integer>> results = c.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    //List<List<Integer>> results = c.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    results.forEach(result -> {
      List<String> output = new ArrayList<String>();
      result.forEach(i -> {
        output.add(i.toString());
      });
      System.out.println(String.join(",", output));
    });
  }
}
