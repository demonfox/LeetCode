// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
  List<List<Integer>> result = new LinkedList<List<Integer>>();
  public List<List<Integer>> permuteUnique(int[] nums) {
    helper(nums, 0);
    return result;
  }

  private void helper(int[] nums, int start) {
    if (start == nums.length) {
      List<Integer> newList = new LinkedList<Integer>();
      for (int i : nums)
        newList.add(i);
      result.add(newList);
      return;
    }
    
    HashSet<Integer> set = new HashSet<>();

    for (int i=start; i<nums.length; i++) {
      // swap nums[start] and nums[i]
      if (set.contains(nums[i]))
        continue;
        
      set.add(nums[i]);
      int temp = nums[start];
      nums[start] = nums[i];
      nums[i] = temp;
      int[] numbers = Arrays.copyOf(nums, nums.length);
      helper(numbers, start+1);
    }
  }

  public static void Run() {
    PermutationsII p = new PermutationsII();
    List<List<Integer>> r = p.permuteUnique(new int[]{1,3,2});
    for (List<Integer> l : r) {
      l.forEach(i -> System.out.print(i + " "));
      System.out.println();
    }
  }
}
