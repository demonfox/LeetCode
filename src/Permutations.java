// Given an array nums of distinct integers, return all the possible permutations. 
// You can return the answer in any order.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
  List<List<Integer>> result = new LinkedList<List<Integer>>();
  public List<List<Integer>> permute(int[] nums) {
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
    
    for (int i=start; i<nums.length; i++) {
      // swap nums[start] and nums[i]
      int temp = nums[start];
      nums[start] = nums[i];
      nums[i] = temp;
      int[] numbers = Arrays.copyOf(nums, nums.length);
      helper(numbers, start+1);
    }
  }

  public static void Run() {
    Permutations p = new Permutations();
    List<List<Integer>> r = p.permute(new int[]{1,2,3});
    for (List<Integer> l : r) {
      l.forEach(i -> System.out.print(i + " "));
      System.out.println();
    }
  }
}
