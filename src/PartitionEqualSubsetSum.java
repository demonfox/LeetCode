// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of 
// the elements in both subsets is equal or false otherwise.

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 == 1) return false;
    Set<Integer> memoization = new HashSet<>();
    memoization.add(0);
    int target = sum / 2;
    for (int num : nums) {
      Set<Integer> newSet = new HashSet<>();
      for (Integer s : memoization) {
        if ((s + num) == target)
          return true;
        newSet.add(s + num);
        newSet.add(s);
      }
      memoization = newSet;
    }
    return false;
  }

  public static void Run() {
    PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
    int[] nums = {1, 5, 11, 5};
    System.out.println(p.canPartition(nums));
    nums = new int[] {1, 2, 3, 5};
    System.out.println(p.canPartition(nums));
    nums = new int[] {1, 2, 5};
    System.out.println(p.canPartition(nums));
    nums = new int[] {1, 2, 3, 4, 5, 6, 7};
    System.out.println(p.canPartition(nums));
  }
}
